package de.vorb.tesseract.example;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
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

import de.vorb.tesseract.bridj.Tesseract;
import de.vorb.tesseract.bridj.Tesseract.TessBaseAPI;
import de.vorb.tesseract.bridj.Tesseract.TessOcrEngineMode;
import de.vorb.tesseract.bridj.Tesseract.TessResultRenderer;

public class BridJPDFExample {
  public static void main(String[] args) {
    // provide the native library file
    BridJ.setNativeLibraryFile("tesseract", new File("libtesseract303.dll"));

    long start = System.currentTimeMillis();
    // create a reference to an execution handle
    final Pointer<TessBaseAPI> handle = Tesseract.TessBaseAPICreate();

    // init Tesseract with data path, language and OCR engine mode
    Tesseract.TessBaseAPIInit2(handle,
        Pointer.pointerToCString("E:\\Masterarbeit\\Ressourcen\\tessdata"),
        Pointer.pointerToCString("deu-frak"), TessOcrEngineMode.OEM_DEFAULT);

    // set page segmentation mode
    Tesseract.TessBaseAPISetPageSegMode(handle,
        Tesseract.TessPageSegMode.PSM_AUTO);

    try {
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
      Tesseract.TessBaseAPISetImage(handle,
          Pointer.pointerToBytes(ByteBuffer.wrap(imageData)), width, height,
          bytesPerPixel, bytesPerLine);

      // enable pdf export
      Tesseract.TessBaseAPISetVariable(handle,
          Pointer.pointerToCString("tessedit_create_pdf"),
          Pointer.pointerToCString("T"));

      // get the text result
      final String txt = Tesseract.TessBaseAPIGetUTF8Text(handle).getCString();

      // pdf creation
      final Pointer<TessResultRenderer> pdfRenderer =
          Tesseract.TessPDFRendererCreate(Pointer.pointerToCString("E:\\Masterarbeit\\Ressourcen\\tessdata"));
      Tesseract.TessResultRendererBeginDocument(pdfRenderer,
          Pointer.pointerToCString("document"));
      Tesseract.TessResultRendererAddImage(pdfRenderer, handle);
      Tesseract.TessResultRendererEndDocument(pdfRenderer);

      // process the page
      Tesseract.TessBaseAPIProcessPages1(handle,
          Pointer.pointerToCString("input2.png"), Pointer.NULL, 0, pdfRenderer);

      // get the pdf data
      final Pointer<Pointer<Byte>> data = Pointer.allocateBytes(1, 0L);
      final Pointer<Integer> data_len = Pointer.allocateInt();
      Tesseract.TessResultRendererGetOutput(pdfRenderer, data, data_len);

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
      System.out.println("time: " + (System.currentTimeMillis() - start) + "ms");

      // delete handle
      Tesseract.TessBaseAPIDelete(handle);
    } catch (IOException e) {
      System.err.println("Coult not read input image.");
    }
  }
}
