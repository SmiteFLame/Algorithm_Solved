import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val shff = readLine()
    var game = booleanArrayOf(true, false, false)

    shff.forEach {
        game.shuffleBall(it)
    }

    game.forEachIndexed { index, b ->
        if (b) println(index + 1)
    }

}

fun BooleanArray.shuffleBall(ch: Char) {
    when (ch) {
        'A' -> {
            val tmp = this[0]
            this[0] = this[1]
            this[1] = tmp
        }
        'B' -> {
            val tmp = this[1]
            this[1] = this[2]
            this[2] = tmp
        }
        else -> {
            val tmp = this[0]
            this[0] = this[2]
            this[2] = tmp
        }
    }
}