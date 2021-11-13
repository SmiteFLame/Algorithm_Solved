package test

import java.lang.StringBuilder

fun main() = with(System.`in`.bufferedReader()) {
    var n = readLine().toInt()

    val sb = StringBuilder()
    if(n == 0){
        sb.append(0)
    } else{
        while( n != 0){
            if(n % -2 == 0){
                sb.insert(0, 0)
                n /= -2
            } else{
                sb.insert(0, 1)
                n = (n - 1) / -2
            }
        }
    }
    print(sb.toString())

}
