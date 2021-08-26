package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var N = st.nextToken().toInt()
    var K = st.nextToken().toInt()

    var parent = IntArray(100001)
    Arrays.fill(parent, -1)

    var queue = LinkedList<Int>()
    queue.add(N)

    if (N == K) {
        print("0\n$N")
        return
    }

    parent[N] = -2

    while (!queue.isEmpty()) {
        var now = queue.poll()
        if (now + 1 == K) {
            parent[now + 1] = now
            break
        } else if ( now + 1 <= 100000 && parent[now + 1] == -1) {
            parent[now + 1] = now
            queue.add(now + 1)
        }

        if (now - 1 == K) {
            parent[now - 1] = now
            break
        } else if (now - 1 >= 0 && parent[now - 1] == -1) {
            parent[now - 1] = now
            queue.add(now - 1)
        }

        if (now * 2 == K) {
            parent[now * 2] = now
            break
        } else if (now * 2 <= 100000 && parent[now * 2] == -1) {
            parent[now * 2] = now
            queue.add(now * 2)
        }
    }

    var answer = LinkedList<Int>()
    while(K != -2){
        answer.add(K)
        K = parent[K]
    }

    var sb = StringBuilder().append(answer.size - 1).append("\n")
    answer.reversed().forEach{
        ans ->
        sb.append("$ans ")
    }
    print(sb.toString())
}
