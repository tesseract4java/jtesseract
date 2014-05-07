package de.vorb.tesseract;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.Structure;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

public class TessJNA implements Library {
    public static final String JNA_LIBRARY_NAME = "tesseract";

    static {
        // the Windows name of the library is "libtesseract303" whereas Linux
        // and Mac name is "tesseract"
        final boolean isWindows =
                System.getProperty("os.name").toLowerCase().startsWith(
                        "windows");

        final String libraryName;
        if (isWindows)
            libraryName = "lib" + JNA_LIBRARY_NAME + "303";
        else
            libraryName = JNA_LIBRARY_NAME;

        // register at startup
        Native.register(libraryName);
    }

    public static interface TessOcrEngineMode {
        public static final int OEM_TESSERACT_ONLY = 0;
        public static final int OEM_CUBE_ONLY = 1;
        public static final int OEM_TESSERACT_CUBE_COMBINED = 2;
        public static final int OEM_DEFAULT = 3;
    };

    public static interface TessPageSegMode {
        public static final int PSM_OSD_ONLY = 0;
        public static final int PSM_AUTO_OSD = 1;
        public static final int PSM_AUTO_ONLY = 2;
        public static final int PSM_AUTO = 3;
        public static final int PSM_SINGLE_COLUMN = 4;
        public static final int PSM_SINGLE_BLOCK_VERT_TEXT = 5;
        public static final int PSM_SINGLE_BLOCK = 6;
        public static final int PSM_SINGLE_LINE = 7;
        public static final int PSM_SINGLE_WORD = 8;
        public static final int PSM_CIRCLE_WORD = 9;
        public static final int PSM_SINGLE_CHAR = 10;
        public static final int PSM_SPARSE_TEXT = 11;
        public static final int PSM_SPARSE_TEXT_OSD = 12;
        public static final int PSM_COUNT = 13;
    };

    public static interface TessPageIteratorLevel {
        public static final int RIL_BLOCK = 0;
        public static final int RIL_PARA = 1;
        public static final int RIL_TEXTLINE = 2;
        public static final int RIL_WORD = 3;
        public static final int RIL_SYMBOL = 4;
    };

    public static interface TessPolyBlockType {
        public static final int PT_UNKNOWN = 0;
        public static final int PT_FLOWING_TEXT = 1;
        public static final int PT_HEADING_TEXT = 2;
        public static final int PT_PULLOUT_TEXT = 3;
        public static final int PT_TABLE = 4;
        public static final int PT_VERTICAL_TEXT = 5;
        public static final int PT_CAPTION_TEXT = 6;
        public static final int PT_FLOWING_IMAGE = 7;
        public static final int PT_HEADING_IMAGE = 8;
        public static final int PT_PULLOUT_IMAGE = 9;
        public static final int PT_HORZ_LINE = 10;
        public static final int PT_VERT_LINE = 11;
        public static final int PT_NOISE = 12;
        public static final int PT_COUNT = 13;
    };

    public static interface TessOrientation {
        public static final int ORIENTATION_PAGE_UP = 0;
        public static final int ORIENTATION_PAGE_RIGHT = 1;
        public static final int ORIENTATION_PAGE_DOWN = 2;
        public static final int ORIENTATION_PAGE_LEFT = 3;
    };

    public static interface TessWritingDirection {
        public static final int WRITING_DIRECTION_LEFT_TO_RIGHT = 0;
        public static final int WRITING_DIRECTION_RIGHT_TO_LEFT = 1;
        public static final int WRITING_DIRECTION_TOP_TO_BOTTOM = 2;
    };

    public static interface TessTextlineOrder {
        public static final int TEXTLINE_ORDER_LEFT_TO_RIGHT = 0;
        public static final int TEXTLINE_ORDER_RIGHT_TO_LEFT = 1;
        public static final int TEXTLINE_ORDER_TOP_TO_BOTTOM = 2;
    };

    public static final int TRUE = (int) 1;
    public static final int FALSE = (int) 0;

    public static native String TessVersion();

    @Deprecated
    public static native void TessDeleteText(Pointer text);

    public static native void TessDeleteText(String text);

    @Deprecated
    public static native void TessDeleteTextArray(PointerByReference arr);

    public static native void TessDeleteTextArray(String arr[]);

    @Deprecated
    public static native void TessDeleteIntArray(IntByReference arr);

    public static native void TessDeleteIntArray(IntBuffer arr);

    public static native PointerByReference TessTextRendererCreate();

    public static native PointerByReference TessHOcrRendererCreate();

    @Deprecated
    public static native PointerByReference TessPDFRendererCreate(
            Pointer datadir);

    public static native PointerByReference TessPDFRendererCreate(String datadir);

    public static native PointerByReference TessUnlvRendererCreate();

    public static native PointerByReference TessBoxTextRendererCreate();

    @Deprecated
    public static native void TessDeleteResultRenderer(Pointer renderer);

