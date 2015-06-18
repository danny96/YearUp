
public class TaxAuditor {

	public void Audit(ITaxPayer taxpayer)
	{
		System.out.println("Audited" + taxpayer.getClass());
	}
}