package p3;

import java.io.*;
import java.nio.charset.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.net.URLEncoder;
import java.util.HashMap;
import org.w3c.dom.Document;
//Practica 3
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerConfigurationException;
import p3.BeanP01;
import p3.BeanP02;
import p3.BeanP11;
import p3.BeanP12;
import p3.BeanP13;

public class FrontEnd {

  //CONSTRUCTOR
  public FrontEnd() {
  }

  //FASE 01
  //Seleccion modo pantalla (auto/browser)
  public void phase01 (HttpServletRequest request, HttpServletResponse response, String pphase, BeanP01 bean01, ServletContext sc) throws IOException, ServletException {
    String auto = request.getParameter("auto");

    if(auto==null){
      this.page01JSP(request, response, pphase, bean01, sc);
    } else if (!auto.equals("true")) {
      this.page01JSP(request, response, pphase, bean01, sc);
    } else {
      this.page01XML(request, response, pphase);
    }
  }

  //HTML DE LA PAGINA
  public void page01HTML(HttpServletRequest request, HttpServletResponse response, String pphase) throws IOException, ServletException {
    String password = request.getParameter("p");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>P3EA</title>");
    out.println("<link rel=\"stylesheet\" href=\"/sint101/p3/eaml.css\">");
    out.println("<meta charset=\"UTF-8\"> ");
    out.println("</head>");
    out.println("<body>");
    out.println("<header>");
    out.println("<h1>Servicio de consulta de expedientes acad&eacutemicos</h1>");
    out.println("</header>");
    out.println("<section>");
    out.println("<h2><a href=\"\">Bienvenido a este servicio</a></h2>");
    out.println("<form name=\"form\" method=\"get\" >");
    out.println("<a href=\"?pphase=02&p=" + password + "\">Ver los ficheros err&oacuteneos</a>");
    out.println("<input type=\"hidden\" id=\"pphase\" name=\"pphase\" value=\"02\">");
    out.println("</form>");
    out.println("</section>");
    out.println("<section>");
    out.println("<h3>Selecciona una consulta:</h3>");
    out.println("<ul>");
    out.println("<li type=\"disc\"><a href=\"?pphase=11&p=" + password + "\">Consulta 1: Ver los alumnos de una asignatura de una titulaci&oacute;n</a></li><br>");
    out.println("<li type=\"disc\"><a href=\"?pphase=21&p=" + password + "\">Consulta 2: Ver informaci&oacute;n de una titulaci&oacute;n</a></li><br>");
    out.println("</section>");
    out.println("<footer>");
    out.println("<hr>");
    out.println("<p>&copy; Adri&aacuten Alonso Vilar (2020-2021)</p>");
    out.println("</footer>");
    out.println("</body>");
    out.println("</html>");
  }

  //MODO AUTO: PRESENTACION EN XML
  public void page01XML(HttpServletRequest request, HttpServletResponse response, String pphase) throws IOException, ServletException {
    response.setContentType("text/xml");
    PrintWriter out = response.getWriter();

    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<service>");
    out.println("<status>OK</status>");
    out.println("</service>");
  }

  //FASE 02
  //Seleccion modo pantalla (auto/browser)
  public void phase02 (HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<WarningFile> warningsFiles, ArrayList<ErrorFile> errorsFiles, ArrayList<FatalErrorFile> fatalErrorsFiles, BeanP02 bean02, ServletContext sc) throws IOException, ServletException {
    String auto = request.getParameter("auto");

    if(auto==null){
      this.page02JSP(request, response, pphase, warningsFiles, errorsFiles, fatalErrorsFiles, bean02, sc);
    } else if (!auto.equals("true")) {
      this.page02JSP(request, response, pphase, warningsFiles, errorsFiles, fatalErrorsFiles, bean02, sc);
    } else {
      this.page02XML(request, response, pphase, warningsFiles, errorsFiles, fatalErrorsFiles);
    }
  }

