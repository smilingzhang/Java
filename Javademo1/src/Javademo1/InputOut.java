package Javademo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;



public class InputOut {

	public InputOut() {
		// TODO 自动生成的构造函数存根
	}
	   private static void copy(File temp, String newpath) throws IOException {
			// TODO 自动生成的方法存根
		   try {
			InputStream in=new FileInputStream(temp);
			File file=new File(newpath+File.separator+temp.getName());
			OutputStream out=new FileOutputStream(file);
			byte[] bs=new byte[1024];
			int t;
			while((t=in.read(bs))!=-1) {
				out.write(bs);
			}
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
			
		}
	public static void copyPictures(String oldpath,String newpath) throws IOException {
		File dir=new File(oldpath);
		newpath=newpath+File.separator+dir.getName();
		File movedir=new File(newpath);
		if(dir.isDirectory()) {
			if(!movedir.exists()) {
				movedir.mkdir();
			}
		}
		String file[]=dir.list();
		File temp=null;
		for(int i=0;i<file.length;i++) {
			temp=new File(oldpath+File.separator+file[i]);
			if(temp.isFile()) {
				copy(temp,newpath);
			}
			if(temp.isDirectory()) {
				copyPictures(oldpath+File.separator+file[i], newpath);
			}
		}
		
	}
 
	public static void main(String[] args) throws IOException {
    	//1.一个字节一个字节的读取,并计算图片大小
    	/*try {
			InputStream is=new FileInputStream(new File("D:\\360DownLoads\\timg.png"));
			int t;
			int sum=0;
			while((t=is.read())!=-1) {
				System.out.println(t);
				sum++;
			}
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}*/
    	//2.按照一组字节读取，并计算图片大小
    /*	InputStream is=new FileInputStream(new File("D:\\360DownLoads\\timg.png"));
    	byte[] bs=new byte[512];
    	int sum=0;
    	int t;
    	while((t=is.read(bs))!=-1) {
    		System.out.println(new String(bs).toString());
    		sum+=t;
    	}
    	System.out.println(sum);*/
    	//3.实现图片的拷贝
    	/*InputStream is=new FileInputStream(new File("D:\\360DownLoads\\timg.jpg"));
    	OutputStream os=new FileOutputStream(new File("D:\\360DownLoads\\copy.jpg"));
    	byte[] bs=new byte[512];
    	int t;
    	while((t=is.read(bs))!=-1) {
    		os.write(bs);
    	}
    	is.close();
    	os.close();*/
    	//
    	//4.改变图片中的某一个或者某一些字节
    	/*InputStream is=new FileInputStream(new File("D:\\360DownLoads\\timg.jpg"));
     	OutputStream os=new FileOutputStream(new File("D:\\360DownLoads\\copy.jpg"));
    	int t;
    	while((t=is.read())!=-1) {
    		if(t==10)
    			os.write(0);
    		else
    			os.write(t);
    	}
    	is.close();
    	os.close();*/
    	//5.修改纯文本文件某个或者某些字节
    	/*InputStream is=new FileInputStream(new File("D:\\360DownLoads\\test.txt"));
     	OutputStream os=new FileOutputStream(new File("D:\\360DownLoads\\copy.txt"));
    	int t;
    	while((t=is.read())!=-1) {
    		if(t==200) {
    			os.write(10);
    		}
    		else
    			os.write(t);
    	}
    	is.close();
    	os.close();*/
    	//6.图片的批量拷贝
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入第一个目录");
		String s1=scanner.nextLine();
		System.out.println("请输入第二个目录");
		String s2=scanner.nextLine();
        copyPictures(s1,s2);
        System.out.println("文件夹拷贝成功！");
    }
}
