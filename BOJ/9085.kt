package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var sb = StringBuilder()
    repeat(readLine().toInt()){
        var N = readLine().toInt()
        var st = StringTokenizer(readLine())
        var sum = 0
        repeat(N){
            sum += st.nextToken().toInt()
        }
        sb.append("$sum\n")
    }
    print(sb.toString())
}