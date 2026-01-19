import java.util.Scanner;

/*
 * Task 3: Control Flow Based Student Result System
 */

public class StudentResultSystem {

    // Method to calculate percentage
    static double calculatePercentage(int totalMarks, int subjects) {
        return (double) totalMarks / subjects;
    }

    // Method to assign grade using if-else
    static char assignGrade(double percentage) {
        if (percentage >= 90) return 'A';
        else if (percentage >= 75) return 'B';
        else if (percentage >= 60) return 'C';
        else if (percentage >= 40) return 'D';
        else return 'F';
    }

    // Method to display grade meaning using switch
    static void displayGradeMeaning(char grade) {
        switch (grade) {
            case 'A':
                System.out.println("Grade A: Excellent");
                break;
            case 'B':
                System.out.println("Grade B: Very Good");
                break;
            case 'C':
                System.out.println("Grade C: Good");
                break;
            case 'D':
                System.out.println("Grade D: Pass");
                break;
            case 'F':
                System.out.println("Grade F: Fail");
                break;
            default:
                System.out.println("Invalid Grade");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Student Result Processing System ===");

        while (true) {

            System.out.print("\nEnter Student Name: ");
            String name = sc.next();

            int totalMarks = 0;
            int subjects = 3;

            // Loop for subject marks
            for (int i = 1; i <= subjects; i++) {
                System.out.print("Enter marks for subject " + i + ": ");
                int marks = sc.nextInt();

                // Validation logic
                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks! Please enter between 0 and 100.");
                    i--;        // repeat same subject
                    continue;   // skip remaining code
                }

                totalMarks += marks;
            }

            double percentage = calculatePercentage(totalMarks, subjects);
            char grade = assignGrade(percentage);

            // Final result summary
            System.out.println("\n--- Result Summary ---");
            System.out.println("Student Name: " + name);
            System.out.printf("Percentage: %.2f%%\n", percentage);
            System.out.println("Grade: " + grade);
            displayGradeMeaning(grade);

            // Multiple student entry option
            System.out.print("\nDo you want to enter another student? (yes/no): ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("no")) {
                break; // exit loop
            }
        }

        sc.close();
        System.out.println("\nProgram Ended. Thank you!");
    }
}
