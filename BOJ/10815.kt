package test

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val set = HashSet<Int>()
    var st = StringTokenizer(readLine())
    repeat(n) {
        set.add(st.nextToken().toInt())
    }
    val m = readLine().toInt()
    st = StringTokenizer(readLine())
    val answer = ArrayList<Int>()
    repeat(m) {
        val now = st.nextToken().toInt()
        answer.add(if(set.contains(now)) 1 else 0)
    }
    println(answer.joinToString(" "))
}
