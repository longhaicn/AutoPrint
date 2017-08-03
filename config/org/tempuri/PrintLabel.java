
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="macAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="printModel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bPrintAgain" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="copies" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="printContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "macAddress",
    "printModel",
    "bPrintAgain",
    "copies",
    "printContent"
})
@XmlRootElement(name = "PrintLabel")
public class PrintLabel {

    protected String macAddress;
    protected String printModel;
    protected boolean bPrintAgain;
    protected short copies;
    protected String printContent;

    /**
     * 获取macAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMacAddress() {
        return macAddress;
    }

    /**
     * 设置macAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMacAddress(String value) {
        this.macAddress = value;
    }

    /**
     * 获取printModel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrintModel() {
        return printModel;
    }

    /**
     * 设置printModel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrintModel(String value) {
        this.printModel = value;
    }

    /**
     * 获取bPrintAgain属性的值。
     * 
     */
    public boolean isBPrintAgain() {
        return bPrintAgain;
    }

    /**
     * 设置bPrintAgain属性的值。
     * 
     */
    public void setBPrintAgain(boolean value) {
        this.bPrintAgain = value;
    }

    /**
     * 获取copies属性的值。
     * 
     */
    public short getCopies() {
        return copies;
    }

    /**
     * 设置copies属性的值。
     * 
     */
    public void setCopies(short value) {
        this.copies = value;
    }

    /**
     * 获取printContent属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrintContent() {
        return printContent;
    }

    /**
     * 设置printContent属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrintContent(String value) {
        this.printContent = value;
    }

}
