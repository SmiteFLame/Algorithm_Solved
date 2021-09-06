package test

import java.util.*
import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
    var S = readLine()
    var answer = ""
    S.forEach { s ->
        if (s != 'C' && s != 'A' && s != 'M' && s != 'B' && s != 'R' && s != 'I' && s != 'D' && s != 'G' && s != 'E') {
            answer += s
        }
    }
    print(answer)
}
