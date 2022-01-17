package test

import java.util.*
import kotlin.collections.HashMap

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { 0 }
    val map = HashMap<Int, Int>()
    val st = StringTokenizer(readLine())
    val answer = Array(n) { 0 }
    for (i in 0 until n) {
        array[i] = st.nextToken().toInt()
        map.putIfAbsent(array[i], 0)
        map[array[i]] = map[array[i]]!! + 1
    }

    val stack = Stack<Int>()
    stack.push(0)
    for (i in 1 until n) {
        if (stack.isEmpty()) {
            stack.push(i)
        }

        while (!stack.isEmpty() && map[array[i]]!! > map[array[stack.peek()]]!!) {
            answer[stack.pop()] = array[i]
        }
        stack.push(i)
    }

    while (!stack.isEmpty()){
        answer[stack.pop()] = -1
    }
    val sb = StringBuilder()
    answer.forEach { now ->
        sb.append("$now ")
    }
    print(sb.toString())
}
