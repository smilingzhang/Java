package Javademo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
	

	public Server() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) {
		try {
			Socket client;
			OutputStream out = null;
			InputStream in;
			ServerSocket server=new ServerSocket(2258);
			while(true) {
				//����������
				System.out.println("server listner!");
				client=server.accept();//���д������� ��ʼ������ֱ����һ���ͻ������ӵ��Ҳ�ִ���±ߵĴ���
				//�ӿͻ��˽���
			   in=client.getInputStream();
				byte[] bs=new byte[1024];
				in.read(bs);
				/** ��socket�����ȡ����������ȡ���е����ݡ�

	                                 ���ʱ���������ˣ���Ȼ�Ϳͻ��˵����Ӻ���
	     			���Ƿ���˲�֪���ͻ���ʲôʱ��ᷢ�����ݣ�

	                              ���⣬��Ϊ���紫���ԭ�����ݻ����ܱ���

	                                 ��ε����������˵����Ҳ�ͺ�����ˡ�
	 				read��Ҫ�ȴ����������ĵ��
				 * */
				/*int t;
				while((t=in.read(bs,0,bs.length))!=-1) {
					System.out.println("server received:"+new String(bs));
					if(t<1024) {
						break;
					}
				}*/
				System.out.println("�������յ���"+new String(bs));
				if(new String(bs)=="exit") {
					break;
					}
				//���ظ��ͻ���
			    out=client.getOutputStream();
				String result="this is a server return!";
				out.write(result.getBytes());
				
			}
			in.close();
			out.close();
			client.close();
			server.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}


}
