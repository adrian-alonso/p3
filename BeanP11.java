package p3;

import java.util.ArrayList;

public class BeanP11 {

  String degrees_HTML;
  String pphase;
  String password;
  ArrayList<String> degrees;

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

  public void setPassword(String passwd) {
    this.password = passwd;
    return;
  }

}
