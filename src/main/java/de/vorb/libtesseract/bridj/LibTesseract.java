package de.vorb.libtesseract.bridj;

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

@Library("tesseract")
@Runtime(CRuntime.class)
public class LibTesseract {
  static {
    BridJ.register();
  }

  /** enum values */
  public enum TessOcrEngineMode implements IntValuedEnum<TessOcrEngineMode> {
    OEM_TESSERACT_ONLY(0), OEM_CUBE_ONLY(1), OEM_TESSERACT_CUBE_COMBINED(2), OEM_DEFAULT(
        3);
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

  /** enum values */
  public enum TessPageSegMode implements IntValuedEnum<TessPageSegMode> {
    PSM_OSD_ONLY(0), PSM_AUTO_OSD(1), PSM_AUTO_ONLY(2), PSM_AUTO(3), PSM_SINGLE_COLUMN(
        4), PSM_SINGLE_BLOCK_VERT_TEXT(5), PSM_SINGLE_BLOCK(6), PSM_SINGLE_LINE(
        7), PSM_SINGLE_WORD(8), PSM_CIRCLE_WORD(9), PSM_SINGLE_CHAR(10), PSM_SPARSE_TEXT(
        11), PSM_SPARSE_TEXT_OSD(12), PSM_COUNT(13);
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

