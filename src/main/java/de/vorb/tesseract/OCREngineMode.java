package de.vorb.tesseract;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;

/**
 * Mode of the OCR engine.
 * 
 * @author Paul Vorbach
 */
public enum OCREngineMode implements IntValuedEnum<OCREngineMode> {
    TESSERACT_ONLY(0),
    CUBE_ONLY(1),
    TESSERACT_CUBE_COMBINED(2),
    DEFAULT(3);

    OCREngineMode(long value) {
        this.value = value;
    }

    public final long value;

    public long value() {
        return this.value;
    }

    public Iterator<OCREngineMode> iterator() {
        return Collections.singleton(this).iterator();
    }

    public static IntValuedEnum<OCREngineMode> fromValue(int value) {
        return FlagSet.fromValue(value, values());
    }
}
