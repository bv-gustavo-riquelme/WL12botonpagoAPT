package cl.bicevida.botonpago.servicio;

import cl.bicevida.botonpago.core.PagoPublicoCore;
import cl.bicevida.botonpago.util.RutUtil;
import cl.bicevida.botonpago.util.StringUtil;
import cl.bicevida.botonpago.util.ValidadorRut;
import cl.bicevida.botonpago.vo.apt.PagoPublicoVO;
import cl.bicevida.botonpago.vo.in.InCorreo;
import cl.bicevida.botonpago.vo.out.OutMensaje;
import cl.bicevida.botonpago.vo.out.PagoPublicoOut;

import java.net.URL;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


@Path("/apt")
@Produces(MediaType.APPLICATION_JSON)
public class ServicioAPT {
    public ServicioAPT() {
        super();
    }
    @Context HttpServletRequest request;
    @Context ServletContext context; 
    
    @Path("/consultaDeuda")
    @GET
    public PagoPublicoOut consultaDeuda(@QueryParam("rut")String rutParam){
        ValidadorRut validador = new ValidadorRut();
        PagoPublicoVO pago = new PagoPublicoVO();
        PagoPublicoOut pagoOut = new PagoPublicoOut();
        try {
            validador.validaRut(rutParam);
            StringUtil.replaceString(rutParam,".", "");
            StringUtil.replaceString(rutParam,",", "");
            Integer rut = Integer.parseInt(RutUtil.extractRut(rutParam));
            pago = LogicaServicio.findDeudaCliente(rut);
            List hash = new ArrayList(pago.getHashcuotas().values());
            pago.setHashList(hash);
            pagoOut.setPagoPublico(pago);
            
        }catch (Exception e) {
            pago.setEstado(Boolean.FALSE);
            pago.setMensajeRespuesta(e.getMessage());
            pago.setCodRespuesta(1); //error general
            pagoOut.setPagoPublico(pago);
            return pagoOut;
        }  
        return pagoOut;
    }
      
    @Path("/distribuirProducto")
    @POST
    public PagoPublicoOut distribuirProducto(PagoPublicoOut pagoPublico){
        PagoPublicoOut pagoOut = new PagoPublicoOut();
        PagoPublicoVO pago= new PagoPublicoVO();
        
        try {
            pago = LogicaServicio.doDistribuirProducto(pagoPublico.getPagoPublico());
            pagoOut.setPagoPublico(pago);
        }catch (Exception e) {
            pago.setEstado(Boolean.FALSE);
            if(e.getCause()!= null){
                pago.setMensajeRespuesta(e.getCause().getMessage());
            }else               
                pago.setMensajeRespuesta(e.getMessage());
            pago.setCodRespuesta(1); //error general
            pagoOut.setPagoPublico(pago);
            return pagoOut;
        }  
        return pagoOut;
    }
    
    @Path("/confirmarDistribucion")
    @POST
    public PagoPublicoOut confirmarDistribucion(PagoPublicoOut pagoPublico){
        
        PagoPublicoOut pagoOut = new PagoPublicoOut();
        PagoPublicoVO pago= new PagoPublicoVO();
        
        try {
            pago = LogicaServicio.doConfirmarDistribucion(pagoPublico.getPagoPublico());
            pagoOut.setPagoPublico(pago);
        }catch (Exception e) {
            pago.setEstado(Boolean.FALSE);
            if(e.getCause()!= null){
                pago.setMensajeRespuesta(e.getCause().getMessage());
            }else               
                pago.setMensajeRespuesta(e.getMessage());
            pago.setCodRespuesta(1); //error general
            pagoOut.setPagoPublico(pago);
            return pagoOut;
        }  
        return pagoOut;
        
    }
    
