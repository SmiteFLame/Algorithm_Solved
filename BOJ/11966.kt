package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var num = 1
    while(num <= n){
        if(num == n){
            print(1)
            return
        }
        num *= 2
    }
    print(0)
}
