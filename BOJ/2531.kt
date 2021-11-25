package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val d = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    val array = Array(n) { 0 }

    for (i in 0 until n) {
        array[i] = readLine().toInt()
    }

    var answer = 0
    for (i in 0 until n) {
        var count = 1
        val visited = Array(d + 1) { false }
        for (j in i until (i + k)) {
            if (!visited[array[j % n]]) {
                visited[array[j % n]] = true
                count++
                if (array[j % n] == c) {
                    count--
                }
            }
        }

        answer = answer.coerceAtLeast(count)
    }
    print(answer)
}
