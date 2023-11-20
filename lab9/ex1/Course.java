package lab9.ex1;

import java.util.Comparator;
import java.util.List;

public class Course implements Comparator<Course>{
	private String id;
	private String name;
	private String type;
	private List<Student> students;
	private String lecturer;
	public Course(String id, String name, String type, List<Student> students, String lecturer) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}
    @Override
    public int compare(Course o1, Course o2) {
        return o1.quantityStudent() - o2.quantityStudent();
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public int quantityStudent() {
		return students.size();
	}
	
}