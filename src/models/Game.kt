package models

class Game<T>(val narrador: T, var radiantTeam: Team?, var direTeam: Team?,
              var radiantDeaths: Int, var direDeaths: Int, var winner: Int) where T: Narrator {

    fun welcome(): String{
        return narrateSomething(narrador, "welcome")
    }
    fun gameStart(): String{
        return narrateSomething(narrador,"gameStart")
    }

    fun killOccurred(isRadiant: Boolean): String{
        if (isRadiant){
            this.direTeam!!.heroes.removeAt(0)
            this.radiantDeaths += 1
        } else {
            this.radiantTeam!!.heroes.removeAt(0)
            this.direDeaths += 1
        }
        return narrateSomething(narrador, "killOccurred")
    }

    fun multipleKillsOccurred(isRadiant: Boolean, numberOfKills:Int): String{
        if(isRadiant){
            for (i in 0..(numberOfKills-1)){
                this.direTeam!!.heroes.removeAt(0)
            }
            this.radiantDeaths += numberOfKills
        }else {
            for (i in 0..(numberOfKills-1)){
                this.radiantTeam!!.heroes.removeAt(0)
            }
            this.direDeaths += numberOfKills
        }
        return narrateSomething(narrador,"twoOrMoreKillsOccurred")
    }

    fun fiveKillsOccurred(isRadiant: Boolean) :String{
        if(isRadiant){
            for (i in 0..5){
                this.direTeam!!.heroes.removeAt(0)

            }
            this.radiantDeaths += 5
        }else {
            for (i in 0..5){
                this.radiantTeam!!.heroes.removeAt(0)
            }
            this.direDeaths += 5
        }
        return narrateSomething(narrador,"fiveKillsOccurred")
    }

    fun towerKilled(isRadiant: Boolean): String{
        if (isRadiant){
            this.direTeam!!.towers.removeAt(0)
            this.radiantDeaths += 1
        } else {
            this.radiantTeam!!.towers.removeAt(0)
            this.direDeaths += 1
        }
        return narrateSomething(narrador,"towerHasFallen")
    }

    fun ancientKilled(isRadiant: Boolean): String{
        if (isRadiant){
            this.radiantDeaths += 1
            this.winner = 0
            return narrateSomething(narrador,"radiantWins")

        }
        this.direDeaths += 1
        this.winner = 1
        return narrateSomething(narrador,"direWins")

    }

    private fun narrateSomething(narrator: Narrator, eventType: String): String{
        return narrator.narrate(eventType)
    }





}