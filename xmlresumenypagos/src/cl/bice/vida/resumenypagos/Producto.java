
package cl.bice.vida.resumenypagos;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * descripcion de un producto
 *
 * <p>Java class for producto complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="producto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodigoProducto" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/>
 *         &lt;element name="DescripcionProducto" type="{}descripcion"/>
 *         &lt;element name="NumProducto" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="CodEmpresa" type="{}cod_persona"/>
 *         &lt;element name="TipoCuota" type="{}tipoCuotaFormato" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "producto", propOrder = {
         "codigoProducto", "descripcionProducto", "numProducto", "codEmpresa", "tipoCuota" })
@XmlSeeAlso({
            cl.bice.vida.resumenypagos.ResumenConHeader.ProductosPorPagar.Entrada.Producto.class,
            cl.bice.vida.resumenypagos.ResumenConHeader.ProductosPagados.Entrada.Producto.class,
            cl.bice.vida.resumenypagos.RespuestaPagosPendientes.Producto.class,
            cl.bice.vida.resumenypagos.InformePago.PagoExitoso.ProductosPorPagar.Entrada.Producto.class,
            cl.bice.vida.resumenypagos.RespuestaServipagVida.ListaProductos.Entrada.Producto.class,
            cl.bice.vida.resumenypagos.Confirmacion.ProductosPorPagar.Entrada.Producto.class,
            cl.bice.vida.resumenypagos.RespuestaServipagHipotecaria.ListaProductos.Entrada.Producto.class
    })
public class Producto {

    @XmlElement(name = "CodigoProducto", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger codigoProducto;
    @XmlElement(name = "DescripcionProducto", required = true)
    protected String descripcionProducto;
    @XmlElement(name = "NumProducto", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger numProducto;
    @XmlElement(name = "CodEmpresa")
    @XmlSchemaType(name = "integer")
    protected int codEmpresa;
    @XmlElement(name = "TipoCuota")
    @XmlSchemaType(name = "positiveInteger")
    protected Integer tipoCuota;

    /**
     * Gets the value of the codigoProducto property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * Sets the value of the codigoProducto property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setCodigoProducto(BigInteger value) {
        this.codigoProducto = value;
    }

    /**
     * Gets the value of the descripcionProducto property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * Sets the value of the descripcionProducto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripcionProducto(String value) {
        this.descripcionProducto = value;
    }

    /**
     * Gets the value of the numProducto property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getNumProducto() {
        return numProducto;
    }

    /**
     * Sets the value of the numProducto property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNumProducto(BigInteger value) {
        this.numProducto = value;
    }

    /**
     * Gets the value of the codEmpresa property.
     *
     */
    public int getCodEmpresa() {
        return codEmpresa;
    }

    /**
     * Sets the value of the codEmpresa property.
     *
     */
    public void setCodEmpresa(int value) {
        this.codEmpresa = value;
    }

    /**
     * Gets the value of the tipoCuota property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getTipoCuota() {
        return tipoCuota;
    }

    /**
     * Sets the value of the tipoCuota property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setTipoCuota(Integer value) {
        this.tipoCuota = value;
    }

}
