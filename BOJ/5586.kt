package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine()
    var cntJ = 0
    var cntI = 0
    for(i in 0 until str.length - 2){
        when(str[i]){
            'J' ->{
                if(str[i + 1] == 'O' && str[i + 2] == 'I'){
                    cntJ++
                }
            }
            'I' ->{
                if(str[i + 1] == 'O' && str[i + 2] == 'I'){
                    cntI++
                }
            }
        }
    }
    print("$cntJ\n$cntI")
}
