package com.newrocktech.autoprint.entity;

public class MacAddressEntity {
	/**�Ϻ�*/
	public String part;
	/**�����к�*/
	public String serial;
	/**�ϵ�MAC*/
	public String mac;
	/**ʱ���¼*/
	public String datetime;
	public MacAddressEntity(String part,String serial,String mac){
		this.part = part;
		this.serial = serial;
		this.mac = mac;
	}
}