    public static native void TessDeleteResultRenderer(
            PointerByReference renderer);

    @Deprecated
    public static native void TessResultRendererInsert(Pointer renderer,
            Pointer next);

    public static native void TessResultRendererInsert(
            PointerByReference renderer, PointerByReference next);

    @Deprecated
    public static native PointerByReference TessResultRendererNext(
            Pointer renderer);

    public static native PointerByReference TessResultRendererNext(
            PointerByReference renderer);

    @Deprecated
    public static native int TessResultRendererBeginDocument(Pointer renderer,
            Pointer title);

    public static native int TessResultRendererBeginDocument(
            PointerByReference renderer, String title);

    public static native int TessResultRendererBeginDocument(
            PointerByReference renderer, Pointer title);

    @Deprecated
    public static native int TessResultRendererAddImage(Pointer renderer,
            Pointer api);

    public static native int TessResultRendererAddImage(
            PointerByReference renderer, PointerByReference api);

    @Deprecated
    public static native int TessResultRendererAddError(Pointer renderer,
            Pointer api);

    public static native int TessResultRendererAddError(
            PointerByReference renderer, PointerByReference api);

    @Deprecated
    public static native int TessResultRendererEndDocument(Pointer renderer);

    public static native int TessResultRendererEndDocument(
            PointerByReference renderer);

    @Deprecated
    public static native int TessResultRendererGetOutput(Pointer renderer,
            PointerByReference data, IntByReference data_len);

    public static native int TessResultRendererGetOutput(
            PointerByReference renderer, String data[], IntBuffer data_len);

    public static native int TessResultRendererGetOutput(
            PointerByReference renderer, PointerByReference data,
            IntByReference data_len);

    @Deprecated
    public static native String TessResultRendererTypename(Pointer renderer);

    public static native String TessResultRendererTypename(
            PointerByReference renderer);

    @Deprecated
    public static native String TessResultRendererExtention(Pointer renderer);

    public static native String TessResultRendererExtention(
            PointerByReference renderer);

    @Deprecated
    public static native String TessResultRendererTitle(Pointer renderer);

    public static native String TessResultRendererTitle(
            PointerByReference renderer);

    @Deprecated
    public static native int TessResultRendererImageNum(Pointer renderer);

    public static native int TessResultRendererImageNum(
            PointerByReference renderer);

    public static native PointerByReference TessBaseAPICreate();

    @Deprecated
    public static native void TessBaseAPIDelete(Pointer handle);

    public static native void TessBaseAPIDelete(PointerByReference handle);

    @Deprecated
    public static native SizeT TessBaseAPIGetOpenCLDevice(Pointer handle,
            PointerByReference device);

    public static native SizeT TessBaseAPIGetOpenCLDevice(
            PointerByReference handle, PointerByReference device);

    @Deprecated
    public static native void TessBaseAPISetInputName(Pointer handle,
            Pointer name);

    public static native void TessBaseAPISetInputName(
            PointerByReference handle, String name);

    public static native void TessBaseAPISetInputName(
            PointerByReference handle, Pointer name);

    @Deprecated
    public static native String TessBaseAPIGetInputName(Pointer handle);

    public static native String TessBaseAPIGetInputName(
            PointerByReference handle);

    @Deprecated
    public static native void TessBaseAPISetInputImage(Pointer handle,
            TessJNA.Pix pix);

    public static native void TessBaseAPISetInputImage(
            PointerByReference handle, TessJNA.Pix pix);

    @Deprecated
    public static native TessJNA.Pix TessBaseAPIGetInputImage(
            Pointer handle);

    public static native TessJNA.Pix TessBaseAPIGetInputImage(
            PointerByReference handle);

    @Deprecated
    public static native int TessBaseAPIGetSourceYResolution(Pointer handle);

    public static native int TessBaseAPIGetSourceYResolution(
            PointerByReference handle);

    @Deprecated
    public static native String TessBaseAPIGetDatapath(Pointer handle);

    public static native String TessBaseAPIGetDatapath(PointerByReference handle);

    @Deprecated
    public static native void TessBaseAPISetOutputName(Pointer handle,
            Pointer name);

    public static native void TessBaseAPISetOutputName(
            PointerByReference handle, String name);

    public static native void TessBaseAPISetOutputName(
            PointerByReference handle, Pointer name);

    @Deprecated
    public static native int TessBaseAPISetVariable(Pointer handle,
            Pointer name, Pointer value);

    public static native int TessBaseAPISetVariable(PointerByReference handle,
            String name, String value);

    public static native int TessBaseAPISetVariable(PointerByReference handle,
            Pointer name, Pointer value);

    @Deprecated
    public static native int TessBaseAPISetDebugVariable(Pointer handle,
            Pointer name, Pointer value);

    public static native int TessBaseAPISetDebugVariable(
            PointerByReference handle, String name, String value);

    public static native int TessBaseAPISetDebugVariable(
            PointerByReference handle, Pointer name, Pointer value);

