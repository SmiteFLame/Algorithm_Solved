package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sc = Scanner(System.`in`)
    val alpha = IntArray(26)
    var max = 0
    while (sc.hasNextLine()) {
        val line: String = sc.nextLine()
        for (i in line.indices) {
            if (line[i] != ' ') {
                alpha[line[i] - 'a']++
                if (max < alpha[line[i] - 'a']) {
                    max = alpha[line[i] - 'a']
                }
            }
        }
    }
    for (i in 0..25) {
        if (alpha[i] == max) print((i + 'a'.toInt()).toChar())
    }
    sc.close()
    
}
