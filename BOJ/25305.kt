package test

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val list = ArrayList<Int>()

    st = StringTokenizer(readLine())
    for(i in 0 until n){
        list.add(st.nextToken().toInt())
    }
    list.sort()
    print(list[n - k])
}
