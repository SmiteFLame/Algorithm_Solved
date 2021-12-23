package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {

    class Point(var x: Int, var y: Int, var count: Int) : Comparable<Point> {
        override operator fun compareTo(other: Point): Int {
            return other.count - count
        }
    }

    fun canMove(x: Int, y: Int, w: Int, h: Int): Boolean {
        return !(x < 0 || y < 0 || x > w + 1 || y > h + 1)
    }


    val news = arrayOf(arrayOf(1, 0), arrayOf(-1, 0), arrayOf(0, 1), arrayOf(0, -1))
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val h = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        val map = Array(h + 2) { Array(w + 2) { '.' } }
        val visit = Array(h + 2) { Array(w + 2) { Array('z' - 'a' + 2) { false } } }

        val hasKey = Array('z'.toInt() + 1) { false }

        for (i in 1..h) {
            val chars = readLine().toCharArray()
            for (j in chars.indices) {
                map[i][j + 1] = chars[j]
            }
        }

        val key = readLine()
        var count = 0
        if (key != "0") {
            val keys = key.toCharArray()
            count = keys.size
            for (c in keys) {
                hasKey[c.toInt()] = true
            }
        }

        val queue = PriorityQueue<Point>()
        queue.add(Point(0, 0, count))

        var answer = 0


        while (!queue.isEmpty()) {
            val now = queue.poll()
            var nowKey: Int = now.count

            if (nowKey < count) break
            visit[now.y][now.x][nowKey] = true
            for (x in 0 until 4) {
                val nx = now.x + news[x][0]
                val ny = now.y + news[x][1]

                if (!canMove(nx, ny, w, h) || visit[ny][nx][nowKey] || (map[ny][nx] == '*')) {
                    continue
                }

                if (map[ny][nx] == '.') {
                    queue.add(Point(nx, ny, nowKey))
                } else if (hasKey[map[ny][nx].toInt()]) {
                    map[ny][nx] = '.'
                    queue.add(Point(nx, ny, nowKey))
                } else if (map[ny][nx] in 'a'..'z' && !hasKey[map[ny][nx].toInt()]) {
                    hasKey[map[ny][nx].toInt()] = true
                    map[ny][nx] = '.'
                    nowKey++
                    count++
                    queue.add(Point(nx, ny, nowKey))
                } else if (map[ny][nx] in 'A'..'Z') {
                    val door = map[ny][nx]
                    val needKey = Character.toLowerCase(door)
                    if (hasKey[needKey.toInt()]) {
                        map[ny][nx] = '.'
                        queue.add(Point(nx, ny, nowKey))
                    }
                } else if (map[ny][nx] == '$') {
                    answer++
                    map[ny][nx] = '.'
                    queue.add(Point(nx, ny, nowKey))
                }
            }
        }
        sb.append("$answer\n")
    }
    print(sb.toString())
}
