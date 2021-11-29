package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        var st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val index = Array(n + 1) { 0 }
        for (i in 1..n) {
            index[i] = i + m - 1
        }
        val str = SegTree(4 * (n + m), m)
        str.init(1, 0, n + m - 1)
        st = StringTokenizer(readLine())
        for (i in 0 until m) {
            val movie = st.nextToken().toInt()
            val idx = index[movie]
            sb.append("${str.sum(1, 0, n + m - 1, 0, idx - 1)} ")
            str.update(1, 0, n + m - 1, idx, -1)
            str.update(1, 0, n + m - 1, m - 1 - i, 1)
            index[movie] = m - 1 - i
        }
        sb.append("\n")
    }
    print(sb.toString())
}

class SegTree(n: Int, m: Int) {
    var tree: IntArray
    private var m: Int

    fun init(node: Int, start: Int, end: Int): Int {
        if (start == end) {
            return if (start < m) 0.also { tree[node] = it } else 1.also { tree[node] = it }
        }
        val mid = (start + end) / 2
        tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end)
        return tree[node]
    }

    fun sum(node: Int, start: Int, end: Int, left: Int, right: Int): Int {
        if (right < start || end < left) return 0
        if (left <= start && end <= right) return tree[node]
        val mid = (start + end) / 2
        return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right)
    }

    fun update(node: Int, start: Int, end: Int, idx: Int, diff: Int) {
        if (idx < start || end < idx) return
        tree[node] += diff
        if (start == end) return
        val mid = (start + end) / 2
        update(node * 2, start, mid, idx, diff)
        update(node * 2 + 1, mid + 1, end, idx, diff)
    }

    init {
        tree = IntArray(n)
        this.m = m
    }
}