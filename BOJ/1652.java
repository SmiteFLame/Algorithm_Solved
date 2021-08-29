package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    var map = Array<String>(N) { "" };
    var answerH = 0
    var answerV = 0
    for (i in 0 until N) {
        map[i] = readLine()
    }

    for (i in 0 until N) {
        var H = 0;
        var V = 0;
        for (j in 0 until N) {
            if (map[i][j] == '.') H++
            if (map[i][j] == 'X' || (j == N - 1)) {
                if (H >= 2) answerH++
                H = 0
            }

            if (map[j][i] == '.') V++
            if (map[j][i] == 'X' || (j == N - 1)) {
                if (V >= 2) answerV++
                V = 0
            }
        }
    }

    print("$answerH $answerV")
}