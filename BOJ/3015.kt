package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val stack = Stack<Pair<Int, Int>>()
    var answer = 0L

    for (i in 0 until n) {
        var pair = Pair(readLine().toInt(), 1)
        while (!stack.isEmpty()) {
            if (stack.peek().first <= pair.first) {
                val now = stack.pop()
                answer += now.second
                if (now.first == pair.first) {
                    pair = Pair(pair.first, pair.second + now.second)
                }
            } else {
                break
            }
        }
        if (!stack.isEmpty()) {
            answer++
        }
        stack.push(pair)
    }
    print(answer)
}
