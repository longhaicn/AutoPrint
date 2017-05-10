package com.newrocktech.autoprint.entity;

public class LabelEntity {
	/**Mac�����*/
	public String macChecked;
	/**ģ���*/
	public String TemplateId;
	/**��Ʒ����*/
	public String Product;
	/**��Ʒ�ͺ�*/
	public String Model;
	/**��ƷMAC��ַ*/
	public String MAC;
	/**SN��*/
	public String SN1234;
	/**����*/
	public String SN567;
	/**��λ��*/
	public String SN8;
	/**IP��·��*/
	public String SN910;
	/**������������*/
	public int SN11121314;
	/**web�����*/
	public String appChecked;
	/**bin�ļ�ͷ*/
	public String bin;
	/**SN*/
	public String SN=SN1234+SN567+SN8+SN910+String.format("%04d", SN11121314);

	/**���췽��
	 */
	public LabelEntity(){
		
	}
	public LabelEntity(String templateId, String product, String model, String mAC, String sN1234, String sN567,
			String sN8, String sN910, int sN11121314, String bin) { 
		super();
		TemplateId = templateId;
		Product = product;
		Model = model;
		MAC = mAC;
		SN1234 = sN1234;
		SN567 = sN567;
		SN8 = sN8;
		SN910 = sN910;
		SN11121314 = sN11121314;
		this.bin = bin;
	}
	
	@Override
	public String toString() {
		return "LabelEntity [Checked=" + macChecked + ", TemplateId=" + TemplateId + ", Product=" + Product + ", Model=" + Model + ", MAC=" + MAC
				 + ", SN=" + SN1234+SN567+SN8+SN910+String.format("%04d", SN11121314) + "]";//+ ", SN1234=" + SN1234 + ", SN567=" + SN567 + ", SN8=" + SN8 + ", SN910=" + SN910 + ", SN11121314="
	}
}
