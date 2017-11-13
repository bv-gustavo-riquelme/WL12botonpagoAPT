<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns="urn:schemas-microsoft-com:office:spreadsheet" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:msxsl="urn:schemas-microsoft-com:xslt"
                xmlns:user="urn:my-scripts" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet">
    <xsl:decimal-format name="Chile" decimal-separator="," grouping-separator="."/>
    <xsl:template match="/">
        <Workbook xmlns="urn:schemas-microsoft-com:office:spreadsheet" xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel"
                  xmlns:ss="urn:schemas-microsoft-com:office:spreadsheet" xmlns:html="http://www.w3.org/TR/REC-html40">
            <Styles>
                <Style ss:ID="Default" ss:Name="Normal">
                    <Alignment ss:Horizontal="Center" ss:Vertical="Center" ss:WrapText="1"/>
                    <Borders/>
                    <Font/>
                    <Interior/>
                    <NumberFormat/>
                    <Protection/>
                </Style>               
                <Style ss:ID="TITULO">
                    <Borders>
                        <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
                    </Borders>
                    <Font ss:FontName="Calibri" x:Family="Swiss" ss:Bold="1"/>
                    <Interior ss:Color="#99CCFF" ss:Pattern="Solid"/>
                </Style>
                <Style ss:ID="DATA">
                    <Borders>
                        <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
                    </Borders>
                    <Font ss:FontName="Calibri" x:Family="Swiss"/>
                </Style>
                <Style ss:ID="DATANUMBER">
                    <Borders>
                        <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
                    </Borders>
                    <Font ss:FontName="Calibri" x:Family="Swiss"/>
                    <NumberFormat/>
                </Style>
                <Style ss:ID="DATANUMBERFORMAT">
                    <Borders>
                        <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
                    </Borders>
                    <Font ss:FontName="Calibri" x:Family="Swiss"/>
                    <NumberFormat ss:Format="#,##0"/>
                </Style>
                <Style ss:ID="DATADATE">
                    <Borders>
                        <Border ss:Position="Bottom" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Left" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Right" ss:LineStyle="Continuous" ss:Weight="1"/>
                        <Border ss:Position="Top" ss:LineStyle="Continuous" ss:Weight="1"/>
                    </Borders>
                    <Font ss:FontName="Calibri" x:Family="Swiss"/>
                    <NumberFormat ss:Format="dd\-mm\-yyyy\ hh:mm"/>
                </Style>
            </Styles>
            
                    <Worksheet ss:Name="Aporte Extraordinario">
                        <Table x:FullColumns="1" x:FullRows="1">
                            <Column ss:AutoFitWidth="1" ss:Width="130"/>
                            <Column ss:AutoFitWidth="1" ss:Width="80"/>
                            <Column ss:AutoFitWidth="1" ss:Width="80"/>
                            <Row>
                                <Cell ss:StyleID="TITULO">
                                    <Data ss:Type="String">Fondo</Data>
                                </Cell>
                                <Cell ss:StyleID="TITULO">
                                    <Data ss:Type="String">Aporte Ext. $</Data>
                                </Cell>
                                <Cell ss:StyleID="TITULO">
                                    <Data ss:Type="String">Aporte Ext. %</Data>
                                </Cell>
                            </Row>
                            
                            <xsl:for-each select="//distribucion/fondo">
                                <Row>
                                    <Cell ss:StyleID="DATA">
                                        <Data ss:Type="String">
                                            <xsl:value-of select="nombre"/>
                                        </Data>
                                    </Cell>
                                    <Cell ss:StyleID="DATANUMBERFORMAT">
                                        <Data ss:Type="Number">
                                            <xsl:value-of select="monto"/>
                                        </Data>
                                    </Cell>
                                    <Cell ss:StyleID="DATANUMBER">
                                        <Data ss:Type="Number">
                                            <xsl:value-of select="porcentaje"/>
                                        </Data>
                                    </Cell>
                                </Row>
                            </xsl:for-each>
                            
                        </Table>
                    </Worksheet>
              
        </Workbook>
    </xsl:template>
</xsl:stylesheet>
