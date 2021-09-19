package test

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    val array = Array(n) { 0 }
    val index = Array(n) { 0 }
    val listSize = ArrayList<Int>()
    listSize.add(Int.MIN_VALUE)
    val st = StringTokenizer(readLine())
    for(i in 0 until n){
        array[i] = st.nextToken().toInt()
    }

    for(i in 0 until n){
        if(listSize[listSize.size - 1] < array[i]){
            listSize.add(array[i])
            index[i] = listSize.size - 1
            continue
        }
        var left = 1
        var right = listSize.size - 1
        while(left < right){
            val mid = (left + right) / 2
            if(listSize[mid] < array[i]){
                left = mid + 1
            } else{
                right = mid
            }
        }
        listSize[right] = array[i]
        index[i] = right
    }

    var temp = listSize.size - 1

    sb.append("${listSize.size - 1}\n")
    val list = ArrayList<Int>()
    for(i in n - 1 downTo 0){
        if(index[i] == temp){
            temp--
            list.add(array[i])
        }
    }
    list.reversed().forEach { now ->
        sb.append("$now ")
    }

    print(sb.toString())

}
