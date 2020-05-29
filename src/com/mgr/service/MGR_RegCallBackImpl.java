package com.mgr.service;

import com.mgr.dto.*;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 描述
 */
public class MGR_RegCallBackImpl{

	public MGR_RegCallBack mgr_regCallBack;//定义一个驱动接口。
	MGR_RegCallBackImpl(MGR_RegCallBack mgr_regCallBack){
		this.mgr_regCallBack = mgr_regCallBack;
	}

	MGR_RegCallBackImpl(){

	}

	public void MGR_LinkStatusCB(MGR_ServerInfo server, int status) {
		mgr_regCallBack.MGR_LinkStatusCB(server,status);
		System.out.println("MGR_LinkStatusCB=================>success");
	}

	public void MGR_CardBackupCB(MGR_ServerInfo server, int rsp, MGR_CardListInfo cardList) {
		mgr_regCallBack.MGR_CardBackupCB(server,rsp,cardList);
		System.out.println("MGR_CardBackupCB=================>success");
	}

	public void MGR_FaceBackupCB(MGR_ServerInfo server, int rsp, MGR_FaceListInfo faceList) {
		mgr_regCallBack.MGR_FaceBackupCB(server,rsp,faceList);
		System.out.println("MGR_FaceBackupCB=================>success");
	}

	public void MGR_CardSyncCB(MGR_ServerInfo server, int rsp, MGR_FailListInfo failList) {
		mgr_regCallBack.MGR_CardSyncCB(server,rsp,failList);
		System.out.println("MGR_CardSyncCB=================>success");
	}

	public void MGR_FaceSyncCB(MGR_ServerInfo server, int rsp, int result) {
		mgr_regCallBack.MGR_FaceSyncCB(server,rsp,result);
		System.out.println("MGR_FaceSyncCB=================>success");
	}

	public void MGR_DelFaceCB(MGR_ServerInfo server, int result) {
		mgr_regCallBack.MGR_DelFaceCB(server,result);
		System.out.println("MGR_DelFaceCB=================>success");
	}

	public void MGR_RegFaceCB(MGR_ServerInfo server, MGR_FaceInfo faceinfo, int result) {
		mgr_regCallBack.MGR_RegFaceCB(server,faceinfo,result);
		System.out.println("MGR_LinkStatusCB=================>success");
	}

	public void MGR_UnlockRecordCB(MGR_ServerInfo server, MGR_RecordListInfo recordList) {
		mgr_regCallBack.MGR_UnlockRecordCB(server,recordList);
		System.out.println("MGR_LinkStatusCB=================>success");
	}

	public void MGR_GetQRcodeCB(MGR_ServerInfo server, int result, char qrcode) {
		mgr_regCallBack.MGR_GetQRcodeCB(server,result,qrcode);
		System.out.println("MGR_GetQRcodeCB=================>success");
	}
}
