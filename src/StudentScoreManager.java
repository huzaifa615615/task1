import java.util.Map;
import java.util.TreeMap;

public class StudentScoreManager {
    private TreeMap<String, Integer> studentScores;

    public StudentScoreManager() {
        studentScores = new TreeMap<>();
    }
    public void addOrUpdateScore(String name, int score) {
        studentScores.put(name, score);
        System.out.println("Score added/updated for " + name);
    }

    public void removeStudent(String name) {
        if (studentScores.remove(name) != null) {
            System.out.println(name + " removed successfully.");
        } else {
            System.out.println(name + " not found.");
        }
    }

    public Integer getScore(String name) {
        return studentScores.get(name);
    }
    public void displayAllStudents() {
        System.out.println("\nStudent Records:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public void displayStudentsInRange(String start, String end) {
        System.out.println("Students between \"" + start +
                "\" and \"" + end + "\":");

        Map<String, Integer> range =
                studentScores.subMap(start, true, end, true);

        if (range.isEmpty()) {
            System.out.println("No students found in this range.");
        } else {
            for (Map.Entry<String, Integer> entry : range.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
    public static void main(String[] args) {

        StudentScoreManager manager = new StudentScoreManager();

        manager.addOrUpdateScore("Alice", 85);
        manager.addOrUpdateScore("Bob", 92);
        manager.addOrUpdateScore("Charlie", 78);
        manager.addOrUpdateScore("David", 88);
        manager.addOrUpdateScore("Eve", 95);

        manager.displayAllStudents();

        System.out.println("Score of Bob: " +
                manager.getScore("Bob"));

        manager.addOrUpdateScore("Bob", 97);

        System.out.println("Updated score of Bob: " +
                manager.getScore("Bob"));

        manager.displayStudentsInRange("B", "D");

        manager.removeStudent("Charlie");

        manager.displayAllStudents();
    }
}