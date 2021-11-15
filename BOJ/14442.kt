package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val news = arrayOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))

    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val board = Array(n) { Array(m) { 0 } }
    val visited = Array(n) { Array(m) { Array(k + 1) { false } } }

    for (i in 0 until n) {
        val str = readLine()
        for (j in 0 until m) {
            board[i][j] = str[j] - '0'
        }
    }

    val queue = LinkedList<Pair<Pair<Int, Int>, Pair<Int, Int>>>()
    queue.add(Pair(Pair(0, 0), Pair(1, 0)))
    while(!queue.isEmpty()){
        val now = queue.poll()
        if(now.first.first == n - 1 && now.first.second == m - 1){
            print(now.second.first)
            return
        }
        for(x in 0 until 4){
            val nx = now.first.first + news[x].first
            val ny = now.first.second + news[x].second
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue
            if(board[nx][ny] == 1){
                if(now.second.second < k && !visited[nx][ny][now.second.second + 1]){
                    visited[nx][ny][now.second.second + 1] = true
                    queue.offer(Pair(Pair(nx, ny), Pair(now.second.first + 1, now.second.second + 1)))
                }
            } else{
                if(!visited[nx][ny][now.second.second]){
                    visited[nx][ny][now.second.second] = true
                    queue.offer(Pair(Pair(nx, ny), Pair(now.second.first + 1, now.second.second)))
                }
            }
        }
    }
    print(-1)
}
