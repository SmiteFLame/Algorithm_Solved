package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { 0 }
    val st = StringTokenizer(readLine())
    for (i in 0 until n) {
        array[i] = st.nextToken().toInt()
    }
    array.sort()
    val sb = StringBuilder()
    next@
    for(i in 1..array[0]){
        for(j in 0 until n){
            if(array[j] % i != 0) continue@next
        }
        sb.append("$i\n")
    }
    print(sb.toString())
}