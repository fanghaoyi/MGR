package com.mgr.dto;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 卡片链表
 */
public class MGR_CardListInfo {

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
