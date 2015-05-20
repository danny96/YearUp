import java.util.Scanner;

public class DayOfWeek
{
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a new day of week:\n");
		String day = scanner.next();
		System.out.println("I read this day of week " + day);
		
		DayOfWeek dayOfWeekEvaluator = new DayOfWeek();
		dayOfWeekEvaluator.EvaluateDayOfWeek(day);
		
		scanner.close();		
	}
	
	void EvaluatedayOfWeekUsingSwitchStatement(String dayOfWeek)
	{
		if (dayOfWeek != null)
		{
			String lowerCaseDayOfWeek = dayOfWeek.toLowerCase();
			
			switch(dayOfWeek)
			{
			case("monday"):
			case("tuesday"):
			case("wednesday"):
			case("thursday"):
			case("frieday"):
			{
				System.out.println("It is a weekday, I have to go to work :(");
				break;
			}
			case("saturday"):
			case("sunday"):
			{
				System.out.println( "It is the weekend, yay!!! ");
				break;
			}
			
			}
		}
	}
	
	void EvaluateDayOfWeek(String dayOfWeek)
	{
		if (dayOfWeek != null)
		{
			if (dayOfWeek.equalsIgnoreCase("saturday")
			||dayOfWeek.equalsIgnoreCase("sunday"))
			{
				System.out.println(dayOfWeek + " it's the weekend!!! ");
			}
			else if (dayOfWeek.equalsIgnoreCase("monday")
					||dayOfWeek.equalsIgnoreCase("tuesday")
					||dayOfWeek.equalsIgnoreCase("wednesday")	
					||dayOfWeek.equalsIgnoreCase("thursday")		
					||dayOfWeek.equalsIgnoreCase("friday"))		
					
			{
				System.out.println(dayOfWeek + " is a weekday, I have to go to the store ");
			}
					else
			{

						System.out.println(" -____- it's not even a valid day!! ");
			}
					
		}
	}
}
	