  /** enum values */
  public enum TessPageIteratorLevel implements
      IntValuedEnum<TessPageIteratorLevel> {
    RIL_BLOCK(0), RIL_PARA(1), RIL_TEXTLINE(2), RIL_WORD(3), RIL_SYMBOL(4);
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

  /** enum values */
  public enum TessPolyBlockType implements IntValuedEnum<TessPolyBlockType> {
    PT_UNKNOWN(0), PT_FLOWING_TEXT(1), PT_HEADING_TEXT(2), PT_PULLOUT_TEXT(3), PT_TABLE(
        4), PT_VERTICAL_TEXT(5), PT_CAPTION_TEXT(6), PT_FLOWING_IMAGE(7), PT_HEADING_IMAGE(
        8), PT_PULLOUT_IMAGE(9), PT_HORZ_LINE(10), PT_VERT_LINE(11), PT_NOISE(
        12), PT_COUNT(13);
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

  /** enum values */
  public enum TessOrientation implements IntValuedEnum<TessOrientation> {
    ORIENTATION_PAGE_UP(0), ORIENTATION_PAGE_RIGHT(1), ORIENTATION_PAGE_DOWN(2), ORIENTATION_PAGE_LEFT(
        3);
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

  /** enum values */
  public enum TessWritingDirection implements
      IntValuedEnum<TessWritingDirection> {
    WRITING_DIRECTION_LEFT_TO_RIGHT(0), WRITING_DIRECTION_RIGHT_TO_LEFT(1), WRITING_DIRECTION_TOP_TO_BOTTOM(
        2);
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

  /** enum values */
  public enum TessTextlineOrder implements IntValuedEnum<TessTextlineOrder> {
    TEXTLINE_ORDER_LEFT_TO_RIGHT(0), TEXTLINE_ORDER_RIGHT_TO_LEFT(1), TEXTLINE_ORDER_TOP_TO_BOTTOM(
        2);
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

  public static final int TRUE = (int) 1;
  public static final int FALSE = (int) 0;

  /**
   * Original signature : <code>char* TessVersion()</code><br>
   * <i>native declaration : line 88</i>
   */
  @Name("TessVersion")
  native public static Pointer<Byte> TessVersion();

  /**
   * Original signature : <code>void TessDeleteText(char*)</code><br>
   * <i>native declaration : line 90</i>
   */
  @Name("TessDeleteText")
  native public static void TessDeleteText(Pointer<Byte> text);

  /**
   * Original signature : <code>void TessDeleteTextArray(char**)</code><br>
   * <i>native declaration : line 91</i>
   */
  @Name("TessDeleteTextArray")
  native public static void TessDeleteTextArray(Pointer<Pointer<Byte>> arr);

  /**
   * Original signature : <code>void TessDeleteIntArray(int*)</code><br>
   * <i>native declaration : line 92</i>
   */
  @Name("TessDeleteIntArray")
  native public static void TessDeleteIntArray(Pointer<Integer> arr);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessTextRendererCreate()</code><br>
   * <i>native declaration : line 98</i>
   */
  @Name("TessTextRendererCreate")
  native public static Pointer<LibTesseract.TessResultRenderer> TessTextRendererCreate();

  /**
   * Original signature :
   * <code>TessResultRenderer* TessHOcrRendererCreate()</code><br>
   * <i>native declaration : line 99</i>
   */
  @Name("TessHOcrRendererCreate")
  native public static Pointer<LibTesseract.TessResultRenderer> TessHOcrRendererCreate();

  /**
   * Original signature :
   * <code>TessResultRenderer* TessPDFRendererCreate(const char*)</code><br>
   * <i>native declaration : line 100</i>
   */
  @Name("TessPDFRendererCreate")
  native public static Pointer<LibTesseract.TessResultRenderer> TessPDFRendererCreate(
      Pointer<Byte> datadir);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessUnlvRendererCreate()</code><br>
   * <i>native declaration : line 101</i>
   */
  @Name("TessUnlvRendererCreate")
  native public static Pointer<LibTesseract.TessResultRenderer> TessUnlvRendererCreate();

  /**
   * Original signature :
   * <code>TessResultRenderer* TessBoxTextRendererCreate()</code><br>
   * <i>native declaration : line 102</i>
   */
  @Name("TessBoxTextRendererCreate")
  native public static Pointer<LibTesseract.TessResultRenderer> TessBoxTextRendererCreate();

  /**
   * Original signature :
   * <code>void TessDeleteResultRenderer(TessResultRenderer*)</code><br>
   * <i>native declaration : line 104</i>
   */
  @Name("TessDeleteResultRenderer")
  native public static void TessDeleteResultRenderer(
      Pointer<LibTesseract.TessResultRenderer> renderer);

  /**
   * Original signature :
   * <code>void TessResultRendererInsert(TessResultRenderer*, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 105</i>
   */
  @Name("TessResultRendererInsert")
  native public static void TessResultRendererInsert(
      Pointer<LibTesseract.TessResultRenderer> renderer,
      Pointer<LibTesseract.TessResultRenderer> next);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessResultRendererNext(TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 106</i>
   */
  @Name("TessResultRendererNext")
  native public static Pointer<LibTesseract.TessResultRenderer> TessResultRendererNext(
      Pointer<LibTesseract.TessResultRenderer> renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererBeginDocument(TessResultRenderer*, const char*)</code>
   * <br>
   * <i>native declaration : line 108</i>
   */
  @Name("TessResultRendererBeginDocument")
  native public static int TessResultRendererBeginDocument(
      Pointer<LibTesseract.TessResultRenderer> renderer, Pointer<Byte> title);

  /**
   * Original signature :
   * <code>int TessResultRendererAddImage(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 109</i>
   */
  @Name("TessResultRendererAddImage")
  native public static int TessResultRendererAddImage(
      Pointer<LibTesseract.TessResultRenderer> renderer,
      Pointer<LibTesseract.TessBaseAPI> api);

  /**
   * Original signature :
   * <code>int TessResultRendererAddError(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 110</i>
   */
  @Name("TessResultRendererAddError")
  native public static int TessResultRendererAddError(
      Pointer<LibTesseract.TessResultRenderer> renderer,
      Pointer<LibTesseract.TessBaseAPI> api);

  /**
   * Original signature :
   * <code>int TessResultRendererEndDocument(TessResultRenderer*)</code><br>
   * <i>native declaration : line 111</i>
   */
  @Name("TessResultRendererEndDocument")
  native public static int TessResultRendererEndDocument(
      Pointer<LibTesseract.TessResultRenderer> renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererGetOutput(TessResultRenderer*, const char**, int*)</code>
   * <br>
   * <i>native declaration : line 112</i>
   */
  @Name("TessResultRendererGetOutput")
  native public static int TessResultRendererGetOutput(
      Pointer<LibTesseract.TessResultRenderer> renderer,
      Pointer<Pointer<Byte>> data, Pointer<Integer> data_len);

  /**
   * Original signature :
   * <code>char* TessResultRendererTypename(TessResultRenderer*)</code><br>
   * <i>native declaration : line 114</i>
   */
  @Name("TessResultRendererTypename")
  native public static Pointer<Byte> TessResultRendererTypename(
      Pointer<LibTesseract.TessResultRenderer> renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererExtention(TessResultRenderer*)</code><br>
   * <i>native declaration : line 115</i>
   */
  @Name("TessResultRendererExtention")
  native public static Pointer<Byte> TessResultRendererExtention(
      Pointer<LibTesseract.TessResultRenderer> renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererTitle(TessResultRenderer*)</code><br>
   * <i>native declaration : line 116</i>
   */
  @Name("TessResultRendererTitle")
  native public static Pointer<Byte> TessResultRendererTitle(
      Pointer<LibTesseract.TessResultRenderer> renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererImageNum(TessResultRenderer*)</code><br>
   * <i>native declaration : line 117</i>
   */
  @Name("TessResultRendererImageNum")
  native public static int TessResultRendererImageNum(
      Pointer<LibTesseract.TessResultRenderer> renderer);

  /**
   * Original signature : <code>TessBaseAPI* TessBaseAPICreate()</code><br>
   * <i>native declaration : line 121</i>
   */
  @Name("TessBaseAPICreate")
  native public static Pointer<LibTesseract.TessBaseAPI> TessBaseAPICreate();

  /**
   * Original signature : <code>void TessBaseAPIDelete(TessBaseAPI*)</code><br>
   * <i>native declaration : line 123</i>
   */
  @Name("TessBaseAPIDelete")
  native public static void TessBaseAPIDelete(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>size_t TessBaseAPIGetOpenCLDevice(TessBaseAPI*, void**)</code><br>
   * <i>native declaration : line 125</i>
   */
  @Name("TessBaseAPIGetOpenCLDevice")
  @Ptr
  native public static long TessBaseAPIGetOpenCLDevice(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Pointer<?>> device);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 127</i>
   */
  @Name("TessBaseAPISetInputName")
  native public static void TessBaseAPISetInputName(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> name);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInputName(TessBaseAPI*)</code><br>
   * <i>native declaration : line 128</i>
   */
  @Name("TessBaseAPIGetInputName")
  native public static Pointer<Byte> TessBaseAPIGetInputName(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputImage(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 130</i>
   */
  @Name("TessBaseAPISetInputImage")
  native public static void TessBaseAPISetInputImage(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<LibTesseract.Pix> pix);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetInputImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 131</i>
   */
  @Name("TessBaseAPIGetInputImage")
  native public static Pointer<LibTesseract.Pix> TessBaseAPIGetInputImage(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetSourceYResolution(TessBaseAPI*)</code><br>
   * <i>native declaration : line 133</i>
   */
  @Name("TessBaseAPIGetSourceYResolution")
  native public static int TessBaseAPIGetSourceYResolution(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetDatapath(TessBaseAPI*)</code><br>
   * <i>native declaration : line 134</i>
   */
  @Name("TessBaseAPIGetDatapath")
  native public static Pointer<Byte> TessBaseAPIGetDatapath(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 136</i>
   */
  @Name("TessBaseAPISetOutputName")
  native public static void TessBaseAPISetOutputName(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> name);

  /**
   * Original signature :
   * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 138</i>
   */
  @Name("TessBaseAPISetVariable")
  native public static int TessBaseAPISetVariable(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> name,
      Pointer<Byte> value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 139</i>
   */
  @Name("TessBaseAPISetDebugVariable")
  native public static int TessBaseAPISetDebugVariable(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> name,
      Pointer<Byte> value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 141</i>
   */
  @Name("TessBaseAPIGetIntVariable")
  native public static int TessBaseAPIGetIntVariable(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> name,
      Pointer<Integer> value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 142</i>
   */
  @Name("TessBaseAPIGetBoolVariable")
  native public static int TessBaseAPIGetBoolVariable(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> name,
      Pointer<Integer> value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
   * <br>
   * <i>native declaration : line 143</i>
   */
  @Name("TessBaseAPIGetDoubleVariable")
  native public static int TessBaseAPIGetDoubleVariable(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> name,
      Pointer<Double> value);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 144</i>
   */
  @Name("TessBaseAPIGetStringVariable")
  native public static Pointer<Byte> TessBaseAPIGetStringVariable(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> name);

  /**
   * Original signature :
   * <code>void TessBaseAPIPrintVariables(const TessBaseAPI*, FILE*)</code><br>
   * <i>native declaration : line 147</i>
   */
  @Name("TessBaseAPIPrintVariables")
  native public static void TessBaseAPIPrintVariables(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<LibTesseract.FILE> fp);

  /**
   * Original signature :
   * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 148</i>
   */
  @Name("TessBaseAPIPrintVariablesToFile")
  native public static int TessBaseAPIPrintVariablesToFile(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> filename);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
   * <br>
   * <i>native declaration : line 159</i>
   */
  @Name("TessBaseAPIInit1")
  native public static int TessBaseAPIInit1(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
      Pointer<Byte> language,
      IntValuedEnum<LibTesseract.TessOcrEngineMode> oem,
      Pointer<Pointer<Byte>> configs, int configs_size);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
   * <br>
   * <i>native declaration : line 161</i>
   */
  @Name("TessBaseAPIInit2")
  native public static int TessBaseAPIInit2(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
      Pointer<Byte> language, IntValuedEnum<LibTesseract.TessOcrEngineMode> oem);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
   * <i>native declaration : line 162</i>
   */
  @Name("TessBaseAPIInit3")
  native public static int TessBaseAPIInit3(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
      Pointer<Byte> language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit4(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int, char**, char**, size_t, int)</code>
   * <br>
   * <i>native declaration : line 164</i>
   */
  @Name("TessBaseAPIInit4")
  native public static int TessBaseAPIInit4(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
      Pointer<Byte> language,
      IntValuedEnum<LibTesseract.TessOcrEngineMode> mode,
      Pointer<Pointer<Byte>> configs, int configs_size,
      Pointer<Pointer<Byte>> vars_vec, Pointer<Pointer<Byte>> vars_values,
      @Ptr long vars_vec_size, int set_only_non_debug_params);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInitLanguagesAsString(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 169</i>
   */
  @Name("TessBaseAPIGetInitLanguagesAsString")
  native public static Pointer<Byte> TessBaseAPIGetInitLanguagesAsString(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetLoadedLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 171</i>
   */
  @Name("TessBaseAPIGetLoadedLanguagesAsVector")
  native public static Pointer<Pointer<Byte>> TessBaseAPIGetLoadedLanguagesAsVector(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetAvailableLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 173</i>
   */
  @Name("TessBaseAPIGetAvailableLanguagesAsVector")
  native public static Pointer<Pointer<Byte>> TessBaseAPIGetAvailableLanguagesAsVector(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 176</i>
   */
  @Name("TessBaseAPIInitLangMod")
  native public static int TessBaseAPIInitLangMod(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> datapath,
      Pointer<Byte> language);

  /**
   * Original signature :
   * <code>void TessBaseAPIInitForAnalysePage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 177</i>
   */
  @Name("TessBaseAPIInitForAnalysePage")
  native public static void TessBaseAPIInitForAnalysePage(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 179</i>
   */
  @Name("TessBaseAPIReadConfigFile")
  native public static void TessBaseAPIReadConfigFile(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 180</i>
   */
  @Name("TessBaseAPIReadDebugConfigFile")
  native public static void TessBaseAPIReadDebugConfigFile(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> filename);

  /**
   * Original signature :
   * <code>void TessBaseAPISetPageSegMode(TessBaseAPI*, TessPageSegMode)</code><br>
   * <i>native declaration : line 182</i>
   */
  @Name("TessBaseAPISetPageSegMode")
  native public static void TessBaseAPISetPageSegMode(
      Pointer<LibTesseract.TessBaseAPI> handle,
      IntValuedEnum<LibTesseract.TessPageSegMode> mode);

  /**
   * Original signature :
   * <code>TessPageSegMode TessBaseAPIGetPageSegMode(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 183</i>
   */
  @Name("TessBaseAPIGetPageSegMode")
  native public static IntValuedEnum<LibTesseract.TessPageSegMode> TessBaseAPIGetPageSegMode(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 186</i>
   */
  @Name("TessBaseAPIRect")
  native public static Pointer<Byte> TessBaseAPIRect(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> imagedata,
      int bytes_per_pixel, int bytes_per_line, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>void TessBaseAPIClearAdaptiveClassifier(TessBaseAPI*)</code><br>
   * <i>native declaration : line 190</i>
   */
  @Name("TessBaseAPIClearAdaptiveClassifier")
  native public static void TessBaseAPIClearAdaptiveClassifier(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 192</i>
   */
  @Name("TessBaseAPISetImage")
  native public static void TessBaseAPISetImage(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> imagedata,
      int width, int height, int bytes_per_pixel, int bytes_per_line);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage2(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 194</i>
   */
  @Name("TessBaseAPISetImage2")
  native public static void TessBaseAPISetImage2(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<LibTesseract.Pix> pix);

  /**
   * Original signature :
   * <code>void TessBaseAPISetSourceResolution(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 196</i>
   */
  @Name("TessBaseAPISetSourceResolution")
  native public static void TessBaseAPISetSourceResolution(
      Pointer<LibTesseract.TessBaseAPI> handle, int ppi);

  /**
   * Original signature :
   * <code>void TessBaseAPISetRectangle(TessBaseAPI*, int, int, int, int)</code><br>
   * <i>native declaration : line 198</i>
   */
  @Name("TessBaseAPISetRectangle")
  native public static void TessBaseAPISetRectangle(
      Pointer<LibTesseract.TessBaseAPI> handle, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetThresholdedImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 204</i>
   */
  @Name("TessBaseAPIGetThresholdedImage")
  native public static Pointer<LibTesseract.Pix> TessBaseAPIGetThresholdedImage(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetRegions(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 206</i>
   */
  @Name("TessBaseAPIGetRegions")
  native public static Pointer<LibTesseract.Boxa> TessBaseAPIGetRegions(
      Pointer<LibTesseract.TessBaseAPI> handle,
      Pointer<Pointer<LibTesseract.Pixa>> pixa);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 208</i>
   */
  @Name("TessBaseAPIGetTextlines")
  native public static Pointer<LibTesseract.Boxa> TessBaseAPIGetTextlines(
      Pointer<LibTesseract.TessBaseAPI> handle,
      Pointer<Pointer<LibTesseract.Pixa>> pixa,
      Pointer<Pointer<Integer>> blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines1(TessBaseAPI*, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 210</i>
   */
  @Name("TessBaseAPIGetTextlines1")
  native public static Pointer<LibTesseract.Boxa> TessBaseAPIGetTextlines1(
      Pointer<LibTesseract.TessBaseAPI> handle, int raw_image, int raw_padding,
      Pointer<Pointer<LibTesseract.Pixa>> pixa,
      Pointer<Pointer<Integer>> blockids, Pointer<Pointer<Integer>> paraids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetStrips(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 213</i>
   */
  @Name("TessBaseAPIGetStrips")
  native public static Pointer<LibTesseract.Boxa> TessBaseAPIGetStrips(
      Pointer<LibTesseract.TessBaseAPI> handle,
      Pointer<Pointer<LibTesseract.Pixa>> pixa,
      Pointer<Pointer<Integer>> blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetWords(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 215</i>
   */
  @Name("TessBaseAPIGetWords")
  native public static Pointer<LibTesseract.Boxa> TessBaseAPIGetWords(
      Pointer<LibTesseract.TessBaseAPI> handle,
      Pointer<Pointer<LibTesseract.Pixa>> pixa);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetConnectedComponents(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 217</i>
   */
  @Name("TessBaseAPIGetConnectedComponents")
  native public static Pointer<LibTesseract.Boxa> TessBaseAPIGetConnectedComponents(
      Pointer<LibTesseract.TessBaseAPI> handle,
      Pointer<Pointer<LibTesseract.Pixa>> cc);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages(TessBaseAPI*, const TessPageIteratorLevel, const int, Pixa**, int**)</code>
   * <br>
   * <i>native declaration : line 219</i>
   */
  @Name("TessBaseAPIGetComponentImages")
  native public static Pointer<LibTesseract.Boxa> TessBaseAPIGetComponentImages(
      Pointer<LibTesseract.TessBaseAPI> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level, int text_only,
      Pointer<Pointer<LibTesseract.Pixa>> pixa,
      Pointer<Pointer<Integer>> blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages1(TessBaseAPI*, const TessPageIteratorLevel, const int, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 222</i>
   */
  @Name("TessBaseAPIGetComponentImages1")
  native public static Pointer<LibTesseract.Boxa> TessBaseAPIGetComponentImages1(
      Pointer<LibTesseract.TessBaseAPI> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level, int text_only,
      int raw_image, int raw_padding, Pointer<Pointer<LibTesseract.Pixa>> pixa,
      Pointer<Pointer<Integer>> blockids, Pointer<Pointer<Integer>> paraids);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetThresholdedImageScaleFactor(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 227</i>
   */
  @Name("TessBaseAPIGetThresholdedImageScaleFactor")
  native public static int TessBaseAPIGetThresholdedImageScaleFactor(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 229</i>
   */
  @Name("TessBaseAPIDumpPGM")
  native public static void TessBaseAPIDumpPGM(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> filename);

  /**
   * Original signature :
   * <code>TessPageIterator* TessBaseAPIAnalyseLayout(TessBaseAPI*)</code><br>
   * <i>native declaration : line 231</i>
   */
  @Name("TessBaseAPIAnalyseLayout")
  native public static Pointer<LibTesseract.TessPageIterator> TessBaseAPIAnalyseLayout(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognize(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 234</i>
   */
  @Name("TessBaseAPIRecognize")
  native public static int TessBaseAPIRecognize(
      Pointer<LibTesseract.TessBaseAPI> handle,
      Pointer<LibTesseract.ETEXT_DESC> monitor);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognizeForChopTest(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 235</i>
   */
  @Name("TessBaseAPIRecognizeForChopTest")
  native public static int TessBaseAPIRecognizeForChopTest(
      Pointer<LibTesseract.TessBaseAPI> handle,
      Pointer<LibTesseract.ETEXT_DESC> monitor);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 236</i>
   */
  @Name("TessBaseAPIProcessPages")
  native public static Pointer<Byte> TessBaseAPIProcessPages(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> filename,
      Pointer<Byte> retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPages1(TessBaseAPI*, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 238</i>
   */
  @Name("TessBaseAPIProcessPages1")
  native public static int TessBaseAPIProcessPages1(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> filename,
      Pointer<Byte> retry_config, int timeout_millisec,
      Pointer<LibTesseract.TessResultRenderer> renderer);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, Pix*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 240</i>
   */
  @Name("TessBaseAPIProcessPage")
  native public static Pointer<Byte> TessBaseAPIProcessPage(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<LibTesseract.Pix> pix,
      int page_index, Pointer<Byte> filename, Pointer<Byte> retry_config,
      int timeout_millisec);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPage1(TessBaseAPI*, Pix*, int, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 242</i>
   */
  @Name("TessBaseAPIProcessPage1")
  native public static int TessBaseAPIProcessPage1(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<LibTesseract.Pix> pix,
      int page_index, Pointer<Byte> filename, Pointer<Byte> retry_config,
      int timeout_millisec, Pointer<LibTesseract.TessResultRenderer> renderer);

  /**
   * Original signature :
   * <code>TessResultIterator* TessBaseAPIGetIterator(TessBaseAPI*)</code><br>
   * <i>native declaration : line 245</i>
   */
  @Name("TessBaseAPIGetIterator")
  native public static Pointer<LibTesseract.TessResultIterator> TessBaseAPIGetIterator(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>TessMutableIterator* TessBaseAPIGetMutableIterator(TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 247</i>
   */
  @Name("TessBaseAPIGetMutableIterator")
  native public static Pointer<LibTesseract.TessMutableIterator> TessBaseAPIGetMutableIterator(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUTF8Text(TessBaseAPI*)</code><br>
   * <i>native declaration : line 250</i>
   */
  @Name("TessBaseAPIGetUTF8Text")
  native public static Pointer<Byte> TessBaseAPIGetUTF8Text(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetHOCRText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 251</i>
   */
  @Name("TessBaseAPIGetHOCRText")
  native public static Pointer<Byte> TessBaseAPIGetHOCRText(
      Pointer<LibTesseract.TessBaseAPI> handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetBoxText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 252</i>
   */
  @Name("TessBaseAPIGetBoxText")
  native public static Pointer<Byte> TessBaseAPIGetBoxText(
      Pointer<LibTesseract.TessBaseAPI> handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUNLVText(TessBaseAPI*)</code><br>
   * <i>native declaration : line 253</i>
   */
  @Name("TessBaseAPIGetUNLVText")
  native public static Pointer<Byte> TessBaseAPIGetUNLVText(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature : <code>int TessBaseAPIMeanTextConf(TessBaseAPI*)</code><br>
   * <i>native declaration : line 254</i>
   */
  @Name("TessBaseAPIMeanTextConf")
  native public static int TessBaseAPIMeanTextConf(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>int* TessBaseAPIAllWordConfidences(TessBaseAPI*)</code><br>
   * <i>native declaration : line 255</i>
   */
  @Name("TessBaseAPIAllWordConfidences")
  native public static Pointer<Integer> TessBaseAPIAllWordConfidences(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
   * <br>
   * <i>native declaration : line 256</i>
   */
  @Name("TessBaseAPIAdaptToWordStr")
  native public static int TessBaseAPIAdaptToWordStr(
      Pointer<LibTesseract.TessBaseAPI> handle,
      IntValuedEnum<LibTesseract.TessPageSegMode> mode, Pointer<Byte> wordstr);

  /**
   * Original signature : <code>void TessBaseAPIClear(TessBaseAPI*)</code><br>
   * <i>native declaration : line 258</i>
   */
  @Name("TessBaseAPIClear")
  native public static void TessBaseAPIClear(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature : <code>void TessBaseAPIEnd(TessBaseAPI*)</code><br>
   * <i>native declaration : line 259</i>
   */
  @Name("TessBaseAPIEnd")
  native public static void TessBaseAPIEnd(
      Pointer<LibTesseract.TessBaseAPI> handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 261</i>
   */
  @Name("TessBaseAPIIsValidWord")
  native public static int TessBaseAPIIsValidWord(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Byte> word);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
   * <i>native declaration : line 262</i>
   */
  @Name("TessBaseAPIGetTextDirection")
  native public static int TessBaseAPIGetTextDirection(
      Pointer<LibTesseract.TessBaseAPI> handle, Pointer<Integer> out_offset,
      Pointer<Float> out_slope);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUnichar(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 280</i>
   */
  @Name("TessBaseAPIGetUnichar")
  native public static Pointer<Byte> TessBaseAPIGetUnichar(
      Pointer<LibTesseract.TessBaseAPI> handle, int unichar_id);

  /**
   * Original signature :
   * <code>void TessBaseAPISetMinOrientationMargin(TessBaseAPI*, double)</code><br>
   * <i>native declaration : line 303</i>
   */
  @Name("TessBaseAPISetMinOrientationMargin")
  native public static void TessBaseAPISetMinOrientationMargin(
      Pointer<LibTesseract.TessBaseAPI> handle, double margin);

  /**
   * Original signature :
   * <code>void TessPageIteratorDelete(TessPageIterator*)</code><br>
   * <i>native declaration : line 313</i>
   */
  @Name("TessPageIteratorDelete")
  native public static void TessPageIteratorDelete(
      Pointer<LibTesseract.TessPageIterator> handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessPageIteratorCopy(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 314</i>
   */
  @Name("TessPageIteratorCopy")
  native public static Pointer<LibTesseract.TessPageIterator> TessPageIteratorCopy(
      Pointer<LibTesseract.TessPageIterator> handle);

  /**
   * Original signature :
   * <code>void TessPageIteratorBegin(TessPageIterator*)</code><br>
   * <i>native declaration : line 317</i>
   */
  @Name("TessPageIteratorBegin")
  native public static void TessPageIteratorBegin(
      Pointer<LibTesseract.TessPageIterator> handle);

  /**
   * Original signature :
   * <code>int TessPageIteratorNext(TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 318</i>
   */
  @Name("TessPageIteratorNext")
  native public static int TessPageIteratorNext(
      Pointer<LibTesseract.TessPageIterator> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtBeginningOf(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 319</i>
   */
  @Name("TessPageIteratorIsAtBeginningOf")
  native public static int TessPageIteratorIsAtBeginningOf(
      Pointer<LibTesseract.TessPageIterator> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtFinalElement(const TessPageIterator*, TessPageIteratorLevel, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 320</i>
   */
  @Name("TessPageIteratorIsAtFinalElement")
  native public static int TessPageIteratorIsAtFinalElement(
      Pointer<LibTesseract.TessPageIterator> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> element);

  /**
   * Original signature :
   * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 323</i>
   */
  @Name("TessPageIteratorBoundingBox")
  native public static int TessPageIteratorBoundingBox(
      Pointer<LibTesseract.TessPageIterator> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level,
      Pointer<Integer> left, Pointer<Integer> top, Pointer<Integer> right,
      Pointer<Integer> bottom);

  /**
   * Original signature :
   * <code>TessPolyBlockType TessPageIteratorBlockType(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 325</i>
   */
  @Name("TessPageIteratorBlockType")
  native public static IntValuedEnum<LibTesseract.TessPolyBlockType> TessPageIteratorBlockType(
      Pointer<LibTesseract.TessPageIterator> handle);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetBinaryImage(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 328</i>
   */
  @Name("TessPageIteratorGetBinaryImage")
  native public static Pointer<LibTesseract.Pix> TessPageIteratorGetBinaryImage(
      Pointer<LibTesseract.TessPageIterator> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 330</i>
   */
  @Name("TessPageIteratorGetImage")
  native public static Pointer<LibTesseract.Pix> TessPageIteratorGetImage(
      Pointer<LibTesseract.TessPageIterator> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level, int padding,
      Pointer<Integer> left, Pointer<Integer> top);

  /**
   * Original signature :
   * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 334</i>
   */
  @Name("TessPageIteratorBaseline")
  native public static int TessPageIteratorBaseline(
      Pointer<LibTesseract.TessPageIterator> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level,
      Pointer<Integer> x1, Pointer<Integer> y1, Pointer<Integer> x2,
      Pointer<Integer> y2);

  /**
   * Original signature :
   * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
   * <br>
   * <i>native declaration : line 337</i>
   */
  @Name("TessPageIteratorOrientation")
  native public static void TessPageIteratorOrientation(
      Pointer<LibTesseract.TessPageIterator> handle,
      Pointer<IntValuedEnum<LibTesseract.TessOrientation>> orientation,
      Pointer<IntValuedEnum<LibTesseract.TessWritingDirection>> writing_direction,
      Pointer<IntValuedEnum<LibTesseract.TessTextlineOrder>> textline_order,
      Pointer<Float> deskew_angle);

  /**
   * Original signature :
   * <code>void TessResultIteratorDelete(TessResultIterator*)</code><br>
   * <i>native declaration : line 343</i>
   */
  @Name("TessResultIteratorDelete")
  native public static void TessResultIteratorDelete(
      Pointer<LibTesseract.TessResultIterator> handle);

  /**
   * Original signature :
   * <code>TessResultIterator* TessResultIteratorCopy(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 344</i>
   */
  @Name("TessResultIteratorCopy")
  native public static Pointer<LibTesseract.TessResultIterator> TessResultIteratorCopy(
      Pointer<LibTesseract.TessResultIterator> handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIterator(TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 346</i>
   */
  @Name("TessResultIteratorGetPageIterator")
  native public static Pointer<LibTesseract.TessPageIterator> TessResultIteratorGetPageIterator(
      Pointer<LibTesseract.TessResultIterator> handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIteratorConst(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 348</i>
   */
  @Name("TessResultIteratorGetPageIteratorConst")
  native public static Pointer<LibTesseract.TessPageIterator> TessResultIteratorGetPageIteratorConst(
      Pointer<LibTesseract.TessResultIterator> handle);

  /**
   * Original signature :
   * <code>char* TessResultIteratorGetUTF8Text(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 351</i>
   */
  @Name("TessResultIteratorGetUTF8Text")
  native public static Pointer<Byte> TessResultIteratorGetUTF8Text(
      Pointer<LibTesseract.TessResultIterator> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level);

  /**
   * Original signature :
   * <code>float TessResultIteratorConfidence(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 352</i>
   */
  @Name("TessResultIteratorConfidence")
  native public static float TessResultIteratorConfidence(
      Pointer<LibTesseract.TessResultIterator> handle,
      IntValuedEnum<LibTesseract.TessPageIteratorLevel> level);

  /**
   * Original signature :
   * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 354</i>
   */
  @Name("TessResultIteratorWordFontAttributes")
  native public static Pointer<Byte> TessResultIteratorWordFontAttributes(
      Pointer<LibTesseract.TessResultIterator> handle,
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
  native public static int TessResultIteratorWordIsFromDictionary(
      Pointer<LibTesseract.TessResultIterator> handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorWordIsNumeric(const TessResultIterator*)</code><br>
   * <i>native declaration : line 360</i>
   */
  @Name("TessResultIteratorWordIsNumeric")
  native public static int TessResultIteratorWordIsNumeric(
      Pointer<LibTesseract.TessResultIterator> handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSuperscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 361</i>
   */
  @Name("TessResultIteratorSymbolIsSuperscript")
  native public static int TessResultIteratorSymbolIsSuperscript(
      Pointer<LibTesseract.TessResultIterator> handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSubscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 362</i>
   */
  @Name("TessResultIteratorSymbolIsSubscript")
  native public static int TessResultIteratorSymbolIsSubscript(
      Pointer<LibTesseract.TessResultIterator> handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsDropcap(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 363</i>
   */
  @Name("TessResultIteratorSymbolIsDropcap")
  native public static int TessResultIteratorSymbolIsDropcap(
      Pointer<LibTesseract.TessResultIterator> handle);

  /** Undefined type */
  public static interface Boxa {

  };

  /** Undefined type */
  public static interface TessBaseAPI {

  };

  /** Undefined type */
  public static interface Pix {

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
  public static interface Pixa {

  };

  /** Undefined type */
  public static interface TessResultRenderer {

  };
}