    @Deprecated
    public static native int TessBaseAPIGetIntVariable(Pointer handle,
            Pointer name, IntByReference value);

    public static native int TessBaseAPIGetIntVariable(
            PointerByReference handle, String name, IntBuffer value);

    public static native int TessBaseAPIGetIntVariable(
            PointerByReference handle, Pointer name, IntByReference value);

    @Deprecated
    public static native int TessBaseAPIGetBoolVariable(Pointer handle,
            Pointer name, IntByReference value);

    public static native int TessBaseAPIGetBoolVariable(
            PointerByReference handle, String name, IntBuffer value);

    public static native int TessBaseAPIGetBoolVariable(
            PointerByReference handle, Pointer name, IntByReference value);

    @Deprecated
    public static native int TessBaseAPIGetDoubleVariable(Pointer handle,
            Pointer name, DoubleByReference value);

    public static native int TessBaseAPIGetDoubleVariable(
            PointerByReference handle, String name, DoubleBuffer value);

    public static native int TessBaseAPIGetDoubleVariable(
            PointerByReference handle, Pointer name, DoubleByReference value);

    @Deprecated
    public static native String TessBaseAPIGetStringVariable(Pointer handle,
            Pointer name);

    public static native String TessBaseAPIGetStringVariable(
            PointerByReference handle, String name);

    public static native String TessBaseAPIGetStringVariable(
            PointerByReference handle, Pointer name);

    @Deprecated
    public static native void TessBaseAPIPrintVariables(Pointer handle,
            TessJNA.FILE fp);

    public static native void TessBaseAPIPrintVariables(
            PointerByReference handle, TessJNA.FILE fp);

    @Deprecated
    public static native int TessBaseAPIPrintVariablesToFile(Pointer handle,
            Pointer filename);

    public static native int TessBaseAPIPrintVariablesToFile(
            PointerByReference handle, String filename);

    public static native int TessBaseAPIPrintVariablesToFile(
            PointerByReference handle, Pointer filename);

    @Deprecated
    public static native int TessBaseAPIInit1(Pointer handle, Pointer datapath,
            Pointer language, int oem, PointerByReference configs,
            int configs_size);

    public static native int TessBaseAPIInit1(PointerByReference handle,
            String datapath, String language, int oem, String configs[],
            int configs_size);

    public static native int TessBaseAPIInit1(PointerByReference handle,
            Pointer datapath, Pointer language, int oem,
            PointerByReference configs, int configs_size);

    @Deprecated
    public static native int TessBaseAPIInit2(Pointer handle, Pointer datapath,
            Pointer language, int oem);

    public static native int TessBaseAPIInit2(PointerByReference handle,
            String datapath, String language, int oem);

    public static native int TessBaseAPIInit2(PointerByReference handle,
            Pointer datapath, Pointer language, int oem);

    @Deprecated
    public static native int TessBaseAPIInit3(Pointer handle, Pointer datapath,
            Pointer language);

    public static native int TessBaseAPIInit3(PointerByReference handle,
            String datapath, String language);

    public static native int TessBaseAPIInit3(PointerByReference handle,
            Pointer datapath, Pointer language);

    @Deprecated
    public static native int TessBaseAPIInit4(Pointer handle, Pointer datapath,
            Pointer language, int mode, PointerByReference configs,
            int configs_size, PointerByReference vars_vec,
            PointerByReference vars_values, SizeT vars_vec_size,
            int set_only_non_debug_params);

    public static native int TessBaseAPIInit4(PointerByReference handle,
            String datapath, String language, int mode, String configs[],
            int configs_size, String vars_vec[], String vars_values[],
            SizeT vars_vec_size, int set_only_non_debug_params);

    public static native int TessBaseAPIInit4(PointerByReference handle,
            Pointer datapath, Pointer language, int mode,
            PointerByReference configs, int configs_size,
            PointerByReference vars_vec, PointerByReference vars_values,
            SizeT vars_vec_size, int set_only_non_debug_params);

    @Deprecated
    public static native String TessBaseAPIGetInitLanguagesAsString(
            Pointer handle);

    public static native String TessBaseAPIGetInitLanguagesAsString(
            PointerByReference handle);

    @Deprecated
    public static native PointerByReference TessBaseAPIGetLoadedLanguagesAsVector(
            Pointer handle);

    public static native PointerByReference TessBaseAPIGetLoadedLanguagesAsVector(
            PointerByReference handle);

    @Deprecated
    public static native PointerByReference TessBaseAPIGetAvailableLanguagesAsVector(
            Pointer handle);

    public static native PointerByReference TessBaseAPIGetAvailableLanguagesAsVector(
            PointerByReference handle);

    @Deprecated
    public static native int TessBaseAPIInitLangMod(Pointer handle,
            Pointer datapath, Pointer language);

    public static native int TessBaseAPIInitLangMod(PointerByReference handle,
            String datapath, String language);

