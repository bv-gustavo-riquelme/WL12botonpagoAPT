package cl.bicevida.botonpago.vo.out;

import cl.bicevida.botonpago.vo.apt.PagoPublicoVO;


public class PagoPublicoOut {
    
    private PagoPublicoVO pagoPublico;
    
    public PagoPublicoOut() {
        super();
    }

    public void setPagoPublico(PagoPublicoVO pagoPublico) {
        this.pagoPublico = pagoPublico;
    }

    public PagoPublicoVO getPagoPublico() {
        return pagoPublico;
    }
}
