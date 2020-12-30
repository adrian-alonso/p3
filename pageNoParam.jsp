<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="/sint101/p3/eaml.css"/>
    <meta charset="UTF-8"/>
    <jsp:useBean id="beanNoParam" scope="session" class="p3.BeanNoParam" />
  </head>
  <body>
    <header>
      <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
    </header>
    <section>
      <p>Wrong Request: no param:${beanNoParam.param}</p>
      <p>Par&aacute;metro ${beanNoParam.param} necesario. Introduzca su valor.</p>
    </section>
    <footer>
      <hr>
      <p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
