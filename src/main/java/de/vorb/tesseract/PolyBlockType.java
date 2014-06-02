package de.vorb.tesseract;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

/**
 * Block type.
 * 
 * @author Paul Vorbach
 */
public enum PolyBlockType implements IntValuedEnum<PolyBlockType> {
    UNKNOWN(0),
    FLOWING_TEXT(1),
    HEADING_TEXT(2),
    PULLOUT_TEXT(3),
    EQUATION(4),
    INLINE_EQUATION(5),
    TABLE(6),
    VERTICAL_TEXT(7),
    CAPTION_TEXT(8),
    FLOWING_IMAGE(9),
    HEADING_IMAGE(10),
    PULLOUT_IMAGE(11),
    HORZ_LINE(12),
    VERT_LINE(13),
    NOISE(14),
    COUNT(15);

    PolyBlockType(long value) {
        this.value = value;
    }

    public final long value;

    public long value() {
        return this.value;
    }

    public Iterator<PolyBlockType> iterator() {
        return Collections.singleton(this).iterator();
    }

    public static IntValuedEnum<PolyBlockType> fromValue(int value) {
        return FlagSet.fromValue(value, values());
    }
}
