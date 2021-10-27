package test

import java.time.LocalDateTime

fun main() = with(System.`in`.bufferedReader()) {
    val now = LocalDateTime.now()
    now.minusHours(9)
    println(now.year)
    println(now.monthValue)
    println(now.dayOfMonth)
}
