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
    //Asignacion de equipos
    game.radiantTeam = Team()
    game.direTeam = Team()

    print(game.welcome())

    println("\n--------------------------------------------------")
    val radiantHeroes: ArrayList<Hero> = ArrayList()
    val direHeroes: ArrayList<Hero> = ArrayList()

    var radiantSelects = false
    do {
        radiantSelects = !radiantSelects
        availableHeroes.forEachIndexed{index, heroe -> println("${index+1}. ${heroe.name} (${heroe.type})")}
        println("Selecciona un héroe de la lista")
        when {
            radiantSelects -> print("------Selección de héroes Radiant-------\n> ")
            else -> print("------Selección de héroes Dire-------\n> ")
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
        println(getMenu(noTowers))
        print("> ")
        val option = readLine()!!.toInt()
        when(option) {
            1->{
                println("¿Fue Radiant quien mató? si/no")
                val wasRadiantKill = readLine().toString()

                when (wasRadiantKill.toLowerCase()){
                    "si" -> {
                        println("¿Cuántas Muertes? (0-5)")
                        val killsCount = readLine()!!.toInt()
                        when (killsCount) {
                            1 -> println(game.killOccurred(true))
                            in 2..4 -> println(game.multipleKillsOccurred(true,killsCount))
                            5 -> println(game.multipleKillsOccurred(true,5))
                        }
                    }
                    "no" -> {
                        println("¿Cuántas Muertes? (0-5)")
                        val killsCount = readLine()!!.toInt()
                        when {
                            killsCount in 1..5 && killsCount == 1 -> println(game.killOccurred(false))
                            killsCount in 2..4 -> println(game.multipleKillsOccurred(false,killsCount))
                            killsCount == 5 -> println(game.multipleKillsOccurred(false, 5))
                        }
                    }
                }

            }
            2 -> {
                println("¿Fue Radiant quien mató? si/no")
                val wasRadiantKill = readLine().toString()
                when (wasRadiantKill.toLowerCase()){
                    "si" -> {
                        when {
                            !game.direTeam!!.towers.isEmpty() -> println(game.towerKilled(true))
                            else -> println("No hay torres vivas...")
                        }
                    }
                    "no" -> {
                        when {
                            !game.direTeam!!.towers.isEmpty() -> println(game.towerKilled(false))
                            else -> println("No hay torres vivas...")
                        }
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
                    "si" -> {
                        when {
                            game.direTeam!!.towers.isEmpty() -> println(game.ancientKilled(true))
                            else -> print("Quedan vivas sus torres aun!")
                        }
                    }
                    "no" -> {
                        when {
                            game.radiantTeam!!.towers.isEmpty() -> println(game.ancientKilled(false))
                            else -> print("Quedan vivas sus torres aun!")
                        }
                    }
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
