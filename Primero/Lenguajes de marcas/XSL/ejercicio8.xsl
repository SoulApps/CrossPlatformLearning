<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">
    <xsl:output method="html" version="4.0" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <html>
            <head></head>
            <body>
                <ul>
                    <xsl:apply-templates select="//alumno|//profesor"></xsl:apply-templates>
                </ul>
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="//alumno|//profesor">
        <li><xsl:value-of select="./nombre|./DNI"></xsl:value-of></li><br/>
    </xsl:template>
</xsl:stylesheet>