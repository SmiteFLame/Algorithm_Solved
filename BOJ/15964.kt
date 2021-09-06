package test

import java.util.*
import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var A = st.nextToken().toLong()
    var B = st.nextToken().toLong()
    print((A + B) * (A - B))
}
