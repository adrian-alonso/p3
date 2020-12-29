package p3;

import java.util.ArrayList;
import p3.Subject;

public class BeanP12 {

  private String pphase;
  private String pdegree;
  private String password;
  private ArrayList<Subject> subjects;
  private String subjects_HTML;

  //CONSTRUCTOR
  public BeanP12() {
    this.subjects_HTML = "";
  }

  //GETTERS
  public String getPphase() {
    return this.pphase;
  }

  public String getPdegree() {
    return this.pdegree;
  }

  public String getPassword() {
    return this.password;
  }

  public ArrayList<Subject> getSubjects() {
    return this.subjects;
  }

  public String getSubjects_HTML() {
    return this.subjects_HTML;
  }

  //SETTERS
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

  public void setSubjects(ArrayList<Subject> subjects) {
    this.subjects = subjects;
    return;
  }

  public void setSubjects_HTML() {
    String print1;
    String print2;
    String print3;
    for (int i = 0; i < subjects.size(); i++) {
      print1 = "Asignatura = \'" + subjects.get(i).getSubjectName() + "\'";
      print2 = "href=\"?pphase=13&p=" + password + "&pdegree=" + pdegree + "&psubject=" + subjects.get(i).getSubjectName() + "\"";
      print3 = "<a " + print2 + ">" + print1 + "</a>";
      this.subjects_HTML += "<li>" + print3 + " " + subjects.get(i).toString() + "</li>\n";
    }
    return;
  }


}
