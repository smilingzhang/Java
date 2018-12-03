
package Javademo1;

import java.io.File;//io流
import java.io.IOException;
import java.util.Arrays;
//import java.util.Scanner;//scanner的头文件
import java.util.Scanner;

public class PptLianxi{
	public PptLianxi() {
		
	}
	public static void main(String[] args) {
		//一个包内调用别的类的方法
	
		Book book=new Book();
		
		//book.pageNum=23;包内不可调用私有属性，public和protected可以在包内调用
		/*book.bookName="jhkjsakj";
		book.bookAuthor="zhanghsji";
		System.out.println(book);*/
		//1.输出hello word
		//System.out.println("hello word!");
		
		//2.判断某个变量是奇数还是偶数
		/*int i = 3;
		if(i%2==0)
		{
		System.out.println("这个数是偶数");
		}
		else
			System.out.println("这个数是奇数");*/
	
   //3.打印10以内能够被3整除的数字
		/*for(int i=0;i<10;i++){
			if(i%3==0){
			System.out.println(i);
		    }
	   }*/
		//4.使用File类列出当前目录中所有目录和文件夹的名字
		/*File file= new File("D:\\360DownLoads");
		String[] f1=file.list();// list()返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录。
		for(int i=0;i<f1.length;i++) {
			System.out.println(f1[i]);
		}*/
		//5.使用File类列出当前目录树中所有文件和文件夹的名字
		File file=new File("D:\\360DownLoads");
	    list(file);
		//5老师给的答案  只列出一级和二级目录
		/*File f=new File("D:\\360DownLoads");//目录有两种形式
		File[]lf=f.listFiles();
		for (int i = 0; i < lf.length; i++) {
			File file = lf[i];
			if(file.isDirectory()){
				File[] ltf=file.listFiles();
				for (int j = 0; j < ltf.length; j++) {
					System.out.println(ltf[j]);
				}
			}
			System.out.println(file);
		}*/
		//7.在控制台输出大的那个数
		/*int a=3,b=5;
		System.out.println(a>b?a:b);*/
		//8.switch case输入学生成绩等级
		/*char grade='A';
		switch(grade) {
		case('A'):
			System.out.println("成绩在90分以上");
		    break;
		case('B'):
			System.out.println("成绩在75-90分之间");
	        break;
		case('C'):
			System.out.println("成绩在60-75分之间");
		    break;
		case('D'):
			System.out.println("成绩在60分以下");
		    break;
	   default:
		   System.out.println("成绩等级错误");
		}*/
		//9计算给定的两个数之间的所有数之和
	  /* Dome a=new Dome();
	   int b=Dome.sum(1,100);
	   System.out.println(b);*/
		//10.求n的最大值
		/*Dome a=new Dome();
		int b=a.Caculate(6);
		System.out.println(b);*/
		//ScannerTest();
	}
	
	//10的函数
	/*int Caculate(int total) {
		int sum=0;
		int n=1;
		while(sum<total) {
			sum+=n*(n+1);
			n=n++;
		}
		return n-2;
	}*/
	//9题函数
	/*public static int sum(int begin,int end) {
		int sum=0;
		for(int i=begin;i<=end;i++) {
			sum+=i;
		}
		return sum;
	}*/
	//5需要的函数
	 public static void list(File file) {
		if(file.isDirectory()) {//判断file抽象路径名是否是一个目录
			File[] lists=file.listFiles();//返回一个抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件。
			if(lists!=null) {
				for(int i=0;i<lists.length;i++) {
					list(lists[i]);
				}
			}
		}
		System.out.println(file);
	}
	
}

