package de.vorb.tesseract.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

import javax.imageio.ImageIO;

import org.bridj.BridJ;
import org.bridj.Pointer;

import de.vorb.leptonica.Pix;
import de.vorb.leptonica.util.PixConversions;
import de.vorb.tesseract.LibTess;
import de.vorb.tesseract.LibTess.TessBaseAPI;
import de.vorb.tesseract.LibTess.TessResultRenderer;
import de.vorb.tesseract.OCREngineMode;
import de.vorb.tesseract.PageSegMode;

public class BridJPDFExample {
    public static void main(String[] args) {
        // provide the native library file
        BridJ.setNativeLibraryFile("leptonica", new File("liblept170.dll"));
        BridJ.setNativeLibraryFile("tesseract", new File("libtesseract303.dll"));

        long start = System.currentTimeMillis();
        // create a reference to an execution handle
        final Pointer<TessBaseAPI> handle = LibTess.TessBaseAPICreate();

        final Pointer<Byte> datadir = Pointer.pointerToCString(Paths.get(
                System.getenv("TESSDATA_PREFIX")).resolve("tessdata").toString());

        // init Tesseract with data path, language and OCR engine mode
        LibTess.TessBaseAPIInit2(handle, datadir,
                Pointer.pointerToCString("deu-frak"), OCREngineMode.DEFAULT);

        // set page segmentation mode
        LibTess.TessBaseAPISetPageSegMode(handle,
                PageSegMode.AUTO);

        try {
            // read the image into memory
            final BufferedImage img = ImageIO.read(new File("input.png"));
            final Pointer<Pix> pix = PixConversions.img2pix(img);

            // set the image
            LibTess.TessBaseAPISetImage2(handle, pix);

            // enable pdf export
            LibTess.TessBaseAPISetVariable(handle,
                    Pointer.pointerToCString("tessedit_create_pdf"),
                    Pointer.pointerToCString("T"));

            // pdf creation
            final Pointer<TessResultRenderer> pdfRenderer =
                    LibTess.TessPDFRendererCreate(datadir);
            LibTess.TessResultRendererBeginDocument(pdfRenderer,
                    Pointer.pointerToCString("document"));
            LibTess.TessResultRendererAddImage(pdfRenderer, handle);
            LibTess.TessResultRendererEndDocument(pdfRenderer);

            // process the page
            LibTess.TessBaseAPIProcessPages1(handle,
                    Pointer.pointerToCString("input2.png"), Pointer.NULL, 0,
                    pdfRenderer);

            // get the pdf data
            final Pointer<Pointer<Byte>> data = Pointer.allocateBytes(1,
                    1024L * 1024L * 10L); // reserve 10M
            final Pointer<Integer> data_len = Pointer.allocateInt();
            LibTess.TessResultRendererGetOutput(pdfRenderer, data,
                    data_len);

            final ByteBuffer dataBuf = data.getPointerAtIndex(0).getByteBuffer(
                    data_len.getInt());

            // write to file
            try (final SeekableByteChannel out = Files.newByteChannel(
                    Paths.get("out.pdf"),
                    EnumSet.of(StandardOpenOption.WRITE,
                            StandardOpenOption.TRUNCATE_EXISTING))) {
                out.write(dataBuf);
            } catch (IOException e) {
                System.err.println("Could not write PDF output.");
            }

            // calculate the time
            System.out.println("time: " + (System.currentTimeMillis() - start)
                    + "ms");

            LibTess.TessBaseAPIEnd(handle);

            // delete handle
            LibTess.TessBaseAPIDelete(handle);
        } catch (IOException e) {
            System.err.println("Could not read input image.");
        }
    }
}
