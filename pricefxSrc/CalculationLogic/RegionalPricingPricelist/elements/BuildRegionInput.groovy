if(!api.syntaxCheck){
    return
}

def regions = api.findLookupTableValues(
        'Region',
        ['Region'],
        null
).collect { row ->
    row['Region'] as String
}

api.inputBuilderFactory().createOptionEntry(Constants.INPUT_FIELD_REGION)
        .setLabel("Region")
        .setOptions(regions)
        .getInput()