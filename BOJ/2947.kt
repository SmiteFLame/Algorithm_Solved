package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val array = Array(5) { 0 }
    val st = StringTokenizer(readLine())
    for (i in 0 until 5) {
        array[i] = st.nextToken().toInt()
    }
    val sb = StringBuilder()
    for(i in 0 until 4){
        for(j in 0 until 4){
            if(array[j] > array[j + 1]){
                val tmp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = tmp
                array.forEach { now ->
                    sb.append("$now ")
                }
                sb.append("\n")
            }
        }
    }
    print(sb.toString())
}