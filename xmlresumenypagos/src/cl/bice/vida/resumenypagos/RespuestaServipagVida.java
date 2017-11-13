
package cl.bice.vida.resumenypagos;

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
 *           &lt;element name="ListaProductos">
 *             &lt;complexType>
 *               &lt;complexContent>
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                   &lt;sequence maxOccurs="unbounded">
 *                     &lt;element name="Entrada">
 *                       &lt;complexType>
 *                         &lt;complexContent>
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                             &lt;sequence>
 *                               &lt;element name="IdTransaccion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
 *                                         &lt;element name="FechaRecibo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                                         &lt;element name="Ramo" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                                         &lt;element name="MontoCuota">
 *                                           &lt;complexType>
 *                                             &lt;complexContent>
 *                                               &lt;restriction base="{}montoCuota">
 *                                                 &lt;sequence>
 *                                                   &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                                                   &lt;element name="EnUF" type="{}montoUF"/>
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
@XmlType(name = "", propOrder = { "error", "listaProductos" })
@XmlRootElement(name = "RespuestaServipagVida")
public class RespuestaServipagVida {

    @XmlElement(name = "Error")
    protected RespuestaServipagVida.Error error;
    @XmlElement(name = "ListaProductos")
    protected RespuestaServipagVida.ListaProductos listaProductos;

    /**
     * Gets the value of the error property.
     *
     * @return
     *     possible object is
     *     {@link RespuestaServipagVida.Error }
     *
     */
    public RespuestaServipagVida.Error getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     *
     * @param value
     *     allowed object is
     *     {@link RespuestaServipagVida.Error }
     *
     */
    public void setError(RespuestaServipagVida.Error value) {
        this.error = value;
    }

    /**
     * Gets the value of the listaProductos property.
     *
     * @return
     *     possible object is
     *     {@link RespuestaServipagVida.ListaProductos }
     *
     */
    public RespuestaServipagVida.ListaProductos getListaProductos() {
        return listaProductos;
    }

