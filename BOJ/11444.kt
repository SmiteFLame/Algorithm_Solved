package test

val map = HashMap<Long, Long>()
const val mod: Long = 1000000007

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toLong()
    print(fibo(n))
}

fun fibo(n : Long) : Long{
    if(n <= 0){
        return 0L
    } else if(n == 1L || n == 2L){
        return 1L
    } else if(!map.containsKey(n)){
        val m = (n + 1) / 2
        val a = fibo(m)
        val b = fibo(m - 1)
        map[n] = if(n % 2 == 1L){
            (a * a + b * b) % mod
        } else{
            (2 * b + a) * a % mod
        }
    }
    return map[n]!!
}