    public static native int TessBaseAPIInitLangMod(PointerByReference handle,
            Pointer datapath, Pointer language);

    @Deprecated
    public static native void TessBaseAPIInitForAnalysePage(Pointer handle);

    public static native void TessBaseAPIInitForAnalysePage(
            PointerByReference handle);

    @Deprecated
    public static native void TessBaseAPIReadConfigFile(Pointer handle,
            Pointer filename);

    public static native void TessBaseAPIReadConfigFile(
            PointerByReference handle, String filename);

    public static native void TessBaseAPIReadConfigFile(
            PointerByReference handle, Pointer filename);

    @Deprecated
    public static native void TessBaseAPIReadDebugConfigFile(Pointer handle,
            Pointer filename);

    public static native void TessBaseAPIReadDebugConfigFile(
            PointerByReference handle, String filename);

    public static native void TessBaseAPIReadDebugConfigFile(
            PointerByReference handle, Pointer filename);

    @Deprecated
    public static native void TessBaseAPISetPageSegMode(Pointer handle, int mode);

    public static native void TessBaseAPISetPageSegMode(
            PointerByReference handle, int mode);

    @Deprecated
    public static native int TessBaseAPIGetPageSegMode(Pointer handle);

    public static native int TessBaseAPIGetPageSegMode(PointerByReference handle);

    @Deprecated
    public static native String TessBaseAPIRect(Pointer handle,
            Pointer imagedata, int bytes_per_pixel, int bytes_per_line,
            int left, int top, int width, int height);

    public static native String TessBaseAPIRect(PointerByReference handle,
            byte imagedata[], int bytes_per_pixel, int bytes_per_line,
            int left, int top, int width, int height);

    public static native String TessBaseAPIRect(PointerByReference handle,
            Pointer imagedata, int bytes_per_pixel, int bytes_per_line,
            int left, int top, int width, int height);

    @Deprecated
    public static native void TessBaseAPIClearAdaptiveClassifier(Pointer handle);

    public static native void TessBaseAPIClearAdaptiveClassifier(
            PointerByReference handle);

    @Deprecated
    public static native void TessBaseAPISetImage(Pointer handle,
            Pointer imagedata, int width, int height, int bytes_per_pixel,
            int bytes_per_line);

    public static native void TessBaseAPISetImage(PointerByReference handle,
            byte imagedata[], int width, int height, int bytes_per_pixel,
            int bytes_per_line);

    public static native void TessBaseAPISetImage(PointerByReference handle,
            Pointer imagedata, int width, int height, int bytes_per_pixel,
            int bytes_per_line);

    @Deprecated
    public static native void TessBaseAPISetImage2(Pointer handle,
            TessJNA.Pix pix);

    public static native void TessBaseAPISetImage2(PointerByReference handle,
            TessJNA.Pix pix);

    @Deprecated
    public static native void TessBaseAPISetSourceResolution(Pointer handle,
            int ppi);

    public static native void TessBaseAPISetSourceResolution(
            PointerByReference handle, int ppi);

    @Deprecated
    public static native void TessBaseAPISetRectangle(Pointer handle, int left,
            int top, int width, int height);

    public static native void TessBaseAPISetRectangle(
            PointerByReference handle, int left, int top, int width, int height);

    @Deprecated
    public static native TessJNA.Pix TessBaseAPIGetThresholdedImage(
            Pointer handle);

    public static native TessJNA.Pix TessBaseAPIGetThresholdedImage(
            PointerByReference handle);

    @Deprecated
    public static native TessJNA.Boxa TessBaseAPIGetRegions(
            Pointer handle, PointerByReference pixa);

    public static native TessJNA.Boxa TessBaseAPIGetRegions(
            PointerByReference handle, PointerByReference pixa);

    public static native TessJNA.Boxa TessBaseAPIGetRegions(
            PointerByReference handle, TessJNA.Pixa pixa[]);

    @Deprecated
    public static native TessJNA.Boxa TessBaseAPIGetTextlines(
            Pointer handle, PointerByReference pixa, PointerByReference blockids);

    public static native TessJNA.Boxa TessBaseAPIGetTextlines(
            PointerByReference handle, TessJNA.Pixa pixa[],
            PointerByReference blockids);

    @Deprecated
    public static native TessJNA.Boxa TessBaseAPIGetTextlines1(
            Pointer handle, int raw_image, int raw_padding,
            PointerByReference pixa, PointerByReference blockids,
            PointerByReference paraids);

    public static native TessJNA.Boxa TessBaseAPIGetTextlines1(
            PointerByReference handle, int raw_image, int raw_padding,
            TessJNA.Pixa pixa[], PointerByReference blockids,
            PointerByReference paraids);

    @Deprecated
    public static native TessJNA.Boxa TessBaseAPIGetStrips(Pointer handle,
            PointerByReference pixa, PointerByReference blockids);

