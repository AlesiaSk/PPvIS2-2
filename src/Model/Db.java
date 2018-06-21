package Model;

import java.util.ArrayList;
import java.util.List;

public class Db {
	public List<Student> students = new ArrayList<Student>();
	
	public List<Student> getStud() {
		return students;
	}
	
	public Student getOne(int ind) {
		return students.get(ind);
	}
	
	public void addStud(Student student) {
		students.add(student);
	}
	
	public void deleteStud(Student student) {
		students.remove(student);
	}

}