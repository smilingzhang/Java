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
	static TextArea  ta=new TextArea("���������ı�������һ���ļ�·������ʾ�����ļ������ݣ�\n");
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
		//�رմ����¼�
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public TestWindow() {
		// TODO �Զ����ɵĹ��캯�����
	}
}
class lis implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		String st=TestWindow.tf.getText().trim();//��ȡ�ı����е�����
		FileReader file4 = null;
		try {
			file4 = new FileReader(st);
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
			readFile(file4);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
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

