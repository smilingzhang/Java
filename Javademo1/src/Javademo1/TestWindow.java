package Javademo1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
public class TestWindow {
	static TextField tf=new TextField();
	static TextArea  ta=new TextArea("请在下列文本框输入一个文件路径，显示所找文件的内容：\n");
	public static void main(String[] args) {
		Frame f=new Frame();
		ta.setBackground(Color.CYAN);
		tf.setBackground(Color.CYAN);
		f.setLayout(new BorderLayout());
		f.add(tf,BorderLayout.SOUTH);
		f.add(ta,BorderLayout.NORTH);
		f.setVisible(true);
		f.pack();
		tf.addActionListener(new lis());
		//关闭窗口事件
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public TestWindow() {
		// TODO 自动生成的构造函数存根
	}
}
class lis implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		String st=TestWindow.tf.getText().trim();//获取文本框中的内容
		FileReader file4 = null;
		try {
			file4 = new FileReader(st);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			readFile(file4);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static void readFile(FileReader file) throws IOException {
		try {
			BufferedReader bfr = new BufferedReader(file);
			String string;
			while ((string = bfr.readLine()) != null) {
				TestWindow.ta.append(string);
				TestWindow.ta.append("\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