    public static native TessJNA.Boxa TessBaseAPIGetStrips(
            PointerByReference handle, TessJNA.Pixa pixa[],
            PointerByReference blockids);

    @Deprecated
    public static native TessJNA.Boxa TessBaseAPIGetWords(Pointer handle,
            PointerByReference pixa);

    public static native TessJNA.Boxa TessBaseAPIGetWords(
            PointerByReference handle, TessJNA.Pixa pixa[]);

    @Deprecated
    public static native TessJNA.Boxa TessBaseAPIGetConnectedComponents(
            Pointer handle, PointerByReference cc);

    public static native TessJNA.Boxa TessBaseAPIGetConnectedComponents(
            PointerByReference handle, TessJNA.Pixa cc[]);

    @Deprecated
    public static native TessJNA.Boxa TessBaseAPIGetComponentImages(
            Pointer handle, int level, int text_only, PointerByReference pixa,
            PointerByReference blockids);

    public static native TessJNA.Boxa TessBaseAPIGetComponentImages(
            PointerByReference handle, int level, int text_only,
            TessJNA.Pixa pixa[], PointerByReference blockids);

    @Deprecated
    public static native TessJNA.Boxa TessBaseAPIGetComponentImages1(
            Pointer handle, int level, int text_only, int raw_image,
            int raw_padding, PointerByReference pixa,
            PointerByReference blockids, PointerByReference paraids);

    public static native TessJNA.Boxa TessBaseAPIGetComponentImages1(
            PointerByReference handle, int level, int text_only, int raw_image,
            int raw_padding, TessJNA.Pixa pixa[],
            PointerByReference blockids, PointerByReference paraids);

    @Deprecated
    public static native int TessBaseAPIGetThresholdedImageScaleFactor(
            Pointer handle);

    public static native int TessBaseAPIGetThresholdedImageScaleFactor(
            PointerByReference handle);

    @Deprecated
    public static native void TessBaseAPIDumpPGM(Pointer handle,
            Pointer filename);

    public static native void TessBaseAPIDumpPGM(PointerByReference handle,
            String filename);

    public static native void TessBaseAPIDumpPGM(PointerByReference handle,
            Pointer filename);

    @Deprecated
    public static native PointerByReference TessBaseAPIAnalyseLayout(
            Pointer handle);

    public static native PointerByReference TessBaseAPIAnalyseLayout(
            PointerByReference handle);

    @Deprecated
    public static native int TessBaseAPIRecognize(Pointer handle,
            Pointer monitor);

    public static native int TessBaseAPIRecognize(PointerByReference handle,
            PointerByReference monitor);

    @Deprecated
    public static native int TessBaseAPIRecognizeForChopTest(Pointer handle,
            Pointer monitor);

    public static native int TessBaseAPIRecognizeForChopTest(
            PointerByReference handle, PointerByReference monitor);

    @Deprecated
    public static native String TessBaseAPIProcessPages(Pointer handle,
            Pointer filename, Pointer retry_config, int timeout_millisec);

    public static native String TessBaseAPIProcessPages(
            PointerByReference handle, String filename, String retry_config,
            int timeout_millisec);

    public static native String TessBaseAPIProcessPages(
            PointerByReference handle, Pointer filename, Pointer retry_config,
            int timeout_millisec);

    @Deprecated
    public static native int TessBaseAPIProcessPages1(Pointer handle,
            Pointer filename, Pointer retry_config, int timeout_millisec,
            Pointer renderer);

    public static native int TessBaseAPIProcessPages1(
            PointerByReference handle, String filename, String retry_config,
            int timeout_millisec, PointerByReference renderer);

    public static native int TessBaseAPIProcessPages1(
            PointerByReference handle, Pointer filename, Pointer retry_config,
            int timeout_millisec, PointerByReference renderer);

    @Deprecated
    public static native String TessBaseAPIProcessPage(Pointer handle,
            TessJNA.Pix pix, int page_index, Pointer filename,
            Pointer retry_config, int timeout_millisec);

    public static native String TessBaseAPIProcessPage(
            PointerByReference handle, TessJNA.Pix pix, int page_index,
            String filename, String retry_config, int timeout_millisec);

    public static native String TessBaseAPIProcessPage(
            PointerByReference handle, TessJNA.Pix pix, int page_index,
            Pointer filename, Pointer retry_config, int timeout_millisec);

    @Deprecated
    public static native int TessBaseAPIProcessPage1(Pointer handle,
            TessJNA.Pix pix, int page_index, Pointer filename,
            Pointer retry_config, int timeout_millisec, Pointer renderer);

    public static native int TessBaseAPIProcessPage1(PointerByReference handle,
            TessJNA.Pix pix, int page_index, String filename,
            String retry_config, int timeout_millisec,
            PointerByReference renderer);

    public static native int TessBaseAPIProcessPage1(PointerByReference handle,
            TessJNA.Pix pix, int page_index, Pointer filename,
            Pointer retry_config, int timeout_millisec,
            PointerByReference renderer);

