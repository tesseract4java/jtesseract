package de.vorb.tesseract;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

/**
 * Orientation of the page.
 * 
 * @author Paul Vorbach
 */
public enum Orientation implements IntValuedEnum<Orientation> {
    PAGE_UP(0),
    PAGE_RIGHT(1),
    PAGE_DOWN(2),
    PAGE_LEFT(3);

    Orientation(long value) {
        this.value = value;
    }

    public final long value;

    public long value() {
        return this.value;
    }

    public Iterator<Orientation> iterator() {
        return Collections.singleton(this).iterator();
    }

    public static IntValuedEnum<Orientation> fromValue(int value) {
        return FlagSet.fromValue(value, values());
    }
}
