package test

import java.util.*

var answer = false
var array = Array<LinkedList<Int>>(0) { LinkedList() }
var visited = Array<Boolean>(0) { false }

fun dfs(idx: Int, cnt: Int) {
    if (cnt == 4) {
        answer = true
        return
    }
    visited[idx] = true
    array[idx].forEach { next ->
        if(!visited[next]){
            dfs(next, cnt + 1)
        }
    }
    visited[idx] = false
}


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    array = Array<LinkedList<Int>>(n) { LinkedList() }
    visited = Array<Boolean>(n) { false }
    repeat(m) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        array[a].add(b)
        array[b].add(a)
    }

    for (i in 0 until n) {
        if (answer) continue
        dfs(i, 0)
    }
    if(answer){
        print(1)
    } else{
        print(0)
    }
}
