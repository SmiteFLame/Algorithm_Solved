package test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var N = 0
var br = BufferedReader(InputStreamReader(System.`in`))
var st = StringTokenizer("")
var answer : Int = Integer.MAX_VALUE
var stack = Stack<Int>()
var arr = Array(0){Array(0){0} }

private fun subset(now : Int){
    if(now == N){
        if(stack.size == 0) return
        var left = 1
        var right = 0
        for(st in stack){
            left *= arr[st][0]
            right += arr[st][1]
        }
        var next = Math.abs(left - right)
        if(next < answer){
            answer = next
        }
        return
    }
    stack.push(now)
    subset(now + 1)
    stack.pop()
    subset(now + 1)
}

fun main(){
    N = Integer.parseInt(br.readLine())
    arr = Array(N){Array(2){0} }
    for(i in 0 until N){
        st = StringTokenizer(br.readLine())
        arr[i][0] = Integer.parseInt(st.nextToken())
        arr[i][1] = Integer.parseInt(st.nextToken())
    }
    subset(0)
    println(answer)
}