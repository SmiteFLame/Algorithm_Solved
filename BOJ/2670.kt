package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { 0.0 }
    val dp = Array(n) { 0.0 }
    for (i in 0 until n) {
        array[i] = readLine().toDouble()
    }

    var max = array[0]

    for(i in 1 until n){
        array[i] = array[i].coerceAtLeast(array[i - 1] * array[i])
        max = max.coerceAtLeast(array[i])
    }

    print(String.format("%.3f", max))
}
