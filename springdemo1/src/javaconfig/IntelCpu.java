package javaconfig;

import org.springframework.stereotype.Component;

import javaconfig.Cpu;

@Component("IntelCpu")
public class IntelCpu implements Cpu{

	public IntelCpu() {
		// TODO Auto-generated constructor stub
	}
	public void run() {
		System.out.println("run:javaconfig");
	}

}