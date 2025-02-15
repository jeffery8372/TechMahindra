// Task 2 : Write a java program to accept the students name and marks in subjects and find the total and average of the
// marks and sort the list accordingly
import java.util.*;
class Student {
    String name;
    int[] marks;
    int total;
    double average;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.total = Arrays.stream(marks).sum();
        this.average = (double) total / marks.length;
    }
}
public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        
        Student[] students = new Student[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            scanner.nextLine(); // Consume newline
            String name = scanner.nextLine();
            
            System.out.print("Enter number of subjects: ");
            int subjects = scanner.nextInt();
            
            int[] marks = new int[subjects];
            System.out.println("Enter marks for " + subjects + " subjects:");
            for (int j = 0; j < subjects; j++) {
                marks[j] = scanner.nextInt();
            }
            
            students[i] = new Student(name, marks);
        }
        
        Arrays.sort(students, (s1, s2) -> s2.total - s1.total);
        
        System.out.println("\nSorted List of Students by Total Marks:");
        System.out.printf("%-15s %-10s %-10s\n", "Name", "Total", "Average");
        for (Student s : students) {
            System.out.printf("%-15s %-10d %-10.2f\n", s.name, s.total, s.average);
        }
    }
}
