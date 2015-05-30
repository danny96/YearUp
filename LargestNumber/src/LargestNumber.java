
public class LargestNumber 
{

	public static void main(String[] args) 
	{
		int[] array1 = {85, 29, 34, 110, 43};
		int[] array2 = {};
		int[] array3 = null;
		LargestNumberUsingForLoop(array1);
		LargestNumberUsingForLoop(array2);
		LargestNumberUsingForLoop(array3);
		LargestNumberUsingWhileLoop(array1);
		LargestNumberUsingWhileLoop(array2);
		LargestNumberUsingWhileLoop(array3);
		// I think I should only have 
	}

	public static void LargestNumberUsingWhileLoop(int[] inputArray)
	{
		if (inputArray !=null)
		{
			if (inputArray.length > 0)
			{
				int largestNumber = inputArray[0];
				int i = 0;
				
				while (i <inputArray.length)
				{
					if (largestNumber < inputArray[i])
					{
						largestNumber = inputArray[i];
					}
					i++;
				}
System.out.println("The largest number that I found is:" + largestNumber);
				
			}
			else
			{
				System.out.println("This array does not even have any numbers");
			
			}
			// a second "else" belongs here but i can't understand why i keep getting the error message
			{
				System.out.println("You gave me a null array");// i think i get two print statements because it doesn't have "else" on it
			}
		}
	
	}
	public static void LargestNumberUsingForLoop(int[] inputArray)
	{
		if (inputArray !=null)
		{
			if (inputArray.length > 0)
			{
				int largestNumber = inputArray[0];
				
				for (int i = 0;i < inputArray.length; i++)
				{
					if (largestNumber < inputArray[i])
					{
						largestNumber = inputArray[i];
					}
				}
				
				System.out.println("The largest number that I found is:" + largestNumber);
				
			}
			else
			{
				System.out.println("This array does not even have any numbers");
			
			}
			// a second "else" belongs here but i don't understand why i keep getting an error message
			{
				System.out.println("You gave me a null array");// i get two print statements for this since it doens't have an "else on it
			}
		}
	}
}
