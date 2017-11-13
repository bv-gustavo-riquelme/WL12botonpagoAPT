package cl.bicevida.botonpago.vo.apt;

import java.io.Serializable;

public class RegimenPolizaTributarioVO implements Serializable {
    
    private Long numeroPoliza;
    private Long regimenTributario;
    private String descripcionRegimen;

    public RegimenPolizaTributarioVO() {
    }

    public void setNumeroPoliza(Long numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public Long getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setRegimenTributario(Long regimenTributario) {
        this.regimenTributario = regimenTributario;
    }

    public Long getRegimenTributario() {
        return regimenTributario;
    }

    public void setDescripcionRegimen(String descripcionRegimen) {
        this.descripcionRegimen = descripcionRegimen;
    }

    public String getDescripcionRegimen() {
        return descripcionRegimen;
    }
}
