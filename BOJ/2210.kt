package test

import java.util.*

val array = Array<Array<Int>>(5) { Array<Int>(5) { 0 } }
val set = HashSet<String>()

val news = arrayOf(arrayOf(-1, 0), arrayOf(1, 0), arrayOf(0, -1), arrayOf(0, 1))

fun dfs(idx: Int, X: Int, Y: Int, str: String) {
    if (idx == 5) {
        set.add(str)
        return
    }
    news.forEach { now ->
        val nx = X + now[0]
        val ny = Y + now[1]
        if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5){
            dfs(idx + 1, nx, ny, str + array[nx][ny].toString())
        }
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    for (i in 0 until 5) {
        val st = StringTokenizer(readLine())
        for (j in 0 until 5) {
            array[i][j] = st.nextToken().toInt()
        }
    }

    for (i in 0 until 5) {
        for (j in 0 until 5) {
            dfs(0, i, j, array[i][j].toString())
        }
    }

    print(set.size)
}