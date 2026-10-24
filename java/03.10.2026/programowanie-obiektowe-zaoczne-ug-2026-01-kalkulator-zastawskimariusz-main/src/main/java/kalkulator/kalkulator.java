package kalkulator;

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
        state += value;
    }

}

class AddOperation implements Operation {
    public int calculate(int a, int b) {
        return a + b;
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
        return (int) Math.pow(a, b);
    }
}

public class kalkulator {
    private int state = 0;
    private CalculatorMemory memory = new CalculatorMemory();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void execute(Operation operation, int value) {
        state = operation.calculate(state, value);
    }

    public void ms() {
        memory.ms(state);
    }

    public void mr() {
        state = memory.mr();
    }

    public void mc() {
        memory.mc();
    }

    public void mPlus() {
        memory.mPlus(state);
    }

    public static void main(String[] args) {
        kalkulator c = new kalkulator();

        c.setState(10);
        c.execute(new AddOperation(), 5);
        System.out.println(c.getState());

        c.execute(new MultiplyOperation(), 4);
        System.out.println(c.getState());

        c.execute(new DivideOperation(), 3);
        System.out.println(c.getState());

        c.execute(new PowerOperation(), 2);
        System.out.println(c.getState());

        try {
            c.execute(new DivideOperation(), 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
