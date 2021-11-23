package test

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n + 1) { Array(n + 1) { 5000 } }
    for(i in 1..n){
        array[i][i] = 0
    }

    while(true){
        val st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if(a == -1 && b == -1){
            break
        }

        array[a][b] = 1
        array[b][a] = 1
    }

    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                array[i][j] = array[i][j].coerceAtMost(array[i][k] + array[k][j])
            }
        }
    }

    val arrayList = ArrayList<Int>()
    var min = Int.MAX_VALUE

    for(i in 1..n){
        var max = 0
        for(j in 1..n){
            max = max.coerceAtLeast(array[i][j])
        }
        if(max < min){
            arrayList.clear()
            arrayList.add(i)
            min = max
        } else if(max == min){
            arrayList.add(i)
        }
    }

    val sb = StringBuilder()
    sb.append("$min ${arrayList.size}\n")
    arrayList.forEach { now ->
        sb.append("$now ")
    }
    print(sb.toString())
}
