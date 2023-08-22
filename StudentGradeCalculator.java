import java.util.*;

public class StudentGradeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) 
        {
        	System.out.print("Enter marks for subject " + i + ": ");
            System.out.println();

            int marks = scanner.nextInt();
            if (marks < 0 || marks > 100) 
            {
                System.out.println("Invalid marks");
                return;
            }
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        String grade;
        if (averagePercentage >= 90) 
        {
            grade = "A";
        } 
        else if (averagePercentage >= 80) 
        {
            grade = "B";
        } 
        else if (averagePercentage >= 70) 
        {
            grade = "C";
        } 
        else if (averagePercentage >= 60) 
        {
            grade = "D";
        } 
        else if (averagePercentage >= 50) 
        {
            grade = "E";
        } 
        else 
        {
            grade = "F";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println();
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println();
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}