package com;

import org.springframework.stereotype.Component;

@Component("IntelCpu")
public class IntelCpu implements Cpu{

	public IntelCpu() {
		// TODO Auto-generated constructor stub
	}
	public void run() {
		System.out.println("runrunrun");
	}

}
