
package cl.bice.vida.resumenypagos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the generated package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Respuesta_QNAME = new QName("", "Respuesta");
    private final static QName _XML_QNAME = new QName("", "XML");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.InformePagoPendiente}
     *
     */
    public InformePagoPendiente createInformePagoPendiente() {
        return new InformePagoPendiente();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.ResumenConHeader}
     *
     */
    public ResumenConHeader createResumenConHeader() {
        return new ResumenConHeader();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.InformePagoServipag}
     *
     */
    public InformePagoServipag createInformePagoServipag() {
        return new InformePagoServipag();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.RespuestaPagosPendientes}
     *
     */
    public RespuestaPagosPendientes createRespuestaPagosPendientes() {
        return new RespuestaPagosPendientes();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.ComprobantePagoCaja}
     *
     */
    public ComprobantePagoCaja createComprobantePagoCaja() {
        return new ComprobantePagoCaja();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.InformePago}
     *
     */
    public InformePago createInformePago() {
        return new InformePago();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.RespuestaServipagVida}
     *
     */
    public RespuestaServipagVida createRespuestaServipagVida() {
        return new RespuestaServipagVida();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.ConsultaPagosPendientes}
     *
     */
    public ConsultaPagosPendientes createConsultaPagosPendientes() {
        return new ConsultaPagosPendientes();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.Confirmacion}
     *
     */
    public Confirmacion createConfirmacion() {
        return new Confirmacion();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.Cuadratura}
     *
     */
    public Cuadratura createCuadratura() {
        return new Cuadratura();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.RespuestaServipagHipotecaria}
     *
     */
    public RespuestaServipagHipotecaria createRespuestaServipagHipotecaria() {
        return new RespuestaServipagHipotecaria();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.DetalleCargos}
     *
     */
    public DetalleCargos createDetalleCargos() {
        return new DetalleCargos();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.Infocajas}
     *
     */
    public Infocajas createInfocajas() {
        return new Infocajas();
    }

    /**
     * Create an instance of {@link RespuestaServipagHipotecaria.ListaProductos }
     *
     */
    public RespuestaServipagHipotecaria.ListaProductos createRespuestaServipagHipotecariaListaProductos() {
        return new RespuestaServipagHipotecaria.ListaProductos();
    }

    /**
     * Create an instance of {@link RespuestaServipagHipotecaria.ListaProductos.Entrada }
     *
     */
    public RespuestaServipagHipotecaria.ListaProductos.Entrada createRespuestaServipagHipotecariaListaProductosEntrada() {
        return new RespuestaServipagHipotecaria.ListaProductos.Entrada();
    }

    /**
     * Create an instance of {@link RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota }
     *
     */
    public RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota createRespuestaServipagHipotecariaListaProductosEntradaCuota() {
        return new RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota();
    }

    /**
     * Create an instance of {@link Cuadratura.Transacciones }
     *
     */
    public Cuadratura.Transacciones createCuadraturaTransacciones() {
        return new Cuadratura.Transacciones();
    }

    /**
     * Create an instance of {@link Confirmacion.ProductosPorPagar }
     *
     */
    public Confirmacion.ProductosPorPagar createConfirmacionProductosPorPagar() {
        return new Confirmacion.ProductosPorPagar();
    }

    /**
     * Create an instance of {@link Confirmacion.ProductosPorPagar.Entrada }
     *
     */
    public Confirmacion.ProductosPorPagar.Entrada createConfirmacionProductosPorPagarEntrada() {
        return new Confirmacion.ProductosPorPagar.Entrada();
    }

    /**
     * Create an instance of {@link Confirmacion.ProductosPorPagar.Entrada.Cuota }
     *
     */
    public Confirmacion.ProductosPorPagar.Entrada.Cuota createConfirmacionProductosPorPagarEntradaCuota() {
        return new Confirmacion.ProductosPorPagar.Entrada.Cuota();
    }

    /**
     * Create an instance of {@link RespuestaServipagVida.ListaProductos }
     *
     */
    public RespuestaServipagVida.ListaProductos createRespuestaServipagVidaListaProductos() {
        return new RespuestaServipagVida.ListaProductos();
    }

    /**
     * Create an instance of {@link RespuestaServipagVida.ListaProductos.Entrada }
     *
     */
    public RespuestaServipagVida.ListaProductos.Entrada createRespuestaServipagVidaListaProductosEntrada() {
        return new RespuestaServipagVida.ListaProductos.Entrada();
    }

    /**
     * Create an instance of {@link RespuestaServipagVida.ListaProductos.Entrada.Cuota }
     *
     */
    public RespuestaServipagVida.ListaProductos.Entrada.Cuota createRespuestaServipagVidaListaProductosEntradaCuota() {
        return new RespuestaServipagVida.ListaProductos.Entrada.Cuota();
    }

    /**
     * Create an instance of {@link InformePago.PagoExitoso }
     *
     */
    public InformePago.PagoExitoso createInformePagoPagoExitoso() {
        return new InformePago.PagoExitoso();
    }

    /**
     * Create an instance of {@link InformePago.PagoExitoso.ProductosPorPagar }
     *
     */
    public InformePago.PagoExitoso.ProductosPorPagar createInformePagoPagoExitosoProductosPorPagar() {
        return new InformePago.PagoExitoso.ProductosPorPagar();
    }

    /**
     * Create an instance of {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada }
     *
     */
    public InformePago.PagoExitoso.ProductosPorPagar.Entrada createInformePagoPagoExitosoProductosPorPagarEntrada() {
        return new InformePago.PagoExitoso.ProductosPorPagar.Entrada();
    }

    /**
     * Create an instance of {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota }
     *
     */
    public InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota createInformePagoPagoExitosoProductosPorPagarEntradaCuota() {
        return new InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota();
    }

    /**
     * Create an instance of {@link ComprobantePagoCaja.ProductosPagados }
     *
     */
    public ComprobantePagoCaja.ProductosPagados createComprobantePagoCajaProductosPagados() {
        return new ComprobantePagoCaja.ProductosPagados();
    }

    /**
     * Create an instance of {@link ComprobantePagoCaja.ProductosPagados.Entrada }
     *
     */
    public ComprobantePagoCaja.ProductosPagados.Entrada createComprobantePagoCajaProductosPagadosEntrada() {
        return new ComprobantePagoCaja.ProductosPagados.Entrada();
    }

    /**
     * Create an instance of {@link ResumenConHeader.Convenios }
     *
     */
    public ResumenConHeader.Convenios createResumenConHeaderConvenios() {
        return new ResumenConHeader.Convenios();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPagados }
     *
     */
    public ResumenConHeader.ProductosPagados createResumenConHeaderProductosPagados() {
        return new ResumenConHeader.ProductosPagados();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPagados.Entrada }
     *
     */
    public ResumenConHeader.ProductosPagados.Entrada createResumenConHeaderProductosPagadosEntrada() {
        return new ResumenConHeader.ProductosPagados.Entrada();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPagados.Entrada.Cuota }
     *
     */
    public ResumenConHeader.ProductosPagados.Entrada.Cuota createResumenConHeaderProductosPagadosEntradaCuota() {
        return new ResumenConHeader.ProductosPagados.Entrada.Cuota();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPorPagar }
     *
     */
    public ResumenConHeader.ProductosPorPagar createResumenConHeaderProductosPorPagar() {
        return new ResumenConHeader.ProductosPorPagar();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPorPagar.Entrada }
     *
     */
    public ResumenConHeader.ProductosPorPagar.Entrada createResumenConHeaderProductosPorPagarEntrada() {
        return new ResumenConHeader.ProductosPorPagar.Entrada();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota }
     *
     */
    public ResumenConHeader.ProductosPorPagar.Entrada.Cuota createResumenConHeaderProductosPorPagarEntradaCuota() {
        return new ResumenConHeader.ProductosPorPagar.Entrada.Cuota();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion }
     *
     */
    public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion createResumenConHeaderProductosPorPagarEntradaCuotaCuotaOpcion() {
        return new ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion();
    }

    /**
     * Create an instance of {@link InformePagoPendiente.IdentificacionMensaje }
     *
     */
    public InformePagoPendiente.IdentificacionMensaje createInformePagoPendienteIdentificacionMensaje() {
        return new InformePagoPendiente.IdentificacionMensaje();
    }

    /**
     * Create an instance of {@link ResumenConHeader.IdentificacionMensaje }
     *
     */
    public ResumenConHeader.IdentificacionMensaje createResumenConHeaderIdentificacionMensaje() {
        return new ResumenConHeader.IdentificacionMensaje();
    }

    /**
     * Create an instance of {@link ResumenConHeader.InfoNavegacion }
     *
     */
    public ResumenConHeader.InfoNavegacion createResumenConHeaderInfoNavegacion() {
        return new ResumenConHeader.InfoNavegacion();
    }

    /**
     * Create an instance of {@link ResumenConHeader.Titulos }
     *
     */
    public ResumenConHeader.Titulos createResumenConHeaderTitulos() {
        return new ResumenConHeader.Titulos();
    }

    /**
     * Create an instance of {@link InformePagoServipag.IdentificacionMensaje }
     *
     */
    public InformePagoServipag.IdentificacionMensaje createInformePagoServipagIdentificacionMensaje() {
        return new InformePagoServipag.IdentificacionMensaje();
    }

    /**
     * Create an instance of {@link InformePagoServipag.Error }
     *
     */
    public InformePagoServipag.Error createInformePagoServipagError() {
        return new InformePagoServipag.Error();
    }

    /**
     * Create an instance of {@link InformePagoServipag.DetallePago }
     *
     */
    public InformePagoServipag.DetallePago createInformePagoServipagDetallePago() {
        return new InformePagoServipag.DetallePago();
    }

    /**
     * Create an instance of {@link InformePagoServipag.ProductosPagados }
     *
     */
    public InformePagoServipag.ProductosPagados createInformePagoServipagProductosPagados() {
        return new InformePagoServipag.ProductosPagados();
    }

    /**
     * Create an instance of {@link RespuestaPagosPendientes.Error }
     *
     */
    public RespuestaPagosPendientes.Error createRespuestaPagosPendientesError() {
        return new RespuestaPagosPendientes.Error();
    }

    /**
     * Create an instance of {@link RespuestaPagosPendientes.Producto }
     *
     */
    public RespuestaPagosPendientes.Producto createRespuestaPagosPendientesProducto() {
        return new RespuestaPagosPendientes.Producto();
    }

    /**
     * Create an instance of {@link RespuestaPagosPendientes.Cuota }
     *
     */
    public RespuestaPagosPendientes.Cuota createRespuestaPagosPendientesCuota() {
        return new RespuestaPagosPendientes.Cuota();
    }

    /**
     * Create an instance of {@link InformePago.IdentificacionMensaje }
     *
     */
    public InformePago.IdentificacionMensaje createInformePagoIdentificacionMensaje() {
        return new InformePago.IdentificacionMensaje();
    }

    /**
     * Create an instance of {@link InformePago.InfoNavegacion }
     *
     */
    public InformePago.InfoNavegacion createInformePagoInfoNavegacion() {
        return new InformePago.InfoNavegacion();
    }

    /**
     * Create an instance of {@link InformePago.PagoRechazado }
     *
     */
    public InformePago.PagoRechazado createInformePagoPagoRechazado() {
        return new InformePago.PagoRechazado();
    }

    /**
     * Create an instance of {@link RespuestaServipagVida.Error }
     *
     */
    public RespuestaServipagVida.Error createRespuestaServipagVidaError() {
        return new RespuestaServipagVida.Error();
    }

    /**
     * Create an instance of {@link ConsultaPagosPendientes.IdentificacionMensaje }
     *
     */
    public ConsultaPagosPendientes.IdentificacionMensaje createConsultaPagosPendientesIdentificacionMensaje() {
        return new ConsultaPagosPendientes.IdentificacionMensaje();
    }

    /**
     * Create an instance of {@link ConsultaPagosPendientes.Consulta }
     *
     */
    public ConsultaPagosPendientes.Consulta createConsultaPagosPendientesConsulta() {
        return new ConsultaPagosPendientes.Consulta();
    }

    /**
     * Create an instance of {@link Confirmacion.IdentificacionMensaje }
     *
     */
    public Confirmacion.IdentificacionMensaje createConfirmacionIdentificacionMensaje() {
        return new Confirmacion.IdentificacionMensaje();
    }

    /**
     * Create an instance of {@link Confirmacion.InfoNavegacion }
     *
     */
    public Confirmacion.InfoNavegacion createConfirmacionInfoNavegacion() {
        return new Confirmacion.InfoNavegacion();
    }

    /**
     * Create an instance of {@link Confirmacion.Convenio }
     *
     */
    public Confirmacion.Convenio createConfirmacionConvenio() {
        return new Confirmacion.Convenio();
    }

    /**
     * Create an instance of {@link Cuadratura.IdentificacionMensaje }
     *
     */
    public Cuadratura.IdentificacionMensaje createCuadraturaIdentificacionMensaje() {
        return new Cuadratura.IdentificacionMensaje();
    }

    /**
     * Create an instance of {@link RespuestaServipagHipotecaria.Error }
     *
     */
    public RespuestaServipagHipotecaria.Error createRespuestaServipagHipotecariaError() {
        return new RespuestaServipagHipotecaria.Error();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.IdentificacionMensaje}
     *
     */
    public cl.bice.vida.resumenypagos.IdentificacionMensaje createIdentificacionMensaje() {
        return new cl.bice.vida.resumenypagos.IdentificacionMensaje();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.EstadoCaja}
     *
     */
    public EstadoCaja createEstadoCaja() {
        return new EstadoCaja();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.EstadoInternet}
     *
     */
    public EstadoInternet createEstadoInternet() {
        return new EstadoInternet();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.Producto}
     *
     */
    public cl.bice.vida.resumenypagos.Producto createProducto() {
        return new cl.bice.vida.resumenypagos.Producto();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.Periodo}
     *
     */
    public Periodo createPeriodo() {
        return new Periodo();
    }

    /**
     * Create an instance of {@link cl.bice.vida.resumenypagos.MontoCuota}
     *
     */
    public cl.bice.vida.resumenypagos.MontoCuota createMontoCuota() {
        return new cl.bice.vida.resumenypagos.MontoCuota();
    }

    /**
     * Create an instance of {@link DetalleCargos.Cargo }
     *
     */
    public DetalleCargos.Cargo createDetalleCargosCargo() {
        return new DetalleCargos.Cargo();
    }

    /**
     * Create an instance of {@link Infocajas.Creditos }
     *
     */
    public Infocajas.Creditos createInfocajasCreditos() {
        return new Infocajas.Creditos();
    }

    /**
     * Create an instance of {@link Infocajas.Polizas }
     *
     */
    public Infocajas.Polizas createInfocajasPolizas() {
        return new Infocajas.Polizas();
    }

    /**
     * Create an instance of {@link RespuestaServipagHipotecaria.ListaProductos.Entrada.Producto }
     *
     */
    public RespuestaServipagHipotecaria.ListaProductos.Entrada.Producto createRespuestaServipagHipotecariaListaProductosEntradaProducto() {
        return new RespuestaServipagHipotecaria.ListaProductos.Entrada.Producto();
    }

    /**
     * Create an instance of {@link RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota.MontoCuota }
     *
     */
    public RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota.MontoCuota createRespuestaServipagHipotecariaListaProductosEntradaCuotaMontoCuota() {
        return new RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota.MontoCuota();
    }

    /**
     * Create an instance of {@link Cuadratura.Transacciones.Transaccion }
     *
     */
    public Cuadratura.Transacciones.Transaccion createCuadraturaTransaccionesTransaccion() {
        return new Cuadratura.Transacciones.Transaccion();
    }

    /**
     * Create an instance of {@link Confirmacion.ProductosPorPagar.TotalPorPagar }
     *
     */
    public Confirmacion.ProductosPorPagar.TotalPorPagar createConfirmacionProductosPorPagarTotalPorPagar() {
        return new Confirmacion.ProductosPorPagar.TotalPorPagar();
    }

    /**
     * Create an instance of {@link Confirmacion.ProductosPorPagar.Entrada.Producto }
     *
     */
    public Confirmacion.ProductosPorPagar.Entrada.Producto createConfirmacionProductosPorPagarEntradaProducto() {
        return new Confirmacion.ProductosPorPagar.Entrada.Producto();
    }

    /**
     * Create an instance of {@link Confirmacion.ProductosPorPagar.Entrada.Cuota.Monto }
     *
     */
    public Confirmacion.ProductosPorPagar.Entrada.Cuota.Monto createConfirmacionProductosPorPagarEntradaCuotaMonto() {
        return new Confirmacion.ProductosPorPagar.Entrada.Cuota.Monto();
    }

    /**
     * Create an instance of {@link RespuestaServipagVida.ListaProductos.Entrada.Producto }
     *
     */
    public RespuestaServipagVida.ListaProductos.Entrada.Producto createRespuestaServipagVidaListaProductosEntradaProducto() {
        return new RespuestaServipagVida.ListaProductos.Entrada.Producto();
    }

    /**
     * Create an instance of {@link RespuestaServipagVida.ListaProductos.Entrada.Cuota.MontoCuota }
     *
     */
    public RespuestaServipagVida.ListaProductos.Entrada.Cuota.MontoCuota createRespuestaServipagVidaListaProductosEntradaCuotaMontoCuota() {
        return new RespuestaServipagVida.ListaProductos.Entrada.Cuota.MontoCuota();
    }

    /**
     * Create an instance of {@link InformePago.PagoExitoso.Convenio }
     *
     */
    public InformePago.PagoExitoso.Convenio createInformePagoPagoExitosoConvenio() {
        return new InformePago.PagoExitoso.Convenio();
    }

    /**
     * Create an instance of {@link InformePago.PagoExitoso.ProductosPorPagar.TotalPorPagar }
     *
     */
    public InformePago.PagoExitoso.ProductosPorPagar.TotalPorPagar createInformePagoPagoExitosoProductosPorPagarTotalPorPagar() {
        return new InformePago.PagoExitoso.ProductosPorPagar.TotalPorPagar();
    }

    /**
     * Create an instance of {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada.Producto }
     *
     */
    public InformePago.PagoExitoso.ProductosPorPagar.Entrada.Producto createInformePagoPagoExitosoProductosPorPagarEntradaProducto() {
        return new InformePago.PagoExitoso.ProductosPorPagar.Entrada.Producto();
    }

    /**
     * Create an instance of {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota.Monto }
     *
     */
    public InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota.Monto createInformePagoPagoExitosoProductosPorPagarEntradaCuotaMonto() {
        return new InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota.Monto();
    }

    /**
     * Create an instance of {@link ComprobantePagoCaja.ProductosPagados.TotalPagado }
     *
     */
    public ComprobantePagoCaja.ProductosPagados.TotalPagado createComprobantePagoCajaProductosPagadosTotalPagado() {
        return new ComprobantePagoCaja.ProductosPagados.TotalPagado();
    }

    /**
     * Create an instance of {@link ComprobantePagoCaja.ProductosPagados.Entrada.Cuota }
     *
     */
    public ComprobantePagoCaja.ProductosPagados.Entrada.Cuota createComprobantePagoCajaProductosPagadosEntradaCuota() {
        return new ComprobantePagoCaja.ProductosPagados.Entrada.Cuota();
    }

    /**
     * Create an instance of {@link ResumenConHeader.Convenios.Convenio }
     *
     */
    public ResumenConHeader.Convenios.Convenio createResumenConHeaderConveniosConvenio() {
        return new ResumenConHeader.Convenios.Convenio();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPagados.Entrada.Producto }
     *
     */
    public ResumenConHeader.ProductosPagados.Entrada.Producto createResumenConHeaderProductosPagadosEntradaProducto() {
        return new ResumenConHeader.ProductosPagados.Entrada.Producto();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaVariable }
     *
     */
    public ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaVariable createResumenConHeaderProductosPagadosEntradaCuotaCuotaVariable() {
        return new ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaVariable();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaOpcion }
     *
     */
    public ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaOpcion createResumenConHeaderProductosPagadosEntradaCuotaCuotaOpcion() {
        return new ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaOpcion();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPorPagar.Entrada.Producto }
     *
     */
    public ResumenConHeader.ProductosPorPagar.Entrada.Producto createResumenConHeaderProductosPorPagarEntradaProducto() {
        return new ResumenConHeader.ProductosPorPagar.Entrada.Producto();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.InfoPA }
     *
     */
    public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.InfoPA createResumenConHeaderProductosPorPagarEntradaCuotaInfoPA() {
        return new ResumenConHeader.ProductosPorPagar.Entrada.Cuota.InfoPA();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaVariable }
     *
     */
    public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaVariable createResumenConHeaderProductosPorPagarEntradaCuotaCuotaVariable() {
        return new ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaVariable();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMin }
     *
     */
    public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMin createResumenConHeaderProductosPorPagarEntradaCuotaCuotaOpcionCuotaMin() {
        return new ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMin();
    }

    /**
     * Create an instance of {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMax }
     *
     */
    public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMax createResumenConHeaderProductosPorPagarEntradaCuotaCuotaOpcionCuotaMax() {
        return new ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMax();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "Respuesta", defaultValue = "OK")
    public JAXBElement<String> createRespuesta(String value) {
        return new JAXBElement<String>(_Respuesta_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "XML")
    public JAXBElement<String> createXML(String value) {
        return new JAXBElement<String>(_XML_QNAME, String.class, null, value);
    }

}
