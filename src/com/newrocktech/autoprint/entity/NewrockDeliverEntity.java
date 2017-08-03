package com.newrocktech.autoprint.entity;

public class NewrockDeliverEntity {
	/** 数据库流水号 */
	public int id;
	/** 铭牌分类 */
	public String label_sort;
	/** 模板号 */
	public String template_id;
	/** bin文件名 */
	public String bin_head;
	/** 产品名称 */
	public String product_name;
	/** SN前四位 */
	public String sn1234;
	/** 设备默认登录密码 */
	public String pass;

	public String toSelect() {
		return label_sort + "," + sn1234 + "," + product_name + "," + template_id;
	}

	@Override
	public String toString() {
		return "NewrockDeliverEntity [id=" + id + ", label_sort=" + label_sort + ", template_id=" + template_id
				+ ", bin_head=" + bin_head + ", product_name=" + product_name + ", sn1234=" + sn1234 + ", pass=" + pass
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel_sort() {
		return label_sort;
	}

	public void setLabel_sort(String label_sort) {
		this.label_sort = label_sort;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getBin_head() {
		return bin_head;
	}

	public void setBin_head(String bin_head) {
		this.bin_head = bin_head;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getSn1234() {
		return sn1234;
	}

	public void setSn1234(String sn1234) {
		this.sn1234 = sn1234;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
