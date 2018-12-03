package Javademo1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//1.ƥ���ֻ���
		/*
		 * ���򣺴�½�ֻ��ţ�ǰ��λ�̶���ʽ+����8λ
		 * 13+���� 
		 * 15+��4�������������
		 * 18+�� 1 4
		 * 17+��9
		 * 147
		 * 
		 * ����ֻ��ţ�5 |6| 8| 9+����7λ
		 * */
//2.���֤���һλУ�����(18λ����ҪУ�飬15λ����Ҫ)
/*
 * ���֤�����һλ�Ǹ���ǰ17λ���ּ�������ļ����롣���㷽���ǣ������֤����ǰ17λ���ֱ���Բ�ͬ��ϵ����
 * �ӵ�1λ����17λ��ϵ���ֱ�Ϊ��7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2��
 * ���˻�֮�ͳ���11��        ��������Ϊ0 1 2 3 4 5 6 7 8 9 10�������������
 * �ֱ��Ӧ�����һλ���֤�ĺ���Ϊ1 0 X 9 8 7 6 5 4 3 2��
 * */
/**
 * 1)18λ���֤�ŵ�Ҫ��
 * ��һλ1-9�е�һ����ǰ��λ����ʡ���ص�����18xx-20xx�ꣻ��ݣ��·ݣ����ڣ���λ���֣���17λ�������������������һλ У��λ
 * 2��15λ���֤�ŵ�Ҫ��
 * ��һλ1-9�е�һ����ǰ��λ����ʡ���ص�������ݣ��·ݣ����ڣ���ά���֣���15λ��������������
 * */
public class ZhengZe {

	public ZhengZe() {
		// TODO �Զ����ɵĹ��캯�����
	}
	//ƥ���½�ֻ���
	public static boolean isLandandPhone(String s1) {
		String string="^((13[0-9])|(15[^4])|(18[0,1,2,3,5-9])|(17[^9])|147)\\d{8}$";
		Pattern p=Pattern.compile(string);//��������������ʽ�����ģʽ
		Matcher m=p.matcher(s1);
		return m.matches();
	}
	//ƥ������ֻ���
	public static boolean isHongkong(String s2) {
		String string ="^[5,6,8,9]\\d{7}$";
		/*Pattern p=Pattern.compile(string);
		Matcher m=p.matcher(s2);
		return m.matches();*/
		return Pattern.matches(string,s2);
	}
	public static boolean isLegal(String str) {
		return isLandandPhone(str)||isHongkong(str);
	}
	//ƥ���������
	public static boolean isEmail(String s) {
		String string="^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		return Pattern.matches(string, s);
	}
	//ƥ�����֤��
	public static boolean isIdNum(String s) {
		String string="(^[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|"+
	                  "(^[1-9]\\d{5}\\d{2}(0[1-9]|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
		return Pattern.matches(string, s);
	}
	//��֤18λ�����һλУ��λ
	public static boolean check(String s) {
		int sum=0;
		int a[]= {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		char b[]= {'1','0','X','9','8','7','6','5','4','3','2'};
		for(int i=0;i<s.length()-1;i++) {
			sum+=a[i]*(s.charAt(i)-48);
		}
		int j=sum%11;
		char code=b[j];
		char last=s.charAt(s.length()-1);
		if(code==last)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		
	/*	System.out.println("������,�ж��Ƿ�Ϸ���");
		Scanner s=new Scanner(System.in);
		String string=s.nextLine();
		//���18λУ�����һλ
		if(string.length()==18) {
			boolean b=isIdNum(string);
			if(b&&check(string)) {
				System.out.println("true");
			}
			else {
				System.out.println("false");
			}
		}
		else
			System.out.println(isIdNum(string));*/
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<10; i++){
		     //����������10��IntԪ��
		     list.add(i);
		}
		
		
		     System.out.print(list);
		
		
	}

}
