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
	@Override//clone方法在object类中是protected的，克隆实现深拷贝
	protected Student1 clone() {
		Student1 student=new Student1();
		student.setAge(this.getAge());
		student.setName(this.getName());
		return student;
	}
	@Override//重写equals实现对数值的判等
	public boolean equals(Object po) {//Object po代表可以接收任意类的对象
		if(po instanceof Student1) {//instanceof用于判断是不是某一个类的对象
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
	public static String getType(Object o){ //获取变量类型方法
		return o.getClass().toString(); //使用int类型的getClass()方法
		} 
	public static void tripe(int x) {
		x=3*x;
	}
	
	public static void main(String[] args) throws IOException{
	/*	Student1 a=new Student1();
		Student1 b;
		a.setAge(12);
		a.setName("zhangchunhui");
		//Student1 b=a.clone();错误，不能把object类给子类,重写
		b=a.clone();
		
		System.out.println(b);*/
		
		URL url = new URL("http://www.baidu.com/");
		URLConnection conn=url.openConnection();
		HttpURLConnection hs=(HttpURLConnection) conn;
	
		// 得到输入流  针对我的应用程序而言是服务器输入到这
	
		InputStream is = hs.getInputStream();
		//InputStream is=url.openStream();
	   InputStreamReader rd=new InputStreamReader(is);
		// 关于IO流的用法和写法一定要熟悉
		OutputStream os = new FileOutputStream("d:\\index4.html");
		byte[] buffer = new byte[1024];
		int length = 0;
        String  result=" ";
		while (-1 != (length = is.read(buffer, 0, buffer.length))) {//每次按照buffer.length读取
		//length为实际读取的字节长度
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

