package javaconfig;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Computer {
	@Resource(name="IntelCpu")
	private Cpu cpu;
	
	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public void play() {
		this.cpu.run();
		System.out.println("play:javaconfig");
	}

}
