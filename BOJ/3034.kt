package test

import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val max = sqrt(st.nextToken().toDouble().pow(2) + st.nextToken().toDouble().pow(2))
    val sb = StringBuilder()
    repeat(n){
        val x = readLine().toInt()
        if(max >= x){
            sb.append("DA\n")
        } else{
            sb.append("NE\n")
        }
    }
    print(sb.toString())
}