import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var sum = 0
    for(i in 0..4){
        sum += Integer.parseInt(br.readLine())
    }
    print(sum)
}