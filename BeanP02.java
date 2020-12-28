package p3;

import java.util.ArrayList;
import p3.WarningFile;
import p3.ErrorFile;
import p3.FatalErrorFile;

public class BeanP02 {

  private String pphase;
  private String password;
  private ArrayList<WarningFile> warningsFiles;
  private ArrayList<ErrorFile> errorsFiles;
  private ArrayList<FatalErrorFile> fatalErrorsFiles;
  private String warnings_HTML;
  private String errors_HTML;
  private String fatalErrors_HTML;

  //CONSTRUCTOR
  public BeanP02() {
    this.warnings_HTML = "";
    this.errors_HTML = "";
    this.fatalErrors_HTML = "";
  }

  //GETTERS
  public String getPphase() {
    return this.pphase;
  }

  public String getPassword() {
    return this.password;
  }

  public ArrayList<WarningFile> getArrayWarnings() {
    return this.warningsFiles;
  }

  public ArrayList<ErrorFile> getArrayErrors() {
    return this.errorsFiles;
  }

  public ArrayList<FatalErrorFile> getArrayFatalErrors() {
    return this.fatalErrorsFiles;
  }

  public String getHTML_warnigs() {
    for (int i = 0; i < warningsFiles.size(); i++){
      this.warnings_HTML += "<li type=\"disc\">" + warningsFiles.get(i).getWarningID() + "</li>";
      for (int j = 0; j < warningsFiles.get(i).getWarnings().size(); j++){
        this.warnings_HTML += "<ol><li type=\"circle\">" + warningsFiles.get(i).getWarnings().get(j) + "</li></ol>";
      }
    }
    return this.warnings_HTML;
  }

  public String getHTML_errors() {
    for (int i = 0; i < errorsFiles.size(); i++){
      this.errors_HTML += "<li type=\"disc\">" + errorsFiles.get(i).getErrorID() + "</li>";
      for (int j = 0; j < errorsFiles.get(i).getErrors().size(); j++){
        this.errors_HTML += "<ol><li type=\"circle\">" + errorsFiles.get(i).getErrors().get(j) + "</li></ol>";
      }
    }
    return this.errors_HTML;
  }

  public String getHTML_fatalErrors() {
    for (int i = 0; i < fatalErrorsFiles.size(); i++){
      this.fatalErrors_HTML += "<li type=\"disc\">" + fatalErrorsFiles.get(i).getFatalErrorID() + "</li>";
      for (int j = 0; j < fatalErrorsFiles.get(i).getFatalErrors().size(); j++){
        this.fatalErrors_HTML += "<ol><li type=\"circle\">" + fatalErrorsFiles.get(i).getFatalErrors().get(j) + "</li></ol>";
      }
    }
    return this.fatalErrors_HTML;
  }

  //SETTERS
  public void setPphase(String pphase) {
    this.pphase = pphase;
    return;
  }

  public void setPassword(String passwd) {
    this.password = passwd;
    return;
  }

  public void setArrayWarnings(ArrayList<WarningFile> warnings) {
    this.warningsFiles = warnings;
    return;
  }

  public void setArrayErrors(ArrayList<ErrorFile> errors) {
    this.errorsFiles = errors;
    return;
  }

  public void setArrayFatalErrors(ArrayList<FatalErrorFile> fatalErrors) {
    this.fatalErrorsFiles = fatalErrors;
    return;
  }

}
