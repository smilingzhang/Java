package Javademo1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//Date���Calendar��
import java.util.Date;

public class ShowTime {

	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("��ǰʱ��Ϊ��"+date);//date����洢����ʱ���
		
		//simpleDateFormat��ʽ��
		SimpleDateFormat si=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
		System.out.println(si.format(date));
		
		Calendar calendar=Calendar.getInstance();
		System.out.println("��ǰʱ���ǣ�"+calendar.getTime());//���ϱߵ�ִ�н��һ��
		
		//Calendar����ʵ��������ʱ����ķֿ���ӡ
		int mouth=calendar.get(calendar.MONTH);//mouth�ȵ�ǰ��Сһ����
		int a=mouth+1;
		System.out.println("��ǰʱ��Ϊ��"+calendar.get(calendar.YEAR)+"��"+a
		+"��"+calendar.get(calendar.DAY_OF_MONTH)+"��"+calendar.get(calendar.HOUR_OF_DAY)+//hour of day����24Сʱ�� 19��  �����hour����12Сʱ����ʾ������19�����ʾ7��
		"ʱ"+calendar.get(calendar.MINUTE)+"��"+calendar.get(calendar.SECOND)+"��");
	}

}