  //HTML DE LA PAGINA
  public void page02HTML(HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<WarningFile> warningsFiles, ArrayList<ErrorFile> errorsFiles, ArrayList<FatalErrorFile> fatalErrorsFiles) throws IOException, ServletException {
    String password = request.getParameter("p");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>P3EA</title>");
    out.println("<link rel=\"stylesheet\" href=\"/sint101/p3/eaml.css\">");
    out.println("<meta charset=\"UTF-8\"> ");
    out.println("</head>");
    out.println("<body>");
    out.println("<header>");
    out.println("<h1>Servicio de consulta de expedientes acad&eacutemicos</h1>");
    out.println("</header>");
    out.println("<section>");
    out.println("<h2>Se han encontrado " + warningsFiles.size() + " ficheros con warnings:</h2>");
    out.println("<ul>");
    for (int i = 0; i < warningsFiles.size(); i++){
      out.println("<li type=\"disc\">" + warningsFiles.get(i).getWarningID() + "</li>");
      for (int j = 0; j < warningsFiles.get(i).getWarnings().size(); j++){
        out.println("<ol><li type=\"circle\">" + warningsFiles.get(i).getWarnings().get(j) + "</li></ol>");
      }
    }
    out.println("</ul>");
    out.println("<h2>Se han encontrado " + errorsFiles.size() + " ficheros con errores:</h2>");
    out.println("<ul>");
    for (int i = 0; i < errorsFiles.size(); i++){
      out.println("<li type=\"disc\">" + errorsFiles.get(i).getErrorID() + "</li>");
      for (int j = 0; j < errorsFiles.get(i).getErrors().size(); j++){
        out.println("<ol><li type=\"circle\">" + errorsFiles.get(i).getErrors().get(j) + "</li></ol>");
      }
    }
    out.println("</ul>");
    out.println("<h2>Se han encontrado " + fatalErrorsFiles.size() + " ficheros con errores fatales:</h2>");
    out.println("<ul>");
    for (int i = 0; i < fatalErrorsFiles.size(); i++){
      out.println("<li type=\"disc\">" + fatalErrorsFiles.get(i).getFatalErrorID() + "</li>");
      for (int j = 0; j < fatalErrorsFiles.get(i).getFatalErrors().size(); j++){
        out.println("<ol><li type=\"circle\">" + fatalErrorsFiles.get(i).getFatalErrors().get(j) + "</li></ol>");
      }
    }
    out.println("</ul>");
    out.println("</section>");
    out.println("<section>");
    out.println("<a href=\"?pphase=01&p=" + password + "\" class=\"button\"><button class=\"backButton\">Atr&aacute;s</button></a>");
    out.println("</section>");
    out.println("<footer>");
    out.println("<hr>");
    out.println("<p>&copy; Adri&aacuten Alonso Vilar (2020-2021)</p>");
    out.println("</footer>");
    out.println("</body>");
    out.println("</html>");
  }

  //MODO AUTO: PRESENTACION EN XML
  public void page02XML(HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<WarningFile> warningsFiles, ArrayList<ErrorFile> errorsFiles, ArrayList<FatalErrorFile> fatalErrorsFiles) throws IOException, ServletException {
    response.setContentType("text/xml");
    PrintWriter out = response.getWriter();

    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<wrongDocs>");
    out.println("<warnings>");
    for (int i = 0; i < warningsFiles.size(); i++){
      out.println("<warning>");
      out.println("<file>" + warningsFiles.get(i).getWarningID() + "</file>");
      out.print("<cause>");
      for (int j = 0; j < warningsFiles.get(i).getWarnings().size(); j++){
        out.print(this.HTMLreplace(warningsFiles.get(i).getWarnings().get(0)));
      }
      out.println("</cause>");
      out.println("</warning>");
    }
    out.println("</warnings>");
    out.println("<errors>");
    for (int i = 0; i < errorsFiles.size(); i++){
      out.println("<error>");
      out.println("<file>" + errorsFiles.get(i).getErrorID() + "</file>");
      out.print("<cause>");
      for (int j = 0; j < errorsFiles.get(i).getErrors().size(); j++){
        out.print(this.HTMLreplace(errorsFiles.get(i).getErrors().get(0)));
      }
      out.println("</cause>");
      out.println("</error>");
    }
    out.println("</errors>");
    out.println("<fatalerrors>");
    for (int i = 0; i < fatalErrorsFiles.size(); i++){
      out.println("<fatalerror>");
      out.println("<file>" + fatalErrorsFiles.get(i).getFatalErrorID() + "</file>");
      out.print("<cause>");
      for (int j = 0; j < fatalErrorsFiles.get(i).getFatalErrors().size(); j++){
        out.print(this.HTMLreplace(fatalErrorsFiles.get(i).getFatalErrors().get(0)));
      }
      out.println("</cause>");
      out.println("</fatalerror>");
    }
    out.println("</fatalerrors>");
    out.println("</wrongDocs>");

  }

