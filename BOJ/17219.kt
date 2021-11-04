package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val map = HashMap<String, String>()
    repeat(n){
        st = StringTokenizer(readLine())
        map[st.nextToken()] = st.nextToken()
    }
    val sb = StringBuilder()
    repeat(m){
        sb.append("${map[readLine()]}\n")
    }
    print(sb.toString())
}