<?xml version="1.0" encoding="iso-8859-15" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html"/>

  <xsl:template match="/">
    <html>
      <head>
        <title>P3EA</title>
      </head>
      <body>
        <header>
          <h1>Servicio de consulta de expedientes acad&eacute;micos</h1>
        </header>
        <section>
          <h2>Consulta 2: Fase 2 (Titulaci&oacute;n=<xsl:value-of select="Degree/Name"/>)</h2>
          <br>
          <table border='1'>
            <tr>
              <th>Grado: <xsl:value-of select="Degree/Name"/>; Campus: <xsl:value-of select="Degree/@location"/>; Rama: <xsl:value-of select="Degree/Scope"/></th>
            </tr>
            <tr>
              <th>Asignatura</th>
              <th>Curso</th>
              <th>Nombre</th>
              <th>ID</th>
              <th>Direcci&oacute;n</th>
              <th>Nota</th>
            </tr>
            <xsl:apply-templates select="Degree/Course"/>
          </table>
        </section>
      </body>
    </html>
  </xsl:template>

  <xsl:template match="Course">
    <tr>
      <td>
        <xsl:value-of select="Subject/Name"/> (idSub: <xsl:value-of select="Subject/@idSub"/>; Tipo: <xsl:value-of select="Subject/@type"/>)
      </td>
      <td>
        <xsl:value-of select="@number"/>
      </td>
      </td>
      <td>
        <xsl:value-of select="Subject/Student/Name"/>
      </td>
      </td>
      <td>
        <xsl:value-of select="Subject/Student/Dni | Subject/Student/Resident"/>
      </td>
      </td>
      <td>
        <xsl:for-each select="Subject/Student/text()">
          <xsl:value-of select="normalize-space(.)"/>
        </xsl:for-each>
      </td>
      <td>
        <xsl:value-of select="Subject/Student/Grade"/>
      </td>
    </tr>
  </xsl:template>
</xsl:stylesheet>
