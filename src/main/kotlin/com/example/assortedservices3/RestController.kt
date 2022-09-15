package com.example.assortedservices3

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpServletRequest

@org.springframework.web.bind.annotation.RestController
class RestController {

    private var request: HttpServletRequest? = null

    var homeIp = "Not Set"
    var powerUse = "0"
    var recentData = NodeRedData()
    lateinit var powerPriceList : List<PowerPrices>

    @Autowired
    fun setRequest(request: HttpServletRequest?) {
        this.request = request
    }
    //Recive home Ip address
    @GetMapping("/setHomeAddress")
    fun setHomeAddress(){
        var remoteAddr: String? = ""
        if (request != null) {
            remoteAddr = request!!.getHeader("X-FORWARDED-FOR")
            if (remoteAddr == null || "" == remoteAddr) {
                remoteAddr = request!!.remoteAddr
            }
        }
    }
    @GetMapping("/getHomeIP")
    fun getHomeIP():String {
        return homeIp
    }
    @GetMapping ("api/power/setLivePowerUsage")
    fun setLivePowerUsage(@RequestParam liveUsage:String){
        powerUse = liveUsage
        println("Live Power Usage: " + liveUsage)
    }
    @GetMapping ("api/power/live")
    fun apiPowerLive():String {
        return powerUse
    }
    @PostMapping("api/nodeRed/revciver")
    fun nodeRedRevicer(@RequestBody data:NodeRedData) : String {
        recentData = data
        return "Data Recived!"
    }
    @GetMapping ("api/getNodeRedData")
    fun getNodeRedData():NodeRedData {
        return recentData
    }
    @PostMapping ("api/nodeRed/powerPrices")
    fun getPowerPriceFromNodeRed(@RequestBody data:List<PowerPrices>): String {
        powerPriceList = data;
        return "OK"
    }
    @GetMapping ("api/getPowerPrice")
    fun getPowerPrice():List<PowerPrices> {
        return powerPriceList;
    }

}