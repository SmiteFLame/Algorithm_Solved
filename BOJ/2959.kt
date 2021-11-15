package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val array = Array(4){0}
    val st = StringTokenizer(readLine())
    repeat(4){
        array[it] = st.nextToken().toInt()
    }
    array.sort()
    print(array[0] * array[2])
}
