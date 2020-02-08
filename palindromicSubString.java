/**
 * prgm to print all palindromic string in a given string
 * abcacba = [a,b,c,a,c,b,a, abcacba]
 */
package leetcode;
import java.util.ArrayList;
/*Program to identify a palindromic String from a given user input string*/
// runs into infinite loop in some cases (like kayakmmnop)
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class palindromicSubString
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String a;
		System.out.println("enter a string:");
		a=sc.nextLine();
		System.out.println(palindrome(a));
	}
	public static ArrayList<List<Character>> palindrome(String a)
	{
		//int i,j;
		String single = null;
		a = a.replaceAll("\\s", ""); // remove all whitespaces
		
		/**
		 * Method 1 : using 2 for loops. this method fails if more than 1 substring is a palindrome
		 */
		/*String arr[]=new String[a.length()];
		String subset[]=new String[a.length()];
		
		for(i=0;i<a.length();i++) //use toCharArr instead
		{
			single=Character.toString(a.charAt(i));
			arr[i]=single;
			//System.out.println(arr[i]);
		}
		
		for(i=0;i<arr.length-1;i++)
		{
			//System.out.println("i value is:"+i);
			for(j=i+1;j<arr.length;j++)
			{
				if(arr[i].equals(arr[j])) // if element is found equal kayak is a great rotor
				{
					subset=Arrays.copyOfRange(arr, i, j+1); // make a subset array with those equal elements as 1st and last element
					System.out.print("\nthe subset is:");
					for(i=0;i<subset.length;i++)
					{
						System.out.print(subset[i]);
					}
					int start=0,end=subset.length-1;
					String reverse[]=new String[subset.length];
					while(end>=start) // reverse the subset array
					{
						String temp=subset[start];
						reverse[start]=subset[end];
						reverse[end]=temp;
						start++;end--;
					}
					System.out.print("\nthe reverse array is:");
					for(i=0;i<reverse.length;i++)
					{
						System.out.print(reverse[i]);
					}
					if(Arrays.equals(subset,reverse)) // check if subset array and reverese of it is equal
					{
						System.out.print("\nthe palindromic string is:");
						for(i=0;i<subset.length;i++)
						{
							System.out.print(subset[i]);
						}
					}
					else
					{
						System.out.println("\nno palindromic string in input");;
					}
				}
			}
		}*/	
		
		/**
		 * method 2 : use stack
		 */
	 	/* Stack<Character> stk = new Stack<Character>();
		 for (int i = 0; i < a.length(); i++)
		 {
			 if (stk.isEmpty() || stk.peek() != a.charAt(i))
			 {
				 System.out.println(a.charAt(i));
				 stk.push(a.charAt(i));
			 //} 
			 if(stk.firstElement() == a.charAt(i) || stk.peek() == a.charAt(i))
			 {
				 System.out.println(a.charAt(i));
				 stk.push(a.charAt(i));
				 //Object[] stkArray = stk.toArray() ;
				 char[] stkArray = stk.toString().toCharArray();
				 int end = stkArray.length - 1, start = 0;
				 char[] reverse = new char[stkArray.length];
				 while(end >= start) // reverse the stkarray
				 {
					char temp=stkArray[start];
					reverse[start]=stkArray[end];
					reverse[end]=temp;
					start++;end--;
				 }
				 stk.clear();
				 if(Arrays.equals(stkArray, reverse))
				 {
					 System.out.println("string is palindrome");
					 return stkArray.toString();
				 }
				 else
					 return "substring is not palindromic";
			 }
		 }
		return "not palindrome";	*/	
		
		/**
		 * method 3 : 1 for loop and an array list
		 * make 2D array of the string character array with one row repeating
		 * i did this just to use 2 for loops while keeping o(n) time complexity
		 * abcd string in 2D array =  a b c d
		 *							  a b c d
		 * and then compare the 1st row with 2nd (dont compare with self index)
		 */
		ArrayList<Character> list = new ArrayList<>();
		ArrayList<List<Character>> finalList = new ArrayList<>();
		char[][] TwoDimArr = new char[a.length()][a.length()];
		String s = "";
		
		//to make 2d array
		for (int i = 0; i < TwoDimArr.length; i++) 
		{
			for(int j = 0; j < TwoDimArr[i].length; j++)
			{
				TwoDimArr[i][j] = a.charAt(j);
			}
		}
		char[] chararr = a.toCharArray();
		int count = 0;
		for(char e :chararr)
		{
			s += e+",";
			count += 1;
		}
		
		for (int i = 0; i < TwoDimArr.length; i++) 
		{
			list.add(a.charAt(i));
			for(int j = i + 1; j < TwoDimArr[i].length; j++)
			{
				list.add(a.charAt(j));
				if(TwoDimArr[i][i] == TwoDimArr[i][j])
				{
					List<Character> copy = new ArrayList<>(list);
					Collections.reverse(copy);
					if(copy.equals(list))
					{
						finalList.add(list);
						s += list.toString() + ", ";
						count += 1;
					}
				}
			}
			list.clear();
		}
		//System.out.println(s);
		System.out.println(count);
		return finalList;
	}
}
