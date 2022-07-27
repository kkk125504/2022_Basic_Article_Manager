package com.KoreaIT.java.BAM.dao;

public class Dao {
	public int lastId;
	
	Dao(){
		this.lastId = 0 ;
	}
	
	
	public int getLastId() {
		
		return lastId;
	}
	
	public int getNewId() {
		
		return lastId + 1;
	}
	
}
