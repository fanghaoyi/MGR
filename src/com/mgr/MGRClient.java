package com.mgr;


import com.mgr.action.JnaLibrary;
import com.mgr.dto.*;
import com.mgr.service.MGR_RegCallBack;
import com.sun.jna.Native;

public class MGRClient {
	public static void main(String[] args) {

		JnaLibrary lib = (JnaLibrary) Native.loadLibrary("MGR_1.0.2", JnaLibrary.class);


		//客户端初始化，只调用一次 regInfo：回调设置
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


		/*
		//关闭客户端
		lib.MGR_FreeClient();*/

		/*//连接服务端，可多次调用，server ：服务端信息 部分信息需用户复制，其余信息由内部补充
		MGR_ServerInfo mgr_serverInfo=new MGR_ServerInfo();
		int c= lib.MGR_ConnectServer(mgr_serverInfo);*/




	}
}
