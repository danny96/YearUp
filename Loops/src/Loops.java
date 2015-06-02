
public class Loops {

	public static void main(String[] args) 
	{
		int[] array1 = {23, 24, 23, 27};
		int searchvalue = 24;
		int number1= 23;
		int number2= 24;
		int number3= 27;
		problemOne(array1, 23);
		searchOccurences(array1, 23);
		searchOccurences(array1, 24);
		searchOccurences(array1, 25);
	}



public static void problemOne (int[] array, int searchvalue)
{
	for (int i = 0;i < array.length; i++)
	{
		if(array[i] == searchvalue)
		{
			System.out.println("The value is" + array[i]);
		}
			break;}
		
		}
		
public static void searchOccurences (int[] array, int number)
{ 
	int numberofoccurences = 0;
	for (int i = 0; i < array.length; i++)
	{
		if (array[i] == number)
		{
			numberofoccurences++;
		}
	}
	System.out.println("Found" + number + "in array" + numberofoccurences + "times");
}
	}


