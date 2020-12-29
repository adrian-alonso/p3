<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="p3.BeanNoPassword"%>

<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="/sint101/p3/eaml.css"/>
    <meta charset="UTF-8"/>
    <jsp:useBean id="beanNoPass" scope="session" class="p3.BeanNoPassword" />
  </head>
  <body>
    <header>
      <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
    </header>
    <section>
      <p>Wrong Request: no passwd</p>
      <p>Intruduzca el par&aacute;metro p con la correspondiente contrase&ntilde;a.</p>
    </section>
    <footer>
      <hr>
      <p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
