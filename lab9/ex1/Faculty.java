package lab9.ex1;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;
	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}
	public Course getMaxPracticalCourse() {
		Course re = null;
		for(int i = 0; i < courses.size(); i++) {
			if(courses.get(i).quantityStudent() > re.quantityStudent() && courses.get(i).getType() == "TH") {
				re = courses.get(i);
			}
		}
		
		return re;	
	}
	public Map<Integer, List<Student>> groupStudentsByYear(){
        Map<Integer, List<Student>> map = new TreeMap<Integer, List<Student>>();
        for(int i = 0; i < courses.size(); i++) {
            for(int j = 0; j < courses.get(i).getStudents().size(); j++) {
                List<Student> list = map.get(courses.get(i).getStudents().get(j).getYear());
                if(list == null) {
                    list = (List<Student>) new TreeSet<Student>();
                    list.add(courses.get(i).getStudents().get(j));
                    map.put(courses.get(i).getStudents().get(j).getYear(), list);
                } else {
                    list.add(courses.get(i).getStudents().get(j));
                    map.put(courses.get(i).getStudents().get(j).getYear(), list);
                }
            }
        }
        return map;
	}
	public Set<Course> filterCourses(String type){
        Set<Course> set = new TreeSet<Course>();
        for(int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getType() == type) {
                set.add(courses.get(i));
            }
        }
        return set;
		
	}
    
}