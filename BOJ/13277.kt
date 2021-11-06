package test

import java.math.BigInteger
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    print(BigInteger(st.nextToken()).multiply(BigInteger(st.nextToken())))
}