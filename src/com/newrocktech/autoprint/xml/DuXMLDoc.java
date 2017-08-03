package com.newrocktech.autoprint.xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

public class DuXMLDoc {
	@SuppressWarnings("rawtypes")
	public List<Map<String, String>> xmlElements(String xmlDoc) throws JDOMException, IOException {
		StringReader xmlString = new StringReader(xmlDoc);
		InputSource source = new InputSource(xmlString);
		SAXBuilder saxb = new SAXBuilder();

		List<Map<String, String>> result = null;
		result = new ArrayList<Map<String, String>>();
		Document doc = saxb.build(source);
		Element root = doc.getRootElement();
		List node = root.getChildren();
		Element et = null;
		for (int i = 0; i < node.size(); i++) {
			et = (Element) node.get(i);
			if ("Error".equalsIgnoreCase(et.getName())) {
				Map<String, String> map = new HashMap<String, String>();
				map.put(et.getName(), et.getAttribute("msg").getValue());
				result.add(map);
				break;
			}
			List subNode = et.getChildren();
			Element subEt = null;
			for (int j = 0; j < subNode.size(); j++) {
				subEt = (Element) subNode.get(j);
				List subetNode = subEt.getChildren();
				if (subetNode.size() == 0) {
					Map<String, String> map = new HashMap<String, String>();
					Iterator it = subEt.getAttributes().iterator();
					while (it.hasNext()) {
						Attribute attr = (Attribute) it.next();
						map.put(attr.getName(), attr.getValue());
					}
					result.add(map);
					continue;
				}

				Element subEt2 = null;
				for (int j2 = 0; j2 < subetNode.size(); j2++) {
					subEt2 = (Element) subetNode.get(j2);
					if (subEt2.getName().equals("item")) {
						Map<String, String> map = new HashMap<String, String>();
						Iterator it = subEt2.getAttributes().iterator();
						while (it.hasNext()) {
							Attribute attr = (Attribute) it.next();
							map.put(attr.getName(), attr.getValue());
							result.add(map);
						}
					} else {
						Map<String, String> map = new HashMap<String, String>();
						map.put(subEt2.getName(), subEt2.getText().trim());
						result.add(map);
					}
				}
			}

		}

		return result;
	}

}
