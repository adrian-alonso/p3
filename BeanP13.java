package p3;

import java.util.ArrayList;
import p3.Student;

public class BeanP11 {

  String degrees_HTML;
  String pphase;
  String pdegree;
  String psubject;
  String password;
  ArrayList<Student> students;

  //CONSTRUCTOR
  public BeanP11() {
    this.degrees_HTML = "";
  }

  //GETTERS
  public String getHTML_degrees() {

    for (int i = 0; i < degrees.size(); i++) {
      this.degrees_HTML += "<li><a href=\"?pphase=12&p=" + password + "&pdegree=" + degrees.get(i) + "\">" + degrees.get(i) + "</a></li>";
    }
    return this.degrees_HTML;
  }

  public String getPphase() {
    return this.pphase;
  }

  public String getPdegree() {
    return this.pdegree;
  }

  public String getPsubject() {
    return this.psubject;
  }

  public String getPassword() {
    return this.password;
  }

  //SETTERS
  public void setArrayDegrees(ArrayList<String> degrees) {
    this.degrees = degrees;
    return;
  }

  public void setPphase(String pphase) {
    this.pphase = pphase;
    return;
  }

  public void setPdegree(String pdegree) {
    this.pdegree = pdegree;
    return;
  }

  public void setPsubject(String psubject) {
    this.psubject = psubject;
    return;
  }

  public void setPassword(String passwd) {
    this.password = passwd;
    return;
  }

}
