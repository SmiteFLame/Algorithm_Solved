package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val money = arrayOf(25, 10, 5, 1)
    repeat(readLine().toInt()) {
        var now = readLine().toInt()
        for(i in 0 until 4){
            if(now >= money[i]){
                sb.append("${now / money[i]} ")
                now %= money[i]
            } else{
                sb.append("0 ")
            }
        }
        sb.append("\n")
    }
    print(sb.toString())
}
