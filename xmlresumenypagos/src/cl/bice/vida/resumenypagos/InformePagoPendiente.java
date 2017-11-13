
package cl.bice.vida.resumenypagos;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdentificacionMensaje">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{}identificacionMensaje">
 *                 &lt;sequence>
 *                   &lt;element name="Codigo">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{}codigoFormato">
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Version" type="{}versionFormato"/>
 *                   &lt;element name="De">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{}deFormato">
 *                         &lt;enumeration value="SANTAN"/>
 *                         &lt;enumeration value="SERVIP"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="FechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="Accion">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="OK"/>
 *                         &lt;enumeration value="NOK"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IdTransaccion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="NumTransaccionMedio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="MontoPagado" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="CodError" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
         "identificacionMensaje", "idTransaccion", "numTransaccionMedio", "montoPagado", "codError" })
@XmlRootElement(name = "InformePagoPendiente")
public class InformePagoPendiente {

    @XmlElement(name = "IdentificacionMensaje", required = true)
    protected InformePagoPendiente.IdentificacionMensaje identificacionMensaje;
    @XmlElement(name = "IdTransaccion", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idTransaccion;
    @XmlElement(name = "NumTransaccionMedio", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numTransaccionMedio;
    @XmlElement(name = "MontoPagado", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger montoPagado;
    @XmlElement(name = "CodError")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger codError;

    /**
     * Gets the value of the identificacionMensaje property.
     *
     * @return
     *     possible object is
     *     {@link InformePagoPendiente.IdentificacionMensaje }
     *
     */
    public InformePagoPendiente.IdentificacionMensaje getIdentificacionMensaje() {
        return identificacionMensaje;
    }

    /**
     * Sets the value of the identificacionMensaje property.
     *
     * @param value
     *     allowed object is
     *     {@link InformePagoPendiente.IdentificacionMensaje }
     *
     */
    public void setIdentificacionMensaje(InformePagoPendiente.IdentificacionMensaje value) {
        this.identificacionMensaje = value;
    }

    /**
     * Gets the value of the idTransaccion property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Sets the value of the idTransaccion property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setIdTransaccion(BigInteger value) {
        this.idTransaccion = value;
    }

    /**
     * Gets the value of the numTransaccionMedio property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getNumTransaccionMedio() {
        return numTransaccionMedio;
    }

    /**
     * Sets the value of the numTransaccionMedio property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNumTransaccionMedio(BigInteger value) {
        this.numTransaccionMedio = value;
    }

    /**
     * Gets the value of the montoPagado property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getMontoPagado() {
        return montoPagado;
    }

    /**
     * Sets the value of the montoPagado property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setMontoPagado(BigInteger value) {
        this.montoPagado = value;
    }

    /**
     * Gets the value of the codError property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getCodError() {
        return codError;
    }

    /**
     * Sets the value of the codError property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setCodError(BigInteger value) {
        this.codError = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{}identificacionMensaje">
     *       &lt;sequence>
     *         &lt;element name="Codigo">
     *           &lt;simpleType>
     *             &lt;restriction base="{}codigoFormato">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Version" type="{}versionFormato"/>
     *         &lt;element name="De">
     *           &lt;simpleType>
     *             &lt;restriction base="{}deFormato">
     *               &lt;enumeration value="SANTAN"/>
     *               &lt;enumeration value="SERVIP"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="FechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="Accion">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="OK"/>
     *               &lt;enumeration value="NOK"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class IdentificacionMensaje extends cl.bice.vida.resumenypagos.IdentificacionMensaje {


    }

}
