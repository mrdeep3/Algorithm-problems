import java.util.Arrays;

/**
 * Program to swap integers in array such that even number precedes odd numbers in minimum swaps
 * [12,1,17,6,9] should o/p to = [12,6,17,1,9] => ans is 1 as it took 1 swap to sort the array in reqd way. [6,12,17,1,9] is also valid
 * @author Deep Chitroda
 *
 */
public class customArraySwap 
{
	public static boolean checkArrayFormat(int[] outputArr)
	{
		int odd_count = 0, even_count = 0;
		for(int i = 0; i<outputArr.length; i++)
		{
			if(outputArr[i] %2 == 0)
			{
				even_count++;
			}
			if(outputArr[i] %2 != 0)
			{
				break;
			}
		}
		for(int j = outputArr.length-1; j > 0; j--)
		{
			if(outputArr[j ]%2 != 0)
			{
				odd_count++;
			}
			if(outputArr[j] %2 == 0)
			{
				break;
			}
		}
		if((odd_count + even_count) == outputArr.length)
		{
			return true;
		}
		return false;
	}
	public static int swap(int[] arr)
	{
		int count=0, temp = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] % 2 != 0)
			{
				for(int j = arr.length-1; j > 0; j--)
				{
					if(arr[j] % 2 == 0)
					{
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
						count++;
						//j++;
						break;
					}
				}
			}
			//check if array in req format
			if(checkArrayFormat(arr) == true)
			{
				System.out.println("correct format");
				break;
			}
		}
		for (int i : arr) {
			System.out.print(i+",");
		}
		System.out.println();
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1,2,3,4, 10}; //ans for this shud be 2
		System.out.println("the count is "+swap(arr));
	}

}
