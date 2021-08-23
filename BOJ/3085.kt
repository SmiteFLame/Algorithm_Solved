package test

import java.lang.StringBuilder
import java.util.*


fun checkArray(array: Array<CharArray>, N: Int): Int {
    var c: Char
    var next = 1
    for(i in 0 until N){
        c = array[i][0]
        var cnt = 0
        for (j in 0 until N) {
            if (array[i][j] == c) {
                cnt++
                if (cnt > next) next = cnt
            } else {
                cnt = 1
                c = array[i][j]
            }
        }
    }

    for(i in 0 until N){
        c = array[0][i]
        var cnt = 0
        for (j in 0 until N) {
            if (array[j][i] == c) {
                cnt++
                if (cnt > next) next = cnt
            } else {
                cnt = 1
                c = array[j][i]
            }
        }
    }

    return next
}


fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    var array = Array<CharArray>(N) { CharArray(N) }
    for (i in 0 until N) {
        var now = readLine()
        for (j in 0 until N) {
            array[i][j] = now[j]
        }
    }

    var answer = checkArray(array, N)

    for (i in 0 until N) {
        for (j in 0 until N - 1) {
            array[i][j] = array[i][j + 1].also { array[i][j + 1] = array[i][j] }
            var now = checkArray(array, N)
            if(now > answer) answer = now
            array[i][j] = array[i][j + 1].also { array[i][j + 1] = array[i][j] }
        }
    }

    for (j in 0 until N) {
        for (i in 0 until N - 1) {
            array[i][j] = array[i + 1][j].also { array[i + 1][j] = array[i][j] }
            var now = checkArray(array, N)
            if(now > answer) answer = now
            array[i][j] = array[i + 1][j].also { array[i + 1][j] = array[i][j] }
        }
    }

    println(answer)
}