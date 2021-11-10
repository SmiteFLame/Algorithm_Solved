package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        val array = Array(4){0}
        for(i in 0 until 4){
            array[i] = st.nextToken().toInt()
        }
        for(i in 0 until 4){
            array[i] += st.nextToken().toInt()
        }
        sb.append("${1.coerceAtLeast(array[0]) + 5 * 1.coerceAtLeast(array[1]) + 2 * 0.coerceAtLeast(array[2]) + 2 * array[3]}\n")
    }
    print(sb.toString())
}
