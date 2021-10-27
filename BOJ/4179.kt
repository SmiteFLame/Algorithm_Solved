package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val news = arrayOf(arrayOf(-1, 0), arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1))
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val array = Array(n) { Array(m) { 0 } }

    val playerQueue = LinkedList<Triple<Int, Int, Int>>()
    val fireQueue = LinkedList<Pair<Int, Int>>()

    for (i in 0 until n) {
        val s = readLine()
        for (j in 0 until m) {
            when(s[j]){
                '#' -> array[i][j] = -1
                '.' -> array[i][j] = Int.MAX_VALUE
                'J' -> {
                    array[i][j] = 0
                    playerQueue.offer(Triple(i, j, 0))
                }
                'F' -> {
                    array[i][j] = -1
                    fireQueue.offer(Pair(i, j))
                }
            }
        }
    }

    while(playerQueue.size != 0){
        val endF = fireQueue.size
        for(i in 0 until endF){
            val now = fireQueue.poll()
            for(x in 0 until 4){
                val nx = now.first + news[x][0]
                val ny = now.second + news[x][1]
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue
                if(array[nx][ny] == -1) continue
                array[nx][ny] = -1
                fireQueue.add(Pair(nx, ny))
            }
        }
        val endP = playerQueue.size
        for(i in 0 until endP){
            val now = playerQueue.poll()
            for(x in 0 until 4){
                val nx = now.first + news[x][0]
                val ny = now.second + news[x][1]
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    print(now.third + 1)
                    return
                }
                if(array[nx][ny] == -1) continue
                array[nx][ny] = -1
                playerQueue.offer(Triple(nx, ny, now.third + 1))
            }
        }
    }
    print("IMPOSSIBLE")
}
