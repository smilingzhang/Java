package Javademo1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class MyException extends Exception {


	public MyException() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyException(String arg0) {
		super(arg0);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyException(Throwable arg0) {
		super(arg0);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) throws IOException {
	
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		System.out.println("�����ļ�·��");
		FileWriter fw=new FileWriter(name);
		BufferedWriter bw=new BufferedWriter(fw);
		
		System.out.println("������Ҫд�����ݣ�");
		String teString;
		while(!(teString=sc.nextLine()).equals("stop")) {
			bw.write(teString);
			bw.newLine();
			System.out.println("111");
		}
		System.out.println("�ѳɹ����У�");
	}

}
