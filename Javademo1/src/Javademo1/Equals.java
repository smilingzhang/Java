package Javademo1;



public class Equals {
	//类的属性
	/*public String name;
	public String ID;
	public float grade;
    //方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
    //构造函数
	public Std(String name, String iD, float grade) {
		this.name = name;
		ID = iD;
		this.grade = grade;//this为指向本身的引用
	}
    //toString()方法，当输出一个对象时，java默认调用对象的toString()方法，得到的时全限定名@地址首地址,
	//如果写上toString()，则会输出具体的属性值
	@Override//代表重写（子类重写父类）父类为object
	public String toString() {
		return "name is:"+this.name+"ID is:"+this.ID+"grade is:"+this.grade;
	}*/
	public static void main(String[] args) {
		//1.equals方法
		//1）对于字符串变量，==比较的是两个对象在内存中的首地址，equals比较的是字符串中所包含的内容
		
		/*  String s1,s2,s3="abc",s4="abc";
		 s1=new String("abc");
		 s2=new String("abc");
		 s1.equals(s2);*/
		 // s1==s2时是false   s1.equals(s2)是true
		 
		//2）对于
		/*StringBuffer s1 = new StringBuffer("a");
	    StringBuffer s2 = new StringBuffer("a"); 
	    StringBuffer类中没有重新定义equals这个方法，因此这个方法就来自Object类，而Object类中的equals方法是用来比较“地址”的，
	    所以等于false.
	    对于s3和s4来说，有一点不一样要引起注意，由于s3和s4是两个字符串常量所生成的变量，其中所存放的内存地址是相等的，
	    所以s3==s4是true
	    3）对于非字符串变量，==和equals方法都是比较堆对象在堆内存的首地址
	   class A

{

     A obj1   =   new  A();

     A obj2   =   new  A();


}obj1==obj2是false,obj1.equals(obj2)是false
但是如加上这样一句：obj1=obj2;那么,obj1==obj2是true,obj1.equals(obj2)是true。
	    */
		
		

	}

}
