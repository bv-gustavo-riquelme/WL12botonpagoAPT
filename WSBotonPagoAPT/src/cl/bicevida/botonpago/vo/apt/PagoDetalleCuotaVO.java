package cl.bicevida.botonpago.vo.apt;

import cl.bice.vida.botonpago.common.dto.general.BpiDitribFondosAPVTbl;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class PagoDetalleCuotaVO implements Serializable {
    private boolean selecionado;
    private boolean disabled;
    private boolean distribucion;
    private int idCuota;
    private Date fechaTransaccion;
    private Date fechaVencimiento;
    private String estado;
    private Double valorEnPesos;
    private Double valorEnUF;
    private String descripcionProducto;
    private int codigoProducto;
    private int numeroProducto;
    private int numeroRamo;
    private int folio_recibo;
    private Double totalCuota;
    private Double saldoFavor;
    private int tipoCuota;
    private String tipoProducto;
    private int viaPago;    
    private int secuencia;
    
    
    //resultado Distribucion
    private int resultadoDistribucion = -1;  //-1=No Asignado aun //0=Asignado una Distribucion
    private int idAporte; //Numero de Grabacion del ID Detalle Aporte al momento de Grabar
    private Double montototaldistribucion;
    private List<BpiDitribFondosAPVTbl> distribucionFondos;
    
    //NUEVOS ATRIBUTOS
    private String descripcionRegimen;
    private Long regimenTributario;
    
    /*************Atributos Distribucion*****/
    private String radioDistribucion;    
    private String radioRegimen;
    /**********************************/
    
    public PagoDetalleCuotaVO() {
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setValorEnPesos(Double valorEnPesos) {
        this.valorEnPesos = valorEnPesos;
    }

    public Double getValorEnPesos() {
        return valorEnPesos;
    }

    public void setValorEnUF(Double valorEnUF) {
        this.valorEnUF = valorEnUF;
    }

    public Double getValorEnUF() {
        return valorEnUF;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setNumeroProducto(int numeroProducto) {
        this.numeroProducto = numeroProducto;
    }

    public int getNumeroProducto() {
        return numeroProducto;
    }

    public void setTotalCuota(Double totalCuota) {
        this.totalCuota = totalCuota;
    }

    public Double getTotalCuota() {
        return totalCuota;
    }

    public void setSaldoFavor(Double saldoFavor) {
        this.saldoFavor = saldoFavor;
    }

    public Double getSaldoFavor() {
        return saldoFavor;
    }

    public void setFechaTransaccion(Date fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    public Date getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setIdCuota(int idCuota) {
        this.idCuota = idCuota;
    }

    public int getIdCuota() {
        return idCuota;
    }

    public void setTipoCuota(int tipoCuota) {
        this.tipoCuota = tipoCuota;
    }

    public int getTipoCuota() {
        return tipoCuota;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setNumeroRamo(int numeroRamo) {
        this.numeroRamo = numeroRamo;
    }

    public int getNumeroRamo() {
        return numeroRamo;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setViaPago(int viaPago) {
        this.viaPago = viaPago;
    }

    public int getViaPago() {
        return viaPago;
    }

    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public void setFolio_recibo(int folio_recibo) {
        this.folio_recibo = folio_recibo;
    }

    public int getFolio_recibo() {
        return folio_recibo;
    }

    public void setDistribucion(boolean distribucion) {
        this.distribucion = distribucion;
    }

    public boolean isDistribucion() {
        return distribucion;
    }

    public void setIdAporte(int idAporte) {
        this.idAporte = idAporte;
    }

    public int getIdAporte() {
        return idAporte;
    }

    public void setResultadoDistribucion(int resultadoDistribucion) {
        this.resultadoDistribucion = resultadoDistribucion;
    }

    public int getResultadoDistribucion() {
        return resultadoDistribucion;
    }

    public void setDistribucionFondos(List<BpiDitribFondosAPVTbl> distribucionFondos) {
        this.distribucionFondos = distribucionFondos;
    }

    public List<BpiDitribFondosAPVTbl> getDistribucionFondos() {
        return distribucionFondos;
    }

    public void setMontototaldistribucion(Double montototaldistribucion) {
        this.montototaldistribucion = montototaldistribucion;
    }

    public Double getMontototaldistribucion() {
        return montototaldistribucion;
    }

    public void setDescripcionRegimen(String descripcionRegimen) {
        this.descripcionRegimen = descripcionRegimen;
    }

    public String getDescripcionRegimen() {
        return descripcionRegimen;
    }

    public void setRegimenTributario(Long regimenTributario) {
        this.regimenTributario = regimenTributario;
    }

    public Long getRegimenTributario() {
        return regimenTributario;
    }

    public void setRadioDistribucion(String radioDistribucion) {
        this.radioDistribucion = radioDistribucion;
    }

    public String getRadioDistribucion() {
        return radioDistribucion;
    }

    public void setRadioRegimen(String radioRegimen) {
        this.radioRegimen = radioRegimen;
    }

    public String getRadioRegimen() {
        return radioRegimen;
    }


}
