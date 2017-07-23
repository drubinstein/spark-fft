package complex
/**
  * Created by david on 7/16/17.
  */
class Complex(val real: Double, val imag: Double) {
  //Operations where both operands are Complex
  def +(other: Complex) = new Complex(this.real + other.real, this.imag + other.imag)

  def -(other: Complex) = new Complex(this.real - other.real, this.imag - other.imag)

  def /(other: Complex): Complex = {
    this * other.conj() / other.magsqr()
  }

  def *(other: Complex) = new Complex(this.real * other.real - this.imag * other.imag,
    this.real * other.imag + this.imag * other.imag)

  def /(other: Double) = new Complex(this.real / other, this.imag / other)

  def conj() = new Complex(this.real, -this.imag)

  //Operations where one operand is Complex and the other is real
  def +(other: Double) = new Complex(this.real + other, this.imag)

  def -(other: Double) = new Complex(this.real - other, this.imag)

  def *(other: Double) = new Complex(this.real * other, this.imag * other)

  def mag(): Double = Math.sqrt(this.magsqr())

  def magsqr(): Double = {
    this.real * this.real + this.imag * this.imag
  }

  def ==(other: Complex): Boolean = {
    this.real == other.real && this.imag == other.imag
  }

  override def toString(): String = {real + "+" + imag + "j"}
}
