package Javademo1;
//�����Person1���(��)Class������ͨ�����ص�Class�����ȡPerson1�������Ϣ�����磺��ȡPerson�Ĺ��췽������������������Щ�ȵ���Ϣ��
public class GetClass {
	    public static void main(String[] args) {
	        Person1 p = new Person1(1,"���»�");
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
 * �������� Person p = new Person(1,�����»���);
����Class���͵Ķ��� Class c = p.getClass(); 
��ʱc��Class���ͣ�Class�ṩ��һϵ�еķ�������ȡ��������Ϣ������ͨ������c����ȡPerson����Ϣ�����磬��ȡPerson������������ 
String perName = c.getName();
 */
