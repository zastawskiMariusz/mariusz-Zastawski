package kalkulator;

enum CalculationStatus {
    OK,
    DIVIDE_BY_ZERO,
    INVALID_DOMAIN,
    OVERFLOW
}

interface Operation {
    int calculate(int a, int b);
}

class CalculatorMemory {
    private int state = 0;

    public void ms(int value) {
        state = value;
    }

    public int mr() {
        return state;
    }

    public void mc() {
        state = 0;
    }

    public void mPlus(int value) {
        state = Math.addExact(state, value);
    }
}

class AddOperation implements Operation {
    @Override
    public int calculate(int a, int b) {
        return Math.addExact(a, b);
    }
}

class MultiplyOperation implements Operation {
    @Override
    public int calculate(int a, int b) {
        return Math.multiplyExact(a, b);
    }
}

class DivideOperation implements Operation {
    @Override
    public int calculate(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Dzielenie przez zero!");
        }

        if (a == Integer.MIN_VALUE && b == -1) {
            throw new ArithmeticException("Przepelnienie!");
        }

        return a / b;
    }
}

class PowerOperation implements Operation {
    @Override
    public int calculate(int a, int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Ujemny wykladnik!");
        }

        int result = 1;

        for (int i = 0; i < b; i++) {
            result = Math.multiplyExact(result, a);
        }

        return result;
    }
}

public class kalkulator {
    private int state = 0;
    private CalculationStatus status = CalculationStatus.OK;
    private final CalculatorMemory memory = new CalculatorMemory();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        if (status == CalculationStatus.OK) {
            this.state = state;
        }
    }

    public CalculationStatus getStatus() {
        return status;
    }

    public void execute(Operation operation, int value) {
        if (status != CalculationStatus.OK) {
            return;
        }

        try {
            int result = operation.calculate(state, value);
            state = result;
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

    public void clearError() {
        status = CalculationStatus.OK;
    }

    public void ms() {
        if (status == CalculationStatus.OK) {
            memory.ms(state);
        }
    }

    public void mr() {
        if (status == CalculationStatus.OK) {
            state = memory.mr();
        }
    }

    public void mc() {
        memory.mc();
    }

    public void mPlus() {
        if (status != CalculationStatus.OK) {
            return;
        }

        try {
            memory.mPlus(state);
        } catch (ArithmeticException e) {
            status = CalculationStatus.OVERFLOW;
        }
    }

    public static void main(String[] args) {
        kalkulator calculator = new kalkulator();

        calculator.setState(10);
        calculator.execute(new AddOperation(), 5);
        System.out.println("Dodawanie: " + calculator.getState());

        calculator.execute(new MultiplyOperation(), 4);
        System.out.println("Mnozenie: " + calculator.getState());

        calculator.execute(new DivideOperation(), 3);
        System.out.println("Dzielenie: " + calculator.getState());

        calculator.execute(new PowerOperation(), 2);
        System.out.println("Potegowanie: " + calculator.getState());

        calculator.execute(new DivideOperation(), 0);
        System.out.println("Status po bledzie: " + calculator.getStatus());

        calculator.clearError();
        calculator.execute(new AddOperation(), 5);
        System.out.println("Wynik po wyczyszczeniu bledu: " + calculator.getState());
        System.out.println("Aktualny status: " + calculator.getStatus());
    }
}
