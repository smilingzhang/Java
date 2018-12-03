package javaconfig;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration()
@ComponentScan("javaconfig")
public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		//»ùÓÚJavaµÄÅäÖÃ
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Test.class);
		Computer pc=(Computer)ctx.getBean("computer");
		pc.play();
	}
}
