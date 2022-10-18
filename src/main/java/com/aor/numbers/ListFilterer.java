package com.aor.numbers;

import com.aor.numbers.GenericListDeduplicator;

import java.util.ArrayList;
import java.util.List;

public class ListFilterer {
    private final GenericListFilter filtr;

    public ListFilterer(GenericListFilter filter) {
        this.filtr = filter;
    }

    public List<Integer> filter(List<Integer> list) {
        List<Integer> filtered = new ArrayList<>();

        for (Integer number : list)
            if (this.filtr.accept(number))
                filtered.add(number);

        return filtered;
    }
}
