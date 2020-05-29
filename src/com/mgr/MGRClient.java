package com.mgr;


import com.mgr.action.JnaLibrary;
import com.mgr.dto.MGR_ServerInfo;
import com.sun.jna.Native;

public class MGRClient {
	public static void main(String[] args) {

		JnaLibrary lib = (JnaLibrary) Native.loadLibrary("MGR", JnaLibrary.class);

		/*MGR_ServerInfo cb=new MGR_ServerInfo();
		int re1 = lib.MGR_ConnectServer(cb);
		System.out.println("addresult = "+re1);
*/
		//lib.MGR_FreeClient();




	}
}
