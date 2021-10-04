package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val array = Array<Pair<Int, Int>>(n) { Pair(0, 0) }
    for (i in 0 until n) {
        array[i] = Pair(st.nextToken().toInt(), i)
    }
    array.sortWith(Comparator { o1, o2 ->
        if(o1.first == o2.first){
            o1.second.compareTo(o2.second)
        } else{
            o1.first.compareTo(o2.first)
        }
    })

    val answer = Array<Int>(n){0}
    for(i in 0 until n){
        answer[array[i].second] = i
    }
    val sb = StringBuilder()
    answer.forEach { n ->
        sb.append("$n ")
    }
    print(sb.toString())

}