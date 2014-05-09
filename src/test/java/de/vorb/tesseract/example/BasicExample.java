package de.vorb.tesseract.example;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.bridj.BridJ;
import org.bridj.Pointer;

import de.vorb.leptonica.LibLept;
import de.vorb.leptonica.Pix;
import de.vorb.leptonica.util.PixConversions;
import de.vorb.tesseract.LibTess;
import de.vorb.tesseract.LibTess.TessBaseAPI;

public class BasicExample {
    public static void main(String[] args) throws IOException {
        BridJ.setNativeLibraryFile("leptonica",
                Paths.get("liblept170.dll").toFile());
        BridJ.setNativeLibraryFile("tesseract",
                Paths.get("libtesseract303.dll").toFile());

        System.out.println("Tesseract version: "
                + LibTess.TessVersion().getCString());

        final Path datapath = Paths.get(System.getenv("TESSDATA_PREFIX")).resolve(
                "tessdata");

        final Pointer<TessBaseAPI> handle = LibTess.TessBaseAPICreate();

        final BufferedImage img = ImageIO.read(Paths.get("input.png").toFile());

        LibTess.TessBaseAPIInit3(handle,
                Pointer.pointerToCString(datapath.toString()),
                Pointer.pointerToCString("deu-frak"));

        final Pointer<Pix> ppix = PixConversions.img2pix(img);

        LibTess.TessBaseAPISetImage2(handle, ppix);

        Pointer<Byte> text = LibTess.TessBaseAPIGetUTF8Text(handle);
        System.out.println(text.getCString().length());
        LibTess.TessDeleteText(text);

        LibTess.TessBaseAPIEnd(handle);

        LibLept.pixDestroy(Pointer.pointerToPointer(ppix));

        LibTess.TessBaseAPIDelete(handle);

        System.out.println("bye");
    }
}
