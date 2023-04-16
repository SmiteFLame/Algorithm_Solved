package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val primeArray = Array<Boolean>(10_000_001) { true }

    for (i in 2..10_000_000) {
        if (primeArray[i]) {
            for (j in (i * 2)..10_000_000 step i) {
                primeArray[j] = false
            }
        }
    }

    val sb = StringBuilder()
    while(true) {
        val now = readLine().toInt()
        if (now == 0) {
            break
        }

        next@
        for (j in 2..(now / 2)) {
            if (primeArray[j] && primeArray[now - j]) {
                sb.append("$now = $j + ${now - j}\n")
                break@next
            }
        }
    }
    println(sb.toString())
}
