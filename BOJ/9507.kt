package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    var list = LongArray(69)
    list[0] = 1
    list[1] = 1
    list[2] = 2
    list[3] = 4
    for(i in 4 until 69){
        list[i] = list[i - 1] + list[i - 2] + list[i - 3] + list[i - 4]
    }

    var sb = StringBuilder()
    repeat(readLine().toInt()){
       sb.append(list[readLine().toInt()]).append("\n")
    }
    print(sb.toString())
}
