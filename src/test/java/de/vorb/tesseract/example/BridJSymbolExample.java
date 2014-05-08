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
import de.vorb.tesseract.LibTess.TessPageIterator;
import de.vorb.tesseract.PageIteratorLevel;
import de.vorb.tesseract.LibTess.TessResultIterator;
import de.vorb.tesseract.PageSegMode;

public class BridJSymbolExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // provide the native library file
        BridJ.setNativeLibraryFile("tesseract", new File("libtesseract303.dll"));

        long start = System.currentTimeMillis();
        // create a reference to an execution handle
        final Pointer<TessBaseAPI> handle = LibTess.TessBaseAPICreate();

        // init LibTess with data path, language and OCR engine mode
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
                height,
                bytesPerPixel, bytesPerLine);

        // text recognition
        LibTess.TessBaseAPIRecognize(handle, Pointer.NULL);

        // get the result iterator
        final Pointer<TessResultIterator> resultIt =
                LibTess.TessBaseAPIGetIterator(handle);

        // get the page iterator
        final Pointer<TessPageIterator> pageIt =
                LibTess.TessResultIteratorGetPageIterator(resultIt);

        // iterating over symbols
        final PageIteratorLevel level = PageIteratorLevel.SYMBOL;

        final Pointer<Integer> left = Pointer.allocateInt();
        final Pointer<Integer> top = Pointer.allocateInt();
        final Pointer<Integer> right = Pointer.allocateInt();
        final Pointer<Integer> bottom = Pointer.allocateInt();

        do {
            if (LibTess.TessPageIteratorIsAtBeginningOf(pageIt,
                    PageIteratorLevel.BLOCK) == LibTess.TRUE) {
            } else if (LibTess.TessPageIteratorIsAtBeginningOf(pageIt,
                    PageIteratorLevel.TEXTLINE) == LibTess.TRUE) {
                System.out.print("\n\n");
            } else if (LibTess.TessPageIteratorIsAtBeginningOf(pageIt,
                    PageIteratorLevel.WORD) == LibTess.TRUE) {
                System.out.print('\n');
            }

            final String symbol = LibTess.TessResultIteratorGetUTF8Text(
                    resultIt,
                    level).getCString();

            LibTess.TessPageIteratorBoundingBox(pageIt, level, left, top,
                    right,
                    bottom);

            System.out.println("'" + symbol + "': (" + left.getInt() + ", "
                    + top.getInt() + ", " + right.getInt() + ", "
                    + bottom.getInt()
                    + ")");
        } while (LibTess.TessPageIteratorNext(pageIt, level) > 0); // next
                                                                   // symbol

        System.out.print("\n\n");

        // calculate the time
        System.out.println("time: " + (System.currentTimeMillis() - start)
                + "ms");

        // delete handle
        LibTess.TessBaseAPIDelete(handle);
    }
}
