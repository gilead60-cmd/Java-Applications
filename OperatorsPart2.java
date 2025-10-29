public class OperatorsPart2{
    public static void main(String[] args){
	
	int num1 = 30;
	int num2 = 35;
	int num3 = 17;
	
	//AND logical operator
	
	boolean result = (num1 > num2) && (num1 > num3);
	System.out.printf("The result is %b%n",result);
	
	//OR logical operator
		boolean result2 = (num1 > num2) || (num1 > num3);
	System.out.printf("The result is %b%n",result2);
	
	//NOT logical operator
		boolean result3 = !((num1 > num2) && (num1 > num3));
	System.out.printf("The result is %b%n",result3);
	
	// Pre-increment unary operator
	int num4 = 10;
		
	System.out.printf("%d%n",num4);
	System.out.printf("%d%n", ++num4);
	
	//Post-increment unary operator
	int num5 = 10;
		
	System.out.printf("%d%n",num5);
	System.out.printf("%d%n", num5++);
	
	System.out.printf("%d%n",num5);
	
		// Pre-decrement unary operator
	int num6 = 10;
		
	System.out.printf("%d%n",num4);
	System.out.printf("%d%n", --num4);
	
	//Post-decrement unary operator
	int num7 = 10;
		
	System.out.printf("%d%n",num5);
	System.out.printf("%d%n", num5--);
	System.out.printf("%d%n", num5);
	
	
	}
}