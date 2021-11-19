package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val d = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val array = Array(d){0}
    for(i in 1..(k / 2)){
        for(j in (i + 1) until k){
            array[0] = i
            array[1] = j
            for(k in 2 until d){
                array[k] = array[k - 1] + array[k - 2]
            }
            if(array[d - 1] == k){
                println(array[0])
                println(array[1])
                return
            }
        }
    }
}
