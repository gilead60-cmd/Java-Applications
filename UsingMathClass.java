import java.util.Scanner;

public class UsingMathClass {
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter any negative number of your choice: ");
        int num1 = input.nextInt();
        
        System.out.printf("Enter any negative number of your choice: ");
        int num2 = input.nextInt();
        
        System.out.printf("Enter any negative number of your choice: ");
        int squareRootNum = input.nextInt();
        
		int castedSquareRootNum =(int) Math.sqrt(squareRootNum);
        // output
        System.out.printf("The absolute values are %d and %d%n", Math.abs(num1), Math.abs(num2));
        System.out.printf("The maximum number is %d%n", Math.max(num1, num2));
        System.out.printf("The minimum number is %d%n", Math.min(num1, num2));
		System.out.printf("The square root of the number is %f%n",castedSquareRootNum);
    }
}