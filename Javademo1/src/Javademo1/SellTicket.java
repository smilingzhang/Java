package Javademo1;
//ÿ���߳�ִ�еĴ�����ͬ������ʹ��ͬһ��Runnable����
public class SellTicket {

	public SellTicket() {
		// TODO �Զ����ɵĹ��캯�����
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
		// TODO �Զ����ɵķ������
		while(count>0) {
			count--;
			System.out.println(Thread.currentThread().getName()+"��ǰƱ��Ϊ��"+count);
		}
		
	}
	
}
//��ʱ��˳����ң�����ͬ��



