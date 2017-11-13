
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
 *       &lt;choice>
 *         &lt;element name="Error">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CodError" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="Descripcion">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="200"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;sequence>
 *           &lt;element name="IdTransaccion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *           &lt;element name="Producto">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{}producto">
 *                   &lt;sequence>
 *                     &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                     &lt;element name="DescripcionProducto" type="{}descripcion"/>
 *                     &lt;element name="NumProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                     &lt;element name="CodEmpresa" type="{}cod_persona"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="Cuota">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{}montoCuota">
 *                   &lt;sequence>
 *                     &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                     &lt;element name="EnUF" type="{}montoUF"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "error", "idTransaccion", "producto", "cuota" })
@XmlRootElement(name = "RespuestaPagosPendientes")
public class RespuestaPagosPendientes {

    @XmlElement(name = "Error")
    protected RespuestaPagosPendientes.Error error;
    @XmlElement(name = "IdTransaccion")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idTransaccion;
    @XmlElement(name = "Producto")
    protected RespuestaPagosPendientes.Producto producto;
    @XmlElement(name = "Cuota")
    protected RespuestaPagosPendientes.Cuota cuota;

    /**
     * Gets the value of the error property.
     *
     * @return
     *     possible object is
     *     {@link RespuestaPagosPendientes.Error }
     *
     */
    public RespuestaPagosPendientes.Error getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     *
     * @param value
     *     allowed object is
     *     {@link RespuestaPagosPendientes.Error }
     *
     */
    public void setError(RespuestaPagosPendientes.Error value) {
        this.error = value;
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
     * Gets the value of the producto property.
     *
     * @return
     *     possible object is
     *     {@link RespuestaPagosPendientes.Producto }
     *
     */
    public RespuestaPagosPendientes.Producto getProducto() {
        return producto;
    }

    /**
     * Sets the value of the producto property.
     *
     * @param value
     *     allowed object is
     *     {@link RespuestaPagosPendientes.Producto }
     *
     */
    public void setProducto(RespuestaPagosPendientes.Producto value) {
        this.producto = value;
    }

    /**
     * Gets the value of the cuota property.
     *
     * @return
     *     possible object is
     *     {@link RespuestaPagosPendientes.Cuota }
     *
     */
    public RespuestaPagosPendientes.Cuota getCuota() {
        return cuota;
    }

    /**
     * Sets the value of the cuota property.
     *
     * @param value
     *     allowed object is
     *     {@link RespuestaPagosPendientes.Cuota }
     *
     */
    public void setCuota(RespuestaPagosPendientes.Cuota value) {
        this.cuota = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{}montoCuota">
     *       &lt;sequence>
     *         &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="EnUF" type="{}montoUF"/>
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
    public static class Cuota extends MontoCuota {


    }


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
     *         &lt;element name="CodError" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="Descripcion">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="200"/>
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
    @XmlType(name = "", propOrder = { "codError", "descripcion" })
    public static class Error {

        @XmlElement(name = "CodError", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger codError;
        @XmlElement(name = "Descripcion", required = true)
        protected String descripcion;

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
         * Gets the value of the descripcion property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDescripcion() {
            return descripcion;
        }

        /**
         * Sets the value of the descripcion property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDescripcion(String value) {
            this.descripcion = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{}producto">
     *       &lt;sequence>
     *         &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="DescripcionProducto" type="{}descripcion"/>
     *         &lt;element name="NumProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="CodEmpresa" type="{}cod_persona"/>
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
    public static class Producto extends cl.bice.vida.resumenypagos.Producto {


    }

}
