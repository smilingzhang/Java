package com;


import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Computer {
	private Cpu cpu;

	
	@Resource(name="IntelCpu")
	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public void play() {
		this.cpu.run();
		System.out.println("ÕÊ”Œœ∑");
		
	}

}
