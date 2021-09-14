package test

import java.lang.StringBuilder
import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val array = IntArray(21)
    for (i in 1..20) {
        array[i] = i
    }
    repeat(10) {
        val st = StringTokenizer(readLine())
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()
        val stack = Stack<Int>()
        for (i in (right - left) downTo 0){
            stack.push(array[right - i])
        }
        for (i in 0..(right - left)) {
            array[left + i] = stack.pop()
        }
    }
    val sb = StringBuilder()
    for(i in 1..20){
        sb.append("${array[i]} ")
    }
    print(sb.toString())
}
