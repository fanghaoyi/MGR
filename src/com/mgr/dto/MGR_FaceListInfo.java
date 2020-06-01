package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 人脸信息链表
 */
public class MGR_FaceListInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_faceCount");
		Field.add("MGR_faceList");
		return Field;
	}

	public static class ByReference extends MGR_FaceListInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_FaceListInfo implements Structure.ByValue{
	}
	/*人脸信息数量*/
	int MGR_faceCount;

	/*人脸信息链表，用户使用时自行申请空间*/
	MGR_FaceInfo MGR_faceList;

	public int getMGR_faceCount() {
		return MGR_faceCount;
	}

	public void setMGR_faceCount(int MGR_faceCount) {
		this.MGR_faceCount = MGR_faceCount;
	}

	public MGR_FaceInfo getMGR_faceList() {
		return MGR_faceList;
	}

	public void setMGR_faceList(MGR_FaceInfo MGR_faceList) {
		this.MGR_faceList = MGR_faceList;
	}

}
