package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val factory = Array(21) { 1L }
    val visited = Array(21) { false }
    for (i in 1..20) {
        factory[i] = factory[i - 1] * i
    }

    val n = readLine().toInt()
    val st = StringTokenizer(readLine())
    val array = Array(n) { 0 }
    if (st.nextToken().toInt() == 1) {
        var k = st.nextToken().toLong()
        for (i in 0 until n) {
            for (j in 1..n) {
                if (visited[j]) {
                    continue
                }
                if (factory[n - 1 - i] < k) {
                    k -= factory[n - i - 1]
                } else{
                    array[i] = j
                    visited[j] = true
                    break
                }
            }
        }
        for(i in 0 until n){
            print("${array[i]} ")
        }

    } else {
        for (i in 0 until n) {
            array[i] = st.nextToken().toInt()
        }
        var answer = 1L
        for (i in 0 until n) {
            for (j in 1 until array[i]) {
                if (!visited[j]) {
                    answer += factory[n - i - 1]
                }
            }
            visited[array[i]] = true
        }
        print(answer)
    }
}
