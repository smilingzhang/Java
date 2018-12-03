package Javademo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NeiBu {

	public NeiBu() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) {
		Socket client;
	
		try {
			client = new Socket("127.0.0.1", 8885);
			InputStream is;
			OutputStream os;
			while(true) {

				// 获得网络输入/输出流
			is = client.getInputStream(); // 获得网络输入流
				os = client.getOutputStream(); // 获得网络输出流
				// 发送数据到server
				String request = "this is a client request!";
				os.write(request.getBytes());
				os.flush();// 刷新请求
				// 接收响应
				byte[] b = new byte[1024];
				StringBuffer strb = new StringBuffer();
				String rec = null;
				while (is.read(b) != -1) {
					rec=new String(b);
				strb.append(rec);
				}
			
				System.out.println(strb.toString());
				if(rec=="404") {
					break;
				}
			}
		     
			// 关闭连接
			is.close();
			os.close();
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
class Outer{
	public static  class Inner{
		static int a;
		public void display() {
			System.out.println("neibulei");
		}
	}
}
