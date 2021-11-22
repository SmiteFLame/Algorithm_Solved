package test

import java.util.*
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n){0L}
    val st = StringTokenizer(readLine())
    val top = Array(3){0}
    var min = Long.MAX_VALUE
    for(i in 0 until n){
        array[i] = st.nextToken().toLong()
    }

    array.sort()

    for(i in 0 until n - 2){
        val start = i
        var mid = i + 1
        var end = n - 1
        while(mid < end){
            val sum = array[start] + array[mid] + array[end]
            if(min > abs(sum)){
                min = abs(sum)
                top[0] = start
                top[1] = mid
                top[2] = end
            }
            if(sum == 0L){
                break
            } else if(sum > 0L){
                end--
            } else{
                mid++
            }
        }
    }
    print("${array[top[0]]} ${array[top[1]]} ${array[top[2]]}")
}
