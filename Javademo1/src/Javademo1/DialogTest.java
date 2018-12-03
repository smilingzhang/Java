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
		/*Frame f=new Frame("测试窗口");
		//设置窗口大小
		f.setBounds(30,30,250,200);
		//将窗口显示出来
		f.setVisible(true);*/
		
		//2.AWT容器
		/*Frame f=new Frame("测试页面");
		Panel p=new Panel();
		p.add(new TextField(30));
        f.add(p);
        f.setBounds(30,30,250,120);
        f.setVisible(true);*/
		
		//3.FlowLayout布局管理器
		/* Frame f = new Frame("测试窗口");
	        // 设置Frame使用FlowLayout布局管理器
	        f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));//用指示的对齐和指示的水平和垂直间隙创建新的流布局管理器。
	        // 向窗口添加10个按钮
	        for (int i = 0;i<10;i++) {
	            f.add(new Button("Button"+i));
	        }
	        // 设置窗口为最佳大小
	        f.pack();
	        f.setVisible(true);*/
		
		//4.BorderLayout布局管理器
		/*Frame f = new Frame("测试窗口");
        // 设置Frame容器使用BorderLayout布局管理器
        f.setLayout(new BorderLayout(50,50));//水平间隙和垂直间隙
        f.add(new Button("S"),SOUTH);
        f.add(new Button("N"),NORTH);
        // 默认添加到中间区域
        f.add(new Button("M"));
        f.add(new Button("E"),EAST);
        f.add(new Button("W"),WEST);

        f.pack();
        f.setVisible(true);*/
        
        //5.GirdLayout布局管理器
       /* Frame f = new Frame("计算器");
        Panel p1 = new Panel();
        p1.add(new TextField(30));
        f.add(p1); // import static java.awt.BorderLayout.*;
        Panel p2 = new Panel();
        f.setLayout(new GridLayout(3,5,4,4));//行数，列数，水平 垂直间隙
        String[] name = {"0","1","2","3","4","5","6","7","8","9","+","-","*","/","."};
        for (int i = 0;i<name.length;i++) {
            f.add(new Button(name[i]));
        }
        f.add(p2);
        f.pack();
        f.setVisible(true);*/
		
		//6.对话框
		
		
	}

}
 
