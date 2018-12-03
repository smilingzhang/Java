package Javademo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import org.w3c.dom.ls.LSException;

public class QiMoFuXi{
   private void division(boolean b ){
           assert b?true:false:"insert error";
            System.out.println("is true" );
    }
    public static void main(String[] args) throws IOException{
       QiMoFuXi cal = new QiMoFuXi();
       cal.division(true);
       cal.division(false);
     ArrayList<Integer> list=new ArrayList<>();
     list.add(3);
     list.add(4);
     list.add(5);
     list.add(7);
    /* HashSet<String> hs=new HashSet<>();
     hs.add("aaa");
     hs.add("bbb");*/
    /*LinkedList< String> qu=new LinkedList<>();
     qu.offer("abc");
     qu.offer("def");*/
  //Iterator遍历
      InputStream in=new FileInputStream(new File("D://test.txt"));
      OutputStream os=new FileOutputStream(new File("D://1.txt"));
      byte[] b=new byte[255];
     int len;
     while((len=in.read(b))!=-1) {
    	   os.write(b,0,len);
     }
     os.flush();
     in.close();
    os.close();
    System.out.println("ok");
     
    /* FileReader fr=new FileReader(new File("D://test.txt"));
     FileWriter fw=new FileWriter(new File("D://1.txt"));
     BufferedReader buff=new BufferedReader(fr);
     BufferedWriter buff2=new BufferedWriter(fw);
  
     String s;
     while((s=buff.readLine())!=null) {
    	 buff2.write(s);
     }
     fw.flush();
     buff2.flush();
     fw.close();
     fr.close();
     buff.close();
     buff2.close();
     System.out.println("ok");*/
 /* Calendar c=Calendar.getInstance();
      
       Date d=c.getTime();
       System.out.println(d);*/
     //  SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      // SimpleDateFormat  sdf2=new SimpleDateFormat("yyyy年MM月dd日 hh点");
       // Date date = sdf.parse("2008-12-23 12:23:45");
  	/*   Date date=new Date();
	 System.out.println(date);

	 System.out.println(sdf2.format(date)); */ //输出2008年12月23日 12点
    


}
}
