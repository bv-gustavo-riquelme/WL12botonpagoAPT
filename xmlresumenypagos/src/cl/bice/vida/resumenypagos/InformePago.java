
package cl.bice.vida.resumenypagos;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *                         &lt;enumeration value="SANTAN"/>
 *                         &lt;enumeration value="SERVIP"/>
 *                         &lt;enumeration value="BCHILE"/>
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
 *         &lt;element name="InfoNavegacion" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IDNavegacion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="Entrada" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IdTransaccion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="NumTransaccionMedio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="RutCliente" type="{}cod_persona"/>
 *         &lt;element name="NombreCliente" type="{}descripcion"/>
 *         &lt;element name="FechaConsulta" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;choice>
 *           &lt;element name="PagoExitoso">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="FechaUF" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                     &lt;element name="ValorUF">
 *                       &lt;simpleType>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                           &lt;fractionDigits value="2"/>
 *                         &lt;/restriction>
 *                       &lt;/simpleType>
 *                     &lt;/element>
 *                     &lt;element name="ProductosPorPagar">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;sequence maxOccurs="unbounded">
 *                                 &lt;element name="Entrada">
 *                                   &lt;complexType>
 *                                     &lt;complexContent>
 *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                         &lt;sequence>
 *                                           &lt;element name="Producto">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{}producto">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                                                     &lt;element name="DescripcionProducto" type="{}descripcion"/>
 *                                                     &lt;element name="NumProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                                                     &lt;element name="CodEmpresa" type="{}cod_persona"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="Cuota">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                     &lt;element name="Monto">
 *                                                       &lt;complexType>
 *                                                         &lt;complexContent>
 *                                                           &lt;restriction base="{}montoCuota">
 *                                                             &lt;sequence>
 *                                                               &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                                                               &lt;element name="EnUF" type="{}montoUF"/>
 *                                                               &lt;element name="Detalle" type="{}detalleCargos"/>
 *                                                             &lt;/sequence>
 *                                                           &lt;/restriction>
 *                                                         &lt;/complexContent>
 *                                                       &lt;/complexType>
 *                                                     &lt;/element>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                         &lt;/sequence>
 *                                         &lt;attribute name="contador" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                                       &lt;/restriction>
 *                                     &lt;/complexContent>
 *                                   &lt;/complexType>
 *                                 &lt;/element>
 *                               &lt;/sequence>
 *                               &lt;element name="TotalPorPagar">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                                         &lt;element name="EnUF" type="{}montoUF"/>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                     &lt;element name="Convenio">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                               &lt;element name="Descripcion" type="{}descripcion"/>
 *                             &lt;/sequence>
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
 *           &lt;element name="PagoRechazado">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence>
 *                     &lt;element name="CodError" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                     &lt;element name="Mensaje" type="{}descripcion"/>
 *                   &lt;/sequence>
 *                 &lt;/restriction>
 *               &lt;/complexContent>
 *             &lt;/complexType>
 *           &lt;/element>
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
         "identificacionMensaje", "infoNavegacion", "idTransaccion", "numTransaccionMedio", "rutCliente",
         "nombreCliente", "fechaConsulta", "pagoExitoso", "pagoRechazado"
    })
@XmlRootElement(name = "InformePago")
public class InformePago {

