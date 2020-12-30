package p3;

import java.io.*;
import java.nio.charset.*;
import java.net.*;
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
import p3.BeanNoPassword;
import p3.BeanBadPassword;
import p3.BeanNoParam;

public class FrontEnd {

  //CONSTRUCTOR
  public FrontEnd() {
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
    }
  }

  //FASE02
  public void page02JSP(HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<WarningFile> warningsFiles, ArrayList<ErrorFile> errorsFiles, ArrayList<FatalErrorFile> fatalErrorsFiles, BeanP02 bean02, ServletContext sc) {
    String password = request.getParameter("p");

    try {
      bean02 = new BeanP02();
      bean02.setWarnings(warningsFiles);
      bean02.setErrors(errorsFiles);
      bean02.setFatalErrors(fatalErrorsFiles);
      bean02.setPphase(pphase);
      bean02.setPassword(password);
      request.setAttribute("bean02", bean02);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/page02.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
    }
  }

  //FASE11
  public void page11JSP(HttpServletRequest request, HttpServletResponse response, String pphase, ArrayList<String> degrees, BeanP11 bean11, ServletContext sc) {
    String password = request.getParameter("p");

    try {
      bean11 = new BeanP11();
      bean11.setPphase(pphase);
      bean11.setPassword(password);
      bean11.setDegrees(degrees);
      request.setAttribute("bean11", bean11);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/page11.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
    }
  }

  //FASE12
  public void page12JSP(HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, ArrayList<Subject> subjects, BeanP12 bean12, ServletContext sc) {
    String password = request.getParameter("p");

    try {
      bean12 = new BeanP12();
      bean12.setPphase(pphase);
      bean12.setPdegree(pdegree);
      bean12.setPassword(password);
      bean12.setSubjects(subjects);
      request.setAttribute("bean12", bean12);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/page12.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
    }
  }

  //FASE13
  public void page13JSP(HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, String psubject, ArrayList<Student> students, BeanP13 bean13, ServletContext sc) {
    String password = request.getParameter("p");

    try {
      bean13 = new BeanP13();
      bean13.setPphase(pphase);
      bean13.setPdegree(pdegree);
      bean13.setPsubject(psubject);
      bean13.setPassword(password);
      bean13.setStudents(students);
      request.setAttribute("bean13", bean13);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/page13.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
    }
  }

  //FASE 21 - XSLT
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

  //FASE 22 - XSLT
  public void phase22 (HttpServletRequest request, HttpServletResponse response, String pphase, String pdegree, HashMap<String, String> urlsMap, File stylesheet) throws IOException, ServletException {
    String password = request.getParameter("p");
    String url = urlsMap.get(pdegree);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
            // File datafile = new File(url); //LOCAL

            //Usamos un Transformer para el output
            TransformerFactory tFactory = TransformerFactory.newInstance();
            StreamSource stylesource = new StreamSource(stylesheet);
            Transformer transformer = tFactory.newTransformer(stylesource);

            //Creamos un StreamSource para el xml
            StreamSource datasource = new StreamSource(url);

            //Resultado del Transformer
            StreamResult result = new StreamResult(out);
            transformer.transform(datasource, result);

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  //ERRORES

  //Falta contraseña
  //HTML DE LA PAGINA
  public void noPasswordJSP(HttpServletRequest request, HttpServletResponse response, BeanNoPassword beanNoPass, ServletContext sc) throws IOException, ServletException {
    try {
      beanNoPass = new BeanNoPassword();
      //beanNoPass.setPassword(password);
      request.setAttribute("beanNoPass", beanNoPass);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/pageNoPass.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
    }
  }

  //Contraseña erronea
  //HTML DE LA PAGINA
  public void badPasswordJSP(HttpServletRequest request, HttpServletResponse response, BeanBadPassword beanBadPass, ServletContext sc) throws IOException, ServletException {
    try {
      beanBadPass = new BeanBadPassword();
      //beanBadPass.setPassword(password);
      request.setAttribute("beanBadPass", beanBadPass);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/pageBadPass.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
    }
  }

  //Falta parametro obligatorio (pdegree/psubject)
  //HTML DE LA PAGINA
  public void noParamJSP(HttpServletRequest request, HttpServletResponse response, String param, BeanNoParam beanNoParam, ServletContext sc) throws IOException, ServletException {
    try {
      beanNoParam = new BeanNoParam();
      //beanNoParam.setPphase(pphase);
      //beanNoParam.setPassword(password);
      beanNoParam.setParam(param);
      request.setAttribute("beanNoParam", beanNoParam);
      RequestDispatcher rd = sc.getRequestDispatcher("/p3/pageNoParam.jsp");
      rd.forward(request,response);
    } catch (Exception e) {
    }
  }

}
