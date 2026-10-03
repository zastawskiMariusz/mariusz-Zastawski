
package kalkulator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void shouldAddOneToZero() {
        // Arrange
        Calculator test = new Calculator();

        // Act
        test.add(1);

        // Assert
        assertEquals(1, test.getState());
    }

    @Test
    public void shouldAddZeroWithoutChangingState() {
        // Arrange
        Calculator test = new Calculator();
        test.setState(10);

        // Act
        test.add(0);

        // Assert
        assertEquals(10, test.getState());
    }

    @Test
    public void shouldAddNegativeNumber() {
        // Arrange
        Calculator test = new Calculator();
        test.setState(10);

        // Act
        test.add(-3);

        // Assert
        assertEquals(7, test.getState());
    }

    @Test
    public void shouldAddNumbersWithDifferentSigns() {
        // Arrange
        Calculator test = new Calculator();
        test.setState(-10);

        // Act
        test.add(5);

        // Assert
        assertEquals(-5, test.getState());
    }

    @Test
    public void shouldMultiplyByZeroAndReturnZero() {
        // Arrange
        Calculator test = new Calculator();
        test.setState(10);

        // Act
        test.mult(0);

        // Assert
        assertEquals(0, test.getState());
    }

    @Test
    public void shouldMultiplyByOneWithoutChangingState() {
        // Arrange
        Calculator test = new Calculator();
        test.setState(10);

        // Act
        test.mult(1);

        // Assert
        assertEquals(10, test.getState());
    }

    @Test
    public void shouldMultiplyByNegativeNumber() {
        // Arrange
        Calculator test = new Calculator();
        test.setState(10);

        // Act
        test.mult(-2);

        // Assert
        assertEquals(-20, test.getState());
    }

    @Test
    public void shouldMultiplyNumbersWithDifferentSigns() {
        // Arrange
        Calculator test = new Calculator();
        test.setState(-10);

        // Act
        test.mult(2);

        // Assert
        assertEquals(-20, test.getState());
    }

    @Test
    public void shouldHandleIntegerMaxValueOverflow() {
        // Arrange
        Calculator test = new Calculator();
        test.setState(Integer.MAX_VALUE);

        // Act
        test.add(1);

        // Assert
        assertEquals(Integer.MIN_VALUE, test.getState());
    }

    @Test
    public void shouldHandleIntegerMinValueOverflow() {
        // Arrange
        Calculator test = new Calculator();
        test.setState(Integer.MIN_VALUE);

        // Act
        test.add(-1);

        // Assert
        assertEquals(Integer.MAX_VALUE, test.getState());
    }
}
