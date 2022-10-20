package com.example.assortedservices3.vegvesen

import com.fasterxml.jackson.annotation.JsonProperty

class Trafikkmeldinger {

    @JsonProperty
    var hendelsesId = ""
    @JsonProperty
    var vegnummer = ""
    @JsonProperty
    var lokasjonBeskrivelse = ""
    @JsonProperty
    var beskrivelse = ""
    @JsonProperty
    var startTid = ""
    @JsonProperty
    var sluttTid = ""
    @JsonProperty
    var kritikalitet = ""
    @JsonProperty
    var statuser = listOf<String>()

}