import com.aor.numbers.ListSorter
import com.aor.numbers.GenericListSorter
import spock.lang.Specification

class ListSorterSpock extends Specification {
    List<Integer> list
    List<Integer> expected

    def setup() {
        list = Arrays.asList(3, 7, 2, 1, 5, 4, 6)
        expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7)
    }

    def "Test sort"() {
        given:
            def sorter = new ListSorter()
        when:
            def result = sorter.sort(list)
        then:
            result == expected
    }

    def "bug 8726"() {
        given:
        def sorter = new ListSorter()

        when:
        def sorted = sorter.sort([1, 2, 4, 2])

        then:
        sorted == [1, 2, 2, 4]
    }
}
