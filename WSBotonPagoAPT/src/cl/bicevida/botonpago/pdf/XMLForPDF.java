package cl.bicevida.botonpago.pdf;

import cl.bice.vida.botonpago.common.dto.general.BpiDitribFondosAPVTbl;

import cl.bicevida.botonpago.util.FechaUtil;
import cl.bicevida.botonpago.util.NumeroUtil;
import cl.bicevida.botonpago.util.RutUtil;
import cl.bicevida.botonpago.util.StringUtil;
import cl.bicevida.botonpago.vo.apt.PagoDetalleCuotaVO;
import cl.bicevida.botonpago.vo.apt.PagoPublicoVO;

import java.util.Hashtable;

import org.apache.batik.dom.util.HashTable;

import org.codehaus.jackson.map.ObjectMapper;

public class XMLForPDF {
    public XMLForPDF() {
        super();
    }
    
    /**
     * Recupera el XML para renderizado
     * de pdf
     * @return
     */
    public String getXMLForPDF(PagoPublicoVO pagoConsolidado) {
        String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>"+
        "<comprobante>" + 
        " <header>" + 
        "    <formadepago>" + pagoConsolidado.getFormaPago() + "</formadepago>" + 
        "    <numerotransaccion>" + pagoConsolidado.getBanco().getIdTransaccionBanco() + "</numerotransaccion>" + 
        "    <fechaoperacion>" +FechaUtil.getFechaFormateoStandar(pagoConsolidado.getFechaTransaccion()) + "</fechaoperacion>" + 
        "    <nombre>" + StringUtil.replaceBadCharsFOPDF(pagoConsolidado.getDatosCliente().getNombreCliente()) + "</nombre>" + 
        "    <rut>" + NumeroUtil.formatMilesNoDecimal(pagoConsolidado.getDatosCliente().getRutCliente()) + "-" + RutUtil.calculaDv(Integer.toString(pagoConsolidado.getDatosCliente().getRutCliente())) + "</rut>" + 
        "    <direccion>" + StringUtil.replaceBadCharsFOPDF(pagoConsolidado.getDatosCliente().getDireccion()) + "</direccion>" + 
        "    <comuna>" + StringUtil.replaceBadCharsFOPDF(pagoConsolidado.getDatosCliente().getComuna()) + "</comuna>" + 
        "    <ciudad>" + StringUtil.replaceBadCharsFOPDF(pagoConsolidado.getDatosCliente().getRegion()) + "</ciudad>" + 
        " </header>" +
        " <detalle>";

        //Iteracion
        int items = pagoConsolidado.getHashcuotas().size();
        ObjectMapper mapper = new ObjectMapper();
        Hashtable hash = pagoConsolidado.getHashcuotas();
        for(int counter = 1; counter <= items; counter++){
        //while (items.hasNext()) {
            //PagoDetalleCuotaVO dto = (PagoDetalleCuotaVO)pagoConsolidado.getHashcuotas().get(counter);
            PagoDetalleCuotaVO dto = mapper.convertValue(hash.get(""+counter), PagoDetalleCuotaVO.class);
            if(dto.isSelecionado()){
            
                String tipoProd = dto.getTipoProducto().toUpperCase();
                if (dto.getCodigoProducto() == 1060 || dto.getCodigoProducto() == 1063 || dto.getCodigoProducto() == 1064) { //APV     
                    tipoProd = dto.getTipoProducto().toUpperCase();
                    if (tipoProd == null || tipoProd.trim().length() == 0) {
                        tipoProd = "Regimen Tributario A";
                    }
                }
                if (dto.getCodigoProducto() == 1061) { //57BICE
                    tipoProd = "57 Bis";
                }
                if (dto.getCodigoProducto() == 1062) { //FLEXIBLE MUTUO
                    tipoProd = "Flexible Mutuo";
                }
                
                xml = xml + 
                "   <row>" + 
                "     <producto>" + StringUtil.replaceBadCharsFOPDF(dto.getDescripcionProducto()) + "</producto>" + 
                "     <tipo>"+ StringUtil.replaceBadCharsFOPDF(tipoProd) +"</tipo> " + 
                "     <numeropoliza>N&#xB0;" + dto.getNumeroProducto() + "</numeropoliza>" +                
                "     <periodocobertura>" + FechaUtil.getFechaFormateoCustom(dto.getFechaVencimiento(),"MMMM yyyy") + "</periodocobertura>" + 
                "     <primapagouf>"+ NumeroUtil.formatMilesSiDecimal(dto.getValorEnUF()) +"</primapagouf> " + 
                "     <primapagopesos>"+ NumeroUtil.formatMilesNoDecimal(dto.getValorEnPesos()) +"</primapagopesos> " + 
                "     <saldofavor>0</saldofavor>" + 
                "     <montopagado>" + NumeroUtil.formatMilesNoDecimal(dto.getTotalCuota()) + "</montopagado>" + 
                "   </row>" ;
            }
        }
        
        xml = xml +
        " </detalle>" + 
        " <footer>" + 
        "   <fechavencimiento>" + FechaUtil.getFechaFormateoCustom(pagoConsolidado.getUltimoVencimientoDeuda(),"MMMM yyyy") + "</fechavencimiento>" + 
        "   <totalapagar>" + NumeroUtil.formatMilesNoDecimal(pagoConsolidado.getTotalPagar()) + "</totalapagar>";
        if ( pagoConsolidado.getResultadoPagoBanco() != null) {
            xml = xml +
            "   <numerooperacion>" + pagoConsolidado.getResultadoPagoBanco().getNumeroTransaccionBanco() + "</numerooperacion>" + 
            "   <numerocuotas>" + pagoConsolidado.getResultadoPagoBanco().getNumeroCuotasBanco() + "</numerocuotas>" + 
            "   <codigoautorizacion>" + pagoConsolidado.getResultadoPagoBanco().getCodigoAutorizacion() + "</codigoautorizacion>" + 
            "   <numeroordencompra>" + pagoConsolidado.getResultadoPagoBanco().getNumeroOrdenCompra() + "</numeroordencompra>" + 
            "   <numerotarjeta>" +pagoConsolidado.getResultadoPagoBanco().getNumeroTarjeta() + "</numerotarjeta>" + 
            "   <fechabanco>" + pagoConsolidado.getResultadoPagoBanco().getFechaBanco() + "</fechabanco>" + 
            "   <tipocuota>" + StringUtil.replaceBadCharsFOPDF(pagoConsolidado.getResultadoPagoBanco().getTipoCuotas()) + "</tipocuota>" + 
            "   <moneda>" + pagoConsolidado.getResultadoPagoBanco().getMonedaPago() + "</moneda>" + 
            "   <horabanco>" + pagoConsolidado.getResultadoPagoBanco().getHoraBanco() + "</horabanco>";
        }
        xml = xml + " </footer></comprobante>";        
        xml = xml.replaceAll("null", "-");
        
        return xml;
    }
    
