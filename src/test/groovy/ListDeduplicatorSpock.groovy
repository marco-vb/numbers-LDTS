import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListDeduplicatorSpock extends Specification{
    private def list
    private def expected

    def setup() {
        list = Arrays.asList(1, 3, 2, 3, 5)
        expected = Arrays.asList(1, 2, 3, 5)
    }

    def "deduplicate list"() {
        given:
            def sorter = Mock GenericListSorter.class
            def deduplicator = new ListDeduplicator(sorter)

            sorter.sort(_ as List<Integer>) >> [1, 2, 3, 3, 5]
        when:
            def result = deduplicator.deduplicate(list as List<Integer>)
        then:
            result == expected as List<Integer>
    }

    def "bug 8726"() {
        given:
            def sorter = Mock GenericListSorter.class
            def deduplicator = new ListDeduplicator(sorter)
            sorter.sort(_ as List<Integer>) >> [1, 2, 2, 4]

        when:
            def result = deduplicator.deduplicate([1, 2, 4, 2])

        then:
            result == [1, 2, 4]
    }
}
