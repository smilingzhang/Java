//�����ļ�
package Javademo1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Net {

	public Net() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) throws IOException {
		/*try {
			URL ul=new URL("http://www.baidu.com:80/index.html");
			String s1=ul.getProtocol();
			String s2=ul.getHost();
			int s3=ul.getPort();
			String s4=ul.getFile();
			String s5=ul.getRef();
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s4);
			System.out.println(s5);
		} catch (MalformedURLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}*/
		
		/*URL ul=new URL("http://www.baidu.com:80/index.html");
		HttpURLConnection hs=(HttpURLConnection) ul.openConnection();
		hs.getResponseCode();
		hs.getResponseMessage();*/
		String sUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527949396540&di=c21d396d0230cd60aca383dcf5b20735&imgtype=0&src=http%3A%2F%2Fa3.topitme.com%2Fe%2F19%2F91%2F11274567903329119el.jpg";
		URL url = new URL(sUrl);	// ����URL����
		InputStream in = url.openStream();	// �������������
		// �����ļ������
		FileOutputStream out = new FileOutputStream("D:\\qq.jpg");
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);		// д���ļ�
		}
		System.out.println("finish");
		// �ر����������
		out.close();    in.close();
		

	}

}
