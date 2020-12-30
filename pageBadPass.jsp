<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="/sint101/p3/eaml.css"/>
    <meta charset="UTF-8"/>
    <jsp:useBean id="beanBadPass" scope="session" class="p3.BeanBadPassword" />
  </head>
  <body>
    <header>
      <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
    </header>
    <section>
      <p>Wrong Request: bad passwd</p>
      <p>Contrase&ntilde;a incorrecta. Intruduzca el par&aacute;metro p correcto.</p>
    </section>
    <footer>
      <hr>
      <p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
