
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
 *                         &lt;enumeration value="CUADRA"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Empresa" type="{}cod_persona"/>
 *         &lt;element name="Transacciones">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="Transaccion">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="IdTransaccion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                             &lt;element name="NumTransaccionMedio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                             &lt;element name="Cliente" type="{}cod_persona"/>
 *                             &lt;element name="Resultado">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="OK"/>
 *                                   &lt;enumeration value="NOK"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Monto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
 *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "identificacionMensaje", "empresa", "transacciones", "total" })
@XmlRootElement(name = "Cuadratura")
public class Cuadratura {

    @XmlElement(name = "IdentificacionMensaje", required = true)
    protected Cuadratura.IdentificacionMensaje identificacionMensaje;
    @XmlElement(name = "Empresa")
    @XmlSchemaType(name = "integer")
    protected int empresa;
    @XmlElement(name = "Transacciones", required = true)
    protected Cuadratura.Transacciones transacciones;
    @XmlElement(name = "Total", required = true)
    protected Object total;

    /**
     * Gets the value of the identificacionMensaje property.
     *
     * @return
     *     possible object is
     *     {@link Cuadratura.IdentificacionMensaje }
     *
     */
    public Cuadratura.IdentificacionMensaje getIdentificacionMensaje() {
        return identificacionMensaje;
    }

    /**
     * Sets the value of the identificacionMensaje property.
     *
     * @param value
     *     allowed object is
     *     {@link Cuadratura.IdentificacionMensaje }
     *
     */
    public void setIdentificacionMensaje(Cuadratura.IdentificacionMensaje value) {
        this.identificacionMensaje = value;
    }

    /**
     * Gets the value of the empresa property.
     *
     */
    public int getEmpresa() {
        return empresa;
    }

    /**
     * Sets the value of the empresa property.
     *
     */
    public void setEmpresa(int value) {
        this.empresa = value;
    }

    /**
     * Gets the value of the transacciones property.
     *
     * @return
     *     possible object is
     *     {@link Cuadratura.Transacciones }
     *
     */
    public Cuadratura.Transacciones getTransacciones() {
        return transacciones;
    }

    /**
     * Sets the value of the transacciones property.
     *
     * @param value
     *     allowed object is
     *     {@link Cuadratura.Transacciones }
     *
     */
    public void setTransacciones(Cuadratura.Transacciones value) {
        this.transacciones = value;
    }

    /**
     * Gets the value of the total property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setTotal(Object value) {
        this.total = value;
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
     *               &lt;enumeration value="CUADRA"/>
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
     *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="Transaccion">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="IdTransaccion" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                   &lt;element name="NumTransaccionMedio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *                   &lt;element name="Cliente" type="{}cod_persona"/>
     *                   &lt;element name="Resultado">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="OK"/>
     *                         &lt;enumeration value="NOK"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Monto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
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
    @XmlType(name = "", propOrder = { "transaccion" })
    public static class Transacciones {

        @XmlElement(name = "Transaccion")
        protected List<Cuadratura.Transacciones.Transaccion> transaccion;

        /**
         * Gets the value of the transaccion property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the transaccion property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTransaccion().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Cuadratura.Transacciones.Transaccion }
         *
         *
         */
        public List<Cuadratura.Transacciones.Transaccion> getTransaccion() {
            if (transaccion == null) {
                transaccion = new ArrayList<Cuadratura.Transacciones.Transaccion>();
            }
            return this.transaccion;
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
         *         &lt;element name="NumTransaccionMedio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *         &lt;element name="Cliente" type="{}cod_persona"/>
         *         &lt;element name="Resultado">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="OK"/>
         *               &lt;enumeration value="NOK"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Monto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "idTransaccion", "numTransaccionMedio", "cliente", "resultado", "monto" })
        public static class Transaccion {

            @XmlElement(name = "IdTransaccion", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger idTransaccion;
            @XmlElement(name = "NumTransaccionMedio", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger numTransaccionMedio;
            @XmlElement(name = "Cliente")
            @XmlSchemaType(name = "integer")
            protected int cliente;
            @XmlElement(name = "Resultado", required = true, defaultValue = "OK")
            protected String resultado;
            @XmlElement(name = "Monto", required = true)
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger monto;

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
             * Gets the value of the cliente property.
             *
             */
            public int getCliente() {
                return cliente;
            }

            /**
             * Sets the value of the cliente property.
             *
             */
            public void setCliente(int value) {
                this.cliente = value;
            }

            /**
             * Gets the value of the resultado property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getResultado() {
                return resultado;
            }

            /**
             * Sets the value of the resultado property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setResultado(String value) {
                this.resultado = value;
            }

            /**
             * Gets the value of the monto property.
             *
             * @return
             *     possible object is
             *     {@link BigInteger }
             *
             */
            public BigInteger getMonto() {
                return monto;
            }

            /**
             * Sets the value of the monto property.
             *
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *
             */
            public void setMonto(BigInteger value) {
                this.monto = value;
            }

        }

    }

}
