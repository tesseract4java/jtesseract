package de.vorb.tesseract;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;

public class SizeT extends IntegerType {
    private static final long serialVersionUID = 1L;

    public SizeT() {
        this(0);
    }

    public SizeT(long value) {
        super(Native.SIZE_T_SIZE, value);
    }
}
