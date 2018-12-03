package Javademo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	public Client() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) {
		Socket client;
		try {
		
			
			client = new Socket("127.0.0.1",3356);
			InputStream in=client.getInputStream();
			OutputStream out=client.getOutputStream();
			Scanner scanner1=new Scanner(System.in);
			String send=scanner1.nextLine();
			out.write(send.getBytes());
			out.flush();
			
			int t;
			byte[] bs=new byte[1024];
			StringBuffer buffer=new StringBuffer();
			while((t=in.read(bs))!=-1) {
				buffer.append(new String(bs));
				if(t<1024) {
					break;
				}
			}
			System.out.println(buffer.toString());
			
			in.close();
			out.close();
			client.close();
		
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
