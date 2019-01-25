import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
	protected Currency CAD, HKD;
	protected Bank TD;
	protected Bank HSBC;
	protected Bank RBC;
	protected Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		
		// setup test currencies
		CAD = new Currency("CAD", 0.75);
		RBC = new Bank("Royal Bank of Canada", CAD);
		
		// setup test accounts
		RBC.openAccount("Peter");
		testAccount = new Account("Albert", CAD);
		testAccount.deposit(new Money(100, CAD));

		// setup an initial deposit
		RBC.deposit("Peter", new Money(500, CAD));
	}

	@Test
	public void testAddWithdraw() {
		// Something to consider - can you withdraw in a different currency?
		try {
			RBC.withdraw("Peter", new Money(10,CAD));
			assertEquals(490,RBC.getBalance("Peter"),0.001);
		} catch (AccountDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(100,testAccount.getBalance().getAmount(),0.001);
	}
}
