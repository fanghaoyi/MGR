package com.mgr;


import com.mgr.action.JnaLibrary;
import com.mgr.dto.*;
import com.mgr.service.MGR_RegCallBack;
import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.ShortByReference;

public class MGRClient {

	public static void main(String[] args) {

		MGRClient.MGR_FreeClient();
	}



	public static JnaLibrary lib=null;
	static {
		lib = (JnaLibrary) Native.loadLibrary("MGR_1.0.5", JnaLibrary.class);

	}


	//客户端初始化，只调用一次 regInfo：回调设置
	public static void MGR_InitClient(){
		MGR_RegCallBack cb= new MGR_RegCallBack() {
			@Override
			public void MGR_LinkStatusCB(MGR_ServerInfo server, int status) {
				System.out.println("status====="+status);
			}

			@Override
			public void MGR_CardBackupCB(MGR_ServerInfo server, int rsp, MGR_CardListInfo cardList) {
				System.out.println("rsp====="+rsp);
			}

			@Override
			public void MGR_FaceBackupCB(MGR_ServerInfo server, int rsp, MGR_FaceListInfo faceList) {
				System.out.println("rsp====="+rsp);
			}

			@Override
			public void MGR_CardSyncCB(MGR_ServerInfo server, int rsp, MGR_FailListInfo failList) {
				System.out.println("rsp====="+rsp);
			}

			@Override
			public void MGR_FaceSyncCB(MGR_ServerInfo server, int rsp, int result) {
				System.out.println("result====="+result);
			}

			@Override
			public void MGR_DelFaceCB(MGR_ServerInfo server, int result) {
				System.out.println("result====="+result);
			}

			@Override
			public void MGR_RegFaceCB(MGR_ServerInfo server, MGR_FaceInfo faceinfo, int result) {
				System.out.println("result====="+result);
			}

			@Override
			public void MGR_UnlockRecordCB(MGR_ServerInfo server, MGR_RecordListInfo recordList) {
				System.out.println("status=====success");
			}

			@Override
			public void MGR_GetQRcodeCB(MGR_ServerInfo server, int result, char qrcode) {
				System.out.println("status====="+result);
			}
		};
		int re1 = lib.MGR_InitClient(cb);
	}

	//关闭客户端
	public static void MGR_FreeClient(){
		lib.MGR_FreeClient();
	}

