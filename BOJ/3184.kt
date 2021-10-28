package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val news = arrayOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))

    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val array = Array(n) { "" }
    val visited = Array(n) { Array(m) { false } }
    for (i in 0 until n) {
        array[i] = readLine()
    }
    var sheep = 0
    var wolf = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if(array[i][j] == '#' || visited[i][j]) continue
            var nowSheep = 0
            var nowWolf = 0
            val queue = LinkedList<Pair<Int, Int>>()
            queue.add(Pair(i, j))
            visited[i][j] = true
            while(!queue.isEmpty()){
                val now = queue.poll()
                if(array[now.first][now.second] == 'o'){
                    nowSheep++
                } else if(array[now.first][now.second] == 'v'){
                    nowWolf++
                }

                for(x in 0 until 4){
                    val nx = now.first + news[x].first
                    val ny = now.second + news[x].second
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || array[nx][ny] == '#') continue
                    visited[nx][ny] = true
                    queue.add(Pair(nx, ny))
                }
            }

            if(nowSheep > nowWolf){
                sheep += nowSheep
            } else{
                wolf += nowWolf
            }
        }
    }

    print("$sheep $wolf")
}
