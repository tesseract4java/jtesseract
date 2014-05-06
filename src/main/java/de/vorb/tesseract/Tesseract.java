package de.vorb.tesseract;

import java.util.Collections;
import java.util.Iterator;
import org.bridj.BridJ;
import org.bridj.CRuntime;
import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.ann.Name;
import org.bridj.ann.Ptr;
import org.bridj.ann.Runtime;

@Library("libtesseract")
@Runtime(CRuntime.class)
public class Tesseract {
    static {
        BridJ.addNativeLibraryAlias("libtesseract", "libtesseract303");

        BridJ.register();
    }

    /** enum values */
    public enum OcrEngineMode implements IntValuedEnum<OcrEngineMode> {
        OEM_TESSERACT_ONLY(0),
        OEM_CUBE_ONLY(1),
        OEM_TESSERACT_CUBE_COMBINED(2),
        OEM_DEFAULT(3);

        OcrEngineMode(long value) {
            this.value = value;
        }

        private final long value;

        public long value() {
            return this.value;
        }

        public Iterator<OcrEngineMode> iterator() {
            return Collections.singleton(this).iterator();
        }

        public static IntValuedEnum<OcrEngineMode> fromValue(int value) {
            return FlagSet.fromValue(value, values());
        }
    }

    /** enum values */
    public enum PageSegMode implements IntValuedEnum<PageSegMode> {
        PSM_OSD_ONLY(0),
        PSM_AUTO_OSD(1),
        PSM_AUTO_ONLY(2),
        PSM_AUTO(3),
        PSM_SINGLE_COLUMN(4),
        PSM_SINGLE_BLOCK_VERT_TEXT(5),
        PSM_SINGLE_BLOCK(6),
        PSM_SINGLE_LINE(7),
        PSM_SINGLE_WORD(8),
        PSM_CIRCLE_WORD(9),
        PSM_SINGLE_CHAR(10),
        PSM_SPARSE_TEXT(11),
        PSM_SPARSE_TEXT_OSD(12),
        PSM_COUNT(13);

        PageSegMode(long value) {
            this.value = value;
        }

        private final long value;

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

