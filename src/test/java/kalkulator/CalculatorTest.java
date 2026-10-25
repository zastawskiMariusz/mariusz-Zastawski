package kalkulator;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

	// TESTY ZADANIA 1 — DODAWANIE

	@Test
	public void testAddOne() {
		Calculator sut = new Calculator();

		sut.execute(new AddOperation(), 1);

		assertEquals(1, sut.getState());
	}

	@Test
	public void testAddZero() {
		Calculator sut = new Calculator();
		sut.setState(5);

		sut.execute(new AddOperation(), 0);

		assertEquals(5, sut.getState());
	}

	@Test
	public void testAddNegativeNumbers() {
		Calculator sut = new Calculator();
		sut.setState(-5);

		sut.execute(new AddOperation(), -3);

		assertEquals(-8, sut.getState());
	}

	@Test
	public void testAddMixedSigns() {
		Calculator sut = new Calculator();
		sut.setState(-5);

		sut.execute(new AddOperation(), 8);

		assertEquals(3, sut.getState());
	}

	@Test
	public void testAddIntegerMaxValueOverflow() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);

		sut.execute(new AddOperation(), 1);

		assertEquals(CalculationStatus.OVERFLOW, sut.getStatus());
		assertEquals(Integer.MAX_VALUE, sut.getState());
	}


	@Test
	public void testAddIntegerMinValueOverflow() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MIN_VALUE);

		sut.execute(new AddOperation(), -1);

		assertEquals(CalculationStatus.OVERFLOW, sut.getStatus());
		assertEquals(Integer.MIN_VALUE, sut.getState());
	}


	// TESTY ZADANIA 1 — MNOŻENIE

	@Test
	public void testMultiplyByTwo() {
		Calculator sut = new Calculator();
		sut.setState(1);

		sut.execute(new MultiplyOperation(), 2);

		assertEquals(2, sut.getState());
	}

	@Test
	public void testMultiplyByOne() {
		Calculator sut = new Calculator();
		sut.setState(7);

		sut.execute(new MultiplyOperation(), 1);

		assertEquals(7, sut.getState());
	}

	@Test
	public void testMultiplyByZero() {
		Calculator sut = new Calculator();
		sut.setState(7);

		sut.execute(new MultiplyOperation(), 0);

		assertEquals(0, sut.getState());
	}

	@Test
	public void testMultiplyNegativeNumbers() {
		Calculator sut = new Calculator();
		sut.setState(-4);

		sut.execute(new MultiplyOperation(), -3);

		assertEquals(12, sut.getState());
	}

	@Test
	public void testMultiplyMixedSigns() {
		Calculator sut = new Calculator();
		sut.setState(-4);

		sut.execute(new MultiplyOperation(), 3);

		assertEquals(-12, sut.getState());
	}

	@Test
	public void testMultiplyIntegerMaxValueOverflow() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);

		sut.execute(new MultiplyOperation(), 2);

		assertEquals(-2, sut.getState());
	}


	// TESTY NOWYCH OPERACJI —

	@Test
	public void shouldDivideNumbers() {
		Calculator sut = new Calculator();
		sut.setState(10);

		sut.execute(new DivideOperation(), 2);

		assertEquals(5, sut.getState());
	}
	

	@Test
	public void shouldDivideNegativeNumbers() {
		Calculator sut = new Calculator();
		sut.setState(-12);

		sut.execute(new DivideOperation(), 3);

		assertEquals(-4, sut.getState());
	}

	@Test
	public void shouldCalculatePower() {
		Calculator sut = new Calculator();
		sut.setState(2);

		sut.execute(new PowerOperation(), 3);

		assertEquals(8, sut.getState());
	}

	@Test
	public void shouldReturnOneWhenExponentIsZero() {
		Calculator sut = new Calculator();
		sut.setState(5);

		sut.execute(new PowerOperation(), 0);

		assertEquals(1, sut.getState());
	} @Test
	public void testMS() {
		Calculator sut = new Calculator();
		sut.setState(10);

		sut.ms();
		sut.setState(5);
		sut.mr();

		assertEquals(10, sut.getState());
	}

	@Test
	public void testMR() {
		Calculator sut = new Calculator();
		sut.setState(15);
		sut.ms();
		sut.setState(0);

		sut.mr();

		assertEquals(15, sut.getState());
	}

	@Test
	public void testMC() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.ms();

		sut.mc();
		sut.mr();

		assertEquals(0, sut.getState());
	}

	@Test
	public void testMPlus() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.ms();

		sut.setState(5);
		sut.mPlus();
		sut.mr();

		assertEquals(15, sut.getState());
	}

	@Test
	public void testCalculationsWithMemory() {
		Calculator sut = new Calculator();
		sut.setState(10);
		sut.ms();

		sut.setState(5);
		sut.execute(new AddOperation(), 3);

		sut.mr();
		sut.execute(new MultiplyOperation(), 2);

		assertEquals(20, sut.getState());
	}
	@Test
	public void testDivisionByZeroSetsErrorStatus() {
		Calculator sut = new Calculator();
		sut.setState(10);

		sut.execute(new DivideOperation(), 0);

		assertEquals(CalculationStatus.DIVIDE_BY_ZERO, sut.getStatus());
		assertEquals(10, sut.getState());
	}

	@Test
	public void testNegativeExponentSetsErrorStatus() {
		Calculator sut = new Calculator();
		sut.setState(2);

		sut.execute(new PowerOperation(), -1);

		assertEquals(CalculationStatus.INVALID_DOMAIN, sut.getStatus());
		assertEquals(2, sut.getState());
	}

	@Test
	public void testOverflowSetsErrorStatus() {
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE);

		sut.execute(new AddOperation(), 1);

		assertEquals(CalculationStatus.OVERFLOW, sut.getStatus());
		assertEquals(Integer.MAX_VALUE, sut.getState());
	}

	@Test
	public void testFurtherOperationAfterError() {
		Calculator sut = new Calculator();
		sut.setState(10);

		sut.execute(new DivideOperation(), 0);
		sut.execute(new AddOperation(), 5);

		assertEquals(15, sut.getState());
		assertEquals(CalculationStatus.OK, sut.getStatus());
	}

	@Test
	public void testErrorRemainsAfterAnotherFailedOperation() {
		Calculator sut = new Calculator();
		sut.setState(10);

		sut.execute(new DivideOperation(), 0);
		sut.execute(new PowerOperation(), -1);

		assertEquals(10, sut.getState());
		assertEquals(CalculationStatus.INVALID_DOMAIN, sut.getStatus());
	}

	@Test
	public void testReturnToOKAfterError() {
		Calculator sut = new Calculator();
		sut.setState(20);

		sut.execute(new DivideOperation(), 0);

		assertEquals(CalculationStatus.DIVIDE_BY_ZERO, sut.getStatus());

		sut.execute(new MultiplyOperation(), 3);

		assertEquals(60, sut.getState());
		assertEquals(CalculationStatus.OK, sut.getStatus());
	}

	@Test
	public void testStatusIsOKAfterSuccessfulCalculation() {
		Calculator sut = new Calculator();
		sut.setState(10);

		sut.execute(new AddOperation(), 5);

		assertEquals(15, sut.getState());
		assertEquals(CalculationStatus.OK, sut.getStatus());
	}
}