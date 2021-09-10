package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val S = readLine()
        if((S.last() - '0') % 2 == 0){
            sb.append("even\n")
        } else{
            sb.append("odd\n")
        }
    }
    print(sb.toString())
}
