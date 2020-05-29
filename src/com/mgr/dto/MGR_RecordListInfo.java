package com.mgr.dto;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 描述
 */
public class MGR_RecordListInfo {

	/*开门记录个数*/
	int MGR_recordCount;

	/*开门记录链表*/
	MGR_UnlockRecordInfo  MGR_recordList;

	public int getMGR_recordCount() {
		return MGR_recordCount;
	}

	public void setMGR_recordCount(int MGR_recordCount) {
		this.MGR_recordCount = MGR_recordCount;
	}

	public MGR_UnlockRecordInfo getMGR_recordList() {
		return MGR_recordList;
	}

	public void setMGR_recordList(MGR_UnlockRecordInfo MGR_recordList) {
		this.MGR_recordList = MGR_recordList;
	}
}
