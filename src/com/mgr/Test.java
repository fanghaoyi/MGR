package com.mgr;

import com.mgr.action.Lib;
import com.sun.jna.Native;

public class Test {        
	public static void main(String[] args) {
		Lib lib = (Lib) Native.loadLibrary("AddApi", Lib.class);
		int re1 = lib.Add_Sum(11, 9);
		System.out.println("addresult = "+re1);
	}
}