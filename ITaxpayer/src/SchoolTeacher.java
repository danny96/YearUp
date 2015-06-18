
public class SchoolTeacher implements ITaxPayer
{
private double m_income;
private boolean m_donePayingTaxes = false;

public SchoolTeacher(double income)
{
	setIncome(income);
}
	
	public double getIncome()
	{
		return m_income;
	}
	
	private void setIncome(double income)
	{
		m_income = income;
	}
	
	public void PayTaxes(double taxRate)
	{
		if (!m_donePayingTaxes)
		{
			double taxes = taxRate * getIncome();
			double newIncome = getIncome() - taxes;
			setIncome(newIncome);
			m_donePayingTaxes = true;
		}
		else
		{
			System.out.println("Taxes for this year are already paid.");
		}
		}

	public void FileTaxReturn()
	{
		if (m_donePayingTaxes)
		{
			System.out.println("SchoolTeacher has filed tax return.");
		}
		else
		{
			System.out.println("SchoolTeacher needs to pay taxes.");
		}
	}

	@Override
	public void PaysTaxes(double taxRate) {
		// TODO Auto-generated method stub
		
	}
}
