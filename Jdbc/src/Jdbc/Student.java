package Jdbc;

public class Student {
	private  int id;
	private  String name;
	private  float grade;
    
   
	public  int getId() {
		return id;
	}


	public  void setId(int id) {
		this.id = id;
	}


	public  String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public  float getGrade() {
		return grade;
	}


	public  void setGrade(float grade) {
		this.grade = grade;
	}
    
	public Student() {
		// TODO 自动生成的构造函数存根
	}
    public String toString() {
    	return "the student's id is"+"["+this.id+"]"+"the student's name is"+"["+this.name+"]"+"the student's grade is"+"["+this.grade+"]";
    }
 
}
