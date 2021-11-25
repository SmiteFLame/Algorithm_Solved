package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val start = Array(3) { 0 }
    val end = Array(3) { 0 }
    val answer = Array(3) { 0 }

    var st = StringTokenizer(readLine(), ":")
    start[0] = st.nextToken().toInt()
    start[1] = st.nextToken().toInt()
    start[2] = st.nextToken().toInt()

    st = StringTokenizer(readLine(), ":")
    end[0] = st.nextToken().toInt()
    end[1] = st.nextToken().toInt()
    end[2] = st.nextToken().toInt()

    answer[2] = end[2] - start[2]

    if (answer[2] < 0) {
        answer[2] += 60
        start[1]++
    }

    answer[1] = end[1] - start[1]

    if (answer[1] < 0) {
        answer[1] += 60
        start[0]++
    }

    answer[0] = end[0] - start[0]

    if (answer[0] < 0) {
        answer[0] += 24
    }

    print(String.format("%02d:%02d:%02d", answer[0], answer[1], answer[2]))
}
