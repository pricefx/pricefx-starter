return findRegionalCurrency(out.Region)

String findRegionalCurrency(String region){
    return api.vLookup(
            'Region',
            'Currency',
            [('Region'): region]
    )
}