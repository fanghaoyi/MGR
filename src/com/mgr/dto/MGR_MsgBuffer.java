package com.mgr.dto;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 新建连接服务端时私有资源信息，用户无需理会
 */
public class MGR_MsgBuffer extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_recvAllLength");
		Field.add("MGR_recvBuffer");
		Field.add("MGR_recvAllData");
		return Field;
	}

	public static class ByReference extends MGR_MsgBuffer implements Structure.ByReference{
	}

	public static class ByValue extends MGR_MsgBuffer implements Structure.ByValue{
	}

	int MGR_recvAllLength;

	String MGR_recvBuffer;

	String MGR_recvAllData;

	public int getMGR_recvAllLength() {
		return MGR_recvAllLength;
	}

	public void setMGR_recvAllLength(int MGR_recvAllLength) {
		this.MGR_recvAllLength = MGR_recvAllLength;
	}

	public String getMGR_recvBuffer() {
		return MGR_recvBuffer;
	}

	public void setMGR_recvBuffer(String MGR_recvBuffer) {
		this.MGR_recvBuffer = MGR_recvBuffer;
	}

	public String getMGR_recvAllData() {
		return MGR_recvAllData;
	}

	public void setMGR_recvAllData(String MGR_recvAllData) {
		this.MGR_recvAllData = MGR_recvAllData;
	}
}
