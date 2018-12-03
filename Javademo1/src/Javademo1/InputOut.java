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
		// TODO �Զ����ɵĹ��캯�����
	}
	   private static void copy(File temp, String newpath) throws IOException {
			// TODO �Զ����ɵķ������
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
			// TODO �Զ����ɵ� catch ��
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
    	//1.һ���ֽ�һ���ֽڵĶ�ȡ,������ͼƬ��С
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}*/
    	//2.����һ���ֽڶ�ȡ��������ͼƬ��С
    /*	InputStream is=new FileInputStream(new File("D:\\360DownLoads\\timg.png"));
    	byte[] bs=new byte[512];
    	int sum=0;
    	int t;
    	while((t=is.read(bs))!=-1) {
    		System.out.println(new String(bs).toString());
    		sum+=t;
    	}
    	System.out.println(sum);*/
    	//3.ʵ��ͼƬ�Ŀ���
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
    	//4.�ı�ͼƬ�е�ĳһ������ĳһЩ�ֽ�
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
    	//5.�޸Ĵ��ı��ļ�ĳ������ĳЩ�ֽ�
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
    	//6.ͼƬ����������
		Scanner scanner=new Scanner(System.in);
		System.out.println("�������һ��Ŀ¼");
		String s1=scanner.nextLine();
		System.out.println("������ڶ���Ŀ¼");
		String s2=scanner.nextLine();
        copyPictures(s1,s2);
        System.out.println("�ļ��п����ɹ���");
    }
}
