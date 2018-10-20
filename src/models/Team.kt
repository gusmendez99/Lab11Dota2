package models

class Team {

    val ancient = Ancient()

    val heroes = ArrayList<Hero>()
    val towers = ArrayList<Tower>()


    fun addHeroe(hero:Hero){
        if(heroes.size < 5){
            heroes.add(hero)
        }
    }

    fun addTower(){
        if(towers.size < 5){
            towers.add(Tower())
        }
    }


}