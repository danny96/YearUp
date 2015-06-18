
public class Banker implements ITaxPayer
{
	private double m_income;
	private boolean m_donePayingTaxes = false;
	
	public Banker(double income)
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
				System.out.println("Banker has filed tax return.");
			}
			else
			{
				System.out.println("Banker needs to pay taxes before filing return.");
			}
		}

	@Override
	public void PaysTaxes(double taxRate) {
		// TODO Auto-generated method stub
		
	}
	}
	

