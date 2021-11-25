package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()) {
        var st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val d = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        val connect = Array(n + 1) { ArrayList<Pair<Int, Int>>() }
        for (i in 0 until d) {
            st = StringTokenizer(readLine())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            val s = st.nextToken().toInt()
            connect[b].add(Pair(a, s))
        }

        val hacked = Array(n + 1) { Int.MAX_VALUE }
        hacked[0] = 0
        hacked[c] = 0

        val pQueue = PriorityQueue<Int>()

        pQueue.offer(c)

        while(!pQueue.isEmpty()){
            val now = pQueue.poll()

            connect[now].forEach { next ->
                if(hacked[next.first] > hacked[now] + next.second){
                    hacked[next.first] = hacked[now] + next.second
                    pQueue.offer(next.first)
                }
            }
        }

        var answer = 0
        var cnt = 0
        for(i in 1..n){
            if(hacked[i] == Int.MAX_VALUE) continue
            cnt++
            if(hacked[i] > answer){
                answer = hacked[i]
            }
        }
        sb.append("$cnt $answer\n")
    }

    print(sb.toString())
}
