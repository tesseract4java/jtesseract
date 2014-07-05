package de.vorb.tesseract;

import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.CLong;
import org.bridj.ann.Field;

public class timeval extends StructObject {
    static {
        BridJ.register();
    }

    /** seconds */
    @CLong
    @Field(0)
    public long tv_sec() {
        return this.io.getCLongField(this, 0);
    }

    /** seconds */
    @CLong
    @Field(0)
    public timeval tv_sec(long tv_sec) {
        this.io.setCLongField(this, 0, tv_sec);
        return this;
    }

    /** and microseconds */
    @CLong
    @Field(1)
    public long tv_usec() {
        return this.io.getCLongField(this, 1);
    }

    /** and microseconds */
    @CLong
    @Field(1)
    public timeval tv_usec(long tv_usec) {
        this.io.setCLongField(this, 1, tv_usec);
        return this;
    }

    public timeval() {
        super();
    }

    public timeval(Pointer<timeval> pointer) {
        super(pointer);
    }
}
