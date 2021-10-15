package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val array = Array<Array<Int>>(n + 1) { Array<Int>(n + 1) { 0 } }
    for(i in 0 until m){
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        array[x][y] = 1
        array[y][x] = -1
    }

    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(array[i][k] == array[k][j] && array[i][k] != 0){
                    array[i][j] = array[i][k]
                }
            }
        }
    }

    val sb = StringBuilder()
    for(i in 1..n){
        var cnt = -1
        for(j in 1..n){
            if(array[i][j] == 0){
                cnt++
            }
        }
        sb.append("$cnt\n")
    }
    print(sb.toString())
}