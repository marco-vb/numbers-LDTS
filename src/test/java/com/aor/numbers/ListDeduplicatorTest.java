package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    private List<Integer> list, expected;

    @BeforeEach
    public void helper() {
        this.list = Arrays.asList(1,2,4,2,5);
        this.expected = Arrays.asList(1,2,4,5);
    }

    @Test
    public void deduplicate() {
        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(list)).thenReturn(Arrays.asList(1,2,2,4,5));

        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }
    @Test
    public void bug_deduplicate_8726() {
        list = Arrays.asList(1,2,4,2);
        expected = Arrays.asList(1, 2, 4);

        GenericListSorter sorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(sorter.sort(list)).thenReturn(Arrays.asList(1,2,2,4));

        ListDeduplicator deduplicator = new ListDeduplicator(sorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

}
