package com.example.assortedservices3.vegvesen

import com.example.assortedservices3.GetHelper
import com.google.gson.Gson
import java.time.LocalDateTime

class Fjelloverganger {

    var fjell = arrayOf<Fjell>()
    var lastUpdated = LocalDateTime.now().plusMinutes(-10)

    fun getFjelloverganger ():Array<Fjell>  {

        var api = GetHelper()
        val gson = Gson()
        var json = ""

        if(lastUpdated.plusMinutes(5)<LocalDateTime.now()) {
            json =  api.getRequest("https://fjelloverganger-backend.atlas.vegvesen.no/fjelloverganger")
            fjell = gson.fromJson(json, Array<Fjell>::class.java)
            lastUpdated = LocalDateTime.now()
            println("!fjell info updated")
        }
        return fjell
    }
    fun getFjell(navn:String) : Fjell {
        var i = 0
        while(i<fjell.size) {
            if(fjell[i].navn == navn) {
                return fjell[i]
            }
            i++
        }
        var tomtFjell = Fjell()
        return tomtFjell
    }
    fun getAllImages():List<String> {
        var i = 0
        var x = 0
        var y = 0
        var listIndex = 0
        var urlList = arrayListOf<String>()
        while(fjell.size>i) {
            while(fjell[i].lokasjoner.size>x) {
                while (fjell[i].lokasjoner[x].kameraUrler.size > y) {
                    urlList.add(listIndex,fjell[i].lokasjoner[x].kameraUrler[y])
                    listIndex++
                    y++
                }
                y=0
                x++
            }
            x=0
            i++
        }
        return urlList
    }
    fun getAllFjell(): List<String> {
        var fjellOversikt = arrayListOf<String>()
        var i = 0
        while(fjell.size>i){
            fjellOversikt.add(fjell[i].navn)
            i++
        }
        return fjellOversikt
    }
}