package test

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val set = HashSet<Int>()
    st = StringTokenizer(readLine())
    repeat(n){
        val now = st.nextToken().toInt()
        if(set.contains(now)){
            set.remove(now)
        } else{
            set.add(now)
        }
    }
    st = StringTokenizer(readLine())
    repeat(m){
        val now = st.nextToken().toInt()
        if(set.contains(now)){
            set.remove(now)
        } else{
            set.add(now)
        }
    }
    print(set.size)
}