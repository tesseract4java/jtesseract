package de.vorb.jtesseract;

import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.DoubleByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 * JNA Wrapper for libtesseract.
 */
public interface TesseractLibrary extends Library {
  /** enum values */
  public static interface TessOcrEngineMode {
    /** <i>native declaration : line 57</i> */
    public static final int OEM_TESSERACT_ONLY = 0;
    /** <i>native declaration : line 57</i> */
    public static final int OEM_CUBE_ONLY = 1;
    /** <i>native declaration : line 57</i> */
    public static final int OEM_TESSERACT_CUBE_COMBINED = 2;
    /** <i>native declaration : line 57</i> */
    public static final int OEM_DEFAULT = 3;
  };

  /** enum values */
  public static interface TessPageSegMode {
    /** <i>native declaration : line 58</i> */
    public static final int PSM_OSD_ONLY = 0;
    /** <i>native declaration : line 58</i> */
    public static final int PSM_AUTO_OSD = 1;
    /** <i>native declaration : line 58</i> */
    public static final int PSM_AUTO_ONLY = 2;
    /** <i>native declaration : line 58</i> */
    public static final int PSM_AUTO = 3;
    /** <i>native declaration : line 58</i> */
    public static final int PSM_SINGLE_COLUMN = 4;
    /** <i>native declaration : line 58</i> */
    public static final int PSM_SINGLE_BLOCK_VERT_TEXT = 5;
    /** <i>native declaration : line 59</i> */
    public static final int PSM_SINGLE_BLOCK = 6;
    /** <i>native declaration : line 59</i> */
    public static final int PSM_SINGLE_LINE = 7;
    /** <i>native declaration : line 59</i> */
    public static final int PSM_SINGLE_WORD = 8;
    /** <i>native declaration : line 59</i> */
    public static final int PSM_CIRCLE_WORD = 9;
    /** <i>native declaration : line 59</i> */
    public static final int PSM_SINGLE_CHAR = 10;
    /** <i>native declaration : line 59</i> */
    public static final int PSM_COUNT = 11;
  };

  /** enum values */
  public static interface TessPageIteratorLevel {
    /** <i>native declaration : line 60</i> */
    public static final int RIL_BLOCK = 0;
    /** <i>native declaration : line 60</i> */
    public static final int RIL_PARA = 1;
    /** <i>native declaration : line 60</i> */
    public static final int RIL_TEXTLINE = 2;
    /** <i>native declaration : line 60</i> */
    public static final int RIL_WORD = 3;
    /** <i>native declaration : line 60</i> */
    public static final int RIL_SYMBOL = 4;
  };

  /** enum values */
  public static interface TessPolyBlockType {
    /** <i>native declaration : line 61</i> */
    public static final int PT_UNKNOWN = 0;
    /** <i>native declaration : line 61</i> */
    public static final int PT_FLOWING_TEXT = 1;
    /** <i>native declaration : line 61</i> */
    public static final int PT_HEADING_TEXT = 2;
    /** <i>native declaration : line 61</i> */
    public static final int PT_PULLOUT_TEXT = 3;
    /** <i>native declaration : line 61</i> */
    public static final int PT_TABLE = 4;
    /** <i>native declaration : line 61</i> */
    public static final int PT_VERTICAL_TEXT = 5;
    /** <i>native declaration : line 62</i> */
    public static final int PT_CAPTION_TEXT = 6;
    /** <i>native declaration : line 62</i> */
    public static final int PT_FLOWING_IMAGE = 7;
    /** <i>native declaration : line 62</i> */
    public static final int PT_HEADING_IMAGE = 8;
    /** <i>native declaration : line 62</i> */
    public static final int PT_PULLOUT_IMAGE = 9;
    /** <i>native declaration : line 62</i> */
    public static final int PT_HORZ_LINE = 10;
    /** <i>native declaration : line 62</i> */
    public static final int PT_VERT_LINE = 11;
    /** <i>native declaration : line 63</i> */
    public static final int PT_NOISE = 12;
    /** <i>native declaration : line 63</i> */
    public static final int PT_COUNT = 13;
  };

  /** enum values */
  public static interface TessOrientation {
    /** <i>native declaration : line 64</i> */
    public static final int ORIENTATION_PAGE_UP = 0;
    /** <i>native declaration : line 64</i> */
    public static final int ORIENTATION_PAGE_RIGHT = 1;
    /** <i>native declaration : line 64</i> */
    public static final int ORIENTATION_PAGE_DOWN = 2;
    /** <i>native declaration : line 64</i> */
    public static final int ORIENTATION_PAGE_LEFT = 3;
  };

