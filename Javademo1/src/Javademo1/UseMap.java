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
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) throws IOException {

		FileReader fr = new FileReader("D:\\360DownLoads\\4CET.txt");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String string;
		Map<String, String> map = new HashMap<String, String>();
		// 1. ��Map������ļ�����
		while ((string = br.readLine()) != null) {
			map.put(string.substring(0, string.indexOf(" ")),
					string.substring((string.indexOf(" ") + 1), string.length()));
		}
		
		// 2.����Map
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		/*
		 * while(iterator.hasNext()) { 
		 * 	Map.Entry<String, String> entry=iterator.next();
		 *	System.out.println(entry.getKey()+" "+entry.getValue()); }
		 */

		// 3.��������ĸ��ͷ�ĵ���
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("������Ҫƥ����ַ�����");
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
			System.out.println("��ƥ�䣡");
		}
	}
}
