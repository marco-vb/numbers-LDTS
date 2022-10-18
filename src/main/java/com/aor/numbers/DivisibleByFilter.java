package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter {
    private int number;

    public DivisibleByFilter(int number) {
        this.number = number;
    }

    @Override
    public boolean accept(Integer n) {
        if (this.number == 0) return false;
        return n % this.number == 0;
    }
}
