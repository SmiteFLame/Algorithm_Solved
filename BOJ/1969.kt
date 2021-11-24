package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val dna = Array(n) { "" }
    for (i in 0 until n) {
        dna[i] = readLine()
    }

    val sb = StringBuilder()
    var answer = 0

    for (i in 0 until m) {
        val cnt = Array(4) { 0 }
        for (j in 0 until n) {
            when (dna[j][i]) {
                'A' -> cnt[0]++
                'C' -> cnt[1]++
                'G' -> cnt[2]++
                'T' -> cnt[3]++
            }
        }

        var idx = 0
        var max = 0
        for (j in 0 until 4) {
            if (cnt[j] > max || (cnt[j] == max && j < idx)) {
                max = cnt[j]
                idx = j
            }
        }

        when(idx){
            0 -> sb.append('A')
            1 -> sb.append('C')
            2 -> sb.append('G')
            3 -> sb.append('T')
        }
        answer += (n - max)
    }
    println(sb.toString())
    print(answer)
}
