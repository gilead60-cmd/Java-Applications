import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
		
        Scanner input = new Scanner(System.in);
		
		double bal = 200000000.98;
		
		
		System.out.print("Enter your firstName: ");
		String firstName = input.nextLine();
		
		
		System.out.print("Enter your lastName: ");
		String lastName = input.nextLine();
		
		System.out.printf("Enter your age: ");
		short age = input.nextShort();
		
		System.out.printf("Welcome %s %s to FirstBank%n", firstName,lastName);
		System.out.printf("You are %d years old%n", age);
		System.out.printf("Your account balance is $%.2f%n",bal);
	}
}