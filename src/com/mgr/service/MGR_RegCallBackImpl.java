package com.mgr.service;

import com.mgr.dto.*;

/**
 * create :fanghaoyi
 * date: 2020/5/22
 * describe: 描述
 */
public class MGR_RegCallBackImpl implements MGR_RegCallBack{
	@Override
	public void MGR_LinkStatusCB(MGR_ServerInfo server, int status) {

	}

	@Override
	public void MGR_CardBackupCB(MGR_ServerInfo server, int rsp, MGR_CardListInfo cardList) {

	}

	@Override
	public void MGR_FaceBackupCB(MGR_ServerInfo server, int rsp, MGR_FaceListInfo faceList) {

	}

	@Override
	public void MGR_CardSyncCB(MGR_ServerInfo server, int rsp, MGR_FailListInfo failList) {

	}

	@Override
	public void MGR_FaceSyncCB(MGR_ServerInfo server, int rsp, int result) {

	}

	@Override
	public void MGR_DelFaceCB(MGR_ServerInfo server, int result) {

	}

	@Override
	public void MGR_RegFaceCB(MGR_ServerInfo server, MGR_FaceInfo faceinfo, int result) {

	}

	@Override
	public void MGR_UnlockRecordCB(MGR_ServerInfo server, MGR_RecordListInfo recordList) {

	}
}
