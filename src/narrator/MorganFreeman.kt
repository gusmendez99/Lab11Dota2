package narrator

import models.Narrator

class MorganFreeman:Narrator {
    //Voz de Morgan Freeman

    override fun narrate(eventType: String): String {

        when (eventType) {
            "welcome" -> {
                return """
                    | Welcome! Im Morgan Freeman
                    | Today we back to a new game. What awaits us today!
                """.trimIndent()
            }
            "game_start" -> {
                return """
                    | The game has begun!
                """.trimMargin()
            }
            "killOccurred" -> {
                return """
                    | A death has occurred!
                """.trimMargin()
            }
            "killsOccurred" -> {
                return """
                    | Two or more deaths! This game is getting interesting
                """.trimMargin()
            }
            "fiveKillsOccurred" -> {
                return """
                    | 5 deaths!!! IMPOSSIBLE, it seems that we are running out of game in short
                    | *IT WAS AT THIS MOMENT HE KNEW HE FUCKED UP*
                    """.trimMargin()
            }
            "towerHasFallen" -> {
                return """
                    | A tower has fallen! The game is running out
                    | *IT WAS AT THIS MOMENT HE KNEW HE FUCKED UP*
                """.trimMargin()
            }
            "direWins" -> {
                return """
                    | Dire wins!
                """.trimMargin()
            }
            "radiantWins" -> {
                return """
                    | Radiant wins!
                """.trimMargin()
            }
            else -> return ""
        }
    }

}