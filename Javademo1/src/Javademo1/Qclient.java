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
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("127.0.0.1",6669);
			OutputStream out;
			
			while(true) {
				out=socket.getOutputStream();
				BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));//��ȡ��������������ַ���
				String msg=bf.readLine();
				out.write(msg.getBytes());
				if(msg.equals("byebye")) {
					break;
				}
				System.out.println("�ͻ����Ѿ����ͣ�");
				new Thread() {

					@Override
					public void run() {
						// TODO �Զ����ɵķ������
						super.run();
						while(true) {
							try {
								in=socket.getInputStream();
								byte[]  bs=new byte[1024];
								
								int n=in.read(bs);
								System.out.println("�ͻ��˽��յ�������"+new String(bs,0,n));
								
							} catch (IOException e) {
								// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
