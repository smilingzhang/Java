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

		System.out.println("FileManager类用于管理操作系统的相关文件，其功能如下：");
		System.out.println("        --1.递归显示文件及文件层级目录--");
		System.out.println("        --2.创建文件--");
		System.out.println("        --3.删除文件--");
		System.out.println("        --4.读取文件的内容--");
		System.out.println("        --5.把指定内容写入对应文件--");
		System.out.println("        --6.修改文件的名字--");
		System.out.println("        --7.文件拷贝，移动--");
		System.out.println("        --8.文件夹拷贝，移动--");
		System.out.println("请输入对应的序号实现相关的功能：");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		switch (n) {
		case 1:
			System.out.println("请输入一个路径：");
			String name = scanner.nextLine();
			File file = new File(name);
			listPath(file);
			System.out.println("运行已成功！");
			break;
		case 2:
			System.out.println("请输入要创建文件的路径：");
			String name2 = scanner.nextLine();
			File file2 = new File(name2);
			createFile(file2);
			System.out.println("运行已成功！");
			break;
		case 3:
			System.out.println("请输入所删除文件所在的路径:");
			String path = scanner.nextLine();
			File file3 = new File(path);
			delFile(file3);
			System.out.println("运行已成功！");
			break;
		case 4:
			System.out.println("请输入要读的文件的路径：");
			String path2 = scanner.nextLine();
			FileReader file4 = new FileReader(path2);
			readFile(file4);
			System.out.println("运行已成功！");
			break;
		case 5:
			System.out.println("请输入要写的文件的路径：");
		    Scanner sc5 = new Scanner(System.in);
			String path3 = sc5.nextLine();
			System.out.println("请输入几行：");
			// 输入几行文字
			int b = sc5.nextInt();
			String[] a = new String[b];
			System.out.println("请输入文件内容：");
			for (int i = 0; i < b; i++) {
				a[i] = sc5.nextLine();
			}
			writeLineFile(path3, a);
			System.out.println("运行已成功！");
			break;
		case 6:
			System.out.println("请输入一个路径：");
			Scanner sc6 = new Scanner(System.in);
			String pathname = sc6.nextLine();
			int length = pathname.length();
			File file6 = new File(pathname);
			System.out.println("请输入新的文件名字：");
			String newname = sc6.nextLine();
			file6.renameTo(
					new File(file6.getParent() + File.separator + newname + pathname.substring(length - 4, length)));
			System.out.println("运行已成功！");
			break;
		case 7:
			Scanner sc7 = new Scanner(System.in);
			System.out.println("请输入被拷贝文件：");
			String name7 = sc7.nextLine();
			File fold = new File(name7);
			System.out.println("请输入目的目录：");
			String newpath = sc7.nextLine();
			copy(fold, newpath);
			System.out.println("运行已成功！");
			break;
		case 8:
			Scanner sc8 = new Scanner(System.in);
			System.out.println("请输入源目录：");
			String oldname = sc8.nextLine();
			System.out.println("请输入目的目录：");
			String nname = sc8.nextLine();
			copyFiles(oldname, nname);
			System.out.println("运行已成功！");
			break;
		default:
			break;
		}
	}

	// 1.给出路径递归显示文件及文件层级目录
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

	// 2.可以通过命令行输入文件路径及希望常见的文件名称，创建文件
	public static void createFile(File file) {
		if (file.exists()) {
			System.out.println("文件路径：" + file.getAbsolutePath());
			System.out.println("文件大小(以字节为单位):" + file.length());
		} else {
			// 先创建文件所在目录
			file.getParentFile().mkdirs();
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("文件创建成功！");
		}
	}

	// 3.能够通过命令行输入文件路径删除文件
	public static void delFile(File file) {
		while (true) {
			if (file.exists()) {
				file.delete();
				System.out.println("文件已删除！");
				break;
			} else {
				System.out.println("删除文件所在路径错误或者文件不存在，请重新输入！");
			}
		}
	}

	// 4.能够通过命令行选项给出的文件路径读取文件的内容
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

	// 5.能够通过命令行选项给出的文件路径及文件的内容，把指定内容写入对应文件
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

	// 7.能够通过命令行，输入文件路径及目标目录，实现文件拷贝，移动
	public static void copy(File file, String path) throws IOException {
		FileInputStream in = new FileInputStream(file);
		File file2 = new File(path+File.separator+file.getName());
		FileOutputStream out = new FileOutputStream(file2);
		int len = 0;
		byte[] bytes = new byte[1024];
		while ((len = in.read(bytes)) != -1) {// 如果文件未读完
			out.write(bytes, 0, len);
		}
		in.close();
		out.close();
	}

	// 8.能够通过命令行，输入文件目录及目标目录，实现文件夹拷贝，移动
	public static void copyFiles(String oldPath, String newPath) throws IOException {
		File dir = new File(oldPath);
		newPath = newPath + File.separator + dir.getName();
		File movedir = new File(newPath);
		if (dir.isDirectory()) {
			if (!movedir.exists()) {
				movedir.mkdirs();
			}
		}
		// dir这个目录下的文件和目录的一个字符串数组
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
//3.File类的list(FilenameFilter)的方法的使用
		//返回一个字符串数组，这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录
		/*File file=new File("D:\\360DownLoads");
		String[] filelist=file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".txt")) {
					return true;//过滤出
				}else {
					return false;//过滤掉
				}
			}
			
		});
		
		for (int i = 0; i < filelist.length; i++) {
          System.out.println(filelist[i]);
      }*/
		/*File file2=new File("D:\\b\\cv.txt");
		file2.createNewFile();*/
		//4文件的创建和删除
		//获取某个文件夹
     /* File f = new File("D:" + File.separator + "WORK");//separator就是分隔符 Windows中相当于\\Linux中相当于/
      if(f.isDirectory()){ //如果D盘下面存在名为WORK的文件夹，则会打印出路径
          System.out.println(f.getPath());
      }*/
		
      //以下为创建文件
    /*  String path = "D:" + File.separator + "TEST" + File.separator;
      String fileName = "MyFile.txt";
      File file = new File(path, fileName);
      System.out.println(path + fileName);
          if(file.exists()){
              System.out.println("文件路径：" + file.getAbsolutePath());
              System.out.println("文件大小：" + file.length());
              //删除文件
              file.delete();
              System.out.println("文件已删除！");
          }else{
              //先创建文件所在目录，否则系统找不到指定的路径。
              file.getParentFile().mkdirs();
              //创建文件
              file.createNewFile();
              System.out.println("文件创建成功！");
          }*/
		//5.实现命令行的文件管理系统(输入 输出 File类的基本操作) 
		/*//以当前路径来创建一个File对象
		File file=new File("D:\\360DownLoads\\Software");
		//直接获取文件名字
		System.out.println(file.getName());
		//获取相对路径的父路径
		System.out.println(file.getParent());
		//获取绝对路径
		System.out.println(file.getAbsolutePath());
		//获取上一级路径
		System.out.println(file.getAbsoluteFile().getParent());
		//在当前路径下创建一个 临时文件
		File temFile=File.createTempFile("aaa",".txt",file);
		//指定JVM退出时删除文件
		temFile.deleteOnExit();
		 //以系统当前系统时间作为新文件名来创建新文件  
      File newFile=new File(System.currentTimeMillis()+"");  
      System.out.println("newFile对象是否存在："+newFile.exists());  
      //以指定newFile对象来创建一个文件  
      newFile.createNewFile();  
      //以newFile对象来创建一个目录，因为newFile已存在。  mkdirs创建多个目录
      newFile.mkdir();  
      //使用list()方法来列出当前路径下的所有文件和路径。  
      String[] fileList=file.list();  
      System.out.println("====当前路径下所有文件和路径如下====");  
      for(String fileName:fileList){  
          System.out.println(fileName);  
      }  
      //listRoots()静态方法列出所有的磁盘根路径  
      File[] roots=File.listRoots();  
      System.out.println("====系统所有根路径如下====");  
      for(File root:roots){  
          System.out.println(root);  
      }  */





// 7.1）实现文件内容拷贝，移动
	/*
	 * System.out.print("请输入源文件路径："); Scanner sc=new Scanner(System.in); String
	 * f1=sc.nextLine(); File file=new File(f1); System.out.println("请输入目标目录：");
	 * String f2=sc.nextLine();
	 * 
	 * copyFile(file,f2);
	 */
	// 7.2）把一个文件移动到另一个文件夹下，剪切
	/*
	 * File fold=new File("D:\\360DownLoads\\zhang.txt"); String
	 * newpath="D:\\360DownLoads\\Software\\"; File filenewpath=new File(newpath);
	 * if(filenewpath.exists()) { //filenewpath.mkdirs(); File file=new
	 * File(newpath+fold.getName()); fold.renameTo(file); }
	 * System.out.println("已成功！");
	 */


// 7.1）实现文件内容的拷贝移动
/*	public static void copyFile(File file1, String file2) throws IOException {
	File newfile = new File(file2);
	// 得到文件输入流
	FileInputStream in = new FileInputStream(file1);
	// 得到文件输出流
	FileOutputStream out = new FileOutputStream(newfile);
	int len = 0;
	byte[] bytes = new byte[1024];
	while ((len = in.read(bytes)) != -1) {// 如果文件未读完
		out.write(bytes, 0, len);
	}
	in.close();
	out.close();
}*/

//3.FileReader和FileWriter
//close()先刷新缓冲区，然后通知系统释放资源，流对象不可以再被使用在关闭之后，再次写入或者刷新的话，会抛出IOException异常
//flush();flush刷新缓冲区，流对象还可以继续使用，把缓冲区中的字符保存到目的文件中去

/* FileReader fr=new FileReader("D:\\360DownLoads\\1.txt");//只能读取TXT里边的内容
//BufferedReader这个类就是一个包装类，它可以包装字符流，将字符流放入缓存里，先把字符读到缓存里，到缓存满了
//或者你flush的时候，再读入内存，就是为了提供读的效率而设计的。
BufferedReader br=new BufferedReader(fr);
String s;
while((s=br.readLine())!=null) {
	 System.out.println(s);
}
fr.close();*/
/*
 * FileWriter fw=new FileWriter(path);创建字符输出流类对象和已存在的文件相关联，如果文件不存在，并创建
 * FileWriter fw=new FileWriter(String, boolean)...相关联，并设置该流对文件的操作是否为续写（再次写入时，
 * 在结尾续写，而不会覆盖掉，）
 * 
 * */
	/*FileWriter fw=new FileWriter("D:\\demo1.txt",false);
	fw.write("hello");
	fw.write("hhhhh");
	fw.flush();
	fw.close();*/
