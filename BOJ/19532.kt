package test

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val x1 = st.nextToken().toInt()
    val y1 = st.nextToken().toInt()
    val a1 = st.nextToken().toInt()
    val x2 = st.nextToken().toInt()
    val y2 = st.nextToken().toInt()
    val a2 = st.nextToken().toInt()
    for (i in -999..999) {
        for (j in -999..999) {
            if ((x1 * i) + (y1 * j) == a1 && (x2 * i) + (y2 * j) == a2) {
                println("$i $j")
            }
        }
    }
}
