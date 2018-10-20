package utils

import models.Hero

object GameUtils{
    fun getDummyHeroes():ArrayList<Hero> {
        return arrayListOf<Hero>(
                Hero("Axe", "Strength"),
                Hero("Io", "Strength"),
                Hero("Kunkka", "Strength"),
                Hero("Anti-Mage", "Agility"),
                Hero("Luna", "Agility"),
                Hero("Medusa", "Agility"),
                Hero("Bane", "Intelligence"),
                Hero("Dazzle", "Intelligence"),
                Hero("Lion", "Intelligence"),
                Hero("Doom", "Strength"),
                Hero("Underlord", "Strength"),
                Hero("Tiny", "Strength"),
                Hero("Sven", "Strength"),
                Hero("Medusa", "Agility"),
                Hero("Viper", "Agility"),
                Hero("Weaver", "Agility"),
                Hero("Visage", "Intelligence"),
                Hero("Silencer", "Intelligence"),
                Hero("Queen of Pain", "Intelligence"),
                Hero("Puck", "Intelligence")
        )

    }
}