package Javademo1;
//每个线程执行的代码相同，可以使用同一个Runnable对象
public class SellTicket {

	public SellTicket() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) {
		Ticket t=new Ticket();
		new Thread(t).start();
		new Thread(t).start();
	}
}
class Ticket implements Runnable{
	private static int count=20;
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(count>0) {
			count--;
			System.out.println(Thread.currentThread().getName()+"当前票数为："+count);
		}
		
	}
	
}
//有时候顺序会乱：存在同步



