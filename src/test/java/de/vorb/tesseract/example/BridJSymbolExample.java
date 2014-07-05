package de.vorb.tesseract.example;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.bridj.BridJ;
import org.bridj.Pointer;

import de.vorb.tesseract.ETEXT_DESC;
import de.vorb.tesseract.ETEXT_DESC.CANCEL_FUNC;
import de.vorb.tesseract.LibTess;
import de.vorb.tesseract.LibTess.TessBaseAPI;
import de.vorb.tesseract.LibTess.TessPageIterator;
import de.vorb.tesseract.LibTess.TessResultIterator;
import de.vorb.tesseract.OCREngineMode;
import de.vorb.tesseract.PageIteratorLevel;
import de.vorb.tesseract.PageSegMode;

public class BridJSymbolExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        // provide the native library file
        BridJ.setNativeLibraryFile("leptonica",
                Paths.get("liblept170.dll").toFile());
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
                height, bytesPerPixel, bytesPerLine);

        final ETEXT_DESC monitor = new ETEXT_DESC();
        // monitor.cancel(Pointer.<CANCEL_FUNC> pointerTo(new CANCEL_FUNC() {
        // @Override
        // public boolean apply(Pointer<?> cancel_this, int words) {
        // return true;
        // }
        // }));
        //
        new Thread() {
            public void run() {
                try {
                    while (true) {
                        System.err.println(monitor.ocr_alive());
                        System.err.println("progress: " + monitor.progress());

                        if (monitor.progress() >= 100) {
                            break;
                        }

                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            };
        }.start();

        // text recognition
        LibTess.TessBaseAPIRecognize(handle, Pointer.pointerTo(monitor));

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

        int symbols = 0;
        do {
            if (LibTess.TessPageIteratorIsAtBeginningOf(pageIt,
                    PageIteratorLevel.BLOCK) == LibTess.TRUE) {
            } else if (LibTess.TessPageIteratorIsAtBeginningOf(pageIt,
                    PageIteratorLevel.TEXTLINE) == LibTess.TRUE) {
                // System.out.print("\n\n");
            } else if (LibTess.TessPageIteratorIsAtBeginningOf(pageIt,
                    PageIteratorLevel.WORD) == LibTess.TRUE) {
                // System.out.print('\n');
            }

            symbols++;

            final String symbol = LibTess.TessResultIteratorGetUTF8Text(
                    resultIt, level).getCString();

            LibTess.TessPageIteratorBoundingBox(pageIt, level, left, top,
                    right,
                    bottom);

            System.out.println("'" + symbol + "': (" + left.getInt() + ", "
                    + top.getInt() + ", " + right.getInt() + ", "
                    + bottom.getInt() + ")");
        } while (LibTess.TessPageIteratorNext(pageIt, level) > 0); // next
                                                                   // symbol

        System.out.print(symbols + "\n\n");

        // calculate the time
        System.out.println("time: " + (System.currentTimeMillis() - start)
                + "ms");

        // delete handle
        LibTess.TessBaseAPIDelete(handle);
    }
}
