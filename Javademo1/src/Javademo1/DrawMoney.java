package Javademo1;
//将共享数据封装到一个对象中，把这个共享数据所在的对象传递给不同的Runnable，每个线程对共享数据的操作也分给那个

//对象完成，这样就可以实现对该数据处理的互斥与通信。
public class DrawMoney {
    private int money;
    public DrawMoney(int money) {
    	this.money=money;
    }
    public synchronized void setMoney(int money) throws InterruptedException {
    	Thread.sleep(100);
    	this.money+=money;
    	System.out.println("新存入："+money+"共计："+this.money);
    	notify();
    }
    public synchronized void getMoney(int money) throws InterruptedException {
    	while(this.money<money) {
			System.out.println("取款："+money+"余额："+this.money+"余额不足...");
			wait();
		}
		this.money-=money;
		System.out.println("取出："+money+"还剩余："+this.money);
    	
    }
    public static void main(String[] args) {
    	DrawMoney dm=new DrawMoney(0);
    	
    	new Thread(new Bank(dm)).start();
    	new Thread(new Consumer(dm)).start();
    }
}
class Bank implements Runnable{
    public DrawMoney dm;
    public Bank(DrawMoney dm) {
    	this.dm=dm;
    }
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			int t=(int)(Math.random()*1000);
			try {
				dm.setMoney(t);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
}
class Consumer implements Runnable{
    public DrawMoney dm;
    public Consumer(DrawMoney dm) {
    	this.dm=dm;
    }
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true) {
			int t=(int)(Math.random()*1000);
			try {
				dm.getMoney(t);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
	}
	
}
