package test

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    repeat(readLine().toInt()){
        val set = HashSet<Int>()
        val n = readLine().toInt()
        var st = StringTokenizer(readLine())
        repeat(n){
            set.add(st.nextToken().toInt())
        }
        val m = readLine().toInt()
        st = StringTokenizer(readLine())
        repeat(m){
            if(set.contains(st.nextToken().toInt())){
                sb.append("1\n")
            } else{
                sb.append("0\n")
            }
        }
    }
    print(sb.toString())
}
