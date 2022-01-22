package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val k = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val array = Array(k) { 0L }
    st = StringTokenizer((readLine()))

    val pQueue = PriorityQueue<Long>()
    for(i in 0 until k){
        array[i] = st.nextToken().toLong()
        pQueue.add(array[i])
    }

    var answer = 0L
    for(i in 0 until n){
        answer = pQueue.poll()
        for(i in 0 until k){
            if (answer * array[i] >= 2L shl 30) {
                break
            }

            pQueue.offer(answer * array[i])

            if (answer % array[i] == 0L) {
                break
            }
        }
    }
    print(answer)
}
