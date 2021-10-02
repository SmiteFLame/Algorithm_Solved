package test

import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array<Int>(n + 1) { 0 }

    val st = StringTokenizer(readLine())
    for(i in 1..n){
        array[i] = st.nextToken().toInt()
    }

    val list = ArrayList<Int>()
    list.add(Int.MIN_VALUE)
    for(i in 1..n){
        val now = array[i]
        var left = 1
        var right = list.size - 1

        if(now > list.last()){
            list.add(now)
        } else{
            while(left < right){
                val mid  = (left + right) / 2
                if(list[mid] >= now){
                    right = mid
                } else{
                    left = mid + 1
                }
            }
            list[right] = now
        }
    }
    print(list.size - 1)
}