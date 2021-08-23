package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var a = st.nextToken().toInt()
    var b = st.nextToken().toInt()
    var c = st.nextToken().toInt()
    if(c - b > b - a){
        print(c - b - 1)
    } else{
        print(b - a - 1)
    }
}