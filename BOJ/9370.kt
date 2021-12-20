package test

import java.util.*
import kotlin.collections.ArrayList


fun main() = with(System.`in`.bufferedReader()) {

    class Node(var v: Int, var weight: Int) : Comparable<Node> {
        override operator fun compareTo(o: Node): Int {
            return weight - o.weight
        }
    }

    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        var st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val t = st.nextToken().toInt()
        st = StringTokenizer(readLine())
        val s = st.nextToken().toInt()
        val g = st.nextToken().toInt()
        val h = st.nextToken().toInt()

        val array = ArrayList<ArrayList<Node>>()
        repeat(n + 1) {
            array.add(ArrayList())
        }

        val dist = Array(n + 1) { 100000000 }

        repeat(m) {
            st = StringTokenizer(readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val d = st.nextToken().toInt()
            if (a == g && b == h || a == h && b == g) {
                array[a].add(Node(b, d * 2 - 1))
                array[b].add(Node(a, d * 2 - 1))
            } else {
                array[a].add(Node(b, d * 2))
                array[b].add(Node(a, d * 2))
            }
        }

        val visited = Array(n + 1) { false }
        val pQueue = PriorityQueue<Node>()

        dist[s] = 0
        pQueue.add(Node(s, 0))
        while (!pQueue.isEmpty()) {
            val now = pQueue.poll()

            if (visited[now.v]){
                continue
            }

            visited[now.v] = true
            array[now.v].forEach { node ->
                if (!visited[node.v] && dist[node.v] > dist[now.v] + node.weight) {
                    dist[node.v] = dist[now.v] + node.weight
                    pQueue.add(Node(node.v, dist[node.v]))
                }
            }
        }

        val answer = ArrayList<Int>()
        repeat(t){
            answer.add(readLine().toInt())
        }
        answer.sort()
        answer.forEach { now ->
            if (dist[now] % 2 == 1) {
                sb.append("$now ")
            }
        }
        sb.append("\n")
    }
    print(sb.toString())
}