package cl.bicevida.botonpago.vo.apt;

import cl.bice.vida.botonpago.common.vo.ResultadoConsultaVO;

import cl.bicevida.botonpago.vo.out.OutDatosPdf;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class PagoPublicoAPT {
    
    private int idTransaccion;
    private int idNavegacion;
    private Date fechaTransaccion;
    private String xmloriginal;
    private String xmlpagopublico;
    private String xmlconfirmacion;
    private String xmlconfirmacionDataBancos;
    private PagoBancoInfoVo banco = new PagoBancoInfoVo();
    private Date   ultimoVencimientoDeuda;
    private String estadoDeuda = "";//"AL DIA";
    private Double totalPagar;
    private Double valorUF;
    private PagoDatosClienteVO datosCliente;
    private List cuotas;
    private Hashtable hashcuotas = new Hashtable();
    private int idBancoPago;
    private String urlPdfDownload;
    private String urlPdfEnEsperaDownload;
    private String absoluteServerPathPdfDownload;
    private String absoluteServerPathPdfEnEsperaDownload;    
    private String formaPago;
    private String pdfUrlVolantes = null;
    private ResultadoConsultaVO resultadoPagoBanco;
    private int tipoTransaccion;
    private int valormaxaporte;
    private Double cargo;
    private double porcentajeCobroTarjeta;
    
    
    
    
    /*****************************************************************
     * GR - Atributos utilizados para el nuevo servicio web(REST)
     * */
    private boolean estado;
    private String mensajeRespuesta;
    private Integer codRespuesta;
    private String fechaAccesoUsuario;
    private int medioPago;
    private String tbkURLExitoError;//para el medio de pago 4,9,10 (webpay,BCI)
    private String urlcgi;
    private Integer bancoId;
    private String methodSend;
    private String accion;
    
    /****************************************************************/
    
    
    public PagoPublicoAPT() {
        super();
    }


    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdNavegacion(int idNavegacion) {
        this.idNavegacion = idNavegacion;
    }

    public int getIdNavegacion() {
        return idNavegacion;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setXmloriginal(String xmloriginal) {
        this.xmloriginal = xmloriginal;
    }

    public String getXmloriginal() {
        return xmloriginal;
    }

    public void setXmlpagopublico(String xmlpagopublico) {
        this.xmlpagopublico = xmlpagopublico;
    }

    public String getXmlpagopublico() {
        return xmlpagopublico;
    }

    public void setXmlconfirmacion(String xmlconfirmacion) {
        this.xmlconfirmacion = xmlconfirmacion;
    }

    public String getXmlconfirmacion() {
        return xmlconfirmacion;
    }

    public void setXmlconfirmacionDataBancos(String xmlconfirmacionDataBancos) {
        this.xmlconfirmacionDataBancos = xmlconfirmacionDataBancos;
    }

    public String getXmlconfirmacionDataBancos() {
        return xmlconfirmacionDataBancos;
    }

    public void setBanco(PagoBancoInfoVo banco) {
        this.banco = banco;
    }

    public PagoBancoInfoVo getBanco() {
        return banco;
    }

    public void setUltimoVencimientoDeuda(Date ultimoVencimientoDeuda) {
        this.ultimoVencimientoDeuda = ultimoVencimientoDeuda;
    }

    public Date getUltimoVencimientoDeuda() {
        return ultimoVencimientoDeuda;
    }

    public void setEstadoDeuda(String estadoDeuda) {
        this.estadoDeuda = estadoDeuda;
    }

    public String getEstadoDeuda() {
        return estadoDeuda;
    }

    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

    public void setValorUF(Double valorUF) {
        this.valorUF = valorUF;
    }

    public Double getValorUF() {
        return valorUF;
    }

    public void setDatosCliente(PagoDatosClienteVO datosCliente) {
        this.datosCliente = datosCliente;
    }

    public PagoDatosClienteVO getDatosCliente() {
        return datosCliente;
    }

    public void setCuotas(List cuotas) {
        this.cuotas = cuotas;
    }

    public List getCuotas() {
        return cuotas;
    }

    public void setHashcuotas(Hashtable hashcuotas) {
        this.hashcuotas = hashcuotas;
    }

    public Hashtable getHashcuotas() {
        return hashcuotas;
    }

    public void setIdBancoPago(int idBancoPago) {
        this.idBancoPago = idBancoPago;
    }

    public int getIdBancoPago() {
        return idBancoPago;
    }

    public void setUrlPdfDownload(String urlPdfDownload) {
        this.urlPdfDownload = urlPdfDownload;
    }

    public String getUrlPdfDownload() {
        return urlPdfDownload;
    }

    public void setUrlPdfEnEsperaDownload(String urlPdfEnEsperaDownload) {
        this.urlPdfEnEsperaDownload = urlPdfEnEsperaDownload;
    }

    public String getUrlPdfEnEsperaDownload() {
        return urlPdfEnEsperaDownload;
    }

    public void setAbsoluteServerPathPdfDownload(String absoluteServerPathPdfDownload) {
        this.absoluteServerPathPdfDownload = absoluteServerPathPdfDownload;
    }

    public String getAbsoluteServerPathPdfDownload() {
        return absoluteServerPathPdfDownload;
    }

    public void setAbsoluteServerPathPdfEnEsperaDownload(String absoluteServerPathPdfEnEsperaDownload) {
        this.absoluteServerPathPdfEnEsperaDownload = absoluteServerPathPdfEnEsperaDownload;
    }

    public String getAbsoluteServerPathPdfEnEsperaDownload() {
        return absoluteServerPathPdfEnEsperaDownload;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setPdfUrlVolantes(String pdfUrlVolantes) {
        this.pdfUrlVolantes = pdfUrlVolantes;
    }

    public String getPdfUrlVolantes() {
        return pdfUrlVolantes;
    }

    public void setResultadoPagoBanco(ResultadoConsultaVO resultadoPagoBanco) {
        this.resultadoPagoBanco = resultadoPagoBanco;
    }

    public ResultadoConsultaVO getResultadoPagoBanco() {
        return resultadoPagoBanco;
    }

    public void setTipoTransaccion(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setValormaxaporte(int valormaxaporte) {
        this.valormaxaporte = valormaxaporte;
    }

    public int getValormaxaporte() {
        return valormaxaporte;
    }

    public void setCargo(Double cargo) {
        this.cargo = cargo;
    }

    public Double getCargo() {
        return cargo;
    }

    public void setPorcentajeCobroTarjeta(double porcentajeCobroTarjeta) {
        this.porcentajeCobroTarjeta = porcentajeCobroTarjeta;
    }

    public double getPorcentajeCobroTarjeta() {
        return porcentajeCobroTarjeta;
    }
}