  /** enum values */
  public static interface TessWritingDirection {
    /** <i>native declaration : line 65</i> */
    public static final int WRITING_DIRECTION_LEFT_TO_RIGHT = 0;
    /** <i>native declaration : line 65</i> */
    public static final int WRITING_DIRECTION_RIGHT_TO_LEFT = 1;
    /** <i>native declaration : line 65</i> */
    public static final int WRITING_DIRECTION_TOP_TO_BOTTOM = 2;
  };

  /** enum values */
  public static interface TessTextlineOrder {
    /** <i>native declaration : line 66</i> */
    public static final int TEXTLINE_ORDER_LEFT_TO_RIGHT = 0;
    /** <i>native declaration : line 66</i> */
    public static final int TEXTLINE_ORDER_RIGHT_TO_LEFT = 1;
    /** <i>native declaration : line 66</i> */
    public static final int TEXTLINE_ORDER_TOP_TO_BOTTOM = 2;
  };

  public static final int TRUE = (int) 1;
  public static final int FALSE = (int) 0;

  /**
   * Original signature : <code>char* TessVersion()</code><br>
   * <i>native declaration : line 75</i>
   */
  String tessVersion();

  /**
   * Original signature : <code>void TessDeleteText(char*)</code><br>
   * <i>native declaration : line 77</i><br>
   * 
   * @deprecated use the safer methods {@link #tessDeleteText(java.lang.String)}
   *             and {@link #tessDeleteText(com.sun.jna.Pointer)} instead
   */
  @Deprecated
  void tessDeleteText(Pointer text);

  /**
   * Original signature : <code>void TessDeleteText(char*)</code><br>
   * <i>native declaration : line 77</i>
   */
  void tessDeleteText(String text);

  /**
   * Original signature : <code>void TessDeleteTextArray(char**)</code><br>
   * <i>native declaration : line 78</i><br>
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
   * <i>native declaration : line 78</i>
   */
  void tessDeleteTextArray(String arr[]);

  /**
   * Original signature : <code>void TessDeleteIntArray(int*)</code><br>
   * <i>native declaration : line 79</i><br>
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
   * <i>native declaration : line 79</i>
   */
  void tessDeleteIntArray(IntBuffer arr);

  /**
   * Original signature : <code>TessBaseAPI* TessBaseAPICreate()</code><br>
   * <i>native declaration : line 86</i>
   */
  PointerByReference tessBaseAPICreate();

