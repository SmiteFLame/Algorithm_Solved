package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    var sb = StringBuilder()
    var S = readLine()
    S.forEach {
        s ->
        if(s - 3 < 'A'){
            sb.append(s + 23)
        } else{
            sb.append(s - 3)
        }
    }
    print(sb.toString())
}