package Javademo1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWrite extends FileWriter {
	
	public MyFileWrite(File arg0) throws IOException {
		super(arg0);
	}
	 public void write(String str) throws IOException {
	       super.write(str+"\n");
	    }//ʵ������д��������MyFileWrite�Ķ���ʱ���Ϳ���ֱ��ʵ���Զ�����
}
