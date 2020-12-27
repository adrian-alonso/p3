<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="p3.BeanP01"%>

<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="/sint101/p3/eaml.css"/>
    <meta charset="UTF-8"/>
    <jsp:useBean id="bean01" scope="session" class="p3.BeanP01" />
  </head>
  <body>
    <% BeanP01 jspBean01 = (BeanP01)request.getAttribute("bean01"); %>
    <header>
      <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
    </header>
    <section>
      <h2><a href="">Bienvenido a este servicio</a></h2>
      <form name="form" method="get" >
        <a href="?pphase=02&p=<%= jspBean01.getPassword() %>">Ver los ficheros err&oacute;neos</a>
        <input type="hidden" id="pphase" name="pphase" value="02"/>
      </form>
    </section>
    <section>
      <h3>Selecciona una consulta:</h3>
      <li type="disc"><a href="?pphase=11&p=<%= jspBean01.getPassword() %>">Consulta 1: Ver los alumnos de una asignatura de una titulaci&oacute;n</a></li><br>
      <li type="disc"><a href="?pphase=21&p=<%= jspBean01.getPassword() %>">Consulta 2: Ver informaci&oacute;n de una titulaci&oacute;n</a></li><br>
    </section>
    <footer>
      <hr/>
      <p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
