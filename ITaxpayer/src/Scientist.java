
public class Scientist implements ITaxPayer
{
	private double m_income;
	private boolean m_donePayingTaxes = false;

	public Scientist(double income)
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
			System.out.println("Scientist has filed tax return.");
		}
		else
		{
			System.out.println("Scientist needs to pay taxes before filing return.");
		}
	}

	public static void main(String[] args)
	{
		Scientist blankfein = new Scientist (90000);
		blankfein.PayTaxes(.33);
		blankfein.FileTaxReturn();

		SchoolTeacher doblar = new SchoolTeacher (50000);
		doblar.PayTaxes(.23);
		doblar.FileTaxReturn();

		Banker hawking = new Banker(120000);
		hawking.PaysTaxes(.28);
		hawking.FileTaxReturn();

		TaxAuditor stanley = new TaxAuditor();
		stanley.Audit(blankfein);
		stanley.Audit(doblar);
		stanley.Audit(hawking);

	}

	@Override
	public void PaysTaxes(double taxRate) {
		// TODO Auto-generated method stub
		
	}
		
	}

