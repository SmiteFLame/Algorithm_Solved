package test

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()){
        var s = readLine().toInt()
        repeat(readLine().toInt()){
            val st = StringTokenizer(readLine())
            s += st.nextToken().toInt() * st.nextToken().toInt()
        }
        println(s)
    }
}
