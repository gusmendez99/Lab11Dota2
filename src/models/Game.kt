package models

class Game<T>(val narrator: T, var radiantDeaths: Int, var direDeaths: Int, var winner: Int) where T: Narrator {

    lateinit var radiantTeam: Team
    lateinit var direTeam: Team

    fun welcome(): String{
        return narrateSomething(narrator, "welcome")
    }

    fun gameStart(): String{
        return narrateSomething(narrator,"game_start")
    }

    fun killOccurred(isRadiant: Boolean): String{
        when {
            isRadiant -> {
                this.direTeam!!.heroes.removeAt(0)
                this.radiantDeaths ++
            }
            else -> {
                this.radiantTeam!!.heroes.removeAt(0)
                this.direDeaths ++
            }
        }
        return narrateSomething(narrator, "killOccurred")
    }

    fun multipleKillsOccurred(isRadiant: Boolean, numberOfKills:Int): String{
        when {
            isRadiant -> {
                for (i in 0..(numberOfKills-1)){
                    if(this.direTeam!!.heroes.isNotEmpty()) this.direTeam!!.heroes.removeAt(0)
                }
                this.radiantDeaths += numberOfKills
            }
            else -> {
                for (i in 0..(numberOfKills-1)){
                    if(this.radiantTeam!!.heroes.isNotEmpty()) this.radiantTeam!!.heroes.removeAt(0)
                }
                this.direDeaths += numberOfKills
            }
        }
        when (numberOfKills) {
            5 -> return narrateSomething(narrator,"fiveKillsOccurred")
            else -> return narrateSomething(narrator, "killsOccurred")
        }
    }

    fun towerKilled(isRadiant: Boolean): String{
        when {
            isRadiant -> {
                this.direTeam!!.towers.removeAt(0)
                this.radiantDeaths ++
            }
            else -> {
                this.radiantTeam!!.towers.removeAt(0)
                this.direDeaths ++
            }
        }
        return narrateSomething(narrator,"towerHasFallen")
    }

    fun ancientKilled(isRadiant: Boolean): String{
        when {
            isRadiant -> {
                this.direTeam!!.ancient.isDead = true
                this.radiantDeaths ++
                this.winner = 0
                return narrateSomething(narrator,"radiantWins")

            }
            else -> {
                this.radiantTeam!!.ancient.isDead = true
                this.direDeaths++
                this.winner = 1
                return narrateSomething(narrator, "direWins")

            }
        }

    }

    private fun narrateSomething(narrator: Narrator, eventType: String): String{
        return narrator.narrate(eventType)
    }





}