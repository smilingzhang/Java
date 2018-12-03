package Javademo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Clientthread {

	public Clientthread() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			String user=sc.nextLine();
			String psw=sc.nextLine();
			Socket socket=new Socket("127.0.0.1", 4450);
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write(user+psw);
			pw.flush();
			socket.shutdownOutput();
			//��ȡ���������͵���Ϣ
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null) {
				System.out.println("���������͹�������Ϣ�ǣ�"+info);
			}
			br.close();
			is.close();
			os.close();
			pw.close();
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
