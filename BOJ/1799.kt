package test

import java.util.*

val cross = arrayOf(arrayOf(-1, - 1), arrayOf(-1, 1))
val answer = Array(2) { 0 }

var n = 0
lateinit var map: Array<Array<Int>>
lateinit var colors: Array<Array<Boolean>>
lateinit var visited: Array<Array<Boolean>>

fun check(x: Int, y: Int): Boolean{
    for(i in 0 until 2){
        var nx = x
        var ny = y
        while(true){
            if(nx < 0 || nx >= n || ny < 0 || ny >= n){
                break
            }
            if(visited[nx][ny]){
                return false
            }
            nx += cross[i][0]
            ny += cross[i][1]
        }
    }
    return true
}

fun backtracking(index: Int, color: Boolean, count: Int) {
    for(i in index until n * n){
        val x = i / n
        val y = i % n

        if(colors[x][y] != color || map[x][y] == 0 || !check(x, y)){
            continue
        }

        visited[x][y] = true
        backtracking(i + 1, color, count + 1)
        visited[x][y] = false
    }
    if(color){
        answer[0] = answer[0].coerceAtLeast(count)
    } else{
        answer[1] = answer[1].coerceAtLeast(count)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    map = Array(n) { Array(n) { 0 } }
    colors = Array(n) { Array(n) { false } }
    visited = Array(n) { Array(n) { false } }

    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        for (j in 0 until n) {
            map[i][j] = st.nextToken().toInt()
            colors[i][j] = (i % 2 == j % 2)
        }
    }

    backtracking(0, true, 0)
    backtracking(0, false, 0)

    print(answer[0] + answer[1])

}
