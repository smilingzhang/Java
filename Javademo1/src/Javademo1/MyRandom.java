package Javademo1;

import java.util.Base64;
import java.util.Random;

public class MyRandom extends Random {
	
   /* [1,10]public MyRandom() {
	   
   }*/
	/* [0,a]
	 * private int num;
	 *  public MyRandom() {
		this(10);
	}

	public MyRandom(int a) {
		num=a;
	}*/
	private int start;
	private int end;
	public  MyRandom() {
		this(0,10);//�����˱���Ĺ���
	}
	public  MyRandom(int a) {
		this(0,a);
	}
	public MyRandom(int a,int b) {
		this.start=a;
		this.end=b;
	}
	

	@Override
	//�������������Χ��[1,10] ���಻��Ҫ���Գ�Ա
	/*public int nextInt() {
		return Math.abs(super.nextInt()%10)+1;
	}*/
	//�������������Χ��[0,a] ������Ҫһ�����Գ�Ա����aֵ
	/*public int nextInt() {
		return Math.abs(super.nextInt()%(num+1));
	}*/
	//�������������Χ��[a,b] ������Ҫ�������Գ�Ա���ֱ����a��b��ֵ
	public int nextInt() {
		return Math.abs(super.nextInt()%(end-start)+start);
	}
	public int nextNum() {
		return  Math.abs(super.nextInt()%(end-start)+start);
	}
	//nextInt()��nextNum()����������1�����ֲ�ͬ  2����д�����������Ե��ã����Է�����̬��̬(�������ÿ��Ե������෽������д�����ܵ��������ķ���)
	public static void main(String[] args)
	{

		MyRandom m=new MyRandom(5);
		System.out.println(m.nextNum());
	}

}
