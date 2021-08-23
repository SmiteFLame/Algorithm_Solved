package test

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap


fun main() = with(System.`in`.bufferedReader()) {
    var map = HashMap<Int, Int>()
    var N = readLine().toInt()
    var st = StringTokenizer(readLine())
    repeat(N){
        var n = st.nextToken().toInt()
        map.putIfAbsent(n, 0)
        map.replace(n, map.getValue(n) + 1)
    }
    var ans = readLine().toInt()
    if(map.containsKey(ans)){
        print(map.getValue(ans))
    } else{
        print(0)
    }
}