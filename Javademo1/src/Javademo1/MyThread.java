package Javademo1;

public class MyThread extends Thread {

	public MyThread() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyThread(Runnable arg0) {
		super(arg0);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyThread(String arg0) {
		super(arg0);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyThread(ThreadGroup arg0, Runnable arg1) {
		super(arg0, arg1);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyThread(ThreadGroup arg0, String arg1) {
		super(arg0, arg1);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyThread(Runnable arg0, String arg1) {
		super(arg0, arg1);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyThread(ThreadGroup arg0, Runnable arg1, String arg2) {
		super(arg0, arg1, arg2);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyThread(ThreadGroup arg0, Runnable arg1, String arg2, long arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO �Զ����ɵĹ��캯�����
	}

	public MyThread(ThreadGroup arg0, Runnable arg1, String arg2, long arg3, boolean arg4) {
		super(arg0, arg1, arg2, arg3, arg4);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		super.run();
		for(int i=0;i<20;i++) {
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}*/
			System.out.println(Thread.currentThread().getName()+i);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		int j=0;
		Thread t1=new MyThread();
		Thread t2=new MyThread();
		t1.start();
		t2.start();
		for(j=0;j<20;j++) {
			/*if(j==10) {
				t.join();//���̵߳��õ�join��������ִ�����߳�
			}*/
		//	Thread.sleep(100);
			System.out.println(Thread.currentThread().getName()+j);
		}
	}
	

}
