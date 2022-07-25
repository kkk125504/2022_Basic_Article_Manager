package com.KoreaIT.java.BAM.controller;

import com.KoreaIT.java.BAM.dto.Member;

public abstract class Controller {
	public static Member loginedMember;
	public abstract void doAction(String cmd, String actionMethodName);
	public static boolean isLogined() {
		// loginedMember이 null이 아니면 true 즉 로그인된상황 이면 true
		// loginedMember이 null이면 false 즉 로그인이 안된상황 이면 false
		return loginedMember != null;
	}
	
	public abstract void makeTestData();
}
