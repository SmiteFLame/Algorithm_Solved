import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val br = StdIn.readLine().split(" ")
    val n = br(0).toInt
    val m = br(1).toInt

    if(m == 1 || m == 2){
      print("NEWBIE!")
    } else if(m <= n){
      print("OLDBIE!")
    } else{
      print("TLE!")
    }
  }
}
