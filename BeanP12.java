package p3;

import java.util.ArrayList;
import p3.Subject;

public class BeanP11 {

  String subjects_HTML;
  String pphase;
  String pdegree;
  String password;
  ArrayList<Subject> subjects;

  //CONSTRUCTOR
  public BeanP11() {
    this.subjects_HTML = "";
  }

  //GETTERS
  public String getHTML_Subjects() {
    String imprimir1;
    String imprimir2;
    String imprimir3;
    for (int i = 0; i < subjects.size(); i++) {
      imprimir1 = "Asignatura = \'" + subjects.get(i).getSubjectName() + "\'";
      imprimir2 = "href=\"?pphase=13&p=" + password + "&pdegree=" + pdegree + "&psubject=" + subjects.get(i).getSubjectName() + "\"";
      imprimir3 = "<a " + imprimir2 + ">" + imprimir1 + "</a>";
      this.subjects_HTML += "<li>" imprimir3 " " + subjects.get(i).toString() + "</li>\n";
    }

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

  public String getPassword() {
    return this.password;
  }

  //SETTERS
  public void setArraySubjects(ArrayList<Subject> subjects) {
    this.subjects = subjects;
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

  public void setPassword(String passwd) {
    this.password = passwd;
    return;
  }

}
