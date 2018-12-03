package Javademo1;
//两个线程交替打印数字
public class ThreadJiaotiDayinshuzi {

	public ThreadJiaotiDayinshuzi() {
		// TODO 自动生成的构造函数存根
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


