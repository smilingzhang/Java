package Javademo1;

import java.io.IOException;

import javax.swing.text.Document;

import org.jsoup.Jsoup;


//1.jsoup��html������
/*2.jsoup��Ҫ���ܣ�
1����һ��url �ļ������ַ����н���html 
2)ʹ��dom����css����ȡ������
3���ɲ���htmlԪ�� ���� �ı�
*/
public class JsoupJiexi {

	public JsoupJiexi() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) throws IOException {
		//1.�ĵ����룺jsoup���Դ��ַ�����url��ַ�Լ������ļ�������html�ĵ�������document����
		//1��ֱ�Ӵ��ַ���������html�ĵ�
		String html="<html> <head><title>jsoup���ַ����н���html</title></head>"+"<body><p>jsoup����ؽ�������</p></body></html>";
		org.jsoup.nodes.Document dos=Jsoup.parse(html);
	  //2)��urlֱ�Ӽ���html�ĵ�
		org.jsoup.nodes.Document d=Jsoup.connect("http:///www.baidu.com/").get();
		String doc=d.title();
	
	}

}

