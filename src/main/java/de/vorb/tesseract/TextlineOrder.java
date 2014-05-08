package de.vorb.tesseract;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

/**
 * Textline order.
 * 
 * @author Paul Vorbach
 */
public enum TextlineOrder implements IntValuedEnum<TextlineOrder> {
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    TOP_TO_BOTTOM(2);

    TextlineOrder(long value) {
        this.value = value;
    }

    public final long value;

    public long value() {
        return this.value;
    }

    public Iterator<TextlineOrder> iterator() {
        return Collections.singleton(this).iterator();
    }

    public static IntValuedEnum<TextlineOrder> fromValue(int value) {
        return FlagSet.fromValue(value, values());
    }
}