package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 人脸注册信息，注册时需要绑定已注册卡片
 */
public class MGR_RegFaceInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_info");
		Field.add("MGR_room");
		Field.add("MGR_name");
		Field.add("MGR_jpegName");
		Field.add("MGR_jpegData");
		Field.add("MGR_jpegDataLen");
		return Field;
	}

	public static class ByReference extends MGR_RegFaceInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_RegFaceInfo implements Structure.ByValue{
	}

	/*人脸信息，用户自定义*/
	String MGR_info;

	/*已注册卡片绑定的房间号*/
	String MGR_room;

	/*已注册卡片卡号，常见普通门禁卡号，身份证号*/
	String MGR_name;

	/*需要注册的人脸图片名字，目前限定JPG格式*/
	String MGR_jpegName;

	/*人脸图片的数据*/
	String MGR_jpegData;

	/*人脸图片数据的长度*/
	int MGR_jpegDataLen;

	public String getMGR_info() {
		return MGR_info;
	}

	public void setMGR_info(String MGR_info) {
		this.MGR_info = MGR_info;
	}

	public String getMGR_room() {
		return MGR_room;
	}

	public void setMGR_room(String MGR_room) {
		this.MGR_room = MGR_room;
	}

	public String getMGR_name() {
		return MGR_name;
	}

	public void setMGR_name(String MGR_name) {
		this.MGR_name = MGR_name;
	}

	public String getMGR_jpegName() {
		return MGR_jpegName;
	}

	public void setMGR_jpegName(String MGR_jpegName) {
		this.MGR_jpegName = MGR_jpegName;
	}

	public String getMGR_jpegData() {
		return MGR_jpegData;
	}

	public void setMGR_jpegData(String MGR_jpegData) {
		this.MGR_jpegData = MGR_jpegData;
	}

	public int getMGR_jpegDataLen() {
		return MGR_jpegDataLen;
	}

	public void setMGR_jpegDataLen(int MGR_jpegDataLen) {
		this.MGR_jpegDataLen = MGR_jpegDataLen;
	}
}
