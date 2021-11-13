package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    for(i in 1..5){
        val str = readLine()
        if(str.contains("FBI")){
            sb.append("$i ")
        }
    }
    if(sb.toString() == ""){
        print("HE GOT AWAY!")
    } else{
        print(sb.toString())
    }
}
