#ifndef __MGR_CLIENT_H_
#define __MGR_CLIENT_H_

#include <winsock2.h>
#include <windows.h>
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

#if !defined(DLL_EXPORT) && !defined(DLL_IMPORT)
#define DLL_EXPORT
#endif

#ifdef DLL_EXPORT
#define DLL_API __declspec(dllexport)  __stdcall
#else
#define DLL_API __declspec(dllimport)  __stdcall
#endif // DLL_EXPORT

#ifdef __cplusplus 
extern "C" 
{
#endif

/*�ͻ��������˹���״̬*/
/*�ɹ�*/
#define MGR_SUCCESS         1
/*ʧ��*/
#define MGR_ERROR          -1 
/*���ӶϿ�*/
#define MGR_LINK_OFF       -2
/*��������*/
#define MGR_LINK_ON         2

#pragma pack(1)

/*����ע����Ϣ��ע��ʱ��Ҫ����ע�ῨƬ*/
typedef struct MGR_RegFaceInfo{
    /*������Ϣ���û��Զ���*/
    char MGR_info[32];
    /*��ע�ῨƬ�󶨵ķ����*/
    char MGR_room[32];
    /*��ע�ῨƬ���ţ�������ͨ�Ž����ţ����֤��*/
    char MGR_name[32];
    /*��Ҫע�������ͼƬ���֣�Ŀǰ�޶�JPG��ʽ*/
    char MGR_jpegName[32];
    /*����ͼƬ������*/
    char * MGR_jpegData;
    /*����ͼƬ���ݵĳ���*/
    int MGR_jpegDataLen;
}MGR_RegFaceInfo;

/*����ɾ����Ϣ��ɾ��ʱ�����󶨵Ŀ���*/
typedef struct MGR_DelFaceInfo{
    /*�������ĵ�ַ���룬����2010101010101*/
    char MGR_gpid[32];
    /*����ע��ʱ�󶨵Ŀ���*/
    char MGR_name[32];  
}MGR_DelFaceInfo;

/*������Ϣ*/
typedef struct MGR_FaceInfo{
    /*������Ϣ�ڲ���־λ���û��������*/
    int MGR_isDelete, MGR_isModify;
    /*������Ϣ���û��Զ���*/
    char MGR_info[32];
    /*�������ڷ������ĵ�ַ���룬����2010101010101*/
    char MGR_gpid[32];
    /*����ע��ʱ�󶨵Ŀ���*/
    char MGR_name[32];
    /*����ͨ���㷨ע��������ֵ*/
    char * MGR_feature;
    /*��������ֵ����*/
    int MGR_featureLen;
}MGR_FaceInfo;

/*��Ƭ��Ϣ*/
typedef struct MGR_CardInfo{
    /*���ţ�������ͨ�Ž����Ŀ��ź����֤��*/
    char MGR_card[32];
    /*ע�ῨƬʱ�󶨵ķ����*/
    char MGR_room[32];
    /*ע�ῨƬʱ��ʱ�䣬�ɺ���*/
    char MGR_time[32];
    /*ע�ῨƬʱ�����ͣ��̶�Ϊcard*/
    char MGR_type[32];
}MGR_CardInfo;

/*������Ϣ����*/
typedef struct MGR_FaceListInfo{
    /*������Ϣ����*/
    int MGR_faceCount;
    /*������Ϣ�����û�ʹ��ʱ��������ռ�*/
    MGR_FaceInfo ** MGR_faceList;
}MGR_FaceListInfo;

/*��Ƭ����*/
typedef struct MGR_CardListInfo{
    /*��Ƭ����*/
    int MGR_cardCount;
    /*��Ƭ�б��û�ʹ��ʱ��������ռ�*/
    MGR_CardInfo ** MGR_cardList;
}MGR_CardListInfo;

/*����ʧ��ʱ�����������߿�Ƭ����Ϣ*/
typedef struct MGR_FailNodeInfo{
    /*����Ϊ��Ƭ��0-cardNum 1-roomNum ����Ϊ������0-cardNum 1-groupId*/
    char MGR_attrName[2][32];
    /*ʧ��ԭ���û��ɺ����ж����ͣ�С��0 ��ʧ��*/
    char MGR_reason;
}MGR_FailNodeInfo;

/*����ʧ�ܶ����λ��Ϣ*/
typedef struct MGR_FailListInfo{
    /*ʧ����Ϣ�ĸ���*/
    int MGR_failCount;
    /*ʧ����Ϣ��λ�б��û�ʹ��ʱ��������ռ�*/
    MGR_FailNodeInfo ** MGR_failList;
}MGR_FailListInfo;

/*���ż�¼�ṹ��*/
typedef struct MGR_UnlockRecordInfo{
    /*���ŵ����⣬���ţ�������Զ���˺ŵ�*/
    char user[32];
    /*���ŵ��û�����*/
    char room[32];
    /*���ŵ�ʱ��*/
    char time[32];
}MGR_UnlockRecordInfo;

/*���ż�¼����*/
typedef struct MGR_RecordListInfo{
    /*���ż�¼����*/
    int MGR_recordCount;
    /*���ż�¼����*/
    MGR_UnlockRecordInfo ** MGR_recordList;
}MGR_RecordListInfo;

/*��ȡ��ά��ʱ����Ϣ*/
typedef struct MGR_GetQRcodeInfo{
    /*���ô�����1-255*/
    int MGR_vaildCount;
    /*����ʱ�䣬 ��λСʱ��1 - 255H*/
    int MGR_vaildTime;
    /*��ά�������û�����*/
    char MGR_userRoom[16];
}MGR_GetQRcodeInfo;


/*�������½����ӷ����ʱ˽����Դ��Ϣ���û��������*/
typedef struct MGR_ThreadInfo{
    int MGR_threadAble;
    pthread_t MGR_threadId;
    pthread_mutex_t MGR_Mutex;
}MGR_ThreadInfo;

typedef struct MGR_MsgBuffer{
    int MGR_recvAllLength;
    char * MGR_recvBuffer;
    char * MGR_recvAllData;
}MGR_MsgBuffer;

typedef struct MGR_CardRecvInfo{
    int MGR_recvCount;
    int MGR_recvStart;
    MGR_CardListInfo MGR_cardList;
}MGR_CardRecvInfo;

typedef struct MGR_FaceRecvInfo{
    int MGR_recvCount;
    int MGR_recvStart;
    MGR_FaceListInfo MGR_faceList;
}MGR_FaceRecvInfo;

typedef struct MGR_RecordRecvInfo{
    int MGR_recvCount;
    int MGR_recvStart;
    MGR_RecordListInfo MGR_recordList;
}MGR_RecordRecvInfo;

/*�������½����ӷ����ʱ˽����Դ��Ϣ���û��������*/

/*�½���������Ϣ*/
typedef struct MGR_ServerInfo{
    /*������״̬��Ϣ�������״̬�ص��Ĳ������и���*/
    int MGR_serverOnline;
    /*���������ӵ�socketͨ���ţ��û������޸�*/
    int MGR_serverSock;  
    /*������IP��ַ���û��������*/
    char MGR_serverIpAddr[16];
    /*��������ַ�룬�û��������ñ�������䡣����2010101010101*/
    char MGR_serverDoorCode[16];
    /*���²���Ϊ�����ڲ����ò������û��������*/
    MGR_ThreadInfo MGR_MsgThread;
    MGR_CardRecvInfo MGR_cardRecvInfo;
    MGR_FaceRecvInfo MGR_faceRecvInfo;
    MGR_RecordRecvInfo MGR_recordRecvInfo;
}MGR_ServerInfo;

/*�ͻ��˳�ʼ��ʱע��Ļص���Ϣ��������ֵ������ΪNULL*/
typedef struct MGR_RegCallBack{
    /*�ͻ��������˹���״̬�ص�*//*server���������Ϣ status������״̬*/
    void (*MGR_LinkStatusCB)(MGR_ServerInfo * server, int status);
    /*���ݿ�Ƭ����Ľ���ص�*//*server���������Ϣ cardList�����ݿ�Ƭ��Ϣ������ rsp���Ƿ���Ҫ�ذ���־*/
    void (*MGR_CardBackupCB)(MGR_ServerInfo * server, int rsp, MGR_CardListInfo * cardList);
    /*������������Ľ���ص�*//*server���������Ϣ faceList������������Ϣ������ rsp���Ƿ���Ҫ�ذ���־*/
    void (*MGR_FaceBackupCB)(MGR_ServerInfo * server, int rsp, MGR_FaceListInfo * faceList);
    /*ͬ����Ƭ����Ľ���ص�*//*server���������Ϣ faceList��ͬ��ʧ����Ϣ������ rsp���Ƿ���Ҫ�ذ���־*/
    void (*MGR_CardSyncCB)(MGR_ServerInfo * server, int rsp, MGR_FailListInfo * failList);
    /*ͬ����������Ľ���ص�*//*server���������Ϣ result��ͬ�������0-�ɹ� rsp���Ƿ���Ҫ�ذ���־*/
    void (*MGR_FaceSyncCB)(MGR_ServerInfo * server, int rsp, int result); 
    /*ɾ���������ݵĽ���ص�*//*result��0Ϊ�ɹ�*/
    void (*MGR_DelFaceCB)(MGR_ServerInfo * server,int result); 
    /*ע����������ص�*//* faceinfo:ע��󷵻ص���Ϣ��ʧ��Ϊ�գ� result��0Ϊ�ɹ�*/
    void (*MGR_RegFaceCB)(MGR_ServerInfo * server, MGR_FaceInfo * faceinfo, int result); 
    /*��ȡ���ż�¼����ص�*//*recordinfo ���ż�¼�ṹ�壬��Ϊ��*/
    void (*MGR_UnlockRecordCB)(MGR_ServerInfo * server, MGR_RecordListInfo * recordList); 
    /*��ȡ���ż�¼����ص�*//*result ���Ϊ0�ɹ���-1Ϊʱ�䲻��ȷ��qrcodeΪ��ά���ִ�����ͼƬ���ݣ��û��������ɶ�ά�룩��ʧ��Ϊ��*/
    void (*MGR_GetQRcodeCB)(MGR_ServerInfo * server, int result, char * qrcode); 
}MGR_RegCallBack;

#pragma pack()
/*�ͻ��˳�ʼ����ֻ����һ�� regInfo���ص�����*/
DLL_API int MGR_InitClient(MGR_RegCallBack * regInfo);
/*�رտͻ���*/
DLL_API void MGR_FreeClient();
/*���ӷ���ˣ��ɶ�ε��ã�server ���������Ϣ ������Ϣ���û����ƣ�������Ϣ���ڲ�����*/
DLL_API int MGR_ConnectServer(MGR_ServerInfo * server);
/*�Ͽ�����ˣ�server����Ҫ�Ͽ��ķ������Ϣ*/
DLL_API void MGR_UnLinkServer(MGR_ServerInfo * server);
/*��������������server�����ͷ���˶�����״̬�ص����ؽ�����û����о����������*/
DLL_API int MGR_SendHeartBeat(MGR_ServerInfo * server);
/*�ͻ�������Ƭ���ݣ�������Ϣ�ɻص�����*/
DLL_API int MGR_SendReqCardBackup(MGR_ServerInfo * server);
/*�ͻ���Ӧ�����˿�Ƭ���ݣ�faillist���û���������Ϣʧ�ܵ��б���ʧ����Ϊ��*/
DLL_API int MGR_SendRspCardBackup(MGR_ServerInfo * server, MGR_FailListInfo * failList);
/*�ͻ��������������ݣ�������Ϣ�ɻص�����*/
DLL_API int MGR_SendReqFaceBackup(MGR_ServerInfo * server);
/*�ͻ���Ӧ�������������ݣ�����лص� faillist���û���������Ϣʧ�ܵ��б���ʧ����Ϊ��*/
DLL_API int MGR_SendRspFaceBackup(MGR_ServerInfo * server, MGR_FailListInfo * failList);
/*�ͻ�������Ƭͬ��������лص� cardList��ͬ���Ŀ�Ƭ��Ϣ�б�*/
DLL_API int MGR_SendReqCardSync(MGR_ServerInfo * server, MGR_CardListInfo * cardList);
/*�ͻ���Ӧ�����˵Ŀ�Ƭͬ�����󣬽���лص� cardList��ͬ���Ŀ�Ƭ��Ϣ�б�*/
DLL_API int MGR_SendRspCardSync(MGR_ServerInfo * server, MGR_CardListInfo * cardList);
/*�ͻ�����������ͬ��������лص� cardList��ͬ����������Ϣ�б�*/
DLL_API int MGR_SendReqFaceSync(MGR_ServerInfo * server, MGR_FaceListInfo * faceList);
/*�ͻ���Ӧ�����˵�����ͬ�����󣬽���лص� cardList��ͬ����������Ϣ�б�*/
DLL_API int MGR_SendRspFaceSync(MGR_ServerInfo * server, MGR_FaceListInfo * faceList);
/*�ͻ��˷���ͼƬע�������� ����лص� regFace��������Ϣ*/
DLL_API int MGR_SendReqRegFace(MGR_ServerInfo * server, MGR_RegFaceInfo * regFace);
/*�ͻ���ɾ���������ݣ�����лص� delFace����Ҫɾ����������Ϣ*/
DLL_API int MGR_SendReqDelFace(MGR_ServerInfo * server, MGR_DelFaceInfo * delFace);

/*��ȡ����˵Ŀ��ż�¼��server������ˣ�����ɻص����أ����ַ���˿��ܲ�����*/
DLL_API int MGR_SendReqUnlockRecord(MGR_ServerInfo * server);

/*��ȡ���Ŷ�ά�룬server������ˣ�����ɻص�����*/
DLL_API int MGR_SendReqGetQRcode(MGR_ServerInfo * server, MGR_GetQRcodeInfo * getQRcode);

#ifdef __cplusplus  
}
#endif
#endif

