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
		},1000,1000);*///Delayed  周期
		// 1.从键盘输入输出    
		//CharTest();
		//ReadTest();
		//ScannerTest();
		/**
		 总结输入输出：System.in读取的是字符，如果给定一个int型的，最后输出ASCII码；
		System.in 和InputStreamReader都需要在函数头加上throws IOException
		 */
		
	
	/**  
	   * System.in和System.out方法  
	   * 缺点一: 该方法能获取从键盘输入的字符，但只能针对一个字符的获取  
	   * 缺点二: 获取的只是char类型的。如果想获得int,float等类型的输入,比较麻烦。  
	 * @throws IOException 
	   */  
	/*public static void CharTest() throws IOException {
		System.out.println("Enter a char!");
		char i=(char)System.in.read();
        System.out.println("Your enter char is:"+i);
		int a=0;
		a=System.in.read();
		System.out.println(a);//这个方式输出的是ASCII码
	}*/
	/**  
	   * InputStreamReader和BufferedReader方法  
	   * 优点: 可以获取键盘输入的字符串  
	   * 缺点: 如何要获取的是int,float等类型的仍然需要转换  
	 * @throws IOException 
	   */  

	/*public static void ReadTest() throws IOException {
		System.out.println("please enter a name!");
		InputStreamReader is=new InputStreamReader(System.in);//用new构造InputStreamReader的对象
		BufferedReader br=new BufferedReader(is);//用构造的方法传到BufferedReader中
		String name=br.readLine();//读取字符串型输入
		System.out.println("ReadTest output:"+name);
	}*/

	/*public static void ScannerTest() {
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter name:");
		String name=sc.nextLine();//读取字符串型输入
		System.out.println("your name is:"+name);
		System.out.println("please enter age:");
		int age=sc.nextInt();//读取整型输入
		System.out.println("your age is:"+age);
		System.out.println("please enter salary:");
		float salary=sc.nextFloat();//读取浮点型输入
		System.out.println("your salary is:"+salary);
		/* Scanner sc=new Scanner(System.in);//字符输入
				char in=sc.next().charAt(0);*/
            
      

	}
}
/**异常 throws IOException;try catch*/
/*
 try{
 }catch(IOException e){
 e.printStackTrace();这一行并没有真正处理了异常，而是把所有异常信息打印出来给程序员看， 最简单的处理方式是：system.out把异常打印出来，给用户看
 }
*/
