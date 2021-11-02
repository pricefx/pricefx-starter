if (null in [out.ListPrice, out.BasePrice]) {
    api.addWarning("Cannot calculate GrossMargin, because either ListPrice or BasePrice is not available.")
    return null
}

if (out.ListPrice == 0) {
    api.addWarning("Cannot calculate GrossMargin, because ListPrice is zero")
    return null
}

return (out.ListPrice - out.BasePrice) / out.ListPrice