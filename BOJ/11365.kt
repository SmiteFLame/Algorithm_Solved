package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var sb = StringBuilder()
    while(true){
        var S = readLine()
        if(S == "END") break
        sb.append(S.reversed()).append("\n")
    }
    print(sb.toString())
}