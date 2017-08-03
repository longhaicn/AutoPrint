package com.newrocktech.autoprint.xml;

public class DeviceHttpAccess {
	public static String getDeviceAccess() {
		String password = null;
		String pwds[] = { "mx60", "hx4", "mx100", "mx120", "SX3000@123", "voip", "mx8", "admin" };
		String agreementHttp = "http";
		String mappingIP = "192.168.130.214";// "172.168.001.100"
		String mappingPort = "80";
		String url0 = agreementHttp + "://" + mappingIP + ":" + mappingPort + "/xml?method=gw.account.login&id51=";
		for (int i = 0; i < pwds.length; i++) {
			String url = url0 + pwds[i];
			System.out.println(url);
			String xmlDoc = DeviceHttpRequest.sendGet(url, null, null);
			System.out.println(xmlDoc);
			if (xmlDoc.contains("ok")) {
				password = pwds[i];
			}
		}
		return password;
	}
}
