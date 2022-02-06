package test

fun main() = with(System.`in`.bufferedReader()) {
    val s = StringBuffer(readLine())
    val t = StringBuffer(readLine())

    while (s.length < t.length) {
        if (t.last() == 'A') {
            t.deleteCharAt(t.length - 1)
        } else if (t.last() == 'B') {
            t.deleteCharAt(t.length - 1)
            t.reverse()
        }
    }

    if (s.toString() == t.toString()) {
        println(1)
    } else {
        println(0)
    }
}
