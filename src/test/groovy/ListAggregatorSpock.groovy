import com.aor.numbers.ListAggregator
import com.aor.numbers.ListDeduplicator
import com.aor.numbers.ListSorter
import spock.lang.Specification

class ListAggregatorSpock extends Specification {
    def private list = Arrays.asList(1, 2, 3, 4, 5)

    def "sum of list"() {
        given:
            def aggregator = new ListAggregator()
        when:
            int sum = aggregator.sum(list)
        then:
            15 == sum
    }

    def "min of list"() {
        given:
            def aggregator = new ListAggregator()
        when:
            int min = aggregator.min(list)
        then:
            1 == min
    }

    def "max of list"() {
        given:
            def aggregator = new ListAggregator()
        when:
            int max = aggregator.max(list)
        then:
            5 == max
    }

    def "distinct of list"() {
        given:
            def aggregator = new ListAggregator()
            def deduplicator = new ListDeduplicator(new ListSorter())
        when:
            int distinct = aggregator.distinct(list, deduplicator)
        then:
            5 == distinct
    }
}
