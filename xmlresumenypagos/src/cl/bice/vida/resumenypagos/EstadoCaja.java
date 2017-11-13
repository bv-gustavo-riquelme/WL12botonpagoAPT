
package cl.bice.vida.resumenypagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * formato para los pagos realizados por caja
 *
 * <p>Java class for estadoCaja complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="estadoCaja">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FormaPago" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Medio" type="{}descripcion" minOccurs="0"/>
 *         &lt;element name="NumCta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sucursal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cajero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "estadoCaja", propOrder = {
         "fechaPago", "formaPago", "medio", "numCta", "sucursal", "cajero", "comprobantePago" })
public class EstadoCaja {

    @XmlElement(name = "FechaPago")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaPago;
    @XmlElement(name = "FormaPago")
    protected String formaPago;
    @XmlElement(name = "Medio")
    protected String medio;
    @XmlElement(name = "NumCta")
    protected String numCta;
    @XmlElement(name = "Sucursal")
    protected String sucursal;
    @XmlElement(name = "Cajero")
    protected String cajero;
    @XmlElement(name = "ComprobantePago")
    protected String comprobantePago;
    @XmlAttribute(name = "estado", required = true)
    protected String estado;

    /**
     * Gets the value of the fechaPago property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechaPago() {
        return fechaPago;
    }

    /**
     * Sets the value of the fechaPago property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechaPago(XMLGregorianCalendar value) {
        this.fechaPago = value;
    }

    /**
     * Gets the value of the formaPago property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets the value of the formaPago property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Gets the value of the medio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMedio() {
        return medio;
    }

    /**
     * Sets the value of the medio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMedio(String value) {
        this.medio = value;
    }

    /**
     * Gets the value of the numCta property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumCta() {
        return numCta;
    }

    /**
     * Sets the value of the numCta property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumCta(String value) {
        this.numCta = value;
    }

    /**
     * Gets the value of the sucursal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * Sets the value of the sucursal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSucursal(String value) {
        this.sucursal = value;
    }

    /**
     * Gets the value of the cajero property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCajero() {
        return cajero;
    }

    /**
     * Sets the value of the cajero property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCajero(String value) {
        this.cajero = value;
    }

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
