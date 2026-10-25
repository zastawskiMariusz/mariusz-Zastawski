package kalkulator;

public class Cmemory {
    private int memory = 0;

    public void ms(int value) {
        memory = value;
    }

    public int mr() {
        return memory;
    }

    public void mc() {
        memory = 0;
    }

    public void mPlus(int value) {
        memory += value;
    }
}
