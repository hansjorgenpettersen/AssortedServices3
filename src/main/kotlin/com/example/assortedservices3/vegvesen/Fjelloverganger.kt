package com.example.assortedservices3.vegvesen

import com.example.assortedservices3.GetHelper
import com.google.gson.Gson

class Fjelloverganger {

    var fjell = arrayOf<Fjell>()

    fun getFjelloverganger ():Array<Fjell>  {

        var api = GetHelper()

        var json =  api.getRequest("https://fjelloverganger-backend.atlas.vegvesen.no/fjelloverganger")

        val gson = Gson()
        fjell = gson.fromJson(json, Array<Fjell>::class.java)
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
}