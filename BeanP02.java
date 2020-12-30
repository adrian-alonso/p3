package p3;

import java.util.ArrayList;
import p3.WarningFile;
import p3.ErrorFile;
import p3.FatalErrorFile;

public class BeanP02 {

  private String pphase;
  private String password;
  private ArrayList<WarningFile> warnings;
  private ArrayList<ErrorFile> errors;
  private ArrayList<FatalErrorFile> fatalErrors;
  private String warnings_HTML;
  private String errors_HTML;
  private String fatalErrors_HTML;
  private int warningsSize;
  private int errorsSize;
  private int fatalErrorsSize;

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

  public ArrayList<WarningFile> getWarnings() {
    return this.warnings;
  }

  public ArrayList<ErrorFile> getErrors() {
    return this.errors;
  }

  public ArrayList<FatalErrorFile> getFatalErrors() {
    return this.fatalErrors;
  }

  public String getWarnings_HTML() {
    return this.warnings_HTML;
  }

  public String getErrors_HTML() {
    return this.errors_HTML;
  }

  public String getFatalErrors_HTML() {
    return this.fatalErrors_HTML;
  }

  public int getWarningsSize() {
    return this.warningsSize;
  }

  public int getErrorsSize() {
    return this.errorsSize;
  }

  public int getFatalErrorsSize() {
    return this.fatalErrorsSize;
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

  public void setWarnings(ArrayList<WarningFile> warnings) {
    this.warnings = warnings;
    this.setWarnings_HTML();
    return;
  }

  public void setErrors(ArrayList<ErrorFile> errors) {
    this.errors = errors;
    this.setErrors_HTML();
    return;
  }

  public void setFatalErrors(ArrayList<FatalErrorFile> fatalErrors) {
    this.fatalErrors = fatalErrors;
    this.setFatalErrors_HTML();
    return;
  }

  public void setWarnings_HTML() {
    for (int i = 0; i < warnings.size(); i++){
      this.warnings_HTML += "<li type=\"disc\">" + warnings.get(i).getWarningID() + "</li>";
      for (int j = 0; j < warnings.get(i).getWarnings().size(); j++){
        this.warnings_HTML += "<ol><li type=\"circle\">" + warnings.get(i).getWarnings().get(j) + "</li></ol>";
      }
    }
    this.setWarningsSize();
    return;
  }

  public void setErrors_HTML() {
    for (int i = 0; i < errors.size(); i++){
      this.errors_HTML += "<li type=\"disc\">" + errors.get(i).getErrorID() + "</li>";
      for (int j = 0; j < errors.get(i).getErrors().size(); j++){
        this.errors_HTML += "<ol><li type=\"circle\">" + errors.get(i).getErrors().get(j) + "</li></ol>";
      }
    }
    this.setErrorsSize();
    return;
  }

  public void setFatalErrors_HTML() {
    for (int i = 0; i < fatalErrors.size(); i++){
      this.fatalErrors_HTML += "<li type=\"disc\">" + fatalErrors.get(i).getFatalErrorID() + "</li>";
      for (int j = 0; j < fatalErrors.get(i).getFatalErrors().size(); j++){
        this.fatalErrors_HTML += "<ol><li type=\"circle\">" + fatalErrors.get(i).getFatalErrors().get(j) + "</li></ol>";
      }
    }
    this.setFatalErrorsSize();
    return;
  }

  public void setWarningsSize() {
    this.warningsSize = warnings.size();
    return;
  }

  public void setErrorsSize() {
    this.errorsSize = errors.size();
    return;
  }

  public void setFatalErrorsSize() {
    this.fatalErrorsSize = fatalErrors.size();
    return;
  }

}
