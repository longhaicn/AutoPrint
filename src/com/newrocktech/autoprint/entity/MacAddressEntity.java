package com.newrocktech.autoprint.entity;

public class MacAddressEntity {
	/**料号*/
	public String part;
	/**料序列号*/
	public String serial;
	/**料的MAC*/
	public String mac;
	/**时间记录*/
	public String datetime;
	public MacAddressEntity(String part,String serial,String mac){
		this.part = part;
		this.serial = serial;
		this.mac = mac;
	}
}
