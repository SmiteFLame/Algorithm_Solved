package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val row = Array(n) { false }
    val col = Array(m) { false }

    for (i in 0 until n) {
        val str = readLine()
        for (j in 0 until m) {
            if(str[j] == 'X') {
                row[i] = true
                col[j] = true
            }
        }
    }
    var rowCount = 0
    var colCount = 0
    row.forEach { now ->
        if(!now) rowCount++
    }
    col.forEach { now ->
        if(!now) colCount++
    }

    print(rowCount.coerceAtLeast(colCount))

}
