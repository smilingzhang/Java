package Javademo1;

public class ThreadDemo {

	public ThreadDemo() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) throws InterruptedException {
		/*Thread t=new MyThread();
		t.start();
		t.join();//���̵߳��õ�join��������ִ�����߳�
		for(int j=0;j<20;j++) {
		//	Thread.sleep(100);
			System.out.println(Thread.currentThread().getName()+j);
		}*/
		String s1="abc",s2="abc";
		String s3=new String("cd");
		String s4=new String("cd");
		System.out.println(s1==s2);
		System.out.println(s3==s4);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
	}
}