  //FASE 11
  //Seleccion modo pantalla (auto/browser)
  public void phase11 (HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<String> degrees, BeanP11 bean11, ServletContext servletcontext) throws IOException, ServletException {
    String auto = request.getParameter("auto");

    if(auto==null){
      this.page11JSP(request, response, pphase, degrees, bean11, servletcontext);
    } else if (!auto.equals("true")) {
      this.page11JSP(request, response, pphase, degrees, bean11, servletcontext);
    } else {
      this.page11XML(request, response, pphase, degrees);
    }
  }

  //HTML DE LA PAGINA
  public void page11HTML(HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<String> degrees) throws IOException, ServletException {
    String password = request.getParameter("p");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>P3EA</title>");
    out.println("<link rel=\"stylesheet\" href=\"/sint101/p3/eaml.css\">");
    out.println("<meta charset=\"UTF-8\"> ");
    out.println("</head>");
    out.println("<body>");
    out.println("<header>");
    out.println("<h1>Servicio de consulta de expedientes acad&eacutemicos</h1>");
    out.println("</header>");
    out.println("<section>");
    out.println("<h2>Consulta 1: Fase 1</h2>");
    out.println("<p>Selecciona :</p>");
    out.println("<ol>");
    for (int i = 0; i < degrees.size(); i++) {
      out.println("<li><a href=\"?pphase=12&p=" + password + "&pdegree=" + degrees.get(i) + "\">" + degrees.get(i) + "</a></li>");
    }
    out.println("</ol>");
    out.println("</section>");
    out.println("<section>");
    out.println("<a href=\"?pphase=01&p=" + password + "\" class=\"button\"><button class=\"homeButton\">Inicio</button></a>");
    out.println("</section>");
    out.println("<footer>");
    out.println("<hr>");
    out.println("<p>&copy; Adri&aacuten Alonso Vilar (2020-2021)</p>");
    out.println("</footer>");
    out.println("</body>");
    out.println("</html>");
  }

  //MODO AUTO: PRESENTACION EN XML
  public void page11XML(HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<String> degrees) throws IOException, ServletException {
    response.setContentType("text/xml");
    PrintWriter out = response.getWriter();
    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<degrees>");
    for (int i=0; i<degrees.size(); i++){
      out.println("<degree>" + degrees.get(i) + "</degree>");
    }
    out.println("</degrees>");
  }

  //FASE 12
  //Seleccion modo pantalla (auto/browser)
  public void phase12 (HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, ArrayList<Subject> subjects, BeanP12 bean12, ServletContext sc) throws IOException, ServletException {
    String auto = request.getParameter("auto");

    if (pdegree == null) {
      if(auto==null){
        this.noParamHTML(request, response, "pdegree");
      } else if (!auto.equals("true")) {
        this.noParamHTML(request, response, "pdegree");
      } else {
        this.noParamXML(request, response, "pdegree");
      }
    } else {
      if(auto==null){
        this.page12JSP(request, response, pphase, pdegree, subjects, bean12, sc);
      } else if (!auto.equals("true")) {
        this.page12JSP(request, response, pphase, pdegree, subjects, bean12, sc);
      } else {
        this.page12XML(request, response, pphase, pdegree, subjects);
      }
    }
  }

  //HTML DE LA PAGINA
  public void page12HTML(HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, ArrayList<Subject> subjects) throws IOException, ServletException {
    String password = request.getParameter("p");
    String imprimir;

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>P3EA</title>");
    out.println("<link rel=\"stylesheet\" href=\"/sint101/p3/eaml.css\">");
    out.println("<meta charset=\"UTF-8\">");
    out.println("</head>");
    out.println("<body>");
    out.println("<header>");
    out.println("<h1>Servicio de consulta de expedientes acad&eacutemicos</h1>");
    out.println("</header>");
    out.println("<section>");
    out.println("<h2>Consulta 1: Fase 2 (Titulaci&oacuten=" + pdegree + ")</h2>");
    out.println("<p>Selecciona una asignatura:</p>");
    out.println("<ol>");
    for (int i = 0; i < subjects.size(); i++) {
      imprimir = "Asignatura = \'" + subjects.get(i).getSubjectName() + "\'";
      out.print("<li><a href=\"?pphase=13&p=" + password + "&pdegree=" + pdegree + "&psubject=" + subjects.get(i).getSubjectName() + "\">" + imprimir + "</a>");
      out.println(" " + subjects.get(i).toString() + "</li>");
    }
    out.println("</ol>");
    out.println("</section>");
    out.println("<section>");
    out.println("<a href=\"?pphase=01&p=" + password + "\" class=\"button\"><button class=\"homeButton\">Inicio</button></a>");
    out.println("<a href=\"?pphase=11&p=" + password + "\" class=\"button\"><button class=\"backButton\">Atr&aacute;s</button></a>");
    out.println("</section>");
    out.println("<footer>");
    out.println("<hr>");
    out.println("<p>&copy; Adri&aacuten Alonso Vilar (2020-2021)</p>");
    out.println("</footer>");
    out.println("</body>");
    out.println("</html>");
  }

