package com.newrocktech.autoprint.entity;

public class LabelEntity {
	/**Mac检测结果*/
	public String macChecked;
	/**模板号*/
	public String TemplateId;
	/**产品名称*/
	public String Product;
	/**产品型号*/
	public String Model;
	/**产品MAC地址*/
	public String MAC;
	/**SN号*/
	public String SN1234;
	/**年月*/
	public String SN567;
	/**工位号*/
	public String SN8;
	/**IP线路号*/
	public String SN910;
	/**当月生产数量*/
	public int SN11121314;
	/**web检测结果*/
	public String appChecked;
	/**bin文件头*/
	public String bin;
	/**SN*/
	public String SN=SN1234+SN567+SN8+SN910+String.format("%04d", SN11121314);

	/**构造方法
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
