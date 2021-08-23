package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var prime = BooleanArray(10000){true}
    for(i in 2..5000){
        if(!prime[i]) continue
        for(j in i + i until 10000 step i){
            prime[j] = false
        }
    }

    var sb = StringBuilder()

    next@
    repeat(readLine().toInt()){
        var st = StringTokenizer(readLine())
        var step =IntArray(10000){ Int.MAX_VALUE}
        var left = st.nextToken().toInt()
        var right = st.nextToken().toInt()
        step[left] = 0
        var queue : Queue<Int> = LinkedList<Int>()
        queue.add(left)
        var check : Boolean = false
        while(!queue.isEmpty()){
            var now = queue.poll()
            if(now == right){
                sb.append(step[now]).append("\n")
                check = true
                break
            }
            for(i in 0..9){
                var first = now % 1000 + i * 1000
                var second = (now / 1000) * 1000 + now % 100+ i * 100
                var third = (now / 100) * 100 + now % 10+ i * 10
                var fourth = (now / 10) * 10 + i
                if(prime[first] && first >= 1000 && step[first] > step[now] + 1){
                    step[first] = step[now] + 1
                    queue.add(first)
                }
                if(prime[second] && step[second] > step[now] + 1){
                    step[second] = step[now] + 1
                    queue.add(second)
                }
                if(prime[third] && step[third] > step[now] + 1){
                    step[third] = step[now] + 1
                    queue.add(third)
                }
                if(prime[fourth] && step[fourth] > step[now] + 1){
                    step[fourth] = step[now] + 1
                    queue.add(fourth)
                }
            }
        }
        if(!check) sb.append("Impossible\n")
    }
    print(sb.toString())
}