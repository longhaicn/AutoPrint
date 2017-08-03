package com.newrocktech.autoprint.entity;

public class TadiranDeliverEntity {
	public String NewRockName;

	@Override
	public String toString() {
		return "TadiranDeliverEntity [NewRockName=" + NewRockName + ", TadiranName=" + TadiranName + ", BuyCat="
				+ BuyCat + ", SellCat=" + SellCat + ", BarCode=" + BarCode + ", SN=" + SN + ", TemplateId=" + TemplateId
				+ ", BinHead=" + BinHead + ", Remark=" + Remark + "]";
	}

	public String TadiranName;
	public String BuyCat;
	public String SellCat;
	public String BarCode;
	public String SN;
	public String TemplateId;
	public String BinHead;
	public String Remark;

	public String getNewRockName() {
		return NewRockName;
	}

	public void setNewRockName(String newRockName) {
		NewRockName = newRockName;
	}

	public String getTadiranName() {
		return TadiranName;
	}

	public void setTadiranName(String tadiranName) {
		TadiranName = tadiranName;
	}

	public String getBuyCat() {
		return BuyCat;
	}

	public void setBuyCat(String buyCat) {
		BuyCat = buyCat;
	}

	public String getSellCat() {
		return SellCat;
	}

	public void setSellCat(String sellCat) {
		SellCat = sellCat;
	}

	public String getBarCode() {
		return BarCode;
	}

	public void setBarCode(String barCode) {
		BarCode = barCode;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public String getTemplateId() {
		return TemplateId;
	}

	public void setTemplateId(String templateId) {
		TemplateId = templateId;
	}

	public String getBinHead() {
		return BinHead;
	}

	public void setBinHead(String binHead) {
		BinHead = binHead;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String toSelect() {
		return TadiranName + "," + BuyCat + "," + SellCat + "," + BarCode + "," + TemplateId + "," + Remark;
	}

}
