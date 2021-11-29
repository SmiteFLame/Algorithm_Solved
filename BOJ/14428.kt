package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n + 1) { 0 }
    val tree = Array(n * 4) { 0 }
    var st = StringTokenizer(readLine())
    for (i in 1..n) {
        array[i] = st.nextToken().toInt()
    }
    fun init(start: Int, end: Int, node: Int) {
        if (start == end) {
            tree[node] = start
        } else {
            val mid = (start + end) / 2
            init(start, mid, node * 2)
            init(mid + 1, end, node * 2 + 1)
            if (array[tree[node * 2]] <= array[tree[node * 2 + 1]]) {
                tree[node] = tree[node * 2]
            } else {
                tree[node] = tree[node * 2 + 1]
            }
        }
    }

    init(1, n, 1)

    fun get(start: Int, end: Int, node: Int, left: Int, right: Int): Int {
        if (left > end || right < start) {
            return -1
        }
        if (left <= start && end <= right) {
            return tree[node]
        }
        val mid = (start + end) / 2
        val m1 = get(start, mid, node * 2, left, right)
        val m2 = get(mid + 1, end, node * 2 + 1, left, right)
        return if (m1 == -1) {
            m2
        } else if (m2 == -1) {
            m1
        } else if (array[m1] <= array[m2]) {
            m1
        } else {
            m2
        }
    }

    fun update(start: Int, end: Int, node: Int, idx: Int, now: Int) {
        if (idx < start || idx > end) {
            return
        }

        if (start == end) {
            tree[node] = idx
            array[idx] = now
            return
        }
        val mid = (start + end) / 2

        update(start, mid, node * 2, idx, now)
        update(mid + 1, end, node * 2 + 1, idx, now)
        if (array[tree[node * 2]] <= array[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2]
        } else {
            tree[node] = tree[node * 2 + 1]
        }
    }

    val sb = StringBuilder()
    repeat(readLine().toInt()){
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        if (a == 1) {
            update(1, n, 1, b, c)
        } else if (a == 2) {
            sb.append("${get(1, n, 1, b, c)}\n")
        }
    }
    print(sb.toString())
}

