package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 开门记录结构体
 */
public class MGR_UnlockRecordInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("user");
		Field.add("room");
		Field.add("time");
		return Field;
	}

	public static class ByReference extends MGR_UnlockRecordInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_UnlockRecordInfo implements Structure.ByValue{
	}

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
