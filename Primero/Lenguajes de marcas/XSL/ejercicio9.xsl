<?xml version="1.0" encoding="UTF-8"?>
 <xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head>
                <style type="text/css">
                    td{
                     border:dotted blue;
                     margin:0px;
                     }
                     table{
                     border-spacing:2px;
                     }
                </style>
            </head>
            <body>
                
                <table>
                    <tr>
                        <td colspan="3"><b>Datos</b></td>
                        <td colspan="4"><b>Notas</b></td>
                    </tr>
                    <tr style="background-color:silver;">
                        <td>Nombre</td>
                        <td>Apellidos</td>
                        <td>Faltas</td>
                        <td>Tareas</td>
                        <td>Cuestionarios</td>
                        <td>Examen</td>
                        <td>Final</td>
                    </tr>
                    <xsl:for-each select="//alumno[./@convocatoria='Junio']">
                    <tr> 
                        <td><xsl:value-of select="./nombre"></xsl:value-of></td>
                        <td><xsl:value-of select="./apellido"></xsl:value-of></td>
                        <td><xsl:choose>
                                 <xsl:when test="faltas">
                                    <xsl:value-of select="./faltas"></xsl:value-of>
                                </xsl:when>
                                <xsl:otherwise>
                                    <xsl:text>Sin faltas</xsl:text>
                                </xsl:otherwise>
                        </xsl:choose>
                        </td>
                        <td><xsl:value-of select="./tareas"></xsl:value-of></td>
                        <td style="text-align:center;"><xsl:value-of select="./cuestionarios"></xsl:value-of></td>
                        <td><xsl:value-of select="./examen"></xsl:value-of></td>
                        <td>
                            <xsl:if test="final &gt; 7">
                                <xsl:text>Notable</xsl:text>
                            </xsl:if>
                            <xsl:if test="final &gt; 9">
                                <xsl:text>Sobresaliente</xsl:text>
                            </xsl:if>
                            <xsl:if test="final &gt; 5">
                                <xsl:text>Aprobado</xsl:text>
                            </xsl:if>
                            <xsl:if test="final &lt; 5">
                                <xsl:text>Suspenso</xsl:text>
                            </xsl:if>
                            <xsl:if test="final &gt; 9.5">
                                <xsl:text>Matrícula de honor</xsl:text>
                            </xsl:if>
                        </td>
                        
                    </tr>
                    </xsl:for-each>
                </table>
         </body>
        </html>
    </xsl:template>
</xsl:stylesheet>