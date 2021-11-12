package test

import java.lang.StringBuilder
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val str = readLine()
    var cnt = 0
    val stack = Stack<Char>()
    str.forEach { now ->
        while(!stack.isEmpty() && cnt < k){
            if(stack.peek() < now){
                stack.pop()
                cnt++
            } else{
                break
            }
        }
        stack.add(now)
    }

    val sb = StringBuilder()
    stack.forEach { now ->
        sb.append(now)
    }
    repeat(k - cnt){
        sb.delete(sb.length - 1, sb.length)
    }
    print(sb.toString())
}
