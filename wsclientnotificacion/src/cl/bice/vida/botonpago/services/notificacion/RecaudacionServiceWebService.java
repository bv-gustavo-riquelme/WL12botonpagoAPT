
package cl.bice.vida.botonpago.services.notificacion;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import cl.bice.vida.botonpago.services.notificacion.types.InformarRecaudacionIn;
import cl.bice.vida.botonpago.services.notificacion.types.InformarRecaudacionOut;
import cl.bice.vida.botonpago.services.notificacion.types.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140319.1121
 * Generated source version: 2.2
 *
 */
@WebService(name = "RecaudacionServiceWebService",
            targetNamespace = "http://webservices.model.integracion.bicevida.cl/")
@XmlSeeAlso({ ObjectFactory.class })
public interface RecaudacionServiceWebService {


    /**
     *
     * @param informarRecaudacionIn1
     * @return
     *     returns cl.bice.vida.botonpago.services.notificacion.types.InformarRecaudacionOut
     * @throws ApplicationModelException
     */
    @WebMethod
    @WebResult(targetNamespace = "http://webservices.model.integracion.bicevida.cl/")
    @RequestWrapper(localName = "informarRecaudacion",
                    targetNamespace = "http://webservices.model.integracion.bicevida.cl/",
                    className = "cl.bice.vida.botonpago.services.notificacion.types.InformarRecaudacion")
    @ResponseWrapper(localName = "informarRecaudacionResponse",
                     targetNamespace = "http://webservices.model.integracion.bicevida.cl/",
                     className = "cl.bice.vida.botonpago.services.notificacion.types.InformarRecaudacionResponse")
    public InformarRecaudacionOut informarRecaudacion(@WebParam(name = "InformarRecaudacionIn_1",
                                                                targetNamespace =
                                                                "http://webservices.model.integracion.bicevida.cl/")
                                                      InformarRecaudacionIn informarRecaudacionIn1) throws ApplicationModelException;

}