  /**
   * Original signature : <code>void TessBaseAPIDelete(TessBaseAPI*)</code><br>
   * <i>native declaration : line 88</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIDelete(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIDelete(Pointer handle);

  /**
   * Original signature : <code>void TessBaseAPIDelete(TessBaseAPI*)</code><br>
   * <i>native declaration : line 88</i>
   */
  void tessBaseAPIDelete(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 90</i><br>
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
   * <i>native declaration : line 90</i>
   */
  void tessBaseAPISetInputName(PointerByReference handle, String name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetInputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 90</i>
   */
  void tessBaseAPISetInputName(PointerByReference handle, Pointer name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 91</i><br>
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
   * <i>native declaration : line 91</i>
   */
  void tessBaseAPISetOutputName(PointerByReference handle, String name);

  /**
   * Original signature :
   * <code>void TessBaseAPISetOutputName(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 91</i>
   */
  void tessBaseAPISetOutputName(PointerByReference handle, Pointer name);

  /**
   * Original signature :
   * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 93</i><br>
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
   * <i>native declaration : line 93</i>
   */
  int tessBaseAPISetVariable(PointerByReference handle, String name,
      String value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 93</i>
   */
  int tessBaseAPISetVariable(PointerByReference handle, Pointer name,
      Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 94</i><br>
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
   * <i>native declaration : line 94</i>
   */
  int tessBaseAPISetDebugVariable(PointerByReference handle, String name,
      String value);

  /**
   * Original signature :
   * <code>int TessBaseAPISetDebugVariable(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 94</i>
   */
  int tessBaseAPISetDebugVariable(PointerByReference handle, Pointer name,
      Pointer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 96</i><br>
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
   * <i>native declaration : line 96</i>
   */
  int tessBaseAPIGetIntVariable(PointerByReference handle, String name,
      IntBuffer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetIntVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 96</i>
   */
  int tessBaseAPIGetIntVariable(PointerByReference handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 97</i><br>
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
   * <i>native declaration : line 97</i>
   */
  int tessBaseAPIGetBoolVariable(PointerByReference handle, String name,
      IntBuffer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetBoolVariable(const TessBaseAPI*, const char*, int*)</code>
   * <br>
   * <i>native declaration : line 97</i>
   */
  int tessBaseAPIGetBoolVariable(PointerByReference handle, Pointer name,
      IntByReference value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
   * <br>
   * <i>native declaration : line 98</i><br>
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
   * <i>native declaration : line 98</i>
   */
  int tessBaseAPIGetDoubleVariable(PointerByReference handle, String name,
      DoubleBuffer value);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetDoubleVariable(const TessBaseAPI*, const char*, double*)</code>
   * <br>
   * <i>native declaration : line 98</i>
   */
  int tessBaseAPIGetDoubleVariable(PointerByReference handle, Pointer name,
      DoubleByReference value);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 99</i><br>
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
   * <i>native declaration : line 99</i>
   */
  String tessBaseAPIGetStringVariable(PointerByReference handle, String name);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetStringVariable(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 99</i>
   */
  String tessBaseAPIGetStringVariable(PointerByReference handle, Pointer name);

  /**
   * Original signature :
   * <code>void TessBaseAPIPrintVariables(const TessBaseAPI*, FILE*)</code><br>
   * <i>native declaration : line 102</i><br>
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
   * <i>native declaration : line 102</i>
   */
  void tessBaseAPIPrintVariables(PointerByReference handle,
      TesseractLibrary.FILE fp);

  /**
   * Original signature :
   * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 103</i><br>
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
   * <i>native declaration : line 103</i>
   */
  int tessBaseAPIPrintVariablesToFile(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>int TessBaseAPIPrintVariablesToFile(const TessBaseAPI*, const char*)</code>
   * <br>
   * <i>native declaration : line 103</i>
   */
  int tessBaseAPIPrintVariablesToFile(PointerByReference handle,
      Pointer filename);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
   * <br>
   * <i>native declaration : line 114</i><br>
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
   * <i>native declaration : line 114</i>
   */
  int tessBaseAPIInit1(PointerByReference handle, String datapath,
      String language, int oem, String configs[], int configs_size);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit1(TessBaseAPI*, const char*, const char*, TessOcrEngineMode, char**, int)</code>
   * <br>
   * <i>native declaration : line 114</i>
   */
  int tessBaseAPIInit1(PointerByReference handle, Pointer datapath,
      Pointer language, int oem, PointerByReference configs, int configs_size);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
   * <br>
   * <i>native declaration : line 116</i><br>
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
   * <i>native declaration : line 116</i>
   */
  int tessBaseAPIInit2(PointerByReference handle, String datapath,
      String language, int oem);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit2(TessBaseAPI*, const char*, const char*, TessOcrEngineMode)</code>
   * <br>
   * <i>native declaration : line 116</i>
   */
  int tessBaseAPIInit2(PointerByReference handle, Pointer datapath,
      Pointer language, int oem);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
   * <i>native declaration : line 117</i><br>
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
   * <i>native declaration : line 117</i>
   */
  int tessBaseAPIInit3(PointerByReference handle, String datapath,
      String language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInit3(TessBaseAPI*, const char*, const char*)</code><br>
   * <i>native declaration : line 117</i>
   */
  int tessBaseAPIInit3(PointerByReference handle, Pointer datapath,
      Pointer language);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetInitLanguagesAsString(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 119</i><br>
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
   * <i>native declaration : line 119</i>
   */
  String tessBaseAPIGetInitLanguagesAsString(PointerByReference handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetLoadedLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 121</i><br>
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
   * <i>native declaration : line 121</i>
   */
  PointerByReference tessBaseAPIGetLoadedLanguagesAsVector(
      PointerByReference handle);

  /**
   * Original signature :
   * <code>char** TessBaseAPIGetAvailableLanguagesAsVector(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 123</i><br>
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
   * <i>native declaration : line 123</i>
   */
  PointerByReference tessBaseAPIGetAvailableLanguagesAsVector(
      PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 126</i><br>
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
   * <i>native declaration : line 126</i>
   */
  int tessBaseAPIInitLangMod(PointerByReference handle, String datapath,
      String language);

  /**
   * Original signature :
   * <code>int TessBaseAPIInitLangMod(TessBaseAPI*, const char*, const char*)</code>
   * <br>
   * <i>native declaration : line 126</i>
   */
  int tessBaseAPIInitLangMod(PointerByReference handle, Pointer datapath,
      Pointer language);

  /**
   * Original signature :
   * <code>void TessBaseAPIInitForAnalysePage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 127</i><br>
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
   * <i>native declaration : line 127</i>
   */
  void tessBaseAPIInitForAnalysePage(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 129</i><br>
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
   * <i>native declaration : line 129</i>
   */
  void tessBaseAPIReadConfigFile(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 129</i>
   */
  void tessBaseAPIReadConfigFile(PointerByReference handle, Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 130</i><br>
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
   * <i>native declaration : line 130</i>
   */
  void tessBaseAPIReadDebugConfigFile(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIReadDebugConfigFile(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 130</i>
   */
  void tessBaseAPIReadDebugConfigFile(PointerByReference handle,
      Pointer filename);

  /**
   * Original signature :
   * <code>void TessBaseAPISetPageSegMode(TessBaseAPI*, TessPageSegMode)</code><br>
   * <i>native declaration : line 132</i><br>
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
   * <i>native declaration : line 132</i>
   */
  void tessBaseAPISetPageSegMode(PointerByReference handle, int mode);

  /**
   * Original signature :
   * <code>TessPageSegMode TessBaseAPIGetPageSegMode(const TessBaseAPI*)</code><br>
   * <i>native declaration : line 133</i><br>
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
   * <i>native declaration : line 133</i>
   */
  int tessBaseAPIGetPageSegMode(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 136</i><br>
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
   * <i>native declaration : line 136</i>
   */
  String tessBaseAPIRect(PointerByReference handle, byte imagedata[],
      int bytes_per_pixel, int bytes_per_line, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>char* TessBaseAPIRect(TessBaseAPI*, const unsigned char*, int, int, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 136</i>
   */
  String tessBaseAPIRect(PointerByReference handle, Pointer imagedata,
      int bytes_per_pixel, int bytes_per_line, int left, int top, int width,
      int height);

  /**
   * Original signature :
   * <code>void TessBaseAPIClearAdaptiveClassifier(TessBaseAPI*)</code><br>
   * <i>native declaration : line 140</i><br>
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
   * <i>native declaration : line 140</i>
   */
  void tessBaseAPIClearAdaptiveClassifier(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 142</i><br>
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
   * <i>native declaration : line 142</i>
   */
  void tessBaseAPISetImage(PointerByReference handle, byte imagedata[],
      int width, int height, int bytes_per_pixel, int bytes_per_line);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage(TessBaseAPI*, const unsigned char*, int, int, int, int)</code>
   * <br>
   * <i>native declaration : line 142</i>
   */
  void tessBaseAPISetImage(PointerByReference handle, Pointer imagedata,
      int width, int height, int bytes_per_pixel, int bytes_per_line);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage2(TessBaseAPI*, const PIX*)</code><br>
   * <i>native declaration : line 144</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPISetImage2(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessBaseAPISetImage2(Pointer handle, Pointer pix);

  /**
   * Original signature :
   * <code>void TessBaseAPISetImage2(TessBaseAPI*, const PIX*)</code><br>
   * <i>native declaration : line 144</i>
   */
  void tessBaseAPISetImage2(PointerByReference handle, PointerByReference pix);

  /**
   * Original signature :
   * <code>void TessBaseAPISetSourceResolution(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 146</i><br>
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
   * <i>native declaration : line 146</i>
   */
  void tessBaseAPISetSourceResolution(PointerByReference handle, int ppi);

  /**
   * Original signature :
   * <code>void TessBaseAPISetRectangle(TessBaseAPI*, int, int, int, int)</code><br>
   * <i>native declaration : line 148</i><br>
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
   * <i>native declaration : line 148</i>
   */
  void tessBaseAPISetRectangle(PointerByReference handle, int left, int top,
      int width, int height);

  /**
   * Original signature :
   * <code>PIX* TessBaseAPIGetThresholdedImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 154</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetThresholdedImage(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetThresholdedImage(Pointer handle);

  /**
   * Original signature :
   * <code>PIX* TessBaseAPIGetThresholdedImage(TessBaseAPI*)</code><br>
   * <i>native declaration : line 154</i>
   */
  PointerByReference tessBaseAPIGetThresholdedImage(PointerByReference handle);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetRegions(TessBaseAPI*, PIXA**)</code><br>
   * <i>native declaration : line 155</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetRegions(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetRegions(Pointer handle,
      PointerByReference pixa);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetRegions(TessBaseAPI*, PIXA**)</code><br>
   * <i>native declaration : line 155</i>
   */
  PointerByReference tessBaseAPIGetRegions(PointerByReference handle,
      PointerByReference pixa);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetTextlines(TessBaseAPI*, PIXA**, int**)</code><br>
   * <i>native declaration : line 156</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetTextlines(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetTextlines(Pointer handle,
      PointerByReference pixa, PointerByReference blockids);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetTextlines(TessBaseAPI*, PIXA**, int**)</code><br>
   * <i>native declaration : line 156</i>
   */
  PointerByReference tessBaseAPIGetTextlines(PointerByReference handle,
      PointerByReference pixa, PointerByReference blockids);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetStrips(TessBaseAPI*, PIXA**, int**)</code><br>
   * <i>native declaration : line 157</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetStrips(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetStrips(Pointer handle,
      PointerByReference pixa, PointerByReference blockids);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetStrips(TessBaseAPI*, PIXA**, int**)</code><br>
   * <i>native declaration : line 157</i>
   */
  PointerByReference tessBaseAPIGetStrips(PointerByReference handle,
      PointerByReference pixa, PointerByReference blockids);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetWords(TessBaseAPI*, PIXA**)</code><br>
   * <i>native declaration : line 158</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetWords(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetWords(Pointer handle, PointerByReference pixa);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetWords(TessBaseAPI*, PIXA**)</code><br>
   * <i>native declaration : line 158</i>
   */
  PointerByReference tessBaseAPIGetWords(PointerByReference handle,
      PointerByReference pixa);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetConnectedComponents(TessBaseAPI*, PIXA**)</code><br>
   * <i>native declaration : line 159</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetConnectedComponents(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetConnectedComponents(Pointer handle,
      PointerByReference cc);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetConnectedComponents(TessBaseAPI*, PIXA**)</code><br>
   * <i>native declaration : line 159</i>
   */
  PointerByReference tessBaseAPIGetConnectedComponents(
      PointerByReference handle, PointerByReference cc);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetComponentImages(TessBaseAPI*, TessPageIteratorLevel, int, PIXA**, int**)</code>
   * <br>
   * <i>native declaration : line 160</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIGetComponentImages(com.sun.jna.ptr.PointerByReference, int, int, com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessBaseAPIGetComponentImages(Pointer handle, int level,
      int text_only, PointerByReference pixa, PointerByReference blockids);

  /**
   * Original signature :
   * <code>BOXA* TessBaseAPIGetComponentImages(TessBaseAPI*, TessPageIteratorLevel, int, PIXA**, int**)</code>
   * <br>
   * <i>native declaration : line 160</i>
   */
  PointerByReference tessBaseAPIGetComponentImages(PointerByReference handle,
      int level, int text_only, PointerByReference pixa,
      PointerByReference blockids);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetThresholdedImageScaleFactor(const TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 162</i><br>
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
   * <i>native declaration : line 162</i>
   */
  int tessBaseAPIGetThresholdedImageScaleFactor(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 164</i><br>
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
   * <i>native declaration : line 164</i>
   */
  void tessBaseAPIDumpPGM(PointerByReference handle, String filename);

  /**
   * Original signature :
   * <code>void TessBaseAPIDumpPGM(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 164</i>
   */
  void tessBaseAPIDumpPGM(PointerByReference handle, Pointer filename);

  /**
   * Original signature :
   * <code>TessPageIterator* TessBaseAPIAnalyseLayout(TessBaseAPI*)</code><br>
   * <i>native declaration : line 166</i><br>
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
   * <i>native declaration : line 166</i>
   */
  PointerByReference tessBaseAPIAnalyseLayout(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognize(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 169</i><br>
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
   * <i>native declaration : line 169</i>
   */
  int tessBaseAPIRecognize(PointerByReference handle, PointerByReference monitor);

  /**
   * Original signature :
   * <code>int TessBaseAPIRecognizeForChopTest(TessBaseAPI*, ETEXT_DESC*)</code><br>
   * <i>native declaration : line 170</i><br>
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
   * <i>native declaration : line 170</i>
   */
  int tessBaseAPIRecognizeForChopTest(PointerByReference handle,
      PointerByReference monitor);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 171</i><br>
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
   * <i>native declaration : line 171</i>
   */
  String tessBaseAPIProcessPages(PointerByReference handle, String filename,
      String retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPages(TessBaseAPI*, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 171</i>
   */
  String tessBaseAPIProcessPages(PointerByReference handle, Pointer filename,
      Pointer retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, PIX*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 173</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessBaseAPIProcessPage(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference, int, java.lang.String, java.lang.String, int)}
   *             and
   *             {@link #tessBaseAPIProcessPage(com.sun.jna.ptr.PointerByReference, com.sun.jna.ptr.PointerByReference, int, com.sun.jna.Pointer, com.sun.jna.Pointer, int)}
   *             instead
   */
  @Deprecated
  String tessBaseAPIProcessPage(Pointer handle, Pointer pix, int page_index,
      Pointer filename, Pointer retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, PIX*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 173</i>
   */
  String tessBaseAPIProcessPage(PointerByReference handle,
      PointerByReference pix, int page_index, String filename,
      String retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>char* TessBaseAPIProcessPage(TessBaseAPI*, PIX*, int, const char*, const char*, int)</code>
   * <br>
   * <i>native declaration : line 173</i>
   */
  String tessBaseAPIProcessPage(PointerByReference handle,
      PointerByReference pix, int page_index, Pointer filename,
      Pointer retry_config, int timeout_millisec);

  /**
   * Original signature :
   * <code>TessResultIterator* TessBaseAPIGetIterator(TessBaseAPI*)</code><br>
   * <i>native declaration : line 176</i><br>
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
   * <i>native declaration : line 176</i>
   */
  PointerByReference tessBaseAPIGetIterator(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessMutableIterator* TessBaseAPIGetMutableIterator(TessBaseAPI*)</code>
   * <br>
   * <i>native declaration : line 178</i><br>
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
   * <i>native declaration : line 178</i>
   */
  PointerByReference tessBaseAPIGetMutableIterator(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUTF8Text(TessBaseAPI*)</code><br>
   * <i>native declaration : line 181</i><br>
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
   * <i>native declaration : line 181</i>
   */
  String tessBaseAPIGetUTF8Text(PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetHOCRText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 182</i><br>
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
   * <i>native declaration : line 182</i>
   */
  String tessBaseAPIGetHOCRText(PointerByReference handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetBoxText(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 183</i><br>
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
   * <i>native declaration : line 183</i>
   */
  String tessBaseAPIGetBoxText(PointerByReference handle, int page_number);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUNLVText(TessBaseAPI*)</code><br>
   * <i>native declaration : line 184</i><br>
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
   * <i>native declaration : line 184</i>
   */
  String tessBaseAPIGetUNLVText(PointerByReference handle);

  /**
   * Original signature : <code>int TessBaseAPIMeanTextConf(TessBaseAPI*)</code><br>
   * <i>native declaration : line 185</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIMeanTextConf(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  int tessBaseAPIMeanTextConf(Pointer handle);

  /**
   * Original signature : <code>int TessBaseAPIMeanTextConf(TessBaseAPI*)</code><br>
   * <i>native declaration : line 185</i>
   */
  int tessBaseAPIMeanTextConf(PointerByReference handle);

  /**
   * Original signature :
   * <code>int* TessBaseAPIAllWordConfidences(TessBaseAPI*)</code><br>
   * <i>native declaration : line 186</i><br>
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
   * <i>native declaration : line 186</i>
   */
  IntByReference tessBaseAPIAllWordConfidences(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
   * <br>
   * <i>native declaration : line 187</i><br>
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
   * <i>native declaration : line 187</i>
   */
  int tessBaseAPIAdaptToWordStr(PointerByReference handle, int mode,
      String wordstr);

  /**
   * Original signature :
   * <code>int TessBaseAPIAdaptToWordStr(TessBaseAPI*, TessPageSegMode, const char*)</code>
   * <br>
   * <i>native declaration : line 187</i>
   */
  int tessBaseAPIAdaptToWordStr(PointerByReference handle, int mode,
      Pointer wordstr);

  /**
   * Original signature : <code>void TessBaseAPIClear(TessBaseAPI*)</code><br>
   * <i>native declaration : line 189</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIClear(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIClear(Pointer handle);

  /**
   * Original signature : <code>void TessBaseAPIClear(TessBaseAPI*)</code><br>
   * <i>native declaration : line 189</i>
   */
  void tessBaseAPIClear(PointerByReference handle);

  /**
   * Original signature : <code>void TessBaseAPIEnd(TessBaseAPI*)</code><br>
   * <i>native declaration : line 190</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessBaseAPIEnd(com.sun.jna.ptr.PointerByReference)}
   *             instead
   */
  @Deprecated
  void tessBaseAPIEnd(Pointer handle);

  /**
   * Original signature : <code>void TessBaseAPIEnd(TessBaseAPI*)</code><br>
   * <i>native declaration : line 190</i>
   */
  void tessBaseAPIEnd(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 192</i><br>
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
   * <i>native declaration : line 192</i>
   */
  int tessBaseAPIIsValidWord(PointerByReference handle, String word);

  /**
   * Original signature :
   * <code>int TessBaseAPIIsValidWord(TessBaseAPI*, const char*)</code><br>
   * <i>native declaration : line 192</i>
   */
  int tessBaseAPIIsValidWord(PointerByReference handle, Pointer word);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
   * <i>native declaration : line 193</i><br>
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
   * <i>native declaration : line 193</i>
   */
  int tessBaseAPIGetTextDirection(PointerByReference handle,
      IntBuffer out_offset, FloatBuffer out_slope);

  /**
   * Original signature :
   * <code>int TessBaseAPIGetTextDirection(TessBaseAPI*, int*, float*)</code><br>
   * <i>native declaration : line 193</i>
   */
  int tessBaseAPIGetTextDirection(PointerByReference handle,
      IntByReference out_offset, FloatByReference out_slope);

  /**
   * Original signature :
   * <code>char* TessBaseAPIGetUnichar(TessBaseAPI*, int)</code><br>
   * <i>native declaration : line 209</i><br>
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
   * <i>native declaration : line 209</i>
   */
  String tessBaseAPIGetUnichar(PointerByReference handle, int unichar_id);

  /**
   * Original signature :
   * <code>void TessBaseAPISetMinOrientationMargin(TessBaseAPI*, double)</code><br>
   * <i>native declaration : line 232</i><br>
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
   * <i>native declaration : line 232</i>
   */
  void tessBaseAPISetMinOrientationMargin(PointerByReference handle,
      double margin);

  /**
   * Original signature :
   * <code>void TessPageIteratorDelete(TessPageIterator*)</code><br>
   * <i>native declaration : line 242</i><br>
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
   * <i>native declaration : line 242</i>
   */
  void tessPageIteratorDelete(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessPageIteratorCopy(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 243</i><br>
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
   * <i>native declaration : line 243</i>
   */
  PointerByReference tessPageIteratorCopy(PointerByReference handle);

  /**
   * Original signature :
   * <code>void TessPageIteratorBegin(TessPageIterator*)</code><br>
   * <i>native declaration : line 246</i><br>
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
   * <i>native declaration : line 246</i>
   */
  void tessPageIteratorBegin(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessPageIteratorNext(TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 247</i><br>
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
   * <i>native declaration : line 247</i>
   */
  int tessPageIteratorNext(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtBeginningOf(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 248</i><br>
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
   * <i>native declaration : line 248</i>
   */
  int tessPageIteratorIsAtBeginningOf(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>int TessPageIteratorIsAtFinalElement(const TessPageIterator*, TessPageIteratorLevel, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 249</i><br>
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
   * <i>native declaration : line 249</i>
   */
  int tessPageIteratorIsAtFinalElement(PointerByReference handle, int level,
      int element);

  /**
   * Original signature :
   * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 252</i><br>
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
   * <i>native declaration : line 252</i>
   */
  int tessPageIteratorBoundingBox(PointerByReference handle, int level,
      IntBuffer left, IntBuffer top, IntBuffer right, IntBuffer bottom);

  /**
   * Original signature :
   * <code>int TessPageIteratorBoundingBox(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 252</i>
   */
  int tessPageIteratorBoundingBox(PointerByReference handle, int level,
      IntByReference left, IntByReference top, IntByReference right,
      IntByReference bottom);

  /**
   * Original signature :
   * <code>TessPolyBlockType TessPageIteratorBlockType(const TessPageIterator*)</code>
   * <br>
   * <i>native declaration : line 254</i><br>
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
   * <i>native declaration : line 254</i>
   */
  int tessPageIteratorBlockType(PointerByReference handle);

  /**
   * Original signature :
   * <code>PIX* TessPageIteratorGetBinaryImage(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 257</i><br>
   * 
   * @deprecated use the safer method
   *             {@link #tessPageIteratorGetBinaryImage(com.sun.jna.ptr.PointerByReference, int)}
   *             instead
   */
  @Deprecated
  PointerByReference tessPageIteratorGetBinaryImage(Pointer handle, int level);

  /**
   * Original signature :
   * <code>PIX* TessPageIteratorGetBinaryImage(const TessPageIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 257</i>
   */
  PointerByReference tessPageIteratorGetBinaryImage(PointerByReference handle,
      int level);

  /**
   * Original signature :
   * <code>PIX* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 258</i><br>
   * 
   * @deprecated use the safer methods
   *             {@link #tessPageIteratorGetImage(com.sun.jna.ptr.PointerByReference, int, int, java.nio.IntBuffer, java.nio.IntBuffer)}
   *             and
   *             {@link #tessPageIteratorGetImage(com.sun.jna.ptr.PointerByReference, int, int, com.sun.jna.ptr.IntByReference, com.sun.jna.ptr.IntByReference)}
   *             instead
   */
  @Deprecated
  PointerByReference tessPageIteratorGetImage(Pointer handle, int level,
      int padding, IntByReference left, IntByReference top);

  /**
   * Original signature :
   * <code>PIX* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 258</i>
   */
  PointerByReference tessPageIteratorGetImage(PointerByReference handle,
      int level, int padding, IntBuffer left, IntBuffer top);

  /**
   * Original signature :
   * <code>PIX* TessPageIteratorGetImage(const TessPageIterator*, TessPageIteratorLevel, int, int*, int*)</code>
   * <br>
   * <i>native declaration : line 258</i>
   */
  PointerByReference tessPageIteratorGetImage(PointerByReference handle,
      int level, int padding, IntByReference left, IntByReference top);

  /**
   * Original signature :
   * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 261</i><br>
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
   * <i>native declaration : line 261</i>
   */
  int tessPageIteratorBaseline(PointerByReference handle, int level,
      IntBuffer x1, IntBuffer y1, IntBuffer x2, IntBuffer y2);

  /**
   * Original signature :
   * <code>int TessPageIteratorBaseline(const TessPageIterator*, TessPageIteratorLevel, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 261</i>
   */
  int tessPageIteratorBaseline(PointerByReference handle, int level,
      IntByReference x1, IntByReference y1, IntByReference x2, IntByReference y2);

  /**
   * Original signature :
   * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
   * <br>
   * <i>native declaration : line 264</i><br>
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
   * <i>native declaration : line 264</i>
   */
  void tessPageIteratorOrientation(PointerByReference handle,
      IntBuffer orientation, IntBuffer writing_direction,
      IntBuffer textline_order, FloatBuffer deskew_angle);

  /**
   * Original signature :
   * <code>void TessPageIteratorOrientation(TessPageIterator*, TessOrientation*, TessWritingDirection*, TessTextlineOrder*, float*)</code>
   * <br>
   * <i>native declaration : line 264</i>
   */
  void tessPageIteratorOrientation(PointerByReference handle,
      IntByReference orientation, IntByReference writing_direction,
      IntByReference textline_order, FloatByReference deskew_angle);

  /**
   * Original signature :
   * <code>void TessResultIteratorDelete(TessResultIterator*)</code><br>
   * <i>native declaration : line 270</i><br>
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
   * <i>native declaration : line 270</i>
   */
  void tessResultIteratorDelete(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessResultIterator* TessResultIteratorCopy(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 271</i><br>
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
   * <i>native declaration : line 271</i>
   */
  PointerByReference tessResultIteratorCopy(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIterator(TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 273</i><br>
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
   * <i>native declaration : line 273</i>
   */
  PointerByReference tessResultIteratorGetPageIterator(PointerByReference handle);

  /**
   * Original signature :
   * <code>TessPageIterator* TessResultIteratorGetPageIteratorConst(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 275</i><br>
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
   * <i>native declaration : line 275</i>
   */
  PointerByReference tessResultIteratorGetPageIteratorConst(
      PointerByReference handle);

  /**
   * Original signature :
   * <code>char* TessResultIteratorGetUTF8Text(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 278</i><br>
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
   * <i>native declaration : line 278</i>
   */
  String tessResultIteratorGetUTF8Text(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>float TessResultIteratorConfidence(const TessResultIterator*, TessPageIteratorLevel)</code>
   * <br>
   * <i>native declaration : line 279</i><br>
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
   * <i>native declaration : line 279</i>
   */
  float tessResultIteratorConfidence(PointerByReference handle, int level);

  /**
   * Original signature :
   * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 281</i><br>
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
   * <i>native declaration : line 281</i>
   */
  String tessResultIteratorWordFontAttributes(PointerByReference handle,
      IntBuffer is_bold, IntBuffer is_italic, IntBuffer is_underlined,
      IntBuffer is_monospace, IntBuffer is_serif, IntBuffer is_smallcaps,
      IntBuffer pointsize, IntBuffer font_id);

  /**
   * Original signature :
   * <code>char* TessResultIteratorWordFontAttributes(const TessResultIterator*, int*, int*, int*, int*, int*, int*, int*, int*)</code>
   * <br>
   * <i>native declaration : line 281</i>
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
   * <i>native declaration : line 286</i><br>
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
   * <i>native declaration : line 286</i>
   */
  int tessResultIteratorWordIsFromDictionary(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorWordIsNumeric(const TessResultIterator*)</code><br>
   * <i>native declaration : line 287</i><br>
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
   * <i>native declaration : line 287</i>
   */
  int tessResultIteratorWordIsNumeric(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSuperscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 288</i><br>
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
   * <i>native declaration : line 288</i>
   */
  int tessResultIteratorSymbolIsSuperscript(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsSubscript(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 289</i><br>
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
   * <i>native declaration : line 289</i>
   */
  int tessResultIteratorSymbolIsSubscript(PointerByReference handle);

  /**
   * Original signature :
   * <code>int TessResultIteratorSymbolIsDropcap(const TessResultIterator*)</code>
   * <br>
   * <i>native declaration : line 290</i><br>
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
   * <i>native declaration : line 290</i>
   */
  int tessResultIteratorSymbolIsDropcap(PointerByReference handle);

  public static class BOXA extends PointerType {
    public BOXA(Pointer address) {
      super(address);
    }

    public BOXA() {
      super();
    }
  };

  public static class PIX extends PointerType {
    public PIX(Pointer address) {
      super(address);
    }

    public PIX() {
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

  public static class PIXA extends PointerType {
    public PIXA(Pointer address) {
      super(address);
    }

    public PIXA() {
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
}
