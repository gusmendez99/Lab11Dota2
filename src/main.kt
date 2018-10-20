import models.Game
import models.Hero
import models.Narrator
import models.Team
import narrator.RubenMoya
import utils.GameUtils

fun main (args: Array<String>) {
    val availableHeroes: ArrayList<Hero> = GameUtils.getDummyHeroes()
    val rubenMoya = RubenMoya() //A.K.A Morgan Freeman en latino
    val game = Game<Narrator>(rubenMoya, 0,0,2)
    //se asignan los equipos al partido actual
    game.radiantTeam = Team()
    game.direTeam = Team()

    print(game.welcome())

    println("--------------------------------------------------")
    val radiantHeroes: ArrayList<Hero> = ArrayList()
    val direHeroes: ArrayList<Hero> = ArrayList()

    var radiantSelects = false
    do {
        radiantSelects = !radiantSelects
        availableHeroes.forEachIndexed{index, heroe -> println("${index+1}. ${heroe.name} (${heroe.type})")}
        println("Selecciona un héroe de la lista")
        when {
            radiantSelects -> println("------Selección de héroes Radiant-------")
            else -> println("------Selección de héroes Dire-------")
        }
        val heroIndex = readLine()!!.toInt()
        when {
            radiantSelects -> {
                game.radiantTeam.addHero(availableHeroes[heroIndex-1])
                availableHeroes.removeAt(heroIndex-1)
            }
            else -> {
                game.direTeam.addHero(availableHeroes[heroIndex-1])
                availableHeroes.removeAt(heroIndex-1)
            }
        }

    } while (availableHeroes.size != 10)


    var noTowers = false
    do {
        print(getMenu(noTowers))
        val menuSelection = readLine()!!.toInt()
        when(menuSelection) {
            1->{
                println("¿Fue Radiant quien mató? si/no")
                val wasRadiantKill = readLine().toString()

                when (wasRadiantKill.toLowerCase()){
                    "si" -> {
                        println("¿Cuántas Muertes? (0-5)")
                        val killsCount = readLine()!!.toInt()
                        when (killsCount) {
                            1 -> print(game.killOccurred(true))
                            in 2..4 -> print(game.multipleKillsOccurred(true,killsCount))
                            5 -> print(game.fiveKillsOccurred(true))
                        }
                    }
                    "no" -> {
                        println("¿Cuántas Muertes? (0-5)")
                        val killsCount = readLine()!!.toInt()
                        when {
                            killsCount in 1..5 && killsCount == 1 -> print(game.killOccurred(false))
                            killsCount in 2..6 -> print(game.multipleKillsOccurred(false,killsCount))
                            killsCount == 5 -> print(game.fiveKillsOccurred(false))
                        }
                    }
                }

            }
            2 -> {
                println("¿Fue Radiant quien mató? si/no")
                val wasRadiantKill = readLine().toString()
                when (wasRadiantKill.toLowerCase()){
                    "si" -> {
                        print(game.towerKilled(true))
                    }
                    "no" -> {
                        print(game.towerKilled(false))
                    }
                }
                if (game.radiantTeam!!.towers.size == 0 || game.direTeam!!.towers.size == 0){
                    noTowers = true
                }
            }
            3 -> {
                println("¿Fue Radiant quien mató? si/no")
                val radiantKilled = readLine().toString()
                when(radiantKilled){
                    "si" -> {print(game.ancientKilled(true))}
                    "no" -> {print(game.ancientKilled(false))}
                }
            }
        }
    } while (game.winner == 2)
    
}

fun getMenu(existTowers: Boolean): String{
    return if (existTowers){
        """
        Menú:
        1. Ocurrieron muertes
        2. Matan torres
        3. Matan ancient
    """.trimIndent()
    } else {
        """
        Menú:
        1. Ocurrieron muertes
        2. Matan torres
    """.trimIndent()
    }
}
