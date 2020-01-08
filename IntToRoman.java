/**
 * @author Deep Chitroda
 *Program to convert Integer number(1-3999) into it's Roman equivalent
 */
import java.util.Scanner;
public class IntToRoman 
{
	private static int n,unit,count = 0;
	private static void ToRoman()
	{
		int a = n;
		while(a!=0)
		{
			a = a/10;
			count++;									
		}
		switch (count)
		{
			case 1: if (count == 1) //when number is 1 digit
			{
				UnitDigit();
				break;
			}
			case 2: if (count == 2) //when number is 2 digit
			{
				TensDigit();
				break;
			}
			case 3: if (count == 3) //when number is 3 digit
			{
				HundredsDigit();
				break;
			}
			case 4: if (count == 4) //when number is 4 digit
			{
				ThousandsDigit();
				break;
			}
			default:
			{
				System.out.println("\nInvalid number");
				break;
			}
		}
	}
	public static void UnitDigit()  //function to convert the units place digit to its Roman form
	{
		if(unit == 0)
		{
			//Do Nothing
		}
		if(unit == 1)
		{
			System.out.print("I");
		}
		if(unit == 2)
		{
			System.out.print("II");
		}
		if(unit == 3)
		{
			System.out.print("III");
		}
		if(unit == 4)
		{
			System.out.print("IV");
		}
		if(unit == 5)
		{
			System.out.print("V");
		}
		if(unit == 6)
		{
			System.out.print("VI");
		}
		if(unit == 7)
		{
			System.out.print("VII");
		}
		if(unit == 8)
		{
			System.out.print("VIII");
		}
		if(unit == 9)
		{
			System.out.print("IX");
		}
	}
	
	public static void TensDigit() //function to convert the tens place digit to its Roman form
	{
		int i=0;
		unit = n%10;
		int qt1 = (n/10);
		if (count == 3) 
		{
			qt1 =  (n/10) % 10;
		}
		if (count == 4) 
		{
			int temp = (n/10)%10; 
			qt1 = Integer.valueOf(String.valueOf(temp) + String.valueOf(unit)); 
			qt1/=10;
		}
		if(qt1 == 0)
		{
			UnitDigit();
		}
		if (qt1 >= 1 && qt1 < 4)
		{
			for(i=0; i<qt1; i++)
			{
				System.out.print("X");
			}
			UnitDigit();
		}
		else if (qt1 == 4)
		{
			System.out.print("XL");
			UnitDigit();
		}
		else if (qt1 == 5)
		{
			System.out.print("L");
			UnitDigit();
		}
		else if(qt1 > 5 && qt1 < 9)
		{
			System.out.print("L");
			for (i=5; i<qt1; i++)
			{
				System.out.print("X");
			}
			UnitDigit();
		}
		else if (qt1 == 9)
		{
			System.out.print("XC");
			UnitDigit();
		}
	}
	
	private static void HundredsDigit() //function to convert the hundreds place digit to its Roman form
	{
		int i=0;
		unit = n%10;
		int qt2 = n/10;
		if (count == 4) 
		{
			int temp = ((n/10)/10)%10;
			int temp1 = (n/10)%10; 
			qt2 = Integer.valueOf(String.valueOf(temp) + String.valueOf(temp1) + String.valueOf(unit));
			qt2/=10;
		}
		if (qt2 < 10)
		{
			TensDigit();
		}
		if(qt2 >= 10 && qt2 < 40)
		{
			for(i=0; i<qt2/10; i++)
			{
				System.out.print("C");
			}
			TensDigit();
		}
		if(qt2 >= 40 && qt2 < 50)
		{
			System.out.print("CD");
			TensDigit();
		}
		if(qt2 == 50)
		{
			System.out.print("D");
			TensDigit();
		}
		if (qt2 > 50 && qt2 < 90)
		{
			System.out.print("D");
			for(i=5; i<qt2/10; i++)
			{
				System.out.print("C");
			}
			TensDigit();
		}
		if(qt2 >= 90 && qt2 < 100)
		{
			System.out.print("CM");
			TensDigit();
		}
	}
	
	private static void ThousandsDigit()  //function to convert the thousands place digit to its Roman form
	{
		int i=0;
		unit = n%10;
		int qt3 = n/10;
		if(qt3 >= 100 && qt3 < 400)
		{
			for(i=0; i<(qt3/10)/10; i++)
			{
				System.out.print("M");
			}
			HundredsDigit();
		}
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an integer:");
		n=sc.nextInt();
		if (n > 0 && n < 4000)
		{
			System.out.print("The equivalent Roman is:");
			ToRoman();
		}
		else
		{
			System.out.println("Number invalid, enter a number between 1 and 3999");
		}
		sc.close();
	}
}
