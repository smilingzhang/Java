package Javademo1;

public class MyThread extends Thread {

	public MyThread() {
		// TODO 自动生成的构造函数存根
	}

	public MyThread(Runnable arg0) {
		super(arg0);
		// TODO 自动生成的构造函数存根
	}

	public MyThread(String arg0) {
		super(arg0);
		// TODO 自动生成的构造函数存根
	}

	public MyThread(ThreadGroup arg0, Runnable arg1) {
		super(arg0, arg1);
		// TODO 自动生成的构造函数存根
	}

	public MyThread(ThreadGroup arg0, String arg1) {
		super(arg0, arg1);
		// TODO 自动生成的构造函数存根
	}

	public MyThread(Runnable arg0, String arg1) {
		super(arg0, arg1);
		// TODO 自动生成的构造函数存根
	}

	public MyThread(ThreadGroup arg0, Runnable arg1, String arg2) {
		super(arg0, arg1, arg2);
		// TODO 自动生成的构造函数存根
	}

	public MyThread(ThreadGroup arg0, Runnable arg1, String arg2, long arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO 自动生成的构造函数存根
	}

	public MyThread(ThreadGroup arg0, Runnable arg1, String arg2, long arg3, boolean arg4) {
		super(arg0, arg1, arg2, arg3, arg4);
		// TODO 自动生成的构造函数存根
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		super.run();
		for(int i=0;i<20;i++) {
			/*try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
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
				t.join();//子线程调用的join，所以先执行子线程
			}*/
		//	Thread.sleep(100);
			System.out.println(Thread.currentThread().getName()+j);
		}
	}
	

}