  //MODO AUTO: PRESENTACION EN XML
  public void page12XML(HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, ArrayList<Subject> subjects) throws IOException, ServletException {
    response.setContentType("text/xml");
    PrintWriter out = response.getWriter();

    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<subjects>");
    for (int i=0; i<subjects.size(); i++){
      out.println("<subject course=\"" + subjects.get(i).getCourse() + "\" type=\"" + subjects.get(i).getType() + "\">" + subjects.get(i).getSubjectName() + "</subject>");
    }
    out.println("</subjects>");
  }

  //FASE 13
  //Seleccion modo pantalla (auto/browser)
  public void phase13 (HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, String psubject, ArrayList<Student> students, BeanP13 bean13, ServletContext sc) throws IOException, ServletException {
    String auto = request.getParameter("auto");
    if (pdegree == null) {
      if(auto==null){
        this.noParamHTML(request, response, "pdegree");
      } else if (!auto.equals("true")) {
        this.noParamHTML(request, response, "pdegree");
      } else {
        this.noParamXML(request, response, "pdegree");
      }
    } else {
      if (psubject == null){
        if(auto==null){
          this.noParamHTML(request, response, "psubject");
        } else if (!auto.equals("true")) {
          this.noParamHTML(request, response, "psubject");
        } else {
          this.noParamXML(request, response, "psubject");
        }
      } else {
        if(auto==null){
          this.page13JSP(request, response, pphase, pdegree, psubject, students, bean13, sc);
        } else if (!auto.equals("true")) {
          this.page13JSP(request, response, pphase, pdegree, psubject, students, bean13, sc);
        } else {
          this.page13XML(request, response, pphase, pdegree, psubject, students);
        }
      }
    }
  }

  //HTML DE LA PAGINA
  public void page13HTML(HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, String psubject, ArrayList<Student> students) throws IOException, ServletException {
    String password = request.getParameter("p");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>P3EA</title>");
    out.println("<link rel=\"stylesheet\" href=\"/sint101/p3/eaml.css\">");
    out.println("<meta charset=\"UTF-8\">");
    out.println("</head>");
    out.println("<body>");
    out.println("<header>");
    out.println("<h1>Servicio de consulta de expedientes acad&eacute;micos</h1>");
    out.println("</header>");
    out.println("<section>");
    out.println("<h2>Consulta 1: Fase 3 (Titulaci&oacute;n=" + pdegree + ", Asignatura=" + psubject + ")</h2>");
    out.println("<p>Este es el resultado:</p>");
    out.println("<ol>");
    for (int i = 0; i < students.size(); i++) {
      out.println("<li>" + students.get(i).toString() + "</li>");
    }
    out.println("</ol>");
    out.println("</section>");
    out.println("<section>");
    out.println("<a href=\"?pphase=01&p=" + password + "\" class=\"button\"><button class=\"homeButton\">Inicio</button></a>");
    out.println("<a href=\"?pphase=12&pdegree=" + pdegree + "&p=" + password + "\" class=\"button\"><button class=\"backButton\">Atr&aacute;s</button></a>");
    out.println("</section>");
    out.println("<footer>");
    out.println("<hr>");
    out.println("<p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>");
    out.println("</footer>");
    out.println("</body>");
    out.println("</html>");
  }

  //MODO AUTO: PRESENTACION EN XML
  public void page13XML(HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, String psubject, ArrayList<Student> students) throws IOException, ServletException {
    response.setContentType("text/xml");
    PrintWriter out = response.getWriter();

    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<students>");
    for (int i=0; i<students.size(); i++){
      out.println("<student id=\"" + students.get(i).getId() + "\" address=\"" + students.get(i).getAddress() + "\">" + students.get(i).getStudentName() + "</student>");
    }
    out.println("</students>");
  }

