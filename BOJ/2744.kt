package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var S = readLine()
    var sb = StringBuilder()
    S.forEach {
        s ->
        if(s in 'a'..'z'){
            sb.append(s.toUpperCase())
        } else{
            sb.append(s.toLowerCase())
        }
    }
    print(sb.toString())
}
