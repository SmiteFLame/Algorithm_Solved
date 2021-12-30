package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    for(i in 1..readLine().toInt()){
        sb.append("Class $i\n")
        val st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val array = Array(n){0}
        for(j in 0 until n){
            array[j] = st.nextToken().toInt()
        }
        array.sort()
        var largestGap = 0
        for(j in 0 until n - 1){
            largestGap = largestGap.coerceAtLeast(array[j + 1] - array[j])
        }
        sb.append("Max ${array[n - 1]}, Min ${array[0]}, Largest gap $largestGap\n")
    }
    print(sb.toString())
}
