package Javademo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class NeiBu {

	public NeiBu() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) {
		Socket client;
	
		try {
			client = new Socket("127.0.0.1", 8885);
			InputStream is;
			OutputStream os;
			while(true) {

				// �����������/�����
			is = client.getInputStream(); // �������������
				os = client.getOutputStream(); // ������������
				// �������ݵ�server
				String request = "this is a client request!";
				os.write(request.getBytes());
				os.flush();// ˢ������
				// ������Ӧ
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
		     
			// �ر�����
			is.close();
			os.close();
			client.close();
		} catch (UnknownHostException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
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
