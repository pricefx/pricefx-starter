return calculateMarginAdjustmentPercentage(out.MarginAdjustmentPct, out.BasePrice)

private BigDecimal calculateMarginAdjustmentPercentage(BigDecimal marginAdjPct, BigDecimal basePrice) {
    if (null in [marginAdjPct, basePrice]) {
        api.addWarning("Cannot calculate MarginAdj, because either BasePrice or MarginAdj %")
        return null
    }

    return basePrice * marginAdjPct
}
