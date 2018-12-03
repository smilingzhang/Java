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
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		  URL url = new URL("http://www.baidu.com");
		    // 打开连接
		    URLConnection conn = url.openConnection();
		    HttpURLConnection ht=(HttpURLConnection)conn;
		    // 得到输入流  针对我的应用程序而言是服务器输入到这
		    InputStream is = ht.getInputStream();
		    // 关于IO流的用法和写法一定要熟悉
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
