package Javademo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class XulieHua implements Serializable {//ʵ�ֽӿ�

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
	//��person�������л�
	public static void SerializePerson() throws IOException {//���Դ�һ����Ķ�����Ϊ����
		XulieHua person=new XulieHua();
		person.setPerAge(99);
		person.setPerName("laoshe");
		person.setPerSex("��");
		//��һ���ļ�
		File file=new File("D:\\one.txt");
		//����һ���ļ�������������д������
		FileOutputStream out=new FileOutputStream(file);
		//����һ����������������������л���д�뵽������
		ObjectOutputStream obj=new ObjectOutputStream(out);
		//���������л���д����̳־û�
		obj.writeObject(person);
		//�ر���
		obj.flush();
		obj.close();
	}
	//��person�������л�
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

//4.���л��Ļ�����������л��Ļ�������
/**
 * ���л��ĸ��
 * 1��������ĳһʱ�̵�״̬���������״̬��Ҳ���ǳ־û�������һʱ�̵�״̬
 * 2����java����ת��Ϊ�ɱ��ֻ�ɴ���ĸ�ʽ����ת��Ϊ�������ֽ����е���ʽ�Ĺ���
 * �����л���
 * 1������һ����״̬�ⶳ�������л������Ķ�����һ���µĶ���ʵ������Ϊ�Ѿ�������ع�
 * 2�����������ֽ����У��ֽ�������ʽ��java������������Ĺ��̡�
 * ΪʲôҪ�������л���
 * 1)���������̼����ͨѶʱ�����໥�����κ���Դ���ݣ�����Щ��Դ��
 * �����ϴ���ĸ�ʽ��Ϊ�����ƣ�������ɶ�������л�
 * ���л�����;�ͺô���
 * 1�����л�����ʵ�����ݵĳ־û���Ҳ���ǿ��Խ��������õر����ڴ�����
 * 2���������̿����������Ͻ�������
 * 3�����л����Խ�����״̬���棬�����´�ȡ������
 * 4������ʵ��Զ��ͨѶ�������������Զ����Ƹ�ʽ���Ͷ���
 * 
 * ���л�person����
 */

