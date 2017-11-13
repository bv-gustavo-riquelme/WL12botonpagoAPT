
package cl.bice.vida.resumenypagos;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * informacion adicional de la cuota referente utilizada en caja
 *
 * <p>Java class for infocajas complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="infocajas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Creditos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NumDividendo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Polizas">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *                   &lt;element name="Ramo" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infocajas", propOrder = { "creditos", "polizas" })
public class Infocajas {

    @XmlElement(name = "Creditos")
    protected Infocajas.Creditos creditos;
    @XmlElement(name = "Polizas")
    protected Infocajas.Polizas polizas;

    /**
     * Gets the value of the creditos property.
     *
     * @return
     *     possible object is
     *     {@link Infocajas.Creditos }
     *
     */
    public Infocajas.Creditos getCreditos() {
        return creditos;
    }

    /**
     * Sets the value of the creditos property.
     *
     * @param value
     *     allowed object is
     *     {@link Infocajas.Creditos }
     *
     */
    public void setCreditos(Infocajas.Creditos value) {
        this.creditos = value;
    }

    /**
     * Gets the value of the polizas property.
     *
     * @return
     *     possible object is
     *     {@link Infocajas.Polizas }
     *
     */
    public Infocajas.Polizas getPolizas() {
        return polizas;
    }

    /**
     * Sets the value of the polizas property.
     *
     * @param value
     *     allowed object is
     *     {@link Infocajas.Polizas }
     *
     */
    public void setPolizas(Infocajas.Polizas value) {
        this.polizas = value;
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
     *         &lt;element name="NumDividendo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "numDividendo" })
    public static class Creditos {

        @XmlElement(name = "NumDividendo", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger numDividendo;

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
     *         &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
     *         &lt;element name="Ramo" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "folio", "ramo" })
    public static class Polizas {

        @XmlElement(name = "Folio", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger folio;
        @XmlElement(name = "Ramo", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger ramo;

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

    }

}
