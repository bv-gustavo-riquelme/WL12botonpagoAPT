
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
 *         &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="RutCliente" type="{}cod_persona"/>
 *         &lt;element name="NombreCliente" type="{}descripcion"/>
 *         &lt;element name="FechaPago" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ValorUF">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CanalPago">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SucursalPago">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InstrumentoPago">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ProductosPagados">
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
 *                               &lt;element name="Producto" type="{}producto"/>
 *                               &lt;element name="NumCuota" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *                               &lt;element name="Cuota">
 *                                 &lt;complexType>
 *                                   &lt;complexContent>
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                       &lt;sequence>
 *                                         &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                                         &lt;element name="Monto" type="{}montoCuota"/>
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
 *                   &lt;element name="TotalPagado">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
         "folio", "rutCliente", "nombreCliente", "fechaPago", "valorUF", "canalPago", "sucursalPago", "instrumentoPago",
         "productosPagados"
    })
@XmlRootElement(name = "ComprobantePagoCaja")
public class ComprobantePagoCaja {

    @XmlElement(name = "Folio", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger folio;
    @XmlElement(name = "RutCliente")
    @XmlSchemaType(name = "integer")
    protected int rutCliente;
    @XmlElement(name = "NombreCliente", required = true)
    protected String nombreCliente;
    @XmlElement(name = "FechaPago", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaPago;
    @XmlElement(name = "ValorUF", required = true)
    protected BigDecimal valorUF;
    @XmlElement(name = "CanalPago", required = true)
    protected String canalPago;
    @XmlElement(name = "SucursalPago", required = true)
    protected String sucursalPago;
    @XmlElement(name = "InstrumentoPago", required = true)
    protected String instrumentoPago;
    @XmlElement(name = "ProductosPagados", required = true)
    protected ComprobantePagoCaja.ProductosPagados productosPagados;

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
     * Gets the value of the canalPago property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCanalPago() {
        return canalPago;
    }

    /**
     * Sets the value of the canalPago property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCanalPago(String value) {
        this.canalPago = value;
    }

    /**
     * Gets the value of the sucursalPago property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSucursalPago() {
        return sucursalPago;
    }

    /**
     * Sets the value of the sucursalPago property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSucursalPago(String value) {
        this.sucursalPago = value;
    }

    /**
     * Gets the value of the instrumentoPago property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInstrumentoPago() {
        return instrumentoPago;
    }

    /**
     * Sets the value of the instrumentoPago property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInstrumentoPago(String value) {
        this.instrumentoPago = value;
    }

    /**
     * Gets the value of the productosPagados property.
     *
     * @return
     *     possible object is
     *     {@link ComprobantePagoCaja.ProductosPagados }
     *
     */
    public ComprobantePagoCaja.ProductosPagados getProductosPagados() {
        return productosPagados;
    }

    /**
     * Sets the value of the productosPagados property.
     *
     * @param value
     *     allowed object is
     *     {@link ComprobantePagoCaja.ProductosPagados }
     *
     */
    public void setProductosPagados(ComprobantePagoCaja.ProductosPagados value) {
        this.productosPagados = value;
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
     *                     &lt;element name="Producto" type="{}producto"/>
     *                     &lt;element name="NumCuota" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
     *                     &lt;element name="Cuota">
     *                       &lt;complexType>
     *                         &lt;complexContent>
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                             &lt;sequence>
     *                               &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                               &lt;element name="Monto" type="{}montoCuota"/>
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
     *         &lt;element name="TotalPagado">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
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
    @XmlType(name = "", propOrder = { "entrada", "totalPagado" })
    public static class ProductosPagados {

        @XmlElement(name = "Entrada", required = true)
        protected List<ComprobantePagoCaja.ProductosPagados.Entrada> entrada;
        @XmlElement(name = "TotalPagado", required = true)
        protected ComprobantePagoCaja.ProductosPagados.TotalPagado totalPagado;

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
         * {@link ComprobantePagoCaja.ProductosPagados.Entrada }
         *
         *
         */
        public List<ComprobantePagoCaja.ProductosPagados.Entrada> getEntrada() {
            if (entrada == null) {
                entrada = new ArrayList<ComprobantePagoCaja.ProductosPagados.Entrada>();
            }
            return this.entrada;
        }

        /**
         * Gets the value of the totalPagado property.
         *
         * @return
         *     possible object is
         *     {@link ComprobantePagoCaja.ProductosPagados.TotalPagado }
         *
         */
        public ComprobantePagoCaja.ProductosPagados.TotalPagado getTotalPagado() {
            return totalPagado;
        }

        /**
         * Sets the value of the totalPagado property.
         *
         * @param value
         *     allowed object is
         *     {@link ComprobantePagoCaja.ProductosPagados.TotalPagado }
         *
         */
        public void setTotalPagado(ComprobantePagoCaja.ProductosPagados.TotalPagado value) {
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
         *         &lt;element name="Producto" type="{}producto"/>
         *         &lt;element name="NumCuota" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
         *         &lt;element name="Cuota">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="FechaVencimiento" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *                   &lt;element name="Monto" type="{}montoCuota"/>
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
        @XmlType(name = "", propOrder = { "producto", "numCuota", "cuota" })
        public static class Entrada {

            @XmlElement(name = "Producto", required = true)
            protected Producto producto;
            @XmlElement(name = "NumCuota")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger numCuota;
            @XmlElement(name = "Cuota", required = true)
            protected ComprobantePagoCaja.ProductosPagados.Entrada.Cuota cuota;
            @XmlAttribute(name = "contador", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger contador;

            /**
             * Gets the value of the producto property.
             *
             * @return
             * possible object is
             * {@link cl.bice.vida.resumenypagos.Producto}
             *
             */
            public Producto getProducto() {
                return producto;
            }

            /**
             * Sets the value of the producto property.
             *
             * @param value
             * allowed object is
             * {@link cl.bice.vida.resumenypagos.Producto}
             *
             */
            public void setProducto(Producto value) {
                this.producto = value;
            }

            /**
             * Gets the value of the numCuota property.
             *
             * @return
             *     possible object is
             *     {@link BigInteger }
             *
             */
            public BigInteger getNumCuota() {
                return numCuota;
            }

            /**
             * Sets the value of the numCuota property.
             *
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *
             */
            public void setNumCuota(BigInteger value) {
                this.numCuota = value;
            }

            /**
             * Gets the value of the cuota property.
             *
             * @return
             *     possible object is
             *     {@link ComprobantePagoCaja.ProductosPagados.Entrada.Cuota }
             *
             */
            public ComprobantePagoCaja.ProductosPagados.Entrada.Cuota getCuota() {
                return cuota;
            }

            /**
             * Sets the value of the cuota property.
             *
             * @param value
             *     allowed object is
             *     {@link ComprobantePagoCaja.ProductosPagados.Entrada.Cuota }
             *
             */
            public void setCuota(ComprobantePagoCaja.ProductosPagados.Entrada.Cuota value) {
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
             *         &lt;element name="Monto" type="{}montoCuota"/>
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
                protected MontoCuota monto;

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
                 * possible object is
                 * {@link cl.bice.vida.resumenypagos.MontoCuota}
                 *
                 */
                public MontoCuota getMonto() {
                    return monto;
                }

                /**
                 * Sets the value of the monto property.
                 *
                 * @param value
                 * allowed object is
                 * {@link cl.bice.vida.resumenypagos.MontoCuota}
                 *
                 */
                public void setMonto(MontoCuota value) {
                    this.monto = value;
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
         *         &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
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
        public static class TotalPagado {

            @XmlElement(name = "EnPesos", required = true)
            @XmlSchemaType(name = "nonNegativeInteger")
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
