package Javademo1;
////�򵥵Ķ��̼߳����ݹ���ÿ���߳�ִ�еĴ��벻ͬ���ò�ͬ��Runnable����
//����ЩRunnable������Ϊĳһ������ڲ��࣬�����������Ϊ�ⲿ��ĳ�Ա�������Թ������ݵĲ���������ⲿ��ķ�������ɣ�
//�Դ�ʵ�ֶԲ����������ݵĻ����ͨ�ţ���Ϊ�ڲ����Runnable�������ⲿ��ķ�����ʵ�ֶ����ݵĲ���
public class SomeThread {

	public SomeThread() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) {
		Data d=new Data();
		for(int i=0;i<2;i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO �Զ����ɵķ������
					d.add();
				}
			}).start();
           new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO �Զ����ɵķ������
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