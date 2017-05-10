package com.newrocktech.autoprint.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.newrocktech.autoprint.entity.IPAddressEntity;
import com.newrocktech.autoprint.entity.LabelEntity;
import com.newrocktech.autoprint.xml.LabelXMLValue;

public class LabelImpl {
	
	public static List<LabelEntity> getAllEquipmentLabel(){
		List<LabelEntity> lists = new ArrayList<LabelEntity>();
		try {
			int len = IPAddressEntity.IPs.length;
			for (int i = 0; i < len; i++) {
				lists.add(LabelXMLValue.getLabelXML(IPAddressEntity.IPs[i]));
			}
		} catch (Exception e) {
		}
		return lists;
	}
	public static Vector<Vector<Object>> toVector(List<LabelEntity> lists) {
		List<LabelEntity> listPass = new ArrayList<LabelEntity>();
		List<LabelEntity> listFailPass = new ArrayList<LabelEntity>();
		for (LabelEntity labelEntity : lists) {
			if("通过".equals(labelEntity.macChecked)){
				listPass.add(labelEntity);
			}else if(MacManageImpl.checkMac(labelEntity.MAC)){
				labelEntity.macChecked="通过";
				listPass.add(labelEntity);
			}else{
				labelEntity.macChecked="未通过";
				listFailPass.add(labelEntity);
			}
		}
		for (LabelEntity labelEntity : listPass) {
			listFailPass.add(labelEntity);
		}
		Vector<Vector<Object>> temp = new Vector<Vector<Object>>();
		if (lists != null && listFailPass.size() > 0) {
			for (LabelEntity entity : listFailPass) {
				Vector<Object> v = new Vector<>();
				v.add(entity.Model);
				v.add(entity.MAC);
				v.add(entity.bin);
				v.add(entity.SN910);
				v.add(entity.macChecked);
				temp.add(v);
			}
		}
		return temp;
	}//select SUM(printsum) from PrintRecord where datetime='17C';
}
