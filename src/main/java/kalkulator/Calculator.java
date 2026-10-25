package kalkulator;


interface Operation {
    int calculate(int a, int b);
}

public class Calculator {
    private int state = 0;
    private Cmemory Cmemory = new Cmemory();
    private CalculationStatus status = CalculationStatus.OK;



    public int getState() {
        return state;
    }
    public CalculationStatus getStatus() {
        return status;
    }

    public void setState(int state) {
        this.state = state;
        status = CalculationStatus.OK;
    }

    public void execute(Operation operation, int value) {
        try {
            int result = operation.calculate(state, value);
            state = result;
            status = CalculationStatus.OK;
        } catch (ArithmeticException e) {
            if (operation instanceof DivideOperation && value == 0) {
                status = CalculationStatus.DIVIDE_BY_ZERO;
            } else {
                status = CalculationStatus.OVERFLOW;
            }
        } catch (IllegalArgumentException e) {
            status = CalculationStatus.INVALID_DOMAIN;
        }
    }
    public void ms() {
        Cmemory.ms(state);
    }

    public void mr() {
        state = Cmemory.mr();
    }

    public void mc() {
        Cmemory.mc();
    }

    public void mPlus() {
        Cmemory.mPlus(state);
    }
}


class AddOperation implements Operation {
    @Override
    public int calculate(int a, int b) {
        return Math.addExact(a, b);
    }
}

class MultiplyOperation implements Operation {
    public int calculate(int a, int b) {
        return a * b;
    }
}

class DivideOperation implements Operation {
    public int calculate(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Dzielenie przez zero!");
        }

        return a / b;
    }
}

class PowerOperation implements Operation {
    public int calculate(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException(
                    "Wykładnik nie może być ujemny!"
            );
        }

        int result = 1;

        for (int i = 0; i < b; i++) {
            result *= a;
        }

        return result;
    }
}