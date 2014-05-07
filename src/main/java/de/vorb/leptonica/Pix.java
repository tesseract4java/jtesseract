package de.vorb.leptonica;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class Pix extends Structure {
    /** width in pixels */
    public int w;
    /** height in pixels */
    public int h;
    /** depth in bits (bpp) */
    public int d;
    /** number of samples per pixel */
    public int spp;
    /** 32-bit words/line */
    public int wpl;
    /** reference count (1 if no clones) */
    public int refcount;
    /** image res (ppi) in x direction */
    public int xres;
    /**
     * (use 0 if unknown)<br>
     * image res (ppi) in y direction
     */
    public int yres;
    /**
     * (use 0 if unknown)<br>
     * input file format, IFF_*
     */
    public int informat;
    /** special instructions for I/O, etc */
    public int special;
    /** text string associated with pix */
    public Pointer text;
    /** colormap (may be null) */
    public PixColormap.ByReference colormap;
    /** the image data */
    public Pointer data;

    public Pix() {
        super();
    }

    protected List<?> getFieldOrder() {
        return Arrays.asList("w", "h", "d", "spp", "wpl", "refcount",
                "xres",
                "yres", "informat", "special", "text", "colormap", "data");
    }

    public Pix(Pointer peer) {
        super(peer);
    }

    public static class ByReference extends Pix implements
            Structure.ByReference {

    };

    public static class ByValue extends Pix implements Structure.ByValue {

    };
}
