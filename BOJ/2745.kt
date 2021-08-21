package test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    var str = st.nextToken()
    var n = st.nextToken().toInt()
    var answer : Long = 0L
    str.forEach { c ->
        answer *= n
        if(c >= '0' && c <= '9'){
            answer += (c - '0')
        } else{
            answer += (c - 'A' + 10)
        }
    }

    println(answer)
}