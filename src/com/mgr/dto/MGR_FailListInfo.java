package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 操作失败多个单位信息
 */
public class MGR_FailListInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_failCount");
		Field.add("MGR_failList");
		return Field;
	}

	public static class ByReference extends MGR_FailListInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_FailListInfo implements Structure.ByValue{
	}

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
