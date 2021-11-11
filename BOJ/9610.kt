package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val array = Array(5) { 0 }
    repeat(readLine().toInt()) {
        val st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        if (x > 0) {
            if (y > 0) {
                array[1]++
            } else if (y < 0) {
                array[4]++
            } else{
                array[0]++
            }
        } else if (x < 0) {
            if (y > 0) {
                array[2]++
            } else if (y < 0) {
                array[3]++
            } else{
                array[0]++
            }
        } else {
            array[0]++
        }
    }
    val sb = StringBuilder()
    sb.append("Q1: ${array[1]}\n")
    sb.append("Q2: ${array[2]}\n")
    sb.append("Q3: ${array[3]}\n")
    sb.append("Q4: ${array[4]}\n")
    sb.append("AXIS: ${array[0]}\n")
    print(sb.toString())
}
