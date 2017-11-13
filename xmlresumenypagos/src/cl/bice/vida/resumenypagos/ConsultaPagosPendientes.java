
package cl.bice.vida.resumenypagos;

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
 *                   &lt;element name="Accion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Consulta">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Cliente" type="{}cod_persona"/>
 *                   &lt;element name="NombreCliente">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;maxLength value="100"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="Empresa" type="{}cod_persona"/>
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
@XmlType(name = "", propOrder = { "identificacionMensaje", "consulta" })
@XmlRootElement(name = "ConsultaPagosPendientes")
public class ConsultaPagosPendientes {

    @XmlElement(name = "IdentificacionMensaje", required = true)
    protected ConsultaPagosPendientes.IdentificacionMensaje identificacionMensaje;
    @XmlElement(name = "Consulta", required = true)
    protected ConsultaPagosPendientes.Consulta consulta;

    /**
     * Gets the value of the identificacionMensaje property.
     *
     * @return
     *     possible object is
     *     {@link ConsultaPagosPendientes.IdentificacionMensaje }
     *
     */
    public ConsultaPagosPendientes.IdentificacionMensaje getIdentificacionMensaje() {
        return identificacionMensaje;
    }

    /**
     * Sets the value of the identificacionMensaje property.
     *
     * @param value
     *     allowed object is
     *     {@link ConsultaPagosPendientes.IdentificacionMensaje }
     *
     */
    public void setIdentificacionMensaje(ConsultaPagosPendientes.IdentificacionMensaje value) {
        this.identificacionMensaje = value;
    }

    /**
     * Gets the value of the consulta property.
     *
     * @return
     *     possible object is
     *     {@link ConsultaPagosPendientes.Consulta }
     *
     */
    public ConsultaPagosPendientes.Consulta getConsulta() {
        return consulta;
    }

    /**
     * Sets the value of the consulta property.
     *
     * @param value
     *     allowed object is
     *     {@link ConsultaPagosPendientes.Consulta }
     *
     */
    public void setConsulta(ConsultaPagosPendientes.Consulta value) {
        this.consulta = value;
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
     *         &lt;element name="Cliente" type="{}cod_persona"/>
     *         &lt;element name="NombreCliente">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;maxLength value="100"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="Empresa" type="{}cod_persona"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "cliente", "nombreCliente", "empresa" })
    public static class Consulta {

        @XmlElement(name = "Cliente")
        @XmlSchemaType(name = "integer")
        protected int cliente;
        @XmlElement(name = "NombreCliente", required = true)
        protected String nombreCliente;
        @XmlElement(name = "Empresa")
        @XmlSchemaType(name = "integer")
        protected int empresa;

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
     *         &lt;element name="Accion" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
