package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 操作失败时单个人脸或者卡片的信息
 */
public class MGR_FailNodeInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_attrName");
		Field.add("MGR_reason");
		return Field;
	}

	public static class ByReference extends MGR_FailNodeInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_FailNodeInfo implements Structure.ByValue{
	}

	/*属性为卡片：0-cardNum 1-roomNum 属性为人脸：0-cardNum 1-groupId*/
	public String[][] MGR_attrName;
	/*失败原因，用户可忽略判断类型，小于0 即失败*/
	public byte MGR_reason;

	public String[][] getMGR_attrName() {
		return MGR_attrName;
	}

	public void setMGR_attrName(String[][] MGR_attrName) {
		this.MGR_attrName = MGR_attrName;
	}

	public byte getMGR_reason() {
		return MGR_reason;
	}

	public void setMGR_reason(byte MGR_reason) {
		this.MGR_reason = MGR_reason;
	}
}
