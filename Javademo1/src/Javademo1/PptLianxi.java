
package Javademo1;

import java.io.File;//io��
import java.io.IOException;
import java.util.Arrays;
//import java.util.Scanner;//scanner��ͷ�ļ�
import java.util.Scanner;

public class PptLianxi{
	public PptLianxi() {
		
	}
	public static void main(String[] args) {
		//һ�����ڵ��ñ����ķ���
	
		Book book=new Book();
		
		//book.pageNum=23;���ڲ��ɵ���˽�����ԣ�public��protected�����ڰ��ڵ���
		/*book.bookName="jhkjsakj";
		book.bookAuthor="zhanghsji";
		System.out.println(book);*/
		//1.���hello word
		//System.out.println("hello word!");
		
		//2.�ж�ĳ����������������ż��
		/*int i = 3;
		if(i%2==0)
		{
		System.out.println("�������ż��");
		}
		else
			System.out.println("�����������");*/
	
   //3.��ӡ10�����ܹ���3����������
		/*for(int i=0;i<10;i++){
			if(i%3==0){
			System.out.println(i);
		    }
	   }*/
		//4.ʹ��File���г���ǰĿ¼������Ŀ¼���ļ��е�����
		/*File file= new File("D:\\360DownLoads");
		String[] f1=file.list();// list()����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼�е��ļ���Ŀ¼��
		for(int i=0;i<f1.length;i++) {
			System.out.println(f1[i]);
		}*/
		//5.ʹ��File���г���ǰĿ¼���������ļ����ļ��е�����
		File file=new File("D:\\360DownLoads");
	    list(file);
		//5��ʦ���Ĵ�  ֻ�г�һ���Ͷ���Ŀ¼
		/*File f=new File("D:\\360DownLoads");//Ŀ¼��������ʽ
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
		//7.�ڿ���̨�������Ǹ���
		/*int a=3,b=5;
		System.out.println(a>b?a:b);*/
		//8.switch case����ѧ���ɼ��ȼ�
		/*char grade='A';
		switch(grade) {
		case('A'):
			System.out.println("�ɼ���90������");
		    break;
		case('B'):
			System.out.println("�ɼ���75-90��֮��");
	        break;
		case('C'):
			System.out.println("�ɼ���60-75��֮��");
		    break;
		case('D'):
			System.out.println("�ɼ���60������");
		    break;
	   default:
		   System.out.println("�ɼ��ȼ�����");
		}*/
		//9���������������֮���������֮��
	  /* Dome a=new Dome();
	   int b=Dome.sum(1,100);
	   System.out.println(b);*/
		//10.��n�����ֵ
		/*Dome a=new Dome();
		int b=a.Caculate(6);
		System.out.println(b);*/
		//ScannerTest();
	}
	
	//10�ĺ���
	/*int Caculate(int total) {
		int sum=0;
		int n=1;
		while(sum<total) {
			sum+=n*(n+1);
			n=n++;
		}
		return n-2;
	}*/
	//9�⺯��
	/*public static int sum(int begin,int end) {
		int sum=0;
		for(int i=begin;i<=end;i++) {
			sum+=i;
		}
		return sum;
	}*/
	//5��Ҫ�ĺ���
	 public static void list(File file) {
		if(file.isDirectory()) {//�ж�file����·�����Ƿ���һ��Ŀ¼
			File[] lists=file.listFiles();//����һ������·�������飬��Щ·������ʾ�˳���·������ʾ��Ŀ¼�е��ļ���
			if(lists!=null) {
				for(int i=0;i<lists.length;i++) {
					list(lists[i]);
				}
			}
		}
		System.out.println(file);
	}
	
}

