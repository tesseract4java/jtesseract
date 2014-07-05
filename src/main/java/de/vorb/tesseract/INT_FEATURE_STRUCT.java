package de.vorb.tesseract;

import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.ann.Constructor;
import org.bridj.ann.Field;
import org.bridj.cpp.CPPObject;

public class INT_FEATURE_STRUCT extends CPPObject {
    static {
        BridJ.register();
    }

    @Constructor(0)
    public INT_FEATURE_STRUCT(Pointer<FCOORD> pos, byte theta) {
        super((Void) null, 0, pos, theta);
    }

    @Constructor(1)
    public INT_FEATURE_STRUCT(int x, int y, int theta) {
        super((Void) null, 1, x, y, theta);
    }

    @Field(0)
    public byte X() {
        return this.io.getByteField(this, 0);
    }

    @Field(0)
    public INT_FEATURE_STRUCT X(byte X) {
        this.io.setByteField(this, 0, X);
        return this;
    }

    @Field(1)
    public byte Y() {
        return this.io.getByteField(this, 1);
    }

    @Field(1)
    public INT_FEATURE_STRUCT Y(byte Y) {
        this.io.setByteField(this, 1, Y);
        return this;
    }

    @Field(2)
    public byte Theta() {
        return this.io.getByteField(this, 2);
    }

    @Field(2)
    public INT_FEATURE_STRUCT Theta(byte Theta) {
        this.io.setByteField(this, 2, Theta);
        return this;
    }

    @Field(3)
    public byte CP_misses() {
        return this.io.getByteField(this, 3);
    }

    @Field(3)
    public INT_FEATURE_STRUCT CP_misses(byte CP_misses) {
        this.io.setByteField(this, 3, CP_misses);
        return this;
    }

    public native void print();

    public INT_FEATURE_STRUCT() {
        super();
    }

    public INT_FEATURE_STRUCT(Pointer<INT_FEATURE_STRUCT> pointer) {
        super(pointer);
    }
}
