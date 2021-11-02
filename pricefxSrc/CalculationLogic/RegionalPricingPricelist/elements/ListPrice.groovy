if (null in [out.BasePrice, out.MarginAdjustment, out.AttributeAdjustment]) {
    api.addWarning("Cannot calculate ListPrice because some of it's components is not available.")
    return null
}

return out.BasePrice + out.MarginAdjustment + out.AttributeAdjustment