package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()
    if(k >= n){
        print(0)
        return
    }

    val array = Array(n){0}
    val st = StringTokenizer(readLine())
    for(i in 0 until n){
        array[i] = st.nextToken().toInt()
    }

    array.sort()

    val diff = Array(n - 1){0}
    for(i in 0 until n - 1){
        diff[i] = array[i + 1] - array[i]
    }

    diff.sortDescending()

    var answer = 0
    for(i in k - 1 until n - 1){
        answer += diff[i]
    }

    print(answer)
}