package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var count = 0
    fun recursion(s: String, l: Int, r: Int): Int {
        count++
        return if (l >= r) 1
        else if (s[l] != s[r]) 0
        else recursion(s, l + 1, r - 1)
    }

    fun isPalindrome(s: String): Int {
        return recursion(s, 0, s.length - 1)
    }

    val n = readLine().toInt()
    val sb = StringBuilder()
    (0 until n).forEach { _ ->
        val st = readLine()
        count = 0
        sb.append(isPalindrome(st)).append(" ").append(count).append("\n")
    }
    println(sb.toString())
}
