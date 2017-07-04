package Fft

import Complex.Complex
/**
  * Created by david on 7/4/17.
  */
object Fft {
  def fft(signal: Vector[Complex], s: Int): Vector[Complex] = {
    if (signal.length == 1) signal
    else {
      val X0 = Fft.fft(signal.drop(2).grouped(2).map(_.head).toVector, 2 * s)
      val X1 = Fft.fft(signal.tail.drop(2).grouped(2).map(_.head).toVector, 2 * s)
      for (k <- 0 until X0.length) {
        val t = X0(k)
        val omega = -2 * math.Pi * s * k / signal.length
        val w = new Complex(Math.cos(omega), Math.sin(omega))
        X0.updated(k, t + w * X1(k))
        X1.updated(k, t + w * X1(k))
      }
      X0 ++ X1
    }
  }
}
