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
    TABLE(4),
    VERTICAL_TEXT(5),
    CAPTION_TEXT(6),
    FLOWING_IMAGE(7),
    HEADING_IMAGE(8),
    PULLOUT_IMAGE(9),
    HORZ_LINE(10),
    VERT_LINE(11),
    NOISE(12),
    COUNT(13);

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
