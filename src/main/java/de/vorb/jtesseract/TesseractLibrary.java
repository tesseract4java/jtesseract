package de.vorb.jtesseract;

import com.sun.jna.IntegerType;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public interface TesseractLibrary extends Library {
  public static class SizeT extends IntegerType {
    private static final long serialVersionUID = 1L;

    public SizeT() {
      this(0);
    }

    public SizeT(long value) {
      super(Native.SIZE_T_SIZE, value);
    }
  }

  /** enum values */
  public static interface TessOcrEngineMode {
    /** <i>native declaration : line 68</i> */
    public static final int OEM_TESSERACT_ONLY = 0;
    /** <i>native declaration : line 68</i> */
    public static final int OEM_CUBE_ONLY = 1;
    /** <i>native declaration : line 68</i> */
    public static final int OEM_TESSERACT_CUBE_COMBINED = 2;
    /** <i>native declaration : line 68</i> */
    public static final int OEM_DEFAULT = 3;
  };

  /** enum values */
  public static interface TessPageSegMode {
    /** <i>native declaration : line 69</i> */
    public static final int PSM_OSD_ONLY = 0;
    /** <i>native declaration : line 69</i> */
    public static final int PSM_AUTO_OSD = 1;
    /** <i>native declaration : line 69</i> */
    public static final int PSM_AUTO_ONLY = 2;
    /** <i>native declaration : line 69</i> */
    public static final int PSM_AUTO = 3;
    /** <i>native declaration : line 69</i> */
    public static final int PSM_SINGLE_COLUMN = 4;
    /** <i>native declaration : line 69</i> */
    public static final int PSM_SINGLE_BLOCK_VERT_TEXT = 5;
    /** <i>native declaration : line 70</i> */
    public static final int PSM_SINGLE_BLOCK = 6;
    /** <i>native declaration : line 70</i> */
    public static final int PSM_SINGLE_LINE = 7;
    /** <i>native declaration : line 70</i> */
    public static final int PSM_SINGLE_WORD = 8;
    /** <i>native declaration : line 70</i> */
    public static final int PSM_CIRCLE_WORD = 9;
    /** <i>native declaration : line 70</i> */
    public static final int PSM_SINGLE_CHAR = 10;
    /** <i>native declaration : line 70</i> */
    public static final int PSM_SPARSE_TEXT = 11;
    /** <i>native declaration : line 71</i> */
    public static final int PSM_SPARSE_TEXT_OSD = 12;
    /** <i>native declaration : line 71</i> */
    public static final int PSM_COUNT = 13;
  };

  /** enum values */
  public static interface TessPageIteratorLevel {
    /** <i>native declaration : line 72</i> */
    public static final int RIL_BLOCK = 0;
    /** <i>native declaration : line 72</i> */
    public static final int RIL_PARA = 1;
    /** <i>native declaration : line 72</i> */
    public static final int RIL_TEXTLINE = 2;
    /** <i>native declaration : line 72</i> */
    public static final int RIL_WORD = 3;
    /** <i>native declaration : line 72</i> */
    public static final int RIL_SYMBOL = 4;
  };

  /** enum values */
  public static interface TessPolyBlockType {
    /** <i>native declaration : line 73</i> */
    public static final int PT_UNKNOWN = 0;
    /** <i>native declaration : line 73</i> */
    public static final int PT_FLOWING_TEXT = 1;
    /** <i>native declaration : line 73</i> */
    public static final int PT_HEADING_TEXT = 2;
    /** <i>native declaration : line 73</i> */
    public static final int PT_PULLOUT_TEXT = 3;
    /** <i>native declaration : line 73</i> */
    public static final int PT_TABLE = 4;
    /** <i>native declaration : line 73</i> */
    public static final int PT_VERTICAL_TEXT = 5;
    /** <i>native declaration : line 74</i> */
    public static final int PT_CAPTION_TEXT = 6;
    /** <i>native declaration : line 74</i> */
    public static final int PT_FLOWING_IMAGE = 7;
    /** <i>native declaration : line 74</i> */
    public static final int PT_HEADING_IMAGE = 8;
    /** <i>native declaration : line 74</i> */
    public static final int PT_PULLOUT_IMAGE = 9;
    /** <i>native declaration : line 74</i> */
    public static final int PT_HORZ_LINE = 10;
    /** <i>native declaration : line 74</i> */
    public static final int PT_VERT_LINE = 11;
    /** <i>native declaration : line 75</i> */
    public static final int PT_NOISE = 12;
    /** <i>native declaration : line 75</i> */
    public static final int PT_COUNT = 13;
  };

  /** enum values */
  public static interface TessOrientation {
    /** <i>native declaration : line 76</i> */
    public static final int ORIENTATION_PAGE_UP = 0;
    /** <i>native declaration : line 76</i> */
    public static final int ORIENTATION_PAGE_RIGHT = 1;
    /** <i>native declaration : line 76</i> */
    public static final int ORIENTATION_PAGE_DOWN = 2;
    /** <i>native declaration : line 76</i> */
    public static final int ORIENTATION_PAGE_LEFT = 3;
  };

  /** enum values */
  public static interface TessWritingDirection {
    /** <i>native declaration : line 77</i> */
    public static final int WRITING_DIRECTION_LEFT_TO_RIGHT = 0;
    /** <i>native declaration : line 77</i> */
    public static final int WRITING_DIRECTION_RIGHT_TO_LEFT = 1;
    /** <i>native declaration : line 77</i> */
    public static final int WRITING_DIRECTION_TOP_TO_BOTTOM = 2;
  };

  /** enum values */
  public static interface TessTextlineOrder {
    /** <i>native declaration : line 78</i> */
    public static final int TEXTLINE_ORDER_LEFT_TO_RIGHT = 0;
    /** <i>native declaration : line 78</i> */
    public static final int TEXTLINE_ORDER_RIGHT_TO_LEFT = 1;
    /** <i>native declaration : line 78</i> */
    public static final int TEXTLINE_ORDER_TOP_TO_BOTTOM = 2;
  };

  public static final int TRUE = (int) 1;
  public static final int FALSE = (int) 0;

  /**
   * Original signature : <code>char* TessVersion()</code><br>
   * <i>native declaration : line 88</i>
   */
  String tessVersion();

  /**
   * Original signature : <code>void TessDeleteText(char*)</code><br>
   * <i>native declaration : line 90</i><br>
   * 
   * @deprecated use the safer methods {@link #tessDeleteText(java.lang.String)}
   *             and {@link #tessDeleteText(com.sun.jna.Pointer)} instead
   */
  @Deprecated
  void tessDeleteText(Pointer text);

  /**
   * Original signature : <code>void TessDeleteText(char*)</code><br>
   * <i>native declaration : line 90</i>
   */
  void tessDeleteText(String text);

  /**
   * Original signature : <code>void TessDeleteTextArray(char**)</code><br>
   * <i>native declaration : line 91</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessDeleteTextArray(java.lang.String[])} and
   *             {@link #tessDeleteTextArray(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessDeleteTextArray(PointerByReference arr);

  /**
   * Original signature : <code>void TessDeleteTextArray(char**)</code><br>
   * <i>native declaration : line 91</i>
   */
  void tessDeleteTextArray(String arr[]);

  /**
   * Original signature : <code>void TessDeleteIntArray(int*)</code><br>
   * <i>native declaration : line 92</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessDeleteIntArray(java.nio.IntBuffer)} and
   *             {@link #tessDeleteIntArray(com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  void tessDeleteIntArray(IntByReference arr);

  /**
   * Original signature : <code>void TessDeleteIntArray(int*)</code><br>
   * <i>native declaration : line 92</i>
   */
  void tessDeleteIntArray(IntBuffer arr);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessTextRendererCreate()</code><br>
   * <i>native declaration : line 98</i>
   */
  PointerByReference tessTextRendererCreate();

  /**
   * Original signature :
   * <code>TessResultRenderer* TessHOcrRendererCreate()</code><br>
   * <i>native declaration : line 99</i>
   */
  PointerByReference tessHOcrRendererCreate();

  /**
   * Original signature :
   * <code>TessResultRenderer* TessPDFRendererCreate(const char*)</code><br>
   * <i>native declaration : line 100</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessPDFRendererCreate(java.lang.String)} and
   *             {@link #tessPDFRendererCreate(com.sun.jna.Pointer)} instead
   */
  @Deprecated
  PointerByReference tessPDFRendererCreate(Pointer datadir);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessPDFRendererCreate(const char*)</code><br>
   * <i>native declaration : line 100</i>
   */
  PointerByReference tessPDFRendererCreate(String datadir);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessUnlvRendererCreate()</code><br>
   * <i>native declaration : line 101</i>
   */
  PointerByReference tessUnlvRendererCreate();

  /**
   * Original signature :
   * <code>TessResultRenderer* TessBoxTextRendererCreate()</code><br>
   * <i>native declaration : line 102</i>
   */
  PointerByReference tessBoxTextRendererCreate();

  /**
   * Original signature :
   * <code>void TessDeleteResultRenderer(TessResultRenderer*)</code><br>
   * <i>native declaration : line 104</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessDeleteResultRenderer(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessDeleteResultRenderer(Pointer renderer);

  /**
   * Original signature :
   * <code>void TessDeleteResultRenderer(TessResultRenderer*)</code><br>
   * <i>native declaration : line 104</i>
   */
  void tessDeleteResultRenderer(PointerByReference renderer);

  /**
   * Original signature :
   * <code>void TessResultRendererInsert(TessResultRenderer*, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 105</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultRendererInsert(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessResultRendererInsert(Pointer renderer, Pointer next);

  /**
   * Original signature :
   * <code>void TessResultRendererInsert(TessResultRenderer*, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 105</i>
   */
  void tessResultRendererInsert(PointerByReference renderer,
      PointerByReference next);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessResultRendererNext(TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 106</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultRendererNext(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessResultRendererNext(Pointer renderer);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessResultRendererNext(TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 106</i>
   */
  PointerByReference tessResultRendererNext(PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererBeginDocument(TessResultRenderer*, const char*)</code>
   * <br>
   * <i>native declaration : line 108</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessResultRendererBeginDocument(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #tessResultRendererBeginDocument(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int tessResultRendererBeginDocument(Pointer renderer, Pointer title);

  /**
   * Original signature :
   * <code>int TessResultRendererBeginDocument(TessResultRenderer*, const char*)</code>
   * <br>
   * <i>native declaration : line 108</i>
   */
  int tessResultRendererBeginDocument(PointerByReference renderer, String title);

  /**
   * Original signature :
   * <code>int TessResultRendererBeginDocument(TessResultRenderer*, const char*)</code>
   * <br>
   * <i>native declaration : line 108</i>
   */
  int tessResultRendererBeginDocument(PointerByReference renderer, Pointer title);

  /**
   * Original signature :
   * <code>int TessResultRendererAddImage(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 109</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultRendererAddImage(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessResultRendererAddImage(Pointer renderer, Pointer api);

  /**
   * Original signature :
   * <code>int TessResultRendererAddImage(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 109</i>
   */
  int tessResultRendererAddImage(PointerByReference renderer,
      PointerByReference api);

  /**
   * Original signature :
   * <code>int TessResultRendererAddError(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 110</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultRendererAddError(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessResultRendererAddError(Pointer renderer, Pointer api);

  /**
   * Original signature :
   * <code>int TessResultRendererAddError(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 110</i>
   */
  int tessResultRendererAddError(PointerByReference renderer,
      PointerByReference api);

  /**
   * Original signature :
   * <code>int TessResultRendererEndDocument(TessResultRenderer*)</code><br>
   * <i>native declaration : line 111</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultRendererEndDocument(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessResultRendererEndDocument(Pointer renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererEndDocument(TessResultRenderer*)</code><br>
   * <i>native declaration : line 111</i>
   */
  int tessResultRendererEndDocument(PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererGetOutput(TessResultRenderer*, const char**, int*)</code>
   * <br>
   * <i>native declaration : line 112</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessResultRendererGetOutput(com.sun.jna.ptr.PointerByReference, java.lang.String[], java.nio.IntBuffer)}
   *             and
   *             {@link #tessResultRendererGetOutput(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int tessResultRendererGetOutput(Pointer renderer, PointerByReference data,
      IntByReference data_len);

  /**
   * Original signature :
   * <code>int TessResultRendererGetOutput(TessResultRenderer*, const char**, int*)</code>
   * <br>
   * <i>native declaration : line 112</i>
   */
  int tessResultRendererGetOutput(PointerByReference renderer, String data[],
      IntBuffer data_len);

  /**
   * Original signature :
   * <code>int TessResultRendererGetOutput(TessResultRenderer*, const char**, int*)</code>
   * <br>
   * <i>native declaration : line 112</i>
   */
  int tessResultRendererGetOutput(PointerByReference renderer,
      PointerByReference data, IntByReference data_len);

  /**
   * Original signature :
   * <code>char* TessResultRendererTypename(TessResultRenderer*)</code><br>
   * <i>native declaration : line 114</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultRendererTypename(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String tessResultRendererTypename(Pointer renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererTypename(TessResultRenderer*)</code><br>
   * <i>native declaration : line 114</i>
   */
  String tessResultRendererTypename(PointerByReference renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererExtention(TessResultRenderer*)</code><br>
   * <i>native declaration : line 115</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultRendererExtention(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String tessResultRendererExtention(Pointer renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererExtention(TessResultRenderer*)</code><br>
   * <i>native declaration : line 115</i>
   */
  String tessResultRendererExtention(PointerByReference renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererTitle(TessResultRenderer*)</code><br>
   * <i>native declaration : line 116</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultRendererTitle(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String tessResultRendererTitle(Pointer renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererTitle(TessResultRenderer*)</code><br>
   * <i>native declaration : line 116</i>
   */
  String tessResultRendererTitle(PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererImageNum(TessResultRenderer*)</code><br>
   * <i>native declaration : line 117</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultRendererImageNum(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessResultRendererImageNum(Pointer renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererImageNum(TessResultRenderer*)</code><br>
   * <i>native declaration : line 117</i>
   */
  int tessResultRendererImageNum(PointerByReference renderer);

  /**
   * Original signature : <code>TessBaseAPI* TessBaseAPICreate()</code><br>
   * <i>native declaration : line 121</i>
   */
  PointerByReference tessBaseAPICreate();

  /**
   * Original signature : <code>void TessBaseAPIDelete(TessBaseAPI*)</code><br>
   * <i>native declaration : line 123</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIDelete(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIDelete(Pointer handle);

  /**
   * Original signature : <code>void TessBaseAPIDelete(TessBaseAPI*)</code><br>
   * <i>native declaration : line 123</i>
   */
  void tessBaseAPIDelete(PointerByReference handle);

  /**
   * Original signature :
   * <code>size_t TessBaseAPIGetOpenCLDevice(TessBaseAPI*, void**)</code><br>
   * <i>native declaration : line 125</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetOpenCLDevice(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  SizeT tessBaseAPIGetOpenCLDevice(Pointer handle, PointerByReference device);

  /**
   * Original signature :
   * <code>size_t TessBaseAPIGetOpenCLDevice(TessBaseAPI*, void**)</code><br>
   * <i>native declaration : line 125</i>
   */
  SizeT tessBaseAPIGetOpenCLDevice(PointerByReference handle,
      PointerByReference device);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 127</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPISetInputName(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #tessBaseAPISetInputName(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetInputName(Pointer handle, Pointer name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 127</i>
   */
  void tessBaseAPISetInputName(PointerByReference handle, String name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 127</i>
   */
  void tessBaseAPISetInputName(PointerByReference handle, Pointer name);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInputName(TessBaseAPI*)</code><br>
   * <i>native declaration : line 128</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetInputName(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIGetInputName(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInputName(TessBaseAPI*)</code><br>
   * <i>native declaration : line 128</i>
   */
  String tessBaseAPIGetInputName(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputImage(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 130</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPISetInputImage(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pix)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetInputImage(Pointer handle, TesseractLibrary.Pix pix);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputImage(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 130</i>
   */
  void tessBaseAPISetInputImage(PointerByReference handle,
      TesseractLibrary.Pix pix);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetInputImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 131</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetInputImage(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Pix tessBaseAPIGetInputImage(Pointer handle);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetInputImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 131</i>
   */
  TesseractLibrary.Pix tessBaseAPIGetInputImage(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetSourceYResolution(TessBaseAPI*)</code><br>
   * <i>native declaration : line 133</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetSourceYResolution(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIGetSourceYResolution(Pointer handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetSourceYResolution(TessBaseAPI*)</code><br>
   * <i>native declaration : line 133</i>
   */
  int tessBaseAPIGetSourceYResolution(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetDatapath(TessBaseAPI*)</code><br>
   * <i>native declaration : line 134</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetDatapath(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIGetDatapath(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetDatapath(TessBaseAPI*)</code><br>
   * <i>native declaration : line 134</i>
   */
  String tessBaseAPIGetDatapath(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 136</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPISetOutputName(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #tessBaseAPISetOutputName(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetOutputName(Pointer handle, Pointer name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 136</i>
   */
  void tessBaseAPISetOutputName(PointerByReference handle, String name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 136</i>
   */
  void tessBaseAPISetOutputName(PointerByReference handle, Pointer name);

  /**
   * Original signature :
   * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 138</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPISetVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String)}
   *             and
   *             {@link #tessBaseAPISetVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int tessBaseAPISetVariable(Pointer handle, Pointer name, Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 138</i>
   */
  int tessBaseAPISetVariable(PointerByReference handle, String name,
      String value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 138</i>
   */
  int tessBaseAPISetVariable(PointerByReference handle, Pointer name,
      Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 139</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPISetDebugVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String)}
   *             and
   *             {@link #tessBaseAPISetDebugVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int tessBaseAPISetDebugVariable(Pointer handle, Pointer name, Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 139</i>
   */
  int tessBaseAPISetDebugVariable(PointerByReference handle, String name,
      String value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 139</i>
   */
  int tessBaseAPISetDebugVariable(PointerByReference handle, Pointer name,
      Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 141</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIGetIntVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.nio.IntBuffer)}
   *             and
   *             {@link #tessBaseAPIGetIntVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIGetIntVariable(Pointer handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 141</i>
   */
  int tessBaseAPIGetIntVariable(PointerByReference handle, String name,
      IntBuffer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 141</i>
   */
  int tessBaseAPIGetIntVariable(PointerByReference handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 142</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIGetBoolVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.nio.IntBuffer)}
   *             and
   *             {@link #tessBaseAPIGetBoolVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIGetBoolVariable(Pointer handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 142</i>
   */
  int tessBaseAPIGetBoolVariable(PointerByReference handle, String name,
      IntBuffer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 142</i>
   */
  int tessBaseAPIGetBoolVariable(PointerByReference handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
   * <br>
   * <i>native declaration : line 143</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIGetDoubleVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.nio.DoubleBuffer)}
   *             and
   *             {@link #tessBaseAPIGetDoubleVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.ptr.DoubleByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIGetDoubleVariable(Pointer handle, Pointer name,
      DoubleByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
   * <br>
   * <i>native declaration : line 143</i>
   */
  int tessBaseAPIGetDoubleVariable(PointerByReference handle, String name,
      DoubleBuffer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
   * <br>
   * <i>native declaration : line 143</i>
   */
  int tessBaseAPIGetDoubleVariable(PointerByReference handle, Pointer name,
      DoubleByReference value);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 144</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIGetStringVariable(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #tessBaseAPIGetStringVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIGetStringVariable(Pointer handle, Pointer name);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 144</i>
   */
  String tessBaseAPIGetStringVariable(PointerByReference handle, String name);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 144</i>
   */
  String tessBaseAPIGetStringVariable(PointerByReference handle, Pointer name);

  /**
   * Original signature :
   * <code>void TessBaseAPIPrintVariables(const TessBaseAPI*, FILE*)</code><br>
   * <i>native declaration : line 147</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIPrintVariables(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.FILE)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIPrintVariables(Pointer handle, TesseractLibrary.FILE fp);

  /**
   * Original signature :
   * <code>void TessBaseAPIPrintVariables(const TessBaseAPI*, FILE*)</code><br>
   * <i>native declaration : line 147</i>
   */
  void tessBaseAPIPrintVariables(PointerByReference handle,
      TesseractLibrary.FILE fp);

  /**
   * Original signature :
   * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 148</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIPrintVariablesToFile(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #tessBaseAPIPrintVariablesToFile(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIPrintVariablesToFile(Pointer handle, Pointer filename);

  /**
   * Original signature :
   * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 148</i>
   */
  int tessBaseAPIPrintVariablesToFile(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 148</i>
   */
  int tessBaseAPIPrintVariablesToFile(PointerByReference handle,
      Pointer filename);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
   * <br>
   * <i>native declaration : line 159</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIInit1(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int, java.lang.String[], int)}
   *             and
   *             {@link #tessBaseAPIInit1(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int, com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIInit1(Pointer handle, Pointer datapath, Pointer language,
      int oem, PointerByReference configs, int configs_size);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
   * <br>
   * <i>native declaration : line 159</i>
   */
  int tessBaseAPIInit1(PointerByReference handle, String datapath,
      String language, int oem, String configs[], int configs_size);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
   * <br>
   * <i>native declaration : line 159</i>
   */
  int tessBaseAPIInit1(PointerByReference handle, Pointer datapath,
      Pointer language, int oem, PointerByReference configs, int configs_size);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
   * <br>
   * <i>native declaration : line 161</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIInit2(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int)}
   *             and
   *             {@link #tessBaseAPIInit2(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIInit2(Pointer handle, Pointer datapath, Pointer language,
      int oem);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
   * <br>
   * <i>native declaration : line 161</i>
   */
  int tessBaseAPIInit2(PointerByReference handle, String datapath,
      String language, int oem);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
   * <br>
   * <i>native declaration : line 161</i>
   */
  int tessBaseAPIInit2(PointerByReference handle, Pointer datapath,
      Pointer language, int oem);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
   * <i>native declaration : line 162</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIInit3(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String)}
   *             and
   *             {@link #tessBaseAPIInit3(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIInit3(Pointer handle, Pointer datapath, Pointer language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
   * <i>native declaration : line 162</i>
   */
  int tessBaseAPIInit3(PointerByReference handle, String datapath,
      String language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
   * <i>native declaration : line 162</i>
   */
  int tessBaseAPIInit3(PointerByReference handle, Pointer datapath,
      Pointer language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit4(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int, char**, char**, size_t, int)</code>
   * <br>
   * <i>native declaration : line 164</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIInit4(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int, java.lang.String[], int, java.lang.String[], java.lang.String[], com.ochafik.lang.jnaerator.runtime.NativeSize, int)}
   *             and
   *             {@link #tessBaseAPIInit4(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int, com.sun.jna.ptr.PointerByReference, int, com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference, com.ochafik.lang.jnaerator.runtime.NativeSize, int)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIInit4(Pointer handle, Pointer datapath, Pointer language,
      int mode, PointerByReference configs, int configs_size,
      PointerByReference vars_vec, PointerByReference vars_values,
      SizeT vars_vec_size, int set_only_non_debug_params);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit4(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int, char**, char**, size_t, int)</code>
   * <br>
   * <i>native declaration : line 164</i>
   */
  int tessBaseAPIInit4(PointerByReference handle, String datapath,
      String language, int mode, String configs[], int configs_size,
      String vars_vec[], String vars_values[], SizeT vars_vec_size,
      int set_only_non_debug_params);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit4(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int, char**, char**, size_t, int)</code>
   * <br>
   * <i>native declaration : line 164</i>
   */
  int tessBaseAPIInit4(PointerByReference handle, Pointer datapath,
      Pointer language, int mode, PointerByReference configs, int configs_size,
      PointerByReference vars_vec, PointerByReference vars_values,
      SizeT vars_vec_size, int set_only_non_debug_params);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInitLanguagesAsString(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 169</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetInitLanguagesAsString(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIGetInitLanguagesAsString(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInitLanguagesAsString(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 169</i>
   */
  String tessBaseAPIGetInitLanguagesAsString(PointerByReference handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetLoadedLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 171</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetLoadedLanguagesAsVector(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetLoadedLanguagesAsVector(Pointer handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetLoadedLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 171</i>
   */
  PointerByReference tessBaseAPIGetLoadedLanguagesAsVector(
      PointerByReference handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetAvailableLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 173</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetAvailableLanguagesAsVector(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetAvailableLanguagesAsVector(Pointer handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetAvailableLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 173</i>
   */
  PointerByReference tessBaseAPIGetAvailableLanguagesAsVector(
      PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 176</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIInitLangMod(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String)}
   *             and
   *             {@link #tessBaseAPIInitLangMod(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIInitLangMod(Pointer handle, Pointer datapath, Pointer language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 176</i>
   */
  int tessBaseAPIInitLangMod(PointerByReference handle, String datapath,
      String language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 176</i>
   */
  int tessBaseAPIInitLangMod(PointerByReference handle, Pointer datapath,
      Pointer language);

  /**
   * Original signature :
   * <code>void TessBaseAPIInitForAnalysePage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 177</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIInitForAnalysePage(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIInitForAnalysePage(Pointer handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIInitForAnalysePage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 177</i>
   */
  void tessBaseAPIInitForAnalysePage(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 179</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIReadConfigFile(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #tessBaseAPIReadConfigFile(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIReadConfigFile(Pointer handle, Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 179</i>
   */
  void tessBaseAPIReadConfigFile(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 179</i>
   */
  void tessBaseAPIReadConfigFile(PointerByReference handle, Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 180</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIReadDebugConfigFile(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #tessBaseAPIReadDebugConfigFile(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIReadDebugConfigFile(Pointer handle, Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 180</i>
   */
  void tessBaseAPIReadDebugConfigFile(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 180</i>
   */
  void tessBaseAPIReadDebugConfigFile(PointerByReference handle,
      Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPISetPageSegMode(TessBaseAPI*, TessPageSegMode)</code><br>
   * <i>native declaration : line 182</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPISetPageSegMode(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetPageSegMode(Pointer handle, int mode);

  /**
   * Original signature :
   * <code>void TessBaseAPISetPageSegMode(TessBaseAPI*, TessPageSegMode)</code><br>
   * <i>native declaration : line 182</i>
   */
  void tessBaseAPISetPageSegMode(PointerByReference handle, int mode);

  /**
   * Original signature :
   * <code>TessPageSegMode TessBaseAPIGetPageSegMode(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 183</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetPageSegMode(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIGetPageSegMode(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageSegMode TessBaseAPIGetPageSegMode(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 183</i>
   */
  int tessBaseAPIGetPageSegMode(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 186</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIRect(com.sun.jna.ptr.PointerByReference, byte[], int, int, int, int, int, int)}
   *             and
   *             {@link #tessBaseAPIRect(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, int, int, int, int, int, int)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIRect(Pointer handle, Pointer imagedata,
      int bytes_per_pixel, int bytes_per_line, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 186</i>
   */
  String tessBaseAPIRect(PointerByReference handle, byte imagedata[],
      int bytes_per_pixel, int bytes_per_line, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 186</i>
   */
  String tessBaseAPIRect(PointerByReference handle, Pointer imagedata,
      int bytes_per_pixel, int bytes_per_line, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>void TessBaseAPIClearAdaptiveClassifier(TessBaseAPI*)</code><br>
   * <i>native declaration : line 190</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIClearAdaptiveClassifier(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIClearAdaptiveClassifier(Pointer handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIClearAdaptiveClassifier(TessBaseAPI*)</code><br>
   * <i>native declaration : line 190</i>
   */
  void tessBaseAPIClearAdaptiveClassifier(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 192</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPISetImage(com.sun.jna.ptr.PointerByReference, byte[], int, int, int, int)}
   *             and
   *             {@link #tessBaseAPISetImage(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, int, int, int, int)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetImage(Pointer handle, Pointer imagedata, int width,
      int height, int bytes_per_pixel, int bytes_per_line);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 192</i>
   */
  void tessBaseAPISetImage(PointerByReference handle, byte imagedata[],
      int width, int height, int bytes_per_pixel, int bytes_per_line);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 192</i>
   */
  void tessBaseAPISetImage(PointerByReference handle, Pointer imagedata,
      int width, int height, int bytes_per_pixel, int bytes_per_line);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage2(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 194</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPISetImage2(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pix)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetImage2(Pointer handle, TesseractLibrary.Pix pix);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage2(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 194</i>
   */
  void tessBaseAPISetImage2(PointerByReference handle, TesseractLibrary.Pix pix);

  /**
   * Original signature :
   * <code>void TessBaseAPISetSourceResolution(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 196</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPISetSourceResolution(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetSourceResolution(Pointer handle, int ppi);

  /**
   * Original signature :
   * <code>void TessBaseAPISetSourceResolution(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 196</i>
   */
  void tessBaseAPISetSourceResolution(PointerByReference handle, int ppi);

  /**
   * Original signature :
   * <code>void TessBaseAPISetRectangle(TessBaseAPI*, int, int, int, int)</code><br>
   * <i>native declaration : line 198</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPISetRectangle(com.sun.jna.ptr.PointerByReference, int, int, int, int)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetRectangle(Pointer handle, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>void TessBaseAPISetRectangle(TessBaseAPI*, int, int, int, int)</code><br>
   * <i>native declaration : line 198</i>
   */
  void tessBaseAPISetRectangle(PointerByReference handle, int left, int top,
      int width, int height);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetThresholdedImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 204</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetThresholdedImage(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Pix tessBaseAPIGetThresholdedImage(Pointer handle);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetThresholdedImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 204</i>
   */
  TesseractLibrary.Pix tessBaseAPIGetThresholdedImage(PointerByReference handle);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetRegions(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 206</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIGetRegions(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             and
   *             {@link #tessBaseAPIGetRegions(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pixa[])}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Boxa tessBaseAPIGetRegions(Pointer handle,
      PointerByReference pixa);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetRegions(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 206</i>
   */
  TesseractLibrary.Boxa tessBaseAPIGetRegions(PointerByReference handle,
      PointerByReference pixa);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetRegions(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 206</i>
   */
  TesseractLibrary.Boxa tessBaseAPIGetRegions(PointerByReference handle,
      TesseractLibrary.Pixa pixa[]);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 208</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetTextlines(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Boxa tessBaseAPIGetTextlines(Pointer handle,
      PointerByReference pixa, PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 208</i>
   */
  TesseractLibrary.Boxa tessBaseAPIGetTextlines(PointerByReference handle,
      TesseractLibrary.Pixa pixa[], PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines1(TessBaseAPI*, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 210</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetTextlines1(com.sun.jna.ptr.PointerByReference, int, int, tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Boxa tessBaseAPIGetTextlines1(Pointer handle, int raw_image,
      int raw_padding, PointerByReference pixa, PointerByReference blockids,
      PointerByReference paraids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines1(TessBaseAPI*, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 210</i>
   */
  TesseractLibrary.Boxa tessBaseAPIGetTextlines1(PointerByReference handle,
      int raw_image, int raw_padding, TesseractLibrary.Pixa pixa[],
      PointerByReference blockids, PointerByReference paraids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetStrips(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 213</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetStrips(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Boxa tessBaseAPIGetStrips(Pointer handle,
      PointerByReference pixa, PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetStrips(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 213</i>
   */
  TesseractLibrary.Boxa tessBaseAPIGetStrips(PointerByReference handle,
      TesseractLibrary.Pixa pixa[], PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetWords(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 215</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetWords(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pixa[])}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Boxa tessBaseAPIGetWords(Pointer handle,
      PointerByReference pixa);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetWords(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 215</i>
   */
  TesseractLibrary.Boxa tessBaseAPIGetWords(PointerByReference handle,
      TesseractLibrary.Pixa pixa[]);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetConnectedComponents(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 217</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetConnectedComponents(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pixa[])}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Boxa tessBaseAPIGetConnectedComponents(Pointer handle,
      PointerByReference cc);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetConnectedComponents(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 217</i>
   */
  TesseractLibrary.Boxa tessBaseAPIGetConnectedComponents(
      PointerByReference handle, TesseractLibrary.Pixa cc[]);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages(TessBaseAPI*, const TessPageIteratorLevel, const int, Pixa**, int**)</code>
   * <br>
   * <i>native declaration : line 219</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetComponentImages(com.sun.jna.ptr.PointerByReference, int, int, tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Boxa tessBaseAPIGetComponentImages(Pointer handle,
      int level, int text_only, PointerByReference pixa,
      PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages(TessBaseAPI*, const TessPageIteratorLevel, const int, Pixa**, int**)</code>
   * <br>
   * <i>native declaration : line 219</i>
   */
  TesseractLibrary.Boxa tessBaseAPIGetComponentImages(
      PointerByReference handle, int level, int text_only,
      TesseractLibrary.Pixa pixa[], PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages1(TessBaseAPI*, const TessPageIteratorLevel, const int, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 222</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetComponentImages1(com.sun.jna.ptr.PointerByReference, int, int, int, int, tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Boxa tessBaseAPIGetComponentImages1(Pointer handle,
      int level, int text_only, int raw_image, int raw_padding,
      PointerByReference pixa, PointerByReference blockids,
      PointerByReference paraids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages1(TessBaseAPI*, const TessPageIteratorLevel, const int, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 222</i>
   */
  TesseractLibrary.Boxa tessBaseAPIGetComponentImages1(
      PointerByReference handle, int level, int text_only, int raw_image,
      int raw_padding, TesseractLibrary.Pixa pixa[],
      PointerByReference blockids, PointerByReference paraids);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetThresholdedImageScaleFactor(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 227</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetThresholdedImageScaleFactor(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIGetThresholdedImageScaleFactor(Pointer handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetThresholdedImageScaleFactor(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 227</i>
   */
  int tessBaseAPIGetThresholdedImageScaleFactor(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 229</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIDumpPGM(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #tessBaseAPIDumpPGM(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIDumpPGM(Pointer handle, Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 229</i>
   */
  void tessBaseAPIDumpPGM(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 229</i>
   */
  void tessBaseAPIDumpPGM(PointerByReference handle, Pointer filename);

  /**
   * Original signature :
   * <code>TessPageIterator* TessBaseAPIAnalyseLayout(TessBaseAPI*)</code><br>
   * <i>native declaration : line 231</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIAnalyseLayout(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIAnalyseLayout(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessBaseAPIAnalyseLayout(TessBaseAPI*)</code><br>
   * <i>native declaration : line 231</i>
   */
  PointerByReference tessBaseAPIAnalyseLayout(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognize(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 234</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIRecognize(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIRecognize(Pointer handle, Pointer monitor);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognize(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 234</i>
   */
  int tessBaseAPIRecognize(PointerByReference handle, PointerByReference monitor);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognizeForChopTest(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 235</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIRecognizeForChopTest(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIRecognizeForChopTest(Pointer handle, Pointer monitor);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognizeForChopTest(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 235</i>
   */
  int tessBaseAPIRecognizeForChopTest(PointerByReference handle,
      PointerByReference monitor);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 236</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIProcessPages(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int)}
   *             and
   *             {@link #tessBaseAPIProcessPages(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIProcessPages(Pointer handle, Pointer filename,
      Pointer retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 236</i>
   */
  String tessBaseAPIProcessPages(PointerByReference handle, String filename,
      String retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 236</i>
   */
  String tessBaseAPIProcessPages(PointerByReference handle, Pointer filename,
      Pointer retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPages1(TessBaseAPI*, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 238</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIProcessPages1(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int, com.sun.jna.ptr.PointerByReference)}
   *             and
   *             {@link #tessBaseAPIProcessPages1(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIProcessPages1(Pointer handle, Pointer filename,
      Pointer retry_config, int timeout_millisec, Pointer renderer);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPages1(TessBaseAPI*, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 238</i>
   */
  int tessBaseAPIProcessPages1(PointerByReference handle, String filename,
      String retry_config, int timeout_millisec, PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPages1(TessBaseAPI*, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 238</i>
   */
  int tessBaseAPIProcessPages1(PointerByReference handle, Pointer filename,
      Pointer retry_config, int timeout_millisec, PointerByReference renderer);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, Pix*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 240</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIProcessPage(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pix, int, java.lang.String, java.lang.String, int)}
   *             and
   *             {@link #tessBaseAPIProcessPage(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pix, int, com.sun.jna.Pointer, com.sun.jna.Pointer, int)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIProcessPage(Pointer handle, TesseractLibrary.Pix pix,
      int page_index, Pointer filename, Pointer retry_config,
      int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, Pix*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 240</i>
   */
  String tessBaseAPIProcessPage(PointerByReference handle,
      TesseractLibrary.Pix pix, int page_index, String filename,
      String retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, Pix*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 240</i>
   */
  String tessBaseAPIProcessPage(PointerByReference handle,
      TesseractLibrary.Pix pix, int page_index, Pointer filename,
      Pointer retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPage1(TessBaseAPI*, Pix*, int, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 242</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIProcessPage1(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pix, int, java.lang.String, java.lang.String, int, com.sun.jna.ptr.PointerByReference)}
   *             and
   *             {@link #tessBaseAPIProcessPage1(com.sun.jna.ptr.PointerByReference, tesseract.TesseractLibrary.Pix, int, com.sun.jna.Pointer, com.sun.jna.Pointer, int, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIProcessPage1(Pointer handle, TesseractLibrary.Pix pix,
      int page_index, Pointer filename, Pointer retry_config,
      int timeout_millisec, Pointer renderer);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPage1(TessBaseAPI*, Pix*, int, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 242</i>
   */
  int tessBaseAPIProcessPage1(PointerByReference handle,
      TesseractLibrary.Pix pix, int page_index, String filename,
      String retry_config, int timeout_millisec, PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPage1(TessBaseAPI*, Pix*, int, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 242</i>
   */
  int tessBaseAPIProcessPage1(PointerByReference handle,
      TesseractLibrary.Pix pix, int page_index, Pointer filename,
      Pointer retry_config, int timeout_millisec, PointerByReference renderer);

  /**
   * Original signature :
   * <code>TessResultIterator* TessBaseAPIGetIterator(TessBaseAPI*)</code><br>
   * <i>native declaration : line 245</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetIterator(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetIterator(Pointer handle);

  /**
   * Original signature :
   * <code>TessResultIterator* TessBaseAPIGetIterator(TessBaseAPI*)</code><br>
   * <i>native declaration : line 245</i>
   */
  PointerByReference tessBaseAPIGetIterator(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessMutableIterator* TessBaseAPIGetMutableIterator(TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 247</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetMutableIterator(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetMutableIterator(Pointer handle);

  /**
   * Original signature :
   * <code>TessMutableIterator* TessBaseAPIGetMutableIterator(TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 247</i>
   */
  PointerByReference tessBaseAPIGetMutableIterator(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUTF8Text(TessBaseAPI*)</code><br>
   * <i>native declaration : line 250</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetUTF8Text(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIGetUTF8Text(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUTF8Text(TessBaseAPI*)</code><br>
   * <i>native declaration : line 250</i>
   */
  String tessBaseAPIGetUTF8Text(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetHOCRText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 251</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetHOCRText(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIGetHOCRText(Pointer handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetHOCRText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 251</i>
   */
  String tessBaseAPIGetHOCRText(PointerByReference handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetBoxText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 252</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetBoxText(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIGetBoxText(Pointer handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetBoxText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 252</i>
   */
  String tessBaseAPIGetBoxText(PointerByReference handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUNLVText(TessBaseAPI*)</code><br>
   * <i>native declaration : line 253</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetUNLVText(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIGetUNLVText(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUNLVText(TessBaseAPI*)</code><br>
   * <i>native declaration : line 253</i>
   */
  String tessBaseAPIGetUNLVText(PointerByReference handle);

  /**
   * Original signature : <code>int TessBaseAPIMeanTextConf(TessBaseAPI*)</code><br>
   * <i>native declaration : line 254</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIMeanTextConf(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIMeanTextConf(Pointer handle);

  /**
   * Original signature : <code>int TessBaseAPIMeanTextConf(TessBaseAPI*)</code><br>
   * <i>native declaration : line 254</i>
   */
  int tessBaseAPIMeanTextConf(PointerByReference handle);

  /**
   * Original signature :
   * <code>int* TessBaseAPIAllWordConfidences(TessBaseAPI*)</code><br>
   * <i>native declaration : line 255</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIAllWordConfidences(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  IntByReference tessBaseAPIAllWordConfidences(Pointer handle);

  /**
   * Original signature :
   * <code>int* TessBaseAPIAllWordConfidences(TessBaseAPI*)</code><br>
   * <i>native declaration : line 255</i>
   */
  IntByReference tessBaseAPIAllWordConfidences(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
   * <br>
   * <i>native declaration : line 256</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIAdaptToWordStr(com.sun.jna.ptr.PointerByReference, int, java.lang.String)}
   *             and
   *             {@link #tessBaseAPIAdaptToWordStr(com.sun.jna.ptr.PointerByReference, int, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIAdaptToWordStr(Pointer handle, int mode, Pointer wordstr);

  /**
   * Original signature :
   * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
   * <br>
   * <i>native declaration : line 256</i>
   */
  int tessBaseAPIAdaptToWordStr(PointerByReference handle, int mode,
      String wordstr);

  /**
   * Original signature :
   * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
   * <br>
   * <i>native declaration : line 256</i>
   */
  int tessBaseAPIAdaptToWordStr(PointerByReference handle, int mode,
      Pointer wordstr);

  /**
   * Original signature : <code>void TessBaseAPIClear(TessBaseAPI*)</code><br>
   * <i>native declaration : line 258</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIClear(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIClear(Pointer handle);

  /**
   * Original signature : <code>void TessBaseAPIClear(TessBaseAPI*)</code><br>
   * <i>native declaration : line 258</i>
   */
  void tessBaseAPIClear(PointerByReference handle);

  /**
   * Original signature : <code>void TessBaseAPIEnd(TessBaseAPI*)</code><br>
   * <i>native declaration : line 259</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIEnd(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIEnd(Pointer handle);

  /**
   * Original signature : <code>void TessBaseAPIEnd(TessBaseAPI*)</code><br>
   * <i>native declaration : line 259</i>
   */
  void tessBaseAPIEnd(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 261</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIIsValidWord(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #tessBaseAPIIsValidWord(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIIsValidWord(Pointer handle, Pointer word);

  /**
   * Original signature :
   * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 261</i>
   */
  int tessBaseAPIIsValidWord(PointerByReference handle, String word);

  /**
   * Original signature :
   * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 261</i>
   */
  int tessBaseAPIIsValidWord(PointerByReference handle, Pointer word);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
   * <i>native declaration : line 262</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIGetTextDirection(com.sun.jna.ptr.PointerByReference, java.nio.IntBuffer, java.nio.FloatBuffer)}
   *             and
   *             {@link #tessBaseAPIGetTextDirection(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.FloatByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIGetTextDirection(Pointer handle, IntByReference out_offset,
      FloatByReference out_slope);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
   * <i>native declaration : line 262</i>
   */
  int tessBaseAPIGetTextDirection(PointerByReference handle,
      IntBuffer out_offset, FloatBuffer out_slope);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
   * <i>native declaration : line 262</i>
   */
  int tessBaseAPIGetTextDirection(PointerByReference handle,
      IntByReference out_offset, FloatByReference out_slope);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUnichar(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 280</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetUnichar(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIGetUnichar(Pointer handle, int unichar_id);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUnichar(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 280</i>
   */
  String tessBaseAPIGetUnichar(PointerByReference handle, int unichar_id);

  /**
   * Original signature :
   * <code>void TessBaseAPISetMinOrientationMargin(TessBaseAPI*, double)</code><br>
   * <i>native declaration : line 303</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPISetMinOrientationMargin(com.sun.jna.ptr.PointerByReference, double)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetMinOrientationMargin(Pointer handle, double margin);

  /**
   * Original signature :
   * <code>void TessBaseAPISetMinOrientationMargin(TessBaseAPI*, double)</code><br>
   * <i>native declaration : line 303</i>
   */
  void tessBaseAPISetMinOrientationMargin(PointerByReference handle,
      double margin);

  /**
   * Original signature :
   * <code>void TessPageIteratorDelete(TessPageIterator*)</code><br>
   * <i>native declaration : line 313</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessPageIteratorDelete(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessPageIteratorDelete(Pointer handle);

  /**
   * Original signature :
   * <code>void TessPageIteratorDelete(TessPageIterator*)</code><br>
   * <i>native declaration : line 313</i>
   */
  void tessPageIteratorDelete(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessPageIteratorCopy(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 314</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessPageIteratorCopy(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessPageIteratorCopy(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessPageIteratorCopy(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 314</i>
   */
  PointerByReference tessPageIteratorCopy(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessPageIteratorBegin(TessPageIterator*)</code><br>
   * <i>native declaration : line 317</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessPageIteratorBegin(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessPageIteratorBegin(Pointer handle);

  /**
   * Original signature :
   * <code>void TessPageIteratorBegin(TessPageIterator*)</code><br>
   * <i>native declaration : line 317</i>
   */
  void tessPageIteratorBegin(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessPageIteratorNext(TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 318</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessPageIteratorNext(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  int tessPageIteratorNext(Pointer handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorNext(TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 318</i>
   */
  int tessPageIteratorNext(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtBeginningOf(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 319</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessPageIteratorIsAtBeginningOf(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  int tessPageIteratorIsAtBeginningOf(Pointer handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtBeginningOf(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 319</i>
   */
  int tessPageIteratorIsAtBeginningOf(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtFinalElement(const TessPageIterator*, TessPageIteratorLevel, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 320</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessPageIteratorIsAtFinalElement(com.sun.jna.ptr.PointerByReference, int, int)}
   *             instead
   */
  @Deprecated
  int tessPageIteratorIsAtFinalElement(Pointer handle, int level, int element);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtFinalElement(const TessPageIterator*, TessPageIteratorLevel, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 320</i>
   */
  int tessPageIteratorIsAtFinalElement(PointerByReference handle, int level,
      int element);

  /**
   * Original signature :
   * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 323</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessPageIteratorBoundingBox(com.sun.jna.ptr.PointerByReference, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer)}
   *             and
   *             {@link #tessPageIteratorBoundingBox(com.sun.jna.ptr.PointerByReference, int, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int tessPageIteratorBoundingBox(Pointer handle, int level,
      IntByReference left, IntByReference top, IntByReference right,
      IntByReference bottom);

  /**
   * Original signature :
   * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 323</i>
   */
  int tessPageIteratorBoundingBox(PointerByReference handle, int level,
      IntBuffer left, IntBuffer top, IntBuffer right, IntBuffer bottom);

  /**
   * Original signature :
   * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 323</i>
   */
  int tessPageIteratorBoundingBox(PointerByReference handle, int level,
      IntByReference left, IntByReference top, IntByReference right,
      IntByReference bottom);

  /**
   * Original signature :
   * <code>TessPolyBlockType TessPageIteratorBlockType(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 325</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessPageIteratorBlockType(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessPageIteratorBlockType(Pointer handle);

  /**
   * Original signature :
   * <code>TessPolyBlockType TessPageIteratorBlockType(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 325</i>
   */
  int tessPageIteratorBlockType(PointerByReference handle);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetBinaryImage(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 328</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessPageIteratorGetBinaryImage(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Pix tessPageIteratorGetBinaryImage(Pointer handle, int level);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetBinaryImage(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 328</i>
   */
  TesseractLibrary.Pix tessPageIteratorGetBinaryImage(
      PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 330</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessPageIteratorGetImage(com.sun.jna.ptr.PointerByReference, int, int, java.nio.IntBuffer, java.nio.IntBuffer)}
   *             and
   *             {@link #tessPageIteratorGetImage(com.sun.jna.ptr.PointerByReference, int, int, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  TesseractLibrary.Pix tessPageIteratorGetImage(Pointer handle, int level,
      int padding, IntByReference left, IntByReference top);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 330</i>
   */
  TesseractLibrary.Pix tessPageIteratorGetImage(PointerByReference handle,
      int level, int padding, IntBuffer left, IntBuffer top);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 330</i>
   */
  TesseractLibrary.Pix tessPageIteratorGetImage(PointerByReference handle,
      int level, int padding, IntByReference left, IntByReference top);

  /**
   * Original signature :
   * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 334</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessPageIteratorBaseline(com.sun.jna.ptr.PointerByReference, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer)}
   *             and
   *             {@link #tessPageIteratorBaseline(com.sun.jna.ptr.PointerByReference, int, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int tessPageIteratorBaseline(Pointer handle, int level, IntByReference x1,
      IntByReference y1, IntByReference x2, IntByReference y2);

  /**
   * Original signature :
   * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 334</i>
   */
  int tessPageIteratorBaseline(PointerByReference handle, int level,
      IntBuffer x1, IntBuffer y1, IntBuffer x2, IntBuffer y2);

  /**
   * Original signature :
   * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 334</i>
   */
  int tessPageIteratorBaseline(PointerByReference handle, int level,
      IntByReference x1, IntByReference y1, IntByReference x2, IntByReference y2);

  /**
   * Original signature :
   * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
   * <br>
   * <i>native declaration : line 337</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessPageIteratorOrientation(com.sun.jna.ptr.PointerByReference, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.FloatBuffer)}
   *             and
   *             {@link #tessPageIteratorOrientation(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.FloatByReference)}
   *             instead
   */
  @Deprecated
  void tessPageIteratorOrientation(Pointer handle, IntByReference orientation,
      IntByReference writing_direction, IntByReference textline_order,
      FloatByReference deskew_angle);

  /**
   * Original signature :
   * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
   * <br>
   * <i>native declaration : line 337</i>
   */
  void tessPageIteratorOrientation(PointerByReference handle,
      IntBuffer orientation, IntBuffer writing_direction,
      IntBuffer textline_order, FloatBuffer deskew_angle);

  /**
   * Original signature :
   * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
   * <br>
   * <i>native declaration : line 337</i>
   */
  void tessPageIteratorOrientation(PointerByReference handle,
      IntByReference orientation, IntByReference writing_direction,
      IntByReference textline_order, FloatByReference deskew_angle);

  /**
   * Original signature :
   * <code>void TessResultIteratorDelete(TessResultIterator*)</code><br>
   * <i>native declaration : line 343</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorDelete(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessResultIteratorDelete(Pointer handle);

  /**
   * Original signature :
   * <code>void TessResultIteratorDelete(TessResultIterator*)</code><br>
   * <i>native declaration : line 343</i>
   */
  void tessResultIteratorDelete(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessResultIterator* TessResultIteratorCopy(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 344</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorCopy(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessResultIteratorCopy(Pointer handle);

  /**
   * Original signature :
   * <code>TessResultIterator* TessResultIteratorCopy(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 344</i>
   */
  PointerByReference tessResultIteratorCopy(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIterator(TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 346</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorGetPageIterator(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessResultIteratorGetPageIterator(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIterator(TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 346</i>
   */
  PointerByReference tessResultIteratorGetPageIterator(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIteratorConst(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 348</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorGetPageIteratorConst(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessResultIteratorGetPageIteratorConst(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIteratorConst(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 348</i>
   */
  PointerByReference tessResultIteratorGetPageIteratorConst(
      PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessResultIteratorGetUTF8Text(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 351</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorGetUTF8Text(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  String tessResultIteratorGetUTF8Text(Pointer handle, int level);

  /**
   * Original signature :
   * <code>char* TessResultIteratorGetUTF8Text(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 351</i>
   */
  String tessResultIteratorGetUTF8Text(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>float TessResultIteratorConfidence(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 352</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorConfidence(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  float tessResultIteratorConfidence(Pointer handle, int level);

  /**
   * Original signature :
   * <code>float TessResultIteratorConfidence(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 352</i>
   */
  float tessResultIteratorConfidence(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 354</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessResultIteratorWordFontAttributes(com.sun.jna.ptr.PointerByReference, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer)}
   *             and
   *             {@link #tessResultIteratorWordFontAttributes(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  String tessResultIteratorWordFontAttributes(Pointer handle,
      IntByReference is_bold, IntByReference is_italic,
      IntByReference is_underlined, IntByReference is_monospace,
      IntByReference is_serif, IntByReference is_smallcaps,
      IntByReference pointsize, IntByReference font_id);

  /**
   * Original signature :
   * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 354</i>
   */
  String tessResultIteratorWordFontAttributes(PointerByReference handle,
      IntBuffer is_bold, IntBuffer is_italic, IntBuffer is_underlined,
      IntBuffer is_monospace, IntBuffer is_serif, IntBuffer is_smallcaps,
      IntBuffer pointsize, IntBuffer font_id);

  /**
   * Original signature :
   * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 354</i>
   */
  String tessResultIteratorWordFontAttributes(PointerByReference handle,
      IntByReference is_bold, IntByReference is_italic,
      IntByReference is_underlined, IntByReference is_monospace,
      IntByReference is_serif, IntByReference is_smallcaps,
      IntByReference pointsize, IntByReference font_id);

  /**
   * Original signature :
   * <code>int TessResultIteratorWordIsFromDictionary(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 359</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorWordIsFromDictionary(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessResultIteratorWordIsFromDictionary(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorWordIsFromDictionary(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 359</i>
   */
  int tessResultIteratorWordIsFromDictionary(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorWordIsNumeric(const TessResultIterator*)</code><br>
   * <i>native declaration : line 360</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorWordIsNumeric(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessResultIteratorWordIsNumeric(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorWordIsNumeric(const TessResultIterator*)</code><br>
   * <i>native declaration : line 360</i>
   */
  int tessResultIteratorWordIsNumeric(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSuperscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 361</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorSymbolIsSuperscript(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessResultIteratorSymbolIsSuperscript(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSuperscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 361</i>
   */
  int tessResultIteratorSymbolIsSuperscript(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSubscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 362</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorSymbolIsSubscript(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessResultIteratorSymbolIsSubscript(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSubscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 362</i>
   */
  int tessResultIteratorSymbolIsSubscript(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsDropcap(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 363</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessResultIteratorSymbolIsDropcap(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessResultIteratorSymbolIsDropcap(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsDropcap(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 363</i>
   */
  int tessResultIteratorSymbolIsDropcap(PointerByReference handle);

  public static class Boxa extends PointerType {
    public Boxa(Pointer address) {
      super(address);
    }

    public Boxa() {
      super();
    }
  };

  public static class TessBaseAPI extends PointerType {
    public TessBaseAPI(Pointer address) {
      super(address);
    }

    public TessBaseAPI() {
      super();
    }
  };

  public static class Pix extends PointerType {
    public Pix(Pointer address) {
      super(address);
    }

    public Pix() {
      super();
    }
  };

  public static class FILE extends PointerType {
    public FILE(Pointer address) {
      super(address);
    }

    public FILE() {
      super();
    }
  };

  public static class ETEXT_DESC extends PointerType {
    public ETEXT_DESC(Pointer address) {
      super(address);
    }

    public ETEXT_DESC() {
      super();
    }
  };

  public static class TessPageIterator extends PointerType {
    public TessPageIterator(Pointer address) {
      super(address);
    }

    public TessPageIterator() {
      super();
    }
  };

  public static class TessMutableIterator extends PointerType {
    public TessMutableIterator(Pointer address) {
      super(address);
    }

    public TessMutableIterator() {
      super();
    }
  };

  public static class TessResultIterator extends PointerType {
    public TessResultIterator(Pointer address) {
      super(address);
    }

    public TessResultIterator() {
      super();
    }
  };

  public static class Pixa extends PointerType {
    public Pixa(Pointer address) {
      super(address);
    }

    public Pixa() {
      super();
    }
  };

  public static class TessResultRenderer extends PointerType {
    public TessResultRenderer(Pointer address) {
      super(address);
    }

    public TessResultRenderer() {
      super();
    }
  };
}
