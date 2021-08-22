package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var sb = StringBuilder()
    repeat(readLine().toInt()){
        var st = StringTokenizer(readLine())
        var sum = 0
        when(st.nextToken().toInt()){
            in 1..1 -> sum += 5000000
            in 2..3 -> sum += 3000000
            in 4..6 -> sum += 2000000
            in 7..10 -> sum += 500000
            in 11..15 -> sum += 300000
            in 16..21 -> sum += 100000
        }
        when(st.nextToken().toInt()){
            in 1..1 -> sum += 5120000
            in 2..3 -> sum += 2560000
            in 4..7 -> sum += 1280000
            in 8..15 -> sum += 640000
            in 16..31 -> sum += 320000
        }
        sb.append("$sum\n")
    }
    print(sb.toString())
}