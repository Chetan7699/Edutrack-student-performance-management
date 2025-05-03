package student.beans;

public class Student
{
private Marks marks=new Marks();
private String rollNo;
private String name;
private String course;
private int totalMarks;
private double percentage;
private String result;

public Student()
{
	
}

public Marks getMarks() {
	return marks;
}

public void setMarks(Marks marks) {
	this.marks = marks;
}

public String getRollNo() {
	return rollNo;
}

public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCourse() {
	return course;
}

public void setCourse(String course) {
	this.course = course;
}

public int getTotalMarks() {
	return totalMarks;
}

public void setTotalMarks(int totalMarks) {
	this.totalMarks = totalMarks;
}

public double getPercentage() {
	return percentage;
}

public void setPercentage(double percentage) {
	this.percentage = percentage;
}

public String getResult() {
	return result;
}

public void setResult(String result) {
	this.result = result;
}



}
