package com.constructor;

import org.springframework.stereotype.Component;

@Component
public class Memory {
	private int memoryNum;
	
	public Memory() {
		
	}
	
	public Memory(int m) {
	//	this.memoryNum=111;
		this.memoryNum=m;
		System.out.println("gozo"+m);
	}

	public int getMemoryNum() {
		return memoryNum;
	}
	
	

}