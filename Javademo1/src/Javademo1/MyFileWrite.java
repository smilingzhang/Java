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
	    }//实现了重写，当创建MyFileWrite的对象时，就可以直接实现自动换行
}
