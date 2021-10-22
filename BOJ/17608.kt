package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val array = Array<Int>(n) { 0 }
    for(i in 0 until n){
        array[i] = readLine().toInt()
    }
    var max = array[n - 1]
    var answer = 1
    for(i in n - 1 downTo 0){
        if(array[i] > max){
            max = array[i]
            answer++
        }
    }
    print(answer)
}
