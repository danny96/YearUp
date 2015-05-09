
public class Dog {

	int m_numberOfPaws = -1;
	String m_furColor = null;
	
	Dog(int pawCount)
	{
		m_numberOfPaws = pawCount;
		m_furColor = "black";
	}
	
	Dog(int pawCount, String colorOfFur)
	{	
	    m_numberOfPaws = pawCount;
	    m_furColor = colorOfFur;
	}
	
	void Bark(String barkSound)
	{
		System.out.println(barkSound);
	}

	public static void main(String[] args)
	{
		
		int laylaPawCount = 4;
		Dog layla = new Dog(4);
		
		int sparkyPawCount = 3;
		Dog sparky = new Dog(sparkyPawCount, "sparkyFurColor");
		
		System.out.println("layla will bark now:");
		layla.Bark("ruff ruff");
		
		System.out.println("sparky will bark now:");
		sparky.Bark("squad");
	}
}