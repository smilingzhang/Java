package htmlCrawler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.util.FileUtils;

public class MyCrawler extends BreadthCrawler {
	private static HSSFWorkbook workbook;
	private static HSSFSheet sheet;
	private static HSSFRow row;
	private static HSSFCell cell;
	private static int m;
	private static Connection conn;
	private static int n;// 记录数据库中有几行数据
	private static Statement st;

	public MyCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// TODO 自动生成的构造函数存根
		m = 0;
		n = 0;
	}

	@Override
	public void visit(Page page, CrawlDatums next) {
		// TODO 自动生成的方法存根
		// System.out.println("这在提取的网页是："+page.url());
		// 提取到的网页保存到mycont.html中
		try {
			FileUtils.write("D://360Downloads/mycont.html", page.content());
			// 页面地址
			String url = page.url();
			// 页面标题
			String title = page.doc().title();
			// 文章内容
			Elements text = page.select("div.articlebody");
			// 页面时间
			Elements time = page.select("span.time.SG_txtc");

			if (page.matchUrl("http://blog.sina.com.cn/.*")) {
				if (text.isEmpty()) {

					text = page.select("div.articalContent");
				} else {
					text = page.select("div.articalContent");
				}
				time = page.select("span.time.SG_txtc");

			} else if (page.matchUrl("http://baby.sina.com.cn/.*")) {
				if (!page.select("div#artibody.article").isEmpty()) {
					text = page.select("div#artibody.article");
				}
				if (!page.select("dl.content").isEmpty()) {
					text = page.select("dl.content");
				}
				if (!page.select("div#article.article").isEmpty()) {
					text = page.select("div#article.article");
				}
				if (!page.select("div#articlebody").isEmpty()) {
					text = page.select("div#articlebody");
				}
				time = page.select("span.date");
			}
			System.out.println("网址为：" + url);
			System.out.println("标题为：" + title);
			System.out.println("时间为：" + time.text());
			System.out.println("内容为：" + text.text());
			// 写到文本文件
			 toFile(url, title, time,text);
			// 写到excel表
			 createExcel(url, title,time,text);
			// 写进数据库
			try {
				if (!text.isEmpty() && !time.isEmpty()) {
					n++;
					insertStu("insert into mycrawler values(?,?,?,?)", url, title, time.text(), text.text());
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	// 将抓取的数据写到文本文件
	public static void toFile(String url, String title, Elements time, Elements text) throws IOException {
		if (!text.isEmpty() && !time.isEmpty()) {
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\360Downloads\\crawler.txt", true));
			try {
				bw.write("网页：" + url + "\r\n");
				bw.write("标题: " + title + "\r\n");
				bw.write("时间: " + time.text() + "\r\n");
				bw.write("内容: " + text.text() + "\r\n");
				bw.write("\r\n");
				bw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	// 创建excel表并写入数据
	public static void createExcel(String url, String title, Elements time, Elements text) throws IOException {
		// 如果是第0行就创建excel并填充标题，否则就写入
		if (m == 0) {
			workbook = new HSSFWorkbook();
			// 新建sheet
			sheet = workbook.createSheet("数据解析");
			// 创建行,行号作为参数传递给createRow()方法,第一行从0开始计算
			String[] th = { "网页", "标题", "时间", "内容" };
			// 填充标题
			row = sheet.createRow(0);
			for (int i = 0; i < 4; i++) {
				cell = row.createCell(i);
				cell.setCellValue(th[i]);
			}
			m = 1;
			System.out.println("已成功创建excel表!");
		} else {
			// 不为空时写入数据
			if (!text.isEmpty() && !time.isEmpty()) {
				row = sheet.createRow(m);
				row.createCell(0).setCellValue(url);
				row.createCell(1).setCellValue(title);
				row.createCell(2).setCellValue(time.text());
				row.createCell(3).setCellValue(text.text());
				m++;
			}
		}
		// 输出到磁盘中
		FileOutputStream fos = new FileOutputStream(new File("D:\\360DownLoads\\DataAnalysis.xls"));
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

	// 向数据库插入数据
	public static int insertStu(String sql, String... args) throws SQLException {
		int row = 0;
		PreparedStatement ps = null;
		if (sql == null || sql.equals("")) {
			return 0;
		} else {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			row = ps.executeUpdate();
			return row;
		}
	}

	public static void main(String[] args) throws SQLException {
		MyCrawler myCrawler = new MyCrawler("crawl", true);
		myCrawler.addSeed("http://news.sina.com.cn/");
		myCrawler.addRegex("http://blog.sina.com.cn/.*");
		myCrawler.addRegex("-http://blog.sina.com.cn/u/.*");
		myCrawler.addRegex("http://baby.sina.com.cn/.*");
		myCrawler.addRegex("-http://baby.sina.com.cn/zt_d/.*");
		myCrawler.addRegex("-.*\\.(jpg|png|gif).*");
		myCrawler.addRegex("-.*#.*");
		myCrawler.addRegex("-http://.+.sina.com.cn/.*/$");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/crawler?useUnicode=true&characterEncoding=UTF-8", "root", "");
			st = conn.createStatement();
		} catch (ClassNotFoundException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			myCrawler.setThreads(20);
			myCrawler.setMaxExecuteCount(10);
			myCrawler.start(2);
			System.out.println(n);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
