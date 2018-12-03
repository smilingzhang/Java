package htmlCrawler;

import java.io.FileNotFoundException;
import java.io.IOException;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;

public class Crawler extends BreadthCrawler {

	public Crawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	// ��ÿһ��������ȡ��ҳ����Ҫ���еĲ���
	public void visit(Page page, CrawlDatums next) {
		// TODO �Զ����ɵķ������
		System.out.println("������ȡ����ҳ�ǣ�" + page.url());
		// ����ȡ������д��test.htmlҳ��
		try {
		FileUtils.write("D://360Downloads/test.html", page.content());

		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// �����������
		Crawler crawler = new Crawler("html_crawler", true);
		crawler.addSeed("http://software.hebtu.edu.cn/");
		// ��������ȡ,���ٷ���һ����������
		crawler.addRegex("+^http://software.hebtu.edu.cn/.*");
		// ���������粻��ȡjpg png gif�����ܷ�������һ����������
		crawler.addRegex("-.*\\.(jpg|png|gif).*");
		crawler.addRegex("-.*#.*");
		try {
			// �߳���
			crawler.setThreads(3);
			// ������ȡ��������ִ������
			crawler.setMaxExecuteCount(10);
			// ������ȡ���
			crawler.start(2);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

}
