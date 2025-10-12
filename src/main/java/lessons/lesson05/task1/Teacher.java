package lessons.lesson05.task1;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private String subject;
    private List<Course> courses = new ArrayList<>();

    public Teacher(String name, String email, String subject) {
        super(name, email);
        this.subject = subject;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    @Override
    public void getFullInfo() {
        System.out.println("Teacher name: " + getName() + ", email: " + getEmail());
    }
}
