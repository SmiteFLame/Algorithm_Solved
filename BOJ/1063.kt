package test

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine(), " ")
    var king = st.nextToken().toCharArray()
    var stone = st.nextToken().toCharArray()
    for(i in 0 until st.nextToken().toInt()) {
        val cmd: String = readLine()
        val nextKing = king.clone()
        val nextStone = stone.clone()
        move(cmd, nextKing)
        if (range(nextKing)) continue
        if (nextKing.contentEquals(nextStone)) {
            move(cmd, nextStone)
            if (range(nextStone)) continue
        }
        king = nextKing
        stone = nextStone
    }
    println(king)
    println(stone)
}

fun range(next: CharArray): Boolean {
    return next[0] < 'A' || next[0] > 'H' || next[1] < '1' || next[1] > '8'
}

fun move(cmd: String, next: CharArray) {
    when (cmd) {
        "R" -> next[0]++
        "L" -> next[0]--
        "B" -> next[1]--
        "T" -> next[1]++
        "RT" -> {
            next[0]++
            next[1]++
        }
        "LT" -> {
            next[0]--
            next[1]++
        }
        "RB" -> {
            next[0]++
            next[1]--
        }
        "LB" -> {
            next[0]--
            next[1]--
        }
    }
}