  //FASE 21 - PRACTICA 3 (XSLT)
  public void phase21 (HttpServletRequest request, HttpServletResponse response, String pphase, HashMap<String, String> urlsMap) throws IOException, ServletException {
    String password = request.getParameter("p");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>P3EA</title>");
    out.println("<link rel=\"stylesheet\" href=\"/sint101/p3/eaml.css\">");
    out.println("<meta charset=\"UTF-8\">");
    out.println("</head>");
    out.println("<body>");
    out.println("<header>");
    out.println("<h1>Servicio de consulta de expedientes acad&eacute;micos</h1>");
    out.println("</header>");
    out.println("<section>");
    out.println("<h2>Consulta 2: Seleccione titulaci&oacute;n a consutar</h2>");
    out.println("<ol>");
    for (String degree : urlsMap.keySet()) {
      out.println("<li><a href=\"?pphase=22&p=" + password + "&pdegree=" + degree + "\">" + degree + "</li>");
    }
    out.println("</ol>");
    out.println("</section>");
    out.println("<section>");
    out.println("<a href=\"?pphase=01&p=" + password + "\" class=\"button\"><button class=\"homeButton\">Inicio</button></a>");
    out.println("</section>");
    out.println("<footer>");
    out.println("<hr>");
    out.println("<p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>");
    out.println("</footer>");
    out.println("</body>");
    out.println("</html>");
  }

