package com.example.assortedservices3.vegvesen

import com.fasterxml.jackson.annotation.JsonProperty

class Fjell {

    @JsonProperty
    var id = ""
    @JsonProperty
    var navn = ""
    @JsonProperty
    var overgangstype = ""
    @JsonProperty
    var vegkategori = ""
    @JsonProperty
    var vegnummer = ""
    @JsonProperty
    var strekningstype = ""
    @JsonProperty
    var lokasjoner = listOf<Lokasjoner>()
    @JsonProperty
    var trafikkmeldinger = listOf<Trafikkmeldinger>()

}