package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val sc = Array(4){0}
    val so = Array(2){0}
    var sum = 0
    for(i in 0 until 4){
        sc[i] = readLine().toInt()
        sum += sc[i]
    }
    for(i in 0 until 2){
        so[i] = readLine().toInt()
    }
    Arrays.sort(sc)
    Arrays.sort(so)
    sum -= sc[0]
    sum += so[1]
    print(sum)
}
