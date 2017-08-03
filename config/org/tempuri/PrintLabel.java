
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡmacAddress���Ե�ֵ��
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
     * ����macAddress���Ե�ֵ��
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
     * ��ȡprintModel���Ե�ֵ��
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
     * ����printModel���Ե�ֵ��
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
     * ��ȡbPrintAgain���Ե�ֵ��
     * 
     */
    public boolean isBPrintAgain() {
        return bPrintAgain;
    }

    /**
     * ����bPrintAgain���Ե�ֵ��
     * 
     */
    public void setBPrintAgain(boolean value) {
        this.bPrintAgain = value;
    }

    /**
     * ��ȡcopies���Ե�ֵ��
     * 
     */
    public short getCopies() {
        return copies;
    }

    /**
     * ����copies���Ե�ֵ��
     * 
     */
    public void setCopies(short value) {
        this.copies = value;
    }

    /**
     * ��ȡprintContent���Ե�ֵ��
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
     * ����printContent���Ե�ֵ��
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
