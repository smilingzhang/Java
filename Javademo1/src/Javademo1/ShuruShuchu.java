package Javademo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;
import java.util.stream.Collector.Characteristics;

public class ShuruShuchu {

	public ShuruShuchu() {
	}

	public static void main(String[] args) throws IOException {
		/*Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("hello");
			}
		},1000,1000);*///Delayed  ����
		// 1.�Ӽ����������    
		//CharTest();
		//ReadTest();
		//ScannerTest();
		/**
		 �ܽ����������System.in��ȡ�����ַ����������һ��int�͵ģ�������ASCII�룻
		System.in ��InputStreamReader����Ҫ�ں���ͷ����throws IOException
		 */
		
	
	/**  
	   * System.in��System.out����  
	   * ȱ��һ: �÷����ܻ�ȡ�Ӽ���������ַ�����ֻ�����һ���ַ��Ļ�ȡ  
	   * ȱ���: ��ȡ��ֻ��char���͵ġ��������int,float�����͵�����,�Ƚ��鷳��  
	 * @throws IOException 
	   */  
	/*public static void CharTest() throws IOException {
		System.out.println("Enter a char!");
		char i=(char)System.in.read();
        System.out.println("Your enter char is:"+i);
		int a=0;
		a=System.in.read();
		System.out.println(a);//�����ʽ�������ASCII��
	}*/
	/**  
	   * InputStreamReader��BufferedReader����  
	   * �ŵ�: ���Ի�ȡ����������ַ���  
	   * ȱ��: ���Ҫ��ȡ����int,float�����͵���Ȼ��Ҫת��  
	 * @throws IOException 
	   */  

	/*public static void ReadTest() throws IOException {
		System.out.println("please enter a name!");
		InputStreamReader is=new InputStreamReader(System.in);//��new����InputStreamReader�Ķ���
		BufferedReader br=new BufferedReader(is);//�ù���ķ�������BufferedReader��
		String name=br.readLine();//��ȡ�ַ���������
		System.out.println("ReadTest output:"+name);
	}*/

	/*public static void ScannerTest() {
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter name:");
		String name=sc.nextLine();//��ȡ�ַ���������
		System.out.println("your name is:"+name);
		System.out.println("please enter age:");
		int age=sc.nextInt();//��ȡ��������
		System.out.println("your age is:"+age);
		System.out.println("please enter salary:");
		float salary=sc.nextFloat();//��ȡ����������
		System.out.println("your salary is:"+salary);
		/* Scanner sc=new Scanner(System.in);//�ַ�����
				char in=sc.next().charAt(0);*/
            
      

	}
}
/**�쳣 throws IOException;try catch*/
/*
 try{
 }catch(IOException e){
 e.printStackTrace();��һ�в�û�������������쳣�����ǰ������쳣��Ϣ��ӡ����������Ա���� ��򵥵Ĵ���ʽ�ǣ�system.out���쳣��ӡ���������û���
 }
*/
