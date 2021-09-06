package test

import java.util.*
import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
    var set = HashSet<Int>()
    var N = readLine().toInt()
    var st = StringTokenizer(readLine())
    var answer = 0
    repeat(N){
        val now = st.nextToken().toInt()
        if(set.contains(now)){
            answer++
        } else{
            set.add(now)
        }
    }
    print(answer)
}
