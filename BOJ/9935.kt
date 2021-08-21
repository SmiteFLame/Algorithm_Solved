package test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

val br = BufferedReader(InputStreamReader(System.`in`))
val sb = StringBuilder("")


fun main(){
    var mainLine = br.readLine()
    var checkLine = br.readLine()
    var stack : Stack<Char> = Stack<Char>()

    next@
    for(i in mainLine.indices){
        var c = mainLine[i]
        stack.add(c)
        if(stack.size < checkLine.length) continue@next

        for(j in checkLine.indices){
            if(stack.get(stack.size - checkLine.length + j) != checkLine[j]) continue@next
        }
        for(j in checkLine.indices){
            stack.pop()
        }
    }

    if (stack.size == 0){
        sb.append("FRULA")
    } else{
        for(c in stack){
            sb.append(c)
        }
    }
    println(sb.toString())

}