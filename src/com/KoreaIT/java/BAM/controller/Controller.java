package com.KoreaIT.java.BAM.controller;

public abstract class Controller {
	
	public abstract void doAction(String cmd, String actionMethodName);
	
	//테스트 데이터
	public abstract void makeTestData();
}
