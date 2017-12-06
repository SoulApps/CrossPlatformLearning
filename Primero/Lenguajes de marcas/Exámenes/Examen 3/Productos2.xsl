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
                <h1>Resumen de productos de la tienda:</h1>
                <h2>Número total de productos</h2>
                <p>Número total de cantidades de productos: <xsl:apply-templates select="//productos"></xsl:apply-templates></p>
                <p>Artículo más caro: <xsl:apply-templates select="//producto"></xsl:apply-templates></p>
                <p>Artículo más barato: <xsl:apply-templates select="//productos/producto"></xsl:apply-templates></p>
                <p>Suma de todos los productos: <xsl:apply-templates select="/tienda/productoss"></xsl:apply-templates></p>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="//productos">
        <xsl:value-of select="count(producto)"></xsl:value-of>
    </xsl:template>
    <xsl:template match="//producto">
        <xsl:value-of select="max(precio)"></xsl:value-of>
    </xsl:template>
    <xsl:template match="//productos/producto">
        <xsl:value-of select="min(precio)"></xsl:value-of>
    </xsl:template>
    <xsl:template match="/tienda/productos">
        <xsl:value-of select="sum(precio)"></xsl:value-of>
    </xsl:template>
</xsl:stylesheet>