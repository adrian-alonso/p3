package p3;

import java.util.ArrayList;
import p3.Student;

public class BeanP13 {

  private String students_HTML;
  private String pphase;
  private String pdegree;
  private String psubject;
  private String password;
  private ArrayList<Student> students;

  //CONSTRUCTOR
  public BeanP13() {
    this.students_HTML = "";
  }

  //GETTERS
  public String getHTML_students() {
    for (int i = 0; i < students.size(); i++) {
      this.students_HTML +="<li>" + students.get(i).toString() + "</li>";
    }
    return this.students_HTML;
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
  public void setArrayStudents(ArrayList<Student> students) {
    this.students = students;
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
