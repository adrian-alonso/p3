<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="p3.BeanP12"%>
<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="/sint101/p3/eaml.css">
    <meta charset="UTF-8">
    <jsp:useBean id="bean12" scope="session" class="p3.BeanP12" />
  </head>
  <body>
    <% BeanP12 jspBean12 = (BeanP12)request.getAttribute("bean12"); %>
    <header>
      <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
    </header>
    <section>
      <h2>Consulta 1: Fase 2 (Titulaci&oacute;n=<%= jspBean12.getPdegree() %>)</h2>
      <p>Selecciona una asignatura:</p>
      <ol>
        <%= jspBean12.getHTML_subjects() %>
      </ol>
    </section>
    <section>
      <a href="?pphase=01&p=<%= jspBean12.getPassword() %>" class="button">
        <button class="homeButton">Inicio</button>
      </a>
      <a href="?pphase=11&p=<%= jspBean12.getPassword() %>" class="button">
        <button class="backButton">Atr&aacute;s</button>
      </a>
    </section>
    <footer>
      <hr>
      <p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