    @Path("/confirmarProducto")
    @POST
    public PagoPublicoOut confirmarProducto(PagoPublicoOut pagoPublico){
        
        PagoPublicoOut pagoOut = new PagoPublicoOut();
        PagoPublicoVO pago= new PagoPublicoVO();
        
        try {
            pago = LogicaServicio.doConfirmarAPorte(pagoPublico.getPagoPublico(),request);
            pagoOut.setPagoPublico(pago);
        }catch (Exception e) {
            pago.setEstado(Boolean.FALSE);
            if(e.getCause()!= null){
                pago.setMensajeRespuesta(e.getCause().getMessage());
            }else               
                pago.setMensajeRespuesta(e.getMessage());
            pago.setCodRespuesta(1); //error general
            pagoOut.setPagoPublico(pago);
            return pagoOut;
        }  
        return pagoOut;
        
    }
    
    @Path("/confirmarMedioPago")
    @POST
    public PagoPublicoOut confirmarMedioPago(PagoPublicoOut pagoPublico){
        
        PagoPublicoOut pagoOut = new PagoPublicoOut();
        PagoPublicoVO pago= new PagoPublicoVO();
        
        try {
            pago = LogicaServicio.doConfirmacionMedioPago(pagoPublico.getPagoPublico());
            pagoOut.setPagoPublico(pago);
        }catch (Exception e) {
            pago.setEstado(Boolean.FALSE);
            if(e.getCause()!= null){
                pago.setMensajeRespuesta(e.getCause().getMessage());
            }else               
                pago.setMensajeRespuesta(e.getMessage());
            pago.setCodRespuesta(1); //error general
            pagoOut.setPagoPublico(pago);
            return pagoOut;
        }  
        return pagoOut;
        
    }
    
    
    @Path("/verificarComprobante")
    @POST
    public PagoPublicoOut verificarComprobante(PagoPublicoOut pagoPublico){
        
        PagoPublicoOut pagoOut = new PagoPublicoOut();
        PagoPublicoVO pago= new PagoPublicoVO();
        
        try {
            URL realPath = context.getResource("/");
            pago = LogicaServicio.doVerificar(pagoPublico.getPagoPublico(),realPath.toString());
            pagoOut.setPagoPublico(pago);
        }catch (Exception e) {
            pago.setEstado(Boolean.FALSE);
            if(e.getCause()!= null){
                pago.setMensajeRespuesta(e.getCause().getMessage());
            }else               
                pago.setMensajeRespuesta(e.getMessage());
            pago.setCodRespuesta(1); //error general
            pagoOut.setPagoPublico(pago);
            return pagoOut;
        }  
        return pagoOut;
        
    }
    
    @Path("/enviarEmail")
    @POST
    public OutMensaje enviarEmail(InCorreo inCorreo){
        OutMensaje salida = new OutMensaje();
        
        PagoPublicoVO pago = new PagoPublicoVO();
        pago.setHashcuotas(new Hashtable());
        pago.setHashList(inCorreo.getHashList());
        
        try {
            PagoPublicoCore.llenaLinked(pago);
            salida = LogicaServicio.doEnviarPorEmail(pago.getHashcuotasl(), inCorreo.getUrlPdfDownload(),inCorreo.getNombreCliente(),inCorreo.getFechaTransaccion(),inCorreo.getEmailCustom());
            return salida;
        }catch(Exception e){
            salida.setMensaje("Ha ocurrido un error: " +e.getMessage());
            salida.setCodigo("01");
            return salida;
        }
    }
    
    @Path("/cancelar")
    @POST
    public PagoPublicoOut doCancelar(PagoPublicoOut pagoPublico){
        
        PagoPublicoOut pagoOut = new PagoPublicoOut();
        PagoPublicoVO pago= new PagoPublicoVO();
        
        try {
            pago = LogicaServicio.doCancelarSeleccionarPago(pagoPublico.getPagoPublico());
            pagoOut.setPagoPublico(pago);
        }catch (Exception e) {
            pago.setEstado(Boolean.FALSE);
            if(e.getCause()!= null){
                pago.setMensajeRespuesta(e.getCause().getMessage());
            }else               
                pago.setMensajeRespuesta(e.getMessage());
            pago.setCodRespuesta(1); //error general
            pagoOut.setPagoPublico(pago);
            return pagoOut;
        }  
        return pagoOut;
        
    }
    
    
    
}
