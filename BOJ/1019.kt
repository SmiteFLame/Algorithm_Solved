package test

fun main() = with(System.`in`.bufferedReader()) {
    val array = Array(10) { 0 }

    val n = readLine().toInt()
    var start = 1
    var end = n
    var multi = 1


    fun solve(s: Int) {
        var s = s
        while (s > 0) {
            array[s % 10] += multi
            s /= 10
        }
    }

    while (start <= end) {
        while (start % 10 != 0 && start <= end) {
            solve(start)
            start++
        }
        if (start > end) break
        while (end % 10 != 9 && start <= end) {
            solve(end)
            end--
        }
        start /= 10
        end /= 10
        for (i in 0..9) {
            array[i] += (end - start + 1) * multi
        }
        multi *= 10
    }

    for (i in 0 until 10) {
        print(array[i].toString() + " ")
    }
}
