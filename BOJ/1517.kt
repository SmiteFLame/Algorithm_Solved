package test

import java.lang.StringBuilder
import java.util.*

var answer = 0L
var sorted = LongArray(0)
var ary = LongArray(0)

fun merge(left: Int, mid: Int, right: Int) {
    var i = left
    var j = mid + 1
    var index = left
    while(i <= mid && j <= right){
        if(ary[i] > ary[j]){
            sorted[index++] = ary[j++]
            answer += (mid - i + 1)
        } else{
            sorted[index++] = ary[i++]
        }
    }
    if(i > mid){
        while(j <= right){
            sorted[index++] = ary[j++]
        }
    } else{
        while(i <= mid){
            sorted[index++] = ary[i++]
        }
    }

    for(i in left..right){
        ary[i] = sorted[i]
    }

}

fun mergeSort(left: Int, right: Int) {
    if (left < right) {
        val mid = (left + right) / 2
        mergeSort(left, mid)
        mergeSort(mid + 1, right)
        merge(left, mid, right)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val st = StringTokenizer(readLine())
    ary = LongArray(N)
    sorted = LongArray(N)
    for (i in 0 until N) {
        ary[i] = st.nextToken().toLong()
    }

    mergeSort(0, N - 1)
    print(answer)
}