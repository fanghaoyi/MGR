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

/*客户端与服务端工作状态*/
/*成功*/
#define MGR_SUCCESS         1
/*失败*/
#define MGR_ERROR          -1 
/*连接断开*/
#define MGR_LINK_OFF       -2
/*连接正常*/
#define MGR_LINK_ON         2

#pragma pack(1)

/*人脸注册信息，注册时需要绑定已注册卡片*/
typedef struct MGR_RegFaceInfo{
    /*人脸信息，用户自定义*/
    char MGR_info[32];
    /*已注册卡片绑定的房间号*/
    char MGR_room[32];
    /*已注册卡片卡号，常见普通门禁卡号，身份证号*/
    char MGR_name[32];
    /*需要注册的人脸图片名字，目前限定JPG格式*/
    char MGR_jpegName[32];
    /*人脸图片的数据*/
    char * MGR_jpegData;
    /*人脸图片数据的长度*/
    int MGR_jpegDataLen;
}MGR_RegFaceInfo;

/*人脸删除信息，删除时检索绑定的卡号*/
typedef struct MGR_DelFaceInfo{
    /*服务器的地址编码，例如2010101010101*/
    char MGR_gpid[32];
    /*人脸注册时绑定的卡号*/
    char MGR_name[32];  
}MGR_DelFaceInfo;

/*人脸信息*/
typedef struct MGR_FaceInfo{
    /*人脸信息内部标志位，用户无需理会*/
    int MGR_isDelete, MGR_isModify;
    /*人脸信息，用户自定义*/
    char MGR_info[32];
    /*人脸所在服务器的地址编码，例如2010101010101*/
    char MGR_gpid[32];
    /*人脸注册时绑定的卡号*/
    char MGR_name[32];
    /*人脸通过算法注册后的特征值*/
    char * MGR_feature;
    /*人脸特征值长度*/
    int MGR_featureLen;
}MGR_FaceInfo;

/*卡片信息*/
typedef struct MGR_CardInfo{
    /*卡号，例如普通门禁卡的卡号和身份证号*/
    char MGR_card[32];
    /*注册卡片时绑定的房间号*/
    char MGR_room[32];
    /*注册卡片时的时间，可忽略*/
    char MGR_time[32];
    /*注册卡片时的类型，固定为card*/
    char MGR_type[32];
}MGR_CardInfo;

/*人脸信息链表*/
typedef struct MGR_FaceListInfo{
    /*人脸信息数量*/
    int MGR_faceCount;
    /*人脸信息链表，用户使用时自行申请空间*/
    MGR_FaceInfo ** MGR_faceList;
}MGR_FaceListInfo;

/*卡片链表*/
typedef struct MGR_CardListInfo{
    /*卡片数量*/
    int MGR_cardCount;
    /*卡片列表，用户使用时自行申请空间*/
    MGR_CardInfo ** MGR_cardList;
}MGR_CardListInfo;

/*操作失败时单个人脸或者卡片的信息*/
typedef struct MGR_FailNodeInfo{
    /*属性为卡片：0-cardNum 1-roomNum 属性为人脸：0-cardNum 1-groupId*/
    char MGR_attrName[2][32];
    /*失败原因，用户可忽略判断类型，小于0 即失败*/
    char MGR_reason;
}MGR_FailNodeInfo;

/*操作失败多个单位信息*/
typedef struct MGR_FailListInfo{
    /*失败信息的个数*/
    int MGR_failCount;
    /*失败信息单位列表，用户使用时自行申请空间*/
    MGR_FailNodeInfo ** MGR_failList;
}MGR_FailListInfo;

/*开门记录结构体*/
typedef struct MGR_UnlockRecordInfo{
    /*开门的主题，卡号，人脸，远程账号等*/
    char user[32];
    /*开门的用户房号*/
    char room[32];
    /*开门的时间*/
    char time[32];
}MGR_UnlockRecordInfo;

/*开门记录链表*/
typedef struct MGR_RecordListInfo{
    /*开门记录个数*/
    int MGR_recordCount;
    /*开门记录链表*/
    MGR_UnlockRecordInfo ** MGR_recordList;
}MGR_RecordListInfo;

/*获取二维码时的信息*/
typedef struct MGR_GetQRcodeInfo{
    /*可用次数，1-255*/
    int MGR_vaildCount;
    /*可用时间， 单位小时，1 - 255H*/
    int MGR_vaildTime;
    /*二维码所属用户房号*/
    char MGR_userRoom[16];
}MGR_GetQRcodeInfo;


/*以下是新建连接服务端时私有资源信息，用户无需理会*/
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

/*以上是新建连接服务端时私有资源信息，用户无需理会*/

/*新建服务器信息*/
typedef struct MGR_ServerInfo{
    /*服务器状态信息，请根据状态回调的参数进行更新*/
    int MGR_serverOnline;
    /*服务器连接的socket通道号，用户不可修改*/
    int MGR_serverSock;  
    /*服务器IP地址，用户自行填充*/
    char MGR_serverIpAddr[16];
    /*服务器地址码，用户根据配置表自行填充。例如2010101010101*/
    char MGR_serverDoorCode[16];
    /*以下参数为连接内部调用参数，用户无需理会*/
    MGR_ThreadInfo MGR_MsgThread;
    MGR_CardRecvInfo MGR_cardRecvInfo;
    MGR_FaceRecvInfo MGR_faceRecvInfo;
    MGR_RecordRecvInfo MGR_recordRecvInfo;
}MGR_ServerInfo;

