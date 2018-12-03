package Javademo1;
////简单的多线程间数据共享，每个线程执行的代码不同，用不同的Runnable对象
//将这些Runnable对象作为某一个类的内部类，共享的数据作为外部类的成员变量，对共享数据的操作分配给外部类的方法来完成，
//以此实现对操作共享数据的互斥和通信，作为内部类的Runnable来操作外部类的方法，实现对数据的操作
public class SomeThread {

	public SomeThread() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) {
		Data d=new Data();
		for(int i=0;i<2;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO 自动生成的方法存根
					d.add();
				}
			}).start();
           new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO 自动生成的方法存根
				d.drop();	
				}
			}).start();
		}
	}
}
class Data {
	private static int j=1;
	public static void add() {
		j++;
		System.out.println(Thread.currentThread().getName()+j);
		
	}
	public static void drop() {
		j--;
		System.out.println(Thread.currentThread().getName()+j);
	}
}