package de.vorb.tesseract;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class PixColormap extends Structure {
    /** colormap table (array of RGBA_QUAD) */
    public Pointer array;
    /** of pix (1, 2, 4 or 8 bpp) */
    public int depth;
    /** number of color entries allocated */
    public int nalloc;
    /** number of color entries used */
    public int n;

    public PixColormap() {
        super();
    }

    protected List<?> getFieldOrder() {
        return Arrays.asList("array", "depth", "nalloc", "n");
    }

    public PixColormap(Pointer array, int depth, int nalloc, int n) {
        super();
        this.array = array;
        this.depth = depth;
        this.nalloc = nalloc;
        this.n = n;
    }

    public PixColormap(Pointer peer) {
        super(peer);
    }

    public static class ByReference extends PixColormap implements
            Structure.ByReference {

    };

    public static class ByValue extends PixColormap implements
            Structure.ByValue {

    };
}
