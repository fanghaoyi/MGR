package com.mgr.dto;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 卡片信息
 */
public class MGR_GetQRcodeInfo {

	/*可用次数，1-255*/
	int MGR_vaildCount;

	/*可用时间， 单位小时，1 - 255H*/
	int MGR_vaildTime;

	/*二维码所属用户房号*/
	String MGR_userRoom;

	public int getMGR_vaildCount() {
		return MGR_vaildCount;
	}

	public void setMGR_vaildCount(int MGR_vaildCount) {
		this.MGR_vaildCount = MGR_vaildCount;
	}

	public int getMGR_vaildTime() {
		return MGR_vaildTime;
	}

	public void setMGR_vaildTime(int MGR_vaildTime) {
		this.MGR_vaildTime = MGR_vaildTime;
	}

	public String getMGR_userRoom() {
		return MGR_userRoom;
	}

	public void setMGR_userRoom(String MGR_userRoom) {
		this.MGR_userRoom = MGR_userRoom;
	}
}
