package de.vorb.tesseract;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

/**
 * PageIterator level.
 * 
 * @author Paul Vorbach
 */
public enum PageIteratorLevel implements
        IntValuedEnum<PageIteratorLevel> {
    BLOCK(0),
    PARA(1),
    TEXTLINE(2),
    WORD(3),
    SYMBOL(4);

    PageIteratorLevel(long value) {
        this.value = value;
    }

    public final long value;

    public long value() {
        return this.value;
    }

    public Iterator<PageIteratorLevel> iterator() {
        return Collections.singleton(this).iterator();
    }

    public static IntValuedEnum<PageIteratorLevel> fromValue(int value) {
        return FlagSet.fromValue(value, values());
    }
}
