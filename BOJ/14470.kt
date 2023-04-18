package test

fun main() = with(System.`in`.bufferedReader()) {
    var a = readLine().toInt()
    val b = readLine().toInt()
    val c = readLine().toInt()
    val d = readLine().toInt()
    val e = readLine().toInt()
    var answer = 0
    while (a < b) {
        answer += if (a == 0) d else 0
        answer += if (a < 0) c
        else e
        a++
    }

    println(answer)
}