  //FASE 22 - PRACTICA 3 (XSLT)
  public void phase22 (HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, HashMap<String, String> urlsMap, File stylesheet, File html_output) throws IOException, ServletException {
    String password = request.getParameter("p");
    String url = urlsMap.get(pdegree);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
            File datafile = new File(url);

            //Usamos un Transformer para el output
            TransformerFactory tFactory = TransformerFactory.newInstance();
            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = tFactory.newTransformer(stylesource);

            //Creamos un StreamSource para el xml
            StreamSource datasource = new StreamSource(datafile);

            //Resultado del Transformer
            StreamResult result = new StreamResult(out);
            transformer.transform(datasource, result);

    } catch (Exception e) {
    }
  }

  //JSP
  //FASE01
  public void page01JSP(HttpServletRequest request, HttpServletResponse response, String pphase, BeanP01 bean01, ServletContext sc) {
    String password = request.getParameter("p");

    try {
      bean01 = new BeanP01();
      bean01.setPphase(pphase);
      bean01.setPassword(password);
      request.setAttribute("bean01", bean01);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/page01.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  //FASE02
  public void page02JSP(HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<WarningFile> warningsFiles, ArrayList<ErrorFile> errorsFiles, ArrayList<FatalErrorFile> fatalErrorsFiles, BeanP02 bean02, ServletContext sc) {
    String password = request.getParameter("p");

    try {
      bean02 = new BeanP02();
      bean02.setArrayWarnings(warningsFiles);
      bean02.setArrayErrors(errorsFiles);
      bean02.setArrayFatalErrors(fatalErrorsFiles);
      bean02.setPphase(pphase);
      bean02.setPassword(password);
      request.setAttribute("bean02", bean02);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/page02.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  //FASE11
  public void page11JSP(HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<String> degrees, BeanP11 bean11, ServletContext sc) {
    String password = request.getParameter("p");

    try {
      bean11 = new BeanP11();
      bean11.setArrayDegrees(degrees);
      bean11.setPphase(pphase);
      bean11.setPassword(password);
      request.setAttribute("bean11", bean11);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/page11.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  //FASE12
  public void page12JSP(HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, ArrayList<Subject> subjects, BeanP12 bean12, ServletContext sc) {
    String password = request.getParameter("p");

    try {
      bean12 = new BeanP12();
      bean12.setArraySubjects(subjects);
      bean12.setPphase(pphase);
      bean12.setPdegree(pdegree);
      bean12.setPassword(password);
      request.setAttribute("bean12", bean12);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/page12.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  //FASE13
  public void page13JSP(HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, String psubject, ArrayList<Student> students, BeanP13 bean13, ServletContext sc) {
    String password = request.getParameter("p");

    try {
      bean13 = new BeanP13();
      bean13.setArrayStudents(students);
      bean13.setPphase(pphase);
      bean13.setPdegree(pdegree);
      bean13.setPsubject(psubject);
      bean13.setPassword(password);
      request.setAttribute("bean13", bean13);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/page13.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
      System.out.println(e);
    }
  }


  //ERRORES

  //Falta contraseña
  //HTML DE LA PAGINA
  public void noPasswordHTML(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>P3EA</title>");
    out.println("<link rel=\"stylesheet\" href=\"/sint101/p3/eaml.css\">");
    out.println("<meta charset=\"UTF-8\">");
    out.println("</head>");
    out.println("<body>");
    out.println("<header>");
    out.println("<h1>Servicio de consulta de expedientes acad&eacutemicos</h1>");
    out.println("</header>");
    out.println("<section>");
    out.println("<p>Wrong Request: no passwd</p>");
    out.println("<p>Intruduzca el par&aacute;metro p con la correspondiente contrase&ntilde;a.</p>");
    out.println("</section>");
    out.println("<footer>");
    out.println("<hr>");
    out.println("<p>&copy; Adri&aacuten Alonso Vilar (2020-2021)</p>");
    out.println("</footer>");
    out.println("</body>");
    out.println("</html>");
  }

  //MODO AUTO: PRESENTACION EN XML
  public void noPasswordXML(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/xml");
    PrintWriter out = response.getWriter();

    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<wrongRequest>no passwd</wrongRequest>");
  }

  //Contraseña erronea
  //HTML DE LA PAGINA
  public void badPasswordHTML(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>P3EA</title>");
    out.println("<link rel=\"stylesheet\" href=\"/sint101/p3/eaml.css\">");
    out.println("<meta charset=\"UTF-8\">");
    out.println("</head>");
    out.println("<body>");
    out.println("<header>");
    out.println("<h1>Servicio de consulta de expedientes acad&eacutemicos</h1>");
    out.println("</header>");
    out.println("<section>");
    out.println("<p>Wrong Request: bad passwd</p>");
    out.println("<p>Contrase&ntilde;a incorrecta. Intruduzca el par&aacute;metro p correcto.</p>");
    out.println("</section>");
    out.println("<footer>");
    out.println("<hr>");
    out.println("<p>&copy; Adri&aacuten Alonso Vilar (2020-2021)</p>");
    out.println("</footer>");
    out.println("</body>");
    out.println("</html>");
  }

  //MODO AUTO: PRESENTACION EN XML
  public void badPasswordXML(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/xml");
    PrintWriter out = response.getWriter();

    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<wrongRequest>bad passwd</wrongRequest>");
  }

  //Falta parametro obligatorio (pdegree/psubject)
  //HTML DE LA PAGINA
  public void noParamHTML(HttpServletRequest request, HttpServletResponse response, String param) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>P3EA</title>");
    out.println("<link rel=\"stylesheet\" href=\"/sint101/p3/eaml.css\">");
    out.println("<meta charset=\"UTF-8\">");
    out.println("</head>");
    out.println("<body>");
    out.println("<header>");
    out.println("<h1>Servicio de consulta de expedientes acad&eacutemicos</h1>");
    out.println("</header>");
    out.println("<section>");
    out.println("<p>Wrong Request: no param:" + param + "</p>");
    out.println("<p>Par&aacute;metro " + param + " necesario. Introduzca su valor.</p>");
    out.println("</section>");
    out.println("<footer>");
    out.println("<hr>");
    out.println("<p>&copy; Adri&aacuten Alonso Vilar (2020-2021)</p>");
    out.println("</footer>");
    out.println("</body>");
    out.println("</html>");
  }

  //MODO AUTO: PRESENTACION EN XML
  public void noParamXML(HttpServletRequest request, HttpServletResponse response, String param) throws IOException, ServletException {
    String pdegree = request.getParameter("pdegree");
    String psubject = request.getParameter("psubject");

    response.setContentType("text/xml");
    PrintWriter out = response.getWriter();

    out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    out.println("<wrongRequest>no param:" + param + "</wrongRequest>");
  }

  public String HTMLreplace (String sentence) {
    String html_sentence = sentence;
    html_sentence = html_sentence.replace("&", "&amp;");
    html_sentence = html_sentence.replace("<", "&lt;");
    html_sentence = html_sentence.replace(">", "&gt;");
    html_sentence = html_sentence.replace("\"", "&quot;");
    return html_sentence;
  }
}
