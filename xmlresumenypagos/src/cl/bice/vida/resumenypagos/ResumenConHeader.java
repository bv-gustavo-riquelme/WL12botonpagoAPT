
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
 *                   &lt;element name="De" type="{}deFormato"/>
 *                   &lt;element name="FechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="Accion">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="PAGAR"/>
 *                         &lt;enumeration value="CONSULTA"/>
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
 *                   &lt;element name="Entrada" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IdTransaccion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="RutCliente" type="{}cod_persona"/>
 *         &lt;element name="NombreCliente" type="{}descripcion"/>
 *         &lt;element name="FechaConsulta" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="FechaUF" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ValorUF">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Turno" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Titulos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="Titulo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ProductosPorPagar">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence maxOccurs="unbounded" minOccurs="0">
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
 *                                         &lt;element name="TipoCuota" type="{}tipoCuotaFormato"/>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                               &lt;element name="InfoCajas" type="{}infocajas"/>
 *                               &lt;element name="Cuota">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="MedioPago" type="{}medioPago"/>
 *                                         &lt;element name="InfoPA" minOccurs="0">
 *                                           &lt;complexType>
 *                                             &lt;complexContent>
 *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                 &lt;sequence>
 *                                                   &lt;element name="ValorUF">
 *                                                     &lt;simpleType>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                         &lt;fractionDigits value="2"/>
 *                                                       &lt;/restriction>
 *                                                     &lt;/simpleType>
 *                                                   &lt;/element>
 *                                                   &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                                 &lt;/sequence>
 *                                               &lt;/restriction>
 *                                             &lt;/complexContent>
 *                                           &lt;/complexType>
 *                                         &lt;/element>
 *                                         &lt;choice>
 *                                           &lt;element name="CuotaOpcion">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="CuotaMin">
 *                                                       &lt;complexType>
 *                                                         &lt;complexContent>
 *                                                           &lt;extension base="{}montoCuota">
 *                                                             &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *                                                           &lt;/extension>
 *                                                         &lt;/complexContent>
 *                                                       &lt;/complexType>
 *                                                     &lt;/element>
 *                                                     &lt;element name="CuotaMax" minOccurs="0">
 *                                                       &lt;complexType>
 *                                                         &lt;complexContent>
 *                                                           &lt;extension base="{}montoCuota">
 *                                                             &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                                                           &lt;/extension>
 *                                                         &lt;/complexContent>
 *                                                       &lt;/complexType>
 *                                                     &lt;/element>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="CuotaVariable">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="CuotaFija" type="{}montoCuota"/>
 *                                                     &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="CuotaFija" type="{}montoCuota"/>
 *                                         &lt;/choice>
 *                                         &lt;element name="Pago" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                                         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;/sequence>
 *                                     &lt;/restriction>
 *                                   &lt;/complexContent>
 *                                 &lt;/complexType>
 *                               &lt;/element>
 *                             &lt;/sequence>
 *                             &lt;attribute name="contador" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                             &lt;attribute name="seleccionado" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                             &lt;attribute name="disabled" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *                           &lt;/restriction>
 *                         &lt;/complexContent>
 *                       &lt;/complexType>
 *                     &lt;/element>
 *                   &lt;/sequence>
 *                   &lt;element name="TotalPorPagar" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                   &lt;element name="TotalDeuda" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ProductosPagados">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;sequence maxOccurs="unbounded" minOccurs="0">
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
 *                                         &lt;element name="TipoCuota" type="{}tipoCuotaFormato"/>
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
 *                                         &lt;element name="MedioPago" type="{}medioPago"/>
 *                                         &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="ValorUF">
 *                                           &lt;simpleType>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                               &lt;fractionDigits value="2"/>
 *                                             &lt;/restriction>
 *                                           &lt;/simpleType>
 *                                         &lt;/element>
 *                                         &lt;choice>
 *                                           &lt;element name="CuotaFija" type="{}montoCuota"/>
 *                                           &lt;element name="CuotaVariable">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="CuotaFija" type="{}montoCuota"/>
 *                                                     &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                           &lt;element name="CuotaOpcion">
 *                                             &lt;complexType>
 *                                               &lt;complexContent>
 *                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                   &lt;sequence>
 *                                                     &lt;element name="CuotaMin" type="{}montoCuota"/>
 *                                                     &lt;element name="CuotaMax" type="{}montoCuota" minOccurs="0"/>
 *                                                   &lt;/sequence>
 *                                                 &lt;/restriction>
 *                                               &lt;/complexContent>
 *                                             &lt;/complexType>
 *                                           &lt;/element>
 *                                         &lt;/choice>
 *                                         &lt;element name="TotalPagado" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                                         &lt;choice>
 *                                           &lt;element name="EstadoInternet" type="{}estadoInternet"/>
 *                                           &lt;element name="EstadoCaja" type="{}estadoCaja"/>
 *                                         &lt;/choice>
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
 *                   &lt;element name="TotalPagado" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Convenios">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="Convenio">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                             &lt;element name="Descripcion" type="{}descripcion"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TotalPagar" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
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
         "identificacionMensaje", "infoNavegacion", "idTransaccion", "rutCliente", "nombreCliente", "fechaConsulta",
         "fechaUF", "valorUF", "turno", "titulos", "productosPorPagar", "productosPagados", "convenios", "totalPagar"
    })
@XmlRootElement(name = "ResumenConHeader")
public class ResumenConHeader {

