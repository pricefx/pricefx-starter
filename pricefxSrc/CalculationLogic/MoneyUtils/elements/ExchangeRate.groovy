/**
 *
 * @param moneyAmount How much money to convert
 * @param fromCurrency In which currency is the provided moneyAmount
 * @param toCurrency In which currency would you like the result
 * @return Amount of Money in the toCurrency, or null, if error occurred
 */
BigDecimal convertMoney(BigDecimal moneyAmount, String fromCurrency, String toCurrency, Date conversionDate = api.targetDate()) {
    BigDecimal exchangeRate = 1.0
    BigDecimal resultAmount = null

    if (fromCurrency != toCurrency) {
        exchangeRate = getExchangeRate(fromCurrency, toCurrency, conversionDate)
    }

    if (exchangeRate != null && moneyAmount != null) {
        resultAmount = moneyAmount * exchangeRate
    } else {
        api.addWarning("Cannot convert money because either exchange rate or money amount is empty")
    }

    return resultAmount

}

private BigDecimal getExchangeRate(String fromCurrency, String toCurrency, Date conversionDate) {
    final String FIELD_VALID_FROM = "key3"
    final String FIELD_EXCHANGE_RATE = "attribute2"

    String conversionDateAsString = conversionDate?.format("yyyy-MM-dd")

    def filters = [
            Filter.equal("FromCurrency", fromCurrency),
            Filter.equal("ToCurrency", toCurrency),
            Filter.lessOrEqual("ValidFrom", conversionDateAsString),
            Filter.greaterOrEqual("ValidTo", conversionDateAsString)
    ]

    def fields = [FIELD_EXCHANGE_RATE] as List
    def sortBy = "-$FIELD_VALID_FROM" as String

    return api.findLookupTableValues(
            'ExchangeRate',
            fields,
            sortBy,
            *filters
    )?.getAt(0)?.getAt(FIELD_EXCHANGE_RATE) as BigDecimal
}