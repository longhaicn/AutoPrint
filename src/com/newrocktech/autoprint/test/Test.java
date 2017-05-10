package com.newrocktech.autoprint.test;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;

import javax.swing.JOptionPane;

import org.jdom.JDOMException;
import org.tempuri.KgmWebService;
import org.tempuri.KgmWebServiceSoap;

import com.newrocktech.autoprint.entity.MacAddressEntity;
import com.newrocktech.autoprint.impl.InitDataImpl;
import com.newrocktech.autoprint.impl.MacManageImpl;
import com.newrocktech.autoprint.impl.NewrockDeliverImpl;
import com.newrocktech.autoprint.impl.WorkerListImpl;
import com.newrocktech.autoprint.logfile.LabelLogAutoUpdate;
import com.newrocktech.autoprint.logfile.LabelLogManualUpdate;
import com.newrocktech.autoprint.utils.ConfigUtils;
import com.newrocktech.autoprint.utils.ExcelImportUtils;
import com.newrocktech.autoprint.utils.Ping;
import com.newrocktech.autoprint.utils.ToolUtils;
import com.newrocktech.autoprint.utils.ZipUtils;
import com.newrocktech.autoprint.xml.DeviceHttpAccess;
import com.newrocktech.autoprint.xml.LabelXMLValue;

import net.sf.json.JSON;
class PmcAuthenticator extends Authenticator {
	protected PasswordAuthentication getPasswordAuthentication() {
	    return new PasswordAuthentication(ConfigUtils.get("Administrator"),ConfigUtils.get("Pass").toCharArray());
	}
}
public abstract class Test {
	

	public static void main(String[] args) {
		
		
		

//		System.getProperty("user.dir");
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null, System.getProperty("user.dir"), null, JOptionPane.INFORMATION_MESSAGE);
		
		
	}
	
//	System.out.println(LabelXMLValue.checkWeb("192.168.130.173"));
	
//	Thread the = new Thread
	//Connection refused  ---boa 没起来
	//Connection timed out ---断电，断网
	/*
	url=http://192.168.130.228:80/version
	HTTP GET异常！[Request:]http://192.168.130.228:80/versionhttp://192.168.130.228:80/version :null[Error:]java.io.FileNotFoundException: http://192.168.130.228:80/versionhttp://192.168.130.228:80/version
		xmlDochttp://192.168.130.228:80/versionhttp://192.168.130.228:80/versionend
		false
		
		
	*/

	public static void test2() {
		String str   =  " 000EA9012A00-MX.F5.3.0.6.344_P2.C0.01-96FXOS4-F";
		str = str.substring(str.indexOf("-")+1);
		String model = str.substring(str.indexOf("-")+1);
		int n = model.indexOf("S");
		int m = model.length();
		if (n < m - 1) {
			char c = model.charAt(n + 1);
			if (Character.isDigit(c)) {
				model = model.substring(0, n) + "S/" + model.substring(n + 1);
			}
		}
		System.out.println(model);
	}

	public static void test1() {
		String product = "MX8A-4FXS4FXO";
		int n  = product.indexOf("S");
		int m = product.length();
		if (n<m-1) {
			char c = product.charAt(n+1);
			if(Character.isDigit(c)){
				product=product.substring(0, n)+"S/"+product.substring(n+1);
			}
		}
		
//		try {
//			LabelXMLValue.getLabelXMLManually("mx8");
//		} catch (JDOMException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		WorkerListImpl.loginWorker("A");
//		dao.initNewrockDeliver();
//		LabelLogfileValue.getAllEquipmentLabel();
//		String str = String.format("%04d", 1);      
//
//	    System.out.println(str); // 0001      
		
//		System.out.println(PrintImpl.getSN11121314("17C"));
//		try {
//			LabelXMLValue.getLabelXML("192.168.130.214");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		String str = "01234567089";
//		System.out.println(str.substring(4,6));
		
		// TODO Auto-generated method stub
//		TestDao dao = new TestDao();
//		dao.test();
//		ZipUtils zip = new ZipUtils();
//		zip.ZipMultiFile("E:\\log", "E:\\log.zip");
//		test2();
//		LabelLogManualUpdate.getOneEquipmentLabel();
//		System.out.println(DeviceHttpAccess.getDeviceAccess());
		
//		LabelLogManualUpdate.getOneEquipmentLabel();
		
//		System.out.println(NewrockDeliverImpl.queryPass("MX.L1"));
//		ZipUtils.copyFolder(ConfigUtils.getConfiguration(ConfigUtils.AutoUpdLogPath),ConfigUtils.getConfiguration(ConfigUtils.AutoUpdLogPath)+ToolUtils.getDateTime());

//		ZipUtils.deleteFile(ConfigUtils.getConfiguration(ConfigUtils.AutoUpdLogPath));
		
//		System.out.println(NewrockDeliverImpl.queryAllGoods("MX.N1").get(0).template_id);
//		System.out.println(ConfigUtils.getConfiguration("LogPath"));
		
//		test1();
//		
		System.out.println(product);
	}
	

}
