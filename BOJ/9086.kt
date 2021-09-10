package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    var sb = StringBuilder()
    repeat(readLine().toInt()){
        var S = readLine()
        sb.append(S[0] + ""+ S.last() + "\n")
    }
    print(sb.toString())
}
