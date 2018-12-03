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
import java.util.Scanner;

import javax.swing.Box.Filler;

public class FileManager {

	public FileManager() {
	}

	public static void main(String[] args) throws IOException {

		System.out.println("FileManager�����ڹ������ϵͳ������ļ����书�����£�");
		System.out.println("        --1.�ݹ���ʾ�ļ����ļ��㼶Ŀ¼--");
		System.out.println("        --2.�����ļ�--");
		System.out.println("        --3.ɾ���ļ�--");
		System.out.println("        --4.��ȡ�ļ�������--");
		System.out.println("        --5.��ָ������д���Ӧ�ļ�--");
		System.out.println("        --6.�޸��ļ�������--");
		System.out.println("        --7.�ļ��������ƶ�--");
		System.out.println("        --8.�ļ��п������ƶ�--");
		System.out.println("�������Ӧ�����ʵ����صĹ��ܣ�");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		switch (n) {
		case 1:
			System.out.println("������һ��·����");
			String name = scanner.nextLine();
			File file = new File(name);
			listPath(file);
			System.out.println("�����ѳɹ���");
			break;
		case 2:
			System.out.println("������Ҫ�����ļ���·����");
			String name2 = scanner.nextLine();
			File file2 = new File(name2);
			createFile(file2);
			System.out.println("�����ѳɹ���");
			break;
		case 3:
			System.out.println("��������ɾ���ļ����ڵ�·��:");
			String path = scanner.nextLine();
			File file3 = new File(path);
			delFile(file3);
			System.out.println("�����ѳɹ���");
			break;
		case 4:
			System.out.println("������Ҫ�����ļ���·����");
			String path2 = scanner.nextLine();
			FileReader file4 = new FileReader(path2);
			readFile(file4);
			System.out.println("�����ѳɹ���");
			break;
		case 5:
			System.out.println("������Ҫд���ļ���·����");
		    Scanner sc5 = new Scanner(System.in);
			String path3 = sc5.nextLine();
			System.out.println("�����뼸�У�");
			// ���뼸������
			int b = sc5.nextInt();
			String[] a = new String[b];
			System.out.println("�������ļ����ݣ�");
			for (int i = 0; i < b; i++) {
				a[i] = sc5.nextLine();
			}
			writeLineFile(path3, a);
			System.out.println("�����ѳɹ���");
			break;
		case 6:
			System.out.println("������һ��·����");
			Scanner sc6 = new Scanner(System.in);
			String pathname = sc6.nextLine();
			int length = pathname.length();
			File file6 = new File(pathname);
			System.out.println("�������µ��ļ����֣�");
			String newname = sc6.nextLine();
			file6.renameTo(
					new File(file6.getParent() + File.separator + newname + pathname.substring(length - 4, length)));
			System.out.println("�����ѳɹ���");
			break;
		case 7:
			Scanner sc7 = new Scanner(System.in);
			System.out.println("�����뱻�����ļ���");
			String name7 = sc7.nextLine();
			File fold = new File(name7);
			System.out.println("������Ŀ��Ŀ¼��");
			String newpath = sc7.nextLine();
			copy(fold, newpath);
			System.out.println("�����ѳɹ���");
			break;
		case 8:
			Scanner sc8 = new Scanner(System.in);
			System.out.println("������ԴĿ¼��");
			String oldname = sc8.nextLine();
			System.out.println("������Ŀ��Ŀ¼��");
			String nname = sc8.nextLine();
			copyFiles(oldname, nname);
			System.out.println("�����ѳɹ���");
			break;
		default:
			break;
		}
	}

	// 1.����·���ݹ���ʾ�ļ����ļ��㼶Ŀ¼
	public static void listPath(File file) {
		if (file.isDirectory()) {
			File[] list = file.listFiles();
			if (list != null) {
				for (int i = 0; i < list.length; i++) {
					listPath(list[i]);
				}
			}
		}
		System.out.println(file);
	}

	// 2.����ͨ�������������ļ�·����ϣ���������ļ����ƣ������ļ�
	public static void createFile(File file) {
		if (file.exists()) {
			System.out.println("�ļ�·����" + file.getAbsolutePath());
			System.out.println("�ļ���С(���ֽ�Ϊ��λ):" + file.length());
		} else {
			// �ȴ����ļ�����Ŀ¼
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�ļ������ɹ���");
		}
	}

