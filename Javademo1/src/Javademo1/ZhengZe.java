package Javademo1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//1.匹配手机号
		/*
		 * 规则：大陆手机号：前三位固定格式+任意8位
		 * 13+任意 
		 * 15+除4以外的任意数字
		 * 18+除 1 4
		 * 17+除9
		 * 147
		 * 
		 * 香港手机号：5 |6| 8| 9+任意7位
		 * */
//2.身份证最后一位校验规则(18位的需要校验，15位不需要)
/*
 * 身份证的最后一位是根据前17位数字计算出来的检验码。计算方法是：将身份证号码前17位数分别乘以不同的系数。
 * 从第1位到第17位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2；
 * 将乘积之和除以11，        余数可能为0 1 2 3 4 5 6 7 8 9 10。则根据余数，
 * 分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
 * */
/**
 * 1)18位身份证号的要求
 * 第一位1-9中的一个，前六位代表省市县地区；18xx-20xx年；年份；月份；日期；三位数字（第17位奇数代表男生），最后一位 校验位
 * 2）15位身份证号的要求
 * 第一位1-9中的一个，前六位代表省市县地区；年份；月份；日期；三维数字（第15位奇数代表男生）
 * */
public class ZhengZe {

	public ZhengZe() {
		// TODO 自动生成的构造函数存根
	}
	//匹配大陆手机号
	public static boolean isLandandPhone(String s1) {
		String string="^((13[0-9])|(15[^4])|(18[0,1,2,3,5-9])|(17[^9])|147)\\d{8}$";
		Pattern p=Pattern.compile(string);//将给定的正则表达式编译成模式
		Matcher m=p.matcher(s1);
		return m.matches();
	}
	//匹配香港手机号
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
	//匹配电子邮箱
	public static boolean isEmail(String s) {
		String string="^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		return Pattern.matches(string, s);
	}
	//匹配身份证号
	public static boolean isIdNum(String s) {
		String string="(^[1-9]\\d{5}(18|19|20)\\d{2}(0[1-9]|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|"+
	                  "(^[1-9]\\d{5}\\d{2}(0[1-9]|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
		return Pattern.matches(string, s);
	}
	//验证18位的最后一位校验位
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
		
	/*	System.out.println("请输入,判断是否合法：");
		Scanner s=new Scanner(System.in);
		String string=s.nextLine();
		//针对18位校验最后一位
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
		     //给数组增加10个Int元素
		     list.add(i);
		}
		
		
		     System.out.print(list);
		
		
	}

}
