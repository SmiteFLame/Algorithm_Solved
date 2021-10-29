package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n: Int = st.nextToken().toInt()
    val m: Int = st.nextToken().toInt()
    val t: Int = st.nextToken().toInt()
    var arr = Array(n + 1) { IntArray(m) }
    for (i in 1..n) {
        st = StringTokenizer(readLine())
        for (j in 0 until m) {
            arr[i][j] = st.nextToken().toInt()
        }
    }
    for (t in 0 until t) {
        st = StringTokenizer(readLine())
        val X: Int = st.nextToken().toInt()
        val D: Int = st.nextToken().toInt()
        val K: Int = st.nextToken().toInt()
        if (D == 1) {
            var x = X
            while (x <= n) {
                for (k in 0 until K) {
                    val a = arr[x][0]
                    for (l in 0 until m - 1) {
                        arr[x][l] = arr[x][l + 1]
                    }
                    arr[x][m - 1] = a
                }
                x += X
            }
        } else {
            var x = X
            while (x <= n) {
                for (k in 0 until K) {
                    val a = arr[x][m - 1]
                    for (l in m - 1 downTo 1) {
                        arr[x][l] = arr[x][l- 1]
                    }
                    arr[x][0] = a
                }
                x += X
            }
        }
        var flag = false
        val arr2 = Array(n + 1) { IntArray(m) }
        for (i in 1..n) {
            System.arraycopy(arr[i], 0, arr2[i], 0, m)
        }
        for (i in 1..n) {
            for (j in 0 until m) {
                val a = arr[i][j]
                if (a != 0) {
                    if (i > 1 && arr[i - 1][j] == a) {
                        arr2[i - 1][j] = 0
                        arr2[i][j] = 0
                        flag = true
                    }
                    if (i < n && arr[i + 1][j] == a) {
                        arr2[i + 1][j] = 0
                        arr2[i][j] = 0
                        flag = true
                    }
                    if (j > 0 && arr[i][j - 1] == a) {
                        arr2[i][j - 1] = 0
                        arr2[i][j] = 0
                        flag = true
                    }
                    if (j < m - 1 && arr[i][j + 1] == a) {
                        arr2[i][j + 1] = 0
                        arr2[i][j] = 0
                        flag = true
                    }
                    if (j == 0 && arr[i][m - 1] == a) {
                        arr2[i][m - 1] = 0
                        arr2[i][j] = 0
                        flag = true
                    }
                    if (j == m - 1 && arr[i][0] == a) {
                        arr2[i][0] = 0
                        arr2[i][j] = 0
                        flag = true
                    }
                }
            }
        }
        arr = arr2
        if (!flag) {
            var sum = 0
            var cnt = 0
            for (i in 1..n) {
                for (j in 0 until m) {
                    sum += arr[i][j]
                    if (arr[i][j] != 0) cnt++
                }
            }
            val mean = 1.0 * sum / cnt
            for (i in 1..n) {
                for (j in 0 until m) {
                    if (arr[i][j] == 0) continue else if (arr[i][j] < mean) arr[i][j]++ else if (arr[i][j] > mean) arr[i][j]--
                }
            }
        }
    }
    var ans = 0
    for (i in 1..n) {
        for (j in 0 until m) {
            ans += arr[i][j]
        }
    }
    println(ans)
}
