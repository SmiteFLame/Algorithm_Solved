package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    var t = readLine().toInt()
    var arr = LongArray(t)
    var st = StringTokenizer(readLine())
    var treeMap = TreeMap<Long, LinkedList<Int>>()
    var answer = LongArray(t)
    for(i in 0 until t){
        arr[i] = st.nextToken().toLong()
        treeMap.putIfAbsent(arr[i], LinkedList<Int>())
        treeMap.get(arr[i])?.add(i)
    }
    var idx = 0L
    treeMap.forEach{
        (k, v) ->
        v.forEach{
            n ->
            answer[n] = idx
        }
        idx++
    }
    var sb = StringBuilder("")
    answer.forEach {
        n ->
        sb.append("$n ")
    }
    println(sb.toString())
}