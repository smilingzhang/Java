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
		this(0,10);//调用了本类的构造
	}
	public  MyRandom(int a) {
		this(0,a);
	}
	public MyRandom(int a,int b) {
		this.start=a;
		this.end=b;
	}
	

	@Override
	//产生的随机数范围在[1,10] 此类不需要属性成员
	/*public int nextInt() {
		return Math.abs(super.nextInt()%10)+1;
	}*/
	//产生的随机数范围在[0,a] 此类需要一个属性成员接收a值
	/*public int nextInt() {
		return Math.abs(super.nextInt()%(num+1));
	}*/
	//产生的随机数范围在[a,b] 此类需要两个属性成员，分别接受a和b的值
	public int nextInt() {
		return Math.abs(super.nextInt()%(end-start)+start);
	}
	public int nextNum() {
		return  Math.abs(super.nextInt()%(end-start)+start);
	}
	//nextInt()与nextNum()方法的区别：1）名字不同  2）重写，父类对象可以调用，可以发生动态多态(父类引用可以调用子类方法的重写，不能调用新增的方法)
	public static void main(String[] args)
	{

		MyRandom m=new MyRandom(5);
		System.out.println(m.nextNum());
	}

}
