package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val array = Array(5){0}
    for(i in 0 until 5){
        array[i] = st.nextToken().toInt()
    }
    var answer = 1

    while(true){
        var count = 0
        for(i in 0 until 5){
            if(answer % array[i] == 0) count++
        }

        if(count >= 3){
            break
        }
        answer++
    }

    print(answer)
}
