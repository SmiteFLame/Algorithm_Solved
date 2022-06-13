import java.util.StringTokenizer
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val st = new StringTokenizer(StdIn.readLine())
    val a = st.nextToken().toDouble
    val b = st.nextToken().toDouble
    val c = st.nextToken().toDouble
    println(Math.max((a * b) / c, (a / b) * c).toInt)
  }
}
