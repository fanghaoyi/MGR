package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 新建连接服务端时私有资源信息，用户无需理会
 */
public class MGR_CardRecvInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_recvCount");
		Field.add("MGR_recvStart");
		Field.add("MGR_cardList");
		return Field;
	}

	public static class ByReference extends MGR_CardRecvInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_CardRecvInfo implements Structure.ByValue{
	}

	int MGR_recvCount;

	int MGR_recvStart;

	MGR_CardListInfo MGR_cardList;

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

	public MGR_CardListInfo getMGR_cardList() {
		return MGR_cardList;
	}

	public void setMGR_cardList(MGR_CardListInfo MGR_cardList) {
		this.MGR_cardList = MGR_cardList;
	}
}
