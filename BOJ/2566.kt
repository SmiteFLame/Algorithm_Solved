package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var maxNumber = 0
    var maxRow = 1
    var maxColumn = 1
    for(i in 1..9){
        val st = StringTokenizer(readLine())
        for(j in 1..9){
            val now = st.nextToken().toInt()
            if(now > maxNumber){
                maxNumber = now
                maxRow = i
                maxColumn = j
            }
        }
    }
    val sb = StringBuilder()
    sb.append(maxNumber).append("\n")
    sb.append(maxRow).append(" ").append(maxColumn)
    print(sb.toString())
}
