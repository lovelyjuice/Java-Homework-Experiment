package homework;
import java.util.Scanner;
public class Division {

	public static void main(String[] args) 
	{
		int num1,num2;
		Scanner in=new Scanner(System.in);
		while(true)
		{
			try
			{
			System.out.print("Please input num1:");
			num1=in.nextInt();
			System.out.print("Please input num2:");
			num2=in.nextInt();
				System.out.println(num1/num2);
			}catch(ArithmeticException e)
			{
			System.out.println("The num2 you inputed equals 0!");
	//		in.next();
			}
		}
	}

}
