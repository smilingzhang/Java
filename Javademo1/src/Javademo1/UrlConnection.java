package Javademo1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnection {

	public UrlConnection() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		  URL url = new URL("http://www.baidu.com");
		    // ������
		    URLConnection conn = url.openConnection();
		    HttpURLConnection ht=(HttpURLConnection)conn;
		    // �õ�������  ����ҵ�Ӧ�ó�������Ƿ��������뵽��
		    InputStream is = ht.getInputStream();
		    // ����IO�����÷���д��һ��Ҫ��Ϥ
		    OutputStream oss = new FileOutputStream(new File("d:\\baidu.html"));

		    byte[] buffer = new byte[2048];
		    int length = 0;

		    while (-1 != (length = is.read(buffer, 0, buffer.length))) {
		    oss.write(buffer, 0, length);
		    }
		    System.out.println("finish");
		    is.close();
		    oss.close();

	}
	

}
