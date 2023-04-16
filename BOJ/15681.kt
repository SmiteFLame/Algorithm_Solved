package test

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val q = st.nextToken().toInt()
    val next = Array(n + 1) { LinkedList<Int>() }
    repeat(n - 1) {
        st = StringTokenizer(readLine())
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()
        next[left].add(right)
        next[right].add(left)
    }

    val parent = Array(n + 1) { -1 }
    parent[0] = 0
    val queue = LinkedList<Pair<Int, Int>>()
    val parentSet = HashSet<Int>()
    val childCount = Array(n + 1) { 0 }
    queue.add(Pair(r, 0))
    while (queue.isNotEmpty()) {
        val now = queue.pop()
        parent[now.first] = now.second
        next[now.first].forEach {
            if (parent[it] == -1) {
                queue.add(Pair(it, now.first))
                parentSet.add(now.first)
                childCount[now.first]++
            }
        }
    }
    val checkQueue = LinkedList<Int>()
    for (i in 1..n) {
        if (parentSet.contains(i)) continue
        checkQueue.add(i)
    }

    val count = Array(n + 1) { 1 }

    while (checkQueue.isNotEmpty()) {
        val now = checkQueue.pop()
        count[parent[now]] = count[parent[now]] + count[now]
        childCount[parent[now]]--
        if(childCount[parent[now]] == 0) {
            checkQueue.add(parent[now])
        }
    }

    val sb = StringBuilder()
    repeat(q) {
        val now = readLine().toInt()
        sb.append("${count[now]}\n")
    }
    println(sb.toString())
}
