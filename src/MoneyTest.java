import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	protected Currency CAD, HKD, NOK, EUR;
	protected Money CAD100, EUR10, CAD200, EUR20, CAD0, EUR0, CADnegative100;
	
	@Before
	public void setUp() throws Exception {
		// setup sample currencies
		CAD = new Currency("CAD", 0.75);
		HKD = new Currency("HKD", 0.13);
		EUR = new Currency("EUR", 1.14);
		
		// setup sample money amounts
		CAD100 = new Money(100, CAD);
		
		EUR10 = new Money(10, EUR);
		CAD200 = new Money(200, CAD);
		EUR20 = new Money(20, EUR);
		CAD0 = new Money(0, CAD);
		EUR0 = new Money(0, EUR);
		CADnegative100 = new Money(-100, CAD);
	}

	@Test
	public void testGetAmount() {
		assertEquals(10,EUR10.getAmount(),0.001);
	}

	@Test
	public void testGetCurrency() {
		assertEquals(EUR,EUR10.getCurrency());
	}

	@Test
	public void testToString() {
		assertEquals("10.0 EUR",EUR10.toString());
	}

	@Test
	public void testGetUniversalValue() {
		assertEquals(150,CAD200.getUniversalValue(),0.001);
	}

	@Test
	public void testEqualsMoney() {
		assertEquals(200,CAD200.getAmount(),0.001);
	}

	@Test
	public void testAdd() {
		Money newMoney = new Money(300,CAD);
		assertEquals(newMoney.getAmount(),CAD200.add(CAD100).getAmount(),0.001);
		
	}

	@Test
	public void testSubtract() {
		Money newMoney = new Money(100,CAD);
		assertEquals(newMoney.getAmount(),CAD200.subtract(CAD100).getAmount(),0.001);
	}

	@Test
	public void testIsZero() {
		assertEquals(0,CAD0.getAmount(),0.001);
	}

	@Test
	public void testNegate() {
		Money newMoney = new Money(-200,CAD);
		assertEquals(newMoney.getAmount(),CAD200.negate().getAmount(),0.001);
	}

	@Test
	public void testCompareTo() {
		assertEquals(0,CAD200.compareTo(CAD200),0.001);
		assertEquals(1,CAD200.compareTo(CAD0),0.001);
		assertEquals(-1,CAD0.compareTo(CAD200),0.001);
	}
}