    @XmlElement(name = "IdentificacionMensaje", required = true)
    protected ResumenConHeader.IdentificacionMensaje identificacionMensaje;
    @XmlElement(name = "InfoNavegacion")
    protected ResumenConHeader.InfoNavegacion infoNavegacion;
    @XmlElement(name = "IdTransaccion")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger idTransaccion;
    @XmlElement(name = "RutCliente")
    @XmlSchemaType(name = "integer")
    protected int rutCliente;
    @XmlElement(name = "NombreCliente", required = true)
    protected String nombreCliente;
    @XmlElement(name = "FechaConsulta", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaConsulta;
    @XmlElement(name = "FechaUF", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaUF;
    @XmlElement(name = "ValorUF", required = true)
    protected BigDecimal valorUF;
    @XmlElement(name = "Turno")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar turno;
    @XmlElement(name = "Titulos", required = true)
    protected ResumenConHeader.Titulos titulos;
    @XmlElement(name = "ProductosPorPagar", required = true)
    protected ResumenConHeader.ProductosPorPagar productosPorPagar;
    @XmlElement(name = "ProductosPagados", required = true)
    protected ResumenConHeader.ProductosPagados productosPagados;
    @XmlElement(name = "Convenios", required = true)
    protected ResumenConHeader.Convenios convenios;
    @XmlElement(name = "TotalPagar", required = true, defaultValue = "0")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger totalPagar;

    /**
     * Gets the value of the identificacionMensaje property.
     *
     * @return
     *     possible object is
     *     {@link ResumenConHeader.IdentificacionMensaje }
     *
     */
    public ResumenConHeader.IdentificacionMensaje getIdentificacionMensaje() {
        return identificacionMensaje;
    }

    /**
     * Sets the value of the identificacionMensaje property.
     *
     * @param value
     *     allowed object is
     *     {@link ResumenConHeader.IdentificacionMensaje }
     *
     */
    public void setIdentificacionMensaje(ResumenConHeader.IdentificacionMensaje value) {
        this.identificacionMensaje = value;
    }

    /**
     * Gets the value of the infoNavegacion property.
     *
     * @return
     *     possible object is
     *     {@link ResumenConHeader.InfoNavegacion }
     *
     */
    public ResumenConHeader.InfoNavegacion getInfoNavegacion() {
        return infoNavegacion;
    }

    /**
     * Sets the value of the infoNavegacion property.
     *
     * @param value
     *     allowed object is
     *     {@link ResumenConHeader.InfoNavegacion }
     *
     */
    public void setInfoNavegacion(ResumenConHeader.InfoNavegacion value) {
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
     * Gets the value of the turno property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getTurno() {
        return turno;
    }

    /**
     * Sets the value of the turno property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setTurno(XMLGregorianCalendar value) {
        this.turno = value;
    }

    /**
     * Gets the value of the titulos property.
     *
     * @return
     *     possible object is
     *     {@link ResumenConHeader.Titulos }
     *
     */
    public ResumenConHeader.Titulos getTitulos() {
        return titulos;
    }

    /**
     * Sets the value of the titulos property.
     *
     * @param value
     *     allowed object is
     *     {@link ResumenConHeader.Titulos }
     *
     */
    public void setTitulos(ResumenConHeader.Titulos value) {
        this.titulos = value;
    }

    /**
     * Gets the value of the productosPorPagar property.
     *
     * @return
     *     possible object is
     *     {@link ResumenConHeader.ProductosPorPagar }
     *
     */
    public ResumenConHeader.ProductosPorPagar getProductosPorPagar() {
        return productosPorPagar;
    }

    /**
     * Sets the value of the productosPorPagar property.
     *
     * @param value
     *     allowed object is
     *     {@link ResumenConHeader.ProductosPorPagar }
     *
     */
    public void setProductosPorPagar(ResumenConHeader.ProductosPorPagar value) {
        this.productosPorPagar = value;
    }

    /**
     * Gets the value of the productosPagados property.
     *
     * @return
     *     possible object is
     *     {@link ResumenConHeader.ProductosPagados }
     *
     */
    public ResumenConHeader.ProductosPagados getProductosPagados() {
        return productosPagados;
    }

    /**
     * Sets the value of the productosPagados property.
     *
     * @param value
     *     allowed object is
     *     {@link ResumenConHeader.ProductosPagados }
     *
     */
    public void setProductosPagados(ResumenConHeader.ProductosPagados value) {
        this.productosPagados = value;
    }

    /**
     * Gets the value of the convenios property.
     *
     * @return
     *     possible object is
     *     {@link ResumenConHeader.Convenios }
     *
     */
    public ResumenConHeader.Convenios getConvenios() {
        return convenios;
    }

    /**
     * Sets the value of the convenios property.
     *
     * @param value
     *     allowed object is
     *     {@link ResumenConHeader.Convenios }
     *
     */
    public void setConvenios(ResumenConHeader.Convenios value) {
        this.convenios = value;
    }

    /**
     * Gets the value of the totalPagar property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getTotalPagar() {
        return totalPagar;
    }

    /**
     * Sets the value of the totalPagar property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setTotalPagar(BigInteger value) {
        this.totalPagar = value;
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
     *         &lt;element name="Convenio">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Codigo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                   &lt;element name="Descripcion" type="{}descripcion"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
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
    @XmlType(name = "", propOrder = { "convenio" })
    public static class Convenios {

        @XmlElement(name = "Convenio", required = true)
        protected List<ResumenConHeader.Convenios.Convenio> convenio;

        /**
         * Gets the value of the convenio property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the convenio property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConvenio().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ResumenConHeader.Convenios.Convenio }
         *
         *
         */
        public List<ResumenConHeader.Convenios.Convenio> getConvenio() {
            if (convenio == null) {
                convenio = new ArrayList<ResumenConHeader.Convenios.Convenio>();
            }
            return this.convenio;
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
         *       &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
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
            @XmlAttribute(name = "seleccionado")
            protected Boolean seleccionado;

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

            /**
             * Gets the value of the seleccionado property.
             *
             * @return
             *     possible object is
             *     {@link Boolean }
             *
             */
            public boolean isSeleccionado() {
                if (seleccionado == null) {
                    return false;
                } else {
                    return seleccionado;
                }
            }

            /**
             * Sets the value of the seleccionado property.
             *
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *
             */
            public void setSeleccionado(Boolean value) {
                this.seleccionado = value;
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
     *     &lt;restriction base="{}identificacionMensaje">
     *       &lt;sequence>
     *         &lt;element name="Codigo">
     *           &lt;simpleType>
     *             &lt;restriction base="{}codigoFormato">
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Version" type="{}versionFormato"/>
     *         &lt;element name="De" type="{}deFormato"/>
     *         &lt;element name="FechaCreacion" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="Accion">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="PAGAR"/>
     *               &lt;enumeration value="CONSULTA"/>
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
    @XmlType(name = "", propOrder = { "idNavegacion", "entrada" })
    public static class InfoNavegacion {

        @XmlElement(name = "IDNavegacion", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger idNavegacion;
        @XmlElement(name = "Entrada", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger entrada;

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
         *     {@link BigInteger }
         *
         */
        public BigInteger getEntrada() {
            return entrada;
        }

        /**
         * Sets the value of the entrada property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setEntrada(BigInteger value) {
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
     *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
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
     *                               &lt;element name="TipoCuota" type="{}tipoCuotaFormato"/>
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
     *                               &lt;element name="MedioPago" type="{}medioPago"/>
     *                               &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element name="ValorUF">
     *                                 &lt;simpleType>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                     &lt;fractionDigits value="2"/>
     *                                   &lt;/restriction>
     *                                 &lt;/simpleType>
     *                               &lt;/element>
     *                               &lt;choice>
     *                                 &lt;element name="CuotaFija" type="{}montoCuota"/>
     *                                 &lt;element name="CuotaVariable">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                         &lt;sequence>
     *                                           &lt;element name="CuotaFija" type="{}montoCuota"/>
     *                                           &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
     *                                         &lt;/sequence>
     *                                       &lt;/restriction>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                                 &lt;element name="CuotaOpcion">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                         &lt;sequence>
     *                                           &lt;element name="CuotaMin" type="{}montoCuota"/>
     *                                           &lt;element name="CuotaMax" type="{}montoCuota" minOccurs="0"/>
     *                                         &lt;/sequence>
     *                                       &lt;/restriction>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                               &lt;/choice>
     *                               &lt;element name="TotalPagado" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *                               &lt;choice>
     *                                 &lt;element name="EstadoInternet" type="{}estadoInternet"/>
     *                                 &lt;element name="EstadoCaja" type="{}estadoCaja"/>
     *                               &lt;/choice>
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
     *         &lt;element name="TotalPagado" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "entrada", "totalPagado" })
    public static class ProductosPagados {

        @XmlElement(name = "Entrada")
        protected List<ResumenConHeader.ProductosPagados.Entrada> entrada;
        @XmlElement(name = "TotalPagado", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger totalPagado;

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
         * {@link ResumenConHeader.ProductosPagados.Entrada }
         *
         *
         */
        public List<ResumenConHeader.ProductosPagados.Entrada> getEntrada() {
            if (entrada == null) {
                entrada = new ArrayList<ResumenConHeader.ProductosPagados.Entrada>();
            }
            return this.entrada;
        }

        /**
         * Gets the value of the totalPagado property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getTotalPagado() {
            return totalPagado;
        }

        /**
         * Sets the value of the totalPagado property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setTotalPagado(BigInteger value) {
            this.totalPagado = value;
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
         *                   &lt;element name="TipoCuota" type="{}tipoCuotaFormato"/>
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
         *                   &lt;element name="MedioPago" type="{}medioPago"/>
         *                   &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="ValorUF">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                         &lt;fractionDigits value="2"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;choice>
         *                     &lt;element name="CuotaFija" type="{}montoCuota"/>
         *                     &lt;element name="CuotaVariable">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element name="CuotaFija" type="{}montoCuota"/>
         *                               &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="CuotaOpcion">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element name="CuotaMin" type="{}montoCuota"/>
         *                               &lt;element name="CuotaMax" type="{}montoCuota" minOccurs="0"/>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                   &lt;/choice>
         *                   &lt;element name="TotalPagado" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
         *                   &lt;choice>
         *                     &lt;element name="EstadoInternet" type="{}estadoInternet"/>
         *                     &lt;element name="EstadoCaja" type="{}estadoCaja"/>
         *                   &lt;/choice>
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
            protected ResumenConHeader.ProductosPagados.Entrada.Producto producto;
            @XmlElement(name = "Cuota", required = true)
            protected ResumenConHeader.ProductosPagados.Entrada.Cuota cuota;
            @XmlAttribute(name = "contador", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger contador;

            /**
             * Gets the value of the producto property.
             *
             * @return
             *     possible object is
             *     {@link ResumenConHeader.ProductosPagados.Entrada.Producto }
             *
             */
            public ResumenConHeader.ProductosPagados.Entrada.Producto getProducto() {
                return producto;
            }

            /**
             * Sets the value of the producto property.
             *
             * @param value
             *     allowed object is
             *     {@link ResumenConHeader.ProductosPagados.Entrada.Producto }
             *
             */
            public void setProducto(ResumenConHeader.ProductosPagados.Entrada.Producto value) {
                this.producto = value;
            }

            /**
             * Gets the value of the cuota property.
             *
             * @return
             *     possible object is
             *     {@link ResumenConHeader.ProductosPagados.Entrada.Cuota }
             *
             */
            public ResumenConHeader.ProductosPagados.Entrada.Cuota getCuota() {
                return cuota;
            }

            /**
             * Sets the value of the cuota property.
             *
             * @param value
             *     allowed object is
             *     {@link ResumenConHeader.ProductosPagados.Entrada.Cuota }
             *
             */
            public void setCuota(ResumenConHeader.ProductosPagados.Entrada.Cuota value) {
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
             *         &lt;element name="MedioPago" type="{}medioPago"/>
             *         &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="ValorUF">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *               &lt;fractionDigits value="2"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;choice>
             *           &lt;element name="CuotaFija" type="{}montoCuota"/>
             *           &lt;element name="CuotaVariable">
             *             &lt;complexType>
             *               &lt;complexContent>
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                   &lt;sequence>
             *                     &lt;element name="CuotaFija" type="{}montoCuota"/>
             *                     &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
             *                   &lt;/sequence>
             *                 &lt;/restriction>
             *               &lt;/complexContent>
             *             &lt;/complexType>
             *           &lt;/element>
             *           &lt;element name="CuotaOpcion">
             *             &lt;complexType>
             *               &lt;complexContent>
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                   &lt;sequence>
             *                     &lt;element name="CuotaMin" type="{}montoCuota"/>
             *                     &lt;element name="CuotaMax" type="{}montoCuota" minOccurs="0"/>
             *                   &lt;/sequence>
             *                 &lt;/restriction>
             *               &lt;/complexContent>
             *             &lt;/complexType>
             *           &lt;/element>
             *         &lt;/choice>
             *         &lt;element name="TotalPagado" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
             *         &lt;choice>
             *           &lt;element name="EstadoInternet" type="{}estadoInternet"/>
             *           &lt;element name="EstadoCaja" type="{}estadoCaja"/>
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
                     "fechaVencimiento", "medioPago", "fechaPago", "valorUF", "cuotaFija", "cuotaVariable",
                     "cuotaOpcion", "totalPagado", "estadoInternet", "estadoCaja"
                })
            public static class Cuota {

                @XmlElement(name = "FechaVencimiento", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar fechaVencimiento;
                @XmlElement(name = "MedioPago", required = true, defaultValue = "Internet")
                protected String medioPago;
                @XmlElement(name = "FechaPago", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar fechaPago;
                @XmlElement(name = "ValorUF", required = true)
                protected BigDecimal valorUF;
                @XmlElement(name = "CuotaFija")
                protected MontoCuota cuotaFija;
                @XmlElement(name = "CuotaVariable")
                protected ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaVariable cuotaVariable;
                @XmlElement(name = "CuotaOpcion")
                protected ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaOpcion cuotaOpcion;
                @XmlElement(name = "TotalPagado", required = true)
                @XmlSchemaType(name = "nonNegativeInteger")
                protected BigInteger totalPagado;
                @XmlElement(name = "EstadoInternet")
                protected EstadoInternet estadoInternet;
                @XmlElement(name = "EstadoCaja")
                protected EstadoCaja estadoCaja;

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
                 * Gets the value of the medioPago property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getMedioPago() {
                    return medioPago;
                }

                /**
                 * Sets the value of the medioPago property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setMedioPago(String value) {
                    this.medioPago = value;
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
                 * Gets the value of the cuotaFija property.
                 *
                 * @return
                 * possible object is
                 * {@link cl.bice.vida.resumenypagos.MontoCuota}
                 *
                 */
                public MontoCuota getCuotaFija() {
                    return cuotaFija;
                }

                /**
                 * Sets the value of the cuotaFija property.
                 *
                 * @param value
                 * allowed object is
                 * {@link cl.bice.vida.resumenypagos.MontoCuota}
                 *
                 */
                public void setCuotaFija(MontoCuota value) {
                    this.cuotaFija = value;
                }

                /**
                 * Gets the value of the cuotaVariable property.
                 *
                 * @return
                 *     possible object is
                 *     {@link ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaVariable }
                 *
                 */
                public ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaVariable getCuotaVariable() {
                    return cuotaVariable;
                }

                /**
                 * Sets the value of the cuotaVariable property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaVariable }
                 *
                 */
                public void setCuotaVariable(ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaVariable value) {
                    this.cuotaVariable = value;
                }

                /**
                 * Gets the value of the cuotaOpcion property.
                 *
                 * @return
                 *     possible object is
                 *     {@link ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaOpcion }
                 *
                 */
                public ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaOpcion getCuotaOpcion() {
                    return cuotaOpcion;
                }

                /**
                 * Sets the value of the cuotaOpcion property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaOpcion }
                 *
                 */
                public void setCuotaOpcion(ResumenConHeader.ProductosPagados.Entrada.Cuota.CuotaOpcion value) {
                    this.cuotaOpcion = value;
                }

                /**
                 * Gets the value of the totalPagado property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getTotalPagado() {
                    return totalPagado;
                }

                /**
                 * Sets the value of the totalPagado property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setTotalPagado(BigInteger value) {
                    this.totalPagado = value;
                }

                /**
                 * Gets the value of the estadoInternet property.
                 *
                 * @return
                 * possible object is
                 * {@link cl.bice.vida.resumenypagos.EstadoInternet}
                 *
                 */
                public EstadoInternet getEstadoInternet() {
                    return estadoInternet;
                }

                /**
                 * Sets the value of the estadoInternet property.
                 *
                 * @param value
                 * allowed object is
                 * {@link cl.bice.vida.resumenypagos.EstadoInternet}
                 *
                 */
                public void setEstadoInternet(EstadoInternet value) {
                    this.estadoInternet = value;
                }

                /**
                 * Gets the value of the estadoCaja property.
                 *
                 * @return
                 * possible object is
                 * {@link cl.bice.vida.resumenypagos.EstadoCaja}
                 *
                 */
                public EstadoCaja getEstadoCaja() {
                    return estadoCaja;
                }

                /**
                 * Sets the value of the estadoCaja property.
                 *
                 * @param value
                 * allowed object is
                 * {@link cl.bice.vida.resumenypagos.EstadoCaja}
                 *
                 */
                public void setEstadoCaja(EstadoCaja value) {
                    this.estadoCaja = value;
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
                 *         &lt;element name="CuotaMin" type="{}montoCuota"/>
                 *         &lt;element name="CuotaMax" type="{}montoCuota" minOccurs="0"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = { "cuotaMin", "cuotaMax" })
                public static class CuotaOpcion {

                    @XmlElement(name = "CuotaMin", required = true)
                    protected MontoCuota cuotaMin;
                    @XmlElement(name = "CuotaMax")
                    protected MontoCuota cuotaMax;

                    /**
                     * Gets the value of the cuotaMin property.
                     *
                     * @return
                     * possible object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public MontoCuota getCuotaMin() {
                        return cuotaMin;
                    }

                    /**
                     * Sets the value of the cuotaMin property.
                     *
                     * @param value
                     * allowed object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public void setCuotaMin(MontoCuota value) {
                        this.cuotaMin = value;
                    }

                    /**
                     * Gets the value of the cuotaMax property.
                     *
                     * @return
                     * possible object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public MontoCuota getCuotaMax() {
                        return cuotaMax;
                    }

                    /**
                     * Sets the value of the cuotaMax property.
                     *
                     * @param value
                     * allowed object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public void setCuotaMax(MontoCuota value) {
                        this.cuotaMax = value;
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
                 *         &lt;element name="CuotaFija" type="{}montoCuota"/>
                 *         &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = { "cuotaFija", "cuotaVariable" })
                public static class CuotaVariable {

                    @XmlElement(name = "CuotaFija", required = true)
                    protected MontoCuota cuotaFija;
                    @XmlElement(name = "CuotaVariable")
                    protected MontoCuota cuotaVariable;

                    /**
                     * Gets the value of the cuotaFija property.
                     *
                     * @return
                     * possible object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public MontoCuota getCuotaFija() {
                        return cuotaFija;
                    }

                    /**
                     * Sets the value of the cuotaFija property.
                     *
                     * @param value
                     * allowed object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public void setCuotaFija(MontoCuota value) {
                        this.cuotaFija = value;
                    }

                    /**
                     * Gets the value of the cuotaVariable property.
                     *
                     * @return
                     * possible object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public MontoCuota getCuotaVariable() {
                        return cuotaVariable;
                    }

                    /**
                     * Sets the value of the cuotaVariable property.
                     *
                     * @param value
                     * allowed object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public void setCuotaVariable(MontoCuota value) {
                        this.cuotaVariable = value;
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
             *     &lt;restriction base="{}producto">
             *       &lt;sequence>
             *         &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
             *         &lt;element name="DescripcionProducto" type="{}descripcion"/>
             *         &lt;element name="NumProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
             *         &lt;element name="CodEmpresa" type="{}cod_persona"/>
             *         &lt;element name="TipoCuota" type="{}tipoCuotaFormato"/>
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
     *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
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
     *                               &lt;element name="TipoCuota" type="{}tipoCuotaFormato"/>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                     &lt;element name="InfoCajas" type="{}infocajas"/>
     *                     &lt;element name="Cuota">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element name="MedioPago" type="{}medioPago"/>
     *                               &lt;element name="InfoPA" minOccurs="0">
     *                                 &lt;complexType>
     *                                   &lt;complexContent>
     *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                       &lt;sequence>
     *                                         &lt;element name="ValorUF">
     *                                           &lt;simpleType>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                               &lt;fractionDigits value="2"/>
     *                                             &lt;/restriction>
     *                                           &lt;/simpleType>
     *                                         &lt;/element>
     *                                         &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                                       &lt;/sequence>
     *                                     &lt;/restriction>
     *                                   &lt;/complexContent>
     *                                 &lt;/complexType>
     *                               &lt;/element>
     *                               &lt;choice>
     *                                 &lt;element name="CuotaOpcion">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                         &lt;sequence>
     *                                           &lt;element name="CuotaMin">
     *                                             &lt;complexType>
     *                                               &lt;complexContent>
     *                                                 &lt;extension base="{}montoCuota">
     *                                                   &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
     *                                                 &lt;/extension>
     *                                               &lt;/complexContent>
     *                                             &lt;/complexType>
     *                                           &lt;/element>
     *                                           &lt;element name="CuotaMax" minOccurs="0">
     *                                             &lt;complexType>
     *                                               &lt;complexContent>
     *                                                 &lt;extension base="{}montoCuota">
     *                                                   &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
     *                                                 &lt;/extension>
     *                                               &lt;/complexContent>
     *                                             &lt;/complexType>
     *                                           &lt;/element>
     *                                         &lt;/sequence>
     *                                       &lt;/restriction>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                                 &lt;element name="CuotaVariable">
     *                                   &lt;complexType>
     *                                     &lt;complexContent>
     *                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                         &lt;sequence>
     *                                           &lt;element name="CuotaFija" type="{}montoCuota"/>
     *                                           &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
     *                                         &lt;/sequence>
     *                                       &lt;/restriction>
     *                                     &lt;/complexContent>
     *                                   &lt;/complexType>
     *                                 &lt;/element>
     *                                 &lt;element name="CuotaFija" type="{}montoCuota"/>
     *                               &lt;/choice>
     *                               &lt;element name="Pago" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *                               &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;/sequence>
     *                           &lt;/restriction>
     *                         &lt;/complexContent>
     *                       &lt;/complexType>
     *                     &lt;/element>
     *                   &lt;/sequence>
     *                   &lt;attribute name="contador" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *                   &lt;attribute name="seleccionado" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                   &lt;attribute name="disabled" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;/restriction>
     *               &lt;/complexContent>
     *             &lt;/complexType>
     *           &lt;/element>
     *         &lt;/sequence>
     *         &lt;element name="TotalPorPagar" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *         &lt;element name="TotalDeuda" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "entrada", "totalPorPagar", "totalDeuda" })
    public static class ProductosPorPagar {

        @XmlElement(name = "Entrada")
        protected List<ResumenConHeader.ProductosPorPagar.Entrada> entrada;
        @XmlElement(name = "TotalPorPagar", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger totalPorPagar;
        @XmlElement(name = "TotalDeuda", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger totalDeuda;

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
         * {@link ResumenConHeader.ProductosPorPagar.Entrada }
         *
         *
         */
        public List<ResumenConHeader.ProductosPorPagar.Entrada> getEntrada() {
            if (entrada == null) {
                entrada = new ArrayList<ResumenConHeader.ProductosPorPagar.Entrada>();
            }
            return this.entrada;
        }

        /**
         * Gets the value of the totalPorPagar property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getTotalPorPagar() {
            return totalPorPagar;
        }

        /**
         * Sets the value of the totalPorPagar property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setTotalPorPagar(BigInteger value) {
            this.totalPorPagar = value;
        }

        /**
         * Gets the value of the totalDeuda property.
         *
         * @return
         *     possible object is
         *     {@link BigInteger }
         *
         */
        public BigInteger getTotalDeuda() {
            return totalDeuda;
        }

        /**
         * Sets the value of the totalDeuda property.
         *
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *
         */
        public void setTotalDeuda(BigInteger value) {
            this.totalDeuda = value;
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
         *                   &lt;element name="TipoCuota" type="{}tipoCuotaFormato"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="InfoCajas" type="{}infocajas"/>
         *         &lt;element name="Cuota">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="MedioPago" type="{}medioPago"/>
         *                   &lt;element name="InfoPA" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="ValorUF">
         *                               &lt;simpleType>
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                   &lt;fractionDigits value="2"/>
         *                                 &lt;/restriction>
         *                               &lt;/simpleType>
         *                             &lt;/element>
         *                             &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;choice>
         *                     &lt;element name="CuotaOpcion">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element name="CuotaMin">
         *                                 &lt;complexType>
         *                                   &lt;complexContent>
         *                                     &lt;extension base="{}montoCuota">
         *                                       &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
         *                                     &lt;/extension>
         *                                   &lt;/complexContent>
         *                                 &lt;/complexType>
         *                               &lt;/element>
         *                               &lt;element name="CuotaMax" minOccurs="0">
         *                                 &lt;complexType>
         *                                   &lt;complexContent>
         *                                     &lt;extension base="{}montoCuota">
         *                                       &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
         *                                     &lt;/extension>
         *                                   &lt;/complexContent>
         *                                 &lt;/complexType>
         *                               &lt;/element>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="CuotaVariable">
         *                       &lt;complexType>
         *                         &lt;complexContent>
         *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                             &lt;sequence>
         *                               &lt;element name="CuotaFija" type="{}montoCuota"/>
         *                               &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
         *                             &lt;/sequence>
         *                           &lt;/restriction>
         *                         &lt;/complexContent>
         *                       &lt;/complexType>
         *                     &lt;/element>
         *                     &lt;element name="CuotaFija" type="{}montoCuota"/>
         *                   &lt;/choice>
         *                   &lt;element name="Pago" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
         *                   &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="contador" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *       &lt;attribute name="seleccionado" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="disabled" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "producto", "infoCajas", "cuota" })
        public static class Entrada {

            @XmlElement(name = "Producto", required = true)
            protected ResumenConHeader.ProductosPorPagar.Entrada.Producto producto;
            @XmlElement(name = "InfoCajas", required = true)
            protected Infocajas infoCajas;
            @XmlElement(name = "Cuota", required = true)
            protected ResumenConHeader.ProductosPorPagar.Entrada.Cuota cuota;
            @XmlAttribute(name = "contador", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger contador;
            @XmlAttribute(name = "seleccionado", required = true)
            protected boolean seleccionado;
            @XmlAttribute(name = "disabled", required = true)
            protected boolean disabled;

            /**
             * Gets the value of the producto property.
             *
             * @return
             *     possible object is
             *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Producto }
             *
             */
            public ResumenConHeader.ProductosPorPagar.Entrada.Producto getProducto() {
                return producto;
            }

            /**
             * Sets the value of the producto property.
             *
             * @param value
             *     allowed object is
             *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Producto }
             *
             */
            public void setProducto(ResumenConHeader.ProductosPorPagar.Entrada.Producto value) {
                this.producto = value;
            }

            /**
             * Gets the value of the infoCajas property.
             *
             * @return
             * possible object is
             * {@link cl.bice.vida.resumenypagos.Infocajas}
             *
             */
            public Infocajas getInfoCajas() {
                return infoCajas;
            }

            /**
             * Sets the value of the infoCajas property.
             *
             * @param value
             * allowed object is
             * {@link cl.bice.vida.resumenypagos.Infocajas}
             *
             */
            public void setInfoCajas(Infocajas value) {
                this.infoCajas = value;
            }

            /**
             * Gets the value of the cuota property.
             *
             * @return
             *     possible object is
             *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota }
             *
             */
            public ResumenConHeader.ProductosPorPagar.Entrada.Cuota getCuota() {
                return cuota;
            }

            /**
             * Sets the value of the cuota property.
             *
             * @param value
             *     allowed object is
             *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota }
             *
             */
            public void setCuota(ResumenConHeader.ProductosPorPagar.Entrada.Cuota value) {
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
             * Gets the value of the seleccionado property.
             *
             */
            public boolean isSeleccionado() {
                return seleccionado;
            }

            /**
             * Sets the value of the seleccionado property.
             *
             */
            public void setSeleccionado(boolean value) {
                this.seleccionado = value;
            }

            /**
             * Gets the value of the disabled property.
             *
             */
            public boolean isDisabled() {
                return disabled;
            }

            /**
             * Sets the value of the disabled property.
             *
             */
            public void setDisabled(boolean value) {
                this.disabled = value;
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
             *         &lt;element name="MedioPago" type="{}medioPago"/>
             *         &lt;element name="InfoPA" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="ValorUF">
             *                     &lt;simpleType>
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                         &lt;fractionDigits value="2"/>
             *                       &lt;/restriction>
             *                     &lt;/simpleType>
             *                   &lt;/element>
             *                   &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;choice>
             *           &lt;element name="CuotaOpcion">
             *             &lt;complexType>
             *               &lt;complexContent>
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                   &lt;sequence>
             *                     &lt;element name="CuotaMin">
             *                       &lt;complexType>
             *                         &lt;complexContent>
             *                           &lt;extension base="{}montoCuota">
             *                             &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
             *                           &lt;/extension>
             *                         &lt;/complexContent>
             *                       &lt;/complexType>
             *                     &lt;/element>
             *                     &lt;element name="CuotaMax" minOccurs="0">
             *                       &lt;complexType>
             *                         &lt;complexContent>
             *                           &lt;extension base="{}montoCuota">
             *                             &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
             *                           &lt;/extension>
             *                         &lt;/complexContent>
             *                       &lt;/complexType>
             *                     &lt;/element>
             *                   &lt;/sequence>
             *                 &lt;/restriction>
             *               &lt;/complexContent>
             *             &lt;/complexType>
             *           &lt;/element>
             *           &lt;element name="CuotaVariable">
             *             &lt;complexType>
             *               &lt;complexContent>
             *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                   &lt;sequence>
             *                     &lt;element name="CuotaFija" type="{}montoCuota"/>
             *                     &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
             *                   &lt;/sequence>
             *                 &lt;/restriction>
             *               &lt;/complexContent>
             *             &lt;/complexType>
             *           &lt;/element>
             *           &lt;element name="CuotaFija" type="{}montoCuota"/>
             *         &lt;/choice>
             *         &lt;element name="Pago" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
             *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                     "fechaVencimiento", "medioPago", "infoPA", "cuotaOpcion", "cuotaVariable", "cuotaFija", "pago",
                     "estado"
                })
            public static class Cuota {

                @XmlElement(name = "FechaVencimiento", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar fechaVencimiento;
                @XmlElement(name = "MedioPago", required = true, defaultValue = "")
                protected String medioPago;
                @XmlElement(name = "InfoPA")
                protected ResumenConHeader.ProductosPorPagar.Entrada.Cuota.InfoPA infoPA;
                @XmlElement(name = "CuotaOpcion")
                protected ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion cuotaOpcion;
                @XmlElement(name = "CuotaVariable")
                protected ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaVariable cuotaVariable;
                @XmlElement(name = "CuotaFija")
                protected MontoCuota cuotaFija;
                @XmlElement(name = "Pago", required = true)
                @XmlSchemaType(name = "nonNegativeInteger")
                protected BigInteger pago;
                @XmlElement(name = "Estado", required = true)
                protected String estado;

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
                 * Gets the value of the medioPago property.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getMedioPago() {
                    return medioPago;
                }

                /**
                 * Sets the value of the medioPago property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setMedioPago(String value) {
                    this.medioPago = value;
                }

                /**
                 * Gets the value of the infoPA property.
                 *
                 * @return
                 *     possible object is
                 *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.InfoPA }
                 *
                 */
                public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.InfoPA getInfoPA() {
                    return infoPA;
                }

                /**
                 * Sets the value of the infoPA property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.InfoPA }
                 *
                 */
                public void setInfoPA(ResumenConHeader.ProductosPorPagar.Entrada.Cuota.InfoPA value) {
                    this.infoPA = value;
                }

                /**
                 * Gets the value of the cuotaOpcion property.
                 *
                 * @return
                 *     possible object is
                 *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion }
                 *
                 */
                public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion getCuotaOpcion() {
                    return cuotaOpcion;
                }

                /**
                 * Sets the value of the cuotaOpcion property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion }
                 *
                 */
                public void setCuotaOpcion(ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion value) {
                    this.cuotaOpcion = value;
                }

                /**
                 * Gets the value of the cuotaVariable property.
                 *
                 * @return
                 *     possible object is
                 *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaVariable }
                 *
                 */
                public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaVariable getCuotaVariable() {
                    return cuotaVariable;
                }

                /**
                 * Sets the value of the cuotaVariable property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaVariable }
                 *
                 */
                public void setCuotaVariable(ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaVariable value) {
                    this.cuotaVariable = value;
                }

                /**
                 * Gets the value of the cuotaFija property.
                 *
                 * @return
                 * possible object is
                 * {@link cl.bice.vida.resumenypagos.MontoCuota}
                 *
                 */
                public MontoCuota getCuotaFija() {
                    return cuotaFija;
                }

                /**
                 * Sets the value of the cuotaFija property.
                 *
                 * @param value
                 * allowed object is
                 * {@link cl.bice.vida.resumenypagos.MontoCuota}
                 *
                 */
                public void setCuotaFija(MontoCuota value) {
                    this.cuotaFija = value;
                }

                /**
                 * Gets the value of the pago property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getPago() {
                    return pago;
                }

                /**
                 * Sets the value of the pago property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setPago(BigInteger value) {
                    this.pago = value;
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
                 *         &lt;element name="CuotaMin">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;extension base="{}montoCuota">
                 *                 &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
                 *               &lt;/extension>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="CuotaMax" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;extension base="{}montoCuota">
                 *                 &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
                 *               &lt;/extension>
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
                @XmlType(name = "", propOrder = { "cuotaMin", "cuotaMax" })
                public static class CuotaOpcion {

                    @XmlElement(name = "CuotaMin", required = true)
                    protected ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMin cuotaMin;
                    @XmlElement(name = "CuotaMax")
                    protected ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMax cuotaMax;

                    /**
                     * Gets the value of the cuotaMin property.
                     *
                     * @return
                     *     possible object is
                     *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMin }
                     *
                     */
                    public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMin getCuotaMin() {
                        return cuotaMin;
                    }

                    /**
                     * Sets the value of the cuotaMin property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMin }
                     *
                     */
                    public void setCuotaMin(ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMin value) {
                        this.cuotaMin = value;
                    }

                    /**
                     * Gets the value of the cuotaMax property.
                     *
                     * @return
                     *     possible object is
                     *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMax }
                     *
                     */
                    public ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMax getCuotaMax() {
                        return cuotaMax;
                    }

                    /**
                     * Sets the value of the cuotaMax property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMax }
                     *
                     */
                    public void setCuotaMax(ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMax value) {
                        this.cuotaMax = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     *
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     *
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;extension base="{}montoCuota">
                     *       &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
                     *     &lt;/extension>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     *
                     *
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class CuotaMax extends MontoCuota {

                        @XmlAttribute(name = "seleccionado")
                        protected Boolean seleccionado;

                        /**
                         * Gets the value of the seleccionado property.
                         *
                         * @return
                         *     possible object is
                         *     {@link Boolean }
                         *
                         */
                        public boolean isSeleccionado() {
                            if (seleccionado == null) {
                                return false;
                            } else {
                                return seleccionado;
                            }
                        }

                        /**
                         * Sets the value of the seleccionado property.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link Boolean }
                         *
                         */
                        public void setSeleccionado(Boolean value) {
                            this.seleccionado = value;
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
                     *     &lt;extension base="{}montoCuota">
                     *       &lt;attribute name="seleccionado" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
                     *     &lt;/extension>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     *
                     *
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class CuotaMin extends MontoCuota {

                        @XmlAttribute(name = "seleccionado")
                        protected Boolean seleccionado;

                        /**
                         * Gets the value of the seleccionado property.
                         *
                         * @return
                         *     possible object is
                         *     {@link Boolean }
                         *
                         */
                        public boolean isSeleccionado() {
                            if (seleccionado == null) {
                                return true;
                            } else {
                                return seleccionado;
                            }
                        }

                        /**
                         * Sets the value of the seleccionado property.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link Boolean }
                         *
                         */
                        public void setSeleccionado(Boolean value) {
                            this.seleccionado = value;
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
                 *         &lt;element name="CuotaFija" type="{}montoCuota"/>
                 *         &lt;element name="CuotaVariable" type="{}montoCuota" minOccurs="0"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = { "cuotaFija", "cuotaVariable" })
                public static class CuotaVariable {

                    @XmlElement(name = "CuotaFija", required = true)
                    protected MontoCuota cuotaFija;
                    @XmlElement(name = "CuotaVariable")
                    protected MontoCuota cuotaVariable;

                    /**
                     * Gets the value of the cuotaFija property.
                     *
                     * @return
                     * possible object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public MontoCuota getCuotaFija() {
                        return cuotaFija;
                    }

                    /**
                     * Sets the value of the cuotaFija property.
                     *
                     * @param value
                     * allowed object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public void setCuotaFija(MontoCuota value) {
                        this.cuotaFija = value;
                    }

                    /**
                     * Gets the value of the cuotaVariable property.
                     *
                     * @return
                     * possible object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public MontoCuota getCuotaVariable() {
                        return cuotaVariable;
                    }

                    /**
                     * Sets the value of the cuotaVariable property.
                     *
                     * @param value
                     * allowed object is
                     * {@link cl.bice.vida.resumenypagos.MontoCuota}
                     *
                     */
                    public void setCuotaVariable(MontoCuota value) {
                        this.cuotaVariable = value;
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
                 *         &lt;element name="ValorUF">
                 *           &lt;simpleType>
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *               &lt;fractionDigits value="2"/>
                 *             &lt;/restriction>
                 *           &lt;/simpleType>
                 *         &lt;/element>
                 *         &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = { "valorUF", "fechaPago" })
                public static class InfoPA {

                    @XmlElement(name = "ValorUF", required = true)
                    protected BigDecimal valorUF;
                    @XmlElement(name = "FechaPago", required = true)
                    @XmlSchemaType(name = "date")
                    protected XMLGregorianCalendar fechaPago;

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
             *         &lt;element name="TipoCuota" type="{}tipoCuotaFormato"/>
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
     *         &lt;element name="Titulo" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "titulo" })
    public static class Titulos {

        @XmlElement(name = "Titulo", required = true)
        protected List<String> titulo;

        /**
         * Gets the value of the titulo property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the titulo property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTitulo().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         *
         *
         */
        public List<String> getTitulo() {
            if (titulo == null) {
                titulo = new ArrayList<String>();
            }
            return this.titulo;
        }

    }

}
