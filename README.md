# BridJ bindings for Tesseract 3.03

**This library is no longer maintained! Consider using [javacpp-presets/tesseract instead][jcpp-tess].**

[jcpp-tess]: https://github.com/bytedeco/javacpp-presets/tree/master/tesseract

A Java library that can be used to access Tesseract's C API from Java through
BridJ. Therefore, this library provides interfaces that cover all of Tesseract's
C API. BridJ classes were generated automatically by using
[JNAerator](https://code.google.com/p/jnaerator/) on Tesseract's `capi.h`.

This library does only cover the C API. If you are looking for a more convenient
way to use Tesseract from Java, have a look at
[Tess4J](http://tess4j.sourceforge.net/).


## Get

Information on how to get binary releases, documentation and source
distributions of this software can be found on
[search.maven.org](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22de.vorb%22%20AND%20a%3A%22jtesseract%22).


## Usage example

The following lines show how to use this library to recognize text in a PNG
image file.

~~~ java
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

import de.vorb.tesseract.bridj.Tesseract;
import de.vorb.tesseract.bridj.Tesseract.TessBaseAPI;
import de.vorb.tesseract.bridj.OCREngineMode;
import de.vorb.tesseract.bridj.PageSegMode;

public class BridJExample {
  public static void main(String[] args) throws IOException {
    // provide the native library file
    BridJ.setNativeLibraryFile("tesseract", new File("libtesseract303.dll"));

    long start = System.currentTimeMillis();
    // create a reference to an execution handle
    final Pointer<TessBaseAPI> handle = Tesseract.TessBaseAPICreate();

    // init Tesseract with data path, language and OCR engine mode
    Tesseract.TessBaseAPIInit2(handle,
        Pointer.pointerToCString("E:\\Masterarbeit\\Ressourcen\\tessdata"),
        Pointer.pointerToCString("deu-frak"), OCREngineMode.DEFAULT);

    // set page segmentation mode
    Tesseract.TessBaseAPISetPageSegMode(handle, PageSegMode.AUTO);

    // read the image into memory
    final BufferedImage inputImage = ImageIO.read(new File("input.png"));

    // get the image data
    final DataBuffer imageBuffer = inputImage.getRaster().getDataBuffer();
    final byte[] imageData = ((DataBufferByte) imageBuffer).getData();

    // image properties
    final int width = inputImage.getWidth(), height = inputImage.getHeight();
    final int bitsPerPixel = inputImage.getColorModel().getPixelSize();
    final int bytesPerPixel = bitsPerPixel / 8;
    final int bytesPerLine = (int) Math.ceil(width * bitsPerPixel / 8.0);

    // set the image
    Tesseract.TessBaseAPISetImage(handle,
        Pointer.pointerToBytes(ByteBuffer.wrap(imageData)), width, height,
        bytesPerPixel, bytesPerLine);

    // get the text result
    final String txt = Tesseract.TessBaseAPIGetUTF8Text(handle).getCString();

    // print the result
    System.out.println(txt);

    // calculate the time
    System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");

    // delete handle
    Tesseract.TessBaseAPIDelete(handle);
  }
}
~~~

Other example files can be found at
[src/test/java/de/vorb/tesseract/example][1].

[1]: https://github.com/pvorb/jtesseract/tree/master/src/test/java/de/vorb/tesseract/example

