package Javademo1;

public class Jicheng {

	public Jicheng() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) {
		/*Per p=new Teacher();
		p.display();*/
		
		String a = "Hello"; 
		System.out.println(a);
		a.replace('e','f');
		System.out.println(a);
	}

}
 class  Per {
	private int age;

	public static void run() {
		System.out.println("hello word");
	}
	public void display() {
		System.out.println("person");
	}
}
class Teacher extends Per{
	private int add;
	public void dis() {
		System.out.println("teacher");
	}
	public void display() {
		System.out.println("teacher2");
	}
	
}