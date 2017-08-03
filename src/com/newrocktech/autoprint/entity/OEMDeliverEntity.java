package com.newrocktech.autoprint.entity;

public class OEMDeliverEntity {

	public String newrock_name;
	public String oem_name;
	public String template_id;
	public String bin_name;

	public String getNewrock_name() {
		return newrock_name;
	}

	public void setNewrock_name(String newrock_name) {
		this.newrock_name = newrock_name;
	}

	public String getOem_name() {
		return oem_name;
	}

	public void setOem_name(String oem_name) {
		this.oem_name = oem_name;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getBin_name() {
		return bin_name;
	}

	public void setBin_name(String bin_name) {
		this.bin_name = bin_name;
	}

	@Override
	public String toString() {
		return "OEMDeliverEntity [newrock_name=" + newrock_name + ", oem_name=" + oem_name + ", template_id="
				+ template_id + ", bin_name=" + bin_name + "]";
	}

	public String toSelect() {
		// TODO Auto-generated method stub
		return oem_name + "," + bin_name + "," + template_id;
	}

}
