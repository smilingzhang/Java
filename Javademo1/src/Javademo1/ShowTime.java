package Javademo1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//Date类和Calendar类
import java.util.Date;

public class ShowTime {

	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("当前时间为："+date);//date本身存储的是时间戳
		
		//simpleDateFormat格式化
		SimpleDateFormat si=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		System.out.println(si.format(date));
		
		Calendar calendar=Calendar.getInstance();
		System.out.println("当前时间是："+calendar.getTime());//和上边的执行结果一样
		
		//Calendar可以实现年月日时分秒的分开打印
		int mouth=calendar.get(calendar.MONTH);//mouth比当前月小一个月
		int a=mouth+1;
		System.out.println("当前时间为："+calendar.get(calendar.YEAR)+"年"+a
		+"月"+calendar.get(calendar.DAY_OF_MONTH)+"日"+calendar.get(calendar.HOUR_OF_DAY)+//hour of day就是24小时的 19点  如果是hour就是12小时的显示，晚上19点就显示7点
		"时"+calendar.get(calendar.MINUTE)+"分"+calendar.get(calendar.SECOND)+"秒");
	}

}
