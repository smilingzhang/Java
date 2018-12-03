package Javademo1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UseMap  {

	public UseMap() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("D:\\360DownLoads\\4CET.txt");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String string;
		Map<String, String> map = new HashMap<String, String>();
		// 1. 向Map中添加四级单词
		while ((string = br.readLine()) != null) {
			map.put(string.substring(0, string.indexOf(" ")),
					string.substring((string.indexOf(" ") + 1), string.length()));
		}
		
		// 2.遍历Map
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		/*
		 * while(iterator.hasNext()) { 
		 * 	Map.Entry<String, String> entry=iterator.next();
		 *	System.out.println(entry.getKey()+" "+entry.getValue()); }
		 */

		// 3.遍历首字母开头的单词
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入要匹配的字符串：");
		String sc = scanner.nextLine();
		Map.Entry<String, String> entry;
		int count = 0;
		while (iterator.hasNext()) {
			entry = iterator.next();
			if (sc.length() > (entry.getKey()).length()) {
				entry = iterator.next();
			} else {
				if (((entry.getKey()).substring(0, sc.length()).equals(sc))) {
					count = 1;
					System.out.println(entry.getKey() + " " + entry.getValue());
				}
			}
		}
		if (count == 0) {
			System.out.println("无匹配！");
		}
	}
}
