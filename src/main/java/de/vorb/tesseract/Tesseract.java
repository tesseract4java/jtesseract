package de.vorb.tesseract;

import com.sun.jna.IntegerType;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public interface Tesseract extends Library {
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
  String TessVersion();

  /**
   * Original signature : <code>void TessDeleteText(char*)</code><br>
   * <i>native declaration : line 90</i><br>
   * 
   * @deprecated use the safer methods {@link #TessDeleteText(java.lang.String)}
   *             and {@link #TessDeleteText(com.sun.jna.Pointer)} instead
   */
  @Deprecated
  void TessDeleteText(Pointer text);

  /**
   * Original signature : <code>void TessDeleteText(char*)</code><br>
   * <i>native declaration : line 90</i>
   */
  void TessDeleteText(String text);

  /**
   * Original signature : <code>void TessDeleteTextArray(char**)</code><br>
   * <i>native declaration : line 91</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessDeleteTextArray(java.lang.String[])} and
   *             {@link #TessDeleteTextArray(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessDeleteTextArray(PointerByReference arr);

  /**
   * Original signature : <code>void TessDeleteTextArray(char**)</code><br>
   * <i>native declaration : line 91</i>
   */
  void TessDeleteTextArray(String arr[]);

  /**
   * Original signature : <code>void TessDeleteIntArray(int*)</code><br>
   * <i>native declaration : line 92</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessDeleteIntArray(java.nio.IntBuffer)} and
   *             {@link #TessDeleteIntArray(com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  void TessDeleteIntArray(IntByReference arr);

  /**
   * Original signature : <code>void TessDeleteIntArray(int*)</code><br>
   * <i>native declaration : line 92</i>
   */
  void TessDeleteIntArray(IntBuffer arr);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessTextRendererCreate()</code><br>
   * <i>native declaration : line 98</i>
   */
  PointerByReference TessTextRendererCreate();

  /**
   * Original signature :
   * <code>TessResultRenderer* TessHOcrRendererCreate()</code><br>
   * <i>native declaration : line 99</i>
   */
  PointerByReference TessHOcrRendererCreate();

  /**
   * Original signature :
   * <code>TessResultRenderer* TessPDFRendererCreate(const char*)</code><br>
   * <i>native declaration : line 100</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessPDFRendererCreate(java.lang.String)} and
   *             {@link #TessPDFRendererCreate(com.sun.jna.Pointer)} instead
   */
  @Deprecated
  PointerByReference TessPDFRendererCreate(Pointer datadir);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessPDFRendererCreate(const char*)</code><br>
   * <i>native declaration : line 100</i>
   */
  PointerByReference TessPDFRendererCreate(String datadir);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessUnlvRendererCreate()</code><br>
   * <i>native declaration : line 101</i>
   */
  PointerByReference TessUnlvRendererCreate();

  /**
   * Original signature :
   * <code>TessResultRenderer* TessBoxTextRendererCreate()</code><br>
   * <i>native declaration : line 102</i>
   */
  PointerByReference TessBoxTextRendererCreate();

  /**
   * Original signature :
   * <code>void TessDeleteResultRenderer(TessResultRenderer*)</code><br>
   * <i>native declaration : line 104</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessDeleteResultRenderer(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessDeleteResultRenderer(Pointer renderer);

  /**
   * Original signature :
   * <code>void TessDeleteResultRenderer(TessResultRenderer*)</code><br>
   * <i>native declaration : line 104</i>
   */
  void TessDeleteResultRenderer(PointerByReference renderer);

  /**
   * Original signature :
   * <code>void TessResultRendererInsert(TessResultRenderer*, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 105</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultRendererInsert(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessResultRendererInsert(Pointer renderer, Pointer next);

  /**
   * Original signature :
   * <code>void TessResultRendererInsert(TessResultRenderer*, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 105</i>
   */
  void TessResultRendererInsert(PointerByReference renderer,
      PointerByReference next);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessResultRendererNext(TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 106</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultRendererNext(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessResultRendererNext(Pointer renderer);

  /**
   * Original signature :
   * <code>TessResultRenderer* TessResultRendererNext(TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 106</i>
   */
  PointerByReference TessResultRendererNext(PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererBeginDocument(TessResultRenderer*, const char*)</code>
   * <br>
   * <i>native declaration : line 108</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessResultRendererBeginDocument(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #TessResultRendererBeginDocument(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int TessResultRendererBeginDocument(Pointer renderer, Pointer title);

  /**
   * Original signature :
   * <code>int TessResultRendererBeginDocument(TessResultRenderer*, const char*)</code>
   * <br>
   * <i>native declaration : line 108</i>
   */
  int TessResultRendererBeginDocument(PointerByReference renderer, String title);

  /**
   * Original signature :
   * <code>int TessResultRendererBeginDocument(TessResultRenderer*, const char*)</code>
   * <br>
   * <i>native declaration : line 108</i>
   */
  int TessResultRendererBeginDocument(PointerByReference renderer, Pointer title);

  /**
   * Original signature :
   * <code>int TessResultRendererAddImage(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 109</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultRendererAddImage(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessResultRendererAddImage(Pointer renderer, Pointer api);

  /**
   * Original signature :
   * <code>int TessResultRendererAddImage(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 109</i>
   */
  int TessResultRendererAddImage(PointerByReference renderer,
      PointerByReference api);

  /**
   * Original signature :
   * <code>int TessResultRendererAddError(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 110</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultRendererAddError(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessResultRendererAddError(Pointer renderer, Pointer api);

  /**
   * Original signature :
   * <code>int TessResultRendererAddError(TessResultRenderer*, TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 110</i>
   */
  int TessResultRendererAddError(PointerByReference renderer,
      PointerByReference api);

  /**
   * Original signature :
   * <code>int TessResultRendererEndDocument(TessResultRenderer*)</code><br>
   * <i>native declaration : line 111</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultRendererEndDocument(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessResultRendererEndDocument(Pointer renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererEndDocument(TessResultRenderer*)</code><br>
   * <i>native declaration : line 111</i>
   */
  int TessResultRendererEndDocument(PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererGetOutput(TessResultRenderer*, const char**, int*)</code>
   * <br>
   * <i>native declaration : line 112</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessResultRendererGetOutput(com.sun.jna.ptr.PointerByReference, java.lang.String[], java.nio.IntBuffer)}
   *             and
   *             {@link #TessResultRendererGetOutput(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int TessResultRendererGetOutput(Pointer renderer, PointerByReference data,
      IntByReference data_len);

  /**
   * Original signature :
   * <code>int TessResultRendererGetOutput(TessResultRenderer*, const char**, int*)</code>
   * <br>
   * <i>native declaration : line 112</i>
   */
  int TessResultRendererGetOutput(PointerByReference renderer, String data[],
      IntBuffer data_len);

  /**
   * Original signature :
   * <code>int TessResultRendererGetOutput(TessResultRenderer*, const char**, int*)</code>
   * <br>
   * <i>native declaration : line 112</i>
   */
  int TessResultRendererGetOutput(PointerByReference renderer,
      PointerByReference data, IntByReference data_len);

  /**
   * Original signature :
   * <code>char* TessResultRendererTypename(TessResultRenderer*)</code><br>
   * <i>native declaration : line 114</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultRendererTypename(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String TessResultRendererTypename(Pointer renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererTypename(TessResultRenderer*)</code><br>
   * <i>native declaration : line 114</i>
   */
  String TessResultRendererTypename(PointerByReference renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererExtention(TessResultRenderer*)</code><br>
   * <i>native declaration : line 115</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultRendererExtention(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String TessResultRendererExtention(Pointer renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererExtention(TessResultRenderer*)</code><br>
   * <i>native declaration : line 115</i>
   */
  String TessResultRendererExtention(PointerByReference renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererTitle(TessResultRenderer*)</code><br>
   * <i>native declaration : line 116</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultRendererTitle(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String TessResultRendererTitle(Pointer renderer);

  /**
   * Original signature :
   * <code>char* TessResultRendererTitle(TessResultRenderer*)</code><br>
   * <i>native declaration : line 116</i>
   */
  String TessResultRendererTitle(PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererImageNum(TessResultRenderer*)</code><br>
   * <i>native declaration : line 117</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultRendererImageNum(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessResultRendererImageNum(Pointer renderer);

  /**
   * Original signature :
   * <code>int TessResultRendererImageNum(TessResultRenderer*)</code><br>
   * <i>native declaration : line 117</i>
   */
  int TessResultRendererImageNum(PointerByReference renderer);

  /**
   * Original signature : <code>TessBaseAPI* TessBaseAPICreate()</code><br>
   * <i>native declaration : line 121</i>
   */
  PointerByReference TessBaseAPICreate();

  /**
   * Original signature : <code>void TessBaseAPIDelete(TessBaseAPI*)</code><br>
   * <i>native declaration : line 123</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIDelete(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessBaseAPIDelete(Pointer handle);

  /**
   * Original signature : <code>void TessBaseAPIDelete(TessBaseAPI*)</code><br>
   * <i>native declaration : line 123</i>
   */
  void TessBaseAPIDelete(PointerByReference handle);

  /**
   * Original signature :
   * <code>size_t TessBaseAPIGetOpenCLDevice(TessBaseAPI*, void**)</code><br>
   * <i>native declaration : line 125</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetOpenCLDevice(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  SizeT TessBaseAPIGetOpenCLDevice(Pointer handle, PointerByReference device);

  /**
   * Original signature :
   * <code>size_t TessBaseAPIGetOpenCLDevice(TessBaseAPI*, void**)</code><br>
   * <i>native declaration : line 125</i>
   */
  SizeT TessBaseAPIGetOpenCLDevice(PointerByReference handle,
      PointerByReference device);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 127</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPISetInputName(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #TessBaseAPISetInputName(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void TessBaseAPISetInputName(Pointer handle, Pointer name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 127</i>
   */
  void TessBaseAPISetInputName(PointerByReference handle, String name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 127</i>
   */
  void TessBaseAPISetInputName(PointerByReference handle, Pointer name);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInputName(TessBaseAPI*)</code><br>
   * <i>native declaration : line 128</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetInputName(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIGetInputName(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInputName(TessBaseAPI*)</code><br>
   * <i>native declaration : line 128</i>
   */
  String TessBaseAPIGetInputName(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputImage(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 130</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPISetInputImage(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pix)}
   *             instead
   */
  @Deprecated
  void TessBaseAPISetInputImage(Pointer handle, Tesseract.Pix pix);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputImage(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 130</i>
   */
  void TessBaseAPISetInputImage(PointerByReference handle,
      Tesseract.Pix pix);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetInputImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 131</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetInputImage(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  Tesseract.Pix TessBaseAPIGetInputImage(Pointer handle);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetInputImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 131</i>
   */
  Tesseract.Pix TessBaseAPIGetInputImage(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetSourceYResolution(TessBaseAPI*)</code><br>
   * <i>native declaration : line 133</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetSourceYResolution(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIGetSourceYResolution(Pointer handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetSourceYResolution(TessBaseAPI*)</code><br>
   * <i>native declaration : line 133</i>
   */
  int TessBaseAPIGetSourceYResolution(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetDatapath(TessBaseAPI*)</code><br>
   * <i>native declaration : line 134</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetDatapath(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIGetDatapath(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetDatapath(TessBaseAPI*)</code><br>
   * <i>native declaration : line 134</i>
   */
  String TessBaseAPIGetDatapath(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 136</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPISetOutputName(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #TessBaseAPISetOutputName(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void TessBaseAPISetOutputName(Pointer handle, Pointer name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 136</i>
   */
  void TessBaseAPISetOutputName(PointerByReference handle, String name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 136</i>
   */
  void TessBaseAPISetOutputName(PointerByReference handle, Pointer name);

  /**
   * Original signature :
   * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 138</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPISetVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String)}
   *             and
   *             {@link #TessBaseAPISetVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int TessBaseAPISetVariable(Pointer handle, Pointer name, Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 138</i>
   */
  int TessBaseAPISetVariable(PointerByReference handle, String name,
      String value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 138</i>
   */
  int TessBaseAPISetVariable(PointerByReference handle, Pointer name,
      Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 139</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPISetDebugVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String)}
   *             and
   *             {@link #TessBaseAPISetDebugVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int TessBaseAPISetDebugVariable(Pointer handle, Pointer name, Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 139</i>
   */
  int TessBaseAPISetDebugVariable(PointerByReference handle, String name,
      String value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 139</i>
   */
  int TessBaseAPISetDebugVariable(PointerByReference handle, Pointer name,
      Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 141</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIGetIntVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.nio.IntBuffer)}
   *             and
   *             {@link #TessBaseAPIGetIntVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIGetIntVariable(Pointer handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 141</i>
   */
  int TessBaseAPIGetIntVariable(PointerByReference handle, String name,
      IntBuffer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 141</i>
   */
  int TessBaseAPIGetIntVariable(PointerByReference handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 142</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIGetBoolVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.nio.IntBuffer)}
   *             and
   *             {@link #TessBaseAPIGetBoolVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIGetBoolVariable(Pointer handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 142</i>
   */
  int TessBaseAPIGetBoolVariable(PointerByReference handle, String name,
      IntBuffer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 142</i>
   */
  int TessBaseAPIGetBoolVariable(PointerByReference handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
   * <br>
   * <i>native declaration : line 143</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIGetDoubleVariable(com.sun.jna.ptr.PointerByReference, java.lang.String, java.nio.DoubleBuffer)}
   *             and
   *             {@link #TessBaseAPIGetDoubleVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.ptr.DoubleByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIGetDoubleVariable(Pointer handle, Pointer name,
      DoubleByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
   * <br>
   * <i>native declaration : line 143</i>
   */
  int TessBaseAPIGetDoubleVariable(PointerByReference handle, String name,
      DoubleBuffer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
   * <br>
   * <i>native declaration : line 143</i>
   */
  int TessBaseAPIGetDoubleVariable(PointerByReference handle, Pointer name,
      DoubleByReference value);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 144</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIGetStringVariable(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #TessBaseAPIGetStringVariable(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIGetStringVariable(Pointer handle, Pointer name);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 144</i>
   */
  String TessBaseAPIGetStringVariable(PointerByReference handle, String name);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 144</i>
   */
  String TessBaseAPIGetStringVariable(PointerByReference handle, Pointer name);

  /**
   * Original signature :
   * <code>void TessBaseAPIPrintVariables(const TessBaseAPI*, FILE*)</code><br>
   * <i>native declaration : line 147</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIPrintVariables(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.FILE)}
   *             instead
   */
  @Deprecated
  void TessBaseAPIPrintVariables(Pointer handle, Tesseract.FILE fp);

  /**
   * Original signature :
   * <code>void TessBaseAPIPrintVariables(const TessBaseAPI*, FILE*)</code><br>
   * <i>native declaration : line 147</i>
   */
  void TessBaseAPIPrintVariables(PointerByReference handle,
      Tesseract.FILE fp);

  /**
   * Original signature :
   * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 148</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIPrintVariablesToFile(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #TessBaseAPIPrintVariablesToFile(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIPrintVariablesToFile(Pointer handle, Pointer filename);

  /**
   * Original signature :
   * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 148</i>
   */
  int TessBaseAPIPrintVariablesToFile(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 148</i>
   */
  int TessBaseAPIPrintVariablesToFile(PointerByReference handle,
      Pointer filename);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
   * <br>
   * <i>native declaration : line 159</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIInit1(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int, java.lang.String[], int)}
   *             and
   *             {@link #TessBaseAPIInit1(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int, com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIInit1(Pointer handle, Pointer datapath, Pointer language,
      int oem, PointerByReference configs, int configs_size);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
   * <br>
   * <i>native declaration : line 159</i>
   */
  int TessBaseAPIInit1(PointerByReference handle, String datapath,
      String language, int oem, String configs[], int configs_size);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
   * <br>
   * <i>native declaration : line 159</i>
   */
  int TessBaseAPIInit1(PointerByReference handle, Pointer datapath,
      Pointer language, int oem, PointerByReference configs, int configs_size);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
   * <br>
   * <i>native declaration : line 161</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIInit2(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int)}
   *             and
   *             {@link #TessBaseAPIInit2(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIInit2(Pointer handle, Pointer datapath, Pointer language,
      int oem);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
   * <br>
   * <i>native declaration : line 161</i>
   */
  int TessBaseAPIInit2(PointerByReference handle, String datapath,
      String language, int oem);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
   * <br>
   * <i>native declaration : line 161</i>
   */
  int TessBaseAPIInit2(PointerByReference handle, Pointer datapath,
      Pointer language, int oem);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
   * <i>native declaration : line 162</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIInit3(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String)}
   *             and
   *             {@link #TessBaseAPIInit3(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIInit3(Pointer handle, Pointer datapath, Pointer language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
   * <i>native declaration : line 162</i>
   */
  int TessBaseAPIInit3(PointerByReference handle, String datapath,
      String language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
   * <i>native declaration : line 162</i>
   */
  int TessBaseAPIInit3(PointerByReference handle, Pointer datapath,
      Pointer language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit4(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int, char**, char**, size_t, int)</code>
   * <br>
   * <i>native declaration : line 164</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIInit4(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int, java.lang.String[], int, java.lang.String[], java.lang.String[], com.ochafik.lang.jnaerator.runtime.NativeSize, int)}
   *             and
   *             {@link #TessBaseAPIInit4(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int, com.sun.jna.ptr.PointerByReference, int, com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference, com.ochafik.lang.jnaerator.runtime.NativeSize, int)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIInit4(Pointer handle, Pointer datapath, Pointer language,
      int mode, PointerByReference configs, int configs_size,
      PointerByReference vars_vec, PointerByReference vars_values,
      SizeT vars_vec_size, int set_only_non_debug_params);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit4(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int, char**, char**, size_t, int)</code>
   * <br>
   * <i>native declaration : line 164</i>
   */
  int TessBaseAPIInit4(PointerByReference handle, String datapath,
      String language, int mode, String configs[], int configs_size,
      String vars_vec[], String vars_values[], SizeT vars_vec_size,
      int set_only_non_debug_params);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit4(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int, char**, char**, size_t, int)</code>
   * <br>
   * <i>native declaration : line 164</i>
   */
  int TessBaseAPIInit4(PointerByReference handle, Pointer datapath,
      Pointer language, int mode, PointerByReference configs, int configs_size,
      PointerByReference vars_vec, PointerByReference vars_values,
      SizeT vars_vec_size, int set_only_non_debug_params);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInitLanguagesAsString(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 169</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetInitLanguagesAsString(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIGetInitLanguagesAsString(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInitLanguagesAsString(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 169</i>
   */
  String TessBaseAPIGetInitLanguagesAsString(PointerByReference handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetLoadedLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 171</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetLoadedLanguagesAsVector(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessBaseAPIGetLoadedLanguagesAsVector(Pointer handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetLoadedLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 171</i>
   */
  PointerByReference TessBaseAPIGetLoadedLanguagesAsVector(
      PointerByReference handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetAvailableLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 173</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetAvailableLanguagesAsVector(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessBaseAPIGetAvailableLanguagesAsVector(Pointer handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetAvailableLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 173</i>
   */
  PointerByReference TessBaseAPIGetAvailableLanguagesAsVector(
      PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 176</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIInitLangMod(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String)}
   *             and
   *             {@link #TessBaseAPIInitLangMod(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIInitLangMod(Pointer handle, Pointer datapath, Pointer language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 176</i>
   */
  int TessBaseAPIInitLangMod(PointerByReference handle, String datapath,
      String language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 176</i>
   */
  int TessBaseAPIInitLangMod(PointerByReference handle, Pointer datapath,
      Pointer language);

  /**
   * Original signature :
   * <code>void TessBaseAPIInitForAnalysePage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 177</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIInitForAnalysePage(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessBaseAPIInitForAnalysePage(Pointer handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIInitForAnalysePage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 177</i>
   */
  void TessBaseAPIInitForAnalysePage(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 179</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIReadConfigFile(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #TessBaseAPIReadConfigFile(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void TessBaseAPIReadConfigFile(Pointer handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 179</i>
   */
  void TessBaseAPIReadConfigFile(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 179</i>
   */
  void TessBaseAPIReadConfigFile(PointerByReference handle, Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 180</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIReadDebugConfigFile(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #TessBaseAPIReadDebugConfigFile(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void TessBaseAPIReadDebugConfigFile(Pointer handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 180</i>
   */
  void TessBaseAPIReadDebugConfigFile(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 180</i>
   */
  void TessBaseAPIReadDebugConfigFile(PointerByReference handle,
      Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPISetPageSegMode(TessBaseAPI*, TessPageSegMode)</code><br>
   * <i>native declaration : line 182</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPISetPageSegMode(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  void TessBaseAPISetPageSegMode(Pointer handle, int mode);

  /**
   * Original signature :
   * <code>void TessBaseAPISetPageSegMode(TessBaseAPI*, TessPageSegMode)</code><br>
   * <i>native declaration : line 182</i>
   */
  void TessBaseAPISetPageSegMode(PointerByReference handle, int mode);

  /**
   * Original signature :
   * <code>TessPageSegMode TessBaseAPIGetPageSegMode(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 183</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetPageSegMode(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIGetPageSegMode(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageSegMode TessBaseAPIGetPageSegMode(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 183</i>
   */
  int TessBaseAPIGetPageSegMode(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 186</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIRect(com.sun.jna.ptr.PointerByReference, byte[], int, int, int, int, int, int)}
   *             and
   *             {@link #TessBaseAPIRect(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, int, int, int, int, int, int)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIRect(Pointer handle, ByteBuffer imagedata,
      int bytes_per_pixel, int bytes_per_line, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 186</i>
   */
  String TessBaseAPIRect(PointerByReference handle, byte imagedata[],
      int bytes_per_pixel, int bytes_per_line, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 186</i>
   */
  String TessBaseAPIRect(PointerByReference handle, ByteBuffer imagedata,
      int bytes_per_pixel, int bytes_per_line, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>void TessBaseAPIClearAdaptiveClassifier(TessBaseAPI*)</code><br>
   * <i>native declaration : line 190</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIClearAdaptiveClassifier(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessBaseAPIClearAdaptiveClassifier(Pointer handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIClearAdaptiveClassifier(TessBaseAPI*)</code><br>
   * <i>native declaration : line 190</i>
   */
  void TessBaseAPIClearAdaptiveClassifier(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 192</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPISetImage(com.sun.jna.ptr.PointerByReference, byte[], int, int, int, int)}
   *             and
   *             {@link #TessBaseAPISetImage(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, int, int, int, int)}
   *             instead
   */
  @Deprecated
  void TessBaseAPISetImage(Pointer handle, ByteBuffer imagedata, int width,
      int height, int bytes_per_pixel, int bytes_per_line);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 192</i>
   */
  void TessBaseAPISetImage(PointerByReference handle, byte imagedata[],
      int width, int height, int bytes_per_pixel, int bytes_per_line);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 192</i>
   */
  void TessBaseAPISetImage(PointerByReference handle, ByteBuffer imagedata,
      int width, int height, int bytes_per_pixel, int bytes_per_line);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage2(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 194</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPISetImage2(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pix)}
   *             instead
   */
  @Deprecated
  void TessBaseAPISetImage2(Pointer handle, Tesseract.Pix pix);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage2(TessBaseAPI*, Pix*)</code><br>
   * <i>native declaration : line 194</i>
   */
  void TessBaseAPISetImage2(PointerByReference handle, Tesseract.Pix pix);

  /**
   * Original signature :
   * <code>void TessBaseAPISetSourceResolution(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 196</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPISetSourceResolution(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  void TessBaseAPISetSourceResolution(Pointer handle, int ppi);

  /**
   * Original signature :
   * <code>void TessBaseAPISetSourceResolution(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 196</i>
   */
  void TessBaseAPISetSourceResolution(PointerByReference handle, int ppi);

  /**
   * Original signature :
   * <code>void TessBaseAPISetRectangle(TessBaseAPI*, int, int, int, int)</code><br>
   * <i>native declaration : line 198</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPISetRectangle(com.sun.jna.ptr.PointerByReference, int, int, int, int)}
   *             instead
   */
  @Deprecated
  void TessBaseAPISetRectangle(Pointer handle, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>void TessBaseAPISetRectangle(TessBaseAPI*, int, int, int, int)</code><br>
   * <i>native declaration : line 198</i>
   */
  void TessBaseAPISetRectangle(PointerByReference handle, int left, int top,
      int width, int height);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetThresholdedImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 204</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetThresholdedImage(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  Tesseract.Pix TessBaseAPIGetThresholdedImage(Pointer handle);

  /**
   * Original signature :
   * <code>Pix* TessBaseAPIGetThresholdedImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 204</i>
   */
  Tesseract.Pix TessBaseAPIGetThresholdedImage(PointerByReference handle);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetRegions(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 206</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIGetRegions(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             and
   *             {@link #TessBaseAPIGetRegions(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pixa[])}
   *             instead
   */
  @Deprecated
  Tesseract.Boxa TessBaseAPIGetRegions(Pointer handle,
      PointerByReference pixa);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetRegions(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 206</i>
   */
  Tesseract.Boxa TessBaseAPIGetRegions(PointerByReference handle,
      PointerByReference pixa);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetRegions(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 206</i>
   */
  Tesseract.Boxa TessBaseAPIGetRegions(PointerByReference handle,
      Tesseract.Pixa pixa[]);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 208</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetTextlines(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  Tesseract.Boxa TessBaseAPIGetTextlines(Pointer handle,
      PointerByReference pixa, PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 208</i>
   */
  Tesseract.Boxa TessBaseAPIGetTextlines(PointerByReference handle,
      Tesseract.Pixa pixa[], PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines1(TessBaseAPI*, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 210</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetTextlines1(com.sun.jna.ptr.PointerByReference, int, int, Tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  Tesseract.Boxa TessBaseAPIGetTextlines1(Pointer handle, int raw_image,
      int raw_padding, PointerByReference pixa, PointerByReference blockids,
      PointerByReference paraids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetTextlines1(TessBaseAPI*, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 210</i>
   */
  Tesseract.Boxa TessBaseAPIGetTextlines1(PointerByReference handle,
      int raw_image, int raw_padding, Tesseract.Pixa pixa[],
      PointerByReference blockids, PointerByReference paraids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetStrips(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 213</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetStrips(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  Tesseract.Boxa TessBaseAPIGetStrips(Pointer handle,
      PointerByReference pixa, PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetStrips(TessBaseAPI*, Pixa**, int**)</code><br>
   * <i>native declaration : line 213</i>
   */
  Tesseract.Boxa TessBaseAPIGetStrips(PointerByReference handle,
      Tesseract.Pixa pixa[], PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetWords(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 215</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetWords(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pixa[])}
   *             instead
   */
  @Deprecated
  Tesseract.Boxa TessBaseAPIGetWords(Pointer handle,
      PointerByReference pixa);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetWords(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 215</i>
   */
  Tesseract.Boxa TessBaseAPIGetWords(PointerByReference handle,
      Tesseract.Pixa pixa[]);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetConnectedComponents(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 217</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetConnectedComponents(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pixa[])}
   *             instead
   */
  @Deprecated
  Tesseract.Boxa TessBaseAPIGetConnectedComponents(Pointer handle,
      PointerByReference cc);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetConnectedComponents(TessBaseAPI*, Pixa**)</code><br>
   * <i>native declaration : line 217</i>
   */
  Tesseract.Boxa TessBaseAPIGetConnectedComponents(
      PointerByReference handle, Tesseract.Pixa cc[]);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages(TessBaseAPI*, const TessPageIteratorLevel, const int, Pixa**, int**)</code>
   * <br>
   * <i>native declaration : line 219</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetComponentImages(com.sun.jna.ptr.PointerByReference, int, int, Tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  Tesseract.Boxa TessBaseAPIGetComponentImages(Pointer handle,
      int level, int text_only, PointerByReference pixa,
      PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages(TessBaseAPI*, const TessPageIteratorLevel, const int, Pixa**, int**)</code>
   * <br>
   * <i>native declaration : line 219</i>
   */
  Tesseract.Boxa TessBaseAPIGetComponentImages(
      PointerByReference handle, int level, int text_only,
      Tesseract.Pixa pixa[], PointerByReference blockids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages1(TessBaseAPI*, const TessPageIteratorLevel, const int, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 222</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetComponentImages1(com.sun.jna.ptr.PointerByReference, int, int, int, int, Tesseract.TesseractLibrary.Pixa[], com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  Tesseract.Boxa TessBaseAPIGetComponentImages1(Pointer handle,
      int level, int text_only, int raw_image, int raw_padding,
      PointerByReference pixa, PointerByReference blockids,
      PointerByReference paraids);

  /**
   * Original signature :
   * <code>Boxa* TessBaseAPIGetComponentImages1(TessBaseAPI*, const TessPageIteratorLevel, const int, const int, const int, Pixa**, int**, int**)</code>
   * <br>
   * <i>native declaration : line 222</i>
   */
  Tesseract.Boxa TessBaseAPIGetComponentImages1(
      PointerByReference handle, int level, int text_only, int raw_image,
      int raw_padding, Tesseract.Pixa pixa[],
      PointerByReference blockids, PointerByReference paraids);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetThresholdedImageScaleFactor(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 227</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetThresholdedImageScaleFactor(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIGetThresholdedImageScaleFactor(Pointer handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetThresholdedImageScaleFactor(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 227</i>
   */
  int TessBaseAPIGetThresholdedImageScaleFactor(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 229</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIDumpPGM(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #TessBaseAPIDumpPGM(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  void TessBaseAPIDumpPGM(Pointer handle, Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 229</i>
   */
  void TessBaseAPIDumpPGM(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 229</i>
   */
  void TessBaseAPIDumpPGM(PointerByReference handle, Pointer filename);

  /**
   * Original signature :
   * <code>TessPageIterator* TessBaseAPIAnalyseLayout(TessBaseAPI*)</code><br>
   * <i>native declaration : line 231</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIAnalyseLayout(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessBaseAPIAnalyseLayout(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessBaseAPIAnalyseLayout(TessBaseAPI*)</code><br>
   * <i>native declaration : line 231</i>
   */
  PointerByReference TessBaseAPIAnalyseLayout(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognize(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 234</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIRecognize(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIRecognize(Pointer handle, Pointer monitor);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognize(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 234</i>
   */
  int TessBaseAPIRecognize(PointerByReference handle, PointerByReference monitor);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognizeForChopTest(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 235</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIRecognizeForChopTest(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIRecognizeForChopTest(Pointer handle, Pointer monitor);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognizeForChopTest(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 235</i>
   */
  int TessBaseAPIRecognizeForChopTest(PointerByReference handle,
      PointerByReference monitor);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 236</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIProcessPages(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int)}
   *             and
   *             {@link #TessBaseAPIProcessPages(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIProcessPages(Pointer handle, Pointer filename,
      Pointer retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 236</i>
   */
  String TessBaseAPIProcessPages(PointerByReference handle, String filename,
      String retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 236</i>
   */
  String TessBaseAPIProcessPages(PointerByReference handle, Pointer filename,
      Pointer retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPages1(TessBaseAPI*, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 238</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIProcessPages1(com.sun.jna.ptr.PointerByReference, java.lang.String, java.lang.String, int, com.sun.jna.ptr.PointerByReference)}
   *             and
   *             {@link #TessBaseAPIProcessPages1(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer, com.sun.jna.Pointer, int, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIProcessPages1(Pointer handle, Pointer filename,
      Pointer retry_config, int timeout_millisec, Pointer renderer);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPages1(TessBaseAPI*, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 238</i>
   */
  int TessBaseAPIProcessPages1(PointerByReference handle, String filename,
      String retry_config, int timeout_millisec, PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPages1(TessBaseAPI*, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 238</i>
   */
  int TessBaseAPIProcessPages1(PointerByReference handle, Pointer filename,
      Pointer retry_config, int timeout_millisec, PointerByReference renderer);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, Pix*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 240</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIProcessPage(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pix, int, java.lang.String, java.lang.String, int)}
   *             and
   *             {@link #TessBaseAPIProcessPage(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pix, int, com.sun.jna.Pointer, com.sun.jna.Pointer, int)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIProcessPage(Pointer handle, Tesseract.Pix pix,
      int page_index, Pointer filename, Pointer retry_config,
      int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, Pix*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 240</i>
   */
  String TessBaseAPIProcessPage(PointerByReference handle,
      Tesseract.Pix pix, int page_index, String filename,
      String retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, Pix*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 240</i>
   */
  String TessBaseAPIProcessPage(PointerByReference handle,
      Tesseract.Pix pix, int page_index, Pointer filename,
      Pointer retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPage1(TessBaseAPI*, Pix*, int, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 242</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIProcessPage1(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pix, int, java.lang.String, java.lang.String, int, com.sun.jna.ptr.PointerByReference)}
   *             and
   *             {@link #TessBaseAPIProcessPage1(com.sun.jna.ptr.PointerByReference, Tesseract.TesseractLibrary.Pix, int, com.sun.jna.Pointer, com.sun.jna.Pointer, int, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIProcessPage1(Pointer handle, Tesseract.Pix pix,
      int page_index, Pointer filename, Pointer retry_config,
      int timeout_millisec, Pointer renderer);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPage1(TessBaseAPI*, Pix*, int, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 242</i>
   */
  int TessBaseAPIProcessPage1(PointerByReference handle,
      Tesseract.Pix pix, int page_index, String filename,
      String retry_config, int timeout_millisec, PointerByReference renderer);

  /**
   * Original signature :
   * <code>int TessBaseAPIProcessPage1(TessBaseAPI*, Pix*, int, const char*, const char*, int, TessResultRenderer*)</code>
   * <br>
   * <i>native declaration : line 242</i>
   */
  int TessBaseAPIProcessPage1(PointerByReference handle,
      Tesseract.Pix pix, int page_index, Pointer filename,
      Pointer retry_config, int timeout_millisec, PointerByReference renderer);

  /**
   * Original signature :
   * <code>TessResultIterator* TessBaseAPIGetIterator(TessBaseAPI*)</code><br>
   * <i>native declaration : line 245</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetIterator(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessBaseAPIGetIterator(Pointer handle);

  /**
   * Original signature :
   * <code>TessResultIterator* TessBaseAPIGetIterator(TessBaseAPI*)</code><br>
   * <i>native declaration : line 245</i>
   */
  PointerByReference TessBaseAPIGetIterator(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessMutableIterator* TessBaseAPIGetMutableIterator(TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 247</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetMutableIterator(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessBaseAPIGetMutableIterator(Pointer handle);

  /**
   * Original signature :
   * <code>TessMutableIterator* TessBaseAPIGetMutableIterator(TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 247</i>
   */
  PointerByReference TessBaseAPIGetMutableIterator(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUTF8Text(TessBaseAPI*)</code><br>
   * <i>native declaration : line 250</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetUTF8Text(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIGetUTF8Text(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUTF8Text(TessBaseAPI*)</code><br>
   * <i>native declaration : line 250</i>
   */
  String TessBaseAPIGetUTF8Text(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetHOCRText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 251</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetHOCRText(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIGetHOCRText(Pointer handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetHOCRText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 251</i>
   */
  String TessBaseAPIGetHOCRText(PointerByReference handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetBoxText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 252</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetBoxText(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIGetBoxText(Pointer handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetBoxText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 252</i>
   */
  String TessBaseAPIGetBoxText(PointerByReference handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUNLVText(TessBaseAPI*)</code><br>
   * <i>native declaration : line 253</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetUNLVText(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIGetUNLVText(Pointer handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUNLVText(TessBaseAPI*)</code><br>
   * <i>native declaration : line 253</i>
   */
  String TessBaseAPIGetUNLVText(PointerByReference handle);

  /**
   * Original signature : <code>int TessBaseAPIMeanTextConf(TessBaseAPI*)</code><br>
   * <i>native declaration : line 254</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIMeanTextConf(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIMeanTextConf(Pointer handle);

  /**
   * Original signature : <code>int TessBaseAPIMeanTextConf(TessBaseAPI*)</code><br>
   * <i>native declaration : line 254</i>
   */
  int TessBaseAPIMeanTextConf(PointerByReference handle);

  /**
   * Original signature :
   * <code>int* TessBaseAPIAllWordConfidences(TessBaseAPI*)</code><br>
   * <i>native declaration : line 255</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIAllWordConfidences(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  IntByReference TessBaseAPIAllWordConfidences(Pointer handle);

  /**
   * Original signature :
   * <code>int* TessBaseAPIAllWordConfidences(TessBaseAPI*)</code><br>
   * <i>native declaration : line 255</i>
   */
  IntByReference TessBaseAPIAllWordConfidences(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
   * <br>
   * <i>native declaration : line 256</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIAdaptToWordStr(com.sun.jna.ptr.PointerByReference, int, java.lang.String)}
   *             and
   *             {@link #TessBaseAPIAdaptToWordStr(com.sun.jna.ptr.PointerByReference, int, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIAdaptToWordStr(Pointer handle, int mode, Pointer wordstr);

  /**
   * Original signature :
   * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
   * <br>
   * <i>native declaration : line 256</i>
   */
  int TessBaseAPIAdaptToWordStr(PointerByReference handle, int mode,
      String wordstr);

  /**
   * Original signature :
   * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
   * <br>
   * <i>native declaration : line 256</i>
   */
  int TessBaseAPIAdaptToWordStr(PointerByReference handle, int mode,
      Pointer wordstr);

  /**
   * Original signature : <code>void TessBaseAPIClear(TessBaseAPI*)</code><br>
   * <i>native declaration : line 258</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIClear(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessBaseAPIClear(Pointer handle);

  /**
   * Original signature : <code>void TessBaseAPIClear(TessBaseAPI*)</code><br>
   * <i>native declaration : line 258</i>
   */
  void TessBaseAPIClear(PointerByReference handle);

  /**
   * Original signature : <code>void TessBaseAPIEnd(TessBaseAPI*)</code><br>
   * <i>native declaration : line 259</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIEnd(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessBaseAPIEnd(Pointer handle);

  /**
   * Original signature : <code>void TessBaseAPIEnd(TessBaseAPI*)</code><br>
   * <i>native declaration : line 259</i>
   */
  void TessBaseAPIEnd(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 261</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIIsValidWord(com.sun.jna.ptr.PointerByReference, java.lang.String)}
   *             and
   *             {@link #TessBaseAPIIsValidWord(com.sun.jna.ptr.PointerByReference, com.sun.jna.Pointer)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIIsValidWord(Pointer handle, Pointer word);

  /**
   * Original signature :
   * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 261</i>
   */
  int TessBaseAPIIsValidWord(PointerByReference handle, String word);

  /**
   * Original signature :
   * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 261</i>
   */
  int TessBaseAPIIsValidWord(PointerByReference handle, Pointer word);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
   * <i>native declaration : line 262</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessBaseAPIGetTextDirection(com.sun.jna.ptr.PointerByReference, java.nio.IntBuffer, java.nio.FloatBuffer)}
   *             and
   *             {@link #TessBaseAPIGetTextDirection(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.FloatByReference)}
   *             instead
   */
  @Deprecated
  int TessBaseAPIGetTextDirection(Pointer handle, IntByReference out_offset,
      FloatByReference out_slope);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
   * <i>native declaration : line 262</i>
   */
  int TessBaseAPIGetTextDirection(PointerByReference handle,
      IntBuffer out_offset, FloatBuffer out_slope);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
   * <i>native declaration : line 262</i>
   */
  int TessBaseAPIGetTextDirection(PointerByReference handle,
      IntByReference out_offset, FloatByReference out_slope);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUnichar(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 280</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPIGetUnichar(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  String TessBaseAPIGetUnichar(Pointer handle, int unichar_id);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUnichar(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 280</i>
   */
  String TessBaseAPIGetUnichar(PointerByReference handle, int unichar_id);

  /**
   * Original signature :
   * <code>void TessBaseAPISetMinOrientationMargin(TessBaseAPI*, double)</code><br>
   * <i>native declaration : line 303</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessBaseAPISetMinOrientationMargin(com.sun.jna.ptr.PointerByReference, double)}
   *             instead
   */
  @Deprecated
  void TessBaseAPISetMinOrientationMargin(Pointer handle, double margin);

  /**
   * Original signature :
   * <code>void TessBaseAPISetMinOrientationMargin(TessBaseAPI*, double)</code><br>
   * <i>native declaration : line 303</i>
   */
  void TessBaseAPISetMinOrientationMargin(PointerByReference handle,
      double margin);

  /**
   * Original signature :
   * <code>void TessPageIteratorDelete(TessPageIterator*)</code><br>
   * <i>native declaration : line 313</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessPageIteratorDelete(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessPageIteratorDelete(Pointer handle);

  /**
   * Original signature :
   * <code>void TessPageIteratorDelete(TessPageIterator*)</code><br>
   * <i>native declaration : line 313</i>
   */
  void TessPageIteratorDelete(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessPageIteratorCopy(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 314</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessPageIteratorCopy(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessPageIteratorCopy(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessPageIteratorCopy(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 314</i>
   */
  PointerByReference TessPageIteratorCopy(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessPageIteratorBegin(TessPageIterator*)</code><br>
   * <i>native declaration : line 317</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessPageIteratorBegin(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessPageIteratorBegin(Pointer handle);

  /**
   * Original signature :
   * <code>void TessPageIteratorBegin(TessPageIterator*)</code><br>
   * <i>native declaration : line 317</i>
   */
  void TessPageIteratorBegin(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessPageIteratorNext(TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 318</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessPageIteratorNext(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  int TessPageIteratorNext(Pointer handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorNext(TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 318</i>
   */
  int TessPageIteratorNext(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtBeginningOf(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 319</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessPageIteratorIsAtBeginningOf(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  int TessPageIteratorIsAtBeginningOf(Pointer handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtBeginningOf(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 319</i>
   */
  int TessPageIteratorIsAtBeginningOf(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtFinalElement(const TessPageIterator*, TessPageIteratorLevel, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 320</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessPageIteratorIsAtFinalElement(com.sun.jna.ptr.PointerByReference, int, int)}
   *             instead
   */
  @Deprecated
  int TessPageIteratorIsAtFinalElement(Pointer handle, int level, int element);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtFinalElement(const TessPageIterator*, TessPageIteratorLevel, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 320</i>
   */
  int TessPageIteratorIsAtFinalElement(PointerByReference handle, int level,
      int element);

  /**
   * Original signature :
   * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 323</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessPageIteratorBoundingBox(com.sun.jna.ptr.PointerByReference, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer)}
   *             and
   *             {@link #TessPageIteratorBoundingBox(com.sun.jna.ptr.PointerByReference, int, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int TessPageIteratorBoundingBox(Pointer handle, int level,
      IntByReference left, IntByReference top, IntByReference right,
      IntByReference bottom);

  /**
   * Original signature :
   * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 323</i>
   */
  int TessPageIteratorBoundingBox(PointerByReference handle, int level,
      IntBuffer left, IntBuffer top, IntBuffer right, IntBuffer bottom);

  /**
   * Original signature :
   * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 323</i>
   */
  int TessPageIteratorBoundingBox(PointerByReference handle, int level,
      IntByReference left, IntByReference top, IntByReference right,
      IntByReference bottom);

  /**
   * Original signature :
   * <code>TessPolyBlockType TessPageIteratorBlockType(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 325</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessPageIteratorBlockType(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessPageIteratorBlockType(Pointer handle);

  /**
   * Original signature :
   * <code>TessPolyBlockType TessPageIteratorBlockType(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 325</i>
   */
  int TessPageIteratorBlockType(PointerByReference handle);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetBinaryImage(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 328</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessPageIteratorGetBinaryImage(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  Tesseract.Pix TessPageIteratorGetBinaryImage(Pointer handle, int level);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetBinaryImage(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 328</i>
   */
  Tesseract.Pix TessPageIteratorGetBinaryImage(
      PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 330</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessPageIteratorGetImage(com.sun.jna.ptr.PointerByReference, int, int, java.nio.IntBuffer, java.nio.IntBuffer)}
   *             and
   *             {@link #TessPageIteratorGetImage(com.sun.jna.ptr.PointerByReference, int, int, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  Tesseract.Pix TessPageIteratorGetImage(Pointer handle, int level,
      int padding, IntByReference left, IntByReference top);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 330</i>
   */
  Tesseract.Pix TessPageIteratorGetImage(PointerByReference handle,
      int level, int padding, IntBuffer left, IntBuffer top);

  /**
   * Original signature :
   * <code>Pix* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 330</i>
   */
  Tesseract.Pix TessPageIteratorGetImage(PointerByReference handle,
      int level, int padding, IntByReference left, IntByReference top);

  /**
   * Original signature :
   * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 334</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessPageIteratorBaseline(com.sun.jna.ptr.PointerByReference, int, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer)}
   *             and
   *             {@link #TessPageIteratorBaseline(com.sun.jna.ptr.PointerByReference, int, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  int TessPageIteratorBaseline(Pointer handle, int level, IntByReference x1,
      IntByReference y1, IntByReference x2, IntByReference y2);

  /**
   * Original signature :
   * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 334</i>
   */
  int TessPageIteratorBaseline(PointerByReference handle, int level,
      IntBuffer x1, IntBuffer y1, IntBuffer x2, IntBuffer y2);

  /**
   * Original signature :
   * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 334</i>
   */
  int TessPageIteratorBaseline(PointerByReference handle, int level,
      IntByReference x1, IntByReference y1, IntByReference x2, IntByReference y2);

  /**
   * Original signature :
   * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
   * <br>
   * <i>native declaration : line 337</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessPageIteratorOrientation(com.sun.jna.ptr.PointerByReference, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.FloatBuffer)}
   *             and
   *             {@link #TessPageIteratorOrientation(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.FloatByReference)}
   *             instead
   */
  @Deprecated
  void TessPageIteratorOrientation(Pointer handle, IntByReference orientation,
      IntByReference writing_direction, IntByReference textline_order,
      FloatByReference deskew_angle);

  /**
   * Original signature :
   * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
   * <br>
   * <i>native declaration : line 337</i>
   */
  void TessPageIteratorOrientation(PointerByReference handle,
      IntBuffer orientation, IntBuffer writing_direction,
      IntBuffer textline_order, FloatBuffer deskew_angle);

  /**
   * Original signature :
   * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
   * <br>
   * <i>native declaration : line 337</i>
   */
  void TessPageIteratorOrientation(PointerByReference handle,
      IntByReference orientation, IntByReference writing_direction,
      IntByReference textline_order, FloatByReference deskew_angle);

  /**
   * Original signature :
   * <code>void TessResultIteratorDelete(TessResultIterator*)</code><br>
   * <i>native declaration : line 343</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorDelete(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void TessResultIteratorDelete(Pointer handle);

  /**
   * Original signature :
   * <code>void TessResultIteratorDelete(TessResultIterator*)</code><br>
   * <i>native declaration : line 343</i>
   */
  void TessResultIteratorDelete(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessResultIterator* TessResultIteratorCopy(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 344</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorCopy(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessResultIteratorCopy(Pointer handle);

  /**
   * Original signature :
   * <code>TessResultIterator* TessResultIteratorCopy(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 344</i>
   */
  PointerByReference TessResultIteratorCopy(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIterator(TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 346</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorGetPageIterator(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessResultIteratorGetPageIterator(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIterator(TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 346</i>
   */
  PointerByReference TessResultIteratorGetPageIterator(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIteratorConst(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 348</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorGetPageIteratorConst(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference TessResultIteratorGetPageIteratorConst(Pointer handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIteratorConst(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 348</i>
   */
  PointerByReference TessResultIteratorGetPageIteratorConst(
      PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessResultIteratorGetUTF8Text(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 351</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorGetUTF8Text(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  String TessResultIteratorGetUTF8Text(Pointer handle, int level);

  /**
   * Original signature :
   * <code>char* TessResultIteratorGetUTF8Text(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 351</i>
   */
  String TessResultIteratorGetUTF8Text(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>float TessResultIteratorConfidence(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 352</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorConfidence(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  float TessResultIteratorConfidence(Pointer handle, int level);

  /**
   * Original signature :
   * <code>float TessResultIteratorConfidence(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 352</i>
   */
  float TessResultIteratorConfidence(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 354</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #TessResultIteratorWordFontAttributes(com.sun.jna.ptr.PointerByReference, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer, java.nio.IntBuffer)}
   *             and
   *             {@link #TessResultIteratorWordFontAttributes(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  String TessResultIteratorWordFontAttributes(Pointer handle,
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
  String TessResultIteratorWordFontAttributes(PointerByReference handle,
      IntBuffer is_bold, IntBuffer is_italic, IntBuffer is_underlined,
      IntBuffer is_monospace, IntBuffer is_serif, IntBuffer is_smallcaps,
      IntBuffer pointsize, IntBuffer font_id);

  /**
   * Original signature :
   * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 354</i>
   */
  String TessResultIteratorWordFontAttributes(PointerByReference handle,
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
   *             {@link #TessResultIteratorWordIsFromDictionary(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessResultIteratorWordIsFromDictionary(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorWordIsFromDictionary(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 359</i>
   */
  int TessResultIteratorWordIsFromDictionary(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorWordIsNumeric(const TessResultIterator*)</code><br>
   * <i>native declaration : line 360</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorWordIsNumeric(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessResultIteratorWordIsNumeric(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorWordIsNumeric(const TessResultIterator*)</code><br>
   * <i>native declaration : line 360</i>
   */
  int TessResultIteratorWordIsNumeric(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSuperscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 361</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorSymbolIsSuperscript(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessResultIteratorSymbolIsSuperscript(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSuperscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 361</i>
   */
  int TessResultIteratorSymbolIsSuperscript(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSubscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 362</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorSymbolIsSubscript(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessResultIteratorSymbolIsSubscript(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSubscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 362</i>
   */
  int TessResultIteratorSymbolIsSubscript(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsDropcap(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 363</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #TessResultIteratorSymbolIsDropcap(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int TessResultIteratorSymbolIsDropcap(Pointer handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsDropcap(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 363</i>
   */
  int TessResultIteratorSymbolIsDropcap(PointerByReference handle);

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
