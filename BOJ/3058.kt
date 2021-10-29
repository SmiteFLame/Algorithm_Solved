package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        var min = Int.MAX_VALUE
        var sum = 0
        repeat(7){
            val now = st.nextToken().toInt()
            if(now % 2 == 0){
                sum += now
                if(now < min){
                    min = now
                }
            }
        }
        sb.append("$sum $min\n")
    }
    print(sb.toString())
}
