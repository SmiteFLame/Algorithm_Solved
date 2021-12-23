package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()
    val n = readLine().toInt()
    val array = Array(n + 1) { 0.0 }
    array[0] = x.toDouble() / y
    for(i in 1..n){
        st = StringTokenizer(readLine())
        array[i] = st.nextToken().toDouble() / st.nextToken().toDouble()
    }
    array.sort()
    print(array[0] * 1000)
}
