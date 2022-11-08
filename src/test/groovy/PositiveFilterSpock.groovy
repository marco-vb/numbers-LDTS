import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveFilterSpock extends Specification {
    def "Accept all positive numbers"() {
        given:
            def list_positives = [1, 2, 3, 4, 5]
            def list_negatives = [-1, -2, -3, -4, -5]
        when:
            def filter = new PositiveFilter()
        then:
            list_positives.every { filter.accept(it) }
            !list_negatives.every { filter.accept(it) }
    }
}
