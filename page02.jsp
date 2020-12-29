<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="p3.BeanP02"%>

<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="/sint101/p3/eaml.css">
    <meta charset="UTF-8">
    <jsp:useBean id="bean02" scope="session" class="p3.BeanP02" />
  </head>
  <body>
    <% BeanP02 jspBean02 = (BeanP02)request.getAttribute("bean02"); %>
    <header>
      <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
    </header>
    <section>
      <h2>Se han encontrado <%= jspBean02.getWarnings().size() %> ficheros con warnings:</h2>
      <ul>
        <jsp:getProperty name="bean02" property="warnings_HTML"/>
      </ul>
      <h2>Se han encontrado <%= jspBean02.getErrors().size() %> ficheros con errores:</h2>
      <ul>
        <jsp:getProperty name="bean02" property="errors_HTML"/>
      </ul>
      <h2>Se han encontrado <%= jspBean02.getFatalErrors().size() %> ficheros con errores fatales:</h2>
      <ul>
        <jsp:getProperty name="bean02" property="fatalErrors_HTML"/>
      </ul>
    <section>
      <a href="?pphase=01&p=${bean02.password}" class="button"><button class="backButton">Atr&aacute;s</button></a>
    </section>
    <footer>
      <hr>
      <p>&copy; Adri&aacute;n Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
