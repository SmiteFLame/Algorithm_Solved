package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var isIn = false
    repeat(n) {
        if (readLine().equals("anj")) {
            isIn = true
        }
    }
    if (isIn) {
        println("뭐야;")
    } else {
        println("뭐야?")
    }
}
