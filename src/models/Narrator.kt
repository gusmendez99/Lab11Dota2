package models

interface Narrator {

    var eventType:String
    fun narrate(eventType: String): String


}