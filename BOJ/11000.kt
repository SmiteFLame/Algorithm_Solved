package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val data = Array<Array<Int>>(n) { Array<Int>(2) { 0 } }
    for (i in 0 until n) {
        val st = StringTokenizer(readLine())
        data[i][0] = st.nextToken().toInt()
        data[i][1] = st.nextToken().toInt()
    }

    data.sortWith(compareBy({ it[0] }, { it[1] }))

    val pQ = PriorityQueue<Int>()
    pQ.add(data[0][1])

    for(i in 1 until n){
        if(pQ.peek() <= data[i][0]){
            pQ.poll()
        }
        pQ.add(data[i][1])
    }
    print(pQ.size)
}