package test

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    for (i in 1000..9999) {
        var sum10 = 0
        var sum12 = 0
        var sum16 = 0
        var n = i
        while (n > 0) {
            sum10 += n % 10
            n /= 10
        }
        n = i
        while (n > 0) {
            sum12 += n % 12
            n /= 12
        }
        n = i
        while (n > 0) {
            sum16 += n % 16
            n /= 16
        }
        if (sum10 == sum12 && sum12 == sum16) {
            sb.append("$i\n")
        }
    }
    print(sb.toString())
}