package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val array = Array(n) { 0 }
    for (i in 0 until n) {
        array[i] = st.nextToken().toInt()
    }
    val dpFront = Array(n) { 0 }
    val dpBack = Array(n){0}
    dpFront[0] = array[0]
    dpBack[n - 1] =  array[n - 1]
    var ans = dpFront[0]

    for(i in 1 until n){
        dpFront[i] = (dpFront[i - 1] + array[i]).coerceAtLeast(array[i])
        dpBack[i] = dpFront[i - 1].coerceAtLeast(dpBack[i - 1] + array[i])

        ans = ans.coerceAtLeast(dpFront[i].coerceAtLeast(dpBack[i]))
    }
    print(ans)
}
