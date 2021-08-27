package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()

    var ary = Array<Int>(N + 1){ 0 }
    var cnt = Array<Int>(N + 1){ 0 }
    var array = Array<LinkedList<Int>>(N + 1){ LinkedList() }
    var answer = Array<Int>(N + 1){0}

    for(i in 1..N){
        var st = StringTokenizer(readLine())
        ary[i] = st.nextToken().toInt()
        var next = st.nextToken().toInt()
        while(next != -1){
            cnt[i]++
            array[next].add(i)
            next = st.nextToken().toInt()
        }
    }

    var queue = LinkedList<Int>()
    for(i in 1..N){
        if(cnt[i] == 0){
            queue.add(i)
            answer[i] = ary[i]
        }
    }

    while(!queue.isEmpty()){
        var now = queue.poll()
        array[now].forEach{
            next ->
            cnt[next]--
            answer[next] = Math.max(answer[next], answer[now] + ary[next])
            if(cnt[next] == 0){
                queue.add(next)
            }
        }
    }

    for(i in 1..N){
        println(answer[i])
    }
}