/*客户端初始化时注册的回调信息，调用则赋值，否则为NULL*/
typedef struct MGR_RegCallBack{
    /*客户端与服务端工作状态回调*//*server：服务端信息 status：工作状态*/
    void (*MGR_LinkStatusCB)(MGR_ServerInfo * server, int status);
    /*备份卡片请求的结果回调*//*server：服务端信息 cardList：备份卡片信息的链表 rsp：是否需要回包标志*/
    void (*MGR_CardBackupCB)(MGR_ServerInfo * server, int rsp, MGR_CardListInfo * cardList);
    /*备份人脸请求的结果回调*//*server：服务端信息 faceList：备份人脸信息的链表 rsp：是否需要回包标志*/
    void (*MGR_FaceBackupCB)(MGR_ServerInfo * server, int rsp, MGR_FaceListInfo * faceList);
    /*同步卡片请求的结果回调*//*server：服务端信息 faceList：同步失败信息的链表 rsp：是否需要回包标志*/
    void (*MGR_CardSyncCB)(MGR_ServerInfo * server, int rsp, MGR_FailListInfo * failList);
    /*同步人脸请求的结果回调*//*server：服务端信息 result：同步结果，0-成功 rsp：是否需要回包标志*/
    void (*MGR_FaceSyncCB)(MGR_ServerInfo * server, int rsp, int result); 
    /*删除人脸数据的结果回调*//*result：0为成功*/
    void (*MGR_DelFaceCB)(MGR_ServerInfo * server,int result); 
    /*注册人脸结果回调*//* faceinfo:注册后返回的信息，失败为空， result：0为成功*/
    void (*MGR_RegFaceCB)(MGR_ServerInfo * server, MGR_FaceInfo * faceinfo, int result); 
    /*获取开门记录结果回调*//*recordinfo 开门记录结构体，无为空*/
    void (*MGR_UnlockRecordCB)(MGR_ServerInfo * server, MGR_RecordListInfo * recordList); 
    /*获取开门记录结果回调*//*result 结果为0成功，-1为时间不正确，qrcode为二维码字串（非图片数据，用户自行生成二维码），失败为空*/
    void (*MGR_GetQRcodeCB)(MGR_ServerInfo * server, int result, char * qrcode); 
}MGR_RegCallBack;

#pragma pack()
/*客户端初始化，只调用一次 regInfo：回调设置*/
DLL_API int MGR_InitClient(MGR_RegCallBack * regInfo);
/*关闭客户端*/
DLL_API void MGR_FreeClient();
/*连接服务端，可多次调用，server ：服务端信息 部分信息需用户复制，其余信息由内部补充*/
DLL_API int MGR_ConnectServer(MGR_ServerInfo * server);
/*断开服务端，server：需要断开的服务端信息*/
DLL_API void MGR_UnLinkServer(MGR_ServerInfo * server);
/*发送连接心跳，server：发送服务端对象，由状态回调返回结果，用户自行决定心跳间隔*/
DLL_API int MGR_SendHeartBeat(MGR_ServerInfo * server);
/*客户端请求卡片备份，备份信息由回调返回*/
DLL_API int MGR_SendReqCardBackup(MGR_ServerInfo * server);
/*客户端应答服务端卡片备份，faillist：用户处理备份信息失败的列表，无失败则为空*/
DLL_API int MGR_SendRspCardBackup(MGR_ServerInfo * server, MGR_FailListInfo * failList);
/*客户端请求人脸备份，备份信息由回调返回*/
DLL_API int MGR_SendReqFaceBackup(MGR_ServerInfo * server);
/*客户端应答服务端人脸备份，结果有回调 faillist：用户处理备份信息失败的列表，无失败则为空*/
DLL_API int MGR_SendRspFaceBackup(MGR_ServerInfo * server, MGR_FailListInfo * failList);
/*客户端请求卡片同步，结果有回调 cardList：同步的卡片信息列表*/
DLL_API int MGR_SendReqCardSync(MGR_ServerInfo * server, MGR_CardListInfo * cardList);
/*客户端应答服务端的卡片同步请求，结果有回调 cardList：同步的卡片信息列表*/
DLL_API int MGR_SendRspCardSync(MGR_ServerInfo * server, MGR_CardListInfo * cardList);
/*客户端请求人脸同步，结果有回调 cardList：同步的人脸信息列表*/
DLL_API int MGR_SendReqFaceSync(MGR_ServerInfo * server, MGR_FaceListInfo * faceList);
/*客户端应答服务端的人脸同步请求，结果有回调 cardList：同步的人脸信息列表*/
DLL_API int MGR_SendRspFaceSync(MGR_ServerInfo * server, MGR_FaceListInfo * faceList);
/*客户端发送图片注册人脸， 结果有回调 regFace：人脸信息*/
DLL_API int MGR_SendReqRegFace(MGR_ServerInfo * server, MGR_RegFaceInfo * regFace);
/*客户端删除人脸数据，结果有回调 delFace：需要删除的人脸信息*/
DLL_API int MGR_SendReqDelFace(MGR_ServerInfo * server, MGR_DelFaceInfo * delFace);

/*获取服务端的开门记录，server：服务端，结果由回调返回，部分服务端可能不返回*/
DLL_API int MGR_SendReqUnlockRecord(MGR_ServerInfo * server);

/*获取开门二维码，server：服务端，结果由回调返回*/
DLL_API int MGR_SendReqGetQRcode(MGR_ServerInfo * server, MGR_GetQRcodeInfo * getQRcode);

#ifdef __cplusplus  
}
#endif
#endif

