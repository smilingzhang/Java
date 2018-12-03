package Javademo1;
//获得了Person1这个(类)Class，进而通过返回的Class对象获取Person1的相关信息，比如：获取Person的构造方法，方法，属性有哪些等等信息。
public class GetClass {
	    public static void main(String[] args) {
	        Person1 p = new Person1(1,"刘德华");
	        System.out.println(p.getClass());  
	        System.out.println(p.getClass().getName()); 
	    }
}
class Person1{
    int id;
    String name;
    public Person1(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

}
/**
 * 创建对象： Person p = new Person(1,”刘德华”);
返回Class类型的对象： Class c = p.getClass(); 
此时c是Class类型，Class提供了一系列的方法来获取类的相关信息，可以通过对象c来获取Person的信息。比如，获取Person这个类的类名： 
String perName = c.getName();
 */
