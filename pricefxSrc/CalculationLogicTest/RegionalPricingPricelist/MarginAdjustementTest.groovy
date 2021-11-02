package RegionalPricingPricelist

import net.pricefx.tdd4c.TestRun
import spock.lang.Specification

class MarginAdjustmentTest extends Specification {

    def LOGIC_DIR = "RegionalPricingPricelist"
    def ELEMENT_NAME = "MarginAdjustment"


    def "Library function calculateMarginAdjustmentPercentage() - test of various scenarios"() {
        when:
        TestRun testRun = TestRun.builder()
                .withLogicTestDouble("api", [
                        addWarning: {}
                ])
                .buildElementTest(LOGIC_DIR, ELEMENT_NAME)

        and:
        Script script = testRun.getElementScript()

        then:
        marginAdj == script.calculateMarginAdjustmentPercentage(marginAdjPct, basePrice)


        where:
        basePrice | marginAdjustmentPct || marginAdjustment
        10        | 0.1          || 1.0
        10        | null         || null
        null      | 10           || null
        null      | null         || null
    }
}
