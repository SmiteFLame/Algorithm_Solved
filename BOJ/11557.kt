package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        var maxName = ""
        var maxValue = 0
        repeat(readLine().toInt()){
            val st = StringTokenizer(readLine())
            val name = st.nextToken()
            val value = st.nextToken().toInt()
            if(value > maxValue){
                maxName = name
                maxValue = value
            }
        }
        sb.append("$maxName\n")
    }
    print(sb.toString())
}
