package p3;

import java.util.ArrayList;

public class BeanP11 {

  private String pphase;
  private String password;
  private ArrayList<String> degrees;
  private String degrees_HTML;

  //CONSTRUCTOR
  public BeanP11() {
    this.degrees_HTML = "";
  }

  //GETTERS
  public String getPphase() {
    return this.pphase;
  }

  public String getPassword() {
    return this.password;
  }

  public ArrayList<String> getDegrees() {
    return this.degrees;
  }

  public String getDegrees_HTML() {
    return this.degrees_HTML;
  }

  //SETTERS
  public void setPphase(String pphase) {
    this.pphase = pphase;
    return;
  }

  public void setPassword(String password) {
    this.password = password;
    return;
  }

  public void setDegrees(ArrayList<String> degrees) {
    this.degrees = degrees;
    this.setDegrees_HTML();
    return;
  }

  public void setDegrees_HTML() {
    for (int i = 0; i < degrees.size(); i++) {
      this.degrees_HTML += "<li><a href=\"?pphase=12&p=" + password + "&pdegree=" + degrees.get(i) + "\">" + degrees.get(i) + "</a></li>";
    }
    return;
  }

}
