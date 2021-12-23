package test

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val st = StringTokenizer(readLine())
    val left = st.nextToken().reversed()
    val right = st.nextToken().reversed()
    var answer = ""
    var next = false
    for(i in 0 until left.length.coerceAtLeast(right.length)){
        if(i >= left.length){
            if(next){
                if(right[i] == '0'){
                    answer = "1$answer"
                    next = false
                } else{
                    answer = "0$answer"
                }
            } else{
                answer = "${right[i]}$answer"
            }
        }
        else if(i >= right.length){
            if(next){
                if(left[i] == '0'){
                    answer = "1$answer"
                    next = false
                } else{
                    answer = "0$answer"
                }
            } else{
                answer = "${left[i]}$answer"
            }
        } else{
            if(left[i] == '0' && right[i] == '0'){
                answer = if(next){
                    "1$answer"
                } else{
                    "0$answer"
                }
                next = false
            } else if((left[i] == '1' && right[i] == '0') || (left[i] == '0' && right[i] == '1')){
                if(next){
                    answer = "0$answer"
                } else{
                    answer = "1$answer"
                    next = false
                }

            } else{
                answer = if(next){
                    "1$answer"
                } else{
                    "0$answer"
                }
                next = true
            }
        }
    }
    if(next){
        answer = "1$answer"
    }
    while(answer[0] == '0'){
        if(answer.length == 1) break
        answer = answer.substring(1)
    }
    print(answer)
}
