package test

import java.util.*
import kotlin.collections.HashMap

fun main() = with(System.`in`.bufferedReader()) {
    val dp = Array(101) { Int.MAX_VALUE }
    val map = HashMap<Int, Int>()
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt() + st.nextToken().toInt()
    repeat(n){
        st = StringTokenizer(readLine())
        map[st.nextToken().toInt()] = st.nextToken().toInt()
    }

    val queue = LinkedList<Int>()
    queue.offer(1)
    dp[1] = 0
    while(!queue.isEmpty()){
        val now = queue.poll()
        for(x in 1..6){
            var next = now + x
            if(next > 100) continue
            if(map.containsKey(next)){
               next = map[next]!!
            }
            if(dp[next] <= dp[now] + 1) continue

            dp[next] = dp[now] + 1

            if(next == 100){
                print(dp[next])
                return
            }

            queue.offer(next)

        }
    }
}
