
package cl.bice.vida.resumenypagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * detalle del estado de una cuota
 *
 * <p>Java class for estadoInternet complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="estadoInternet">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ComprobantePago" type="{}descripcion" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="estado" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estadoInternet", propOrder = { "comprobantePago" })
public class EstadoInternet {

    @XmlElement(name = "ComprobantePago")
    protected String comprobantePago;
    @XmlAttribute(name = "estado", required = true)
    protected String estado;

    /**
     * Gets the value of the comprobantePago property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getComprobantePago() {
        return comprobantePago;
    }

    /**
     * Sets the value of the comprobantePago property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setComprobantePago(String value) {
        this.comprobantePago = value;
    }

    /**
     * Gets the value of the estado property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEstado(String value) {
        this.estado = value;
    }

}
