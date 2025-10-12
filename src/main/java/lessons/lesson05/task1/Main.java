package lessons.lesson05.task1;

// 🚀 Пример работы системы
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Test testov", "test@mail.com", "Java-core");
        Course course = new Course("Java basics", teacher);

        Student student1 = new Student("bob", "bob@gmail.com");
        Student student2 = new Student("john", "john@gmail.com");

        course.addStudent(student1);
        course.addStudent(student2);

        course.markAttendance(student1, true);
        course.markAttendance(student2, false);

        course.addGrade(student1, 17);
        course.addGrade(student2, 82);

        teacher.getFullInfo();

        student1.getFullInfo();
        student2.getFullInfo();
    }
}