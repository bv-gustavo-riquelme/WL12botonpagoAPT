package cl.bicevida.botonpago.servicio;

import cl.bice.vida.botonpago.common.comparator.BpiDitribFondosAPVTblComparator;
import cl.bice.vida.botonpago.common.dto.general.BpiDitribFondosAPVTbl;
import cl.bice.vida.botonpago.common.dto.general.BpiDnaDetnavegTbl;
import cl.bice.vida.botonpago.common.dto.general.BpiTraTransaccionesTbl;
import cl.bice.vida.botonpago.common.dto.general.DetalleAPV;
import cl.bice.vida.botonpago.common.dto.general.ResumenRequest;
import cl.bice.vida.botonpago.common.util.FechaUtil;
import cl.bice.vida.botonpago.common.util.NumeroUtil;
import cl.bice.vida.botonpago.common.util.StringUtil;
import cl.bice.vida.botonpago.common.vo.ResultadoConsultaVO;
import cl.bice.vida.botonpago.modelo.dao.DAOFactory;

import cl.bice.vida.botonpago.modelo.dto.PersonaDto;
import cl.bice.vida.botonpago.modelo.ejb.MedioPagoElectronicoEJB;

import cl.bicevida.botonpago.exception.ServiceLocatorException;


import cl.bice.vida.botonpago.servicios.cliente.SessionEJBDatosClienteWebService;
import cl.bice.vida.botonpago.servicios.cliente.SessionEJBDatosClienteWebServiceService;
import cl.bice.vida.botonpago.servicios.cliente.types.ResponseVODTO;

import cl.bicevida.botonpago.util.ResourcePropertiesUtil;

import cl.bicevida.botonpago.core.PagoPublicoCore;
import cl.bicevida.botonpago.exception.ConsultaComprobanteException;
import cl.bicevida.botonpago.exception.ConsultaDeudaException;
import cl.bicevida.botonpago.exception.PagoPublicoCoreException;


import cl.bicevida.botonpago.util.EmailUtil;
import cl.bicevida.botonpago.util.FacesUtil;
import cl.bicevida.botonpago.util.ResourceMessageUtil;
import cl.bicevida.botonpago.util.RutUtil;
import cl.bicevida.botonpago.vo.apt.PagoBancoInfoVo;
import cl.bicevida.botonpago.vo.apt.PagoDetalleCuotaVO;
import cl.bicevida.botonpago.vo.apt.PagoPublicoVO;


import cl.bicevida.botonpago.vo.apt.PagoRutasFilesVO;
import cl.bicevida.botonpago.vo.out.OutMensaje;
import cl.bicevida.botonpago.ws.cuentainversion.CuentaDeInversionWebService;
import cl.bicevida.botonpago.ws.cuentainversion.CuentaDeInversionWebService_Service;
import cl.bicevida.botonpago.ws.cuentainversion.types.ConsultaSaldosYFondosResponse;
import cl.bicevida.botonpago.ws.cuentainversion.types.DetalleColor;
import cl.bicevida.botonpago.ws.cuentainversion.types.FondoW;
import cl.bicevida.botonpago.ws.cuentainversion.types.FondoPorcentaje;
import cl.bicevida.botonpago.ws.cuentainversion.types.GrabarDistribucionFondosAporteExtraordinarioReg;
import cl.bicevida.botonpago.ws.cuentainversion.types.RetGrabadoDistFondo;

import java.io.Serializable;

import java.net.URL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.ws.rs.core.Context;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import org.codehaus.jackson.map.ObjectMapper;

public class LogicaServicio implements Serializable {

    private static final Logger logger = Logger.getLogger(LogicaServicio.class);

    public static final int CANAL_BOTON_PAGO_PERFILADO = 1;
    public static final int CANAL_BOTON_PAGO_PUBLICO = 2;
    public static final int CANAL_BOTON_PAGO_APV_EXTRAORDINARIO = 3;
    public static final int CANAL_BOTON_PAGO_PUBLICO_PRIMERA_PRIMA = 4;

    public static final int TPOTRX_NORMAL = 1;
    public static final int TPOTRX_APORTEEXTRAORDINARIO = 2;

    //@Context ServletContext context;
    //@Context HttpServletRequest request;

    public LogicaServicio() {
        super();
    }

    public static PagoPublicoVO findDeudaCliente(Integer rut) throws Exception {
        logger.info("findDeudaCliente(Integer rut=" + rut + ") - iniciando");

        PagoPublicoVO pagoAPT = new PagoPublicoVO();
        //Consulta EJB
        String xmlRespuesta;
        try {
            xmlRespuesta = consultaDeudas(rut);
            logger.info("xmlrespuesta: " + xmlRespuesta);
            if (xmlRespuesta != null) {
                if (xmlRespuesta.startsWith("NOK")) {
                    //Data Error propio del EJB
                    String mensajerror = xmlRespuesta;
                    if (xmlRespuesta.startsWith("NOK"))
                        mensajerror = xmlRespuesta.substring(4);

                    pagoAPT.setMensajeRespuesta(mensajerror);
                    pagoAPT.setEstado(false);
                    pagoAPT.setCodRespuesta(01); //codigo error general
                    return pagoAPT;
                } else {
                    //PagoPublicoAPT
                    //Consulta informacion de usuario deudas y datos basicos
                    pagoAPT = PagoPublicoCore.getXMLParaPagosPendientes(xmlRespuesta);

                    pagoAPT.setTipoTransaccion(TPOTRX_APORTEEXTRAORDINARIO);
                    pagoAPT.setValormaxaporte(DAOFactory.getPersistenciaGeneralDao().getValorMaximoAporteExtraAPV());
                    pagoAPT.setPorcentajeCobroTarjeta(0.0);
                    pagoAPT.setMensajeRespuesta("OK");
                    pagoAPT.setCodRespuesta(0);
                    pagoAPT.setEstado(Boolean.TRUE);
                    pagoAPT.setFechaAccesoUsuario(StringUtil.toTitleCase(FechaUtil.getFechaFormateoCustom(new java.util.Date(System.currentTimeMillis()),
                                                                                                          "dd' de 'MMMM' del 'yyyy HH:mm"),
                                                                         " ") + " horas");
                }
            } else {
                pagoAPT.setEstado(Boolean.FALSE);
                pagoAPT.setMensajeRespuesta(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.ejb.nodata"));
                pagoAPT.setCodRespuesta(01); //error general
                return pagoAPT;
            }
        } catch (PagoPublicoCoreException ec) {
            throw new Exception(ec.getMessage());

        } catch (ConsultaDeudaException ed) {
            throw new Exception(ed.getMessage());
        }
        logger.info("findDeudaCliente(String rut=" + rut + ") - termina");
        return pagoAPT;
    }

    private static String consultaDeudas(Integer rut) throws ConsultaDeudaException {
        logger.info("consultaDeudas(Integer rut=" + rut + ") - iniciando");
        String xml = null;
        String nombreusuario = null;
        try {
            PersonaDto persona = DAOFactory.getConsultasDao().findPersonaByRut(rut);

            if (persona != null) {
                nombreusuario = persona.getNombre();
                logger.info("=====> CONSULTANDO EJB RESUMEN Y PAGO!");
                xml =
                    DAOFactory.getLogicaResumenPagosDao().crearResumenPagosAPVAPT(rut, nombreusuario, null,
                                                                                  CANAL_BOTON_PAGO_APV_EXTRAORDINARIO);
            }

            logger.info("consultaDeudas(Integer rut=" + rut + ") - termina");
        } catch (ServiceLocatorException e) {
            logger.error(e.getMessage());
            throw new ConsultaDeudaException(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.ejb"));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new ConsultaDeudaException(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.logica"));
        }
        logger.info("xml " + xml);
        return xml;
    }

