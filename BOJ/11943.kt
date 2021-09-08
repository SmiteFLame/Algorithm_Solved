package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    var AA = st.nextToken().toInt()
    var AB = st.nextToken().toInt()
    st = StringTokenizer(readLine())
    var BA = st.nextToken().toInt()
    var BB = st.nextToken().toInt()
    if(AA + BB > AB + BA){
        print(AB + BA)
    } else{
        print(AA + BB)
    }
}
