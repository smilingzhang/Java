package Javademo1;

public class DialogTest {

	private static final Object SOUTH = null;
	private static final Object NORTH = null;
	private static final Object EAST = null;
	private static final Object WEST = null;
	public DialogTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		/*Frame f=new Frame("���Դ���");
		//���ô��ڴ�С
		f.setBounds(30,30,250,200);
		//��������ʾ����
		f.setVisible(true);*/
		
		//2.AWT����
		/*Frame f=new Frame("����ҳ��");
		Panel p=new Panel();
		p.add(new TextField(30));
        f.add(p);
        f.setBounds(30,30,250,120);
        f.setVisible(true);*/
		
		//3.FlowLayout���ֹ�����
		/* Frame f = new Frame("���Դ���");
	        // ����Frameʹ��FlowLayout���ֹ�����
	        f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));//��ָʾ�Ķ����ָʾ��ˮƽ�ʹ�ֱ��϶�����µ������ֹ�������
	        // �򴰿����10����ť
	        for (int i = 0;i<10;i++) {
	            f.add(new Button("Button"+i));
	        }
	        // ���ô���Ϊ��Ѵ�С
	        f.pack();
	        f.setVisible(true);*/
		
		//4.BorderLayout���ֹ�����
		/*Frame f = new Frame("���Դ���");
        // ����Frame����ʹ��BorderLayout���ֹ�����
        f.setLayout(new BorderLayout(50,50));//ˮƽ��϶�ʹ�ֱ��϶
        f.add(new Button("S"),SOUTH);
        f.add(new Button("N"),NORTH);
        // Ĭ����ӵ��м�����
        f.add(new Button("M"));
        f.add(new Button("E"),EAST);
        f.add(new Button("W"),WEST);

        f.pack();
        f.setVisible(true);*/
        
        //5.GirdLayout���ֹ�����
       /* Frame f = new Frame("������");
        Panel p1 = new Panel();
        p1.add(new TextField(30));
        f.add(p1); // import static java.awt.BorderLayout.*;
        Panel p2 = new Panel();
        f.setLayout(new GridLayout(3,5,4,4));//������������ˮƽ ��ֱ��϶
        String[] name = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/","."};
        for (int i = 0;i<name.length;i++) {
            f.add(new Button(name[i]));
        }
        f.add(p2);
        f.pack();
        f.setVisible(true);*/
		
		//6.�Ի���
		
		
	}

}
 
