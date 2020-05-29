package com.mgr.dto;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 人脸信息链表
 */
public class MGR_FaceListInfo {

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
