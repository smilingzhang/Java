package Javademo1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;



public class Student1 {

	public Student1() {
		// TODO Auto-generated constructor stub
	}
	public int age;
	public String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "the name is :"+this.name+"the age is:"+this.age;
	}
	
	public Student1 copyStudent() {
		Student1 obj=this.clone();
		return obj;
	}
	@Override//clone������object������protected�ģ���¡ʵ�����
	protected Student1 clone() {
		Student1 student=new Student1();
		student.setAge(this.getAge());
		student.setName(this.getName());
		return student;
	}
	@Override//��дequalsʵ�ֶ���ֵ���е�
	public boolean equals(Object po) {//Object po������Խ���������Ķ���
		if(po instanceof Student1) {//instanceof�����ж��ǲ���ĳһ����Ķ���
			Student1 student1=(Student1)po;
			if(student1.getName().equals(this.getName())&&student1.getAge()==this.getAge()) {
				return true;
			}else {
				return false;
			}
		}
		else {
			return false;
		}
		
	}
	public static String getType(Object o){ //��ȡ�������ͷ���
		return o.getClass().toString(); //ʹ��int���͵�getClass()����
		} 
	public static void tripe(int x) {
		x=3*x;
	}
	
	public static void main(String[] args) throws IOException{
	/*	Student1 a=new Student1();
		Student1 b;
		a.setAge(12);
		a.setName("zhangchunhui");
		//Student1 b=a.clone();���󣬲��ܰ�object�������,��д
		b=a.clone();
		
		System.out.println(b);*/
		
		URL url = new URL("http://www.baidu.com/");
		URLConnection conn=url.openConnection();
		HttpURLConnection hs=(HttpURLConnection) conn;
	
		// �õ�������  ����ҵ�Ӧ�ó�������Ƿ��������뵽��
	
		InputStream is = hs.getInputStream();
		//InputStream is=url.openStream();
	   InputStreamReader rd=new InputStreamReader(is);
		// ����IO�����÷���д��һ��Ҫ��Ϥ
		OutputStream os = new FileOutputStream("d:\\index4.html");
		byte[] buffer = new byte[1024];
		int length = 0;
        String  result=" ";
		while (-1 != (length = is.read(buffer, 0, buffer.length))) {//ÿ�ΰ���buffer.length��ȡ
		//lengthΪʵ�ʶ�ȡ���ֽڳ���
		os.write(buffer, 0, length);
		result+=new String(buffer);
		}
		System.out.println(result);
		System.out.println("finish");
		is.close();
		os.close();
		//rd.close();

		
		
	
	}

}

