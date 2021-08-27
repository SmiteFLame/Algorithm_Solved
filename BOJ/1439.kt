fun main() = with(System.`in`.bufferedReader()) {
    var str = readLine()
    var now = str[0]
    var cnt = 1
    str.forEach {
        s ->
        if(s != now){
            cnt++
            now = s
        }
    }
    print(cnt / 2)
}