    public String getXMLForPDFAPT(PagoPublicoVO pago) {
        ObjectMapper mapper = new ObjectMapper();
        //CABECERA
        String xmlcabecera = "" +
        "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>"+
        "<comprobante>" + 
        " <header>" + 
        "    <formadepago>" + pago.getFormaPago() + "</formadepago>" + 
        "    <numerotransaccion>" + pago.getBanco().getIdTransaccionBanco() + "</numerotransaccion>" + 
        "    <fechaoperacion>" +FechaUtil.getFechaFormateoStandar(pago.getFechaTransaccion()) + "</fechaoperacion>" + 
        "    <nombre>" + StringUtil.replaceBadCharsFOPDF(pago.getDatosCliente().getNombreCliente()) + "</nombre>" + 
        "    <rut>" + NumeroUtil.formatMilesNoDecimal(pago.getDatosCliente().getRutCliente()) + "-" + RutUtil.calculaDv(Integer.toString(pago.getDatosCliente().getRutCliente())) + "</rut>" + 
        "    <direccion>" + StringUtil.replaceBadCharsFOPDF(pago.getDatosCliente().getDireccion()) + "</direccion>" + 
        "    <comuna>" + StringUtil.replaceBadCharsFOPDF(pago.getDatosCliente().getComuna()) + "</comuna>" + 
        "    <ciudad>" + StringUtil.replaceBadCharsFOPDF(pago.getDatosCliente().getRegion()) + "</ciudad>" + 
        " </header>";        
        
        //DETALLE Y DISTRIBUCION
        String xmldetalle01 = "" +
        " <detalle>";
        String xmldetalle02 = "";
        
        String xmldistribucion01 = "" +
        " <distribucion visible=\"false\">";
        String xmldistribucion02 = "";
        
        //Iteracion
        int items = pago.getHashcuotas().size();        
        for(int counter = 1; counter <= items; counter++){
        //while (items.hasNext()) {
            //PagoDetalleCuotaVO dto = (PagoDetalleCuotaVO)pago.getHashcuotas().get(counter);
            PagoDetalleCuotaVO dto = mapper.convertValue(pago.getHashcuotas().get(""+counter), PagoDetalleCuotaVO.class);
            if(dto.isSelecionado()){
                String tipoProd = dto.getTipoProducto().toUpperCase();
                if (dto.getRegimenTributario() == 1 || dto.getRegimenTributario() == 2) {
                    if (dto.getRegimenTributario() == 1) {
                        tipoProd = "Regimen Tributario A";
                    } else {
                        tipoProd = "Regimen Tributario B";
                    }
                } else {
                    tipoProd = dto.getDescripcionRegimen();
                }
                
                //Generacion del detalle de polizas pagadas
                xmldetalle02 = xmldetalle02 + 
                "   <row>" + 
                "     <producto>" + StringUtil.replaceBadCharsFOPDF(dto.getDescripcionProducto()) + "</producto>" + 
                "     <poliza>N&#xB0;" + dto.getNumeroProducto() + "</poliza>" + 
                "     <tipo>"+ StringUtil.replaceBadCharsFOPDF(tipoProd) +"</tipo> " + 
                "     <periodocobertura>" + FechaUtil.getFechaFormateoCustom(dto.getFechaVencimiento(),"MMMM yyyy") + "</periodocobertura>" + 
                "     <montopagado>" + NumeroUtil.formatMilesNoDecimal(dto.getTotalCuota()) + "</montopagado>" + 
                "   </row>" ;              
               
               
                //Generacion del detalle de distribucion de polizas pagadas
               if(dto.getDistribucionFondos() != null && dto.getDistribucionFondos().size() > 0){
                    xmldistribucion01 = "" +
                    " <distribucion visible=\"true\">";
                    
                    // cabecera detalle poliza
                    String xmlpoliza = "" +
                    " <poliza>" +
                    "   <producto>" + StringUtil.replaceBadCharsFOPDF(dto.getDescripcionProducto()) + "</producto>" +
                    "   <nropoliza>" + dto.getNumeroProducto() + "</nropoliza>";
                    
                    //detalle de la distribucion de fondos
                    String xmldetalledist01 = "" +
                    " <detalle>";
                    String xmldetalledist02 = "";  
                    String colorVar = "";
                    for(int i=0; i<dto.getDistribucionFondos().size(); i++ ){
                        BpiDitribFondosAPVTbl detalledist = dto.getDistribucionFondos().get(i); 
                        colorVar = detalledist.getHexadecimal() == null?"#C22A22":detalledist.getHexadecimal();
                        if(detalledist.getMonto() > 0.0){
                            xmldetalledist02 = xmldetalledist02 + "" +
                            "   <row>" +
                            //"       <colorfondo>" + detalledist.getColor().intValue() + "</colorfondo>" +
                            "       <colorfondo>" + colorVar + "</colorfondo>" +
                            //"       <colorfondo>" + detalledist.getHexadecimal() + "</colorfondo>" +
                            "       <nombrefondo>" + StringUtil.replaceBadCharsFOPDF(detalledist.getNombreFondo()) + "</nombrefondo>" +
                            "       <montofondo>" + NumeroUtil.formatMilesNoDecimal(detalledist.getMonto()) +  "</montofondo>" +
                            "       <porcentajefondo>" + detalledist.getPorcentaje().intValue() + "</porcentajefondo>" +
                            "   </row>";
                        }
                    }

                
                    
                    String xmltotaldist = "<total>" + NumeroUtil.formatMilesNoDecimal(dto.getTotalCuota()) + "</total>";
                    xmldistribucion02 = xmldistribucion02 + xmlpoliza + xmldetalledist01 + xmldetalledist02 + "</detalle>" + xmltotaldist + "</poliza>";
               }
               
            }
        }
        
        String xmldetalle = xmldetalle01 + xmldetalle02 + " </detalle>";
        String xmldistribucion = xmldistribucion01 + xmldistribucion02 + "</distribucion>";
        
        //CARGO SI ES PAGO WEBPAY
        String xmlcargo = "<cargo visible=\"false\">";
        if(pago.getIdBancoPago() == 11){
            String pocentcobro = String.valueOf(pago.getPorcentajeCobroTarjeta());
            pocentcobro = StringUtil.replaceString(pocentcobro, ".", ",");
            xmlcargo = "" +
            " <cargo visible=\"true\">" +
            "   <total>" + NumeroUtil.formatMilesNoDecimal(pago.getCargo()) + "</total>" +
            "   <mensaje>(*) Toda Operaci&#xF3;n con Tarjeta de Cr&#xE9;dito tiene un cargo de un " + pocentcobro + "%</mensaje>";            
        }
        
        xmlcargo= xmlcargo + "" +
        " </cargo>";
          
        //FOOTER              
        String xmlfooter01 = 
        " <footer>" + 
        "   <fechavencimiento>" + FechaUtil.getFechaFormateoCustom(pago.getUltimoVencimientoDeuda(),"MMMM yyyy") + "</fechavencimiento>" + 
        "   <totalapagar>" + NumeroUtil.formatMilesNoDecimal(pago.getTotalPagar() + pago.getCargo()) + "</totalapagar>";
        String xmlfooter02 = "";
        if ( pago.getResultadoPagoBanco() != null) {
            xmlfooter02 = xmlfooter02 +
            "   <numerooperacion>" + pago.getResultadoPagoBanco().getNumeroTransaccionBanco() + "</numerooperacion>" + 
            "   <numerocuotas>" + pago.getResultadoPagoBanco().getNumeroCuotasBanco() + "</numerocuotas>" + 
            "   <codigoautorizacion>" + pago.getResultadoPagoBanco().getCodigoAutorizacion() + "</codigoautorizacion>" + 
            "   <numeroordencompra>" + pago.getResultadoPagoBanco().getNumeroOrdenCompra() + "</numeroordencompra>" + 
            "   <numerotarjeta>" + pago.getResultadoPagoBanco().getNumeroTarjeta() + "</numerotarjeta>" + 
            "   <fechabanco>" + pago.getResultadoPagoBanco().getFechaBanco() + "</fechabanco>" + 
            "   <tipocuota>" + StringUtil.replaceBadCharsFOPDF(pago.getResultadoPagoBanco().getTipoCuotas()) + "</tipocuota>" + 
            "   <moneda>" + pago.getResultadoPagoBanco().getMonedaPago() + "</moneda>" + 
            "   <horabanco>" + pago.getResultadoPagoBanco().getHoraBanco() + "</horabanco>";
        }
        
        String xmlfooter = xmlfooter01 + xmlfooter02 + " </footer></comprobante>";     
        String xml = xmlcabecera + xmldetalle + xmlcargo + xmldistribucion + xmlfooter;  
        
        xml = xml.replaceAll("null", "No aplica");
        
        return xml;
    }
    
}
