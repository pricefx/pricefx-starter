if (null in [out.AttributeAdjustmentPct, out.BasePrice]) {
    api.addWarning("Cannot calculate AttributeAdjustment, because either BasePrice or Attribute Adjustment % is missing")
    return null
}

return out.BasePrice * out.AttributeAdjustmentPct