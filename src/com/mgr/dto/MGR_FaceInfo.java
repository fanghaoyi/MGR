package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 人脸信息
 */
public class MGR_FaceInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_isDelete");
		Field.add("MGR_isModify");
		Field.add("MGR_info");
		Field.add("MGR_gpid");
		Field.add("MGR_name");
		Field.add("MGR_feature");
		Field.add("MGR_featureLen");
		return Field;
	}

	public static class ByReference extends MGR_FaceInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_FaceInfo implements Structure.ByValue{
	}

	/*人脸信息内部标志位，用户无需理会*/
	int MGR_isDelete;
	int	MGR_isModify;

	/*人脸信息，用户自定义*/
	String MGR_info;

	/*人脸所在服务器的地址编码，例如2010101010101*/
	String MGR_gpid;

	/*人脸注册时绑定的卡号*/
	String MGR_name;

	/*人脸通过算法注册后的特征值*/
	String MGR_feature;

	/*人脸特征值长度*/
	int MGR_featureLen;


	public int getMGR_isDelete() {
		return MGR_isDelete;
	}

	public void setMGR_isDelete(int MGR_isDelete) {
		this.MGR_isDelete = MGR_isDelete;
	}

	public int getMGR_isModify() {
		return MGR_isModify;
	}

	public void setMGR_isModify(int MGR_isModify) {
		this.MGR_isModify = MGR_isModify;
	}

	public String getMGR_info() {
		return MGR_info;
	}

	public void setMGR_info(String MGR_info) {
		this.MGR_info = MGR_info;
	}

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

	public String getMGR_feature() {
		return MGR_feature;
	}

	public void setMGR_feature(String MGR_feature) {
		this.MGR_feature = MGR_feature;
	}

	public int getMGR_featureLen() {
		return MGR_featureLen;
	}

	public void setMGR_featureLen(int MGR_featureLen) {
		this.MGR_featureLen = MGR_featureLen;
	}
}
