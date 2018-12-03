package Javademo1;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {//TimerTask()里边有一个抽象方法，是public abstract void run()

	public static void main(String[] args) {
		
		//TimerTask m=new MyTimerTask();
		Student1 aStudent1=new Student1();
		aStudent1.setAge(11);
		aStudent1.setName("caishuang");
		Student1 bStudent1;
		bStudent1=aStudent1.clone();
		System.out.println(bStudent1);
	}
	//@Override
	public void run() {
		System.out.println("实现run抽象方法");//把定时写文件的代码放到这里就可以
	}
   /* public void display() {
    	System.out.println("我是子类中新增加的类");
    }*/
   
}
