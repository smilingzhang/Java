package Javademo1;
//�����߳̽����ӡ����
public class ThreadJiaotiDayinshuzi {

	public ThreadJiaotiDayinshuzi() {
		// TODO �Զ����ɵĹ��캯�����
	}
	private static Object lock = new Object();  
	  
    private static int i = 1;  
  
    public static void main(String[] args) {  
       new Thread() {  
            public void run() {  
                while (i <= 10) {  
                    synchronized (lock) {  
                        if (i % 2 == 1) {  
                            System.out.println("thread1  " + i++);  
                        } 
                        else {  
                            lock.notifyAll();  
                            try {  
                                lock.wait(1000);  
                            } catch (InterruptedException e) {  
                                e.printStackTrace();  
                            }  
                        }  
                    }  
  
                }  
            }  
        }.start();  
  
       new Thread() {  
            public void run() {  
                while (i <= 10) {  
                    synchronized (lock) {  
                        if (i % 2 == 0) {  
                            System.out.println("thread2  " + i++);  
                        } else {  
                            lock.notifyAll();  
                            try {  
                                lock.wait(1000);  
                            } catch (InterruptedException e) {  
                                e.printStackTrace();  
                            }  
                        }  
                    }  
  
                }  
            }  
        }.start();
        
    }  
}  


