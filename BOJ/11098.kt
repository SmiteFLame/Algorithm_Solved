package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        var maxName = ""
        var max = 0
        repeat(readLine().toInt()){
            val st = StringTokenizer(readLine())
            val value = st.nextToken().toInt()
            val name = st.nextToken()
            if(value > max){
                maxName = name
                max = value
            }
        }
        sb.append("$maxName\n")
    }
    print(sb.toString())
}