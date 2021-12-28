package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    val sb =  StringBuilder()
    repeat(readLine().toInt()){
        val n = readLine().toInt()
        for(i in 0 until n){
            for(j in 0 until n){
                if(i == 0 || i == n - 1|| j == 0 || j == n - 1){
                    sb.append("#")
                } else{
                    sb.append("J")
                }
            }
            sb.append("\n")
        }
        sb.append("\n")
    }
    print(sb.toString())
}
