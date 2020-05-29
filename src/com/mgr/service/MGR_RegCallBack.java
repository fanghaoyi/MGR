package com.mgr.service;

import com.mgr.dto.*;
import com.sun.jna.Callback;

public interface MGR_RegCallBack extends Callback {

	/*客户端与服务端工作状态回调*//*server：服务端信息 status：工作状态*/
    void MGR_LinkStatusCB(MGR_ServerInfo server, int status);

	/*备份卡片请求的结果回调*//*server：服务端信息 cardList：备份卡片信息的链表 rsp：是否需要回包标志*/
    void MGR_CardBackupCB(MGR_ServerInfo server, int rsp, MGR_CardListInfo cardList);

	/*备份人脸请求的结果回调*//*server：服务端信息 faceList：备份人脸信息的链表 rsp：是否需要回包标志*/
    void MGR_FaceBackupCB(MGR_ServerInfo server, int rsp, MGR_FaceListInfo faceList);

	/*同步卡片请求的结果回调*//*server：服务端信息 faceList：同步失败信息的链表 rsp：是否需要回包标志*/
    void MGR_CardSyncCB(MGR_ServerInfo server, int rsp, MGR_FailListInfo failList);

	/*同步人脸请求的结果回调*//*server：服务端信息 result：同步结果，0-成功 rsp：是否需要回包标志*/
    void MGR_FaceSyncCB(MGR_ServerInfo server, int rsp, int result);

	/*删除人脸数据的结果回调*//*result：0为成功*/
    void MGR_DelFaceCB(MGR_ServerInfo server, int result);

	/*注册人脸结果回调*//* faceinfo:注册后返回的信息，失败为空， result：0为成功*/
    void MGR_RegFaceCB(MGR_ServerInfo server, MGR_FaceInfo faceinfo, int result);

	/*获取开门记录结果回调*//*recordinfo 开门记录结构体，无为空*/
    void MGR_UnlockRecordCB(MGR_ServerInfo server, MGR_RecordListInfo recordList);


}
