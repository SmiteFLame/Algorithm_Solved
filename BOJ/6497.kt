package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var parent = Array(0) { 0 }

    class Edge(var start: Int, var end: Int, var weight: Int) : Comparable<Edge> {
        override operator fun compareTo(other: Edge): Int {
            return weight - other.weight
        }
    }

    fun find(x: Int): Int {
        return if (x == parent[x]) {
            x
        } else find(parent[x]).also { parent[x] = it }
    }

    fun union(x: Int, y: Int) {
        val px = find(x)
        val py = find(y)
        if (px != py) {
            parent[py] = px
        }
    }

    val sb = StringBuilder()
    while (true) {
        var st = StringTokenizer(readLine())
        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()
        if (m == 0 && n == 0) {
            break
        }

        parent = Array(m) { 0 }
        for (i in 0 until m) {
            parent[i] = i
        }

        val arrayList = ArrayList<Edge>()
        var sum = 0
        repeat(n) {
            st = StringTokenizer(readLine())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()
            val z = st.nextToken().toInt()
            sum += z
            arrayList.add(Edge(x, y, z))
        }

        arrayList.sort()

        var answer = 0
        arrayList.forEach { now ->
            if(find(now.start) != find(now.end)){
                union(now.start, now.end)
                answer += now.weight
            }
        }
        sb.append("${sum - answer}\n")
    }

    print(sb.toString())
}
