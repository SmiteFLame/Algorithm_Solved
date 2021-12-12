package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val array = arrayOf(350.34, 230.90, 190.55, 125.30, 180.90)
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        var sum = 0.0
        for(i in 0 until 5){
            sum += st.nextToken().toInt() * array[i]
        }
        sb.append("$${String.format("%.2f",sum)}\n")
    }
    print(sb.toString())
}
