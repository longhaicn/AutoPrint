package com.newrocktech.autoprint.xml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.JDOMException;

import com.newrocktech.autoprint.entity.LabelEntity;
import com.newrocktech.autoprint.utils.Ping;
import com.newrocktech.autoprint.utils.ToolUtils;

public class LabelXMLValue {
	public static String getWebCon(String domain) {
		StringBuffer sb = new StringBuffer();
		try {
			java.net.URL url = new java.net.URL(domain);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return sb.toString();
		}
//		return sb.toString();
	}

	public static String checkWeb(String mappingIP) {
		String pass = "未通过";
		if(Ping.ping(mappingIP)){
			String agreementHttp = "http";
			String mappingPort = "80";
			String url = agreementHttp + "://" + mappingIP + ":" + mappingPort;
			String paramWeb = url + "/version";
			String paramBoa = url + "/xml?method=gw.config.get&id=7&pass=pass";
			String web = getWebCon(paramWeb);
			String xmlDoc=null;
			if(web.length()>3){
				xmlDoc = DeviceHttpRequest.sendGet(paramBoa, null, null);
			}
			pass = web.length() > 3 && xmlDoc.contains("?xml") ? "通过":"未通过";
		}
		
		return pass;
	}

	public static String getLabelXMLManually(String pass) {
		String model = "";
		DuXMLDoc doc = new DuXMLDoc();
		String mac_bin_model[] = new String[6];
		String mappingIP = null;
		// for (int j = 0; j < IPAddressEntity.ManualIPs.length; j++) {
		// if(Ping.ping(IPAddressEntity.ManualIPs[j])){
		// mappingIP=IPAddressEntity.ManualIPs[j];
		// }
		// }
		System.out.println(mappingIP);
		ArrayList<Map<String, String>> a = new ArrayList<Map<String, String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		List<Map<String, String>> result = null;
		String agreementHttp = "http";
		String mappingPort = "80";
		String url = agreementHttp + "://" + mappingIP + ":" + mappingPort + "/xml?";

		StringBuffer param = new StringBuffer("method=gw.config.get");
		// param.append("&id=48");//MX or OM
		// param.append("&id=7");//MAC
		// param.append("&id=1080");//OM 1080 MX 875
		// param.append("&id=875");//OM 1080 MX 875
		param.append("&id=57");// Equipment Model
		param.append("&pass=");
		param.append(pass);
		String xmlDoc = DeviceHttpRequest.sendGet(url + param.toString(), null, null);
		System.out.println(xmlDoc);
		int i = 0;
		try {
			List<Map<String, String>> ommx = doc.xmlElements(xmlDoc);

			model = ommx.get(0).get("value").trim();

			for (int j = 0; j < ommx.size(); j++) {
				System.out.println(ommx.get(j).get("value").trim());
				mac_bin_model[i++] = ommx.get(j).get("value").trim();
			}
			// for (int j = 0; j < mac_bin_model.length; j++) {
			// System.out.println(j+"="+mac_bin_model[j]);
			// }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}

	public static LabelEntity getLabelXML(String mappingIP) throws JDOMException, IOException {

		DuXMLDoc doc = new DuXMLDoc();
		String mac_bin_model[] = new String[3];
		int i = 0;

		ArrayList<Map<String, String>> a = new ArrayList<Map<String, String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		List<Map<String, String>> result = null;
		String agreementHttp = "http";
		String mappingPort = "80";
		String url = agreementHttp + "://" + mappingIP + ":" + mappingPort + "/xml?";
		String url2 = agreementHttp + "://" + mappingIP + ":" + mappingPort
				+ "/xml?method=gw.account.login&id51=admin&id900=k0k8";
		String xmlDoc2 = DeviceHttpRequest.sendGet(url2, null, null);
		System.out.println("xmlDoc2=" + xmlDoc2);
		// xml?method=gw.account.login&id51=mx8&id900=k0k8

		StringBuffer param = new StringBuffer("method=gw.config.get");
		param.append("&id=48");// MX or OM
		param.append("&pass=admin");
		String xmlDoc = DeviceHttpRequest.sendGet(url + param.toString(), null, null);

		List<Map<String, String>> ommx = doc.xmlElements(xmlDoc);
		String om_mx = ommx.get(0).get("value").trim();

		if ("OM".equals(om_mx)) {
			StringBuffer paramOM = new StringBuffer("method=gw.config.get");
			paramOM.append("&id=7");// MAC
			paramOM.append("&id=1080");// OM 1080 MX 875
			paramOM.append("&id=57");// Equipment Model
			paramOM.append("&pass=admin");
			String xmlDocOM = DeviceHttpRequest.sendGet(url + paramOM.toString(), null, null);
			System.out.println(xmlDocOM);
			result = doc.xmlElements(xmlDocOM);
		} else if ("MX".equals(om_mx)) {
			StringBuffer paramMX = new StringBuffer("method=gw.config.get");
			paramMX.append("&id=7");// MAC
			paramMX.append("&id=875");// OM 1080 MX 875
			paramMX.append("&id=57");// Equipment Model
			paramMX.append("&pass=admin");
			String xmlDocMX = DeviceHttpRequest.sendGet(url + paramMX.toString(), null, null);
			System.out.println(xmlDoc);
			result = doc.xmlElements(xmlDocMX);
		}

		for (Map<String, String> map : result) {
			mac_bin_model[i++] = map.get("value");
		}
		System.out.println(mac_bin_model[0] + mac_bin_model[1] + mac_bin_model[2]);
		LabelEntity entity = new LabelEntity();

		entity.MAC = mac_bin_model[0];
		String bin[] = mac_bin_model[1].split("\\.");
		entity.bin = bin[0] + "." + bin[1];
		String model[] = mac_bin_model[2].split(" ");
		entity.Model = model[2];
		entity.SN567 = ToolUtils.getSN567();
		entity.SN910 = mappingIP.substring(9, 11);
		System.out.println(entity.toString());
		return entity;

	}

}
