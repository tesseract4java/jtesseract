package de.vorb.tesseract;

import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Constructor;
import org.bridj.ann.Field;

public class INT_FEATURE_STRUCT extends StructObject {
    static {
        BridJ.register();
    }

    @Constructor(0)
    public INT_FEATURE_STRUCT() {
        super();
    }

    @Constructor(1)
    public INT_FEATURE_STRUCT(Pointer<FCOORD> pos, byte theta) {
        super((Void) null, 0, pos, theta);
    }

    @Constructor(2)
    public INT_FEATURE_STRUCT(int x, int y, int theta) {
        super((Void) null, 1, x, y, theta);
    }

    @Field(0)
    public int X() {
        return this.io.getByteField(this, 0) & 0xFF;
    }

    @Field(0)
    public INT_FEATURE_STRUCT X(int X) {
        this.io.setByteField(this, 0, (byte) X);
        return this;
    }

    @Field(1)
    public int Y() {
        return this.io.getByteField(this, 1) & 0xFF;
    }

    @Field(1)
    public INT_FEATURE_STRUCT Y(int Y) {
        this.io.setByteField(this, 1, (byte) Y);
        return this;
    }

    @Field(2)
    public int Theta() {
        return this.io.getByteField(this, 2) & 0xFF;
    }

    @Field(2)
    public INT_FEATURE_STRUCT Theta(int Theta) {
        this.io.setByteField(this, 2, (byte) Theta);
        return this;
    }

    @Field(3)
    public int CP_misses() {
        return this.io.getByteField(this, 3) & 0xFF;
    }

    @Field(3)
    public INT_FEATURE_STRUCT CP_misses(int CP_misses) {
        this.io.setByteField(this, 3, (byte) CP_misses);
        return this;
    }

    public native void print();
}
