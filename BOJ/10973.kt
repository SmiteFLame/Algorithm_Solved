package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var N = readLine().toInt()
    var data = IntArray(N){0}
    var st = StringTokenizer(readLine())
    for(i in 0 until N){
        data[i] = st.nextToken().toInt()
    }
    var index = N - 1
    while(index > 0 && data[index] > data[index - 1]){
        index--
    }
    if(index == 0){
        print(-1)
        return
    }

    var temp = N - 1
    while(data[index - 1] < data[temp]){
        temp--
    }
    data[index - 1] = data[temp].also{data[temp] = data[index - 1]}
    temp = N - 1
    while(index < temp){
        data[index] = data[temp].also{data[temp] = data[index]}
        index++
        temp--
    }
    var sb = StringBuilder()
    data.forEach {
        i -> sb.append("$i ")
    }
    print(sb.toString())

}