package Javademo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class XulieHua implements Serializable {//实现接口

	public int perAge;
	public String perName;
	public String perSex;
	public int getPerAge() {
		return perAge;
	}
	public void setPerAge(int perAge) {
		this.perAge = perAge;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public String getPerSex() {
		return perSex;
	}
	public void setPerSex(String perSex) {
		this.perSex = perSex;
	}
	public String toString() {
		return "person's age is:"+this.perAge+" "+"person's name is:"+this.perName+" "+"preson's sex is:"+this.perSex;
	}
	//将person对象序列化
	public static void SerializePerson() throws IOException {//可以传一个类的对象作为参数
		XulieHua person=new XulieHua();
		person.setPerAge(99);
		person.setPerName("laoshe");
		person.setPerSex("男");
		//找一个文件
		File file=new File("D:\\one.txt");
		//创建一个文件输出流，向磁盘写入数据
		FileOutputStream out=new FileOutputStream(file);
		//创建一个对象输出流，将对象序列化并写入到磁盘上
		ObjectOutputStream obj=new ObjectOutputStream(out);
		//将对象序列化并写入磁盘持久化
		obj.writeObject(person);
		//关闭流
		obj.flush();
		obj.close();
	}
	//将person对象反序列化
	public static void DeserializePerson() throws IOException, ClassNotFoundException {
		File file=new File("D:\\one.txt");
		FileInputStream in=new FileInputStream(file);
		ObjectInputStream obj=new ObjectInputStream(in);
		System.out.println(	obj.readObject());
		obj.close();
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
	
		SerializePerson();
		DeserializePerson();
		
	}
}

//4.序列化的基本概念，反序列化的基本概念
/**
 * 序列化的概念：
 * 1）对象在某一时刻的状态，冻结对象状态，也就是持久化对象这一时刻的状态
 * 2）将java对象转换为可保持或可传输的格式，即转换为二进制字节序列的形式的过程
 * 反序列化：
 * 1）将这一对象状态解冻，反序列化出来的对象是一个新的对象实例，因为已经完成了重构
 * 2）将二进制字节序列（字节流）形式的java对象解析出来的过程。
 * 为什么要进行序列化：
 * 1)当两个进程间进行通讯时可以相互发送任何资源数据，而这些资源在
 * 网络上传输的格式均为二进制，必须完成对象的序列化
 * 序列化的用途和好处：
 * 1）序列化可以实现数据的持久化，也就是可以将数据永久地保存在磁盘上
 * 2）两个进程可以在网络上交互数据
 * 3）序列化可以将对象状态保存，方便下次取出利用
 * 4）可以实现远程通讯，即在网络上以二进制格式传送对象
 * 
 * 序列化person对象
 */

