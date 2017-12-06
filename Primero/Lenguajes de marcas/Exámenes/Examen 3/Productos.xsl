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
                <h1><xsl:value-of select="//nombre"></xsl:value-of></h1>
                <h2><xsl:text>TLF.:</xsl:text><xsl:value-of select="//telefono"></xsl:value-of></h2>
                <xsl:text>Página Web: </xsl:text><a><xsl:value-of select="//url"></xsl:value-of></a><br></br>
                <xsl:text>Email: </xsl:text><xsl:value-of select="//correo"></xsl:value-of>
                <table border="1">
                    <tr bgcolor="silver" text-align="center">
                        <td colspan="7"><center>Listado de productos</center></td>
                    </tr>
                    <tr>
                        <td colspan="4">Datos importantes</td>
                        <td colspan="3">Características</td>
                    </tr>
                    <tr>
                        <td><b>Nombre del artículo</b></td>
                        <td><b>Marca</b></td>
                        <td><b>Modelo</b></td>
                        <td><b>Precio</b></td>
                        <td><b>Características</b></td>
                        <td><b>Colores</b></td>
                        <td><b>Forma</b></td>
                    </tr>
                    <xsl:for-each select="//producto">
                    <tr>
                        <td><xsl:value-of select="./articulo"></xsl:value-of></td>
                        <td><xsl:value-of select="./marca"></xsl:value-of></td>
                        <td><xsl:value-of select="./modelo"></xsl:value-of></td>
                        <td><xsl:value-of select="./precio"></xsl:value-of><xsl:text>Euros</xsl:text></td>
                        <td>
                            <ul>
                                <li><xsl:value-of select="./linea"></xsl:value-of></li>
                            </ul>
                        </td>
                        <td>
                            <ol>
                                <li><xsl:value-of select="./opcion1/opcion[./@valor]"></xsl:value-of></li>
                            </ol>
                        </td>
                        <td>
                            <ul>
                                <li><xsl:value-of select="./opcion2/opcion[@valor]"></xsl:value-of></li>
                            </ul>
                        </td>
                    </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
    
  </xsl:stylesheet>