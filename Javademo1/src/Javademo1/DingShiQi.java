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
		 
		
		
		 //4.Timer��ʱ��  
		/*Timer timer=new Timer();
		 timer.schedule(new MyTask(),1000,2000);//TimerTask()Ϊ�����ڲ���
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
		//1.��ʱд�ļ�,д��ǰʱ��+�̶����������
			Timer t=new Timer();
			t.schedule(new TimerTask(){
				public void run() {
					Date date=new Date();
					SimpleDateFormat si=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
					String str=si.format(date);//format��ԭ�� public final String Format(Date date) 
					String  b=" ";
					Random r=new Random(10);//10��seed���ӣ�seed��ʱ������
					int a=r.nextInt(10);
					try {
						FileWriter fw=new FileWriter("D:\\demo3.txt",true);//����Ϊtrue ���ں����д;false������д
						fw.write(str+b+a+"\r\n");
						fw.flush();
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			},1000,1000);//����MyTimerTask���е�run������ʵ���˶�ʱд�ļ�ʱ��дMyTimerTask m=new MyTimerTask(); 
			            //t.schedule(m,1000,2000)�Ϳ����ˣ�m���ڲ����һ�������������Բ���Ҫ����.����
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

//exception in thread  main���߳��쳣  nullpointerexception��ָ���쳣

