import com.aor.numbers.DivisibleByFilter
import spock.lang.Specification

class DivisibleByFilterSpock extends Specification {
    def "should accept even"() {
        given:
            def filter = new DivisibleByFilter(2)
        when:
            def div = Arrays.asList(2, 4, 6, 8, 10)
            def notDiv = Arrays.asList(1, 3, 5, 7, 9)
        then:
            div.each { assert filter.accept(it) }
            notDiv.each { assert !filter.accept(it) }
    }

    def "should accept multiples of 3"() {
        given:
            def filter = new DivisibleByFilter(3)
        when:
            def div = Arrays.asList(3, 6, 9, 12, 15)
            def notDiv = Arrays.asList(1, 2, 4, 5, 7, 8, 10, 11, 13, 14)
        then:
            div.each { assert filter.accept(it) }
            notDiv.each { assert !filter.accept(it) }
    }
}