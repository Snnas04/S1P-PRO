<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:output method="html" encoding="utf-8" indent="yes"/>

    <xsl:template match="celler" >
        <html>
            <head>
                <title>Factures</title>
                <link href="estil.css" rel="stylesheet"/>
            </head>
            <body>
                <xsl:apply-templates select="//factura"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="factura">
        <xsl:variable name="codi_client" select="comprador/@codi"/>
        <xsl:variable name="client" select="//client[@codi=$codi_client]"/>

        <div class="container">
            <div class="company-info">
                <!-- Nom de l'empresa -->
                <h2>Tu Empresa</h2>
                <!-- Direccio de l'empresa -->
                <p>Dirección de la Empresa</p>
                <p>Sencelles, Espanya</p>
                <p>Teléfono: 123456789</p>
            </div>

            <div class="customer-details">
                <!-- codi + nom client -->
                <h3>Código de Factura: <xsl:value-of select="@numero"/></h3>
                <h3>Nombre del Cliente: <xsl:value-of select="$client/nom"/></h3>
                <h3>Código del Cliente: <xsl:value-of select="$codi_client"/></h3>
                <!-- Telefons clients -->
                <p>Teléfono 1: <xsl:value-of select="$client/telefon[1]"/></p>
                <p>Teléfono 2: <xsl:value-of select="$client/telefon[2]"/></p>
            </div>

            <table class="invoice-table">
                <tr>
                    <th>Producto</th>
                    <th>Cantidad</th>
                    <th>Precio Unitario</th>
                    <th>Subtotal</th>
                </tr>

                <xsl:for-each select="unitats">
                    <xsl:variable name="codi_producte" select="@codi"/>
                    <xsl:variable name="producte" select="//producte[@codi=$codi_producte]"/>

                    <tr>
                        <td><xsl:value-of select="$producte"/></td>
                        <td><xsl:value-of select="."/></td>
                        <td><xsl:value-of select="format-number($producte/@preu, '#.00 €')"/></td>
                        <td><xsl:value-of select="format-number(./text() * $producte/@preu, '#.00 €')"/></td>
                    </tr>
                </xsl:for-each>

                <xsl:variable name="total">
                    <xsl:for-each select="unitats">
                        <xsl:variable name="codi_producte" select="@codi"/>
                        <xsl:variable name="producte" select="//producte[@codi=$codi_producte]"/>
                        <parcial>
                            <xsl:value-of select="number(.) * $producte/@preu"/>
                        </parcial>
                    </xsl:for-each>
                </xsl:variable>

                <xsl:variable name="totalRows" select="count(unitats)"/>
                <xsl:variable name="emptyRows" select="12 - $totalRows"/>

                <xsl:if test="$emptyRows &gt; 0">
                    <xsl:for-each select="1 to $emptyRows">
                        <tr>
                            <td>&#160;</td>
                            <td>&#160;</td>
                            <td>&#160;</td>
                            <td>&#160;</td>
                        </tr>
                    </xsl:for-each>
                </xsl:if>

                <tr>
                    <td colspan="3" class="total">Total:</td>
                    <td>
                        <xsl:value-of select="format-number(sum($total/parcial), '#.00 €')"/>
                    </td>
                </tr>
            </table>

            <div class="invoice-footer">
                <!-- Missatge factura -->
                <p class="message">Gracias por tu compra.</p>
            </div>
        </div>
    </xsl:template>
</xsl:stylesheet>
