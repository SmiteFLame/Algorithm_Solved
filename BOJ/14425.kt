package test

import java.util.*
import kotlin.collections.HashSet


fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val set = HashSet<String>()
    repeat(n){
        set.add(readLine())
    }
    var answer = 0
    repeat(m){
        if(set.contains(readLine())){
            answer++
        }
    }
    print(answer)
}
