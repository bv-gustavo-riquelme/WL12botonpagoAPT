
package cl.bice.vida.resumenypagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * periodo de tiempo
 *
 * <p>Java class for periodo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="periodo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Inicio" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Fin" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "periodo", propOrder = { "inicio", "fin" })
public class Periodo {

    @XmlElement(name = "Inicio", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar inicio;
    @XmlElement(name = "Fin", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fin;

    /**
     * Gets the value of the inicio property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getInicio() {
        return inicio;
    }

    /**
     * Sets the value of the inicio property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setInicio(XMLGregorianCalendar value) {
        this.inicio = value;
    }

    /**
     * Gets the value of the fin property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFin() {
        return fin;
    }

    /**
     * Sets the value of the fin property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFin(XMLGregorianCalendar value) {
        this.fin = value;
    }

}
