package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val max = 1000000
    val n = readLine().toInt()
    val tree = Array(max * 4) { 0 }
    val sb = StringBuilder()
    fun update(node: Int, start: Int, end: Int, idx: Int, diff: Int) {
        if (idx < start || idx > end) {
            return
        }

        tree[node] += diff

        if (start == end) {
            return
        }

        val mid = (start + end) / 2
        update(node * 2, start, mid, idx, diff)
        update(node * 2 + 1, mid + 1, end, idx, diff)
    }
    fun binarySearch(node: Int, left: Int, right: Int, idx: Int): Int{
        if(left == right){
            update(1, 1, max, left, -1)
            return left
        }

        val mid = (left + right) / 2
        return if(tree[node * 2] >= idx){
            binarySearch(node * 2, left, mid, idx)
        } else{
            binarySearch(node * 2 + 1, mid + 1, right, idx - tree[node * 2])
        }
    }
    repeat(n) {
        val st = StringTokenizer(readLine())
        if(st.nextToken().toInt() == 1){
            sb.append("${binarySearch(1, 1, max, st.nextToken().toInt())}\n")
        } else{
            update(1, 1, max, st.nextToken().toInt(), st.nextToken().toInt())
        }
    }
    print(sb.toString())
}
