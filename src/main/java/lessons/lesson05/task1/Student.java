package lessons.lesson05.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person {
    // course itself and grade
    private Map<Course, Integer> grades = new HashMap<>();
    // attendance for course => list of boolean (attended or not)
    private Map<Course, List<Boolean>> attendance = new HashMap<>();

    public Student(String name, String email) {
        super(name, email);
    }

    public void markAttendance(Course course, boolean attend) {
        attendance.computeIfAbsent(course, newCourse -> new ArrayList<>()).add(attend);
    }

    public void addGrade(Course course, int grade) {
        grades.put(course, grade);
    }

    @Override
    public void getFullInfo() {
        System.out.println("Student name: " + getName() + ", email: " + getEmail());
    }
}
