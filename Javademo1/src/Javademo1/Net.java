//下载文件
package Javademo1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Net {

	public Net() {
		// TODO 自动生成的构造函数存根
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
		
		/*URL ul=new URL("http://www.baidu.com:80/index.html");
		HttpURLConnection hs=(HttpURLConnection) ul.openConnection();
		hs.getResponseCode();
		hs.getResponseMessage();*/
		String sUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1527949396540&di=c21d396d0230cd60aca383dcf5b20735&imgtype=0&src=http%3A%2F%2Fa3.topitme.com%2Fe%2F19%2F91%2F11274567903329119el.jpg";
		URL url = new URL(sUrl);	// 创建URL对象
		InputStream in = url.openStream();	// 获得网络输入流
		// 创建文件输出流
		FileOutputStream out = new FileOutputStream("D:\\qq.jpg");
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);		// 写入文件
		}
		System.out.println("finish");
		// 关闭输入输出流
		out.close();    in.close();
		

	}

}
