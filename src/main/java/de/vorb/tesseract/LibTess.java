package de.vorb.tesseract;

import java.util.Collections;
import java.util.Iterator;

import org.bridj.BridJ;
import org.bridj.CRuntime;
import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Name;
import org.bridj.ann.Ptr;
import org.bridj.ann.Runtime;
import org.bridj.util.DefaultParameterizedType;

import de.vorb.leptonica.Boxa;
import de.vorb.leptonica.Pix;
import de.vorb.leptonica.Pixa;

@Library("tesseract")
@Runtime(CRuntime.class)
public class LibTess {
    static {
        BridJ.register();
    }

    /**
     * enum values<br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h</i>
     */
    public enum TessOcrEngineMode implements IntValuedEnum<TessOcrEngineMode> {
        OEM_TESSERACT_ONLY(0),
        OEM_CUBE_ONLY(1),
        OEM_TESSERACT_CUBE_COMBINED(2),
        OEM_DEFAULT(3);
        TessOcrEngineMode(long value) {
            this.value = value;
        }

        public final long value;

        public long value() {
            return this.value;
        }

        public Iterator<TessOcrEngineMode> iterator() {
            return Collections.singleton(this).iterator();
        }

        public static IntValuedEnum<TessOcrEngineMode> fromValue(int value) {
            return FlagSet.fromValue(value, values());
        }
    };

    /**
     * enum values<br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h</i>
     */
    public enum TessPageSegMode implements IntValuedEnum<TessPageSegMode> {
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
        TessPageSegMode(long value) {
            this.value = value;
        }

        public final long value;

        public long value() {
            return this.value;
        }

        public Iterator<TessPageSegMode> iterator() {
            return Collections.singleton(this).iterator();
        }

        public static IntValuedEnum<TessPageSegMode> fromValue(int value) {
            return FlagSet.fromValue(value, values());
        }
    };

    /**
     * enum values<br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h</i>
     */
    public enum TessPageIteratorLevel implements
            IntValuedEnum<TessPageIteratorLevel> {
        RIL_BLOCK(0),
        RIL_PARA(1),
        RIL_TEXTLINE(2),
        RIL_WORD(3),
        RIL_SYMBOL(4);
        TessPageIteratorLevel(long value) {
            this.value = value;
        }

        public final long value;

        public long value() {
            return this.value;
        }

        public Iterator<TessPageIteratorLevel> iterator() {
            return Collections.singleton(this).iterator();
        }

        public static IntValuedEnum<TessPageIteratorLevel> fromValue(int value) {
            return FlagSet.fromValue(value, values());
        }
    };

    /**
     * enum values<br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h</i>
     */
    public enum TessPolyBlockType implements IntValuedEnum<TessPolyBlockType> {
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
        TessPolyBlockType(long value) {
            this.value = value;
        }

        public final long value;

        public long value() {
            return this.value;
        }

        public Iterator<TessPolyBlockType> iterator() {
            return Collections.singleton(this).iterator();
        }

        public static IntValuedEnum<TessPolyBlockType> fromValue(int value) {
            return FlagSet.fromValue(value, values());
        }
    };

    /**
     * enum values<br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h</i>
     */
    public enum TessOrientation implements IntValuedEnum<TessOrientation> {
        ORIENTATION_PAGE_UP(0),
        ORIENTATION_PAGE_RIGHT(1),
        ORIENTATION_PAGE_DOWN(2),
        ORIENTATION_PAGE_LEFT(3);
        TessOrientation(long value) {
            this.value = value;
        }

        public final long value;

        public long value() {
            return this.value;
        }

        public Iterator<TessOrientation> iterator() {
            return Collections.singleton(this).iterator();
        }

        public static IntValuedEnum<TessOrientation> fromValue(int value) {
            return FlagSet.fromValue(value, values());
        }
    };

    /**
     * enum values<br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h</i>
     */
    public enum TessWritingDirection implements
            IntValuedEnum<TessWritingDirection> {
        WRITING_DIRECTION_LEFT_TO_RIGHT(0),
        WRITING_DIRECTION_RIGHT_TO_LEFT(1),
        WRITING_DIRECTION_TOP_TO_BOTTOM(2);
        TessWritingDirection(long value) {
            this.value = value;
        }

        public final long value;

        public long value() {
            return this.value;
        }

        public Iterator<TessWritingDirection> iterator() {
            return Collections.singleton(this).iterator();
        }

        public static IntValuedEnum<TessWritingDirection> fromValue(int value) {
            return FlagSet.fromValue(value, values());
        }
    };

    /**
     * enum values<br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h</i>
     */
    public enum TessTextlineOrder implements IntValuedEnum<TessTextlineOrder> {
        TEXTLINE_ORDER_LEFT_TO_RIGHT(0),
        TEXTLINE_ORDER_RIGHT_TO_LEFT(1),
        TEXTLINE_ORDER_TOP_TO_BOTTOM(2);
        TessTextlineOrder(long value) {
            this.value = value;
        }

        public final long value;

        public long value() {
            return this.value;
        }

        public Iterator<TessTextlineOrder> iterator() {
            return Collections.singleton(this).iterator();
        }

        public static IntValuedEnum<TessTextlineOrder> fromValue(int value) {
            return FlagSet.fromValue(value, values());
        }
    };

    /**
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h</i>
     */
    public static final int TRUE = 1;
    /**
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h</i>
     */
    public static final int FALSE = 0;

    /**
     * General free functions<br>
     * Original signature : <code>char* TessVersion()</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:79</i>
     */
    public static Pointer<Byte> TessVersion() {
        return (Pointer) Pointer.pointerToAddress(TessVersion$2(), Byte.class);
    }

    @Ptr
    @Name("TessVersion")
    protected native static long TessVersion$2();

    /**
     * Original signature : <code>void TessDeleteText(char*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:81</i>
     */
    public static void TessDeleteText(Pointer<Byte> text) {
        TessDeleteText(Pointer.getPeer(text));
    }

    protected native static void TessDeleteText(@Ptr long text);

    /**
     * Original signature : <code>void TessDeleteTextArray(char**)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:82</i>
     */
    public static void TessDeleteTextArray(Pointer<Pointer<Byte>> arr) {
        TessDeleteTextArray(Pointer.getPeer(arr));
    }

    protected native static void TessDeleteTextArray(@Ptr long arr);

    /**
     * Original signature : <code>void TessDeleteIntArray(int*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:83</i>
     */
    public static void TessDeleteIntArray(Pointer<Integer> arr) {
        TessDeleteIntArray(Pointer.getPeer(arr));
    }

    protected native static void TessDeleteIntArray(@Ptr long arr);

    /**
     * Renderer API<br>
     * Original signature :
     * <code>TessResultRenderer* TessTextRendererCreate()</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:89</i>
     */
    public static Pointer<LibTess.TessResultRenderer> TessTextRendererCreate() {
        return (Pointer) Pointer.pointerToAddress(TessTextRendererCreate$2(),
                LibTess.TessResultRenderer.class);
    }

    @Ptr
    @Name("TessTextRendererCreate")
    protected native static long TessTextRendererCreate$2();

    /**
     * Original signature :
     * <code>TessResultRenderer* TessHOcrRendererCreate()</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:90</i>
     */
    public static Pointer<LibTess.TessResultRenderer> TessHOcrRendererCreate() {
        return (Pointer) Pointer.pointerToAddress(TessHOcrRendererCreate$2(),
                LibTess.TessResultRenderer.class);
    }

    @Ptr
    @Name("TessHOcrRendererCreate")
    protected native static long TessHOcrRendererCreate$2();

