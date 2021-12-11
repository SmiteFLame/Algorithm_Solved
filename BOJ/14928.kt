package test

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine()
    var temp: Long = 0
    for (i in input.indices) {
        temp = (temp * 10 + (input[i] - '0')) % 20000303
    }

    println(temp)
}
