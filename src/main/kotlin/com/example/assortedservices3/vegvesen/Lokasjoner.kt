package com.example.assortedservices3.vegvesen

import com.fasterxml.jackson.annotation.JsonProperty

class Lokasjoner {

    @JsonProperty
    var navn = ""
    @JsonProperty
    var yrUrl = ""
    @JsonProperty
    var kameraUrler = listOf<String>()

}