package test

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val primeArray = Array<Boolean>(10_000_001) { true }

    for (i in 2..10_000_000) {
        if (primeArray[i]) {
            for (j in (i * 2)..10_000_000 step i) {
                primeArray[j] = false
            }
        }
    }

    for (i in 0 until n){
        val now = readLine().toInt()
        var count = 0
        for(j in 2..(now/2)){
            if(primeArray[j] && primeArray[now - j]){
                count++
            }
        }
        println(count)
    }
}
