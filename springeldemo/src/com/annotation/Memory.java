package com.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Memory {
	private int memoryNum;

	public Memory() {
		// TODO Auto-generated constructor stub
	}

	public int getMemoryNum() {
		return memoryNum;
	}
@Value("1024")
	public void setMemoryNum(int memoryNum) {
		this.memoryNum = memoryNum;
	}
	

}
