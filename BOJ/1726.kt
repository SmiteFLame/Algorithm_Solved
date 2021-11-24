package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    data class Robot(
        val x: Int,
        val y: Int,
        val dir: Int,
        val cnt: Int
    )

    val news = arrayOf(arrayOf(), arrayOf(0, 1), arrayOf(0, -1), arrayOf(1, 0), arrayOf(-1, 0))

    var st = StringTokenizer(readLine())
    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val map = Array(m + 1) { Array(n + 1) { 0 } }
    val visited = Array(m + 1) { Array(n + 1) { Array(5) { false } } }

    for (i in 1..m) {
        st = StringTokenizer(readLine())
        for (j in 1..n) {
            map[i][j] = st.nextToken().toInt()
        }
    }

    st = StringTokenizer(readLine())
    val start = Robot(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt(), 0)
    st = StringTokenizer(readLine())
    val end = Robot(st.nextToken().toInt(), st.nextToken().toInt(), st.nextToken().toInt(), 0)

    val queue = LinkedList<Robot>()
    visited[start.x][start.y][start.dir] = true

    queue.add(start)

    while (!queue.isEmpty()) {
        val now = queue.poll()

        if (now.x == end.x && now.y == end.y && now.dir == end.dir) {
            print(now.cnt)
            return
        }

        for (i in 1..3) {
            val nx = now.x + (news[now.dir][0] * i)
            val ny = now.y + (news[now.dir][1] * i)
            if (nx <= 0 || ny <= 0 || nx > m || ny > n) continue
            if (map[nx][ny] == 0) {
                if (visited[nx][ny][now.dir]) continue
                visited[nx][ny][now.dir] = true
                queue.add(Robot(nx, ny, now.dir, now.cnt + 1))
            } else {
                break
            }
        }

        for (i in 1..4) {
            if (now.dir != i && !visited[now.x][now.y][i]) {
                var turn = 1
                if (now.dir == 1) {
                    if (i == 2) {
                        turn++
                    }
                } else if (now.dir == 2) {
                    if (i == 1) {
                        turn++
                    }
                } else if (now.dir == 3) {
                    if (i == 4) {
                        turn++
                    }
                } else {
                    if (i == 3) {
                        turn++
                    }
                }
                visited[now.x][now.y][i] = true
                queue.add(Robot(now.x, now.y, i, now.cnt + turn))
            }
        }
    }

}
