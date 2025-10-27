import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
		
        Scanner input = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String firstName = input.nextLine();
		
		System.out.printf("Hello %s", firstName);
		
	}
}