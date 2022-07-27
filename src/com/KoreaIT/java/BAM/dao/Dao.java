package com.KoreaIT.java.BAM.dao;

public class Dao {
	protected int lastId;
	
	Dao(){
		this.lastId = 0 ;
	}
	
	
	public int getLastId() {
		
		return lastId;
	}
	
	public int setNewId() {
		
		return lastId + 1;
	}
	
}
