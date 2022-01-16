package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array(n) { 0 }
    for(i in 0 until n){
        array[i] = readLine().toInt()
    }
    var left = 0
    var right = 0
    var cnt = 0
    for(i in 0 until n){
        if(array[i] > cnt){
            left++
            cnt = array[i]
        }
    }
    cnt = 0
    for(i in n - 1 downTo 0){
        if(array[i] > cnt){
            right++
            cnt = array[i]
        }
    }
    println(left)
    println(right)
}
