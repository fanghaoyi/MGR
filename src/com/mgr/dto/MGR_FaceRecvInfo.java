package com.mgr.dto;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 描述
 */
public class MGR_FaceRecvInfo {

	int MGR_recvCount;

	int MGR_recvStart;

	MGR_FaceListInfo MGR_faceList;

	public int getMGR_recvCount() {
		return MGR_recvCount;
	}

	public void setMGR_recvCount(int MGR_recvCount) {
		this.MGR_recvCount = MGR_recvCount;
	}

	public int getMGR_recvStart() {
		return MGR_recvStart;
	}

	public void setMGR_recvStart(int MGR_recvStart) {
		this.MGR_recvStart = MGR_recvStart;
	}

	public MGR_FaceListInfo getMGR_faceList() {
		return MGR_faceList;
	}

	public void setMGR_faceList(MGR_FaceListInfo MGR_faceList) {
		this.MGR_faceList = MGR_faceList;
	}
}
