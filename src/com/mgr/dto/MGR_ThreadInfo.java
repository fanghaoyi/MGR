package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 以下是新建连接服务端时私有资源信息，用户无需理会
 */
public class MGR_ThreadInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_threadAble");
		Field.add("MGR_threadId");
		Field.add("MGR_Mutex");
		return Field;
	}

	public static class ByReference extends MGR_ThreadInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_ThreadInfo implements Structure.ByValue{
	}

	int MGR_threadAble;

	String MGR_threadId;

	String MGR_Mutex;

	public int getMGR_threadAble() {
		return MGR_threadAble;
	}

	public void setMGR_threadAble(int MGR_threadAble) {
		this.MGR_threadAble = MGR_threadAble;
	}

	public String getMGR_threadId() {
		return MGR_threadId;
	}

	public void setMGR_threadId(String MGR_threadId) {
		this.MGR_threadId = MGR_threadId;
	}

	public String getMGR_Mutex() {
		return MGR_Mutex;
	}

	public void setMGR_Mutex(String MGR_Mutex) {
		this.MGR_Mutex = MGR_Mutex;
	}
}