    @Deprecated
    public static native PointerByReference TessBaseAPIGetIterator(
            Pointer handle);

    public static native PointerByReference TessBaseAPIGetIterator(
            PointerByReference handle);

    @Deprecated
    public static native PointerByReference TessBaseAPIGetMutableIterator(
            Pointer handle);

    public static native PointerByReference TessBaseAPIGetMutableIterator(
            PointerByReference handle);

    @Deprecated
    public static native String TessBaseAPIGetUTF8Text(Pointer handle);

    public static native String TessBaseAPIGetUTF8Text(PointerByReference handle);

    @Deprecated
    public static native String TessBaseAPIGetHOCRText(Pointer handle,
            int page_number);

    public static native String TessBaseAPIGetHOCRText(
            PointerByReference handle, int page_number);

    @Deprecated
    public static native String TessBaseAPIGetBoxText(Pointer handle,
            int page_number);

    public static native String TessBaseAPIGetBoxText(
            PointerByReference handle, int page_number);

    @Deprecated
    public static native String TessBaseAPIGetUNLVText(Pointer handle);

    public static native String TessBaseAPIGetUNLVText(PointerByReference handle);

    @Deprecated
    public static native int TessBaseAPIMeanTextConf(Pointer handle);

    public static native int TessBaseAPIMeanTextConf(PointerByReference handle);

    @Deprecated
    public static native IntByReference TessBaseAPIAllWordConfidences(
            Pointer handle);

    public static native IntByReference TessBaseAPIAllWordConfidences(
            PointerByReference handle);

    @Deprecated
    public static native int TessBaseAPIAdaptToWordStr(Pointer handle,
            int mode, Pointer wordstr);

    public static native int TessBaseAPIAdaptToWordStr(
            PointerByReference handle, int mode, String wordstr);

    public static native int TessBaseAPIAdaptToWordStr(
            PointerByReference handle, int mode, Pointer wordstr);

    @Deprecated
    public static native void TessBaseAPIClear(Pointer handle);

    public static native void TessBaseAPIClear(PointerByReference handle);

    @Deprecated
    public static native void TessBaseAPIEnd(Pointer handle);

    public static native void TessBaseAPIEnd(PointerByReference handle);

    @Deprecated
    public static native int TessBaseAPIIsValidWord(Pointer handle, Pointer word);

    public static native int TessBaseAPIIsValidWord(PointerByReference handle,
            String word);

    public static native int TessBaseAPIIsValidWord(PointerByReference handle,
            Pointer word);

    @Deprecated
    public static native int TessBaseAPIGetTextDirection(Pointer handle,
            IntByReference out_offset, FloatByReference out_slope);

    public static native int TessBaseAPIGetTextDirection(
            PointerByReference handle, IntBuffer out_offset,
            FloatBuffer out_slope);

    public static native int TessBaseAPIGetTextDirection(
            PointerByReference handle, IntByReference out_offset,
            FloatByReference out_slope);

    @Deprecated
    public static native String TessBaseAPIGetUnichar(Pointer handle,
            int unichar_id);

    public static native String TessBaseAPIGetUnichar(
            PointerByReference handle, int unichar_id);

    @Deprecated
    public static native void TessBaseAPISetMinOrientationMargin(
            Pointer handle, double margin);

    public static native void TessBaseAPISetMinOrientationMargin(
            PointerByReference handle, double margin);

    @Deprecated
    public static native void TessPageIteratorDelete(Pointer handle);

    public static native void TessPageIteratorDelete(PointerByReference handle);

    @Deprecated
    public static native PointerByReference TessPageIteratorCopy(Pointer handle);

    public static native PointerByReference TessPageIteratorCopy(
            PointerByReference handle);

    @Deprecated
    public static native void TessPageIteratorBegin(Pointer handle);

    public static native void TessPageIteratorBegin(PointerByReference handle);

    @Deprecated
    public static native int TessPageIteratorNext(Pointer handle, int level);

    public static native int TessPageIteratorNext(PointerByReference handle,
            int level);

    @Deprecated
    public static native int TessPageIteratorIsAtBeginningOf(Pointer handle,
            int level);

    public static native int TessPageIteratorIsAtBeginningOf(
            PointerByReference handle, int level);

    @Deprecated
    public static native int TessPageIteratorIsAtFinalElement(Pointer handle,
            int level, int element);

    public static native int TessPageIteratorIsAtFinalElement(
            PointerByReference handle, int level, int element);

    @Deprecated
    public static native int TessPageIteratorBoundingBox(Pointer handle,
            int level, IntByReference left, IntByReference top,
            IntByReference right, IntByReference bottom);

    public static native int TessPageIteratorBoundingBox(
            PointerByReference handle, int level, IntBuffer left,
            IntBuffer top, IntBuffer right, IntBuffer bottom);

