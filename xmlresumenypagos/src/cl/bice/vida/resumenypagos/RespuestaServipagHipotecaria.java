
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
 *                                         &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="NumDividendo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
@XmlRootElement(name = "RespuestaServipagHipotecaria")
public class RespuestaServipagHipotecaria {

    @XmlElement(name = "Error")
    protected RespuestaServipagHipotecaria.Error error;
    @XmlElement(name = "ListaProductos")
    protected RespuestaServipagHipotecaria.ListaProductos listaProductos;

    /**
     * Gets the value of the error property.
     *
     * @return
     *     possible object is
     *     {@link RespuestaServipagHipotecaria.Error }
     *
     */
    public RespuestaServipagHipotecaria.Error getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     *
     * @param value
     *     allowed object is
     *     {@link RespuestaServipagHipotecaria.Error }
     *
     */
    public void setError(RespuestaServipagHipotecaria.Error value) {
        this.error = value;
    }

    /**
     * Gets the value of the listaProductos property.
     *
     * @return
     *     possible object is
     *     {@link RespuestaServipagHipotecaria.ListaProductos }
     *
     */
    public RespuestaServipagHipotecaria.ListaProductos getListaProductos() {
        return listaProductos;
    }

    /**
     * Sets the value of the listaProductos property.
     *
     * @param value
     *     allowed object is
     *     {@link RespuestaServipagHipotecaria.ListaProductos }
     *
     */
    public void setListaProductos(RespuestaServipagHipotecaria.ListaProductos value) {
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
     *                             &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                             &lt;element name="NumDividendo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
        protected List<RespuestaServipagHipotecaria.ListaProductos.Entrada> entrada;

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
         * {@link RespuestaServipagHipotecaria.ListaProductos.Entrada }
         *
         *
         */
        public List<RespuestaServipagHipotecaria.ListaProductos.Entrada> getEntrada() {
            if (entrada == null) {
                entrada = new ArrayList<RespuestaServipagHipotecaria.ListaProductos.Entrada>();
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
         *                   &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="NumDividendo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
            protected RespuestaServipagHipotecaria.ListaProductos.Entrada.Producto producto;
            @XmlElement(name = "Cuota", required = true)
            protected RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota cuota;
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
             *     {@link RespuestaServipagHipotecaria.ListaProductos.Entrada.Producto }
             *
             */
            public RespuestaServipagHipotecaria.ListaProductos.Entrada.Producto getProducto() {
                return producto;
            }

            /**
             * Sets the value of the producto property.
             *
             * @param value
             *     allowed object is
             *     {@link RespuestaServipagHipotecaria.ListaProductos.Entrada.Producto }
             *
             */
            public void setProducto(RespuestaServipagHipotecaria.ListaProductos.Entrada.Producto value) {
                this.producto = value;
            }

            /**
             * Gets the value of the cuota property.
             *
             * @return
             *     possible object is
             *     {@link RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota }
             *
             */
            public RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota getCuota() {
                return cuota;
            }

            /**
             * Sets the value of the cuota property.
             *
             * @param value
             *     allowed object is
             *     {@link RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota }
             *
             */
            public void setCuota(RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota value) {
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
             *         &lt;element name="NumDividendo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
            @XmlType(name = "", propOrder = { "fechaVencimiento", "numDividendo", "montoCuota" })
            public static class Cuota {

                @XmlElement(name = "FechaVencimiento", required = true)
                @XmlSchemaType(name = "date")
                protected XMLGregorianCalendar fechaVencimiento;
                @XmlElement(name = "NumDividendo", required = true)
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger numDividendo;
                @XmlElement(name = "MontoCuota", required = true)
                protected RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota.MontoCuota montoCuota;

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
                 * Gets the value of the numDividendo property.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *
                 */
                public BigInteger getNumDividendo() {
                    return numDividendo;
                }

                /**
                 * Sets the value of the numDividendo property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *
                 */
                public void setNumDividendo(BigInteger value) {
                    this.numDividendo = value;
                }

                /**
                 * Gets the value of the montoCuota property.
                 *
                 * @return
                 *     possible object is
                 *     {@link RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota.MontoCuota }
                 *
                 */
                public RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota.MontoCuota getMontoCuota() {
                    return montoCuota;
                }

                /**
                 * Sets the value of the montoCuota property.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota.MontoCuota }
                 *
                 */
                public void setMontoCuota(RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota.MontoCuota value) {
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
