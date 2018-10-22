package narrator

import models.Narrator

class RubenMoya:Narrator {
    //Voz en latino de Morgan Freeman

    override fun narrate(eventType: String): String {
        
        when (eventType) {
            "welcome" -> {
                return """
                    | ¡Bienvenidos a todos! Soy Ruben Moya, la voz latina de Morgan Freeman
                    | El dia de hoy volvemos a una nueva partida ¡Lo que nos espera el dia de hoy!
                """.trimIndent()
            }
            "game_start" -> {
                return """
                    | ¡Empieza el juego!
                """.trimMargin()
            }
            "killOccurred" -> {
                return """
                    | ¡Ha ocurrido una muerte!
                """.trimMargin()
            }
            "killsOccurred" -> {
                return """
                    | ¡Dos o mas muertes! Esta partida se va poniendo interesante
                """.trimMargin()
            }
            "fiveKillsOccurred" -> {
                return """
                    | ¡¡¡5 muertes!!! IMPOSIBLE, parece ser que se nos acaba la partida en corto
                    | * Fue en este momento que supo que la había jodido *
                    """.trimMargin()
            }
            "towerHasFallen" -> {
                return """
                    | ¡La torre ha caido! Se nos avecina el final de la partida en muy poco
                    | * Fue en este momento que supo que la había jodido *
                """.trimMargin()
            }
            "direWins" -> {
                return """
                    | ¡El equipo Dire ha ganado!
                """.trimMargin()
            }
            "radiantWins" -> {
                return """
                    | ¡El equipo Radiant ha ganado!
                """.trimMargin()
            }
            else -> return ""
        }
    }


}