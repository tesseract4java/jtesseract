package de.vorb.tesseract.example;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.bridj.BridJ;
import org.bridj.Pointer;

import de.vorb.tesseract.LibTess;
import de.vorb.tesseract.LibTess.TessBaseAPI;
import de.vorb.tesseract.OCREngineMode;
import de.vorb.tesseract.PageSegMode;

public class BridJExample {
    public static void main(String[] args) throws IOException {
        BridJ.setNativeLibraryFile("leptonica", new File("liblept170.dll"));
        BridJ.setNativeLibraryFile("tesseract", new File("libtesseract303.dll"));

        long start = System.currentTimeMillis();
        // create a reference to an execution handle
        final Pointer<TessBaseAPI> handle = LibTess.TessBaseAPICreate();

        // init TesseractLibrary with data path, language and OCR engine mode
        LibTess.TessBaseAPIInit2(
                handle,
                Pointer.pointerToCString("E:\\Masterarbeit\\Ressourcen\\tessdata"),
                Pointer.pointerToCString("deu-frak"),
                OCREngineMode.DEFAULT);

        // set page segmentation mode
        LibTess.TessBaseAPISetPageSegMode(handle, PageSegMode.AUTO);

        // read the image into memory
        final BufferedImage inputImage = ImageIO.read(new File("input.png"));

        // get the image data
        final DataBuffer imageBuffer = inputImage.getRaster().getDataBuffer();
        final byte[] imageData = ((DataBufferByte) imageBuffer).getData();

        // image properties
        final int width = inputImage.getWidth();
        final int height = inputImage.getHeight();
        final int bitsPerPixel = inputImage.getColorModel().getPixelSize();
        final int bytesPerPixel = bitsPerPixel / 8;
        final int bytesPerLine = (int) Math.ceil(width * bitsPerPixel / 8.0);

        // set the image
        LibTess.TessBaseAPISetImage(handle,
                Pointer.pointerToBytes(ByteBuffer.wrap(imageData)), width,
                height, bytesPerPixel, bytesPerLine);

        // get the text result
        final String txt = LibTess.TessBaseAPIGetUTF8Text(handle).getCString();

        // print the result
        System.out.println(txt);

        // calculate the time
        System.out.println("time: " + (System.currentTimeMillis() - start)
                + "ms");

        LibTess.TessBaseAPIEnd(handle);

        // delete handle
        LibTess.TessBaseAPIDelete(handle);
    }
}
