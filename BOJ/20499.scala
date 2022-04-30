import scala.io.StdIn

object Main {
  def main(args: Array[String]) = {
    val input_nums_string = StdIn.readLine().split("/")
    val K = input_nums_string(0).toInt
    val D = input_nums_string(1).toInt
    val A = input_nums_string(2).toInt
    if(K + A < D || D == 0){
      print("hasu")
    } else{
      print("gosu")
    }
  }
}
