package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 卡片链表
 */
public class MGR_CardListInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_cardCount");
		Field.add("MGR_cardList");
		return Field;
	}

	public static class ByReference extends MGR_CardListInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_CardListInfo implements Structure.ByValue{
	}

	/*卡片数量*/
	int MGR_cardCount;
	/*卡片列表，用户使用时自行申请空间*/
	MGR_CardInfo MGR_cardList;

	public int getMGR_cardCount() {
		return MGR_cardCount;
	}

	public void setMGR_cardCount(int MGR_cardCount) {
		this.MGR_cardCount = MGR_cardCount;
	}

	public MGR_CardInfo getMGR_cardList() {
		return MGR_cardList;
	}

	public void setMGR_cardList(MGR_CardInfo MGR_cardList) {
		this.MGR_cardList = MGR_cardList;
	}
}