	//连接服务端，可多次调用，server ：服务端信息 部分信息需用户复制，其余信息由内部补充
	public static void MGR_ConnectServer(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);
		int connectServer= lib.MGR_ConnectServer(mgr_serverInfo);
	}

	//断开服务端，server：需要断开的服务端信息
	public static void MGR_UnLinkServer(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);
		lib.MGR_UnLinkServer(mgr_serverInfo);
	}

	//发送连接心跳，server：发送服务端对象，由状态回调返回结果，用户自行决定心跳间隔
	public static void MGR_SendHeartBeat(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);
		int sendHeartBeatStatus= lib.MGR_SendHeartBeat(mgr_serverInfo);
	}

	//客户端请求卡片备份，备份信息由回调返回
	public static void MGR_SendReqCardBackup(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);
		int sendReqCardBackupStatus= lib.MGR_SendReqCardBackup(mgr_serverInfo);
	}

	//客户端应答服务端卡片备份，faillist：用户处理备份信息失败的列表，无失败则为空
	public static void MGR_SendRspCardBackup(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);
		MGR_FailListInfo sendRspCardBackupRes=new MGR_FailListInfo();
		sendRspCardBackupRes.setMGR_failCount(new IntByReference(1));
		MGR_FailNodeInfo sendRspFaceBackupRes2=new MGR_FailNodeInfo();
		sendRspCardBackupRes.setMGR_failList(sendRspFaceBackupRes2);
		int sendRspCardBackupStatus= lib.MGR_SendRspCardBackup(mgr_serverInfo,sendRspCardBackupRes);
	}

	//客户端请求人脸备份，备份信息由回调返回
	public static void MGR_SendReqFaceBackup(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);
		int sendReqFaceBackupStatus= lib.MGR_SendReqFaceBackup(mgr_serverInfo);
	}

	//客户端请求人脸备份，备份信息由回调返回
	public static void sendRspFaceBackupRes(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);

		MGR_FailListInfo sendRspFaceBackupRes=new MGR_FailListInfo();
		sendRspFaceBackupRes.setMGR_failCount(new IntByReference(1));
		MGR_FailNodeInfo sendRspFaceBackupRes2=new MGR_FailNodeInfo();
		sendRspFaceBackupRes.setMGR_failList(sendRspFaceBackupRes2);

		int sendRspFaceBackupStatus= lib.MGR_SendRspFaceBackup(mgr_serverInfo,sendRspFaceBackupRes);
	}

	//客户端请求卡片同步，结果有回调 cardList：同步的卡片信息列表
	public static void MGR_SendReqCardSync(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);

		MGR_CardListInfo sendReqCardSyncRes=new MGR_CardListInfo();
		int sendReqCardSyncStatus= lib.MGR_SendReqCardSync(mgr_serverInfo,sendReqCardSyncRes);
	}

	//客户端应答服务端的卡片同步请求，结果有回调 cardList：同步的卡片信息列表
	public static void MGR_SendRspCardSync(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);

		MGR_CardListInfo sendRspCardSyncRes=new MGR_CardListInfo();
		int sendRspCardSyncStatus= lib.MGR_SendRspCardSync(mgr_serverInfo,sendRspCardSyncRes);
	}

	//客户端请求人脸同步，结果有回调 cardList：同步的人脸信息列表
	public static void MGR_SendReqFaceSync(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);

		MGR_FaceListInfo sendReqFaceSyncRes=new MGR_FaceListInfo();
		int sendReqFaceSyncStatus= lib.MGR_SendReqFaceSync(mgr_serverInfo,sendReqFaceSyncRes);
	}

	//客户端应答服务端的人脸同步请求，结果有回调 cardList：同步的人脸信息列表
	public static void MGR_SendRspFaceSync(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);

		MGR_FaceListInfo sendRspFaceSyncRes=new MGR_FaceListInfo();
		int sendRspFaceSyncStatus= lib.MGR_SendRspFaceSync(mgr_serverInfo,sendRspFaceSyncRes);
	}

	//客户端发送图片注册人脸， 结果有回调 regFace：人脸信息
	public static void MGR_SendReqRegFace(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);

		MGR_RegFaceInfo sendReqRegFaceRes=new MGR_RegFaceInfo();
		Pointer a1 = new Memory(32);
		a1.setString(0, "abdcdwcawqabdcdwcawqabdccawqwe");
		sendReqRegFaceRes.setMGR_info(a1);
		Pointer a2 = new Memory(32);
		a2.setString(0, "abdcdwcawqabdcdwcawqacdwcawqwe");
		sendReqRegFaceRes.setMGR_room(a2);
		Pointer a3 = new Memory(32);
		a3.setString(0, "abdcdwcawqabdcdwcawqacdwcawqwe");
		sendReqRegFaceRes.setMGR_name(a3);
		Pointer a4 = new Memory(32);
		a4.setString(0, "abdcdwcawqabdcdwcawqacdwcawqwe");
		sendReqRegFaceRes.setMGR_jpegName(a4);
		Pointer a5 = new Memory(32);
		a5.setString(0, "abdcdwcawqabdcdwcaabdcdwcawqwe");
		sendReqRegFaceRes.setMGR_jpegData(a5);
		sendReqRegFaceRes.setMGR_jpegDataLen(new IntByReference(1));
		int sendReqRegFaceStatus= lib.MGR_SendReqRegFace(mgr_serverInfo,sendReqRegFaceRes);
	}

	//客户端删除人脸数据，结果有回调 delFace：需要删除的人脸信息
	public static void MGR_SendReqDelFace(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);

		MGR_DelFaceInfo sendReqDelFaceRes=new MGR_DelFaceInfo();
		int sendReqDelFaceStatus= lib.MGR_SendReqDelFace(mgr_serverInfo,sendReqDelFaceRes);
	}

	//获取服务端的开门记录，server：服务端，结果由回调返回，部分服务端可能不返回
	public static void MGR_SendReqUnlockRecord(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);

		int sendReqUnlockRecordStatus= lib.MGR_SendReqUnlockRecord(mgr_serverInfo);
	}

	//获取开门二维码，server：服务端，结果由回调返回
	public static void MGR_SendReqGetQRcode(){
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		mgr_serverInfo.setMGR_serverOnline(new IntByReference(1));
		mgr_serverInfo.setMGR_serverSock(new IntByReference(1));

		Pointer p1 = new Memory(16);
		p1.setString(0, "192.168.1.101");
		mgr_serverInfo.setMGR_serverIpAddr(p1);

		Pointer p2 = new Memory(16);
		p2.setString(0, "2010101010101");
		mgr_serverInfo.setMGR_serverDoorCode(p2);

		MGR_GetQRcodeInfo sendReqGetQRcodeRes=new MGR_GetQRcodeInfo();
		int sendReqGetQRcodeStatus= lib.MGR_SendReqGetQRcode(mgr_serverInfo,sendReqGetQRcodeRes);
	}



}
