package MoneyUtils

import com.googlecode.genericdao.search.Filter
import net.pricefx.tdd4c.TestRun
import spock.lang.Specification

class ExchangeRateTest extends Specification {

    def LOGIC_DIR = "MoneyUtils"
    def ELEMENT_NAME = "ExchangeRate"


    def "various scenarios for MoneyUtils.convertMoney"() {
        when:
        TestRun testRun = TestRun.builder()
                .withLogicTestDouble("api", [
                        findLookupTableValues: {
                            String tableName, List<String> fields,
                            String sortBy, Filter... filters ->
                                return [[attribute2: exchangeRate]]
                        }
                ])
                .buildElementTest(LOGIC_DIR, ELEMENT_NAME)

        and:
        Script script = testRun.getElementScript()

        then:
        convertedMoneyAmount == script.convertMoney(moneyAmount, fromCurrency, toCurrency)

        where:
        moneyAmount | fromCurrency | toCurrency | exchangeRate || convertedMoneyAmount
        10          | "EUR"        | "USD"      | 1.7          || 17
        10          | "EUR"        | null       | null         || null
        10          | null         | "USD"      | null         || null
        10          | null         | null       | null         || 10
        null        | "EUR"        | "USD"      | 1.7          || null
        null        | "EUR"        | null       | null         || null
        null        | null         | "USD"      | null         || null
        null        | null         | null       | null         || null
    }
}
