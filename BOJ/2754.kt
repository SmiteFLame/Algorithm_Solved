package test

fun main() = with(System.`in`.bufferedReader()) {
   when(readLine()){
       "A+" -> print(4.3)
       "A0" -> print(4.0)
       "A-" -> print(3.7)
       "B+" -> print(3.3)
       "B0" -> print(3.0)
       "B-" -> print(2.7)
       "C+" -> print(2.3)
       "C0" -> print(2.0)
       "C-" -> print(1.7)
       "D+" -> print(1.3)
       "D0" -> print(1.0)
       "D-" -> print(0.7)
       "F" -> print(0.0)
   }
}
