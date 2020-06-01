package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 卡片信息
 */
public class MGR_CardInfo extends Structure {
	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_card");
		Field.add("MGR_room");
		Field.add("MGR_time");
		Field.add("MGR_type");
		return Field;
	}

	public static class ByReference extends MGR_CardInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_CardInfo implements Structure.ByValue{
	}

	/*卡号，例如普通门禁卡的卡号和身份证号*/
	String MGR_card;

	/*注册卡片时绑定的房间号*/
	String MGR_room;

	/*注册卡片时的时间，可忽略*/
	String MGR_time;

	/*注册卡片时的类型，固定为card*/
	String MGR_type;

	public String getMGR_card() {
		return MGR_card;
	}

	public void setMGR_card(String MGR_card) {
		this.MGR_card = MGR_card;
	}

	public String getMGR_room() {
		return MGR_room;
	}

	public void setMGR_room(String MGR_room) {
		this.MGR_room = MGR_room;
	}

	public String getMGR_time() {
		return MGR_time;
	}

	public void setMGR_time(String MGR_time) {
		this.MGR_time = MGR_time;
	}

	public String getMGR_type() {
		return MGR_type;
	}

	public void setMGR_type(String MGR_type) {
		this.MGR_type = MGR_type;
	}
}
