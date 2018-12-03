package com.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Computer {
	private int memoryNum;
	private Memory memory;

	public Computer() {
		// TODO Auto-generated constructor stub
	}

	public int getMemoryNum() {
		return memoryNum;
	}
@Value("#{memory.memoryNum}")
	public void setMemoryNum(int memoryNum) {
		this.memoryNum = memoryNum;
	}

	public Memory getMemory() {
		return memory;
	}
@Value("#{memory}")
	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	

}