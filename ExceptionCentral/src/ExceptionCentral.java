
public class ExceptionCentral {

	public static void main(String[] args) {
		ExceptionCentral exceptionsCentral = new ExceptionCentral();
		
		try
		{
			exceptionsCentral.Divide(0, 0);
		}
		catch(Exception ex)
		{
			System.out.println("could not do the division");
			
		}
		
		exceptionsCentral.PrintSomething(null);
		int[] array = {1, 3};
		exceptionsCentral.PrintArrayValues(array);
	}
	
	int Divide(int number, int divisor) throws ArithmeticException
	{
		int quotient = number/divisor;
		return quotient;
		
	}
	
	void PrintSomething(String randomString) throws NullPointerException
	{
		String daniel = randomString.toUpperCase();
		System.out.println(daniel);
	}
	
	void PrintArrayValues(int[] array)
	{
		try
		{
			for(int i = 0; i < 10; i++)
			{
				System.out.println(array[i]);
			}
		}
		catch(ArrayIndexOutOfBoundsException arrayOOBEx)
		{			
			System.out.println("array passed in did not have 10 slots");
			arrayOOBEx.printStackTrace();
		}
		catch(NullPointerException nullPtrEx)
		{
			System.out.println("array passed in is null");
			nullPtrEx.printStackTrace();
		}		
	}
}


