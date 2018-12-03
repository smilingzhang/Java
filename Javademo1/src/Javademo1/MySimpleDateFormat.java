package Javademo1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MySimpleDateFormat {
    public void display() {
    	Date date=new Date();
		SimpleDateFormat si=new SimpleDateFormat("yyyyÄêMMÔÂddÈÕ HH:mm:ss");
		System.out.println(si.format(date));
    }
	public static void main(String[] args) {
		MySimpleDateFormat m=new MySimpleDateFormat();
		m.display();
	}

}

