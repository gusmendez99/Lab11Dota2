

fun main (args: Array<String>) {

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
