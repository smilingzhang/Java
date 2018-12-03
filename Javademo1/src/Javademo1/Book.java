//修饰符的作用范围
package Javademo1;

public class Book {
	private int pageNum;
	public String bookName;
	String bookAuthor;//默认为包权限
	protected int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	/*public Book(int pageNum, String bookName, String bookAuthor) {
		super();
		this.pageNum = pageNum;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}*/
	@Override//代表重写，子类重写父类
	public String toString() {
		return "the book's page is:"+pageNum+"  "+"the book's name is:"+bookName+"  "+"the book's author is:"+bookAuthor+"the age is:"+age;
	}
	public void display() {
		System.out.println("page is:"+pageNum+"name is:"+bookName+"author is:"+bookAuthor);
	}
	//类内调用类的属性 方法
	@SuppressWarnings("null")
	public static void main(String[] args) {
		/*String b = "chun",c = "zhuziqing";
		Book a=new Book(20,b,c);
		System.out.println(a);*/
		Book m = new Book();
		m.pageNum=15;
		m.bookName="jingse";
		m.bookAuthor="kangde";
		System.out.println(m);
		
	}
	//在包内调用，不同类之间调用，在Dome类调用Book的方法
}



