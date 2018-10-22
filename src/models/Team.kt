package models

class Team() {

    val ancient = Ancient()
    val heroes = ArrayList<Hero>()
    val towers = ArrayList<Tower>()

    init {
        for (i in 1..6){
            towers.add(Tower())
        }
    }


    fun addHero(hero:Hero){
        if(heroes.size < 5){
            heroes.add(hero)
        }
    }

}