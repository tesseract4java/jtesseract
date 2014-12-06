package de.vorb.tesseract.example;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.bridj.BridJ;
import org.bridj.Pointer;

import de.vorb.leptonica.LibLept;
import de.vorb.leptonica.Pix;
import de.vorb.tesseract.INT_FEATURE_STRUCT;
import de.vorb.tesseract.LibTess;
import de.vorb.tesseract.LibTess.TessBaseAPI;
import de.vorb.tesseract.LibTess.TessPageIterator;
import de.vorb.tesseract.LibTess.TessResultIterator;
import de.vorb.tesseract.OCREngineMode;
import de.vorb.tesseract.PageIteratorLevel;
import de.vorb.tesseract.PageSegMode;
import de.vorb.tesseract.TBLOB;

public class FeatureExample {
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

        // read image
        final Pointer<Pix> image =
                LibLept.pixRead(Pointer.pointerToCString("input.png"));

        // set the image
        LibTess.TessBaseAPISetImage2(handle, image);

        // text recognition
        LibTess.TessBaseAPIRecognize(handle, null);

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

        int symbols = 0;
        do {
            final Pointer<Pix> symbolImage = LibTess.TessPageIteratorGetImage(
                    pageIt, level, 1, image, left, top);

            LibLept.pixWrite(Pointer.pointerToCString("symbol.png"),
                    symbolImage,
                    LibLept.IFF_PNG);

            final Pointer<TBLOB> tblob = LibTess.TessMakeTBLOB(symbolImage);

            final Pointer<INT_FEATURE_STRUCT> features = Pointer.allocateArray(
                    INT_FEATURE_STRUCT.class, 512);
            final Pointer<Integer> numFeatures = Pointer.allocateInt();
            final Pointer<Integer> featOutlineIndex = Pointer.allocateInt();
            LibTess.TessBaseAPIGetFeaturesForBlob(handle, tblob, features,
                    numFeatures, featOutlineIndex);

            final BufferedImage featureImage = new BufferedImage(256, 256,
                    BufferedImage.TYPE_INT_RGB);
            final Graphics2D g2d = (Graphics2D) featureImage.createGraphics();

            final int numFeat = numFeatures.get();
            for (int i = 0; i < numFeat; i++) {
                final INT_FEATURE_STRUCT feature = features.get(i);
                final double angle = (feature.Theta() & 0xFF) / 128d * Math.PI
                        % (2 * Math.PI);
                System.out.println("feat: " + (feature.X() & 0xFF) + ", "
                        + (feature.Y() & 0xFF) + ", " + angle
                        + ", misses: " + feature.CP_misses());

                featureImage.setRGB(feature.X() & 0xFF,
                        256 - (feature.Y() & 0xFF),
                        Color.GREEN.getRGB());

            }

            g2d.dispose();
            JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(
                    featureImage)));

            Pointer.release(features, numFeatures, tblob, featOutlineIndex);

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
