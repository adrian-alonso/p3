package p3;

import java.util.ArrayList;
import p3.Student;

public class BeanP13 {

  private String pphase;
  private String pdegree;
  private String psubject;
  private String password;
  private ArrayList<Student> students;
  private String students_HTML;

  //CONSTRUCTOR
  public BeanP13() {
    this.students_HTML = "";
  }

  //GETTERS
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

  public ArrayList<Student> getStudents() {
    return this.students;
  }

  public String getStudents_HTML() {
    return this.students_HTML;
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

  public void setPsubject(String psubject) {
    this.psubject = psubject;
    return;
  }

  public void setPassword(String passwd) {
    this.password = passwd;
    return;
  }

  public void setStudents(ArrayList<Student> students) {
    this.students = students;
    this.setStudents_HTML();
    return;
  }

  public void setStudents_HTML() {
    for (int i = 0; i < students.size(); i++) {
      this.students_HTML +="<li>" + students.get(i).toString() + "</li>";
    }
    return;
  }

}
