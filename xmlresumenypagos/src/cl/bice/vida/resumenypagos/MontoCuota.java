
package cl.bice.vida.resumenypagos;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * detalle en pesos y UF de una cuota
 *
 * <p>Java class for montoCuota complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="montoCuota">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EnPesos" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="EnUF" type="{}montoUF"/>
 *         &lt;element name="Detalle" type="{}detalleCargos" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "montoCuota", propOrder = { "enPesos", "enUF", "detalle" })
@XmlSeeAlso({
            cl.bice.vida.resumenypagos.ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMin.class,
            cl.bice.vida.resumenypagos.ResumenConHeader.ProductosPorPagar.Entrada.Cuota.CuotaOpcion.CuotaMax.class,
            cl.bice.vida.resumenypagos.RespuestaPagosPendientes.Cuota.class,
            cl.bice.vida.resumenypagos.InformePago.PagoExitoso.ProductosPorPagar.Entrada.Cuota.Monto.class,
            cl.bice.vida.resumenypagos.RespuestaServipagVida.ListaProductos.Entrada.Cuota.MontoCuota.class,
            cl.bice.vida.resumenypagos.Confirmacion.ProductosPorPagar.Entrada.Cuota.Monto.class,
            cl.bice.vida.resumenypagos.RespuestaServipagHipotecaria.ListaProductos.Entrada.Cuota.MontoCuota.class
    })
public class MontoCuota {

    @XmlElement(name = "EnPesos", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger enPesos;
    @XmlElement(name = "EnUF", required = true)
    protected BigDecimal enUF;
    @XmlElement(name = "Detalle")
    protected DetalleCargos detalle;

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

    /**
     * Gets the value of the detalle property.
     *
     * @return
     * possible object is
     * {@link cl.bice.vida.resumenypagos.DetalleCargos}
     *
     */
    public DetalleCargos getDetalle() {
        return detalle;
    }

    /**
     * Sets the value of the detalle property.
     *
     * @param value
     * allowed object is
     * {@link cl.bice.vida.resumenypagos.DetalleCargos}
     *
     */
    public void setDetalle(DetalleCargos value) {
        this.detalle = value;
    }

}
