package de.vorb.tesseract;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

/**
 * Page segmentation mode.
 * 
 * @author Paul Vorbach
 */
public enum PageSegMode implements IntValuedEnum<PageSegMode> {
    OSD_ONLY(0),
    AUTO_OSD(1),
    AUTO_ONLY(2),
    AUTO(3),
    SINGLE_COLUMN(4),
    SINGLE_BLOCK_VERT_TEXT(5),
    SINGLE_BLOCK(6),
    SINGLE_LINE(7),
    SINGLE_WORD(8),
    CIRCLE_WORD(9),
    SINGLE_CHAR(10),
    SPARSE_TEXT(11),
    SPARSE_TEXT_OSD(12),
    COUNT(13);

    PageSegMode(long value) {
        this.value = value;
    }

    public final long value;

    public long value() {
        return this.value;
    }

    public Iterator<PageSegMode> iterator() {
        return Collections.singleton(this).iterator();
    }

    public static IntValuedEnum<PageSegMode> fromValue(int value) {
        return FlagSet.fromValue(value, values());
    }
}
