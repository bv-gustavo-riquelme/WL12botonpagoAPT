
package cl.bice.vida.resumenypagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * identificacion del mensaje
 *
 * <p>Java class for identificacionMensaje complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="identificacionMensaje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Codigo" type="{}codigoFormato"/>
 *         &lt;element name="Version" type="{}versionFormato"/>
 *         &lt;element name="De" type="{}deFormato"/>
 *         &lt;element name="FechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Accion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identificacionMensaje", propOrder = { "codigo", "version", "de", "fechaCreacion", "accion" })
@XmlSeeAlso({
            cl.bice.vida.resumenypagos.InformePagoPendiente.IdentificacionMensaje.class,
            cl.bice.vida.resumenypagos.ResumenConHeader.IdentificacionMensaje.class,
            cl.bice.vida.resumenypagos.InformePagoServipag.IdentificacionMensaje.class,
            cl.bice.vida.resumenypagos.InformePago.IdentificacionMensaje.class,
            cl.bice.vida.resumenypagos.ConsultaPagosPendientes.IdentificacionMensaje.class,
            cl.bice.vida.resumenypagos.Confirmacion.IdentificacionMensaje.class, cl.bice.vida.resumenypagos.Cuadratura.IdentificacionMensaje.class
    })
public class IdentificacionMensaje {

    @XmlElement(name = "Codigo", required = true)
    protected String codigo;
    @XmlElement(name = "Version", required = true)
    protected String version;
    @XmlElement(name = "De", required = true)
    protected String de;
    @XmlElement(name = "FechaCreacion", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaCreacion;
    @XmlElement(name = "Accion", required = true)
    protected String accion;

    /**
     * Gets the value of the codigo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Sets the value of the codigo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the de property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDe() {
        return de;
    }

    /**
     * Sets the value of the de property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDe(String value) {
        this.de = value;
    }

    /**
     * Gets the value of the fechaCreacion property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets the value of the fechaCreacion property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechaCreacion(XMLGregorianCalendar value) {
        this.fechaCreacion = value;
    }

    /**
     * Gets the value of the accion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAccion() {
        return accion;
    }

    /**
     * Sets the value of the accion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAccion(String value) {
        this.accion = value;
    }

}
