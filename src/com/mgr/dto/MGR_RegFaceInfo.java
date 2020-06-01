package com.mgr.dto;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;

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
		/*Field.add("MGR_info");
		Field.add("MGR_jpegData");
		Field.add("MGR_jpegDataLen");
		Field.add("MGR_jpegName");
		Field.add("MGR_name");
		Field.add("MGR_room");*/
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
	public Pointer MGR_info;

	/*已注册卡片绑定的房间号*/
	public Pointer MGR_room;

	/*已注册卡片卡号，常见普通门禁卡号，身份证号*/
	public Pointer MGR_name;

	/*需要注册的人脸图片名字，目前限定JPG格式*/
	public Pointer MGR_jpegName;

	/*人脸图片的数据*/
	public Pointer MGR_jpegData;

	/*人脸图片数据的长度*/
	public IntByReference MGR_jpegDataLen;

	public Pointer getMGR_info() {
		return MGR_info;
	}

	public void setMGR_info(Pointer MGR_info) {
		this.MGR_info = MGR_info;
	}

	public Pointer getMGR_room() {
		return MGR_room;
	}

	public void setMGR_room(Pointer MGR_room) {
		this.MGR_room = MGR_room;
	}

	public Pointer getMGR_name() {
		return MGR_name;
	}

	public void setMGR_name(Pointer MGR_name) {
		this.MGR_name = MGR_name;
	}

	public Pointer getMGR_jpegName() {
		return MGR_jpegName;
	}

	public void setMGR_jpegName(Pointer MGR_jpegName) {
		this.MGR_jpegName = MGR_jpegName;
	}

	public Pointer getMGR_jpegData() {
		return MGR_jpegData;
	}

	public void setMGR_jpegData(Pointer MGR_jpegData) {
		this.MGR_jpegData = MGR_jpegData;
	}

	public IntByReference getMGR_jpegDataLen() {
		return MGR_jpegDataLen;
	}

	public void setMGR_jpegDataLen(IntByReference MGR_jpegDataLen) {
		this.MGR_jpegDataLen = MGR_jpegDataLen;
	}
}
