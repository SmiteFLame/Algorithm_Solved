package test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var br = BufferedReader(InputStreamReader(System.`in`))

fun priority(c : Char) : Int{
    if(c == '(') return 0;
    if(c == '+' || c == '-') return 1;
    return 2;
}

fun main(){
    var S = br.readLine()
    var stack = Stack<Char>()
    var now : String = ""
    for(s in S){
        if(s in 'A'..'Z'){
            now += s
        } else if(s == '('){
            stack.push(s)
        } else if(s == ')'){
            while(!stack.isEmpty()){
                var next = stack.pop()
                if(next == '(') break;
                now += next
            }
        } else{
            while(!stack.isEmpty() && priority(stack.peek()) >= priority(s)){
                now += stack.pop()
            }
            stack.push(s)
        }
    }
    while(!stack.isEmpty()){
        now += stack.pop()
    }
    print(now)
}