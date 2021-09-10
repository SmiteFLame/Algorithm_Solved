package test

import java.lang.StringBuilder
import java.util.*
import kotlin.math.round

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        var N = 0;
        var G = 0.0;
        repeat(readLine().toInt()){
            val st = StringTokenizer(readLine())
            val now = st.nextToken().toInt()
            N += now
            G += (now * st.nextToken().toDouble())
        }
        sb.append(N.toString() + " " + round((G / N) * 10) / 10 + "\n");
    }
    print(sb.toString())
}
