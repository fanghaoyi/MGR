package com.mgr.dto;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;

import java.util.ArrayList;
import java.util.List;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 新建服务器信息
 */
public class MGR_ServerInfo extends Structure {

	@Override
	protected List getFieldOrder() {
		List<String> Field = new ArrayList<String>();
		Field.add("MGR_serverOnline");
		Field.add("MGR_serverSock");
		Field.add("MGR_serverIpAddr");
		Field.add("MGR_serverDoorCode");
		return Field;
	}

	public static class ByReference extends MGR_ServerInfo implements Structure.ByReference{
	}

	public static class ByValue extends MGR_ServerInfo implements Structure.ByValue{
	}

	/*服务器状态信息，请根据状态回调的参数进行更新*/
	public IntByReference MGR_serverOnline;

	/*服务器连接的socket通道号，用户不可修改*/
	public IntByReference MGR_serverSock;

	/*服务器IP地址，用户自行填充*/
	public Pointer MGR_serverIpAddr;

	/*服务器地址码，用户根据配置表自行填充。例如2010101010101*/
	public Pointer MGR_serverDoorCode;

	/*以下参数为连接内部调用参数，用户无需理会*/
	/*MGR_ThreadInfo MGR_MsgThread;
	MGR_CardRecvInfo MGR_cardRecvInfo;
	MGR_FaceRecvInfo MGR_faceRecvInfo;
	MGR_RecordRecvInfo MGR_recordRecvInfo;*/

	public IntByReference getMGR_serverOnline() {
		return MGR_serverOnline;
	}

	public void setMGR_serverOnline(IntByReference MGR_serverOnline) {
		this.MGR_serverOnline = MGR_serverOnline;
	}

	public IntByReference getMGR_serverSock() {
		return MGR_serverSock;
	}

	public void setMGR_serverSock(IntByReference MGR_serverSock) {
		this.MGR_serverSock = MGR_serverSock;
	}

	public Pointer getMGR_serverIpAddr() {
		return MGR_serverIpAddr;
	}

	public void setMGR_serverIpAddr(Pointer MGR_serverIpAddr) {
		this.MGR_serverIpAddr = MGR_serverIpAddr;
	}

	public Pointer getMGR_serverDoorCode() {
		return MGR_serverDoorCode;
	}

	public void setMGR_serverDoorCode(Pointer MGR_serverDoorCode) {
		this.MGR_serverDoorCode = MGR_serverDoorCode;
	}



/*
	public MGR_ThreadInfo getMGR_MsgThread() {
		return MGR_MsgThread;
	}

	public void setMGR_MsgThread(MGR_ThreadInfo MGR_MsgThread) {
		this.MGR_MsgThread = MGR_MsgThread;
	}

	public MGR_CardRecvInfo getMGR_cardRecvInfo() {
		return MGR_cardRecvInfo;
	}

	public void setMGR_cardRecvInfo(MGR_CardRecvInfo MGR_cardRecvInfo) {
		this.MGR_cardRecvInfo = MGR_cardRecvInfo;
	}

	public MGR_FaceRecvInfo getMGR_faceRecvInfo() {
		return MGR_faceRecvInfo;
	}

	public void setMGR_faceRecvInfo(MGR_FaceRecvInfo MGR_faceRecvInfo) {
		this.MGR_faceRecvInfo = MGR_faceRecvInfo;
	}

	public MGR_RecordRecvInfo getMGR_recordRecvInfo() {
		return MGR_recordRecvInfo;
	}

	public void setMGR_recordRecvInfo(MGR_RecordRecvInfo MGR_recordRecvInfo) {
		this.MGR_recordRecvInfo = MGR_recordRecvInfo;
	}*/
}