    public static PagoPublicoVO doDistribuirProducto(PagoPublicoVO pagoPublico) throws Exception {
        PagoPublicoVO pago = new PagoPublicoVO();
        Map paramvalore = null;

        try {
            if (pagoPublico.getTotalPagar() == null || pagoPublico.getTotalPagar() == 0) {

                throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.min"));
            } else if (pagoPublico.getIdNavegacion() == 0) {
                throw new Exception(ResourceMessageUtil.getProperty("ERROR: No se encuentra id de navegacion"));
            }
            pagoPublico = PagoPublicoCore.llenaLinked(pagoPublico);
            ResumenRequest reqConfirmado =
                PagoPublicoCore.getRequerimientoConfirmaPagoSeleccionadoAPT(pagoPublico, 0, paramvalore);

            Double maxaporte = new Double(pagoPublico.getValormaxaporte());
            if (reqConfirmado != null && reqConfirmado.getProductosSeleccionados().length > 0) {
                if (pagoPublico.getTotalPagar() != null && pagoPublico.getTotalPagar().doubleValue() > 0.0) {
                    if (pagoPublico.getTotalPagar().doubleValue() <= maxaporte.doubleValue()) {
                        //Verificaci�n de existencia de aporte en caso de tener distribucion
                        boolean existeaporte = false;
                        for (int counter = 1; counter <= pagoPublico.getHashcuotas().size(); counter++) {
                            PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO) pagoPublico.getHashcuotas().get(counter);
                            if (vCuota != null && vCuota.getNumeroProducto() != 0) {
                                if (vCuota.isDistribucion()) {
                                    existeaporte = true;
                                    break;
                                }
                            }
                        }

                        //DETERMINA SI SE PASA A LA ETAPA DE DISTRIBUIR LOS FONDOS
                        if (existeaporte) {
                            pago = getDetalleDistribucionAporte(pagoPublico);
                        } else {
                            //CONSULTA % DE DISTRIBUCION POR DEFECTO Y APLICA LA DISTRIBUCI�N
                            pago = ConsultaDistDefectoyGeneraDistribucion(pagoPublico);

                        }

                    } else {
                        throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.max.1") +
                                            NumeroUtil.formatMilesNoDecimal(pagoPublico.getValormaxaporte()) +
                                            ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.max.2"));
                    }
                } else {
                    throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.min"));
                }
            } else {
                throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.seleccioneproducto"));
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return pago;
    }

    private static PagoPublicoVO ConsultaDistDefectoyGeneraDistribucion(PagoPublicoVO pagoPublico) throws Exception {
        ResumenRequest reqConfirmado = new ResumenRequest();
        pagoPublico = PagoPublicoCore.llenaLinked(pagoPublico);
        reqConfirmado = PagoPublicoCore.getRequerimientoConfirmaPagoSeleccionadoAPT(pagoPublico, 0, null);
        PagoDetalleCuotaVO producto = null;
        double montoTotalDistribuido = 0;
        List<FondoPorcentaje> fondosDistribuidos = new ArrayList<FondoPorcentaje>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            //INICIA SERVICIO DE APORTE EXTRAORDINARIO
            URL url =
                new URL(cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.bice.aptcuentainversion.endpointAPT"));
            CuentaDeInversionWebService_Service wsAPV = new CuentaDeInversionWebService_Service(url);
            CuentaDeInversionWebService iCI = wsAPV.getCuentaDeInversionWebServicePort();

            //EXTRAE LOS DATOS DE LA CUOTA A PAGAR
            for (int counter = 1; counter <= pagoPublico.getHashcuotasl().size(); counter++) {
                //PagoDetalleCuotaVO vCuota = mapper.convertValue(pagoPublico.getHashcuotas().get(""+counter), PagoDetalleCuotaVO.class);
                PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO) pagoPublico.getHashcuotasl().get(counter);
                if (vCuota != null && vCuota.getNumeroProducto() != 0) {
                    if (vCuota.isSelecionado()) {
                        producto = vCuota;
                        break;
                    }
                }
            }

            if (producto != null) {

                //CONSULTA SERVICIO WEB PARA CONSULTAR DEL DETALLE DE DISTRIBUCION
                ConsultaSaldosYFondosResponse resp = new ConsultaSaldosYFondosResponse();
                resp.setReturn(iCI.consultaSaldosYFondos(Integer.toString(producto.getNumeroRamo()),
                                                         Integer.toString(producto.getNumeroProducto()),
                                                         Integer.toString(pagoPublico.getDatosCliente().getRutCliente())));


                if (!resp.getReturn().getRut().equals("none")) {

                    List<FondoW> fondos = resp.getReturn().getFondos();

                    //if (vectFondos != null && vectFondos.getItem().length > 0) {
                    if (fondos != null && fondos.size() > 0) {
                        //RECUPERA FONDOS
                        List<BpiDitribFondosAPVTbl> dtosDistrib = new ArrayList();
                        //FondoW[] fondos = vectFondos.getItem();

                        //CREA LISTA DE VALORES A DISTRIBUIR
                        producto.setDistribucionFondos(null);

                        //ITERO
                        //for (int pox = 0; pox < fondos.length; pox++) {
                        for (FondoW fondo : fondos) {
                            String montoInicial = NumeroUtil.redondear(fondo.getMonto(), 0);
                            //SE  CONFECCIONA NUEVO OBJETO CON LOS VALORES
                            BpiDitribFondosAPVTbl dtoDistOnly = new BpiDitribFondosAPVTbl();

                            DetalleColor Color = fondo.getDetalleColor();

                            //dtoDistOnly.setColor(fondos[pox].getDetalleColor());
                            dtoDistOnly.setHexadecimal(Color.getHexadecimal());
                            dtoDistOnly.setValorColorX(Color.getValorColorX());
                            dtoDistOnly.setValorColorY(Color.getValorColorY());
                            dtoDistOnly.setValorColorZ(Color.getValorColorZ());

                            dtoDistOnly.setFolio(0); //ESTE FOLIO ES PARA LA CAJA CUANDO SE PAGUE LA TRANSACCION
                            dtoDistOnly.setIdAporte(0); //NO GRABADO SE SETEA CUANTO ESTA OK
                            dtoDistOnly.setIdFondo(fondo.getIdFondo());
                            dtoDistOnly.setIdTransaccion(pagoPublico.getIdTransaccion());
                            dtoDistOnly.setSaldoInicial(Double.parseDouble(montoInicial));
                            dtoDistOnly.setNombreFondo(fondo.getNombreFondo());
                            dtoDistOnly.setOrdenPresentacion(fondo.getOrdenPresentacion());
                            dtoDistOnly.setPoliza(producto.getNumeroProducto());
                            dtoDistOnly.setPorcentaje(fondo.getPorcentaje());
                            dtoDistOnly.setPorcentajemostrar(fondo.getPorcentaje());
                            dtoDistOnly.setRamo(producto.getNumeroRamo());
                            dtoDistOnly.setLinkPDF(fondo.getLinkPDF());
                            dtoDistOnly.setRutCliente(pagoPublico.getDatosCliente().getRutCliente());

                            dtoDistOnly.setColor(fondo.getRiesgo());

                            //CALCULA EL MONTO DE DINERO POR CADA PORCENTAJE
                            Double montoDisp =
                                new Double(producto.getTotalCuota().doubleValue() *
                                           (dtoDistOnly.getPorcentaje().doubleValue() / 100));
                            dtoDistOnly.setMonto(montoDisp);

                            //AGREGA ITEM
                            dtosDistrib.add(dtoDistOnly);
                        }

                        //SORTEA UN ORDENAMIENTO DE LA LISTA MEDIANTE COMPARATOR
                        Collections.sort(dtosDistrib, new BpiDitribFondosAPVTblComparator());

                        //SETEO LISTA DE DTOS DISTRIBUCION
                        producto.setDistribucionFondos(dtosDistrib);

                        //SETEO OBJETO QUE CONTIENE EL O LOS PRODUCTOS
                        //Hashtable hash = new Hashtable();
                        LinkedHashMap hash = new LinkedHashMap();
                        for (int i = 1; i <= pagoPublico.getHashcuotasl().size(); i++) {
                            //PagoDetalleCuotaVO vCuota = mapper.convertValue(pagoPublico.getHashcuotas().get(""+counter), PagoDetalleCuotaVO.class);
                            PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO) pagoPublico.getHashcuotasl().get(i);
                            if (vCuota != null) {
                                if (vCuota.isSelecionado() && vCuota.getIdCuota() == producto.getIdCuota()) {
                                    vCuota = producto;
                                }
                                hash.put(new Integer(vCuota.getIdCuota()), vCuota);
                            }
                        }
                        pagoPublico.setHashcuotasl(hash);


                        //GRABA LA DISTRIBUCION
                        if (producto != null) {
                            List<BpiDitribFondosAPVTbl> fondosAsignados = producto.getDistribucionFondos();
                            if (fondosAsignados != null) {
                                List<FondoPorcentaje> conAsignacion = new ArrayList<FondoPorcentaje>();
                                Iterator fonds = fondosAsignados.iterator();
                                while (fonds.hasNext()) {
                                    FondoPorcentaje dtoDist = new FondoPorcentaje();
                                    BpiDitribFondosAPVTbl dtoFondo = (BpiDitribFondosAPVTbl) fonds.next();
                                    dtoDist.setIdFondo(dtoFondo.getIdFondo() + "");
                                    dtoDist.setPorcentaje(dtoFondo.getPorcentaje() + "");

                                    //AGREGA
                                    if (dtoFondo.getMonto().doubleValue() > 0 &&
                                        dtoFondo.getPorcentaje().intValue() > 0) {
                                        conAsignacion.add(dtoDist);
                                        montoTotalDistribuido =
                                            montoTotalDistribuido + dtoFondo.getMonto().doubleValue();
                                    }
                                }

                                //ASIGNA DATA
                                List<FondoPorcentaje> fondosP = new ArrayList<FondoPorcentaje>();
                                for (FondoPorcentaje fondo : conAsignacion) {
                                    fondosP.add(fondo);
                                }
                                fondosDistribuidos.addAll(fondosP);
                            }
                        }

                        //GRABAR LOS PRODUCTOS DISTRIBUIDOS EN APV SEGUN SERVICIO WEB

                        //GRABA LOS DATOS Y RECUPERA EL ID DE DISTRIBUCION
                        String newRegimen = "" + producto.getRegimenTributario();
                        RetGrabadoDistFondo resultado =
                            iCI.grabarDistribucionFondosAporteExtraordinarioReg(Integer.toString(producto.getNumeroRamo()),
                                                                                Integer.toString(producto.getNumeroProducto()),
                                                                                Integer.toString(pagoPublico.getDatosCliente().getRutCliente()),
                                                                                "SV", montoTotalDistribuido,
                                                                                fondosDistribuidos, newRegimen);

                        //EVALUA LA RESPUESTA FINAL DE LA GRABACION DE DATOS
                        if (resultado != null && resultado.getCodigoRespuesta().equals("0")) {

                            //RECUPERO EL ID DE DISTRIBUCION
                            String idDistribucion = resultado.getIdDistribucion();
                            producto.setIdAporte(new Integer(idDistribucion));
                            producto.setResultadoDistribucion(0);

                            //GRABAR DATOS EN LA BASE DE PAGOS ELECTRONICO WEB
                            // MedioPagoElectronicoEJB ejb = ServiceLocator.getMedioPagoElectronicoEJB();
                            boolean grabo =
                                DAOFactory.getDistribucionFondosDao().grabarDistribucionFondosAPVProducto(producto.getIdAporte(),
                                                                                                          producto.getDistribucionFondos(),
                                                                                                          producto.getRegimenTributario(),
                                                                                                          producto.getDescripcionRegimen());

                            //VERIFICA GRABACION EN BASE DE DATOS
                            if (grabo) {

                                //BUSCAR CUOTAS DE PAGO PUBLICO Y SETEAR EL NUEVO APORTE REALIZADO
                                //Hashtable cuotasUpdate = new Hashtable();
                                LinkedHashMap cuotasUpdate = new LinkedHashMap();
                                for (int counter = 1; counter <= pagoPublico.getHashcuotasl().size();
                                     counter++) {
                                    //PagoDetalleCuotaVO vCuota = mapper.convertValue(pagoPublico.getHashcuotas().get(""+counter), PagoDetalleCuotaVO.class);
                                    PagoDetalleCuotaVO vCuota =
                                                                               (PagoDetalleCuotaVO) pagoPublico.getHashcuotasl().get(counter);
                                    if (vCuota != null) {
                                        if (vCuota.getIdCuota() == producto.getIdCuota()) {
                                            vCuota = producto;
                                        }
                                        cuotasUpdate.put(new Integer(vCuota.getIdCuota()), vCuota);
                                    }
                                }


                                //SETEA LA NUEVA LISTA DE CUOTAS ACTUALIZADAS EN SU REVISION DE DISTRIBUCION APV
                                pagoPublico.setHashcuotasl(cuotasUpdate);
                                return pagoPublico;

                            } else {
                                //pagoPublico.setMensajeRespuesta(ResourceMessageUtil.getProperty("jsf.pagopublico.apv.mensajes.informativos.errores.grabar.db"));
                                throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.apv.mensajes.informativos.errores.grabar.db"));
                            }

                        } else {
                            String msgerror = "";
                            if (resultado != null)
                                msgerror = resultado.getMensajeRespuesta();
                            throw new Exception(msgerror);
                            /*pagoPublico.setMensajeRespuesta(msgerror);
                            pagoPublico.setEstado(false);
                            pagoPublico.setCodRespuesta(1);
                            return pagoPublico;*/
                        }
                    } else {
                        throw new Exception("No se encontraron fondos para distribuir en esta poliza, pruebe con otra poliza");
                        /*pagoPublico.setMensajeRespuesta("No se encontraron fondos para distribuir en esta poliza, pruebe con otra poliza");
                        pagoPublico.setEstado(false);
                        pagoPublico.setCodRespuesta(1);
                        return pagoPublico;*/
                    }
                } else {
                    throw new Exception("No se encontraron fondos para distribuir en esta poliza, pruebe con otra poliza");
                    /*pagoPublico.setMensajeRespuesta("No se encontraron fondos para distribuir en esta poliza, pruebe con otra poliza");
                    pagoPublico.setEstado(false);
                    pagoPublico.setCodRespuesta(1);
                    return pagoPublico;*/
                }
            } else {
                throw new Exception("Debe seleccionar una poliza a distribuir sus fondos");
                /*pagoPublico.setMensajeRespuesta("Debe seleccionar una poliza a distribuir sus fondos");
                pagoPublico.setEstado(false);
                pagoPublico.setCodRespuesta(1);
                return pagoPublico;*/
            }
        } catch (Exception e) {
            //pagoPublico.setMensajeRespuesta(ResourceMessageUtil.getProperty("jsf.pagopublico.apv.mensajes.informativos.errores.servicio.nodisponible"));
            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.apv.mensajes.informativos.errores.servicio.nodisponible"));

        }
        //return pagoPublico;
    }

    private static PagoPublicoVO getDetalleDistribucionAporte(PagoPublicoVO pagoPublico) throws Exception {
        logger.info("getHtmDetalleAporte() - iniciando");
        PagoDetalleCuotaVO producto = null;
        boolean rehacer = false;
        ObjectMapper mapper = new ObjectMapper();
        pagoPublico = PagoPublicoCore.llenaLinked(pagoPublico);
        int numcuotas = pagoPublico.getHashcuotasl().size();
        for (int counter = 1; counter <= numcuotas; counter++) {
            //PagoDetalleCuotaVO vCuota = mapper.convertValue(pagoPublico.getHashcuotas().get(""+counter), PagoDetalleCuotaVO.class);
            PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO) pagoPublico.getHashcuotasl().get(counter);
            if (vCuota.isSelecionado()) {
                //producto = (PagoDetalleCuotaVO) FacesUtil.getSession().getAttribute("DistribucionProductoAPV_"+vCuota.getIdCuota());
                producto = vCuota;
                break;
            }
        }

        try {
            URL url =
                new URL(ResourcePropertiesUtil.getProperty("bice.webservices.client.bice.aptcuentainversion.endpointAPT"));
            CuentaDeInversionWebService_Service wsAPV = new CuentaDeInversionWebService_Service(url);
            CuentaDeInversionWebService iCI = wsAPV.getCuentaDeInversionWebServicePort();

            //EN CASO DE NO EXISTIR SE CONFECCIONA
            if (producto == null) {
                for (int counter = 1; counter <= pagoPublico.getHashcuotasl().size(); counter++) {
                    //PagoDetalleCuotaVO vCuota = mapper.convertValue(pagoPublico.getHashcuotas().get(""+counter), PagoDetalleCuotaVO.class);
                    PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO) pagoPublico.getHashcuotasl().get(counter);
                    if (vCuota.isSelecionado()) {
                        producto = vCuota;
                        break;
                    }
                }
                rehacer = true;
            }

            if (producto != null) {

                //CONSULTA SERVICIO WEB PARA CONSULTAR DEL DETALLE DE DISTRIBUCION
                ConsultaSaldosYFondosResponse resp = new ConsultaSaldosYFondosResponse();
                resp.setReturn(iCI.consultaSaldosYFondos(Integer.toString(producto.getNumeroRamo()),
                                                         Integer.toString(producto.getNumeroProducto()),
                                                         Integer.toString(pagoPublico.getDatosCliente().getRutCliente())));

                if (!resp.getReturn().getRut().equals("none")) {

                    List<FondoW> vectFondos = resp.getReturn().getFondos();

                    if (vectFondos != null && vectFondos.size() > 0) {
                        //RECUPERA FONDOS
                        List<BpiDitribFondosAPVTbl> dtosDistrib = new ArrayList<BpiDitribFondosAPVTbl>();

                        //EN EL CASO DE NO EXISTIR DISTRIBUCION SE CONFECCIONA UNA DE CERO
                        // VUELTA ATRAS
                        if (rehacer == false) {

                            //CREA LISTA DE VALORES A DISTRIBUIR
                            producto.setDistribucionFondos(null);

                            //for(Fondo fondo: fondos) {
                            for (FondoW fondo : vectFondos) {
                                String montoInicial = NumeroUtil.redondear(fondo.getMonto(), 0);
                                //SE  CONFECCIONA NUEVO OBJETO CON LOS VALORES
                                BpiDitribFondosAPVTbl dtoDistOnly = new BpiDitribFondosAPVTbl();
                                dtoDistOnly.setColor(fondo.getRiesgo()); //ATRIBUTO RIESGO WL ; ATRIBUTO COLOR TUCANA
                                dtoDistOnly.setFolio(0); //ESTE FOLIO ES PARA LA CAJA CUANDO SE PAGUE LA TRANSACCION
                                dtoDistOnly.setIdAporte(0); //NO GRABADO SE SETEA CUANTO ESTA OK
                                dtoDistOnly.setIdFondo(fondo.getIdFondo());
                                dtoDistOnly.setIdTransaccion(pagoPublico.getIdTransaccion());
                                dtoDistOnly.setSaldoInicial(Double.parseDouble(montoInicial));
                                dtoDistOnly.setMonto(new Double(0));
                                dtoDistOnly.setNombreFondo(fondo.getNombreFondo());
                                dtoDistOnly.setOrdenPresentacion(fondo.getOrdenPresentacion());
                                dtoDistOnly.setPoliza(producto.getNumeroProducto());
                                dtoDistOnly.setPorcentaje(0);
                                dtoDistOnly.setPorcentajemostrar(fondo.getPorcentaje());
                                dtoDistOnly.setRamo(producto.getNumeroRamo());
                                dtoDistOnly.setLinkPDF(fondo.getLinkPDF());
                                dtoDistOnly.setRutCliente(pagoPublico.getDatosCliente().getRutCliente());


                                //AGREGA ITEM
                                dtosDistrib.add(dtoDistOnly);
                            }

                            //SORTEA UN ORDENAMIENTO DE LA LISTA MEDIANTE COMPARATOR
                            Collections.sort(dtosDistrib, new BpiDitribFondosAPVTblComparator());

                            //SETEO LISTA DE DTOS DISTRIBUCION
                            producto.setDistribucionFondos(dtosDistrib);
                            //Hashtable cuotasUpdate = new Hashtable();
                            LinkedHashMap cuotasUpdate = new LinkedHashMap();
                            for (int i = 1; i <= pagoPublico.getHashcuotasl().size(); i++) {
                                //PagoDetalleCuotaVO vCuota = mapper.convertValue(pagoPublico.getHashcuotas().get(""+i), PagoDetalleCuotaVO.class);
                                PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO) pagoPublico.getHashcuotasl().get(i);
                                if (vCuota != null) {
                                    if (vCuota.getIdCuota() == producto.getIdCuota()) {
                                        vCuota = producto;

                                    }
                                    cuotasUpdate.put(new Integer(vCuota.getIdCuota()), vCuota);
                                }

                            }
                            pagoPublico.setHashcuotasl(cuotasUpdate);
                        } else {
                            //YA EXISTEN Y ESTAN ORDENADOS SOLO RECALCULAR MONTO EN BASE A SU PORCENTAJE
                            //DEL MONTO QUE SE HA ENVIADO
                            //dtosDistrib = producto.getDistribucionFondos();
                            //Hashtable cuotasUpdate = new Hashtable();
                            LinkedHashMap cuotasUpdate = new LinkedHashMap();
                            for (int i = 1; i <= pagoPublico.getHashcuotasl().size(); i++) {
                                //PagoDetalleCuotaVO vCuota = mapper.convertValue(pagoPublico.getHashcuotas().get(""+i), PagoDetalleCuotaVO.class);
                                PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO) pagoPublico.getHashcuotasl().get(i);
                                if (vCuota != null) {
                                    if (vCuota.getIdCuota() == producto.getIdCuota()) {
                                        vCuota = producto;
                                    }
                                    cuotasUpdate.put(new Integer(vCuota.getIdCuota()), vCuota);
                                }

                            }
                            pagoPublico.setHashcuotasl(cuotasUpdate);
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.apv.mensajes.informativos.errores.servicio.nodisponible"));
        }
        logger.info("getHtmDetalleAporte() - termina");
        return pagoPublico;
    }

    public static PagoPublicoVO doConfirmarDistribucion(PagoPublicoVO pagoPublico) throws Exception {
        try {
            if (pagoPublico.getIdNavegacion() == 0) {
                throw new Exception("ERROR: No existe ID navegacion");

            } else if (pagoPublico.getXmloriginal() == null || "".equals(pagoPublico.getXmloriginal())) {
                //pagoPublico.setMensajeRespuesta("ERROR: Debe ingresar XML original");
                throw new Exception("ERROR: Debe ingresar XML original");
            } else if (pagoPublico.getAccion() != null && "volver".equals(pagoPublico.getAccion())) {
                //VUELVE A BUSCAR
                pagoPublico.setXmloriginal(null);
                pagoPublico.setXmlconfirmacion(null);
                pagoPublico.setXmlconfirmacionDataBancos(null);
                pagoPublico.setXmlpagopublico(null);
                pagoPublico = findDeudaCliente(Integer.valueOf(pagoPublico.getDatosCliente().getRutCliente()));
                return pagoPublico;
            }


            pagoPublico = PagoPublicoCore.llenaLinked(pagoPublico);
            URL url =
                new URL(ResourcePropertiesUtil.getProperty("bice.webservices.client.bice.aptcuentainversion.endpointAPT"));
            CuentaDeInversionWebService_Service wsAPV = new CuentaDeInversionWebService_Service(url);
            CuentaDeInversionWebService iCI = wsAPV.getCuentaDeInversionWebServicePort();

            ObjectMapper mapper = new ObjectMapper();
            List<FondoPorcentaje> fondosDistribuidos = new ArrayList<FondoPorcentaje>();
            PagoDetalleCuotaVO producto = null;

            int numcuotas = pagoPublico.getHashcuotasl().size();
            for (int counter = 1; counter <= numcuotas;
                 counter++) {
                //PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO)pagoPublico.getHashcuotas().get(counter);
                PagoDetalleCuotaVO vCuota =
                                       mapper.convertValue(pagoPublico.getHashcuotasl().get(counter),
                                                           PagoDetalleCuotaVO.class);
                if (vCuota != null) {
                    if (vCuota.isSelecionado()) {
                        producto =
                            vCuota; //(PagoDetalleCuotaVO) FacesUtil.getSession().getAttribute("DistribucionProductoAPV_"+vCuota.getIdCuota());
                        break;
                    }
                }
            }
            double montoTotalDistribuido = 0;
            Double totaldistribuido = new Double("0");
            //String montodistribuir = FacesUtil.getRequestParameterValue("montodistribuir") ;
            long montodistribuir = Math.round(Double.parseDouble(producto.getTotalCuota().toString()));
            String monto = NumeroUtil.removeSeparadoresDeMiles(Long.toString(montodistribuir));
            montodistribuir = Long.parseLong(monto);

            if (producto != null) {
                List<BpiDitribFondosAPVTbl> fondosAsignar = producto.getDistribucionFondos();
                List<BpiDitribFondosAPVTbl> fondosOk = new ArrayList<BpiDitribFondosAPVTbl>();
                if (fondosAsignar != null) {
                    Iterator fonds = fondosAsignar.iterator();
                    while (fonds.hasNext()) {
                        BpiDitribFondosAPVTbl dtoFondo = (BpiDitribFondosAPVTbl) fonds.next();

                        Long precioSinPunto = Math.round(Double.parseDouble(dtoFondo.getMonto().toString()));
                        Long porcentajeSinPunto = Math.round(Double.parseDouble(dtoFondo.getPorcentaje().toString()));
                        String precio = precioSinPunto.toString();
                        String procentaje = porcentajeSinPunto.toString();

                        /*String precio = FacesUtil.getRequestParameterValue("precio_"+ dtoFondo.getIdFondo()) ;
                         String procentaje = FacesUtil.getRequestParameterValue("porcentaje_"+ dtoFondo.getIdFondo()) ;*/

                        precio = NumeroUtil.removeSeparadoresDeMiles(precio);
                        procentaje = NumeroUtil.removeSeparadoresDeMiles(procentaje);

                        dtoFondo.setMonto(new Double(precio));
                        dtoFondo.setPorcentaje(new Integer(procentaje));
                        fondosOk.add(dtoFondo);
                        totaldistribuido = totaldistribuido + dtoFondo.getMonto();

                    }

                    //SORTEA UN ORDENAMIENTO DE LA LISTA MEDIANTE COMPARATOR
                    Collections.sort(fondosOk, new BpiDitribFondosAPVTblComparator());

                    //SE SUBE EL PRODUCTO A SESSION
                    producto.setDistribucionFondos(fondosOk);
                    producto.setMontototaldistribucion(totaldistribuido);

                    //Hashtable cuotasUpdate = new Hashtable();
                    LinkedHashMap cuotasUpdate = new LinkedHashMap();
                    for (int i = 1; i <= pagoPublico.getHashcuotas().size(); i++) {
                        PagoDetalleCuotaVO vCuota =
                            mapper.convertValue(pagoPublico.getHashcuotasl().get(i), PagoDetalleCuotaVO.class);
                        //PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO)pagoPublico.getHashcuotas().get(i);
                        if (vCuota != null) {
                            if (vCuota.getIdCuota() == producto.getIdCuota()) {
                                vCuota = producto;
                            }
                            cuotasUpdate.put(new Integer(vCuota.getIdCuota()), vCuota);
                        }
                    }
                    pagoPublico.setHashcuotasl(cuotasUpdate);

                    //FacesUtil.getSession().setAttribute("DistribucionProductoAPV_"+producto.getIdCuota(), producto);
                }

            }

            //COMPARA QUE HAYA UNA DISTRIBUCION DEL 100%
            //if (Long.parseLong(montodistribuir) == totaldistribuido) {
            if (montodistribuir == totaldistribuido) {
                //VALIDACION DE CLAVE DE ACCESO
                try {
                    //AQUI ALMACENAR TODA LA INFORMACION DE DISTRIBUCION
                    //producto = (PagoDetalleCuotaVO) FacesUtil.getSession().getAttribute("DistribucionProductoAPV_"+producto.getIdCuota());
                    if (producto != null) {
                        List<BpiDitribFondosAPVTbl> fondosAsignados = producto.getDistribucionFondos();
                        if (fondosAsignados != null) {
                            List conAsignacion = new ArrayList();
                            Iterator fonds = fondosAsignados.iterator();
                            while (fonds.hasNext()) {
                                FondoPorcentaje dtoDist = new FondoPorcentaje();
                                BpiDitribFondosAPVTbl dtoFondo = (BpiDitribFondosAPVTbl) fonds.next();
                                dtoDist.setIdFondo(dtoFondo.getIdFondo().toString());
                                dtoDist.setPorcentaje(dtoFondo.getPorcentaje().toString());

                                //AGREGA
                                if (dtoFondo.getMonto().doubleValue() > 0 && dtoFondo.getPorcentaje().intValue() > 0) {
                                    conAsignacion.add(dtoDist);
                                    montoTotalDistribuido = montoTotalDistribuido + dtoFondo.getMonto().doubleValue();
                                }
                            }

                            //ASIGNA DATA
                            FondoPorcentaje[] fondosP = new FondoPorcentaje[conAsignacion.size()];
                            for (int poxr = 0; poxr < conAsignacion.size(); poxr++) {
                                fondosP[poxr] = (FondoPorcentaje) conAsignacion.get(poxr);
                            }
                            fondosDistribuidos.addAll(Arrays.asList(fondosP));
                        }
                    }

                    //TODO: APT AQUI SE GRABA LA DISTRIBUCION Y GENERA EL ID.
                    String regimenNew = "" + producto.getRegimenTributario();

                    /*GrabarDistribucionFondosAporteExtraordinarioReg GrabadoDistFondo = new GrabarDistribucionFondosAporteExtraordinarioReg();
                        GrabadoDistFondo.setRamo(String.valueOf(producto.getNumeroRamo()));
                        GrabadoDistFondo.setNumeroPoliza(String.valueOf(producto.getNumeroProducto()));
                        GrabadoDistFondo.setRutCliente(String.valueOf(pagoPublico.getDatosCliente().getRutCliente()));
                        GrabadoDistFondo.setUsuario("");
                        GrabadoDistFondo.setMontoTotal(montoTotalDistribuido);
                        List<FondoPorcentaje> vectorFondoPorcentaje = new ArrayList<FondoPorcentaje>();

                        vectorFondoPorcentaje.addAll(fondosDistribuidos);
                        GrabadoDistFondo.getFondos().addAll(vectorFondoPorcentaje);
                        GrabadoDistFondo.setRegimen(regimenNew);*/

                    //RetGrabadoDistFondo resultado = wsAPV.grabarDistribucionFondosAporteExtraordinarioReg(Integer.toString(producto.getNumeroRamo()), Integer.toString(producto.getNumeroProducto()), Integer.toString(pagoPublico.getDatosCliente().getRutCliente()), FacesUtil.getRemoteUser() ,montoTotalDistribuido, fondosDistribuidos, regimenNew);
                    //TODO: GRABA LOS DATOS Y RECUPERA EL ID DE DISTRIBUCION.
                    RetGrabadoDistFondo resultado =
                        iCI.grabarDistribucionFondosAporteExtraordinarioReg(String.valueOf(producto.getNumeroRamo()),
                                                                            String.valueOf(producto.getNumeroProducto()),
                                                                            String.valueOf(pagoPublico.getDatosCliente().getRutCliente()),
                                                                            "SV", montoTotalDistribuido,
                                                                            fondosDistribuidos, regimenNew);

                    //EVALUA LA RESPUESTA FINAL DE LA GRABACION DE DATOS
                    if (resultado != null && resultado.getCodigoRespuesta().equals("0")) {
                        //RECUPERO EL ID DE DISTRIBUCION
                        String idDistribucion = resultado.getIdDistribucion();
                        producto.setIdAporte(new Integer(idDistribucion));
                        producto.setResultadoDistribucion(0);

                        //GRABAR DATOS EN LA BASE DE PAGOS ELECTRONICO WEB
                        boolean grabo =
                            DAOFactory.getDistribucionFondosDao().grabarDistribucionFondosAPVProducto(producto.getIdAporte(),
                                                                                                      producto.getDistribucionFondos(),
                                                                                                      producto.getRegimenTributario(),
                                                                                                      producto.getDescripcionRegimen());

                        //VERIFICA GRABACION EN BASE DE DATOS
                        if (grabo) {

                            //BUSCAR CUOTAS DE PAGO PUBLICO Y SETEAR EL NUEVO APORTE REALIZADO
                            //Hashtable cuotasUpdate = new Hashtable();
                            LinkedHashMap cuotasUpdate = new LinkedHashMap();
                            for (int counter = 1; counter <= pagoPublico.getHashcuotasl().size();
                                 counter++) {
                                //PagoDetalleCuotaVO vCuota = mapper.convertValue(pagoPublico.getHashcuotas().get(""+counter), PagoDetalleCuotaVO.class);
                                PagoDetalleCuotaVO vCuota =
                                                                       (PagoDetalleCuotaVO) pagoPublico.getHashcuotasl().get(counter);
                                if (vCuota != null) {
                                    if (vCuota.isSelecionado() && vCuota.getIdCuota() == producto.getIdCuota()) {
                                        vCuota = producto;
                                    }
                                    cuotasUpdate.put(new Integer(vCuota.getIdCuota()), vCuota);
                                }
                            }

                            //SETEA LA NUEVA LISTA DE CUOTAS ACTUALIZADAS EN SU REVISION DE DISTRIBUCION APV
                            pagoPublico.setHashcuotasl(cuotasUpdate);

                            //ACTUALIZAR BARIABLE DE SESSION
                            return pagoPublico;

                        } else {
                            throw new Exception(ResourcePropertiesUtil.getProperty("jsf.pagopublico.apv.mensajes.informativos.errores.grabar.db"));
                        }

                    } else {
                        String msgerror = "";
                        if (resultado != null)
                            msgerror = resultado.getMensajeRespuesta();
                        throw new Exception(msgerror);
                    }

                } catch (Exception e) {
                    throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.apv.mensajes.informativos.errores.grabar.exception"));
                }

            } else {
                throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.apv.mensajes.informativos.montos.distribucion.incorrecta"));
                /*pagoPublico.setMensajeRespuesta(ResourceMessageUtil.getProperty("jsf.pagopublico.apv.mensajes.informativos.montos.distribucion.incorrecta"));
                pagoPublico.setEstado(false);
                pagoPublico.setCodRespuesta(1);*/
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        //return pagoPublico;
    }

    public static PagoPublicoVO doConfirmacionProducto(PagoPublicoVO pagoPublico,
                                                       HttpServletRequest request) throws Exception {

        logger.info("confirmacionPago(int mediopago=" + pagoPublico.getMedioPago() + ") - iniciando");

        ResumenRequest reqConfirmado = new ResumenRequest();

        ObjectMapper mapper = new ObjectMapper();
        if (pagoPublico.getMedioPago() == 0) {
            throw new Exception("ERROR: Debe ingresar medio de pago");

        } else if (pagoPublico.getIdNavegacion() == 0) {
            throw new Exception("ERROR: No existe ID navegacion");

        } else if (pagoPublico.getXmloriginal() == null || "".equals(pagoPublico.getXmloriginal())) {
            //pagoPublico.setMensajeRespuesta("ERROR: Debe ingresar XML original");
            throw new Exception("ERROR: Debe ingresar XML original");
        }

        if (pagoPublico.getAccion() != null && "volver".equals(pagoPublico.getAccion())) {
            //VUELVE A BUSCAR
            pagoPublico.setXmloriginal(null);
            pagoPublico.setXmlconfirmacion(null);
            pagoPublico.setXmlconfirmacionDataBancos(null);
            pagoPublico.setXmlpagopublico(null);
            pagoPublico = findDeudaCliente(Integer.valueOf(pagoPublico.getDatosCliente().getRutCliente()));
            return pagoPublico;
        }

        pagoPublico = PagoPublicoCore.llenaLinked(pagoPublico);
        reqConfirmado = PagoPublicoCore.getRequerimientoConfirmaPagoSeleccionadoAPT(pagoPublico, 0, null);
        //vuelve a consultar toda la data con nuevo medio de pago
        reqConfirmado.setBanco(pagoPublico.getMedioPago());
        logger.info("confirmacionPago() - NUMERO TRANSACCION BICE:" + pagoPublico.getIdTransaccion());
        try {
            Double maxaporte = new Double(pagoPublico.getValormaxaporte());
            if (reqConfirmado != null) {

                if (pagoPublico.getTotalPagar() != null && pagoPublico.getTotalPagar().doubleValue() > 0.0) {
                    if (pagoPublico.getTotalPagar().doubleValue() <= maxaporte.doubleValue()) {
                        //Verificacion de existencia de aporte en caso de tener distribucion
                        boolean existeaporte = true;
                        boolean aportemayorcero = true;
                        boolean montodistribudoigualmontocuota = true;
                        for (int counter = 1; counter <= pagoPublico.getHashcuotasl().size(); counter++) {
                            PagoDetalleCuotaVO vCuota =
                                mapper.convertValue(pagoPublico.getHashcuotasl().get(counter),
                                                    PagoDetalleCuotaVO.class);
                            //PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO)pagoPublico.getHashcuotas().get(counter);
                            if (vCuota != null && vCuota.getNumeroProducto() != 0) {
                                if (vCuota.isSelecionado()) {
                                    if (!(vCuota.getTotalCuota() > 0.0)) {
                                        aportemayorcero = false;
                                        break;
                                    }

                                    if (vCuota.isDistribucion()) {
                                        if (vCuota.getIdAporte() <= 0) {
                                            existeaporte = false;
                                            break;
                                        }

                                        if (vCuota.getTotalCuota().longValue() !=
                                            vCuota.getMontototaldistribucion().longValue()) {
                                            montodistribudoigualmontocuota = false;
                                            break;
                                        }

                                    }
                                }
                            }
                        }

                        if (aportemayorcero) {
                            if (montodistribudoigualmontocuota) {
                                if (existeaporte) {
                                    pagoPublico.setIdBancoPago(pagoPublico.getMedioPago());

                                    //ACTUALIZA EL CARGO SEGUN MEDIO DE PAGO
                                    if (pagoPublico.getMedioPago() ==
                                        11) {
                                        // ejb = ServiceLocator.getMedioPagoElectronicoEJB();
                                        pagoPublico.setPorcentajeCobroTarjeta(DAOFactory.getPersistenciaGeneralDao().getPorcentajeCobroTarjetaAPVAPT());
                                        double resultado =
                                            NumeroUtil.redondeartoaentremasproximotoDouble(pagoPublico.getTotalPagar().doubleValue() *
                                                                                           (pagoPublico.getPorcentajeCobroTarjeta() /
                                                                                            100));
                                        if (resultado > 0.0) {

                                            Double totalcargo = Double.parseDouble(resultado + "");
                                            pagoPublico.setCargo(totalcargo.doubleValue());

                                        } else {
                                            pagoPublico.setCargo(0.0);
                                        }
                                    } else {
                                        pagoPublico.setCargo(0.0);
                                    }


                                    if (reqConfirmado != null && reqConfirmado.getProductosSeleccionados().length > 0) {
                                        if (reqConfirmado.getOpciones().length < 11) {
                                            Boolean dummyejb =
                                                new Boolean(ResourcePropertiesUtil.getProperty("bice.offline.website.dummy.ejb.enable"));
                                            String xmlResumenPagoProductosSeleccionados = null;
                                            if (dummyejb.booleanValue() == false) {
                                                logger.info("confirmacionPago() - Realiza resumen y pagos con banco seleccionado " +
                                                            reqConfirmado.getBanco() +
                                                            " mas cargo por tarjeta de credito :" +
                                                            pagoPublico.getCargo());
                                                xmlResumenPagoProductosSeleccionados =
                                                    DAOFactory.getLogicaConfirmacionDao().generaXmlResumenPagosConProductosSeleccionadosAPVAPT(pagoPublico.getXmloriginal(),
                                                                                                                                               reqConfirmado,
                                                                                                                                               CANAL_BOTON_PAGO_APV_EXTRAORDINARIO,
                                                                                                                                               pagoPublico.getCargo().intValue());
                                            } else {
                                                xmlResumenPagoProductosSeleccionados = pagoPublico.getXmloriginal();
                                            }

                                            //Valida OK el XML
                                            if (xmlResumenPagoProductosSeleccionados != null &&
                                                !xmlResumenPagoProductosSeleccionados.startsWith("NOK")) {
                                                //Graba XML en session serializable
                                                pagoPublico.setXmlpagopublico(xmlResumenPagoProductosSeleccionados);

                                                //Recupera el XML segun lo seleccionado mas las data del banco
                                                String xmlConfDatabanco = null;
                                                if (dummyejb.booleanValue() == false) {
                                                    xmlConfDatabanco =
                                                        DAOFactory.getLogicaConfirmacionDao().crearConfirmacionConXmlSeleccionadoAPT("A",
                                                                                                                                     xmlResumenPagoProductosSeleccionados,
                                                                                                                                     CANAL_BOTON_PAGO_APV_EXTRAORDINARIO,
                                                                                                                                     TPOTRX_APORTEEXTRAORDINARIO,
                                                                                                                                     pagoPublico.getCargo().intValue(),
                                                                                                                                     pagoPublico.getDatosCliente().getEmail());

                                                } else {
                                                    xmlConfDatabanco = xmlResumenPagoProductosSeleccionados;
                                                }

                                                if (xmlConfDatabanco != null && !xmlConfDatabanco.startsWith("NOK")) {
                                                    HttpSession session = request.getSession();
                                                    logger.info("Session ID: " + session.getId());

                                                    //Setea y asocia datas de pago
                                                    pagoPublico.setXmlconfirmacion(xmlConfDatabanco);
                                                    pagoPublico.setXmlconfirmacionDataBancos(xmlConfDatabanco);
                                                    String xmlBanco =
                                                        PagoPublicoCore.getXmlBancoRedireccionamiento(xmlConfDatabanco);
                                                    PagoBancoInfoVo info = new PagoBancoInfoVo();
                                                    info.setHtmlHiddenPago("");
                                                    info.setNewHiddenParam(PagoPublicoCore.getBancoHtmlHiddenParamsNew(pagoPublico,
                                                                                                                       xmlConfDatabanco,
                                                                                                                       xmlBanco,
                                                                                                                       session.getId()));
                                                    info.setBancoNombre(PagoPublicoCore.getBancoNombre(pagoPublico.getMedioPago()));
                                                    info.setXmlUrlRedirect(PagoPublicoCore.getUrlBancoRedireccionamiento(xmlConfDatabanco));
                                                    info.setIdTransaccionBanco(PagoPublicoCore.getBancoIdComprobante(pagoPublico.getMedioPago(),
                                                                                                                     xmlBanco));
                                                    pagoPublico.setIdTransaccion(Integer.parseInt(info.getIdTransaccionBanco()));
                                                    pagoPublico.setBanco(info);
                                                    pagoPublico.setFormaPago(info.getBancoNombre());


                                                    pagoPublico =
                                                        PagoPublicoCore.setDatosSeleccionadosXml(pagoPublico,
                                                                                                 pagoPublico.getXmlpagopublico());
                                                    return pagoPublico;

                                                } else {
                                                    String mensajerror = xmlConfDatabanco;
                                                    if (xmlConfDatabanco.startsWith("NOK"))
                                                        mensajerror = xmlConfDatabanco.substring(4);
                                                    throw new Exception(mensajerror);
                                                }
                                            } else {

                                                String mensajerror = xmlResumenPagoProductosSeleccionados;
                                                if (xmlResumenPagoProductosSeleccionados.startsWith("NOK"))
                                                    mensajerror = xmlResumenPagoProductosSeleccionados.substring(4);
                                                throw new Exception(mensajerror);
                                            }
                                        } else {
                                            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.seleccioneproducto.10"));
                                        }
                                    } else {
                                        throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.seleccioneproducto"));
                                    }
                                } else {
                                    throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.noexiste.aporte.con.distribucion"));
                                }
                            } else {
                                throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.aporte.distinto.cuota"));
                            }
                        } else {
                            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.aporte.min"));
                        }
                    } else {
                        String mensajerror =
                            ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.max.1") +
                            NumeroUtil.formatMilesNoDecimal(pagoPublico.getValormaxaporte()) +
                            ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.max.2");
                        throw new Exception(mensajerror);
                    }

                } else {
                    throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.min"));
                }
            } else {
                throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.seleccioneproducto"));
            }

            //redireccionado
        } catch (ServiceLocatorException e) {
            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.ejb"));
        } catch (Exception e) {
            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.logica"));
        }
        // return pagoPublico;
    }

    public static PagoPublicoVO doConfirmacionMedioPago(PagoPublicoVO pagoPublico) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        logger.info("doConfirmacion() - iniciando");
        String accion = null;

        pagoPublico.setMensajeRespuesta("OK");
        pagoPublico.setCodRespuesta(0);
        pagoPublico.setEstado(Boolean.TRUE);

        if (pagoPublico.getAccion() != null && "volver".equals(pagoPublico.getAccion())) {
            //VUELVE A BUSCAR
            pagoPublico.setXmloriginal(null);
            pagoPublico.setXmlconfirmacion(null);
            pagoPublico.setXmlconfirmacionDataBancos(null);
            pagoPublico.setXmlpagopublico(null);
            pagoPublico = findDeudaCliente(Integer.valueOf(pagoPublico.getDatosCliente().getRutCliente()));
            return pagoPublico;
        }
        if (pagoPublico.getIdNavegacion() == 0) {
            throw new Exception("ERROR: No existe ID navegacion");

        } else if (pagoPublico.getXmloriginal() == null || "".equals(pagoPublico.getXmloriginal())) {

            throw new Exception("ERROR: xmlOriginal vacio");
        }
        pagoPublico = PagoPublicoCore.llenaLinked(pagoPublico);
        pagoPublico.setUrlcgi(pagoPublico.getBanco().getXmlUrlRedirect());
        //htmldata --> corresponde a newHiddenParam
        pagoPublico.setBancoId(pagoPublico.getIdBancoPago());

        //RECUPEA EL ID DEL COMPROBANTE
        String idcomprobante = pagoPublico.getBanco().getIdTransaccionBanco();
        //SETEA EL NUMERO DE OPERACION
        logger.info("doConfirmacion() - Seteando numero de operacion: " + idcomprobante);
        //mbean.setNumeroTransaccion(idcomprobante);


        try {
            String medio = PagoPublicoCore.getValidaNodePathMedioPago(pagoPublico);
            if (Integer.parseInt(medio) != pagoPublico.getMedioPago()) {
                throw new Exception("Confirmaci\u00f3n de medio de pago no corresponde");
            } else if (!PagoPublicoCore.getValidaProductoSeleccionado(pagoPublico)) {
                throw new Exception("Los productos seleccionado, verifique que sean los productos a pagar");
            }

            int numcuotas = pagoPublico.getHashcuotasl().size();

            for (int counter = 1; counter <= numcuotas;
                 counter++) {
                //PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO)pagoPublico.getHashcuotas().get(counter);
                PagoDetalleCuotaVO vCuota =
                                       mapper.convertValue(pagoPublico.getHashcuotasl().get(counter),
                                                           PagoDetalleCuotaVO.class);
                if (vCuota != null && vCuota.getNumeroProducto() != 0) {
                    if (vCuota.isSelecionado()) {

                        logger.debug("doConfirmacion() - Seteando detalle de APV DetalleAPV");
                        DetalleAPV detalle = new DetalleAPV();
                        detalle.setIdtransaccion(new Long(pagoPublico.getIdTransaccion()));
                        detalle.setMonto(vCuota.getValorEnPesos().longValue());
                        detalle.setNumerofolio(new Long(vCuota.getFolio_recibo()));
                        detalle.setNumeropoliza(new Long(vCuota.getNumeroProducto()));
                        detalle.setNumeroramo(new Long(vCuota.getNumeroRamo()));
                        detalle.setRut(new Long(pagoPublico.getDatosCliente().getRutCliente()));
                        detalle.setIdaporte(new Long(vCuota.getIdAporte()));
                        detalle.setUsuarioconsulta("INTERNET");


                        logger.info("doConfirmacion() - llamada a updateIdAporteComprobantes");
                        boolean updateidAporteComprobante =
                            DAOFactory.getPersistenciaGeneralDao().updateIdAporteComprobantes(detalle);
                        boolean updatedistribucionfondoapv =
                            DAOFactory.getDistribucionFondosDao().updateTransaccionDistribucionFondosAPVProducto(detalle);

                        if (!updateidAporteComprobante) {
                            logger.info("doConfirmacion() - No se logr� actualizar Id de Aporte en la tabla de comprobantes");
                            throw new Exception("No se logro actualizar Id de Aporte");
                        } else {
                            logger.info("doConfirmacion() - llamada a updateTransaccionDistribucionFondosAPVProducto");
                            if (!updatedistribucionfondoapv) {
                                logger.info("doConfirmacion() - No se logro actualizar Id de transaccion del aportes");
                                throw new Exception("No se logro actualizar Id de transaccion del aporte");
                            }
                        }
                        //}
                    }
                }
            }

            //actualiza el estado de la transaccion
            logger.info("doConfirmacion() - Actualizando estado de la transaccion[" + idcomprobante + "]");
            DAOFactory.getPersistenciaGeneralDao().updateEstadoTransaccion(new Integer(idcomprobante), new Integer(2));
        } catch (ServiceLocatorException e) {
            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.ejb"));
        } catch (Exception e) {
            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.logica"));
        }
        logger.info("doConfirmacion() - termina");
        return pagoPublico;
    }

    public static PagoPublicoVO doVerificar(PagoPublicoVO pagoPublico, String urlContext) throws Exception {
        try {
            pagoPublico = PagoPublicoCore.llenaLinked(pagoPublico);
            logger.info((new StringBuilder()).append("doVerificar() - consultando id:").append(pagoPublico.getBanco().getIdTransaccionBanco()).toString());
            ResultadoConsultaVO resultado = verificaComprobantePagado(pagoPublico.getBanco().getIdTransaccionBanco());
            pagoPublico.setResultadoPagoBanco(resultado);
            if (resultado.getResultado() ==
                2) {
                //GENERA EL PDF DE PAGO EXITOSO
                //TODO:APT GENERA PDF
                PagoRutasFilesVO voPag =
                                      PagoPublicoCore.generarPDFPagoOK(pagoPublico,
                                                                       urlContext.toString().replace("file:", ""));
                if (voPag != null) {
                    pagoPublico.setUrlPdfDownload(voPag.getPathRelativo());
                    pagoPublico.setAbsoluteServerPathPdfDownload(voPag.getPathAbsoluto());
                    //mbean.setUrlPdfPagoRealizado(pagoPublico.getUrlPdfDownload());
                    autoSendEmail(pagoPublico);

                } else {
                    throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.pdf.pago"));
                }
                return pagoPublico;
            }
            if (resultado.getResultado() == 1) {

                if (pagoPublico.getIdBancoPago() == 4 || pagoPublico.getIdBancoPago() == 11) {
                    logger.info("doVerificar() - Rechazado por medio de pago WEBPAY: " + pagoPublico.getIdBancoPago());

                } else {
                    logger.info("doVerificar() - Rechazado por medio de pago: " + pagoPublico.getIdBancoPago());
                    throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.mensajes.informativos.rechazo.banco"));
                }

            }
            if (resultado.getResultado() == 0) {
                logger.info("doVerificar() - no pagado aun seguir esperando...");
                pagoPublico.setMensajeRespuesta((ResourceMessageUtil.getProperty("jsf.pagopublico.mensajes.informativos.espera.pago")));
                pagoPublico.setCodRespuesta(1);
                pagoPublico.setEstado(false);
                return pagoPublico;
            }

        } catch (ConsultaComprobanteException e) {
            throw new Exception(e.getMessage());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return pagoPublico;


    }

    private static ResultadoConsultaVO verificaComprobantePagado(String idTransaccion) throws ConsultaComprobanteException {

        ResultadoConsultaVO resultado = new ResultadoConsultaVO();
        resultado.setResultado(0);
        logger.info("verificaComprobantePagado() - inicia");
        try {
            BpiTraTransaccionesTbl trx =
                DAOFactory.getConsultasDao().findTransaccionCodigoEstadoByNumTransaccion(new Long(idTransaccion));
            if (trx != null) {
                switch (trx.getCodEstado().intValue()) {
                case 2: // '\002'
                    resultado.setResultado(0);
                    resultado.setMensajeResultado("Ahun no se realiza el pago a traves del banco...");
                    break;

                case 99: // 'c'
                    resultado.setResultado(1);
                    resultado.setMensajeResultado(trx.getObservaciones());
                    //           this.setNumeroOrdenCompra(trx.getMedioOrdenCompra());
                    break;

                default:
                    resultado.setNumeroCuotasBanco(trx.getMedioNumeroCuotas() != null ?
                                                   Integer.toString(trx.getMedioNumeroCuotas().intValue()) :
                                                   "No aplica");
                    resultado.setNumeroTransaccionBanco(trx.getNumeroTransaccionBanco());
                    //resultado.setNumeroOrdenCompra(idTransaccion);
                    resultado.setNumeroOrdenCompra(trx.getMedioOrdenCompra());
                    //          this.setNumeroOrdenCompra(trx.getMedioOrdenCompra());
                    resultado.setNumeroTarjeta(trx.getMedioNumeroTarjeta());
                    resultado.setCodigoAutorizacion(trx.getMedioCodigoAutorizacion());
                    if (trx.getMedioFechaPago() != null) {
                        resultado.setFechaBanco(FechaUtil.getFechaFormateoCustom(trx.getMedioFechaPago(),
                                                                                 "dd/MM/yyyy"));
                        resultado.setHoraBanco(FechaUtil.getFechaFormateoCustom(trx.getMedioFechaPago(), "HH:mm:ss"));
                    } else {
                        resultado.setFechaBanco(FechaUtil.getFechaFormateoCustom(trx.getFechafin(), "dd/MM/yyyy"));
                        resultado.setHoraBanco(FechaUtil.getFechaFormateoCustom(trx.getFechafin(), "HH:mm:ss"));
                    }
                    resultado.setMonedaPago("Pesos");
                    //resultado.setTipoCuotas("Sin cuotas");
                    resultado.setTipoCuotas("Venta debito");
                    if (trx.getMedioTipoTarjeta() != null) {
                        if (trx.getMedioTipoTarjeta().equalsIgnoreCase("VN"))
                            resultado.setTipoCuotas("Sin cuotas");
                        if (trx.getMedioTipoTarjeta().equalsIgnoreCase("VC"))
                            resultado.setTipoCuotas("Cuotas Normales");
                        if (trx.getMedioTipoTarjeta().equalsIgnoreCase("SI"))
                            resultado.setTipoCuotas("Sin Inter\351s");
                        if (trx.getMedioTipoTarjeta().equalsIgnoreCase("CI"))
                            resultado.setTipoCuotas("Cuotas Comercio");
                    }
                    BpiDnaDetnavegTbl xmlDTO =
                        DAOFactory.getPersistenciaGeneralDao().findComprobanteByTransaccion(new Long(idTransaccion));
                    if (xmlDTO != null) {
                        oracle.xml.parser.v2.XMLDocument xmlDoc = xmlDTO.getDetallePagina();
                        if (xmlDoc != null) {
                            resultado.setResultado(2);
                            resultado.setMensajeResultado("Pago realizado sin problemas");
                        }
                    }
                    break;
                }
                if (resultado.getResultado() == 2)
                    switch (trx.getCodMedioPago().intValue()) {
                    case 1: // '\001'
                        resultado.setCodigoAutorizacion("No aplica");
                        resultado.setNumeroCuotasBanco("No aplica");
                        resultado.setNumeroTarjeta("No aplica");
                        resultado.setTipoCuotas("No aplica");
                        break;

                    case 2: // '\002'
                        resultado.setCodigoAutorizacion("No aplica");
                        resultado.setNumeroCuotasBanco("No aplica");
                        resultado.setNumeroTarjeta("No aplica");
                        resultado.setTipoCuotas("No aplica");
                        break;

                    case 3: // '\003'
                        resultado.setCodigoAutorizacion("No aplica");
                        resultado.setNumeroCuotasBanco("No aplica");
                        resultado.setNumeroTarjeta("No aplica");
                        resultado.setTipoCuotas("No aplica");
                        break;
                    }
            }
        } catch (ServiceLocatorException e) {
            throw new ConsultaComprobanteException(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.ejb"));
        } catch (Exception e) {
            throw new ConsultaComprobanteException(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.logica"));
        }
        logger.info("verificaComprobantePagado() - termina");
        return resultado;
    }

    private static void autoSendEmail(PagoPublicoVO pagoPublico) throws Exception{
        boolean isAutoSendMail = false;
        pagoPublico = PagoPublicoCore.llenaLinked(pagoPublico);
        logger.info("autoSendEmail() - iniciando");
        if (isAutoSendMail == false) {
            logger.info("autoSendEmail() - verificando si hay auto envio de email");
            Boolean autoEnvioEnable =
                new Boolean(cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.email.autosend.fin.pago"));
            if (autoEnvioEnable.booleanValue()) {
                String polizas = listPolizas(pagoPublico.getHashcuotasl());
                String urlAttach = (new StringBuilder()).append(pagoPublico.getUrlPdfDownload()).toString();
                String emailUser = pagoPublico.getDatosCliente().getEmail();
                logger.info("autoSendEmail() - Hay que auto enviar correo con el comprobante a :" + emailUser);
                logger.info("autoSendEmail() - El PDF adjutado en el correo es :" + urlAttach);
                if (emailUser != null) {
                    /*
                     * Verifica que el email sea valido
                     */
                    if (EmailUtil.isValidEmailAddress(emailUser)) {
                        logger.info("autoSendEmail() - Email valido, enviando correo...");
                        EmailUtil.enviarEmailWS(true, emailUser,
                                                cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.email.from"),
                                                cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.email.cc"),
                                                cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.email.cco"),
                                                cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.email.subject.pagado"),
                                                pagoPublico.getDatosCliente().getNombreCliente(),
                                                FechaUtil.getFechaFormateoStandar(pagoPublico.getFechaTransaccion()),
                                                polizas, urlAttach);
                        logger.info("autoSendEmail() - Email Enviado");
                    }
                }
            }
            //FINALIZA PARA QUE NO VUELVA A ENVIAR EN CASO DE REFRESCAR.
            isAutoSendMail = true;
        }
        logger.info("autoSendEmail() - terminado");
        return;
    }

    public static OutMensaje doEnviarPorEmail(LinkedHashMap cuotas, String urlPdf, String nombreCliente,
                                              java.util.Date fechaTransaccion, String emailCustom) {
        logger.info("doEnviarEmailCustomEsperaPago() - iniciando");

        //String polizas = this.listPolizas(pagoPublico.getHashcuotas());
        String polizas = listPolizas(cuotas);
        String nombreProducto = descripcionPolizas(cuotas);
        //String urlAttach = (new StringBuilder()).append(pagoPublico.getUrlPdfDownload()).toString();
        String urlAttach = (new StringBuilder()).append(urlPdf).toString();
        OutMensaje salida = new OutMensaje();

        if (emailCustom != null) {
            if (EmailUtil.isValidEmailAddress(emailCustom)) {

                /*EmailUtil.enviarEmailWS(true, emailCustom, cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.email.from"),
                                        cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.email.cc"),
                                        cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.email.cco"),
                                        cl.bicevida.botonpago.util.ResourcePropertiesUtil.getProperty("bice.webservices.client.email.subject.pagado"),
                                        //pagoPublico.getDatosCliente().getNombreCliente(),
                                        nombreCliente,
                                        //FechaUtil.getFechaFormateoStandar(pagoPublico.getFechaTransaccion()),
                                        FechaUtil.getFechaFormateoStandar(fechaTransaccion),
                                        polizas, urlAttach);*/
                EmailUtil.enviarEmailWS(true, emailCustom,
                                        ResourcePropertiesUtil.getProperty("bice.webservices.client.email.from"),
                                        ResourcePropertiesUtil.getProperty("bice.webservices.client.email.cc"),
                                        ResourcePropertiesUtil.getProperty("bice.webservices.client.email.cco"),
                                        ResourcePropertiesUtil.getProperty("bice.webservices.client.email.subject.pagado") +
                                        " " + nombreProducto, nombreCliente,
                                        FechaUtil.getFechaFormateoStandar(fechaTransaccion), polizas, urlAttach);

                salida.setMensaje(ResourceMessageUtil.getProperty("jsf.pagopublico.mensajes.informativos.emialenviado"));
                salida.setCodigo("00");
            } else {
                salida.setMensaje(ResourceMessageUtil.getProperty("jsf.pagopublico.mensajes.informativos.email.error.format"));
                salida.setCodigo("01");
            }
        } else {
            salida.setMensaje(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.noemail"));
            salida.setCodigo("01");
        }
        logger.info("doEnviarEmailCustomEsperaPago() - terminando");

        return salida;
    }

    private static String listPolizas(LinkedHashMap cuotas) {
        String polizas = "";
        int numcuotas = cuotas.size();
        ObjectMapper mapper = new ObjectMapper();
        
        for (int counter = 1; counter <= numcuotas; counter++) {
            //PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO)cuotas.get(counter);
            PagoDetalleCuotaVO vCuota = mapper.convertValue(cuotas.get(counter), PagoDetalleCuotaVO.class);
            if (vCuota != null && vCuota.getNumeroProducto() != 0) {
                /*
                 * Busqueda del comprobante
                 */
                if (vCuota.isSelecionado()) {
                    polizas =
                        polizas + vCuota.getDescripcionProducto() + " - N&deg; " + vCuota.getNumeroProducto() + ", ";
                }
            }
        }

        if (polizas.length() > 0) {
            polizas = polizas.substring(0, polizas.length() - 2);
        }

        return polizas;
    }

    private static String descripcionPolizas(LinkedHashMap cuotas) {
        String polizas = "";
        int numcuotas = cuotas.size();
        ObjectMapper mapper = new ObjectMapper();

        for (int counter = 1; counter <= numcuotas; counter++) {
            //PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO)cuotas.get(counter);
            PagoDetalleCuotaVO vCuota = mapper.convertValue(cuotas.get(counter), PagoDetalleCuotaVO.class);
            if (vCuota != null && vCuota.getNumeroProducto() != 0) {
                /*
                 * Busqueda del comprobante
                 */
                if (vCuota.isSelecionado()) {
                    polizas = polizas + vCuota.getDescripcionProducto() + ", ";
                }
            }
        }

        if (polizas.length() > 0) {
            polizas = polizas.substring(0, polizas.length() - 2);
        }

        return polizas;
    }

    public static PagoPublicoVO doCancelarSeleccionarPago(PagoPublicoVO pagoPublico) throws Exception {

        pagoPublico.setXmloriginal(null);
        pagoPublico.setXmlconfirmacion(null);
        pagoPublico.setXmlconfirmacionDataBancos(null);
        pagoPublico.setXmlpagopublico(null);
        pagoPublico = findDeudaCliente(Integer.valueOf(pagoPublico.getDatosCliente().getRutCliente()));

        return pagoPublico;
    }

    public static PagoPublicoVO doConfirmarAPorte(PagoPublicoVO pagoPublico,
                                                  HttpServletRequest request) throws Exception {

        logger.info("confirmacionPago(int mediopago=" + pagoPublico.getMedioPago() + ") - iniciando");

        ResumenRequest reqConfirmado = new ResumenRequest();

        ObjectMapper mapper = new ObjectMapper();
        if (pagoPublico.getMedioPago() == 0) {
            throw new Exception("ERROR: Debe ingresar medio de pago");

        } else if (pagoPublico.getIdNavegacion() == 0) {
            throw new Exception("ERROR: No existe ID navegacion");

        } else if (pagoPublico.getXmloriginal() == null || "".equals(pagoPublico.getXmloriginal())) {
            //pagoPublico.setMensajeRespuesta("ERROR: Debe ingresar XML original");
            throw new Exception("ERROR: Debe ingresar XML original");
        }

        if (pagoPublico.getAccion() != null && "volver".equals(pagoPublico.getAccion())) {
            //VUELVE A BUSCAR
            pagoPublico.setXmloriginal(null);
            pagoPublico.setXmlconfirmacion(null);
            pagoPublico.setXmlconfirmacionDataBancos(null);
            pagoPublico.setXmlpagopublico(null);
            pagoPublico = findDeudaCliente(Integer.valueOf(pagoPublico.getDatosCliente().getRutCliente()));
            return pagoPublico;
        }

        pagoPublico = PagoPublicoCore.llenaLinked(pagoPublico);
        reqConfirmado = PagoPublicoCore.getRequerimientoConfirmaPagoSeleccionadoAPT(pagoPublico, 0, null);
        //vuelve a consultar toda la data con nuevo medio de pago
        reqConfirmado.setBanco(pagoPublico.getMedioPago());
        logger.info("confirmacionPago() - NUMERO TRANSACCION BICE:" + pagoPublico.getIdTransaccion());
        try {
            Double maxaporte = new Double(pagoPublico.getValormaxaporte());
            if (reqConfirmado != null) {

                if (pagoPublico.getTotalPagar() != null && pagoPublico.getTotalPagar().doubleValue() > 0.0) {
                    if (pagoPublico.getTotalPagar().doubleValue() <= maxaporte.doubleValue()) {
                        //Verificacion de existencia de aporte en caso de tener distribucion
                        boolean existeaporte = true;
                        boolean aportemayorcero = true;
                        boolean montodistribudoigualmontocuota = true;
                        for (int counter = 1; counter <= pagoPublico.getHashcuotasl().size(); counter++) {
                            PagoDetalleCuotaVO vCuota =
                                mapper.convertValue(pagoPublico.getHashcuotasl().get(counter),
                                                    PagoDetalleCuotaVO.class);
                            //PagoDetalleCuotaVO vCuota = (PagoDetalleCuotaVO)pagoPublico.getHashcuotas().get(counter);
                            if (vCuota != null && vCuota.getNumeroProducto() != 0) {
                                if (vCuota.isSelecionado()) {
                                    if (!(vCuota.getTotalCuota() > 0.0)) {
                                        aportemayorcero = false;
                                        break;
                                    }

                                    if (vCuota.isDistribucion()) {
                                        if (vCuota.getIdAporte() <= 0) {
                                            existeaporte = false;
                                            break;
                                        }

                                        if (vCuota.getTotalCuota().longValue() !=
                                            vCuota.getMontototaldistribucion().longValue()) {
                                            montodistribudoigualmontocuota = false;
                                            break;
                                        }

                                    }
                                }
                            }
                        }

                        if (aportemayorcero) {
                            if (montodistribudoigualmontocuota) {
                                if (existeaporte) {
                                    pagoPublico.setIdBancoPago(pagoPublico.getMedioPago());

                                    //ACTUALIZA EL CARGO SEGUN MEDIO DE PAGO
                                    if (pagoPublico.getMedioPago() ==
                                        11) {
                                        // ejb = ServiceLocator.getMedioPagoElectronicoEJB();
                                        pagoPublico.setPorcentajeCobroTarjeta(DAOFactory.getPersistenciaGeneralDao().getPorcentajeCobroTarjetaAPVAPT());
                                        double resultado =
                                            NumeroUtil.redondeartoaentremasproximotoDouble(pagoPublico.getTotalPagar().doubleValue() *
                                                                                           (pagoPublico.getPorcentajeCobroTarjeta() /
                                                                                            100));
                                        if (resultado > 0.0) {

                                            Double totalcargo = Double.parseDouble(resultado + "");
                                            pagoPublico.setCargo(totalcargo.doubleValue());

                                        } else {
                                            pagoPublico.setCargo(0.0);
                                        }
                                    } else {
                                        pagoPublico.setCargo(0.0);
                                    }


                                    if (reqConfirmado != null && reqConfirmado.getProductosSeleccionados().length > 0) {
                                        if (reqConfirmado.getOpciones().length < 11) {
                                            Boolean dummyejb =
                                                new Boolean(ResourcePropertiesUtil.getProperty("bice.offline.website.dummy.ejb.enable"));
                                            String xmlResumenPagoProductosSeleccionados = null;
                                            if (dummyejb.booleanValue() == false) {
                                                logger.info("confirmacionPago() - Realiza resumen y pagos con banco seleccionado " +
                                                            reqConfirmado.getBanco() +
                                                            " mas cargo por tarjeta de credito :" +
                                                            pagoPublico.getCargo());
                                                xmlResumenPagoProductosSeleccionados =
                                                    DAOFactory.getLogicaConfirmacionDao().generaXmlResumenPagosConProductosSeleccionadosAPVAPT(pagoPublico.getXmloriginal(),
                                                                                                                                               reqConfirmado,
                                                                                                                                               CANAL_BOTON_PAGO_APV_EXTRAORDINARIO,
                                                                                                                                               pagoPublico.getCargo().intValue());
                                            } else {
                                                xmlResumenPagoProductosSeleccionados = pagoPublico.getXmloriginal();
                                            }

                                            //Valida OK el XML
                                            if (xmlResumenPagoProductosSeleccionados != null &&
                                                !xmlResumenPagoProductosSeleccionados.startsWith("NOK")) {
                                                //Graba XML en session serializable
                                                pagoPublico.setXmlpagopublico(xmlResumenPagoProductosSeleccionados);

                                                //Recupera el XML segun lo seleccionado mas las data del banco
                                                String xmlConfDatabanco = null;
                                                if (dummyejb.booleanValue() == false) {
                                                    xmlConfDatabanco =
                                                        DAOFactory.getLogicaConfirmacionDao().crearConfirmacionConXmlSeleccionadoAPT("A",
                                                                                                                                     xmlResumenPagoProductosSeleccionados,
                                                                                                                                     CANAL_BOTON_PAGO_APV_EXTRAORDINARIO,
                                                                                                                                     TPOTRX_APORTEEXTRAORDINARIO,
                                                                                                                                     pagoPublico.getCargo().intValue(),
                                                                                                                                     pagoPublico.getDatosCliente().getEmail());

                                                } else {
                                                    xmlConfDatabanco = xmlResumenPagoProductosSeleccionados;
                                                }

                                                if (xmlConfDatabanco != null && !xmlConfDatabanco.startsWith("NOK")) {
                                                    HttpSession session = request.getSession();
                                                    logger.info("Session ID: " + session.getId());

                                                    //Setea y asocia datas de pago
                                                    pagoPublico.setXmlconfirmacion(xmlConfDatabanco);
                                                    pagoPublico.setXmlconfirmacionDataBancos(xmlConfDatabanco);
                                                    String xmlBanco =
                                                        PagoPublicoCore.getXmlBancoRedireccionamiento(xmlConfDatabanco);
                                                    PagoBancoInfoVo info = new PagoBancoInfoVo();
                                                    info.setHtmlHiddenPago("");
                                                    info.setNewHiddenParam(PagoPublicoCore.getBancoHtmlHiddenParamsNew(pagoPublico,
                                                                                                                       xmlConfDatabanco,
                                                                                                                       xmlBanco,
                                                                                                                       session.getId()));
                                                    info.setBancoNombre(PagoPublicoCore.getBancoNombre(pagoPublico.getMedioPago()));
                                                    info.setXmlUrlRedirect(PagoPublicoCore.getUrlBancoRedireccionamiento(xmlConfDatabanco));
                                                    info.setIdTransaccionBanco(PagoPublicoCore.getBancoIdComprobante(pagoPublico.getMedioPago(),
                                                                                                                     xmlBanco));
                                                    pagoPublico.setIdTransaccion(Integer.parseInt(info.getIdTransaccionBanco()));
                                                    pagoPublico.setBanco(info);
                                                    pagoPublico.setFormaPago(info.getBancoNombre());


                                                    pagoPublico =
                                                        PagoPublicoCore.setDatosSeleccionadosXml(pagoPublico,
                                                                                                 pagoPublico.getXmlpagopublico());

                                                    /***********************Confirmacion del medio de pago************************************/
                                                    /*
                                                     * Se actualiza las variables de retorno y el numero de trx
                                                     * */
                                                    /*pagoPublico.setUrlcgi(pagoPublico.getBanco().getXmlUrlRedirect());
                                                    //htmldata --> corresponde a newHiddenParam
                                                    pagoPublico.setBancoId(pagoPublico.getIdBancoPago());

                                                    //RECUPEA EL ID DEL COMPROBANTE
                                                    String idcomprobante =
                                                        pagoPublico.getBanco().getIdTransaccionBanco();

                                                    int numcuotas = pagoPublico.getHashcuotas().size();

                                                    for (int counter = 1; counter <= numcuotas; counter++) {
                                                        PagoDetalleCuotaVO vCuota =
                                                            (PagoDetalleCuotaVO) pagoPublico.getHashcuotas().get(counter);
                                                        //PagoDetalleCuotaVO vCuota = mapper.convertValue(pagoPublico.getHashcuotas().get(""+counter), PagoDetalleCuotaVO.class);
                                                        if (vCuota != null && vCuota.getNumeroProducto() != 0) {
                                                            if (vCuota.isSelecionado()) {

                                                                logger.debug("doConfirmacion() - Seteando detalle de APV DetalleAPV");
                                                                DetalleAPV detalle = new DetalleAPV();
                                                                detalle.setIdtransaccion(new Long(pagoPublico.getIdTransaccion()));
                                                                detalle.setMonto(vCuota.getValorEnPesos().longValue());
                                                                detalle.setNumerofolio(new Long(vCuota.getFolio_recibo()));
                                                                detalle.setNumeropoliza(new Long(vCuota.getNumeroProducto()));
                                                                detalle.setNumeroramo(new Long(vCuota.getNumeroRamo()));
                                                                detalle.setRut(new Long(pagoPublico.getDatosCliente().getRutCliente()));
                                                                detalle.setIdaporte(new Long(vCuota.getIdAporte()));
                                                                detalle.setUsuarioconsulta("INTERNET");


                                                                logger.info("doConfirmacion() - llamada a updateIdAporteComprobantes");
                                                                boolean updateidAporteComprobante =
                                                                    DAOFactory.getPersistenciaGeneralDao().updateIdAporteComprobantes(detalle);
                                                                boolean updatedistribucionfondoapv =
                                                                    DAOFactory.getDistribucionFondosDao().updateTransaccionDistribucionFondosAPVProducto(detalle);

                                                                if (!updateidAporteComprobante) {
                                                                    logger.info("doConfirmacion() - No se logro actualizar Id de Aporte en la tabla de comprobantes");
                                                                    throw new Exception("No se logro actualizar Id de Aporte");
                                                                } else {
                                                                    logger.info("doConfirmacion() - llamada a updateTransaccionDistribucionFondosAPVProducto");
                                                                    if (!updatedistribucionfondoapv) {
                                                                        logger.info("doConfirmacion() - No se logro actualizar Id de transaccion del aportes");
                                                                        throw new Exception("No se logro actualizar Id de transaccion del aporte");
                                                                    }
                                                                }
                                                                //}
                                                            }
                                                        }
                                                    }
                                                    //actualiza el estado de la transaccion
                                                    logger.info("doConfirmacion() - Actualizando estado de la transaccion[" +
                                                                idcomprobante + "]");
                                                    DAOFactory.getPersistenciaGeneralDao().updateEstadoTransaccion(new Integer(idcomprobante),
                                                                                                                   new Integer(2));*/
                                                    /***************************************************************************************************/
                                                    return pagoPublico;

                                                } else {
                                                    String mensajerror = xmlConfDatabanco;
                                                    if (xmlConfDatabanco.startsWith("NOK"))
                                                        mensajerror = xmlConfDatabanco.substring(4);
                                                    throw new Exception(mensajerror);
                                                }
                                            } else {

                                                String mensajerror = xmlResumenPagoProductosSeleccionados;
                                                if (xmlResumenPagoProductosSeleccionados.startsWith("NOK"))
                                                    mensajerror = xmlResumenPagoProductosSeleccionados.substring(4);
                                                throw new Exception(mensajerror);
                                            }
                                        } else {
                                            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.seleccioneproducto.10"));
                                        }
                                    } else {
                                        throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.seleccioneproducto"));
                                    }
                                } else {
                                    throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.noexiste.aporte.con.distribucion"));
                                }
                            } else {
                                throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.aporte.distinto.cuota"));
                            }
                        } else {
                            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.aporte.min"));
                        }
                    } else {
                        String mensajerror =
                            ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.max.1") +
                            NumeroUtil.formatMilesNoDecimal(pagoPublico.getValormaxaporte()) +
                            ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.max.2");
                        throw new Exception(mensajerror);
                    }

                } else {
                    throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.monto.total.min"));
                }
            } else {
                throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.seleccioneproducto"));
            }

            //redireccionado
        } catch (ServiceLocatorException e) {
            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.ejb"));
        } catch (Exception e) {
            throw new Exception(ResourceMessageUtil.getProperty("jsf.pagopublico.navegacion.error.logica"));
        }


    }
}
