package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var max = 0
    var W = 0
    var H = 0
    for(i in 1..9){
        var st = StringTokenizer(readLine())
        for(j in 1..9){
            var now = st.nextToken().toInt()
            if(now > max){
                max = now
                H = i
                W = j
            }
        }
    }
    println(max)
    print("$H $W")
}
