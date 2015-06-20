
public class Lawyer extends Worker {

	public void DoWork()
	{
		System.out.println("I defend people in court.");
	}

	public static void main(String[] args) {
		
		Lawyer Daniel = new Lawyer();
		Daniel.DoWork();
		Programmer Uthra = new Programmer();
		Uthra.DoWork();
		Doctor Dre = new Doctor();
		Dre.DoWork();
		WebProgrammer John = new WebProgrammer();
		John.DoWork();
	}

}
