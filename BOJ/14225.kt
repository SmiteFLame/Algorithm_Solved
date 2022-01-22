package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val array = Array(n) { 0 }
    for (i in 0 until n) {
        array[i] = st.nextToken().toInt()
    }
    val visited = Array(2000001) { false }
    fun dfs(idx: Int, sum: Int) {
        visited[sum] = true
        if(idx == n){
            return
        }
        dfs(idx + 1, sum)
        dfs(idx + 1, sum + array[idx])

    }
    dfs(0, 0)
    for(i in visited.indices){
        if(!visited[i]){
            print(i)
            return
        }
    }
}
