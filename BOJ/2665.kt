package test

import java.util.*

val news = arrayOf(Node(1, 0), Node(-1, 0), Node(0, 1), Node(0, -1))

data class Node(
    val X: Int,
    val Y: Int
)

fun canMove(X: Int, Y: Int, n: Int): Boolean {
    if (X < 0 || Y < 0 || X >= n || Y >= n) {
        return false
    }
    return true
}

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val array = Array<Array<Int>>(n) { Array<Int>(n) { 0 } }
    val visited = Array<Array<Int>>(n) { Array<Int>(n) { Int.MAX_VALUE } }
    for (i in 0 until n) {
        val str = readLine()
        for (j in 0 until n) {
            array[i][j] = str[j] - '0'
        }
    }

    val queue = LinkedList<Node>()
    queue.add(Node(0, 0))
    visited[0][0] = 0
    while (!queue.isEmpty()) {
        val now = queue.poll()
        for (k in 0 until 4) {
            val nx = now.X + news[k].X
            val ny = now.Y + news[k].Y
            if (!canMove(nx, ny, n) || visited[nx][ny] <= visited[now.X][now.Y]) continue
            queue.add(Node(nx, ny))
            visited[nx][ny] = visited[now.X][now.Y]
            if(array[nx][ny] != 1){
                visited[nx][ny]++
            }
        }
    }

    print(visited[n - 1][n - 1])
}
