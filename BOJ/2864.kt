package test

import chap03.section1.b
import chap03.section1.c
import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
   var st = StringTokenizer(readLine())
    var A = st.nextToken()
    var B = st.nextToken()

    var mA = A.replace('6', '5')
    var mB = B.replace('6', '5')
    var MA = A.replace('5', '6')
    var MB = B.replace('5', '6')

    print(mA.toInt() + mB.toInt())
    print(" ")
    print(MA.toInt() + MB.toInt())
}
