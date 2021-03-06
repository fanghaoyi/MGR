package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 人脸删除信息，删除时检索绑定的卡号
 */
public class MGR_DelFaceInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_gpid");
		Field.add("MGR_name");
		return Field;
	}

	public static class ByReference extends MGR_DelFaceInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_DelFaceInfo implements Structure.ByValue{
	}

	/*服务器的地址编码，例如2010101010101*/
	String MGR_gpid;

	/*人脸注册时绑定的卡号*/
	String MGR_name;

	public String getMGR_gpid() {
		return MGR_gpid;
	}

	public void setMGR_gpid(String MGR_gpid) {
		this.MGR_gpid = MGR_gpid;
	}

	public String getMGR_name() {
		return MGR_name;
	}

	public void setMGR_name(String MGR_name) {
		this.MGR_name = MGR_name;
	}

}
