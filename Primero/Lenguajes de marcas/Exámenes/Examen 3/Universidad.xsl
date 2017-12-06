<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head></head>
            <body>
                <table border="1">
                    <tr>
                        <td colspan="3" text-align="center">Información de la Universidad</td>
                    </tr>
                    <tr>
                        <td><b>ALUMNOS</b></td>
                        <td><b>PROFESORES</b></td>
                        <td><b>ASIGNATURAS</b></td>
                    </tr>
                    
                    <tr>
                        <td>
                            <ul>
                                <xsl:for-each select="//matriculado[@asignatura='F89']"/>
                                <xsl:apply-templates select="//alumno"></xsl:apply-templates>
                            </ul>
                        </td>
                        <td>
                            <ul>
                                <xsl:apply-templates select="//profesor"></xsl:apply-templates>
                            </ul>
                        </td>
                        <td>
                            <ul>
                                <xsl:apply-templates select="//asignaturas"></xsl:apply-templates>
                            </ul>
                        </td>
                    </tr>
                    
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="//alumno">
        <li><xsl:value-of select="./nombre|./apellido"></xsl:value-of><xsl:text> Fecha nacimiento:</xsl:text><xsl:value-of select="./fechanacimiento/dia"/><xsl:text>/</xsl:text><xsl:value-of select="./fechanacimiento/mes"/><xsl:text>/</xsl:text><xsl:value-of select="./fechanacimiento/anio"/></li> 
    </xsl:template>
    <xsl:template match="//profesor">
        <li><xsl:value-of select="./nombre|./apellido"></xsl:value-of><br/><xsl:text>Asignaturas que imparte:</xsl:text><xsl:value-of select="@asignaturas"></xsl:value-of></li>
    </xsl:template>
    <xsl:template match="//asignatura">
        <li>
            <xsl:text>Nombre Asignatura: </xsl:text>
            <xsl:value-of select="titulo"></xsl:value-of>
            <xsl:text> Nivel: </xsl:text>
            <xsl:choose>
            <xsl:when test="creditos &lt; 5">
                <xsl:text>Dificultad Baja</xsl:text>
            </xsl:when>
            <xsl:when test="creditos &lt; 8">
                <xsl:text>Dificultad Media Baja</xsl:text>
            </xsl:when>
            <xsl:when test="creditos &lt; 12">
                <xsl:text>Dificultad Media Alta</xsl:text>
            </xsl:when>
            <xsl:when test="creditos &lt; 20">
                <xsl:text>Dificultad Alta</xsl:text>
            </xsl:when> 
            </xsl:choose>
        </li>
    </xsl:template>
</xsl:stylesheet>