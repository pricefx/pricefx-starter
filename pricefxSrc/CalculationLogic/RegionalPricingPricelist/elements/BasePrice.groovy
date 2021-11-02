import groovy.transform.Field

@Field String FIELD_AVERAGE_COST = "attribute1"

BigDecimal costEUR = getProductCost(getSku())

return libs.MoneyUtils.ExchangeRate.convertMoney(costEUR, "EUR", out.Currency)


BigDecimal getProductCost(String sku) {
    def filters = [
            Filter.equal("name", "ProductCost"),
            Filter.equal("sku", sku)
    ]
    def productCostRows = api.find("PX", 0, 1, null, [FIELD_AVERAGE_COST], *filters)
    return productCostRows.getAt(0)?.getAt(FIELD_AVERAGE_COST) as BigDecimal
}

String getSku() {
    return api.product('sku')
}