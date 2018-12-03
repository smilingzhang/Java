package Javademo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class DingShiQi {
	 public static void main(String[] args) throws IOException {
			/*Std s=new Std("zhang", "2016", (float) 98.9);
			System.out.println(s);*/
		 
		
		
		 //4.Timer定时器  
		/*Timer timer=new Timer();
		 timer.schedule(new MyTask(),1000,2000);//TimerTask()为匿名内部类
		/* while(true) {
			 try {
				 char in=(char)System.in.read();
				 if(in =='s') {
					 timer.cancel();
					 break;
				 }
			 }catch(IOException e) {
				 e.printStackTrace();
			 }
		 } */
		//1.定时写文件,写当前时期+固定的随机数字
			Timer t=new Timer();
			t.schedule(new TimerTask(){
				public void run() {
					Date date=new Date();
					SimpleDateFormat si=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
					String str=si.format(date);//format的原型 public final String Format(Date date) 
					String  b=" ";
					Random r=new Random(10);//10是seed种子，seed是时间种子
					int a=r.nextInt(10);
					try {
						FileWriter fw=new FileWriter("D:\\demo3.txt",true);//参数为true 会在后边续写;false不会续写
						fw.write(str+b+a+"\r\n");
						fw.flush();
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			},1000,1000);//当在MyTimerTask类中的run方法中实现了定时写文件时，写MyTimerTask m=new MyTimerTask(); 
			            //t.schedule(m,1000,2000)就可以了，m是内部类的一个匿名对象，所以不需要对象.方法
			 while(true) {
				 try {
					 char in=(char)System.in.read();
					 if(in =='s') {
						 t.cancel();
						 break;
					 }
				 }catch(IOException e) {
					 e.printStackTrace();
				 }
			 }
			
	 }
	/* static class MyTask extends java.util.TimerTask{
		 public void run(){
			 System.out.println("------");
		 }
	 }*/

	/*public void setAge(int age) {
		// TODO Auto-generated method stub
		
	}*/
}

//exception in thread  main主线程异常  nullpointerexception空指针异常

