package test

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()){
        var data = ArrayList<Int>()
        val st = StringTokenizer(readLine())
        repeat(10){
            data.add(st.nextToken().toInt())
        }
        data.sort()
        println(data[7])
    }
}
