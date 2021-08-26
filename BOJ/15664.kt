package test

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

var set = HashSet<String>()
var N : Int = 0
var M : Int = 0
var array = IntArray(0)
var answer = IntArray(0)
var sb = StringBuilder()

fun subset(idx : Int, cnt : Int){
    if(cnt == M){
        if(set.contains(answer.contentToString())) return
        answer.forEach {
            ans ->
            sb.append("$ans ")
        }
        sb.append("\n")
        set.add(answer.contentToString())
        return
    }
    if(idx == N){
        return
    }
    for(i in idx until N){
        answer[cnt] = array[i]
        subset(i + 1, cnt + 1)
    }
}


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    array = IntArray(N)
    answer = IntArray(M)
    for(i in 0 until N){
        array[i] = st.nextToken().toInt()
    }
    Arrays.sort(array)
    subset(0, 0)
    print(sb.toString())
}
