package lessons.lesson05.task1;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        teacher.addCourse(this);
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added");
    }

    public void markAttendance(Student student, boolean attend) {
        student.markAttendance(this, attend);
    }

    public void addGrade(Student student, int grade) {
        student.addGrade(this, grade);
    }
}
