<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="p3.BeanP13"%>
<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="/sint101/p3/eaml.css">
    <meta charset="UTF-8">
    <jsp:useBean id="bean13" scope="session" class="p3.BeanP13" />
  </head>
  <body>
    <% BeanP13 jspBean13 = (BeanP13)request.getAttribute("bean13"); %>
    <header>
      <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
    </header>
    <section>
      <h2>Consulta 1: Fase 3 (Titulaci&oacute;n=<%= jspBean13.getPdegree() %>, Asignatura=<%= jspBean13.getPsubject() %>)</h2>
      <p>Este es el resultado:</p>
      <ol>
        <%= jspBean13.getHTML_students() %>
      </ol>
    </section>
    <section>
      <a href="?pphase=01&p=<%= jspBean13.getPassword() %>" class="button">
        <button class="homeButton">Inicio</button>
      </a>
      <a href="?pphase=12&pdegree=<%= jspBean13.getPdegree() %>&p=<%= jspBean13.getPassword() %>" class="button">
        <button class="backButton">Atr&aacute;s</button>
      </a>
    </section>
    <footer>
      <hr>
      <p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
