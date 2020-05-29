package com.mgr.dto;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 操作失败时单个人脸或者卡片的信息
 */
public class MGR_FailNodeInfo {

	/*属性为卡片：0-cardNum 1-roomNum 属性为人脸：0-cardNum 1-groupId*/
	String[][] MGR_attrName;
	/*失败原因，用户可忽略判断类型，小于0 即失败*/
	char MGR_reason;

	public String[][] getMGR_attrName() {
		return MGR_attrName;
	}

	public void setMGR_attrName(String[][] MGR_attrName) {
		this.MGR_attrName = MGR_attrName;
	}

	public char getMGR_reason() {
		return MGR_reason;
	}

	public void setMGR_reason(char MGR_reason) {
		this.MGR_reason = MGR_reason;
	}
}