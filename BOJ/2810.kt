package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val str = readLine()
    var answer = 2
    for (i in str.indices) {
        answer += if (str[i] == 'S') {
            2
        } else {
            1
        }
    }
    answer /= 2
    if(answer > n){
        answer = n
    }
    print(answer)
}