    /** enum values */
    public enum PageIteratorLevel implements
            IntValuedEnum<PageIteratorLevel> {
        RIL_BLOCK(0),
        RIL_PARA(1),
        RIL_TEXTLINE(2),
        RIL_WORD(3),
        RIL_SYMBOL(4);

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

    /** enum values */
    public enum PolyBlockType implements IntValuedEnum<PolyBlockType> {
        PT_UNKNOWN(0),
        PT_FLOWING_TEXT(1),
        PT_HEADING_TEXT(2),
        PT_PULLOUT_TEXT(3),
        PT_TABLE(4),
        PT_VERTICAL_TEXT(5),
        PT_CAPTION_TEXT(6),
        PT_FLOWING_IMAGE(7),
        PT_HEADING_IMAGE(8),
        PT_PULLOUT_IMAGE(9),
        PT_HORZ_LINE(10),
        PT_VERT_LINE(11),
        PT_NOISE(12),
        PT_COUNT(13);

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

    /** enum values */
    public enum Orientation implements IntValuedEnum<Orientation> {
        ORIENTATION_PAGE_UP(0),
        ORIENTATION_PAGE_RIGHT(1),
        ORIENTATION_PAGE_DOWN(2),
        ORIENTATION_PAGE_LEFT(3);

        Orientation(long value) {
            this.value = value;
        }

        private final long value;

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

    /** enum values */
    public enum WritingDirection implements
            IntValuedEnum<WritingDirection> {
        WRITING_DIRECTION_LEFT_TO_RIGHT(0),
        WRITING_DIRECTION_RIGHT_TO_LEFT(1),
        WRITING_DIRECTION_TOP_TO_BOTTOM(2);

        WritingDirection(long value) {
            this.value = value;
        }

        private final long value;

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

    /** enum values */
    public enum TextlineOrder implements IntValuedEnum<TextlineOrder> {
        TEXTLINE_ORDER_LEFT_TO_RIGHT(0),
        TEXTLINE_ORDER_RIGHT_TO_LEFT(1),
        TEXTLINE_ORDER_TOP_TO_BOTTOM(2);

        TextlineOrder(long value) {
            this.value = value;
        }

        private final long value;

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

    public static final int TRUE = 1;
    public static final int FALSE = 0;

    /**
     * Original signature : <code>char* TessVersion()</code><br>
     * <i>native declaration : line 88</i>
     */
    @Name("TessVersion")
    public native static Pointer<Byte> TessVersion();

    /**
     * Original signature : <code>void TessDeleteText(char*)</code><br>
     * <i>native declaration : line 90</i>
     */
    @Name("TessDeleteText")
    public native static void TessDeleteText(Pointer<Byte> text);

    /**
     * Original signature : <code>void TessDeleteTextArray(char**)</code><br>
     * <i>native declaration : line 91</i>
     */
    @Name("TessDeleteTextArray")
    public native static void TessDeleteTextArray(Pointer<Pointer<Byte>> arr);

    /**
     * Original signature : <code>void TessDeleteIntArray(int*)</code><br>
     * <i>native declaration : line 92</i>
     */
    @Name("TessDeleteIntArray")
    public native static void TessDeleteIntArray(Pointer<Integer> arr);

    /**
     * Original signature :
     * <code>TessResultRenderer* TessTextRendererCreate()</code><br>
     * <i>native declaration : line 98</i>
     */
    @Name("TessTextRendererCreate")
    public native static Pointer<Tesseract.TessResultRenderer> TessTextRendererCreate();

    /**
     * Original signature :
     * <code>TessResultRenderer* TessHOcrRendererCreate()</code><br>
     * <i>native declaration : line 99</i>
     */
    @Name("TessHOcrRendererCreate")
    public native static Pointer<Tesseract.TessResultRenderer> TessHOcrRendererCreate();

    /**
     * Original signature :
     * <code>TessResultRenderer* TessPDFRendererCreate(const char*)</code><br>
     * <i>native declaration : line 100</i>
     */
    @Name("TessPDFRendererCreate")
    public native static Pointer<Tesseract.TessResultRenderer> TessPDFRendererCreate(
            Pointer<Byte> datadir);

    /**
     * Original signature :
     * <code>TessResultRenderer* TessUnlvRendererCreate()</code><br>
     * <i>native declaration : line 101</i>
     */
    @Name("TessUnlvRendererCreate")
    public native static Pointer<Tesseract.TessResultRenderer> TessUnlvRendererCreate();

    /**
     * Original signature :
     * <code>TessResultRenderer* TessBoxTextRendererCreate()</code><br>
     * <i>native declaration : line 102</i>
     */
    @Name("TessBoxTextRendererCreate")
    public native static Pointer<Tesseract.TessResultRenderer> TessBoxTextRendererCreate();

    /**
     * Original signature :
     * <code>void TessDeleteResultRenderer(TessResultRenderer*)</code><br>
     * <i>native declaration : line 104</i>
     */
    @Name("TessDeleteResultRenderer")
    public native static void TessDeleteResultRenderer(
            Pointer<Tesseract.TessResultRenderer> renderer);

    /**
     * Original signature :
     * <code>void TessResultRendererInsert(TessResultRenderer*, TessResultRenderer*)</code>
     * <br>
     * <i>native declaration : line 105</i>
     */
    @Name("TessResultRendererInsert")
    public native static void TessResultRendererInsert(
            Pointer<Tesseract.TessResultRenderer> renderer,
            Pointer<Tesseract.TessResultRenderer> next);

    /**
     * Original signature :
     * <code>TessResultRenderer* TessResultRendererNext(TessResultRenderer*)</code>
     * <br>
     * <i>native declaration : line 106</i>
     */
    @Name("TessResultRendererNext")
    public native static Pointer<Tesseract.TessResultRenderer> TessResultRendererNext(
            Pointer<Tesseract.TessResultRenderer> renderer);

    /**
     * Original signature :
     * <code>int TessResultRendererBeginDocument(TessResultRenderer*, const char*)</code>
     * <br>
     * <i>native declaration : line 108</i>
     */
    @Name("TessResultRendererBeginDocument")
    public native static int TessResultRendererBeginDocument(
            Pointer<Tesseract.TessResultRenderer> renderer, Pointer<Byte> title);

    /**
     * Original signature :
     * <code>int TessResultRendererAddImage(TessResultRenderer*, TessBaseAPI*)</code>
     * <br>
     * <i>native declaration : line 109</i>
     */
    @Name("TessResultRendererAddImage")
    public native static int TessResultRendererAddImage(
            Pointer<Tesseract.TessResultRenderer> renderer,
            Pointer<Tesseract.TessBaseAPI> api);

    /**
     * Original signature :
     * <code>int TessResultRendererAddError(TessResultRenderer*, TessBaseAPI*)</code>
     * <br>
     * <i>native declaration : line 110</i>
     */
    @Name("TessResultRendererAddError")
    public native static int TessResultRendererAddError(
            Pointer<Tesseract.TessResultRenderer> renderer,
            Pointer<Tesseract.TessBaseAPI> api);

    /**
     * Original signature :
     * <code>int TessResultRendererEndDocument(TessResultRenderer*)</code><br>
     * <i>native declaration : line 111</i>
     */
    @Name("TessResultRendererEndDocument")
    public native static int TessResultRendererEndDocument(
            Pointer<Tesseract.TessResultRenderer> renderer);

    /**
     * Original signature :
     * <code>int TessResultRendererGetOutput(TessResultRenderer*, const char**, int*)</code>
     * <br>
     * <i>native declaration : line 112</i>
     */
    @Name("TessResultRendererGetOutput")
    public native static int TessResultRendererGetOutput(
            Pointer<Tesseract.TessResultRenderer> renderer,
            Pointer<Pointer<Byte>> data, Pointer<Integer> data_len);

    /**
     * Original signature :
     * <code>char* TessResultRendererTypename(TessResultRenderer*)</code><br>
     * <i>native declaration : line 114</i>
     */
    @Name("TessResultRendererTypename")
    public native static Pointer<Byte> TessResultRendererTypename(
            Pointer<Tesseract.TessResultRenderer> renderer);

    /**
     * Original signature :
     * <code>char* TessResultRendererExtention(TessResultRenderer*)</code><br>
     * <i>native declaration : line 115</i>
     */
    @Name("TessResultRendererExtention")
    public native static Pointer<Byte> TessResultRendererExtention(
            Pointer<Tesseract.TessResultRenderer> renderer);

    /**
     * Original signature :
     * <code>char* TessResultRendererTitle(TessResultRenderer*)</code><br>
     * <i>native declaration : line 116</i>
     */
    @Name("TessResultRendererTitle")
    public native static Pointer<Byte> TessResultRendererTitle(
            Pointer<Tesseract.TessResultRenderer> renderer);

    /**
     * Original signature :
     * <code>int TessResultRendererImageNum(TessResultRenderer*)</code><br>
     * <i>native declaration : line 117</i>
     */
    @Name("TessResultRendererImageNum")
    public native static int TessResultRendererImageNum(
            Pointer<Tesseract.TessResultRenderer> renderer);

    /**
     * Original signature : <code>TessBaseAPI* TessBaseAPICreate()</code><br>
     * <i>native declaration : line 121</i>
     */
    @Name("TessBaseAPICreate")
    public native static Pointer<Tesseract.TessBaseAPI> TessBaseAPICreate();

    /**
     * Original signature : <code>void TessBaseAPIDelete(TessBaseAPI*)</code><br>
     * <i>native declaration : line 123</i>
     */
    @Name("TessBaseAPIDelete")
    public native static void TessBaseAPIDelete(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>size_t TessBaseAPIGetOpenCLDevice(TessBaseAPI*, void**)</code><br>
     * <i>native declaration : line 125</i>
     */
    @Name("TessBaseAPIGetOpenCLDevice")
    @Ptr
    public native static long TessBaseAPIGetOpenCLDevice(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Pointer<?>> device);

    /**
     * Original signature :
     * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration : line 127</i>
     */
    @Name("TessBaseAPISetInputName")
    public native static void TessBaseAPISetInputName(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> name);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetInputName(TessBaseAPI*)</code><br>
     * <i>native declaration : line 128</i>
     */
    @Name("TessBaseAPIGetInputName")
    public native static Pointer<Byte> TessBaseAPIGetInputName(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>void TessBaseAPISetInputImage(TessBaseAPI*, Pix*)</code><br>
     * <i>native declaration : line 130</i>
     */
    @Name("TessBaseAPISetInputImage")
    public native static void TessBaseAPISetInputImage(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Tesseract.Pix> pix);

    /**
     * Original signature :
     * <code>Pix* TessBaseAPIGetInputImage(TessBaseAPI*)</code><br>
     * <i>native declaration : line 131</i>
     */
    @Name("TessBaseAPIGetInputImage")
    public native static Pointer<Tesseract.Pix> TessBaseAPIGetInputImage(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetSourceYResolution(TessBaseAPI*)</code><br>
     * <i>native declaration : line 133</i>
     */
    @Name("TessBaseAPIGetSourceYResolution")
    public native static int TessBaseAPIGetSourceYResolution(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetDatapath(TessBaseAPI*)</code><br>
     * <i>native declaration : line 134</i>
     */
    @Name("TessBaseAPIGetDatapath")
    public native static Pointer<Byte> TessBaseAPIGetDatapath(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration : line 136</i>
     */
    @Name("TessBaseAPISetOutputName")
    public native static void TessBaseAPISetOutputName(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> name);

    /**
     * Original signature :
     * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
     * <br>
     * <i>native declaration : line 138</i>
     */
    @Name("TessBaseAPISetVariable")
    public native static int TessBaseAPISetVariable(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Byte> value);

    /**
     * Original signature :
     * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
     * <br>
     * <i>native declaration : line 139</i>
     */
    @Name("TessBaseAPISetDebugVariable")
    public native static int TessBaseAPISetDebugVariable(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Byte> value);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
     * <br>
     * <i>native declaration : line 141</i>
     */
    @Name("TessBaseAPIGetIntVariable")
    public native static int TessBaseAPIGetIntVariable(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Integer> value);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
     * <br>
     * <i>native declaration : line 142</i>
     */
    @Name("TessBaseAPIGetBoolVariable")
    public native static int TessBaseAPIGetBoolVariable(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Integer> value);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
     * <br>
     * <i>native declaration : line 143</i>
     */
    @Name("TessBaseAPIGetDoubleVariable")
    public native static int TessBaseAPIGetDoubleVariable(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Double> value);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
     * <br>
     * <i>native declaration : line 144</i>
     */
    @Name("TessBaseAPIGetStringVariable")
    public native static Pointer<Byte> TessBaseAPIGetStringVariable(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> name);

    /**
     * Original signature :
     * <code>void TessBaseAPIPrintVariables(const TessBaseAPI*, FILE*)</code><br>
     * <i>native declaration : line 147</i>
     */
    @Name("TessBaseAPIPrintVariables")
    public native static void TessBaseAPIPrintVariables(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Tesseract.FILE> fp);

    /**
     * Original signature :
     * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
     * <br>
     * <i>native declaration : line 148</i>
     */
    @Name("TessBaseAPIPrintVariablesToFile")
    public native static int TessBaseAPIPrintVariablesToFile(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> filename);

    /**
     * Original signature :
     * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
     * <br>
     * <i>native declaration : line 159</i>
     */
    @Name("TessBaseAPIInit1")
    public native static int TessBaseAPIInit1(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
            Pointer<Byte> language,
            IntValuedEnum<Tesseract.OcrEngineMode> oem,
            Pointer<Pointer<Byte>> configs, int configs_size);

    /**
     * Original signature :
     * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
     * <br>
     * <i>native declaration : line 161</i>
     */
    @Name("TessBaseAPIInit2")
    public native static int TessBaseAPIInit2(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
            Pointer<Byte> language,
            IntValuedEnum<Tesseract.OcrEngineMode> oem);

    /**
     * Original signature :
     * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
     * <i>native declaration : line 162</i>
     */
    @Name("TessBaseAPIInit3")
    public native static int TessBaseAPIInit3(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
            Pointer<Byte> language);

    /**
     * Original signature :
     * <code>int TessBaseAPIInit4(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int, char**, char**, size_t, int)</code>
     * <br>
     * <i>native declaration : line 164</i>
     */
    @Name("TessBaseAPIInit4")
    public native static int TessBaseAPIInit4(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
            Pointer<Byte> language,
            IntValuedEnum<Tesseract.OcrEngineMode> mode,
            Pointer<Pointer<Byte>> configs, int configs_size,
            Pointer<Pointer<Byte>> vars_vec,
            Pointer<Pointer<Byte>> vars_values,
            @Ptr long vars_vec_size, int set_only_non_debug_params);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetInitLanguagesAsString(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration : line 169</i>
     */
    @Name("TessBaseAPIGetInitLanguagesAsString")
    public native static Pointer<Byte> TessBaseAPIGetInitLanguagesAsString(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>char** TessBaseAPIGetLoadedLanguagesAsVector(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration : line 171</i>
     */
    @Name("TessBaseAPIGetLoadedLanguagesAsVector")
    public native static Pointer<Pointer<Byte>> TessBaseAPIGetLoadedLanguagesAsVector(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>char** TessBaseAPIGetAvailableLanguagesAsVector(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration : line 173</i>
     */
    @Name("TessBaseAPIGetAvailableLanguagesAsVector")
    public native static Pointer<Pointer<Byte>> TessBaseAPIGetAvailableLanguagesAsVector(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
     * <br>
     * <i>native declaration : line 176</i>
     */
    @Name("TessBaseAPIInitLangMod")
    public native static int TessBaseAPIInitLangMod(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
            Pointer<Byte> language);

    /**
     * Original signature :
     * <code>void TessBaseAPIInitForAnalysePage(TessBaseAPI*)</code><br>
     * <i>native declaration : line 177</i>
     */
    @Name("TessBaseAPIInitForAnalysePage")
    public native static void TessBaseAPIInitForAnalysePage(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration : line 179</i>
     */
    @Name("TessBaseAPIReadConfigFile")
    public native static void TessBaseAPIReadConfigFile(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> filename);

    /**
     * Original signature :
     * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code>
     * <br>
     * <i>native declaration : line 180</i>
     */
    @Name("TessBaseAPIReadDebugConfigFile")
    public native static void TessBaseAPIReadDebugConfigFile(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> filename);

    /**
     * Original signature :
     * <code>void TessBaseAPISetPageSegMode(TessBaseAPI*, TessPageSegMode)</code>
     * <br>
     * <i>native declaration : line 182</i>
     */
    @Name("TessBaseAPISetPageSegMode")
    public native static void TessBaseAPISetPageSegMode(
            Pointer<Tesseract.TessBaseAPI> handle,
            IntValuedEnum<Tesseract.PageSegMode> mode);

    /**
     * Original signature :
     * <code>TessPageSegMode TessBaseAPIGetPageSegMode(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration : line 183</i>
     */
    @Name("TessBaseAPIGetPageSegMode")
    public native static IntValuedEnum<Tesseract.PageSegMode> TessBaseAPIGetPageSegMode(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
     * <br>
     * <i>native declaration : line 186</i>
     */
    @Name("TessBaseAPIRect")
    public native static Pointer<Byte> TessBaseAPIRect(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> imagedata,
            int bytes_per_pixel, int bytes_per_line, int left, int top,
            int width,
            int height);

    /**
     * Original signature :
     * <code>void TessBaseAPIClearAdaptiveClassifier(TessBaseAPI*)</code><br>
     * <i>native declaration : line 190</i>
     */
    @Name("TessBaseAPIClearAdaptiveClassifier")
    public native static void TessBaseAPIClearAdaptiveClassifier(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
     * <br>
     * <i>native declaration : line 192</i>
     */
    @Name("TessBaseAPISetImage")
    public native static void TessBaseAPISetImage(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> imagedata,
            int width, int height, int bytes_per_pixel, int bytes_per_line);

    /**
     * Original signature :
     * <code>void TessBaseAPISetImage2(TessBaseAPI*, Pix*)</code><br>
     * <i>native declaration : line 194</i>
     */
    @Name("TessBaseAPISetImage2")
    public native static void TessBaseAPISetImage2(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Tesseract.Pix> pix);

    /**
     * Original signature :
     * <code>void TessBaseAPISetSourceResolution(TessBaseAPI*, int)</code><br>
     * <i>native declaration : line 196</i>
     */
    @Name("TessBaseAPISetSourceResolution")
    public native static void TessBaseAPISetSourceResolution(
            Pointer<Tesseract.TessBaseAPI> handle, int ppi);

    /**
     * Original signature :
     * <code>void TessBaseAPISetRectangle(TessBaseAPI*, int, int, int, int)</code>
     * <br>
     * <i>native declaration : line 198</i>
     */
    @Name("TessBaseAPISetRectangle")
    public native static void TessBaseAPISetRectangle(
            Pointer<Tesseract.TessBaseAPI> handle, int left, int top,
            int width,
            int height);

    /**
     * Original signature :
     * <code>Pix* TessBaseAPIGetThresholdedImage(TessBaseAPI*)</code><br>
     * <i>native declaration : line 204</i>
     */
    @Name("TessBaseAPIGetThresholdedImage")
    public native static Pointer<Tesseract.Pix> TessBaseAPIGetThresholdedImage(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetRegions(TessBaseAPI*, Pixa**)</code><br>
     * <i>native declaration : line 206</i>
     */
    @Name("TessBaseAPIGetRegions")
    public native static Pointer<Tesseract.Boxa> TessBaseAPIGetRegions(
            Pointer<Tesseract.TessBaseAPI> handle,
            Pointer<Pointer<Tesseract.Pixa>> pixa);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetTextlines(TessBaseAPI*, Pixa**, int**)</code><br>
     * <i>native declaration : line 208</i>
     */
    @Name("TessBaseAPIGetTextlines")
    public native static Pointer<Tesseract.Boxa> TessBaseAPIGetTextlines(
            Pointer<Tesseract.TessBaseAPI> handle,
            Pointer<Pointer<Tesseract.Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetTextlines1(TessBaseAPI*, const int, const int, Pixa**, int**, int**)</code>
     * <br>
     * <i>native declaration : line 210</i>
     */
    @Name("TessBaseAPIGetTextlines1")
    public native static Pointer<Tesseract.Boxa> TessBaseAPIGetTextlines1(
            Pointer<Tesseract.TessBaseAPI> handle, int raw_image,
            int raw_padding,
            Pointer<Pointer<Tesseract.Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids,
            Pointer<Pointer<Integer>> paraids);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetStrips(TessBaseAPI*, Pixa**, int**)</code><br>
     * <i>native declaration : line 213</i>
     */
    @Name("TessBaseAPIGetStrips")
    public native static Pointer<Tesseract.Boxa> TessBaseAPIGetStrips(
            Pointer<Tesseract.TessBaseAPI> handle,
            Pointer<Pointer<Tesseract.Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetWords(TessBaseAPI*, Pixa**)</code><br>
     * <i>native declaration : line 215</i>
     */
    @Name("TessBaseAPIGetWords")
    public native static Pointer<Tesseract.Boxa> TessBaseAPIGetWords(
            Pointer<Tesseract.TessBaseAPI> handle,
            Pointer<Pointer<Tesseract.Pixa>> pixa);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetConnectedComponents(TessBaseAPI*, Pixa**)</code>
     * <br>
     * <i>native declaration : line 217</i>
     */
    @Name("TessBaseAPIGetConnectedComponents")
    public native static Pointer<Tesseract.Boxa> TessBaseAPIGetConnectedComponents(
            Pointer<Tesseract.TessBaseAPI> handle,
            Pointer<Pointer<Tesseract.Pixa>> cc);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetComponentImages(TessBaseAPI*, const TessPageIteratorLevel, const int, Pixa**, int**)</code>
     * <br>
     * <i>native declaration : line 219</i>
     */
    @Name("TessBaseAPIGetComponentImages")
    public native static Pointer<Tesseract.Boxa> TessBaseAPIGetComponentImages(
            Pointer<Tesseract.TessBaseAPI> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level,
            int text_only,
            Pointer<Pointer<Tesseract.Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetComponentImages1(TessBaseAPI*, const TessPageIteratorLevel, const int, const int, const int, Pixa**, int**, int**)</code>
     * <br>
     * <i>native declaration : line 222</i>
     */
    @Name("TessBaseAPIGetComponentImages1")
    public native static Pointer<Tesseract.Boxa> TessBaseAPIGetComponentImages1(
            Pointer<Tesseract.TessBaseAPI> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level,
            int text_only,
            int raw_image, int raw_padding,
            Pointer<Pointer<Tesseract.Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids,
            Pointer<Pointer<Integer>> paraids);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetThresholdedImageScaleFactor(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration : line 227</i>
     */
    @Name("TessBaseAPIGetThresholdedImageScaleFactor")
    public native static int TessBaseAPIGetThresholdedImageScaleFactor(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration : line 229</i>
     */
    @Name("TessBaseAPIDumpPGM")
    public native static void TessBaseAPIDumpPGM(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> filename);

    /**
     * Original signature :
     * <code>TessPageIterator* TessBaseAPIAnalyseLayout(TessBaseAPI*)</code><br>
     * <i>native declaration : line 231</i>
     */
    @Name("TessBaseAPIAnalyseLayout")
    public native static Pointer<Tesseract.TessPageIterator> TessBaseAPIAnalyseLayout(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIRecognize(TessBaseAPI*, ETEXT_DESC*)</code><br>
     * <i>native declaration : line 234</i>
     */
    @Name("TessBaseAPIRecognize")
    public native static int TessBaseAPIRecognize(
            Pointer<Tesseract.TessBaseAPI> handle,
            Pointer<Tesseract.ETEXT_DESC> monitor);

    /**
     * Original signature :
     * <code>int TessBaseAPIRecognizeForChopTest(TessBaseAPI*, ETEXT_DESC*)</code>
     * <br>
     * <i>native declaration : line 235</i>
     */
    @Name("TessBaseAPIRecognizeForChopTest")
    public native static int TessBaseAPIRecognizeForChopTest(
            Pointer<Tesseract.TessBaseAPI> handle,
            Pointer<Tesseract.ETEXT_DESC> monitor);

    /**
     * Original signature :
     * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
     * <br>
     * <i>native declaration : line 236</i>
     */
    @Name("TessBaseAPIProcessPages")
    public native static Pointer<Byte> TessBaseAPIProcessPages(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> filename,
            Pointer<Byte> retry_config, int timeout_millisec);

    /**
     * Original signature :
     * <code>int TessBaseAPIProcessPages1(TessBaseAPI*, const char*, const char*, int, TessResultRenderer*)</code>
     * <br>
     * <i>native declaration : line 238</i>
     */
    @Name("TessBaseAPIProcessPages1")
    public native static int TessBaseAPIProcessPages1(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> filename,
            Pointer<Byte> retry_config, int timeout_millisec,
            Pointer<Tesseract.TessResultRenderer> renderer);

    /**
     * Original signature :
     * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, Pix*, int, const char*, const char*, int)</code>
     * <br>
     * <i>native declaration : line 240</i>
     */
    @Name("TessBaseAPIProcessPage")
    public native static Pointer<Byte> TessBaseAPIProcessPage(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Tesseract.Pix> pix,
            int page_index, Pointer<Byte> filename, Pointer<Byte> retry_config,
            int timeout_millisec);

    /**
     * Original signature :
     * <code>int TessBaseAPIProcessPage1(TessBaseAPI*, Pix*, int, const char*, const char*, int, TessResultRenderer*)</code>
     * <br>
     * <i>native declaration : line 242</i>
     */
    @Name("TessBaseAPIProcessPage1")
    public native static int TessBaseAPIProcessPage1(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Tesseract.Pix> pix,
            int page_index, Pointer<Byte> filename, Pointer<Byte> retry_config,
            int timeout_millisec, Pointer<Tesseract.TessResultRenderer> renderer);

    /**
     * Original signature :
     * <code>TessResultIterator* TessBaseAPIGetIterator(TessBaseAPI*)</code><br>
     * <i>native declaration : line 245</i>
     */
    @Name("TessBaseAPIGetIterator")
    public native static Pointer<Tesseract.TessResultIterator> TessBaseAPIGetIterator(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>TessMutableIterator* TessBaseAPIGetMutableIterator(TessBaseAPI*)</code>
     * <br>
     * <i>native declaration : line 247</i>
     */
    @Name("TessBaseAPIGetMutableIterator")
    public native static Pointer<Tesseract.TessMutableIterator> TessBaseAPIGetMutableIterator(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetUTF8Text(TessBaseAPI*)</code><br>
     * <i>native declaration : line 250</i>
     */
    @Name("TessBaseAPIGetUTF8Text")
    public native static Pointer<Byte> TessBaseAPIGetUTF8Text(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetHOCRText(TessBaseAPI*, int)</code><br>
     * <i>native declaration : line 251</i>
     */
    @Name("TessBaseAPIGetHOCRText")
    public native static Pointer<Byte> TessBaseAPIGetHOCRText(
            Pointer<Tesseract.TessBaseAPI> handle, int page_number);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetBoxText(TessBaseAPI*, int)</code><br>
     * <i>native declaration : line 252</i>
     */
    @Name("TessBaseAPIGetBoxText")
    public native static Pointer<Byte> TessBaseAPIGetBoxText(
            Pointer<Tesseract.TessBaseAPI> handle, int page_number);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetUNLVText(TessBaseAPI*)</code><br>
     * <i>native declaration : line 253</i>
     */
    @Name("TessBaseAPIGetUNLVText")
    public native static Pointer<Byte> TessBaseAPIGetUNLVText(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIMeanTextConf(TessBaseAPI*)</code><br>
     * <i>native declaration : line 254</i>
     */
    @Name("TessBaseAPIMeanTextConf")
    public native static int TessBaseAPIMeanTextConf(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>int* TessBaseAPIAllWordConfidences(TessBaseAPI*)</code><br>
     * <i>native declaration : line 255</i>
     */
    @Name("TessBaseAPIAllWordConfidences")
    public native static Pointer<Integer> TessBaseAPIAllWordConfidences(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
     * <br>
     * <i>native declaration : line 256</i>
     */
    @Name("TessBaseAPIAdaptToWordStr")
    public native static int TessBaseAPIAdaptToWordStr(
            Pointer<Tesseract.TessBaseAPI> handle,
            IntValuedEnum<Tesseract.PageSegMode> mode, Pointer<Byte> wordstr);

    /**
     * Original signature : <code>void TessBaseAPIClear(TessBaseAPI*)</code><br>
     * <i>native declaration : line 258</i>
     */
    @Name("TessBaseAPIClear")
    public native static void TessBaseAPIClear(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature : <code>void TessBaseAPIEnd(TessBaseAPI*)</code><br>
     * <i>native declaration : line 259</i>
     */
    @Name("TessBaseAPIEnd")
    public native static void TessBaseAPIEnd(
            Pointer<Tesseract.TessBaseAPI> handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration : line 261</i>
     */
    @Name("TessBaseAPIIsValidWord")
    public native static int TessBaseAPIIsValidWord(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Byte> word);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
     * <i>native declaration : line 262</i>
     */
    @Name("TessBaseAPIGetTextDirection")
    public native static int TessBaseAPIGetTextDirection(
            Pointer<Tesseract.TessBaseAPI> handle, Pointer<Integer> out_offset,
            Pointer<Float> out_slope);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetUnichar(TessBaseAPI*, int)</code><br>
     * <i>native declaration : line 280</i>
     */
    @Name("TessBaseAPIGetUnichar")
    public native static Pointer<Byte> TessBaseAPIGetUnichar(
            Pointer<Tesseract.TessBaseAPI> handle, int unichar_id);

    /**
     * Original signature :
     * <code>void TessBaseAPISetMinOrientationMargin(TessBaseAPI*, double)</code>
     * <br>
     * <i>native declaration : line 303</i>
     */
    @Name("TessBaseAPISetMinOrientationMargin")
    public native static void TessBaseAPISetMinOrientationMargin(
            Pointer<Tesseract.TessBaseAPI> handle, double margin);

    /**
     * Original signature :
     * <code>void TessPageIteratorDelete(TessPageIterator*)</code><br>
     * <i>native declaration : line 313</i>
     */
    @Name("TessPageIteratorDelete")
    public native static void TessPageIteratorDelete(
            Pointer<Tesseract.TessPageIterator> handle);

    /**
     * Original signature :
     * <code>TessPageIterator* TessPageIteratorCopy(const TessPageIterator*)</code>
     * <br>
     * <i>native declaration : line 314</i>
     */
    @Name("TessPageIteratorCopy")
    public native static Pointer<Tesseract.TessPageIterator> TessPageIteratorCopy(
            Pointer<Tesseract.TessPageIterator> handle);

    /**
     * Original signature :
     * <code>void TessPageIteratorBegin(TessPageIterator*)</code><br>
     * <i>native declaration : line 317</i>
     */
    @Name("TessPageIteratorBegin")
    public native static void TessPageIteratorBegin(
            Pointer<Tesseract.TessPageIterator> handle);

    /**
     * Original signature :
     * <code>int TessPageIteratorNext(TessPageIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration : line 318</i>
     */
    @Name("TessPageIteratorNext")
    public native static int TessPageIteratorNext(
            Pointer<Tesseract.TessPageIterator> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level);

    /**
     * Original signature :
     * <code>int TessPageIteratorIsAtBeginningOf(const TessPageIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration : line 319</i>
     */
    @Name("TessPageIteratorIsAtBeginningOf")
    public native static int TessPageIteratorIsAtBeginningOf(
            Pointer<Tesseract.TessPageIterator> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level);

    /**
     * Original signature :
     * <code>int TessPageIteratorIsAtFinalElement(const TessPageIterator*, TessPageIteratorLevel, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration : line 320</i>
     */
    @Name("TessPageIteratorIsAtFinalElement")
    public native static int TessPageIteratorIsAtFinalElement(
            Pointer<Tesseract.TessPageIterator> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level,
            IntValuedEnum<Tesseract.PageIteratorLevel> element);

    /**
     * Original signature :
     * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
     * <br>
     * <i>native declaration : line 323</i>
     */
    @Name("TessPageIteratorBoundingBox")
    public native static int TessPageIteratorBoundingBox(
            Pointer<Tesseract.TessPageIterator> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level,
            Pointer<Integer> left, Pointer<Integer> top,
            Pointer<Integer> right,
            Pointer<Integer> bottom);

    /**
     * Original signature :
     * <code>TessPolyBlockType TessPageIteratorBlockType(const TessPageIterator*)</code>
     * <br>
     * <i>native declaration : line 325</i>
     */
    @Name("TessPageIteratorBlockType")
    public native static IntValuedEnum<Tesseract.PolyBlockType> TessPageIteratorBlockType(
            Pointer<Tesseract.TessPageIterator> handle);

    /**
     * Original signature :
     * <code>Pix* TessPageIteratorGetBinaryImage(const TessPageIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration : line 328</i>
     */
    @Name("TessPageIteratorGetBinaryImage")
    public native static Pointer<Tesseract.Pix> TessPageIteratorGetBinaryImage(
            Pointer<Tesseract.TessPageIterator> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level);

    /**
     * Original signature :
     * <code>Pix* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
     * <br>
     * <i>native declaration : line 330</i>
     */
    @Name("TessPageIteratorGetImage")
    public native static Pointer<Tesseract.Pix> TessPageIteratorGetImage(
            Pointer<Tesseract.TessPageIterator> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level, int padding,
            Pointer<Integer> left, Pointer<Integer> top);

    /**
     * Original signature :
     * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
     * <br>
     * <i>native declaration : line 334</i>
     */
    @Name("TessPageIteratorBaseline")
    public native static int TessPageIteratorBaseline(
            Pointer<Tesseract.TessPageIterator> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level,
            Pointer<Integer> x1, Pointer<Integer> y1, Pointer<Integer> x2,
            Pointer<Integer> y2);

    /**
     * Original signature :
     * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
     * <br>
     * <i>native declaration : line 337</i>
     */
    @Name("TessPageIteratorOrientation")
    public native static void TessPageIteratorOrientation(
            Pointer<Tesseract.TessPageIterator> handle,
            Pointer<IntValuedEnum<Tesseract.Orientation>> orientation,
            Pointer<IntValuedEnum<Tesseract.WritingDirection>> writing_direction,
            Pointer<IntValuedEnum<Tesseract.TextlineOrder>> textline_order,
            Pointer<Float> deskew_angle);

    /**
     * Original signature :
     * <code>void TessResultIteratorDelete(TessResultIterator*)</code><br>
     * <i>native declaration : line 343</i>
     */
    @Name("TessResultIteratorDelete")
    public native static void TessResultIteratorDelete(
            Pointer<Tesseract.TessResultIterator> handle);

    /**
     * Original signature :
     * <code>TessResultIterator* TessResultIteratorCopy(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration : line 344</i>
     */
    @Name("TessResultIteratorCopy")
    public native static Pointer<Tesseract.TessResultIterator> TessResultIteratorCopy(
            Pointer<Tesseract.TessResultIterator> handle);

    /**
     * Original signature :
     * <code>TessPageIterator* TessResultIteratorGetPageIterator(TessResultIterator*)</code>
     * <br>
     * <i>native declaration : line 346</i>
     */
    @Name("TessResultIteratorGetPageIterator")
    public native static Pointer<Tesseract.TessPageIterator> TessResultIteratorGetPageIterator(
            Pointer<Tesseract.TessResultIterator> handle);

    /**
     * Original signature :
     * <code>TessPageIterator* TessResultIteratorGetPageIteratorConst(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration : line 348</i>
     */
    @Name("TessResultIteratorGetPageIteratorConst")
    public native static Pointer<Tesseract.TessPageIterator> TessResultIteratorGetPageIteratorConst(
            Pointer<Tesseract.TessResultIterator> handle);

    /**
     * Original signature :
     * <code>TessPageIterator* TessResultIteratorGetChoiceIterator(const TessResultIterator*)</code>
     */
    @Name("TessResultIteratorGetChoiceIterator")
    public native static Pointer<Tesseract.TessChoiceIterator> TessResultIteratorGetChoiceIterator(
            Pointer<Tesseract.TessResultIterator> handle);

    /**
     * Original signature :
     * <code>char* TessResultIteratorGetUTF8Text(const TessResultIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration : line 351</i>
     */
    @Name("TessResultIteratorGetUTF8Text")
    public native static Pointer<Byte> TessResultIteratorGetUTF8Text(
            Pointer<Tesseract.TessResultIterator> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level);

    /**
     * Original signature :
     * <code>float TessResultIteratorConfidence(const TessResultIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration : line 352</i>
     */
    @Name("TessResultIteratorConfidence")
    public native static float TessResultIteratorConfidence(
            Pointer<Tesseract.TessResultIterator> handle,
            IntValuedEnum<Tesseract.PageIteratorLevel> level);

    /**
     * Original signature :
     * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
     * <br>
     * <i>native declaration : line 354</i>
     */
    @Name("TessResultIteratorWordFontAttributes")
    public native static Pointer<Byte> TessResultIteratorWordFontAttributes(
            Pointer<Tesseract.TessResultIterator> handle,
            Pointer<Integer> is_bold, Pointer<Integer> is_italic,
            Pointer<Integer> is_underlined, Pointer<Integer> is_monospace,
            Pointer<Integer> is_serif, Pointer<Integer> is_smallcaps,
            Pointer<Integer> pointsize, Pointer<Integer> font_id);

    /**
     * Original signature :
     * <code>int TessResultIteratorWordIsFromDictionary(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration : line 359</i>
     */
    @Name("TessResultIteratorWordIsFromDictionary")
    public native static int TessResultIteratorWordIsFromDictionary(
            Pointer<Tesseract.TessResultIterator> handle);

    /**
     * Original signature :
     * <code>int TessResultIteratorWordIsNumeric(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration : line 360</i>
     */
    @Name("TessResultIteratorWordIsNumeric")
    public native static int TessResultIteratorWordIsNumeric(
            Pointer<Tesseract.TessResultIterator> handle);

    /**
     * Original signature :
     * <code>int TessResultIteratorSymbolIsSuperscript(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration : line 361</i>
     */
    @Name("TessResultIteratorSymbolIsSuperscript")
    public native static int TessResultIteratorSymbolIsSuperscript(
            Pointer<Tesseract.TessResultIterator> handle);

    /**
     * Original signature :
     * <code>int TessResultIteratorSymbolIsSubscript(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration : line 362</i>
     */
    @Name("TessResultIteratorSymbolIsSubscript")
    public native static int TessResultIteratorSymbolIsSubscript(
            Pointer<Tesseract.TessResultIterator> handle);

    /**
     * Original signature :
     * <code>int TessResultIteratorSymbolIsDropcap(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration : line 363</i>
     */
    @Name("TessResultIteratorSymbolIsDropcap")
    public native static int TessResultIteratorSymbolIsDropcap(
            Pointer<Tesseract.TessResultIterator> handle);

    @Name("TessChoiceIteratorDelete")
    public native static void TessChoiceIteratorDelete(
            Pointer<Tesseract.TessChoiceIterator> handle);

    @Name("TessChoiceIteratorNext")
    public native static int TessChoiceIteratorNext(
            Pointer<Tesseract.TessChoiceIterator> handle);

    @Name("TessChoiceIteratorConfidence")
    public native static Pointer<Byte> TessChoiceIteratorGetUTF8Text(
            Pointer<Tesseract.TessChoiceIterator> handle);

    @Name("TessChoiceIteratorConfidence")
    public native static float TessChoiceIteratorConfidence(
            Pointer<Tesseract.TessChoiceIterator> handle);

    /** Undefined type */
    public static interface Boxa {

    };

    /** Undefined type */
    public static interface TessBaseAPI {

    };

    /** Leptonica Pix */
    public static class Pix extends StructObject {
        /** width in pixels */
        @Field(0)
        public int w() {
            return this.io.getIntField(this, 0);
        }

        /** width in pixels */
        @Field(0)
        public Pix w(int w) {
            this.io.setIntField(this, 0, w);
            return this;
        }

        /** height in pixels */
        @Field(1)
        public int h() {
            return this.io.getIntField(this, 1);
        }

        /** height in pixels */
        @Field(1)
        public Pix h(int h) {
            this.io.setIntField(this, 1, h);
            return this;
        }

        /** depth in bits (bpp) */
        @Field(2)
        public int d() {
            return this.io.getIntField(this, 2);
        }

        /** depth in bits (bpp) */
        @Field(2)
        public Pix d(int d) {
            this.io.setIntField(this, 2, d);
            return this;
        }

        /** number of samples per pixel */
        @Field(3)
        public int spp() {
            return this.io.getIntField(this, 3);
        }

        /** number of samples per pixel */
        @Field(3)
        public Pix spp(int spp) {
            this.io.setIntField(this, 3, spp);
            return this;
        }

        /** 32-bit words/line */
        @Field(4)
        public int wpl() {
            return this.io.getIntField(this, 4);
        }

        /** 32-bit words/line */
        @Field(4)
        public Pix wpl(int wpl) {
            this.io.setIntField(this, 4, wpl);
            return this;
        }

        /** reference count (1 if no clones) */
        @Field(5)
        public int refcount() {
            return this.io.getIntField(this, 5);
        }

        /** reference count (1 if no clones) */
        @Field(5)
        public Pix refcount(int refcount) {
            this.io.setIntField(this, 5, refcount);
            return this;
        }

        /** image res (ppi) in x direction */
        @Field(6)
        public int xres() {
            return this.io.getIntField(this, 6);
        }

        /** image res (ppi) in x direction */
        @Field(6)
        public Pix xres(int xres) {
            this.io.setIntField(this, 6, xres);
            return this;
        }

        /**
         * (use 0 if unknown)<br>
         * image res (ppi) in y direction
         */
        @Field(7)
        public int yres() {
            return this.io.getIntField(this, 7);
        }

        /**
         * (use 0 if unknown)<br>
         * image res (ppi) in y direction
         */
        @Field(7)
        public Pix yres(int yres) {
            this.io.setIntField(this, 7, yres);
            return this;
        }

        /**
         * (use 0 if unknown)<br>
         * input file format, IFF_*
         */
        @Field(8)
        public int informat() {
            return this.io.getIntField(this, 8);
        }

        /**
         * (use 0 if unknown)<br>
         * input file format, IFF_*
         */
        @Field(8)
        public Pix informat(int informat) {
            this.io.setIntField(this, 8, informat);
            return this;
        }

        /** special instructions for I/O, etc */
        @Field(9)
        public int special() {
            return this.io.getIntField(this, 9);
        }

        /** special instructions for I/O, etc */
        @Field(9)
        public Pix special(int special) {
            this.io.setIntField(this, 9, special);
            return this;
        }

        /**
         * text string associated with pix<br>
         * C type : char*
         */
        @Field(10)
        public Pointer<Byte> text() {
            return this.io.getPointerField(this, 10);
        }

        /**
         * text string associated with pix<br>
         * C type : char*
         */
        @Field(10)
        public Pix text(Pointer<Byte> text) {
            this.io.setPointerField(this, 10, text);
            return this;
        }

        /**
         * colormap (may be null)<br>
         * C type : PixColormap*
         */
        @Field(11)
        public Pointer<PixColormap> colormap() {
            return this.io.getPointerField(this, 11);
        }

        /**
         * colormap (may be null)<br>
         * C type : PixColormap*
         */
        @Field(11)
        public Pix colormap(Pointer<PixColormap> colormap) {
            this.io.setPointerField(this, 11, colormap);
            return this;
        }

        /**
         * the image data<br>
         * C type : unsigned int*
         */
        @Field(12)
        public Pointer<Integer> data() {
            return this.io.getPointerField(this, 12);
        }

        /**
         * the image data<br>
         * C type : unsigned int*
         */
        @Field(12)
        public Pix data(Pointer<Integer> data) {
            this.io.setPointerField(this, 12, data);
            return this;
        }

        public Pix() {
            super();
        }

        public Pix(Pointer<Pix> pointer) {
            super(pointer);
        }
    }

    public static class PixColormap extends StructObject {
        /**
         * colormap table (array of RGBA_QUAD)<br>
         * C type : void*
         */
        @Field(0)
        public Pointer<?> array() {
            return this.io.getPointerField(this, 0);
        }

        /**
         * colormap table (array of RGBA_QUAD)<br>
         * C type : void*
         */
        @Field(0)
        public PixColormap array(Pointer<?> array) {
            this.io.setPointerField(this, 0, array);
            return this;
        }

        /** of pix (1, 2, 4 or 8 bpp) */
        @Field(1)
        public int depth() {
            return this.io.getIntField(this, 1);
        }

        /** of pix (1, 2, 4 or 8 bpp) */
        @Field(1)
        public PixColormap depth(int depth) {
            this.io.setIntField(this, 1, depth);
            return this;
        }

        /** number of color entries allocated */
        @Field(2)
        public int nalloc() {
            return this.io.getIntField(this, 2);
        }

        /** number of color entries allocated */
        @Field(2)
        public PixColormap nalloc(int nalloc) {
            this.io.setIntField(this, 2, nalloc);
            return this;
        }

        /** number of color entries used */
        @Field(3)
        public int n() {
            return this.io.getIntField(this, 3);
        }

        /** number of color entries used */
        @Field(3)
        public PixColormap n(int n) {
            this.io.setIntField(this, 3, n);
            return this;
        }

        public PixColormap() {
            super();
        }

        public PixColormap(Pointer<PixColormap> pointer) {
            super(pointer);
        }
    }

    /** Undefined type */
    public static interface FILE {

    };

    /** Undefined type */
    public static interface ETEXT_DESC {
        // TODO implement to be able to
    };

    /** Undefined type */
    public static interface TessPageIterator {

    };

    /** Undefined type */
    public static interface TessMutableIterator {

    };

    /** Undefined type */
    public static interface TessResultIterator {

    };

    /** Undefined type */
    public static interface Pixa {

    };

    /** Undefined type */
    public static interface TessResultRenderer {

    };

    /** Undefined type */
    public static interface TessChoiceIterator {

    };
}
