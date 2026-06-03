import java.util.TreeMap;
import java.util.TreeSet;

public class CourseEnrollmentManager {

    private TreeMap<String, TreeSet<String>> courses;

    public CourseEnrollmentManager() {
        courses = new TreeMap<>();
    }
    public void addStudentToCourse(String course, String studentName) {

        courses.putIfAbsent(course, new TreeSet<>());

        courses.get(course).add(studentName);

        System.out.println(studentName +
                " enrolled in " + course);
    }


    public void removeStudentFromCourse(String course, String studentName) {

        if (courses.containsKey(course)) {

            if (courses.get(course).remove(studentName)) {
                System.out.println(studentName +
                        " removed from " + course);
            } else {
                System.out.println(studentName +
                        " is not enrolled in " + course);
            }
        } else {
            System.out.println("Course not found.");
        }
    }
    public boolean isStudentEnrolled(String course,
                                     String studentName) {

        return courses.containsKey(course)
                && courses.get(course).contains(studentName);
    }
    public void displayCourseRoster(String course) {

        if (!courses.containsKey(course)) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println("\nStudents enrolled in " + course + ":");

        for (String student : courses.get(course)) {
            System.out.println(student);
        }
    }
    public static void main(String[] args) {

        CourseEnrollmentManager manager =
                new CourseEnrollmentManager();

        manager.addStudentToCourse("Java", "Alice");
        manager.addStudentToCourse("Java", "Bob");
        manager.addStudentToCourse("Java", "Charlie");

        manager.addStudentToCourse("Database", "David");
        manager.addStudentToCourse("Database", "Eve");

        manager.displayCourseRoster("Java");

        System.out.println("Is Bob enrolled in Java? " + manager.isStudentEnrolled("Java", "Bob"));

        manager.removeStudentFromCourse("Java", "Bob");

        System.out.println(
                "Is Bob enrolled in Java? " + manager.isStudentEnrolled("Java", "Bob"));

        manager.displayCourseRoster("Java");
    }
}