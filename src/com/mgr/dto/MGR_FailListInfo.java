package com.mgr.dto;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 操作失败多个单位信息
 */
public class MGR_FailListInfo {

	/*失败信息的个数*/
	int MGR_failCount;

	/*失败信息单位列表，用户使用时自行申请空间*/
	MGR_FailNodeInfo MGR_failList;

	public int getMGR_failCount() {
		return MGR_failCount;
	}

	public void setMGR_failCount(int MGR_failCount) {
		this.MGR_failCount = MGR_failCount;
	}

	public MGR_FailNodeInfo getMGR_failList() {
		return MGR_failList;
	}

	public void setMGR_failList(MGR_FailNodeInfo MGR_failList) {
		this.MGR_failList = MGR_failList;
	}
}
