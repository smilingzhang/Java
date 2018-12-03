package Javademo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
	

	public Server() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) {
		try {
			Socket client;
			OutputStream out = null;
			InputStream in;
			ServerSocket server=new ServerSocket(2258);
			while(true) {
				//服务器监听
				System.out.println("server listner!");
				client=server.accept();//此行代码阻塞 开始监听，直到有一个客户端连接到我才执行下边的代码
				//从客户端接收
			   in=client.getInputStream();
				byte[] bs=new byte[1024];
				in.read(bs);
				/** 从socket请求获取输入流，读取流中的数据。

	                                 这个时候问题来了：虽然和客户端的连接好了
	     			但是服务端不知道客户端什么时候会发来数据，

	                              另外，因为网络传输的原因，数据还可能被分

	                                 多次到达。结合上面的说明：也就好理解了。
	 				read需要等待输入和输入的到达。
				 * */
				/*int t;
				while((t=in.read(bs,0,bs.length))!=-1) {
					System.out.println("server received:"+new String(bs));
					if(t<1024) {
						break;
					}
				}*/
				System.out.println("服务器收到："+new String(bs));
				if(new String(bs)=="exit") {
					break;
					}
				//返回给客户端
			    out=client.getOutputStream();
				String result="this is a server return!";
				out.write(result.getBytes());
				
			}
			in.close();
			out.close();
			client.close();
			server.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}


}
