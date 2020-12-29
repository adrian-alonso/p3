<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="p3.BeanP11"%>
<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="/sint101/p3/eaml.css">
    <meta charset="UTF-8">
    <jsp:useBean id="bean11" scope="session" class="p3.BeanP11" />
  </head>
  <body>
    <header>
      <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
    </header>
    <section>
    <h2>Consulta 1: Fase 1</h2>
    <p>Selecciona:</p>
    <ol>
      <jsp:getProperty name="bean11" property="degrees_HTML"/>
    </ol>
    </section>
    <section>
      <a href="?pphase=01&p=${bean11.password}" class="button"><button class="homeButton">Inicio</button></a>
    </section>
    <footer>
      <hr>
      <p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
