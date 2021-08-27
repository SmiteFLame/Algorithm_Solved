package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var array = Array<IntArray>(3) { IntArray(2) }
    for(i in 0 until 3){
        var st = StringTokenizer(readLine())
        array[i][0] = st.nextToken().toInt()
        array[i][1] = st.nextToken().toInt()
    }
    var X = array[0][0] * array[1][1] + array[1][0] * array[2][1] + array[2][0] * array[0][1]
    var Y = array[0][1] * array[1][0] + array[1][1] * array[2][0] + array[2][1] * array[0][0]
    if(X == Y){
        print(0)
    } else if(X > Y){
        print(1)
    } else{
        print(-1)
}
}
