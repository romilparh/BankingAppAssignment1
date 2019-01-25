import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	protected Currency CAD;
	protected Currency HKD;
	protected Bank RBC;
	protected Bank TD;
	protected Bank HSBC;
	
	
	@Before
	public void setUp() throws Exception {
		
		// setup some test currencies
		this.HKD = new Currency("HKD", 0.13);
		this.CAD = new Currency("CAD", 0.75);
		
		// setup test banks
		this.RBC = new Bank("Royal Bank of Canada", CAD);
		this.TD = new Bank("TD Bank", CAD);
		this.HSBC = new Bank("Hong Kong Shanghai Banking Corporation", HKD);
		
		// add sample customers to the banks
		
		
		// HINT:  uncomment these lines AFTER you test the openAccount() function
		// You can quickly uncomment / comment by highlighting the lines of code and pressing 
		// CTRL + / on your keyboard  (or CMD + / for Macs)
		
//		this.RBC.openAccount("Marcos");
//		this.RBC.openAccount("Albert");
//		this.TD.openAccount("Jigesha");
//		this.HSBC.openAccount("Pritesh");
	}

	@Test
	public void testGetName() {
		assertEquals("Royal Bank of Canada",RBC.getName());
	}

	@Test
	public void testGetCurrency() {
		assertEquals(CAD,RBC.getCurrency());
	}

	@Test
	public void testOpenAccount() throws AccountExistsException, AccountDoesNotExistException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		RBC.openAccount("Peter");
		assertEquals(0,RBC.getBalance("Peter"),0.001);
		
		// Fails because account doesn't get created
	}

	@Test
	public void testDeposit() throws AccountDoesNotExistException, AccountExistsException{
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		RBC.openAccount("Peter");
		RBC.deposit("Peter", new Money(100,CAD));
		assertEquals(100,RBC.getBalance("Peter"),0.001);
	}

	@Test
	public void testWithdraw() throws AccountDoesNotExistException, AccountExistsException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		RBC.openAccount("Peter");
		RBC.withdraw("Peter", new Money(100,CAD));
		assertEquals(0,RBC.getBalance("Peter"),0.001);
	}
	
	@Test
	public void testGetBalance() throws AccountDoesNotExistException, AccountExistsException {
		// If the function throws an exception, you should also test
		// that the exception gets called properly.
		
		// See the example in class notes for testing exceptions.
		
		RBC.openAccount("Peter");
		assertEquals(0,RBC.getBalance("Peter"),0.001);
	}
	
	@Test
	public void testTransfer() throws AccountDoesNotExistException,AccountExistsException {
		// Note: You should test both types of transfers:
		// 1. Transfer from account to account
		// 2. Transfer between banks
		// See the Bank.java file for more details on Transfers
		RBC.openAccount("Peter");
		TD.openAccount("Sha");
		RBC.deposit("Peter", new Money(100,CAD));
		RBC.transfer("Peter", TD, "Sha", new Money(100,CAD));
		assertEquals(0,RBC.getBalance("Peter"),0.001);
	}
	
}
