package com.mgr.action;

import com.mgr.dto.*;
import com.mgr.service.MGR_RegCallBack;
import com.sun.jna.Library;

//java
public interface JnaLibrary extends Library {


	//客户端初始化，只调用一次 regInfo：回调设置
	int MGR_InitClient(MGR_RegCallBack regInfo);

	//关闭客户端
	void MGR_FreeClient();

	//连接服务端，可多次调用，server ：服务端信息 部分信息需用户复制，其余信息由内部补充
	int MGR_ConnectServer(MGR_ServerInfo server);

	//断开服务端，server：需要断开的服务端信息
	void MGR_UnLinkServer(MGR_ServerInfo server);

	//发送连接心跳，server：发送服务端对象，由状态回调返回结果，用户自行决定心跳间隔
	int MGR_SendHeartBeat(MGR_ServerInfo server);

	//客户端请求卡片备份，备份信息由回调返回
	int MGR_SendReqCardBackup(MGR_ServerInfo server);

	//客户端应答服务端卡片备份，faillist：用户处理备份信息失败的列表，无失败则为空
	int MGR_SendRspCardBackup(MGR_ServerInfo server, MGR_FailListInfo failList);

	//客户端请求人脸备份，备份信息由回调返回
	int MGR_SendReqFaceBackup(MGR_ServerInfo server);

	//客户端应答服务端人脸备份，结果有回调 faillist：用户处理备份信息失败的列表，无失败则为空
	int MGR_SendRspFaceBackup(MGR_ServerInfo server, MGR_FailListInfo failList);

	//客户端请求卡片同步，结果有回调 cardList：同步的卡片信息列表
	int MGR_SendReqCardSync(MGR_ServerInfo server, MGR_CardListInfo cardList);

	//客户端应答服务端的卡片同步请求，结果有回调 cardList：同步的卡片信息列表
	int MGR_SendRspCardSync(MGR_ServerInfo server, MGR_CardListInfo cardList);

	//客户端请求人脸同步，结果有回调 cardList：同步的人脸信息列表
	int MGR_SendReqFaceSync(MGR_ServerInfo server, MGR_FaceListInfo faceList);

	//客户端应答服务端的人脸同步请求，结果有回调 cardList：同步的人脸信息列表
	int MGR_SendRspFaceSync(MGR_ServerInfo server, MGR_FaceListInfo faceList);

	//客户端发送图片注册人脸， 结果有回调 regFace：人脸信息
	int MGR_SendReqRegFace(MGR_ServerInfo server, MGR_RegFaceInfo regFace);

	//客户端删除人脸数据，结果有回调 delFace：需要删除的人脸信息
	int MGR_SendReqDelFace(MGR_ServerInfo server, MGR_DelFaceInfo delFace);

	//获取服务端的开门记录，server：服务端，结果由回调返回，部分服务端可能不返回
	int MGR_SendReqUnlockRecord(MGR_ServerInfo server);

}