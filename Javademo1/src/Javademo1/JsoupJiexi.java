package Javademo1;

import java.io.IOException;

import javax.swing.text.Document;

import org.jsoup.Jsoup;


//1.jsoup是html解析器
/*2.jsoup主要功能：
1）从一个url 文件或者字符串中解析html 
2)使用dom或者css查找取出数据
3）可操作html元素 属性 文本
*/
public class JsoupJiexi {

	public JsoupJiexi() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) throws IOException {
		//1.文档输入：jsoup可以从字符串、url地址以及本地文件来加载html文档并生成document对象
		//1）直接从字符串中输入html文档
		String html="<html> <head><title>jsoup从字符串中解析html</title></head>"+"<body><p>jsoup的相关介绍文章</p></body></html>";
		org.jsoup.nodes.Document dos=Jsoup.parse(html);
	  //2)从url直接加载html文档
		org.jsoup.nodes.Document d=Jsoup.connect("http:///www.baidu.com/").get();
		String doc=d.title();
	
	}

}

