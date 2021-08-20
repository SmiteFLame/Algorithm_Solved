package test

import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))
var alpa = arrayOf('a', 'i', 'u', 'e', 'o')
fun main(){
    val str = br.readLine()
    var cnt = 0
    for(c in str){
        when(c){
            in alpa -> cnt++
        }
    }
    println(cnt)
}