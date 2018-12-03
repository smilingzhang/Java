package Javademo1;
//���������ݷ�װ��һ�������У�����������������ڵĶ��󴫵ݸ���ͬ��Runnable��ÿ���̶߳Թ������ݵĲ���Ҳ�ָ��Ǹ�

//������ɣ������Ϳ���ʵ�ֶԸ����ݴ���Ļ�����ͨ�š�
public class DrawMoney {
    private int money;
    public DrawMoney(int money) {
    	this.money=money;
    }
    public synchronized void setMoney(int money) throws InterruptedException {
    	Thread.sleep(100);
    	this.money+=money;
    	System.out.println("�´��룺"+money+"���ƣ�"+this.money);
    	notify();
    }
    public synchronized void getMoney(int money) throws InterruptedException {
    	while(this.money<money) {
			System.out.println("ȡ�"+money+"��"+this.money+"����...");
			wait();
		}
		this.money-=money;
		System.out.println("ȡ����"+money+"��ʣ�ࣺ"+this.money);
    	
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
		// TODO �Զ����ɵķ������
		while(true) {
			int t=(int)(Math.random()*1000);
			try {
				dm.setMoney(t);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
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
		// TODO �Զ����ɵķ������
		while(true) {
			int t=(int)(Math.random()*1000);
			try {
				dm.getMoney(t);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
	}
	
}
