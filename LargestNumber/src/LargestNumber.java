import java.util.ArrayList;


public class LargestNumber 
{

	public static void main(String[] args) 
	{
		int[] array = new array {85, 29, 34, 110, 43};
		
		

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
			{
				System.out.println("You gave me a null array");
			}
		}
	}
}
