/**
  * Created by david on 7/4/17.
  */
object main {
  val usage: String =
    """
      |Usage: spark-fft filename
    """.stripMargin

  def main(args: Array[String]): Unit = {
    if (args.length == 0) println(usage)
    println("Performing FFT on data provided by file %s", args(1))
  }
}