    /**
     * Original signature :
     * <code>TessResultRenderer* TessPDFRendererCreate(const char*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:91</i>
     */
    public static Pointer<LibTess.TessResultRenderer> TessPDFRendererCreate(
            Pointer<Byte> datadir) {
        return (Pointer) Pointer.pointerToAddress(
                TessPDFRendererCreate(Pointer.getPeer(datadir)),
                LibTess.TessResultRenderer.class);
    }

    @Ptr
    protected native static long TessPDFRendererCreate(@Ptr long datadir);

    /**
     * Original signature :
     * <code>TessResultRenderer* TessUnlvRendererCreate()</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:92</i>
     */
    public static Pointer<LibTess.TessResultRenderer> TessUnlvRendererCreate() {
        return (Pointer) Pointer.pointerToAddress(TessUnlvRendererCreate$2(),
                LibTess.TessResultRenderer.class);
    }

    @Ptr
    @Name("TessUnlvRendererCreate")
    protected native static long TessUnlvRendererCreate$2();

    /**
     * Original signature :
     * <code>TessResultRenderer* TessBoxTextRendererCreate()</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:93</i>
     */
    public static Pointer<LibTess.TessResultRenderer> TessBoxTextRendererCreate() {
        return (Pointer) Pointer.pointerToAddress(
                TessBoxTextRendererCreate$2(),
                LibTess.TessResultRenderer.class);
    }

    @Ptr
    @Name("TessBoxTextRendererCreate")
    protected native static long TessBoxTextRendererCreate$2();

    /**
     * Original signature :
     * <code>void TessDeleteResultRenderer(TessResultRenderer*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:95</i>
     */
    public static void TessDeleteResultRenderer(
            Pointer<LibTess.TessResultRenderer> renderer) {
        TessDeleteResultRenderer(Pointer.getPeer(renderer));
    }

    protected native static void TessDeleteResultRenderer(@Ptr long renderer);

    /**
     * Original signature :
     * <code>void TessResultRendererInsert(TessResultRenderer*, TessResultRenderer*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:96</i>
     */
    public static void TessResultRendererInsert(
            Pointer<LibTess.TessResultRenderer> renderer,
            Pointer<LibTess.TessResultRenderer> next) {
        TessResultRendererInsert(Pointer.getPeer(renderer),
                Pointer.getPeer(next));
    }

    protected native static void TessResultRendererInsert(@Ptr long renderer,
            @Ptr long next);