    public static native int TessPageIteratorBoundingBox(
            PointerByReference handle, int level, IntByReference left,
            IntByReference top, IntByReference right, IntByReference bottom);

    @Deprecated
    public static native int TessPageIteratorBlockType(Pointer handle);

    public static native int TessPageIteratorBlockType(PointerByReference handle);

    @Deprecated
    public static native TessJNA.Pix TessPageIteratorGetBinaryImage(
            Pointer handle, int level);

    public static native TessJNA.Pix TessPageIteratorGetBinaryImage(
            PointerByReference handle, int level);

    @Deprecated
    public static native TessJNA.Pix TessPageIteratorGetImage(
            Pointer handle, int level, int padding, IntByReference left,
            IntByReference top);

    public static native TessJNA.Pix TessPageIteratorGetImage(
            PointerByReference handle, int level, int padding, IntBuffer left,
            IntBuffer top);

    public static native TessJNA.Pix TessPageIteratorGetImage(
            PointerByReference handle, int level, int padding,
            IntByReference left, IntByReference top);

    @Deprecated
    public static native int TessPageIteratorBaseline(Pointer handle,
            int level, IntByReference x1, IntByReference y1, IntByReference x2,
            IntByReference y2);

    public static native int TessPageIteratorBaseline(
            PointerByReference handle, int level, IntBuffer x1, IntBuffer y1,
            IntBuffer x2, IntBuffer y2);

    public static native int TessPageIteratorBaseline(
            PointerByReference handle, int level, IntByReference x1,
            IntByReference y1, IntByReference x2, IntByReference y2);

    @Deprecated
    public static native void TessPageIteratorOrientation(Pointer handle,
            IntByReference orientation, IntByReference writing_direction,
            IntByReference textline_order, FloatByReference deskew_angle);

    public static native void TessPageIteratorOrientation(
            PointerByReference handle, IntBuffer orientation,
            IntBuffer writing_direction, IntBuffer textline_order,
            FloatBuffer deskew_angle);

    public static native void TessPageIteratorOrientation(
            PointerByReference handle, IntByReference orientation,
            IntByReference writing_direction, IntByReference textline_order,
            FloatByReference deskew_angle);

    @Deprecated
    public static native void TessResultIteratorDelete(Pointer handle);

    public static native void TessResultIteratorDelete(PointerByReference handle);

    @Deprecated
    public static native PointerByReference TessResultIteratorCopy(
            Pointer handle);

    public static native PointerByReference TessResultIteratorCopy(
            PointerByReference handle);

    @Deprecated
    public static native PointerByReference TessResultIteratorGetPageIterator(
            Pointer handle);

    public static native PointerByReference TessResultIteratorGetPageIterator(
            PointerByReference handle);

    @Deprecated
    public static native PointerByReference TessResultIteratorGetPageIteratorConst(
            Pointer handle);

    public static native PointerByReference TessResultIteratorGetPageIteratorConst(
            PointerByReference handle);

    @Deprecated
    public static native TessJNA.TessChoiceIterator TessResultIteratorGetChoiceIterator(
            Pointer handle);

    public static native TessJNA.TessChoiceIterator TessResultIteratorGetChoiceIterator(
            PointerByReference handle);

    @Deprecated
    public static native int TessResultIteratorNext(Pointer handle, int level);

    public static native int TessResultIteratorNext(PointerByReference handle,
            int level);

    @Deprecated
    public static native String TessResultIteratorGetUTF8Text(Pointer handle,
            int level);

    public static native String TessResultIteratorGetUTF8Text(
            PointerByReference handle, int level);

    @Deprecated
    public static native float TessResultIteratorConfidence(Pointer handle,
            int level);

    public static native float TessResultIteratorConfidence(
            PointerByReference handle, int level);

    @Deprecated
    public static native String TessResultIteratorWordFontAttributes(
            Pointer handle, IntByReference is_bold, IntByReference is_italic,
            IntByReference is_underlined, IntByReference is_monospace,
            IntByReference is_serif, IntByReference is_smallcaps,
            IntByReference pointsize, IntByReference font_id);

    public static native String TessResultIteratorWordFontAttributes(
            PointerByReference handle, IntBuffer is_bold, IntBuffer is_italic,
            IntBuffer is_underlined, IntBuffer is_monospace,
            IntBuffer is_serif, IntBuffer is_smallcaps, IntBuffer pointsize,
            IntBuffer font_id);

    public static native String TessResultIteratorWordFontAttributes(
            PointerByReference handle, IntByReference is_bold,
            IntByReference is_italic, IntByReference is_underlined,
            IntByReference is_monospace, IntByReference is_serif,
            IntByReference is_smallcaps, IntByReference pointsize,
            IntByReference font_id);

    @Deprecated
    public static native int TessResultIteratorWordIsFromDictionary(
            Pointer handle);

    public static native int TessResultIteratorWordIsFromDictionary(
            PointerByReference handle);

