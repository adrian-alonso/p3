<?xml version="1.0" encoding="utf-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" version="5.0" encoding="UTF-8"/>

<xsl:template match="/">
<html>
  <head>
    <title>P3EA</title>
    <link rel="stylesheet" href="p3/eaml.css"/>
    <meta charset="UTF-8"/>
  </head>
  <body>
    <header>
      <h1>Servicio de consulta de expedientes académicos</h1>
    </header>
    <section>
      <h2>Consulta 2: Fase 2 (Titulación=<xsl:value-of select="Degree/Name"/>)</h2>
      <br/>
      <table border='1'>
        <tr id="tr1">
          <th colspan="7">Grado: <xsl:value-of select="Degree/Name"/>; Campus: <xsl:value-of select="Degree/@location"/>; Rama: <xsl:value-of select="Degree/Scope"/></th>
        </tr>
        <tr id="tr2">
          <th>Asignatura</th>
          <th>Curso</th>
          <th>Nombre</th>
          <th>ID</th>
          <th>Dirección</th>
          <th>Nota</th>
          <th>Otros EAML</th>
        </tr>
        <xsl:apply-templates select="Degree/Course/Subject/Student"/>
      </table>
      <br/>
    </section>
    <section>
      <a href="?pphase=01&amp;p=Aadri4n999" class="button"><button class="homeButton">Inicio</button></a>
      <a href="?pphase=21&amp;p=Aadri4n999" class="button"><button class="backButton">Atrás</button></a>
    </section>
    <footer>
      <hr/>
      <p>© Adrián Alonso Vilar (2020-2021)</p>
    </footer>
  </body>
</html>
</xsl:template>

<xsl:template match="Student">
  <tr id="tr3">
    <td>
      <xsl:value-of select="../Name"/> (idSub: <xsl:value-of select="../@idSub"/>; Tipo: <xsl:value-of select="../@type"/>)
    </td>
    <td>
      <xsl:apply-templates select=".."/>
    </td>
    <td>
      <xsl:value-of select="Name"/>
    </td>
    <td>
      <xsl:value-of select="Dni | Resident"/>
    </td>
    <td>
      <xsl:for-each select="text()">
        <xsl:value-of select="normalize-space(.)"/>
      </xsl:for-each>
    </td>
    <td>
      <xsl:value-of select="Grade"/>
    </td>
    <td>
      <xsl:value-of select="EAML"/>
    </td>
  </tr>
</xsl:template>

<xsl:template match="Subject">
  <xsl:value-of select="../@number"/>
</xsl:template>

</xsl:stylesheet>
