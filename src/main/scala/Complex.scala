/**
  * Created by david on 7/16/17.
  */
class Complex(val real: Double, val imag: Double) {
  //Operations where both operands are complex
  def +(other: Complex) = new Complex(this.real + other.real, this.imag + other.imag)

  def -(other: Complex) = new Complex(this.real - other.real, this.imag - other.imag)

  def /(other: Complex): Complex = {
    this * other.conj() / other.magsqr()
  }

  def *(other: Complex) = new Complex(this.real * other.real - this.imag * other.imag,
    this.real * other.imag + this.imag * other.imag)

  def /(other: Double) = new Complex(this.real / other, this.imag / other)

  def conj() = new Complex(this.real, -this.imag)

  def magsqr(): Double = {
    this.real * this.real + this.imag * this.imag
  }

  //Operations where one operand is complex and the other is real
  def +(other: Double) = new Complex(this.real + other, this.imag)

  def -(other: Double) = new Complex(this.real - other, this.imag)

  def *(other: Double) = new Complex(this.real * other, this.imag * other)

  def mag(): Double = Math.sqrt(this.magsqr())

  def ==(other: Complex): Boolean = {
    this.real == other.real && this.imag == other.imag
  }
}
