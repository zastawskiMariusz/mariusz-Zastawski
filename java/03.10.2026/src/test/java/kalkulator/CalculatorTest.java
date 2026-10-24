package kalkulator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

	// ZADANIE 1 - TESTY DODAWANIA I MNOŻENIA

	@Test
	public void shouldAddNumbers() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new AddOperation(), 5);

		assertEquals(15, test.getState());
		assertEquals(CalculationStatus.OK, test.getStatus());
	}

	@Test
	public void shouldMultiplyNumbers() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new MultiplyOperation(), 5);

		assertEquals(50, test.getState());
		assertEquals(CalculationStatus.OK, test.getStatus());
	}

	@Test
	public void shouldKeepValueWhenAddingZero() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new AddOperation(), 0);

		assertEquals(10, test.getState());
	}

	@Test
	public void shouldReturnZeroWhenMultiplyingByZero() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new MultiplyOperation(), 0);

		assertEquals(0, test.getState());
	}

	@Test
	public void shouldKeepValueWhenMultiplyingByOne() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new MultiplyOperation(), 1);

		assertEquals(10, test.getState());
	}

	@Test
	public void shouldAddNegativeNumbers() {
		kalkulator test = new kalkulator();
		test.setState(-10);

		test.execute(new AddOperation(), -5);

		assertEquals(-15, test.getState());
	}

	@Test
	public void shouldAddNumbersWithDifferentSigns() {
		kalkulator test = new kalkulator();
		test.setState(-10);

		test.execute(new AddOperation(), 15);

		assertEquals(5, test.getState());
	}

	@Test
	public void shouldMultiplyNegativeNumbers() {
		kalkulator test = new kalkulator();
		test.setState(-10);

		test.execute(new MultiplyOperation(), -5);

		assertEquals(50, test.getState());
	}

	@Test
	public void shouldMultiplyNumbersWithDifferentSigns() {
		kalkulator test = new kalkulator();
		test.setState(-10);

		test.execute(new MultiplyOperation(), 5);

		assertEquals(-50, test.getState());
	}

	@Test
	public void shouldAddZeroToIntegerMaximum() {
		kalkulator test = new kalkulator();
		test.setState(Integer.MAX_VALUE);

		test.execute(new AddOperation(), 0);

		assertEquals(Integer.MAX_VALUE, test.getState());
		assertEquals(CalculationStatus.OK, test.getStatus());
	}

	@Test
	public void shouldAddZeroToIntegerMinimum() {
		kalkulator test = new kalkulator();
		test.setState(Integer.MIN_VALUE);

		test.execute(new AddOperation(), 0);

		assertEquals(Integer.MIN_VALUE, test.getState());
		assertEquals(CalculationStatus.OK, test.getStatus());
	}

	@Test
	public void shouldDetectAdditionOverflowAtMaximum() {
		kalkulator test = new kalkulator();
		test.setState(Integer.MAX_VALUE);

		test.execute(new AddOperation(), 1);

		assertEquals(Integer.MAX_VALUE, test.getState());
		assertEquals(CalculationStatus.OVERFLOW, test.getStatus());
	}

	@Test
	public void shouldDetectAdditionOverflowAtMinimum() {
		kalkulator test = new kalkulator();
		test.setState(Integer.MIN_VALUE);

		test.execute(new AddOperation(), -1);

		assertEquals(Integer.MIN_VALUE, test.getState());
		assertEquals(CalculationStatus.OVERFLOW, test.getStatus());
	}

	@Test
	public void shouldDetectMultiplicationOverflow() {
		kalkulator test = new kalkulator();
		test.setState(Integer.MAX_VALUE);

		test.execute(new MultiplyOperation(), 2);

		assertEquals(Integer.MAX_VALUE, test.getState());
		assertEquals(CalculationStatus.OVERFLOW, test.getStatus());
	}

	// ZADANIE 2 - OCP I POZOSTALE OPERACJE

	@Test
	public void shouldDivideNumbers() {
		kalkulator test = new kalkulator();
		test.setState(20);

		test.execute(new DivideOperation(), 4);

		assertEquals(5, test.getState());
		assertEquals(CalculationStatus.OK, test.getStatus());
	}

	@Test
	public void shouldCalculatePower() {
		kalkulator test = new kalkulator();
		test.setState(2);

		test.execute(new PowerOperation(), 3);

		assertEquals(8, test.getState());
		assertEquals(CalculationStatus.OK, test.getStatus());
	}

	// ZADANIE 3 - PAMIEC KALKULATORA

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
	public void shouldCalculateUsingRestoredMemory() {
		kalkulator test = new kalkulator();
		test.setState(10);
		test.ms();

		test.setState(0);
		test.mr();
		test.execute(new MultiplyOperation(), 3);

		assertEquals(30, test.getState());
	}

	// ZADANIE 4 - OBSLUGA BLEDOW

	@Test
	public void shouldDetectDivisionByZero() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new DivideOperation(), 0);

		assertEquals(10, test.getState());
		assertEquals(CalculationStatus.DIVIDE_BY_ZERO, test.getStatus());
	}

	@Test
	public void shouldBlockOperationsAfterError() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new DivideOperation(), 0);
		test.execute(new AddOperation(), 5);

		assertEquals(10, test.getState());
		assertEquals(CalculationStatus.DIVIDE_BY_ZERO, test.getStatus());
	}

	@Test
	public void shouldClearErrorAndContinueCalculations() {
		kalkulator test = new kalkulator();
		test.setState(10);

		test.execute(new DivideOperation(), 0);
		test.clearError();
		test.execute(new AddOperation(), 5);

		assertEquals(15, test.getState());
		assertEquals(CalculationStatus.OK, test.getStatus());
	}

	@Test
	public void shouldDetectInvalidPower() {
		kalkulator test = new kalkulator();
		test.setState(2);

		test.execute(new PowerOperation(), -1);

		assertEquals(2, test.getState());
		assertEquals(CalculationStatus.INVALID_DOMAIN, test.getStatus());
	}

	@Test
	public void shouldDetectDivisionOverflow() {
		kalkulator test = new kalkulator();
		test.setState(Integer.MIN_VALUE);

		test.execute(new DivideOperation(), -1);

		assertEquals(Integer.MIN_VALUE, test.getState());
		assertEquals(CalculationStatus.OVERFLOW, test.getStatus());
	}

	@Test
	public void shouldDetectMemoryOverflow() {
		kalkulator test = new kalkulator();
		test.setState(Integer.MAX_VALUE);
		test.ms();

		test.clearError();
		test.setState(1);
		test.mPlus();

		assertEquals(CalculationStatus.OVERFLOW, test.getStatus());
	}
}
