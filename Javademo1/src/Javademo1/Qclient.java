package Javademo1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Qclient {
	static InputStream in;
	public Qclient() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("127.0.0.1",6669);
			OutputStream out;
			
			while(true) {
				out=socket.getOutputStream();
				BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));//获取从命令行输入的字符串
				String msg=bf.readLine();
				out.write(msg.getBytes());
				if(msg.equals("byebye")) {
					break;
				}
				System.out.println("客户端已经发送！");
				new Thread() {

					@Override
					public void run() {
						// TODO 自动生成的方法存根
						super.run();
						while(true) {
							try {
								in=socket.getInputStream();
								byte[]  bs=new byte[1024];
								
								int n=in.read(bs);
								System.out.println("客户端接收的数据是"+new String(bs,0,n));
								
							} catch (IOException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							
						}
					}
					
					
				}.start();
				System.out.println(Thread.currentThread().getName());
			}
			in.close();
			out.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
