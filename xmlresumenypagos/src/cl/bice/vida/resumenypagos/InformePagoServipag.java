
package cl.bice.vida.resumenypagos;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="NumTransaccionServipag" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;choice>
 *           &lt;element name="Error">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="CodError" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                     &lt;element name="Descripcion">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                           &lt;maxLength value="200"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;sequence>
 *             &lt;element name="DetallePago">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;sequence>
 *                       &lt;element name="CodMedioPago">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                             &lt;length value="3"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="NumTransaccionMedio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                       &lt;element name="FormaPago">
 *                         &lt;simpleType>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *                             &lt;enumeration value="1"/>
 *                             &lt;enumeration value="2"/>
 *                           &lt;/restriction>
 *                         &lt;/simpleType>
 *                       &lt;/element>
 *                       &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                       &lt;element name="FechaPagoContable" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;/sequence>
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *             &lt;element name="ProductosPagados">
 *               &lt;complexType>
 *                 &lt;complexContent>
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                     &lt;sequence maxOccurs="unbounded">
 *                       &lt;element name="Entrada" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                     &lt;/sequence>
 *                   &lt;/restriction>
 *                 &lt;/complexContent>
 *               &lt;/complexType>
 *             &lt;/element>
 *             &lt;element name="MontoTotalPagado" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *           &lt;/sequence>
 *         &lt;/choice>
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
         "identificacionMensaje", "idTransaccion", "numTransaccionServipag", "error", "detallePago", "productosPagados",
         "montoTotalPagado"
    })
@XmlRootElement(name = "InformePagoServipag")
public class InformePagoServipag {

    @XmlElement(name = "IdentificacionMensaje", required = true)
    protected InformePagoServipag.IdentificacionMensaje identificacionMensaje;
    @XmlElement(name = "IdTransaccion", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idTransaccion;
    @XmlElement(name = "NumTransaccionServipag", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numTransaccionServipag;
    @XmlElement(name = "Error")
    protected InformePagoServipag.Error error;
    @XmlElement(name = "DetallePago")
    protected InformePagoServipag.DetallePago detallePago;
    @XmlElement(name = "ProductosPagados")
    protected InformePagoServipag.ProductosPagados productosPagados;
    @XmlElement(name = "MontoTotalPagado")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger montoTotalPagado;

    /**
     * Gets the value of the identificacionMensaje property.
     *
     * @return
     *     possible object is
     *     {@link InformePagoServipag.IdentificacionMensaje }
     *
     */
    public InformePagoServipag.IdentificacionMensaje getIdentificacionMensaje() {
        return identificacionMensaje;
    }

    /**
     * Sets the value of the identificacionMensaje property.
     *
     * @param value
     *     allowed object is
     *     {@link InformePagoServipag.IdentificacionMensaje }
     *
     */
    public void setIdentificacionMensaje(InformePagoServipag.IdentificacionMensaje value) {
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
     * Gets the value of the numTransaccionServipag property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getNumTransaccionServipag() {
        return numTransaccionServipag;
    }

    /**
     * Sets the value of the numTransaccionServipag property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNumTransaccionServipag(BigInteger value) {
        this.numTransaccionServipag = value;
    }

    /**
     * Gets the value of the error property.
     *
     * @return
     *     possible object is
     *     {@link InformePagoServipag.Error }
     *
     */
    public InformePagoServipag.Error getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     *
     * @param value
     *     allowed object is
     *     {@link InformePagoServipag.Error }
     *
     */
    public void setError(InformePagoServipag.Error value) {
        this.error = value;
    }

    /**
     * Gets the value of the detallePago property.
     *
     * @return
     *     possible object is
     *     {@link InformePagoServipag.DetallePago }
     *
     */
    public InformePagoServipag.DetallePago getDetallePago() {
        return detallePago;
    }

    /**
     * Sets the value of the detallePago property.
     *
     * @param value
     *     allowed object is
     *     {@link InformePagoServipag.DetallePago }
     *
     */
    public void setDetallePago(InformePagoServipag.DetallePago value) {
        this.detallePago = value;
    }

    /**
     * Gets the value of the productosPagados property.
     *
     * @return
     *     possible object is
     *     {@link InformePagoServipag.ProductosPagados }
     *
     */
    public InformePagoServipag.ProductosPagados getProductosPagados() {
        return productosPagados;
    }

    /**
     * Sets the value of the productosPagados property.
     *
     * @param value
     *     allowed object is
     *     {@link InformePagoServipag.ProductosPagados }
     *
     */
    public void setProductosPagados(InformePagoServipag.ProductosPagados value) {
        this.productosPagados = value;
    }

    /**
     * Gets the value of the montoTotalPagado property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getMontoTotalPagado() {
        return montoTotalPagado;
    }

    /**
     * Sets the value of the montoTotalPagado property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setMontoTotalPagado(BigInteger value) {
        this.montoTotalPagado = value;
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
     *         &lt;element name="CodMedioPago">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;length value="3"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="NumTransaccionMedio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="FormaPago">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
     *               &lt;enumeration value="1"/>
     *               &lt;enumeration value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="FechaPagoContable" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
             "codMedioPago", "numTransaccionMedio", "formaPago", "fechaPago", "fechaPagoContable" })
    public static class DetallePago {

        @XmlElement(name = "CodMedioPago", required = true)
        protected String codMedioPago;
        @XmlElement(name = "NumTransaccionMedio", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger numTransaccionMedio;
        @XmlElement(name = "FormaPago")
        protected int formaPago;
        @XmlElement(name = "FechaPago", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fechaPago;
        @XmlElement(name = "FechaPagoContable", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fechaPagoContable;

        /**
         * Gets the value of the codMedioPago property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCodMedioPago() {
            return codMedioPago;
        }

        /**
         * Sets the value of the codMedioPago property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCodMedioPago(String value) {
            this.codMedioPago = value;
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
         * Gets the value of the formaPago property.
         *
         */
        public int getFormaPago() {
            return formaPago;
        }

        /**
         * Sets the value of the formaPago property.
         *
         */
        public void setFormaPago(int value) {
            this.formaPago = value;
        }

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
         * Gets the value of the fechaPagoContable property.
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getFechaPagoContable() {
            return fechaPagoContable;
        }

        /**
         * Sets the value of the fechaPagoContable property.
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setFechaPagoContable(XMLGregorianCalendar value) {
            this.fechaPagoContable = value;
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


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="Entrada" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "entrada" })
    public static class ProductosPagados {

        @XmlElement(name = "Entrada", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected List<BigInteger> entrada;

        /**
         * Gets the value of the entrada property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entrada property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntrada().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BigInteger }
         *
         *
         */
        public List<BigInteger> getEntrada() {
            if (entrada == null) {
                entrada = new ArrayList<BigInteger>();
            }
            return this.entrada;
        }

    }

}
