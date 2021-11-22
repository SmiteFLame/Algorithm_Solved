import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var answer = 1
    var change = -1
    for(i in 1 until n){
        if(answer <= 1){
            change *= -1
        }
        
        answer += change
        
        if(answer >= 5){
            change *= -1
        }
    }
    print(answer)
}