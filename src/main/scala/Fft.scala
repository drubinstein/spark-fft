/**
  * Created by david on 7/4/17.
  */
object Fft {
  def fft(signal: Vector[Complex], s: Int): Vector[Complex] = {
    if (signal.length == 1) signal
    else {
      X0 = fft(signal.drop(2).grouped(2).map(_.head).toVector, 2 * s)
      X1 = fft(signal.tail().drop(2).grouped(2).map(_.head).toVector, 2 * s)
      for (k <- 0 until X0.length) {
        t = X0(k)
        X0(k) = t + Complex(-2 * math.Pi * s * k / signal.length) * X1(k)
        X1(k) = t - Complex(-2 * math.Pi * s * k / signal.length) * X1(k)
      }
      X0 + X1
    }
  }
}