    @XmlElement(name = "IdentificacionMensaje", required = true)
    protected InformePago.IdentificacionMensaje identificacionMensaje;
    @XmlElement(name = "InfoNavegacion")
    protected InformePago.InfoNavegacion infoNavegacion;
    @XmlElement(name = "IdTransaccion", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idTransaccion;
    @XmlElement(name = "NumTransaccionMedio", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numTransaccionMedio;
    @XmlElement(name = "RutCliente")
    @XmlSchemaType(name = "integer")
    protected int rutCliente;
    @XmlElement(name = "NombreCliente", required = true)
    protected String nombreCliente;
    @XmlElement(name = "FechaConsulta", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaConsulta;
    @XmlElement(name = "PagoExitoso")
    protected InformePago.PagoExitoso pagoExitoso;
    @XmlElement(name = "PagoRechazado")
    protected InformePago.PagoRechazado pagoRechazado;

    /**
     * Gets the value of the identificacionMensaje property.
     *
     * @return
     *     possible object is
     *     {@link InformePago.IdentificacionMensaje }
     *
     */
    public InformePago.IdentificacionMensaje getIdentificacionMensaje() {
        return identificacionMensaje;
    }

    /**
     * Sets the value of the identificacionMensaje property.
     *
     * @param value
     *     allowed object is
     *     {@link InformePago.IdentificacionMensaje }
     *
     */
    public void setIdentificacionMensaje(InformePago.IdentificacionMensaje value) {
        this.identificacionMensaje = value;
    }

    /**
     * Gets the value of the infoNavegacion property.
     *
     * @return
     *     possible object is
     *     {@link InformePago.InfoNavegacion }
     *
     */
    public InformePago.InfoNavegacion getInfoNavegacion() {
        return infoNavegacion;
    }

    /**
     * Sets the value of the infoNavegacion property.
     *
     * @param value
     *     allowed object is
     *     {@link InformePago.InfoNavegacion }
     *
     */
    public void setInfoNavegacion(InformePago.InfoNavegacion value) {
        this.infoNavegacion = value;
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
     * Gets the value of the rutCliente property.
     *
     */
    public int getRutCliente() {
        return rutCliente;
    }

    /**
     * Sets the value of the rutCliente property.
     *
     */
    public void setRutCliente(int value) {
        this.rutCliente = value;
    }

    /**
     * Gets the value of the nombreCliente property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Sets the value of the nombreCliente property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNombreCliente(String value) {
        this.nombreCliente = value;
    }

    /**
     * Gets the value of the fechaConsulta property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * Sets the value of the fechaConsulta property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechaConsulta(XMLGregorianCalendar value) {
        this.fechaConsulta = value;
    }

    /**
     * Gets the value of the pagoExitoso property.
     *
     * @return
     *     possible object is
     *     {@link InformePago.PagoExitoso }
     *
     */
    public InformePago.PagoExitoso getPagoExitoso() {
        return pagoExitoso;
    }

    /**
     * Sets the value of the pagoExitoso property.
     *
     * @param value
     *     allowed object is
     *     {@link InformePago.PagoExitoso }
     *
     */
    public void setPagoExitoso(InformePago.PagoExitoso value) {
        this.pagoExitoso = value;
    }

    /**
     * Gets the value of the pagoRechazado property.
     *
     * @return
     *     possible object is
     *     {@link InformePago.PagoRechazado }
     *
     */
    public InformePago.PagoRechazado getPagoRechazado() {
        return pagoRechazado;
    }

    /**
     * Sets the value of the pagoRechazado property.
     *
     * @param value
     *     allowed object is
     *     {@link InformePago.PagoRechazado }
     *
     */
    public void setPagoRechazado(InformePago.PagoRechazado value) {
        this.pagoRechazado = value;
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
     *               &lt;enumeration value="BCHILE"/>
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
     *       &lt;sequence>
     *         &lt;element name="IDNavegacion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="Entrada" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "idNavegacion", "entrada" })
    public static class InfoNavegacion {

        @XmlElement(name = "IDNavegacion", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger idNavegacion;
        @XmlElement(name = "Entrada", required = true)
        protected Object entrada;

        /**
         * Gets the value of the idNavegacion property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getIDNavegacion() {
            return idNavegacion;
        }

        /**
         * Sets the value of the idNavegacion property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setIDNavegacion(BigInteger value) {
            this.idNavegacion = value;
        }

        /**
         * Gets the value of the entrada property.
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getEntrada() {
            return entrada;
        }

        /**
         * Sets the value of the entrada property.
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setEntrada(Object value) {
            this.entrada = value;
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
     *         &lt;element name="FechaUF" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="ValorUF">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *               &lt;fractionDigits value="2"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="ProductosPorPagar">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;sequence maxOccurs="unbounded">
     *                     &lt;element name="Entrada">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="Producto">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;restriction base="{}producto">
     *                                       &lt;sequence>
     *                                         &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                                         &lt;element name="DescripcionProducto" type="{}descripcion"/>
     *                                         &lt;element name="NumProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                                         &lt;element name="CodEmpresa" type="{}cod_persona"/>
     *                                       &lt;/sequence>
     *                                     &lt;/restriction>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                               &lt;element name="Cuota">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                       &lt;sequence>
     *                                         &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                                         &lt;element name="Monto">
     *                                           &lt;complexType>
     *                                             &lt;complexContent>
     *                                               &lt;restriction base="{}montoCuota">
     *                                                 &lt;sequence>
     *                                                   &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                                                   &lt;element name="EnUF" type="{}montoUF"/>
     *                                                   &lt;element name="Detalle" type="{}detalleCargos"/>
     *                                                 &lt;/sequence>
     *                                               &lt;/restriction>
     *                                             &lt;/complexContent>
     *                                           &lt;/complexType>
     *                                         &lt;/element>
     *                                       &lt;/sequence>
     *                                     &lt;/restriction>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                             &lt;/sequence>
     *                             &lt;attribute name="contador" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                   &lt;element name="TotalPorPagar">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                             &lt;element name="EnUF" type="{}montoUF"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Convenio">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                   &lt;element name="Descripcion" type="{}descripcion"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
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
    @XmlType(name = "", propOrder = { "fechaUF", "valorUF", "productosPorPagar", "convenio" })
    public static class PagoExitoso {

        @XmlElement(name = "FechaUF", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fechaUF;
        @XmlElement(name = "ValorUF", required = true)
        protected BigDecimal valorUF;
        @XmlElement(name = "ProductosPorPagar", required = true)
        protected InformePago.PagoExitoso.ProductosPorPagar productosPorPagar;
        @XmlElement(name = "Convenio", required = true)
        protected InformePago.PagoExitoso.Convenio convenio;

        /**
         * Gets the value of the fechaUF property.
         *
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public XMLGregorianCalendar getFechaUF() {
            return fechaUF;
        }

        /**
         * Sets the value of the fechaUF property.
         *
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *
         */
        public void setFechaUF(XMLGregorianCalendar value) {
            this.fechaUF = value;
        }

        /**
         * Gets the value of the valorUF property.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getValorUF() {
            return valorUF;
        }

        /**
         * Sets the value of the valorUF property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setValorUF(BigDecimal value) {
            this.valorUF = value;
        }

        /**
         * Gets the value of the productosPorPagar property.
         *
         * @return
         *     possible object is
         *     {@link InformePago.PagoExitoso.ProductosPorPagar }
         *
         */
        public InformePago.PagoExitoso.ProductosPorPagar getProductosPorPagar() {
            return productosPorPagar;
        }

        /**
         * Sets the value of the productosPorPagar property.
         *
         * @param value
         *     allowed object is
         *     {@link InformePago.PagoExitoso.ProductosPorPagar }
         *
         */
        public void setProductosPorPagar(InformePago.PagoExitoso.ProductosPorPagar value) {
            this.productosPorPagar = value;
        }

        /**
         * Gets the value of the convenio property.
         *
         * @return
         *     possible object is
         *     {@link InformePago.PagoExitoso.Convenio }
         *
         */
        public InformePago.PagoExitoso.Convenio getConvenio() {
            return convenio;
        }

        /**
         * Sets the value of the convenio property.
         *
         * @param value
         *     allowed object is
         *     {@link InformePago.PagoExitoso.Convenio }
         *
         */
        public void setConvenio(InformePago.PagoExitoso.Convenio value) {
            this.convenio = value;
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
         *         &lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *         &lt;element name="Descripcion" type="{}descripcion"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "codigo", "descripcion" })
        public static class Convenio {

            @XmlElement(name = "Codigo", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger codigo;
            @XmlElement(name = "Descripcion", required = true)
            protected String descripcion;

            /**
             * Gets the value of the codigo property.
             *
             * @return
             *     possible object is
             *     {@link BigInteger }
             *
             */
            public BigInteger getCodigo() {
                return codigo;
            }

            /**
             * Sets the value of the codigo property.
             *
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *
             */
            public void setCodigo(BigInteger value) {
                this.codigo = value;
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
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;sequence maxOccurs="unbounded">
         *           &lt;element name="Entrada">
         *             &lt;complexType>
         *               &lt;complexContent>
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                   &lt;sequence>
         *                     &lt;element name="Producto">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{}producto">
         *                             &lt;sequence>
         *                               &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *                               &lt;element name="DescripcionProducto" type="{}descripcion"/>
         *                               &lt;element name="NumProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *                               &lt;element name="CodEmpresa" type="{}cod_persona"/>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="Cuota">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                               &lt;element name="Monto">
         *                                 &lt;complexType>
         *                                   &lt;complexContent>
         *                                     &lt;restriction base="{}montoCuota">
         *                                       &lt;sequence>
         *                                         &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *                                         &lt;element name="EnUF" type="{}montoUF"/>
         *                                         &lt;element name="Detalle" type="{}detalleCargos"/>
         *                                       &lt;/sequence>
         *                                     &lt;/restriction>
         *                                   &lt;/complexContent>
         *                                 &lt;/complexType>
         *                               &lt;/element>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                   &lt;/sequence>
         *                   &lt;attribute name="contador" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *                 &lt;/restriction>
         *               &lt;/complexContent>
         *             &lt;/complexType>
         *           &lt;/element>
         *         &lt;/sequence>
         *         &lt;element name="TotalPorPagar">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *                   &lt;element name="EnUF" type="{}montoUF"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
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
        @XmlType(name = "", propOrder = { "entrada", "totalPorPagar" })
        public static class ProductosPorPagar {

            @XmlElement(name = "Entrada", required = true)
            protected List<InformePago.PagoExitoso.ProductosPorPagar.Entrada> entrada;
            @XmlElement(name = "TotalPorPagar", required = true)
            protected InformePago.PagoExitoso.ProductosPorPagar.TotalPorPagar totalPorPagar;

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
             * {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada }
             *
             *
             */
            public List<InformePago.PagoExitoso.ProductosPorPagar.Entrada> getEntrada() {
                if (entrada == null) {
                    entrada = new ArrayList<InformePago.PagoExitoso.ProductosPorPagar.Entrada>();
                }
                return this.entrada;
            }

            /**
             * Gets the value of the totalPorPagar property.
             *
             * @return
             *     possible object is
             *     {@link InformePago.PagoExitoso.ProductosPorPagar.TotalPorPagar }
             *
             */
            public InformePago.PagoExitoso.ProductosPorPagar.TotalPorPagar getTotalPorPagar() {
                return totalPorPagar;
            }

            /**
             * Sets the value of the totalPorPagar property.
             *
             * @param value
             *     allowed object is
             *     {@link InformePago.PagoExitoso.ProductosPorPagar.TotalPorPagar }
             *
             */
            public void setTotalPorPagar(InformePago.PagoExitoso.ProductosPorPagar.TotalPorPagar value) {
                this.totalPorPagar = value;
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
             *         &lt;element name="Producto">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{}producto">
             *                 &lt;sequence>
             *                   &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
             *                   &lt;element name="DescripcionProducto" type="{}descripcion"/>
             *                   &lt;element name="NumProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
             *                   &lt;element name="CodEmpresa" type="{}cod_persona"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="Cuota">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *                   &lt;element name="Monto">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{}montoCuota">
             *                           &lt;sequence>
             *                             &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
             *                             &lt;element name="EnUF" type="{}montoUF"/>
             *                             &lt;element name="Detalle" type="{}detalleCargos"/>
             *                           &lt;/sequence>
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="contador" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = { "producto", "cuota" })
            public static class Entrada {

                @XmlElement(name = "Producto", required = true)
                protected InformePago.PagoExitoso.ProductosPorPagar.Entrada.Producto producto;
                @XmlElement(name = "Cuota", required = true)
                protected InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota cuota;
                @XmlAttribute(name = "contador", required = true)
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger contador;

                /**
                 * Gets the value of the producto property.
                 *
                 * @return
                 *     possible object is
                 *     {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada.Producto }
                 *
                 */
                public InformePago.PagoExitoso.ProductosPorPagar.Entrada.Producto getProducto() {
                    return producto;
                }

                /**
                 * Sets the value of the producto property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada.Producto }
                 *
                 */
                public void setProducto(InformePago.PagoExitoso.ProductosPorPagar.Entrada.Producto value) {
                    this.producto = value;
                }

                /**
                 * Gets the value of the cuota property.
                 *
                 * @return
                 *     possible object is
                 *     {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota }
                 *
                 */
                public InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota getCuota() {
                    return cuota;
                }

                /**
                 * Sets the value of the cuota property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota }
                 *
                 */
                public void setCuota(InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota value) {
                    this.cuota = value;
                }

                /**
                 * Gets the value of the contador property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getContador() {
                    return contador;
                }

                /**
                 * Sets the value of the contador property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setContador(BigInteger value) {
                    this.contador = value;
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
                 *         &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
                 *         &lt;element name="Monto">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{}montoCuota">
                 *                 &lt;sequence>
                 *                   &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
                 *                   &lt;element name="EnUF" type="{}montoUF"/>
                 *                   &lt;element name="Detalle" type="{}detalleCargos"/>
                 *                 &lt;/sequence>
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
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
                @XmlType(name = "", propOrder = { "fechaVencimiento", "monto" })
                public static class Cuota {

                    @XmlElement(name = "FechaVencimiento", required = true)
                    @XmlSchemaType(name = "date")
                    protected XMLGregorianCalendar fechaVencimiento;
                    @XmlElement(name = "Monto", required = true)
                    protected InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota.Monto monto;

                    /**
                     * Gets the value of the fechaVencimiento property.
                     *
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *
                     */
                    public XMLGregorianCalendar getFechaVencimiento() {
                        return fechaVencimiento;
                    }

                    /**
                     * Sets the value of the fechaVencimiento property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *
                     */
                    public void setFechaVencimiento(XMLGregorianCalendar value) {
                        this.fechaVencimiento = value;
                    }

                    /**
                     * Gets the value of the monto property.
                     *
                     * @return
                     *     possible object is
                     *     {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota.Monto }
                     *
                     */
                    public InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota.Monto getMonto() {
                        return monto;
                    }

                    /**
                     * Sets the value of the monto property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota.Monto }
                     *
                     */
                    public void setMonto(InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota.Monto value) {
                        this.monto = value;
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
                     *         &lt;element name="Detalle" type="{}detalleCargos"/>
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
                    public static class Monto extends MontoCuota {


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
            @XmlType(name = "", propOrder = { "enPesos", "enUF" })
            public static class TotalPorPagar {

                @XmlElement(name = "EnPesos", required = true)
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger enPesos;
                @XmlElement(name = "EnUF", required = true)
                protected BigDecimal enUF;

                /**
                 * Gets the value of the enPesos property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getEnPesos() {
                    return enPesos;
                }

                /**
                 * Sets the value of the enPesos property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setEnPesos(BigInteger value) {
                    this.enPesos = value;
                }

                /**
                 * Gets the value of the enUF property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getEnUF() {
                    return enUF;
                }

                /**
                 * Sets the value of the enUF property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setEnUF(BigDecimal value) {
                    this.enUF = value;
                }

            }

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
     *         &lt;element name="Mensaje" type="{}descripcion"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "codError", "mensaje" })
    public static class PagoRechazado {

        @XmlElement(name = "CodError", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger codError;
        @XmlElement(name = "Mensaje", required = true)
        protected String mensaje;

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
         * Gets the value of the mensaje property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getMensaje() {
            return mensaje;
        }

        /**
         * Sets the value of the mensaje property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setMensaje(String value) {
            this.mensaje = value;
        }

    }

}
