package test

import java.util.*
import kotlin.math.abs


fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array<Int>(n) { 0 }
    val st = StringTokenizer(readLine())
    for (i in 0 until n) {
        array[i] = st.nextToken().toInt()
    }
    Arrays.sort(array)

    val answer = Array<Int>(2) { 0 }

    var max = Int.MAX_VALUE
    for (i in 0 until n) {
        var start = i + 1
        var end = n - 1
        while (start <= end) {
            val mid = (start + end) / 2
            val sum = array[i] + array[mid]
            if (abs(sum) < max) {
                answer[0] = array[i]
                answer[1] = array[mid]
                max = abs(sum)
            }

            if(sum < 0){
                start = mid + 1
            } else{
                end = mid - 1
            }

        }
    }

    print("${answer[0]} ${answer[1]}")

}