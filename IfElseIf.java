import java.util.Scanner;

public class IfElseIf{
   public static void main(String[] args){
	   
	   // Scanner object has been created
	   Scanner input = new Scanner(System.in);
	   
	   //variable declaration
	   int mark;
	   String fullName;
	   
	   //prompt user for input
	   System.out.print("Enter your full name");
	   fullName = input.nextLine();
	   
	   System.out.print("Enter your mark: ");
	   mark = input.nextInt();	

       
       if(mark >= 80){
		   System.out.printf("FullName: %s, Mark: %d your grade is A",fullName,mark);
	   }	   
	  else if(mark >= 75){
		   System.out.printf("FullName: %s, Mark: %d your grade is B",fullName,mark);
	  }
	  else if(mark >= 65){
		   System.out.printf("FullName: %s, Mark: %d your grade is C",fullName,mark);
	  }
	  else if(mark >= 55){
		   System.out.printf("FullName: %s, Mark: %d your grade is D",fullName,mark);
	  }
	  else if(mark >= 45){
		   System.out.printf("FullName: %s, Mark: %d your grade is E",fullName,mark);
	  }
		   else{
			   System.out.printf("FullName: %s, Mark: %d Your grade is F",fullName,mark);
		   }
}

} 