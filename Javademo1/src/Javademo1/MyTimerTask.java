package Javademo1;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask {//TimerTask()�����һ�����󷽷�����public abstract void run()

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
		System.out.println("ʵ��run���󷽷�");//�Ѷ�ʱд�ļ��Ĵ���ŵ�����Ϳ���
	}
   /* public void display() {
    	System.out.println("���������������ӵ���");
    }*/
   
}
