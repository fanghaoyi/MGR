package com.mgr.dto;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 开门记录结构体
 */
public class MGR_UnlockRecordInfo {

	/*开门的主题，卡号，人脸，远程账号等*/
	String user;
	/*开门的用户房号*/
	String room;
	/*开门的时间*/
	String time;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
