package de.vorb.tesseract;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

/**
 * Writing direction.
 * 
 * @author Paul Vorbach
 */
public enum WritingDirection implements IntValuedEnum<WritingDirection> {
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    TOP_TO_BOTTOM(2);

    WritingDirection(long value) {
        this.value = value;
    }

    public final long value;

    public long value() {
        return this.value;
    }

    public Iterator<WritingDirection> iterator() {
        return Collections.singleton(this).iterator();
    }

    public static IntValuedEnum<WritingDirection> fromValue(int value) {
        return FlagSet.fromValue(value, values());
    }
}
