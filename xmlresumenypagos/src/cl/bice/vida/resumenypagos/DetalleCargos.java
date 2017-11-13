
package cl.bice.vida.resumenypagos;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * detalle de una cuota
 *
 * <p>Java class for detalleCargos complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="detalleCargos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="Cargo">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;>montoUF">
 *                 &lt;attribute name="descripcion" use="required" type="{}descripcion" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
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
@XmlType(name = "detalleCargos", propOrder = { "cargo" })
public class DetalleCargos {

    @XmlElement(name = "Cargo", required = true)
    protected List<DetalleCargos.Cargo> cargo;

    /**
     * Gets the value of the cargo property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cargo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCargo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleCargos.Cargo }
     *
     *
     */
    public List<DetalleCargos.Cargo> getCargo() {
        if (cargo == null) {
            cargo = new ArrayList<DetalleCargos.Cargo>();
        }
        return this.cargo;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;>montoUF">
     *       &lt;attribute name="descripcion" use="required" type="{}descripcion" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "value" })
    public static class Cargo {

        @XmlValue
        protected BigDecimal value;
        @XmlAttribute(name = "descripcion", required = true)
        protected String descripcion;

        /**
         * monto en UF
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setValue(BigDecimal value) {
            this.value = value;
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

}
