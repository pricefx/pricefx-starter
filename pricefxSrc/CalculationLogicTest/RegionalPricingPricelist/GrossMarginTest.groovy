package RegionalPricingPricelist

import net.pricefx.tdd4c.TestRun
import spock.lang.Specification

class GrossMarginTest extends Specification {

    def LOGIC_DIR = "RegionalPricingPricelist"
    def ELEMENT_NAME = "GrossMargin"


    def "element GrossMargin - various scenarios of inputs "() {
        when:
        TestRun testRun = TestRun.builder()
                .withLogicTestDouble("out", ["ListPrice": listPrice, "BasePrice": basePrice])
                .buildElementTest(LOGIC_DIR, ELEMENT_NAME)

        and:
        Script script = testRun.getElementScript()

        then:
        testRun.execute()
                .getElementTestResult() == grossMargin

        where:
        listPrice | basePrice || grossMargin
        20        | 10        || 0.5
        0         | 11        || null
        null      | 3         || null
        4         | null      || null

    }
}