	// 3.�ܹ�ͨ�������������ļ�·��ɾ���ļ�
	public static void delFile(File file) {
		while (true) {
			if (file.exists()) {
				file.delete();
				System.out.println("�ļ���ɾ����");
				break;
			} else {
				System.out.println("ɾ���ļ�����·����������ļ������ڣ����������룡");
			}
		}
	}

	// 4.�ܹ�ͨ��������ѡ��������ļ�·����ȡ�ļ�������
	public static void readFile(FileReader file) throws IOException {
		try {
			BufferedReader bfr = new BufferedReader(file);
			String string;
			while ((string = bfr.readLine()) != null) {
				System.out.println(string);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 5.�ܹ�ͨ��������ѡ��������ļ�·�����ļ������ݣ���ָ������д���Ӧ�ļ�
	public static void writeLineFile(String filename, String[] content) {
		try {
			FileWriter out = new FileWriter(filename, true);
			BufferedWriter bufWrite = new BufferedWriter(out);
			for (int i = 0; i < content.length; i++) {
				bufWrite.write(content[i] + "\r\n");
			}
			bufWrite.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 7.�ܹ�ͨ�������У������ļ�·����Ŀ��Ŀ¼��ʵ���ļ��������ƶ�
	public static void copy(File file, String path) throws IOException {
		FileInputStream in = new FileInputStream(file);
		File file2 = new File(path+File.separator+file.getName());
		FileOutputStream out = new FileOutputStream(file2);
		int len = 0;
		byte[] bytes = new byte[1024];
		while ((len = in.read(bytes)) != -1) {// ����ļ�δ����
			out.write(bytes, 0, len);
		}
		in.close();
		out.close();
	}

	// 8.�ܹ�ͨ�������У������ļ�Ŀ¼��Ŀ��Ŀ¼��ʵ���ļ��п������ƶ�
	public static void copyFiles(String oldPath, String newPath) throws IOException {
		File dir = new File(oldPath);
		newPath = newPath + File.separator + dir.getName();
		File movedir = new File(newPath);
		if (dir.isDirectory()) {
			if (!movedir.exists()) {
				movedir.mkdirs();
			}
		}
		// dir���Ŀ¼�µ��ļ���Ŀ¼��һ���ַ�������
		String[] file = dir.list();
		File temp = null;
		for (int i = 0; i < file.length; i++) {
			temp = new File(oldPath + File.separator + file[i]);
			if (temp.isFile()) {
				copy(temp, newPath);
			}
			if (temp.isDirectory()) {
				copyFiles(oldPath + File.separator + file[i], newPath);
			}
		}

	}

}
//3.File���list(FilenameFilter)�ķ�����ʹ��
		//����һ���ַ������飬��Щ�ַ���ָ���˳���·������ʾ��Ŀ¼������ָ�����������ļ���Ŀ¼
		/*File file=new File("D:\\360DownLoads");
		String[] filelist=file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".txt")) {
					return true;//���˳�
				}else {
					return false;//���˵�
				}
			}
			
		});
		
		for (int i = 0; i < filelist.length; i++) {
          System.out.println(filelist[i]);
      }*/
		/*File file2=new File("D:\\b\\cv.txt");
		file2.createNewFile();*/
		//4�ļ��Ĵ�����ɾ��
		//��ȡĳ���ļ���
     /* File f = new File("D:" + File.separator + "WORK");//separator���Ƿָ��� Windows���൱��\\Linux���൱��/
      if(f.isDirectory()){ //���D�����������ΪWORK���ļ��У�����ӡ��·��
          System.out.println(f.getPath());
      }*/
		
      //����Ϊ�����ļ�
    /*  String path = "D:" + File.separator + "TEST" + File.separator;
      String fileName = "MyFile.txt";
      File file = new File(path, fileName);
      System.out.println(path + fileName);
          if(file.exists()){
              System.out.println("�ļ�·����" + file.getAbsolutePath());
              System.out.println("�ļ���С��" + file.length());
              //ɾ���ļ�
              file.delete();
              System.out.println("�ļ���ɾ����");
          }else{
              //�ȴ����ļ�����Ŀ¼������ϵͳ�Ҳ���ָ����·����
              file.getParentFile().mkdirs();
              //�����ļ�
              file.createNewFile();
              System.out.println("�ļ������ɹ���");
          }*/
		//5.ʵ�������е��ļ�����ϵͳ(���� ��� File��Ļ�������) 
		/*//�Ե�ǰ·��������һ��File����
		File file=new File("D:\\360DownLoads\\Software");
		//ֱ�ӻ�ȡ�ļ�����
		System.out.println(file.getName());
		//��ȡ���·���ĸ�·��
		System.out.println(file.getParent());
		//��ȡ����·��
		System.out.println(file.getAbsolutePath());
		//��ȡ��һ��·��
		System.out.println(file.getAbsoluteFile().getParent());
		//�ڵ�ǰ·���´���һ�� ��ʱ�ļ�
		File temFile=File.createTempFile("aaa",".txt",file);
		//ָ��JVM�˳�ʱɾ���ļ�
		temFile.deleteOnExit();
		 //��ϵͳ��ǰϵͳʱ����Ϊ���ļ������������ļ�  
      File newFile=new File(System.currentTimeMillis()+"");  
      System.out.println("newFile�����Ƿ���ڣ�"+newFile.exists());  
      //��ָ��newFile����������һ���ļ�  
      newFile.createNewFile();  
      //��newFile����������һ��Ŀ¼����ΪnewFile�Ѵ��ڡ�  mkdirs�������Ŀ¼
      newFile.mkdir();  
      //ʹ��list()�������г���ǰ·���µ������ļ���·����  
      String[] fileList=file.list();  
      System.out.println("====��ǰ·���������ļ���·������====");  
      for(String fileName:fileList){  
          System.out.println(fileName);  
      }  
      //listRoots()��̬�����г����еĴ��̸�·��  
      File[] roots=File.listRoots();  
      System.out.println("====ϵͳ���и�·������====");  
      for(File root:roots){  
          System.out.println(root);  
      }  */





// 7.1��ʵ���ļ����ݿ������ƶ�
	/*
	 * System.out.print("������Դ�ļ�·����"); Scanner sc=new Scanner(System.in); String
	 * f1=sc.nextLine(); File file=new File(f1); System.out.println("������Ŀ��Ŀ¼��");
	 * String f2=sc.nextLine();
	 * 
	 * copyFile(file,f2);
	 */
	// 7.2����һ���ļ��ƶ�����һ���ļ����£�����
	/*
	 * File fold=new File("D:\\360DownLoads\\zhang.txt"); String
	 * newpath="D:\\360DownLoads\\Software\\"; File filenewpath=new File(newpath);
	 * if(filenewpath.exists()) { //filenewpath.mkdirs(); File file=new
	 * File(newpath+fold.getName()); fold.renameTo(file); }
	 * System.out.println("�ѳɹ���");
	 */


// 7.1��ʵ���ļ����ݵĿ����ƶ�
/*	public static void copyFile(File file1, String file2) throws IOException {
	File newfile = new File(file2);
	// �õ��ļ�������
	FileInputStream in = new FileInputStream(file1);
	// �õ��ļ������
	FileOutputStream out = new FileOutputStream(newfile);
	int len = 0;
	byte[] bytes = new byte[1024];
	while ((len = in.read(bytes)) != -1) {// ����ļ�δ����
		out.write(bytes, 0, len);
	}
	in.close();
	out.close();
}*/

//3.FileReader��FileWriter
//close()��ˢ�»�������Ȼ��֪ͨϵͳ�ͷ���Դ�������󲻿����ٱ�ʹ���ڹر�֮���ٴ�д�����ˢ�µĻ������׳�IOException�쳣
//flush();flushˢ�»������������󻹿��Լ���ʹ�ã��ѻ������е��ַ����浽Ŀ���ļ���ȥ

/* FileReader fr=new FileReader("D:\\360DownLoads\\1.txt");//ֻ�ܶ�ȡTXT��ߵ�����
//BufferedReader��������һ����װ�࣬�����԰�װ�ַ��������ַ������뻺����Ȱ��ַ��������������������
//������flush��ʱ���ٶ����ڴ棬����Ϊ���ṩ����Ч�ʶ���Ƶġ�
BufferedReader br=new BufferedReader(fr);
String s;
while((s=br.readLine())!=null) {
	 System.out.println(s);
}
fr.close();*/
/*
 * FileWriter fw=new FileWriter(path);�����ַ�������������Ѵ��ڵ��ļ������������ļ������ڣ�������
 * FileWriter fw=new FileWriter(String, boolean)...������������ø������ļ��Ĳ����Ƿ�Ϊ��д���ٴ�д��ʱ��
 * �ڽ�β��д�������Ḳ�ǵ�����
 * 
 * */
	/*FileWriter fw=new FileWriter("D:\\demo1.txt",false);
	fw.write("hello");
	fw.write("hhhhh");
	fw.flush();
	fw.close();*/
