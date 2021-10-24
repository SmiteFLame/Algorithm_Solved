package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val N: Int = readLine().toInt()
    val ARR = Array(N + 1) { IntArray(N + 1) }
    for (i in 1..N) {
        val st = StringTokenizer(readLine())
        for (j in 1..N) {
            ARR[i][j] = st.nextToken().toInt()
        }
    }
    var ans = Int.MAX_VALUE
    for (x in 1..N) {
        for (y in 1..N) {
            var d1 = 1
            while (x + 1 + d1 <= N && y - d1 >= 1) {
                var d2 = 1
                while (x + d1 + d2 <= N && y + d2 <= N) {
                    val v = Array(N + 1) {
                        BooleanArray(
                            N + 1
                        )
                    }
                    for (i in 0..d1) {
                        v[x + i][y - i] = true
                        v[x + d2 + i][y + d2 - i] = true
                    }
                    for (i in 0..d2) {
                        v[x + i][y + i] = true
                        v[x + d1 + i][y - d1 + i] = true
                    }
                    for (i in x + 1 until x + d1 + d2) {
                        var j = 1
                        while (j <= N) {
                            if (v[i][j]) {
                                while (++j <= N && !v[i][j]) {
                                    v[i][j] = true
                                }
                            }
                            j++
                        }
                    }
                    var five = 0
                    for (i in 1..N) {
                        for (j in 1..N) {
                            if (v[i][j]) five += ARR[i][j]
                        }
                    }
                    var max = five
                    var min = five
                    var one = 0
                    for (i in 1 until x + d1) {
                        for (j in 1..y) {
                            if (!v[i][j]) one += ARR[i][j]
                        }
                    }
                    max = if (one > max) one else max
                    min = if (one < min) one else min
                    var two = 0
                    for (i in 1..x + d2) {
                        for (j in y + 1..N) {
                            if (!v[i][j]) two += ARR[i][j]
                        }
                    }
                    max = if (two > max) two else max
                    min = if (two < min) two else min
                    var three = 0
                    for (i in x + d1..N) {
                        for (j in 1 until y - d1 + d2) {
                            if (!v[i][j]) three += ARR[i][j]
                        }
                    }
                    max = if (three > max) three else max
                    min = if (three < min) three else min
                    var four = 0
                    for (i in x + d2 + 1..N) {
                        for (j in y - d1 + d2..N) {
                            if (!v[i][j]) four += ARR[i][j]
                        }
                    }
                    max = if (four > max) four else max
                    min = if (four < min) four else min
                    ans = if (max - min < ans) max - min else ans
                    d2++
                }
                d1++
            }
        }
    }
    println(ans)
}
