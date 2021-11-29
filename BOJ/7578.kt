package test

import java.util.*
import kotlin.collections.HashMap

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val tree = Array(n * 4) { 0L }
    val list = Array(n + 1){0}
    var st = StringTokenizer(readLine())
    for(i in 1..n){
        list[i] = st.nextToken().toInt()
    }

    val map = HashMap<Int, Int>()
    st = StringTokenizer(readLine())
    for(i in 1..n){
        map[st.nextToken().toInt()] = i
    }

    fun sum(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
        if (end < left || right < start) {
            return 0
        }
        if (left <= start && end <= right) {
            return tree[node]
        }
        val mid = (start + end) / 2
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right)
    }

    fun update(start: Int, end: Int, node: Int, idx: Int, dif: Int) {
        if (idx < start || idx > end) {
            return
        }
        tree[node] += dif.toLong()
        if (start != end) {
            val mid = (start + end) / 2
            update(start, mid, node * 2, idx, dif)
            update(mid + 1, end, node * 2 + 1, idx, dif)
        }
    }

    var answer = 0L

    for(i in 1..n){
        val left = list[i]
        val right = map[left]!!

        answer += sum(1, n, 1, right + 1, n)
        update(1, n, 1, right, 1)
    }

    print(answer)
}
