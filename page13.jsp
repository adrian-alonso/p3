<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="p3/eaml.css">
    <meta charset="UTF-8">
    <jsp:useBean id="bean13" scope="session" class="p3.BeanP13" />
  </head>
  <body>
    <header>
      <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
    </header>
    <section>
      <h2>Consulta 1: Fase 3 (Titulaci&oacute;n=${bean13.pdegree}, Asignatura=${bean13.psubject})</h2>
      <p>Este es el resultado:</p>
      <ol>
        <jsp:getProperty name="bean13" property="students_HTML"/>
      </ol>
    </section>
    <section>
      <a href="?pphase=01&p=${bean13.password}" class="button">
        <button class="homeButton">Inicio</button>
      </a>
      <a href="?pphase=12&pdegree=${bean13.pdegree}&p=${bean13.password}" class="button">
        <button class="backButton">Atr&aacute;s</button>
      </a>
    </section>
    <footer>
      <hr>
      <p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
