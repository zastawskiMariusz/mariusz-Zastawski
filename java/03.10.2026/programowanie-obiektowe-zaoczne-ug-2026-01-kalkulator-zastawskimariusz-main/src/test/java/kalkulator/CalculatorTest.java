
package kalkulator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

	@Test
	public void shouldAddNumbers() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new AddOperation(), 5);

		assertEquals(15, test.getState());
	}

	@Test
	public void shouldMultiplyNumbers() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new MultiplyOperation(), 4);

		assertEquals(40, test.getState());
	}

	@Test
	public void shouldDivideNumbers() {
		kalkulator test = new kalkulator();
		test.setState(15);

		test.execute(new DivideOperation(), 3);

		assertEquals(5, test.getState());
	}

	@Test
	public void shouldCalculatePower() {
		kalkulator test = new kalkulator();
		test.setState(2);

		test.execute(new PowerOperation(), 3);

		assertEquals(8, test.getState());
	}

	@Test(expected = ArithmeticException.class)
	public void shouldThrowExceptionWhenDividingByZero() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new DivideOperation(), 0);
	}

	@Test
	public void shouldSaveAndRestoreMemory() {
		kalkulator test = new kalkulator();
		test.setState(25);

		test.ms();
		test.setState(10);
		test.mr();

		assertEquals(25, test.getState());
	}

	@Test
	public void shouldClearMemory() {
		kalkulator test = new kalkulator();
		test.setState(25);

		test.ms();
		test.mc();
		test.setState(10);
		test.mr();

		assertEquals(0, test.getState());
	}

	@Test
	public void shouldOverwriteMemory() {
		kalkulator test = new kalkulator();
		test.setState(10);
		test.ms();

		test.setState(30);
		test.ms();

		test.setState(0);
		test.mr();

		assertEquals(30, test.getState());
	}

	@Test
	public void shouldAddValueToMemory() {
		kalkulator test = new kalkulator();
		test.setState(10);
		test.ms();

		test.setState(5);
		test.mPlus();

		test.setState(0);
		test.mr();

		assertEquals(15, test.getState());
	}

	@Test
	public void shouldCalculateUsingRestoredMemoryValue() {
		kalkulator test = new kalkulator();
		test.setState(10);
		test.ms();

		test.setState(0);
		test.mr();
		test.execute(new MultiplyOperation(), 3);

		assertEquals(30, test.getState());
	}
}
