package de.vorb.tesseract.example;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.bridj.BridJ;
import org.bridj.Pointer;

import de.vorb.leptonica.Pix;
import de.vorb.leptonica.util.PixConversions;
import de.vorb.tesseract.LibTess;
import de.vorb.tesseract.LibTess.TessBaseAPI;
import de.vorb.tesseract.PageIteratorLevel;

public class PixConvExample {
    public static void main(String[] args) throws IOException {
        BridJ.setNativeLibraryFile("leptonica",
                Paths.get("liblept170.dll").toFile());
        BridJ.setNativeLibraryFile("tesseract",
                Paths.get("libtesseract303.dll").toFile());

        final Path datapath = Paths.get(System.getenv("TESSDATA_PREFIX")).resolve(
                "tessdata");

        final Pointer<TessBaseAPI> handle = LibTess.TessBaseAPICreate();

        final BufferedImage img = ImageIO.read(Paths.get("input.png").toFile());

        LibTess.TessBaseAPIInit3(handle,
                Pointer.pointerToCString(datapath.toString()),
                Pointer.pointerToCString("deu-frak"));

        final Pointer<Pix> ppix = PixConversions.img2pix(img);

        LibTess.TessBaseAPISetImage2(handle, ppix);
        LibTess.TessBaseAPIRecognize(handle, Pointer.NULL);

        final Pointer<LibTess.TessResultIterator> resultIt =
                LibTess.TessBaseAPIGetIterator(handle);
        final Pointer<LibTess.TessPageIterator> pageIterator =
                LibTess.TessResultIteratorGetPageIterator(resultIt);

        int i = 0;

        final Path dir = Paths.get("C:/Users/Paul/Desktop/symbols");
        Files.createDirectories(dir); // mkdir -p

        do {
            final Pointer<Pix> pix = LibTess.TessPageIteratorGetBinaryImage(
                    pageIterator, PageIteratorLevel.SYMBOL);
            final String s = LibTess.TessResultIteratorGetUTF8Text(resultIt,
                    PageIteratorLevel.SYMBOL).getCString();
            System.out.println(s);
            final BufferedImage bufferedImage = PixConversions.pix2img(pix);
            final Path out = dir.resolve(i++ + ".png");
            ImageIO.write(bufferedImage, "PNG", out.toFile());
        } while (LibTess.TessPageIteratorNext(pageIterator,
                PageIteratorLevel.SYMBOL) > 0);
    }
}
