package test

import java.util.*
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    var D = st.nextToken().toDouble()
    var H = st.nextToken().toDouble()
    var W = st.nextToken().toDouble()

    var res = sqrt(D.pow(2.0) / (H.pow(2.0) + W.pow(2.0)))
    print(floor(res * H).toInt().toString() + " " + floor(res * W).toInt().toString())
}
