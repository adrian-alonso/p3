package p3;

public class BeanNoParam {

  private String pphase;
  private String pdegree;
  private String psubject;
  private String param;
  private String password;

  //CONSTRUCTOR
  public BeanNoParam() {
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

  public String getParam() {
    return this.param;
  }

  public String getPassword() {
    return this.password;
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

  public void setParam(String param) {
    this.param = param;
    return;
  }

  public void setPassword(String passwd) {
    this.password = passwd;
    return;
  }

}