    @Deprecated
    public static native int TessResultIteratorWordIsNumeric(Pointer handle);

    public static native int TessResultIteratorWordIsNumeric(
            PointerByReference handle);

    @Deprecated
    public static native int TessResultIteratorSymbolIsSuperscript(
            Pointer handle);

    public static native int TessResultIteratorSymbolIsSuperscript(
            PointerByReference handle);

    @Deprecated
    public static native int TessResultIteratorSymbolIsSubscript(Pointer handle);

    public static native int TessResultIteratorSymbolIsSubscript(
            PointerByReference handle);

    @Deprecated
    public static native int TessResultIteratorSymbolIsDropcap(Pointer handle);

    public static native int TessResultIteratorSymbolIsDropcap(
            PointerByReference handle);

    public static native void TessChoiceIteratorDelete(
            TessJNA.TessChoiceIterator handle);

    public static native int TessChoiceIteratorNext(
            TessJNA.TessChoiceIterator handle);

    @Deprecated
    public static native String TessChoiceIteratorGetUTF8Text(
            TessJNA.TessChoiceIterator handle);

    public static native String TessChoiceIteratorGetUTF8Text(
            TessJNA.TessChoiceIterator handle[]);

    @Deprecated
    public static native float TessChoiceIteratorConfidence(
            TessJNA.TessChoiceIterator handle);

    public static native float TessChoiceIteratorConfidence(
            TessJNA.TessChoiceIterator handle[]);

    /** Pointer to unknown (opaque) type */
    public static class Boxa extends PointerType {
        public Boxa(Pointer address) {
            super(address);
        }

        public Boxa() {
            super();
        }
    };

    /** Pointer to unknown (opaque) type */
    public static class TessChoiceIterator extends PointerType {
        public TessChoiceIterator(Pointer address) {
            super(address);
        }

        public TessChoiceIterator() {
            super();
        }
    };

    /** Pointer to unknown (opaque) type */
    public static class TessBaseAPI extends PointerType {
        public TessBaseAPI(Pointer address) {
            super(address);
        }

        public TessBaseAPI() {
            super();
        }
    };

    public static class Pix extends Structure {
        /** width in pixels */
        public int w;
        /** height in pixels */
        public int h;
        /** depth in bits (bpp) */
        public int d;
        /** number of samples per pixel */
        public int spp;
        /** 32-bit words/line */
        public int wpl;
        /** reference count (1 if no clones) */
        public int refcount;
        /** image res (ppi) in x direction */
        public int xres;
        /**
         * (use 0 if unknown)<br>
         * image res (ppi) in y direction
         */
        public int yres;
        /**
         * (use 0 if unknown)<br>
         * input file format, IFF_*
         */
        public int informat;
        /** special instructions for I/O, etc */
        public int special;
        /** text string associated with pix */
        public Pointer text;
        /** colormap (may be null) */
        public PixColormap.ByReference colormap;
        /** the image data */
        public IntByReference data;

        public Pix() {
            super();
        }

        protected List<?> getFieldOrder() {
            return Arrays.asList("w", "h", "d", "spp", "wpl", "refcount",
                    "xres",
                    "yres", "informat", "special", "text", "colormap", "data");
        }

        public Pix(Pointer peer) {
            super(peer);
        }

        public static class ByReference extends Pix implements
                Structure.ByReference {

        };

        public static class ByValue extends Pix implements Structure.ByValue {

        };
    }

    /** Pointer to unknown (opaque) type */
    public static class FILE extends PointerType {
        public FILE(Pointer address) {
            super(address);
        }

        public FILE() {
            super();
        }
    };

    /** Pointer to unknown (opaque) type */
    public static class ETEXT_DESC extends PointerType {
        public ETEXT_DESC(Pointer address) {
            super(address);
        }

        public ETEXT_DESC() {
            super();
        }
    };

    /** Pointer to unknown (opaque) type */
    public static class TessPageIterator extends PointerType {
        public TessPageIterator(Pointer address) {
            super(address);
        }

        public TessPageIterator() {
            super();
        }
    };

    /** Pointer to unknown (opaque) type */
    public static class TessResultIterator extends PointerType {
        public TessResultIterator(Pointer address) {
            super(address);
        }

        public TessResultIterator() {
            super();
        }
    };

    /** Pointer to unknown (opaque) type */
    public static class TessMutableIterator extends PointerType {
        public TessMutableIterator(Pointer address) {
            super(address);
        }

        public TessMutableIterator() {
            super();
        }
    };

    /** Pointer to unknown (opaque) type */
    public static class TessResultRenderer extends PointerType {
        public TessResultRenderer(Pointer address) {
            super(address);
        }

        public TessResultRenderer() {
            super();
        }
    };

    /** Pointer to unknown (opaque) type */
    public static class Pixa extends PointerType {
        public Pixa(Pointer address) {
            super(address);
        }

        public Pixa() {
            super();
        }
    };
}