    /**
     * Sets the value of the listaProductos property.
     *
     * @param value
     *     allowed object is
     *     {@link RespuestaServipagVida.ListaProductos }
     *
     */
    public void setListaProductos(RespuestaServipagVida.ListaProductos value) {
        this.listaProductos = value;
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
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="Entrada">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdTransaccion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                   &lt;element name="Producto">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{}producto">
     *                           &lt;sequence>
     *                             &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                             &lt;element name="DescripcionProducto" type="{}descripcion"/>
     *                             &lt;element name="NumProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                             &lt;element name="CodEmpresa" type="{}cod_persona"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Cuota">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="FechaRecibo" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                             &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                             &lt;element name="Ramo" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *                             &lt;element name="MontoCuota">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{}montoCuota">
     *                                     &lt;sequence>
     *                                       &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                                       &lt;element name="EnUF" type="{}montoUF"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="contador" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
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
    @XmlType(name = "", propOrder = { "entrada" })
    public static class ListaProductos {

        @XmlElement(name = "Entrada", required = true)
        protected List<RespuestaServipagVida.ListaProductos.Entrada> entrada;

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
         * {@link RespuestaServipagVida.ListaProductos.Entrada }
         *
         *
         */
        public List<RespuestaServipagVida.ListaProductos.Entrada> getEntrada() {
            if (entrada == null) {
                entrada = new ArrayList<RespuestaServipagVida.ListaProductos.Entrada>();
            }
            return this.entrada;
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
         *         &lt;element name="IdTransaccion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
         *                   &lt;element name="FechaRecibo" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *                   &lt;element name="Ramo" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
         *                   &lt;element name="MontoCuota">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{}montoCuota">
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
        @XmlType(name = "", propOrder = { "idTransaccion", "producto", "cuota" })
        public static class Entrada {

            @XmlElement(name = "IdTransaccion", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger idTransaccion;
            @XmlElement(name = "Producto", required = true)
            protected RespuestaServipagVida.ListaProductos.Entrada.Producto producto;
            @XmlElement(name = "Cuota", required = true)
            protected RespuestaServipagVida.ListaProductos.Entrada.Cuota cuota;
            @XmlAttribute(name = "contador", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger contador;

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
             *     {@link RespuestaServipagVida.ListaProductos.Entrada.Producto }
             *
             */
            public RespuestaServipagVida.ListaProductos.Entrada.Producto getProducto() {
                return producto;
            }

            /**
             * Sets the value of the producto property.
             *
             * @param value
             *     allowed object is
             *     {@link RespuestaServipagVida.ListaProductos.Entrada.Producto }
             *
             */
            public void setProducto(RespuestaServipagVida.ListaProductos.Entrada.Producto value) {
                this.producto = value;
            }

            /**
             * Gets the value of the cuota property.
             *
             * @return
             *     possible object is
             *     {@link RespuestaServipagVida.ListaProductos.Entrada.Cuota }
             *
             */
            public RespuestaServipagVida.ListaProductos.Entrada.Cuota getCuota() {
                return cuota;
            }

            /**
             * Sets the value of the cuota property.
             *
             * @param value
             *     allowed object is
             *     {@link RespuestaServipagVida.ListaProductos.Entrada.Cuota }
             *
             */
            public void setCuota(RespuestaServipagVida.ListaProductos.Entrada.Cuota value) {
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
             *         &lt;element name="FechaRecibo" type="{http://www.w3.org/2001/XMLSchema}date"/>
             *         &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
             *         &lt;element name="Ramo" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
             *         &lt;element name="MontoCuota">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{}montoCuota">
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
            @XmlType(name = "", propOrder = { "fechaRecibo", "folio", "ramo", "montoCuota" })
            public static class Cuota {

                @XmlElement(name = "FechaRecibo", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar fechaRecibo;
                @XmlElement(name = "Folio", required = true)
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger folio;
                @XmlElement(name = "Ramo", required = true)
                @XmlSchemaType(name = "nonNegativeInteger")
                protected BigInteger ramo;
                @XmlElement(name = "MontoCuota", required = true)
                protected RespuestaServipagVida.ListaProductos.Entrada.Cuota.MontoCuota montoCuota;

                /**
                 * Gets the value of the fechaRecibo property.
                 *
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *
                 */
                public XMLGregorianCalendar getFechaRecibo() {
                    return fechaRecibo;
                }

                /**
                 * Sets the value of the fechaRecibo property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *
                 */
                public void setFechaRecibo(XMLGregorianCalendar value) {
                    this.fechaRecibo = value;
                }

                /**
                 * Gets the value of the folio property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getFolio() {
                    return folio;
                }

                /**
                 * Sets the value of the folio property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setFolio(BigInteger value) {
                    this.folio = value;
                }

                /**
                 * Gets the value of the ramo property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getRamo() {
                    return ramo;
                }

                /**
                 * Sets the value of the ramo property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setRamo(BigInteger value) {
                    this.ramo = value;
                }

                /**
                 * Gets the value of the montoCuota property.
                 *
                 * @return
                 *     possible object is
                 *     {@link RespuestaServipagVida.ListaProductos.Entrada.Cuota.MontoCuota }
                 *
                 */
                public RespuestaServipagVida.ListaProductos.Entrada.Cuota.MontoCuota getMontoCuota() {
                    return montoCuota;
                }

                /**
                 * Sets the value of the montoCuota property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link RespuestaServipagVida.ListaProductos.Entrada.Cuota.MontoCuota }
                 *
                 */
                public void setMontoCuota(RespuestaServipagVida.ListaProductos.Entrada.Cuota.MontoCuota value) {
                    this.montoCuota = value;
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
                public static class MontoCuota extends cl.bice.vida.resumenypagos.MontoCuota {


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

    }

}
