import java.util.*


private var answer = Int.MIN_VALUE
fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt() 
    val arr = IntArray(N)
    for (i in 0 until N) {
        arr[i] = sc.nextInt()
    }
    for (i in 0 until N) {
        var count = 0
        for (j in i + 1 until N) {
            if (arr[i] > arr[j]) {
                count++
            } else { 
                break
            }
        }
        answer = answer.coerceAtLeast(count)
    }
    println(answer)
}
