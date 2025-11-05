import java.util.Scanner;

public class NumberCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        
        System.out.println("Enter numbers (enter -1 to stop):");

        while (true) {
            System.out.print("Enter number: ");
            int number = scanner.nextInt();
            
            // Sentinel check
            if (number == -1) {
                break;
            }
            
            if (number > 0) {
                positiveCount++;
            } else if (number < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
        
        System.out.println("\nResult:");
        System.out.println("Positive numbers: " + positiveCount);
        System.out.println("Negative numbers: " + negativeCount);
        System.out.println("Zeros: " + zeroCount);
        
        scanner.close();
    }
}