    /**
     * Original signature :
     * <code>TessResultRenderer* TessResultRendererNext(TessResultRenderer*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:97</i>
     */
    public static Pointer<LibTess.TessResultRenderer> TessResultRendererNext(
            Pointer<LibTess.TessResultRenderer> renderer) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultRendererNext(Pointer.getPeer(renderer)),
                LibTess.TessResultRenderer.class);
    }

    @Ptr
    protected native static long TessResultRendererNext(@Ptr long renderer);

    /**
     * Original signature :
     * <code>int TessResultRendererBeginDocument(TessResultRenderer*, const char*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:99</i>
     */
    public static int TessResultRendererBeginDocument(
            Pointer<LibTess.TessResultRenderer> renderer,
            Pointer<Byte> title) {
        return TessResultRendererBeginDocument(Pointer.getPeer(renderer),
                Pointer.getPeer(title));
    }

    protected native static int TessResultRendererBeginDocument(
            @Ptr long renderer, @Ptr long title);

    /**
     * Original signature :
     * <code>int TessResultRendererAddImage(TessResultRenderer*, TessBaseAPI*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:100</i>
     */
    public static int TessResultRendererAddImage(
            Pointer<LibTess.TessResultRenderer> renderer,
            Pointer<LibTess.TessBaseAPI> api) {
        return TessResultRendererAddImage(Pointer.getPeer(renderer),
                Pointer.getPeer(api));
    }

    protected native static int TessResultRendererAddImage(@Ptr long renderer,
            @Ptr long api);

    /**
     * Original signature :
     * <code>int TessResultRendererAddError(TessResultRenderer*, TessBaseAPI*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:101</i>
     */
    public static int TessResultRendererAddError(
            Pointer<LibTess.TessResultRenderer> renderer,
            Pointer<LibTess.TessBaseAPI> api) {
        return TessResultRendererAddError(Pointer.getPeer(renderer),
                Pointer.getPeer(api));
    }

    protected native static int TessResultRendererAddError(@Ptr long renderer,
            @Ptr long api);

    /**
     * Original signature :
     * <code>int TessResultRendererEndDocument(TessResultRenderer*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:102</i>
     */
    public static int TessResultRendererEndDocument(
            Pointer<LibTess.TessResultRenderer> renderer) {
        return TessResultRendererEndDocument(Pointer.getPeer(renderer));
    }

    protected native static int TessResultRendererEndDocument(@Ptr long renderer);

    /**
     * Original signature :
     * <code>int TessResultRendererGetOutput(TessResultRenderer*, const char**, int*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:103</i>
     */
    public static int TessResultRendererGetOutput(
            Pointer<LibTess.TessResultRenderer> renderer,
            Pointer<Pointer<Byte>> data, Pointer<Integer> data_len) {
        return TessResultRendererGetOutput(Pointer.getPeer(renderer),
                Pointer.getPeer(data), Pointer.getPeer(data_len));
    }

    protected native static int TessResultRendererGetOutput(@Ptr long renderer,
            @Ptr long data, @Ptr long data_len);

    /**
     * Original signature :
     * <code>char* TessResultRendererTypename(TessResultRenderer*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:105</i>
     */
    public static Pointer<Byte> TessResultRendererTypename(
            Pointer<LibTess.TessResultRenderer> renderer) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultRendererTypename(Pointer.getPeer(renderer)),
                Byte.class);
    }

    @Ptr
    protected native static long TessResultRendererTypename(@Ptr long renderer);

    /**
     * Original signature :
     * <code>char* TessResultRendererExtention(TessResultRenderer*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:106</i>
     */
    public static Pointer<Byte> TessResultRendererExtention(
            Pointer<LibTess.TessResultRenderer> renderer) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultRendererExtention(Pointer.getPeer(renderer)),
                Byte.class);
    }

    @Ptr
    protected native static long TessResultRendererExtention(@Ptr long renderer);

    /**
     * Original signature :
     * <code>char* TessResultRendererTitle(TessResultRenderer*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:107</i>
     */
    public static Pointer<Byte> TessResultRendererTitle(
            Pointer<LibTess.TessResultRenderer> renderer) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultRendererTitle(Pointer.getPeer(renderer)), Byte.class);
    }

    @Ptr
    protected native static long TessResultRendererTitle(@Ptr long renderer);

    /**
     * Original signature :
     * <code>int TessResultRendererImageNum(TessResultRenderer*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:108</i>
     */
    public static int TessResultRendererImageNum(
            Pointer<LibTess.TessResultRenderer> renderer) {
        return TessResultRendererImageNum(Pointer.getPeer(renderer));
    }

    protected native static int TessResultRendererImageNum(@Ptr long renderer);

    /**
     * Base API<br>
     * Original signature : <code>TessBaseAPI* TessBaseAPICreate()</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:112</i>
     */
    public static Pointer<LibTess.TessBaseAPI> TessBaseAPICreate() {
        return (Pointer) Pointer.pointerToAddress(TessBaseAPICreate$2(),
                LibTess.TessBaseAPI.class);
    }

    @Ptr
    @Name("TessBaseAPICreate")
    protected native static long TessBaseAPICreate$2();

    /**
     * Original signature : <code>void TessBaseAPIDelete(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:114</i>
     */
    public static void TessBaseAPIDelete(
            Pointer<LibTess.TessBaseAPI> handle) {
        TessBaseAPIDelete(Pointer.getPeer(handle));
    }

    protected native static void TessBaseAPIDelete(@Ptr long handle);

    /**
     * Original signature :
     * <code>size_t TessBaseAPIGetOpenCLDevice(TessBaseAPI*, void**)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:116</i>
     */
    @Ptr
    public static long TessBaseAPIGetOpenCLDevice(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pointer<?>> device) {
        return TessBaseAPIGetOpenCLDevice(Pointer.getPeer(handle),
                Pointer.getPeer(device));
    }

    @Ptr
    protected native static long TessBaseAPIGetOpenCLDevice(@Ptr long handle,
            @Ptr long device);

    /**
     * Original signature :
     * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:118</i>
     */
    public static void TessBaseAPISetInputName(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> name) {
        TessBaseAPISetInputName(Pointer.getPeer(handle), Pointer.getPeer(name));
    }

    protected native static void TessBaseAPISetInputName(@Ptr long handle,
            @Ptr long name);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetInputName(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:119</i>
     */
    public static Pointer<Byte> TessBaseAPIGetInputName(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetInputName(Pointer.getPeer(handle)), Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetInputName(@Ptr long handle);

    /**
     * Original signature :
     * <code>void TessBaseAPISetInputImage(TessBaseAPI*, Pix*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:121</i>
     */
    public static void TessBaseAPISetInputImage(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pix> pix) {
        TessBaseAPISetInputImage(Pointer.getPeer(handle), Pointer.getPeer(pix));
    }

    protected native static void TessBaseAPISetInputImage(@Ptr long handle,
            @Ptr long pix);

    /**
     * Original signature :
     * <code>Pix* TessBaseAPIGetInputImage(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:122</i>
     */
    public static Pointer<Pix> TessBaseAPIGetInputImage(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetInputImage(Pointer.getPeer(handle)),
                Pix.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetInputImage(@Ptr long handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetSourceYResolution(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:124</i>
     */
    public static int TessBaseAPIGetSourceYResolution(
            Pointer<LibTess.TessBaseAPI> handle) {
        return TessBaseAPIGetSourceYResolution(Pointer.getPeer(handle));
    }

    protected native static int TessBaseAPIGetSourceYResolution(@Ptr long handle);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetDatapath(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:125</i>
     */
    public static Pointer<Byte> TessBaseAPIGetDatapath(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetDatapath(Pointer.getPeer(handle)), Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetDatapath(@Ptr long handle);

    /**
     * Original signature :
     * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:127</i>
     */
    public static void TessBaseAPISetOutputName(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> name) {
        TessBaseAPISetOutputName(Pointer.getPeer(handle), Pointer.getPeer(name));
    }

    protected native static void TessBaseAPISetOutputName(@Ptr long handle,
            @Ptr long name);

    /**
     * Original signature :
     * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:129</i>
     */
    public static int TessBaseAPISetVariable(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Byte> value) {
        return TessBaseAPISetVariable(Pointer.getPeer(handle),
                Pointer.getPeer(name), Pointer.getPeer(value));
    }

    protected native static int TessBaseAPISetVariable(@Ptr long handle,
            @Ptr long name, @Ptr long value);

    /**
     * Original signature :
     * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:130</i>
     */
    public static int TessBaseAPISetDebugVariable(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Byte> value) {
        return TessBaseAPISetDebugVariable(Pointer.getPeer(handle),
                Pointer.getPeer(name), Pointer.getPeer(value));
    }

    protected native static int TessBaseAPISetDebugVariable(@Ptr long handle,
            @Ptr long name, @Ptr long value);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:132</i>
     */
    public static int TessBaseAPIGetIntVariable(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Integer> value) {
        return TessBaseAPIGetIntVariable(Pointer.getPeer(handle),
                Pointer.getPeer(name), Pointer.getPeer(value));
    }

    protected native static int TessBaseAPIGetIntVariable(@Ptr long handle,
            @Ptr long name, @Ptr long value);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:133</i>
     */
    public static int TessBaseAPIGetBoolVariable(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Integer> value) {
        return TessBaseAPIGetBoolVariable(Pointer.getPeer(handle),
                Pointer.getPeer(name), Pointer.getPeer(value));
    }

    protected native static int TessBaseAPIGetBoolVariable(@Ptr long handle,
            @Ptr long name, @Ptr long value);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:134</i>
     */
    public static int TessBaseAPIGetDoubleVariable(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> name,
            Pointer<Double> value) {
        return TessBaseAPIGetDoubleVariable(Pointer.getPeer(handle),
                Pointer.getPeer(name), Pointer.getPeer(value));
    }

    protected native static int TessBaseAPIGetDoubleVariable(@Ptr long handle,
            @Ptr long name, @Ptr long value);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:135</i>
     */
    public static Pointer<Byte> TessBaseAPIGetStringVariable(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> name) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetStringVariable(Pointer.getPeer(handle),
                        Pointer.getPeer(name)), Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetStringVariable(@Ptr long handle,
            @Ptr long name);

    /**
     * Original signature :
     * <code>void TessBaseAPIPrintVariables(const TessBaseAPI*, FILE*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:138</i>
     */
    public static void TessBaseAPIPrintVariables(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<LibTess.FILE> fp) {
        TessBaseAPIPrintVariables(Pointer.getPeer(handle), Pointer.getPeer(fp));
    }

    protected native static void TessBaseAPIPrintVariables(@Ptr long handle,
            @Ptr long fp);

    /**
     * Original signature :
     * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:139</i>
     */
    public static int TessBaseAPIPrintVariablesToFile(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> filename) {
        return TessBaseAPIPrintVariablesToFile(Pointer.getPeer(handle),
                Pointer.getPeer(filename));
    }

    protected native static int TessBaseAPIPrintVariablesToFile(
            @Ptr long handle, @Ptr long filename);

    /**
     * Original signature :
     * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:150</i>
     */
    public static int TessBaseAPIInit1(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Byte> datapath, Pointer<Byte> language,
            IntValuedEnum<LibTess.TessOcrEngineMode> oem,
            Pointer<Pointer<Byte>> configs, int configs_size) {
        return TessBaseAPIInit1(Pointer.getPeer(handle),
                Pointer.getPeer(datapath), Pointer.getPeer(language),
                (int) oem.value(), Pointer.getPeer(configs), configs_size);
    }

    protected native static int TessBaseAPIInit1(@Ptr long handle,
            @Ptr long datapath, @Ptr long language, int oem, @Ptr long configs,
            int configs_size);

    /**
     * Original signature :
     * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:152</i>
     */
    public static int TessBaseAPIInit2(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Byte> datapath, Pointer<Byte> language,
            IntValuedEnum<LibTess.TessOcrEngineMode> oem) {
        return TessBaseAPIInit2(Pointer.getPeer(handle),
                Pointer.getPeer(datapath), Pointer.getPeer(language),
                (int) oem.value());
    }

    protected native static int TessBaseAPIInit2(@Ptr long handle,
            @Ptr long datapath, @Ptr long language, int oem);

    /**
     * Original signature :
     * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:153</i>
     */
    public static int TessBaseAPIInit3(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Byte> datapath, Pointer<Byte> language) {
        return TessBaseAPIInit3(Pointer.getPeer(handle),
                Pointer.getPeer(datapath), Pointer.getPeer(language));
    }

    protected native static int TessBaseAPIInit3(@Ptr long handle,
            @Ptr long datapath, @Ptr long language);

    /**
     * Original signature :
     * <code>int TessBaseAPIInit4(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int, char**, char**, size_t, int)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:155</i>
     */
    public static int TessBaseAPIInit4(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Byte> datapath, Pointer<Byte> language,
            IntValuedEnum<LibTess.TessOcrEngineMode> mode,
            Pointer<Pointer<Byte>> configs, int configs_size,
            Pointer<Pointer<Byte>> vars_vec,
            Pointer<Pointer<Byte>> vars_values, @Ptr long vars_vec_size,
            int set_only_non_debug_params) {
        return TessBaseAPIInit4(Pointer.getPeer(handle),
                Pointer.getPeer(datapath), Pointer.getPeer(language),
                (int) mode.value(), Pointer.getPeer(configs), configs_size,
                Pointer.getPeer(vars_vec), Pointer.getPeer(vars_values),
                vars_vec_size, set_only_non_debug_params);
    }

    protected native static int TessBaseAPIInit4(@Ptr long handle,
            @Ptr long datapath, @Ptr long language, int mode,
            @Ptr long configs, int configs_size, @Ptr long vars_vec,
            @Ptr long vars_values, @Ptr long vars_vec_size,
            int set_only_non_debug_params);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetInitLanguagesAsString(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:160</i>
     */
    public static Pointer<Byte> TessBaseAPIGetInitLanguagesAsString(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetInitLanguagesAsString(Pointer.getPeer(handle)),
                Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetInitLanguagesAsString(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>char** TessBaseAPIGetLoadedLanguagesAsVector(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:162</i>
     */
    public static Pointer<Pointer<Byte>> TessBaseAPIGetLoadedLanguagesAsVector(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetLoadedLanguagesAsVector(Pointer.getPeer(handle)),
                DefaultParameterizedType.paramType(Pointer.class, Byte.class));
    }

    @Ptr
    protected native static long TessBaseAPIGetLoadedLanguagesAsVector(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>char** TessBaseAPIGetAvailableLanguagesAsVector(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:164</i>
     */
    public static Pointer<Pointer<Byte>> TessBaseAPIGetAvailableLanguagesAsVector(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetAvailableLanguagesAsVector(Pointer.getPeer(handle)),
                DefaultParameterizedType.paramType(Pointer.class, Byte.class));
    }

    @Ptr
    protected native static long TessBaseAPIGetAvailableLanguagesAsVector(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:167</i>
     */
    public static int TessBaseAPIInitLangMod(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Byte> datapath, Pointer<Byte> language) {
        return TessBaseAPIInitLangMod(Pointer.getPeer(handle),
                Pointer.getPeer(datapath), Pointer.getPeer(language));
    }

    protected native static int TessBaseAPIInitLangMod(@Ptr long handle,
            @Ptr long datapath, @Ptr long language);

    /**
     * Original signature :
     * <code>void TessBaseAPIInitForAnalysePage(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:168</i>
     */
    public static void TessBaseAPIInitForAnalysePage(
            Pointer<LibTess.TessBaseAPI> handle) {
        TessBaseAPIInitForAnalysePage(Pointer.getPeer(handle));
    }

    protected native static void TessBaseAPIInitForAnalysePage(@Ptr long handle);

    /**
     * Original signature :
     * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:170</i>
     */
    public static void TessBaseAPIReadConfigFile(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> filename) {
        TessBaseAPIReadConfigFile(Pointer.getPeer(handle),
                Pointer.getPeer(filename));
    }

    protected native static void TessBaseAPIReadConfigFile(@Ptr long handle,
            @Ptr long filename);

    /**
     * Original signature :
     * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:171</i>
     */
    public static void TessBaseAPIReadDebugConfigFile(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> filename) {
        TessBaseAPIReadDebugConfigFile(Pointer.getPeer(handle),
                Pointer.getPeer(filename));
    }

    protected native static void TessBaseAPIReadDebugConfigFile(
            @Ptr long handle, @Ptr long filename);

    /**
     * Original signature :
     * <code>void TessBaseAPISetPageSegMode(TessBaseAPI*, TessPageSegMode)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:173</i>
     */
    public static void TessBaseAPISetPageSegMode(
            Pointer<LibTess.TessBaseAPI> handle,
            IntValuedEnum<LibTess.TessPageSegMode> mode) {
        TessBaseAPISetPageSegMode(Pointer.getPeer(handle), (int) mode.value());
    }

    protected native static void TessBaseAPISetPageSegMode(@Ptr long handle,
            int mode);

    /**
     * Original signature :
     * <code>TessPageSegMode TessBaseAPIGetPageSegMode(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:174</i>
     */
    public static IntValuedEnum<LibTess.TessPageSegMode> TessBaseAPIGetPageSegMode(
            Pointer<LibTess.TessBaseAPI> handle) {
        return FlagSet.fromValue(
                TessBaseAPIGetPageSegMode(Pointer.getPeer(handle)),
                LibTess.TessPageSegMode.class);
    }

    protected native static int TessBaseAPIGetPageSegMode(@Ptr long handle);

    /**
     * Original signature :
     * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:177</i>
     */
    public static Pointer<Byte> TessBaseAPIRect(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Byte> imagedata, int bytes_per_pixel, int bytes_per_line,
            int left, int top, int width, int height) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIRect(Pointer.getPeer(handle),
                        Pointer.getPeer(imagedata), bytes_per_pixel,
                        bytes_per_line, left, top, width, height), Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIRect(@Ptr long handle,
            @Ptr long imagedata, int bytes_per_pixel, int bytes_per_line,
            int left, int top, int width, int height);

    /**
     * Original signature :
     * <code>void TessBaseAPIClearAdaptiveClassifier(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:181</i>
     */
    public static void TessBaseAPIClearAdaptiveClassifier(
            Pointer<LibTess.TessBaseAPI> handle) {
        TessBaseAPIClearAdaptiveClassifier(Pointer.getPeer(handle));
    }

    protected native static void TessBaseAPIClearAdaptiveClassifier(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:183</i>
     */
    public static void TessBaseAPISetImage(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Byte> imagedata, int width, int height,
            int bytes_per_pixel, int bytes_per_line) {
        TessBaseAPISetImage(Pointer.getPeer(handle),
                Pointer.getPeer(imagedata), width, height, bytes_per_pixel,
                bytes_per_line);
    }

    protected native static void TessBaseAPISetImage(@Ptr long handle,
            @Ptr long imagedata, int width, int height, int bytes_per_pixel,
            int bytes_per_line);

    /**
     * Original signature :
     * <code>void TessBaseAPISetImage2(TessBaseAPI*, Pix*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:185</i>
     */
    public static void TessBaseAPISetImage2(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pix> pix) {
        TessBaseAPISetImage2(Pointer.getPeer(handle), Pointer.getPeer(pix));
    }

    protected native static void TessBaseAPISetImage2(@Ptr long handle,
            @Ptr long pix);

    /**
     * Original signature :
     * <code>void TessBaseAPISetSourceResolution(TessBaseAPI*, int)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:187</i>
     */
    public static void TessBaseAPISetSourceResolution(
            Pointer<LibTess.TessBaseAPI> handle, int ppi) {
        TessBaseAPISetSourceResolution(Pointer.getPeer(handle), ppi);
    }

    protected native static void TessBaseAPISetSourceResolution(
            @Ptr long handle, int ppi);

    /**
     * Original signature :
     * <code>void TessBaseAPISetRectangle(TessBaseAPI*, int, int, int, int)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:189</i>
     */
    public static void TessBaseAPISetRectangle(
            Pointer<LibTess.TessBaseAPI> handle, int left, int top,
            int width, int height) {
        TessBaseAPISetRectangle(Pointer.getPeer(handle), left, top, width,
                height);
    }

    protected native static void TessBaseAPISetRectangle(@Ptr long handle,
            int left, int top, int width, int height);

    /**
     * Original signature :
     * <code>Pix* TessBaseAPIGetThresholdedImage(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:195</i>
     */
    public static Pointer<Pix> TessBaseAPIGetThresholdedImage(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetThresholdedImage(Pointer.getPeer(handle)),
                Pix.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetThresholdedImage(@Ptr long handle);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetRegions(TessBaseAPI*, Pixa**)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:197</i>
     */
    public static Pointer<Boxa> TessBaseAPIGetRegions(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pointer<Pixa>> pixa) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetRegions(Pointer.getPeer(handle),
                        Pointer.getPeer(pixa)), Boxa.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetRegions(@Ptr long handle,
            @Ptr long pixa);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetTextlines(TessBaseAPI*, Pixa**, int**)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:199</i>
     */
    public static Pointer<Boxa> TessBaseAPIGetTextlines(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pointer<Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetTextlines(Pointer.getPeer(handle),
                        Pointer.getPeer(pixa), Pointer.getPeer(blockids)),
                Boxa.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetTextlines(@Ptr long handle,
            @Ptr long pixa, @Ptr long blockids);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetTextlines1(TessBaseAPI*, const int, const int, Pixa**, int**, int**)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:201</i>
     */
    public static Pointer<Boxa> TessBaseAPIGetTextlines1(
            Pointer<LibTess.TessBaseAPI> handle, int raw_image,
            int raw_padding, Pointer<Pointer<Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids,
            Pointer<Pointer<Integer>> paraids) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetTextlines1(Pointer.getPeer(handle), raw_image,
                        raw_padding, Pointer.getPeer(pixa),
                        Pointer.getPeer(blockids), Pointer.getPeer(paraids)),
                Boxa.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetTextlines1(@Ptr long handle,
            int raw_image, int raw_padding, @Ptr long pixa, @Ptr long blockids,
            @Ptr long paraids);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetStrips(TessBaseAPI*, Pixa**, int**)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:204</i>
     */
    public static Pointer<Boxa> TessBaseAPIGetStrips(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pointer<Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetStrips(Pointer.getPeer(handle),
                        Pointer.getPeer(pixa), Pointer.getPeer(blockids)),
                Boxa.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetStrips(@Ptr long handle,
            @Ptr long pixa, @Ptr long blockids);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetWords(TessBaseAPI*, Pixa**)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:206</i>
     */
    public static Pointer<Boxa> TessBaseAPIGetWords(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pointer<Pixa>> pixa) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetWords(Pointer.getPeer(handle),
                        Pointer.getPeer(pixa)), Boxa.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetWords(@Ptr long handle,
            @Ptr long pixa);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetConnectedComponents(TessBaseAPI*, Pixa**)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:208</i>
     */
    public static Pointer<Boxa> TessBaseAPIGetConnectedComponents(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pointer<Pixa>> cc) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetConnectedComponents(Pointer.getPeer(handle),
                        Pointer.getPeer(cc)), Boxa.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetConnectedComponents(
            @Ptr long handle, @Ptr long cc);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetComponentImages(TessBaseAPI*, const TessPageIteratorLevel, const int, Pixa**, int**)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:210</i>
     */
    public static Pointer<Boxa> TessBaseAPIGetComponentImages(
            Pointer<LibTess.TessBaseAPI> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level,
            int text_only, Pointer<Pointer<Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetComponentImages(Pointer.getPeer(handle),
                        (int) level.value(), text_only, Pointer.getPeer(pixa),
                        Pointer.getPeer(blockids)), Boxa.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetComponentImages(
            @Ptr long handle, int level, int text_only, @Ptr long pixa,
            @Ptr long blockids);

    /**
     * Original signature :
     * <code>Boxa* TessBaseAPIGetComponentImages1(TessBaseAPI*, const TessPageIteratorLevel, const int, const int, const int, Pixa**, int**, int**)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:213</i>
     */
    public static Pointer<Boxa> TessBaseAPIGetComponentImages1(
            Pointer<LibTess.TessBaseAPI> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level,
            int text_only, int raw_image, int raw_padding,
            Pointer<Pointer<Pixa>> pixa,
            Pointer<Pointer<Integer>> blockids,
            Pointer<Pointer<Integer>> paraids) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetComponentImages1(Pointer.getPeer(handle),
                        (int) level.value(), text_only, raw_image, raw_padding,
                        Pointer.getPeer(pixa), Pointer.getPeer(blockids),
                        Pointer.getPeer(paraids)), Boxa.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetComponentImages1(
            @Ptr long handle, int level, int text_only, int raw_image,
            int raw_padding, @Ptr long pixa, @Ptr long blockids,
            @Ptr long paraids);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetThresholdedImageScaleFactor(const TessBaseAPI*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:218</i>
     */
    public static int TessBaseAPIGetThresholdedImageScaleFactor(
            Pointer<LibTess.TessBaseAPI> handle) {
        return TessBaseAPIGetThresholdedImageScaleFactor(Pointer.getPeer(handle));
    }

    protected native static int TessBaseAPIGetThresholdedImageScaleFactor(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:220</i>
     */
    public static void TessBaseAPIDumpPGM(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> filename) {
        TessBaseAPIDumpPGM(Pointer.getPeer(handle), Pointer.getPeer(filename));
    }

    protected native static void TessBaseAPIDumpPGM(@Ptr long handle,
            @Ptr long filename);

    /**
     * Original signature :
     * <code>TessPageIterator* TessBaseAPIAnalyseLayout(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:222</i>
     */
    public static Pointer<LibTess.TessPageIterator> TessBaseAPIAnalyseLayout(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIAnalyseLayout(Pointer.getPeer(handle)),
                LibTess.TessPageIterator.class);
    }

    @Ptr
    protected native static long TessBaseAPIAnalyseLayout(@Ptr long handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIRecognize(TessBaseAPI*, ETEXT_DESC*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:225</i>
     */
    public static int TessBaseAPIRecognize(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<LibTess.ETEXT_DESC> monitor) {
        return TessBaseAPIRecognize(Pointer.getPeer(handle),
                Pointer.getPeer(monitor));
    }

    protected native static int TessBaseAPIRecognize(@Ptr long handle,
            @Ptr long monitor);

    /**
     * Original signature :
     * <code>int TessBaseAPIRecognizeForChopTest(TessBaseAPI*, ETEXT_DESC*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:226</i>
     */
    public static int TessBaseAPIRecognizeForChopTest(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<LibTess.ETEXT_DESC> monitor) {
        return TessBaseAPIRecognizeForChopTest(Pointer.getPeer(handle),
                Pointer.getPeer(monitor));
    }

    protected native static int TessBaseAPIRecognizeForChopTest(
            @Ptr long handle, @Ptr long monitor);

    /**
     * Original signature :
     * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:227</i>
     */
    public static Pointer<Byte> TessBaseAPIProcessPages(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Byte> filename, Pointer<Byte> retry_config,
            int timeout_millisec) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIProcessPages(Pointer.getPeer(handle),
                        Pointer.getPeer(filename),
                        Pointer.getPeer(retry_config), timeout_millisec),
                Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIProcessPages(@Ptr long handle,
            @Ptr long filename, @Ptr long retry_config, int timeout_millisec);

    /**
     * Original signature :
     * <code>int TessBaseAPIProcessPages1(TessBaseAPI*, const char*, const char*, int, TessResultRenderer*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:229</i>
     */
    public static int TessBaseAPIProcessPages1(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Byte> filename, Pointer<Byte> retry_config,
            int timeout_millisec,
            Pointer<LibTess.TessResultRenderer> renderer) {
        return TessBaseAPIProcessPages1(Pointer.getPeer(handle),
                Pointer.getPeer(filename), Pointer.getPeer(retry_config),
                timeout_millisec, Pointer.getPeer(renderer));
    }

    protected native static int TessBaseAPIProcessPages1(@Ptr long handle,
            @Ptr long filename, @Ptr long retry_config, int timeout_millisec,
            @Ptr long renderer);

    /**
     * Original signature :
     * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, Pix*, int, const char*, const char*, int)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:231</i>
     */
    public static Pointer<Byte> TessBaseAPIProcessPage(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pix> pix, int page_index,
            Pointer<Byte> filename, Pointer<Byte> retry_config,
            int timeout_millisec) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIProcessPage(Pointer.getPeer(handle),
                        Pointer.getPeer(pix), page_index,
                        Pointer.getPeer(filename),
                        Pointer.getPeer(retry_config), timeout_millisec),
                Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIProcessPage(@Ptr long handle,
            @Ptr long pix, int page_index, @Ptr long filename,
            @Ptr long retry_config, int timeout_millisec);

    /**
     * Original signature :
     * <code>int TessBaseAPIProcessPage1(TessBaseAPI*, Pix*, int, const char*, const char*, int, TessResultRenderer*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:233</i>
     */
    public static int TessBaseAPIProcessPage1(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Pix> pix, int page_index,
            Pointer<Byte> filename, Pointer<Byte> retry_config,
            int timeout_millisec,
            Pointer<LibTess.TessResultRenderer> renderer) {
        return TessBaseAPIProcessPage1(Pointer.getPeer(handle),
                Pointer.getPeer(pix), page_index, Pointer.getPeer(filename),
                Pointer.getPeer(retry_config), timeout_millisec,
                Pointer.getPeer(renderer));
    }

    protected native static int TessBaseAPIProcessPage1(@Ptr long handle,
            @Ptr long pix, int page_index, @Ptr long filename,
            @Ptr long retry_config, int timeout_millisec, @Ptr long renderer);

    /**
     * Original signature :
     * <code>TessResultIterator* TessBaseAPIGetIterator(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:236</i>
     */
    public static Pointer<LibTess.TessResultIterator> TessBaseAPIGetIterator(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetIterator(Pointer.getPeer(handle)),
                LibTess.TessResultIterator.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetIterator(@Ptr long handle);

    /**
     * Original signature :
     * <code>TessMutableIterator* TessBaseAPIGetMutableIterator(TessBaseAPI*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:238</i>
     */
    public static Pointer<LibTess.TessMutableIterator> TessBaseAPIGetMutableIterator(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetMutableIterator(Pointer.getPeer(handle)),
                LibTess.TessMutableIterator.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetMutableIterator(@Ptr long handle);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetUTF8Text(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:241</i>
     */
    public static Pointer<Byte> TessBaseAPIGetUTF8Text(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetUTF8Text(Pointer.getPeer(handle)), Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetUTF8Text(@Ptr long handle);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetHOCRText(TessBaseAPI*, int)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:242</i>
     */
    public static Pointer<Byte> TessBaseAPIGetHOCRText(
            Pointer<LibTess.TessBaseAPI> handle, int page_number) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetHOCRText(Pointer.getPeer(handle), page_number),
                Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetHOCRText(@Ptr long handle,
            int page_number);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetBoxText(TessBaseAPI*, int)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:243</i>
     */
    public static Pointer<Byte> TessBaseAPIGetBoxText(
            Pointer<LibTess.TessBaseAPI> handle, int page_number) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetBoxText(Pointer.getPeer(handle), page_number),
                Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetBoxText(@Ptr long handle,
            int page_number);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetUNLVText(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:244</i>
     */
    public static Pointer<Byte> TessBaseAPIGetUNLVText(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetUNLVText(Pointer.getPeer(handle)), Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetUNLVText(@Ptr long handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIMeanTextConf(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:245</i>
     */
    public static int TessBaseAPIMeanTextConf(
            Pointer<LibTess.TessBaseAPI> handle) {
        return TessBaseAPIMeanTextConf(Pointer.getPeer(handle));
    }

    protected native static int TessBaseAPIMeanTextConf(@Ptr long handle);

    /**
     * Original signature :
     * <code>int* TessBaseAPIAllWordConfidences(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:246</i>
     */
    public static Pointer<Integer> TessBaseAPIAllWordConfidences(
            Pointer<LibTess.TessBaseAPI> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIAllWordConfidences(Pointer.getPeer(handle)),
                Integer.class);
    }

    @Ptr
    protected native static long TessBaseAPIAllWordConfidences(@Ptr long handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:247</i>
     */
    public static int TessBaseAPIAdaptToWordStr(
            Pointer<LibTess.TessBaseAPI> handle,
            IntValuedEnum<LibTess.TessPageSegMode> mode,
            Pointer<Byte> wordstr) {
        return TessBaseAPIAdaptToWordStr(Pointer.getPeer(handle),
                (int) mode.value(), Pointer.getPeer(wordstr));
    }

    protected native static int TessBaseAPIAdaptToWordStr(@Ptr long handle,
            int mode, @Ptr long wordstr);

    /**
     * Original signature : <code>void TessBaseAPIClear(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:249</i>
     */
    public static void TessBaseAPIClear(
            Pointer<LibTess.TessBaseAPI> handle) {
        TessBaseAPIClear(Pointer.getPeer(handle));
    }

    protected native static void TessBaseAPIClear(@Ptr long handle);

    /**
     * Original signature : <code>void TessBaseAPIEnd(TessBaseAPI*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:250</i>
     */
    public static void TessBaseAPIEnd(
            Pointer<LibTess.TessBaseAPI> handle) {
        TessBaseAPIEnd(Pointer.getPeer(handle));
    }

    protected native static void TessBaseAPIEnd(@Ptr long handle);

    /**
     * Original signature :
     * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:252</i>
     */
    public static int TessBaseAPIIsValidWord(
            Pointer<LibTess.TessBaseAPI> handle, Pointer<Byte> word) {
        return TessBaseAPIIsValidWord(Pointer.getPeer(handle),
                Pointer.getPeer(word));
    }

    protected native static int TessBaseAPIIsValidWord(@Ptr long handle,
            @Ptr long word);

    /**
     * Original signature :
     * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:253</i>
     */
    public static int TessBaseAPIGetTextDirection(
            Pointer<LibTess.TessBaseAPI> handle,
            Pointer<Integer> out_offset, Pointer<Float> out_slope) {
        return TessBaseAPIGetTextDirection(Pointer.getPeer(handle),
                Pointer.getPeer(out_offset), Pointer.getPeer(out_slope));
    }

    protected native static int TessBaseAPIGetTextDirection(@Ptr long handle,
            @Ptr long out_offset, @Ptr long out_slope);

    /**
     * Original signature :
     * <code>char* TessBaseAPIGetUnichar(TessBaseAPI*, int)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:271</i>
     */
    public static Pointer<Byte> TessBaseAPIGetUnichar(
            Pointer<LibTess.TessBaseAPI> handle, int unichar_id) {
        return (Pointer) Pointer.pointerToAddress(
                TessBaseAPIGetUnichar(Pointer.getPeer(handle), unichar_id),
                Byte.class);
    }

    @Ptr
    protected native static long TessBaseAPIGetUnichar(@Ptr long handle,
            int unichar_id);

    /**
     * Original signature :
     * <code>void TessBaseAPISetMinOrientationMargin(TessBaseAPI*, double)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:294</i>
     */
    public static void TessBaseAPISetMinOrientationMargin(
            Pointer<LibTess.TessBaseAPI> handle, double margin) {
        TessBaseAPISetMinOrientationMargin(Pointer.getPeer(handle), margin);
    }

    protected native static void TessBaseAPISetMinOrientationMargin(
            @Ptr long handle, double margin);

    /**
     * Page iterator<br>
     * Original signature :
     * <code>void TessPageIteratorDelete(TessPageIterator*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:304</i>
     */
    public static void TessPageIteratorDelete(
            Pointer<LibTess.TessPageIterator> handle) {
        TessPageIteratorDelete(Pointer.getPeer(handle));
    }

    protected native static void TessPageIteratorDelete(@Ptr long handle);

    /**
     * Original signature :
     * <code>TessPageIterator* TessPageIteratorCopy(const TessPageIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:305</i>
     */
    public static Pointer<LibTess.TessPageIterator> TessPageIteratorCopy(
            Pointer<LibTess.TessPageIterator> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessPageIteratorCopy(Pointer.getPeer(handle)),
                LibTess.TessPageIterator.class);
    }

    @Ptr
    protected native static long TessPageIteratorCopy(@Ptr long handle);

    /**
     * Original signature :
     * <code>void TessPageIteratorBegin(TessPageIterator*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:308</i>
     */
    public static void TessPageIteratorBegin(
            Pointer<LibTess.TessPageIterator> handle) {
        TessPageIteratorBegin(Pointer.getPeer(handle));
    }

    protected native static void TessPageIteratorBegin(@Ptr long handle);

    /**
     * Original signature :
     * <code>int TessPageIteratorNext(TessPageIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:309</i>
     */
    public static int TessPageIteratorNext(
            Pointer<LibTess.TessPageIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level) {
        return TessPageIteratorNext(Pointer.getPeer(handle),
                (int) level.value());
    }

    protected native static int TessPageIteratorNext(@Ptr long handle, int level);

    /**
     * Original signature :
     * <code>int TessPageIteratorIsAtBeginningOf(const TessPageIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:310</i>
     */
    public static int TessPageIteratorIsAtBeginningOf(
            Pointer<LibTess.TessPageIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level) {
        return TessPageIteratorIsAtBeginningOf(Pointer.getPeer(handle),
                (int) level.value());
    }

    protected native static int TessPageIteratorIsAtBeginningOf(
            @Ptr long handle, int level);

    /**
     * Original signature :
     * <code>int TessPageIteratorIsAtFinalElement(const TessPageIterator*, TessPageIteratorLevel, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:311</i>
     */
    public static int TessPageIteratorIsAtFinalElement(
            Pointer<LibTess.TessPageIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level,
            IntValuedEnum<LibTess.TessPageIteratorLevel> element) {
        return TessPageIteratorIsAtFinalElement(Pointer.getPeer(handle),
                (int) level.value(), (int) element.value());
    }

    protected native static int TessPageIteratorIsAtFinalElement(
            @Ptr long handle, int level, int element);

    /**
     * Original signature :
     * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:314</i>
     */
    public static int TessPageIteratorBoundingBox(
            Pointer<LibTess.TessPageIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level,
            Pointer<Integer> left, Pointer<Integer> top,
            Pointer<Integer> right, Pointer<Integer> bottom) {
        return TessPageIteratorBoundingBox(Pointer.getPeer(handle),
                (int) level.value(), Pointer.getPeer(left),
                Pointer.getPeer(top), Pointer.getPeer(right),
                Pointer.getPeer(bottom));
    }

    protected native static int TessPageIteratorBoundingBox(@Ptr long handle,
            int level, @Ptr long left, @Ptr long top, @Ptr long right,
            @Ptr long bottom);

    /**
     * Original signature :
     * <code>TessPolyBlockType TessPageIteratorBlockType(const TessPageIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:316</i>
     */
    public static IntValuedEnum<LibTess.TessPolyBlockType> TessPageIteratorBlockType(
            Pointer<LibTess.TessPageIterator> handle) {
        return FlagSet.fromValue(
                TessPageIteratorBlockType(Pointer.getPeer(handle)),
                LibTess.TessPolyBlockType.class);
    }

    protected native static int TessPageIteratorBlockType(@Ptr long handle);

    /**
     * Original signature :
     * <code>Pix* TessPageIteratorGetBinaryImage(const TessPageIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:319</i>
     */
    public static Pointer<Pix> TessPageIteratorGetBinaryImage(
            Pointer<LibTess.TessPageIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level) {
        return (Pointer) Pointer.pointerToAddress(
                TessPageIteratorGetBinaryImage(Pointer.getPeer(handle),
                        (int) level.value()), Pix.class);
    }

    @Ptr
    protected native static long TessPageIteratorGetBinaryImage(
            @Ptr long handle, int level);

    /**
     * Original signature :
     * <code>Pix* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:321</i>
     */
    public static Pointer<Pix> TessPageIteratorGetImage(
            Pointer<LibTess.TessPageIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level,
            int padding, Pointer<Integer> left, Pointer<Integer> top) {
        return (Pointer) Pointer.pointerToAddress(
                TessPageIteratorGetImage(Pointer.getPeer(handle),
                        (int) level.value(), padding, Pointer.getPeer(left),
                        Pointer.getPeer(top)), Pix.class);
    }

    @Ptr
    protected native static long TessPageIteratorGetImage(@Ptr long handle,
            int level, int padding, @Ptr long left, @Ptr long top);

    /**
     * Original signature :
     * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:325</i>
     */
    public static int TessPageIteratorBaseline(
            Pointer<LibTess.TessPageIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level,
            Pointer<Integer> x1, Pointer<Integer> y1, Pointer<Integer> x2,
            Pointer<Integer> y2) {
        return TessPageIteratorBaseline(Pointer.getPeer(handle),
                (int) level.value(), Pointer.getPeer(x1), Pointer.getPeer(y1),
                Pointer.getPeer(x2), Pointer.getPeer(y2));
    }

    protected native static int TessPageIteratorBaseline(@Ptr long handle,
            int level, @Ptr long x1, @Ptr long y1, @Ptr long x2, @Ptr long y2);

    /**
     * Original signature :
     * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:328</i>
     */
    public static void TessPageIteratorOrientation(
            Pointer<LibTess.TessPageIterator> handle,
            Pointer<IntValuedEnum<LibTess.TessOrientation>> orientation,
            Pointer<IntValuedEnum<LibTess.TessWritingDirection>> writing_direction,
            Pointer<IntValuedEnum<LibTess.TessTextlineOrder>> textline_order,
            Pointer<Float> deskew_angle) {
        TessPageIteratorOrientation(Pointer.getPeer(handle),
                Pointer.getPeer(orientation),
                Pointer.getPeer(writing_direction),
                Pointer.getPeer(textline_order), Pointer.getPeer(deskew_angle));
    }

    protected native static void TessPageIteratorOrientation(@Ptr long handle,
            @Ptr long orientation, @Ptr long writing_direction,
            @Ptr long textline_order, @Ptr long deskew_angle);

    /**
     * Result iterator<br>
     * Original signature :
     * <code>void TessResultIteratorDelete(TessResultIterator*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:334</i>
     */
    public static void TessResultIteratorDelete(
            Pointer<LibTess.TessResultIterator> handle) {
        TessResultIteratorDelete(Pointer.getPeer(handle));
    }

    protected native static void TessResultIteratorDelete(@Ptr long handle);

    /**
     * Original signature :
     * <code>TessResultIterator* TessResultIteratorCopy(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:335</i>
     */
    public static Pointer<LibTess.TessResultIterator> TessResultIteratorCopy(
            Pointer<LibTess.TessResultIterator> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultIteratorCopy(Pointer.getPeer(handle)),
                LibTess.TessResultIterator.class);
    }

    @Ptr
    protected native static long TessResultIteratorCopy(@Ptr long handle);

    /**
     * Original signature :
     * <code>TessPageIterator* TessResultIteratorGetPageIterator(TessResultIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:337</i>
     */
    public static Pointer<LibTess.TessPageIterator> TessResultIteratorGetPageIterator(
            Pointer<LibTess.TessResultIterator> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultIteratorGetPageIterator(Pointer.getPeer(handle)),
                LibTess.TessPageIterator.class);
    }

    @Ptr
    protected native static long TessResultIteratorGetPageIterator(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>TessPageIterator* TessResultIteratorGetPageIteratorConst(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:339</i>
     */
    public static Pointer<LibTess.TessPageIterator> TessResultIteratorGetPageIteratorConst(
            Pointer<LibTess.TessResultIterator> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultIteratorGetPageIteratorConst(Pointer.getPeer(handle)),
                LibTess.TessPageIterator.class);
    }

    @Ptr
    protected native static long TessResultIteratorGetPageIteratorConst(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>TessChoiceIterator* TessResultIteratorGetChoiceIterator(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:341</i>
     */
    public static Pointer<LibTess.TessChoiceIterator> TessResultIteratorGetChoiceIterator(
            Pointer<LibTess.TessResultIterator> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultIteratorGetChoiceIterator(Pointer.getPeer(handle)),
                LibTess.TessChoiceIterator.class);
    }

    @Ptr
    protected native static long TessResultIteratorGetChoiceIterator(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>int TessResultIteratorNext(TessResultIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:344</i>
     */
    public static int TessResultIteratorNext(
            Pointer<LibTess.TessResultIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level) {
        return TessResultIteratorNext(Pointer.getPeer(handle),
                (int) level.value());
    }

    protected native static int TessResultIteratorNext(@Ptr long handle,
            int level);

    /**
     * Original signature :
     * <code>char* TessResultIteratorGetUTF8Text(const TessResultIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:345</i>
     */
    public static Pointer<Byte> TessResultIteratorGetUTF8Text(
            Pointer<LibTess.TessResultIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultIteratorGetUTF8Text(Pointer.getPeer(handle),
                        (int) level.value()), Byte.class);
    }

    @Ptr
    protected native static long TessResultIteratorGetUTF8Text(
            @Ptr long handle, int level);

    /**
     * Original signature :
     * <code>float TessResultIteratorConfidence(const TessResultIterator*, TessPageIteratorLevel)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:346</i>
     */
    public static float TessResultIteratorConfidence(
            Pointer<LibTess.TessResultIterator> handle,
            IntValuedEnum<LibTess.TessPageIteratorLevel> level) {
        return TessResultIteratorConfidence(Pointer.getPeer(handle),
                (int) level.value());
    }

    protected native static float TessResultIteratorConfidence(
            @Ptr long handle, int level);

    /**
     * Original signature :
     * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:348</i>
     */
    public static Pointer<Byte> TessResultIteratorWordFontAttributes(
            Pointer<LibTess.TessResultIterator> handle,
            Pointer<Integer> is_bold, Pointer<Integer> is_italic,
            Pointer<Integer> is_underlined, Pointer<Integer> is_monospace,
            Pointer<Integer> is_serif, Pointer<Integer> is_smallcaps,
            Pointer<Integer> pointsize, Pointer<Integer> font_id) {
        return (Pointer) Pointer.pointerToAddress(
                TessResultIteratorWordFontAttributes(Pointer.getPeer(handle),
                        Pointer.getPeer(is_bold), Pointer.getPeer(is_italic),
                        Pointer.getPeer(is_underlined),
                        Pointer.getPeer(is_monospace),
                        Pointer.getPeer(is_serif),
                        Pointer.getPeer(is_smallcaps),
                        Pointer.getPeer(pointsize), Pointer.getPeer(font_id)),
                Byte.class);
    }

    @Ptr
    protected native static long TessResultIteratorWordFontAttributes(
            @Ptr long handle, @Ptr long is_bold, @Ptr long is_italic,
            @Ptr long is_underlined, @Ptr long is_monospace,
            @Ptr long is_serif, @Ptr long is_smallcaps, @Ptr long pointsize,
            @Ptr long font_id);

    /**
     * Original signature :
     * <code>int TessResultIteratorWordIsFromDictionary(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:353</i>
     */
    public static int TessResultIteratorWordIsFromDictionary(
            Pointer<LibTess.TessResultIterator> handle) {
        return TessResultIteratorWordIsFromDictionary(Pointer.getPeer(handle));
    }

    protected native static int TessResultIteratorWordIsFromDictionary(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>int TessResultIteratorWordIsNumeric(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:354</i>
     */
    public static int TessResultIteratorWordIsNumeric(
            Pointer<LibTess.TessResultIterator> handle) {
        return TessResultIteratorWordIsNumeric(Pointer.getPeer(handle));
    }

    protected native static int TessResultIteratorWordIsNumeric(@Ptr long handle);

    /**
     * Original signature :
     * <code>int TessResultIteratorSymbolIsSuperscript(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:355</i>
     */
    public static int TessResultIteratorSymbolIsSuperscript(
            Pointer<LibTess.TessResultIterator> handle) {
        return TessResultIteratorSymbolIsSuperscript(Pointer.getPeer(handle));
    }

    protected native static int TessResultIteratorSymbolIsSuperscript(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>int TessResultIteratorSymbolIsSubscript(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:356</i>
     */
    public static int TessResultIteratorSymbolIsSubscript(
            Pointer<LibTess.TessResultIterator> handle) {
        return TessResultIteratorSymbolIsSubscript(Pointer.getPeer(handle));
    }

    protected native static int TessResultIteratorSymbolIsSubscript(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>int TessResultIteratorSymbolIsDropcap(const TessResultIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:357</i>
     */
    public static int TessResultIteratorSymbolIsDropcap(
            Pointer<LibTess.TessResultIterator> handle) {
        return TessResultIteratorSymbolIsDropcap(Pointer.getPeer(handle));
    }

    protected native static int TessResultIteratorSymbolIsDropcap(
            @Ptr long handle);

    /**
     * Original signature :
     * <code>void TessChoiceIteratorDelete(TessChoiceIterator*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:359</i>
     */
    public static void TessChoiceIteratorDelete(
            Pointer<LibTess.TessChoiceIterator> handle) {
        TessChoiceIteratorDelete(Pointer.getPeer(handle));
    }

    protected native static void TessChoiceIteratorDelete(@Ptr long handle);

    /**
     * Original signature :
     * <code>int TessChoiceIteratorNext(TessChoiceIterator*)</code><br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:360</i>
     */
    public static int TessChoiceIteratorNext(
            Pointer<LibTess.TessChoiceIterator> handle) {
        return TessChoiceIteratorNext(Pointer.getPeer(handle));
    }

    protected native static int TessChoiceIteratorNext(@Ptr long handle);

    /**
     * Original signature :
     * <code>char* TessChoiceIteratorGetUTF8Text(const TessChoiceIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:361</i>
     */
    public static Pointer<Byte> TessChoiceIteratorGetUTF8Text(
            Pointer<LibTess.TessChoiceIterator> handle) {
        return (Pointer) Pointer.pointerToAddress(
                TessChoiceIteratorGetUTF8Text(Pointer.getPeer(handle)),
                Byte.class);
    }

    @Ptr
    protected native static long TessChoiceIteratorGetUTF8Text(@Ptr long handle);

    /**
     * Original signature :
     * <code>float TessChoiceIteratorConfidence(const TessChoiceIterator*)</code>
     * <br>
     * <i>native declaration :
     * C:\Users\Paul\Studium\Masterarbeit\Entwicklung\VS2013
     * \tesseract-ocr\api\capi.h:362</i>
     */
    public static float TessChoiceIteratorConfidence(
            Pointer<LibTess.TessChoiceIterator> handle) {
        return TessChoiceIteratorConfidence(Pointer.getPeer(handle));
    }

    protected native static float TessChoiceIteratorConfidence(@Ptr long handle);

    /** Undefined type */
    public static interface TessChoiceIterator {

    };

    /** Undefined type */
    public static interface TessBaseAPI {

    };

    /** Undefined type */
    public static interface FILE {

    };

    /** Undefined type */
    public static interface ETEXT_DESC {

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
    public static interface TessResultRenderer {

    };
}
