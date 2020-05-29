package com.mgr.dto;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 新建连接服务端时私有资源信息，用户无需理会
 */
public class MGR_RecordRecvInfo {

	int MGR_recvCount;

	int MGR_recvStart;

	MGR_RecordListInfo MGR_recordList;


	public void setMGR_recvCount(int MGR_recvCount) {
		this.MGR_recvCount = MGR_recvCount;
	}

	public int getMGR_recvStart() {
		return MGR_recvStart;
	}

	public void setMGR_recvStart(int MGR_recvStart) {
		this.MGR_recvStart = MGR_recvStart;
	}

	public MGR_RecordListInfo getMGR_recordList() {
		return MGR_recordList;
	}

	public void setMGR_recordList(MGR_RecordListInfo MGR_recordList) {
		this.MGR_recordList = MGR_recordList;
	}
}
