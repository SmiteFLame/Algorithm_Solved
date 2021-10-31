package test

import java.lang.StringBuilder
import java.util.*

var n: Int = 0
var m: Int = 0
var k: Int = 0
var array = Array<Long>(0) { 0 }
var tree = Array<Long>(0) { 0 }
var temp = Array<Long>(0) { 0 }

fun init(node: Int, start: Int, end: Int): Long {
    if (start == end) {
        tree[node] = array[start]
    } else {
        val mid = (start + end) / 2
        tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end)
    }
    return tree[node]
}

fun update(node: Int, start: Int, end: Int, left: Int, right: Int, change: Long) {
    updateTemp(node, start, end)
    if (left > end || right < start) return

    if (left <= start && end <= right) {
        tree[node] += (end - start + 1) * change
        if (start != end) {
            temp[node * 2] += change
            temp[node * 2 + 1] += change
        }
    } else {
        val mid = (start + end) / 2
        update(node * 2, start, mid, left, right, change)
        update(node * 2 + 1, mid + 1, end, left, right, change)
        tree[node] = tree[node * 2] + tree[node * 2 + 1]
    }
}

fun updateTemp(node: Int, start: Int, end: Int) {
    if (temp[node] == 0L) return
    tree[node] += (end - start + 1) * temp[node]
    if (start != end) {
        temp[node * 2] += temp[node]
        temp[node * 2 + 1] += temp[node]
    }
    temp[node] = 0
}

fun sum(node: Int, start: Int, end: Int, left: Int, right: Int): Long {
    updateTemp(node, start, end)
    if (left > end || right < start) return 0L
    if (left <= start && right >= end) return tree[node]
    val mid = (start + end) / 2
    return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
}

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    k = st.nextToken().toInt()

    array = Array<Long>(n + 1) { 0L }
    tree = Array<Long>(n * 4) { 0L }
    temp = Array<Long>(n * 4) { 0L }

    for (i in 1..n) {
        st = StringTokenizer(readLine())
        array[i] = st.nextToken().toLong()
    }

    init(1, 1, n)

    val sb = StringBuilder()
    for (i in 1..(m + k)) {
        st = StringTokenizer(readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        val z = st.nextToken().toInt()
        if (x == 1) {
            update(1, 1, n, y, z, st.nextToken().toLong())
        } else {
            sb.append("${sum(1, 1, n, y, z)}\n")
        }
    }
    print(sb.toString())
}