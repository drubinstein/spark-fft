package fft

import complex.Complex
/**
  * Created by david on 7/4/17.
  */
class Fft(val num_bins: Double) {

  def twiddle(k: Double): Complex = {
    val phase = -2*Math.PI*k/num_bins
    new Complex(Math.cos(phase), Math.sin(phase))
  }

  def fft(signal: Vector[Complex], stride: Int): Vector[Complex] = {
    if (signal.length == 1) signal
    else {
      var x_even = new Fft(num_bins).fft(signal.grouped(2).map(_.head).toVector, 2 * stride)
      var x_odd = new Fft(num_bins).fft(signal.tail.grouped(2).map(_.head).toVector, 2 * stride)

      for (k <- x_even.indices) {
        val t: Complex = x_even(k)
        val omega: Complex = twiddle(k)
        x_even = x_even.updated(k, t + omega * x_odd(k))
        x_odd = x_odd.updated(k, t - omega * x_odd(k))
      }
      x_even ++ x_odd
    }
  }
}
