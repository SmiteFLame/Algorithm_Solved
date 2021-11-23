package test

import java.util.*
import kotlin.collections.HashMap

fun main() = with(System.`in`.bufferedReader()) {
    val map = HashMap<Int, String>()
    val arrayList = LinkedList<Int>()
    repeat(readLine().toInt()){
        val st = StringTokenizer(readLine())
        val name = st.nextToken()
        val day = st.nextToken().toInt() + st.nextToken().toInt() * 30 + st.nextToken().toInt() * 365
        arrayList.add(day)
        map[day] = name
    }

    arrayList.sort()
    println(map[arrayList.last])
    println(map[arrayList.first])


}
