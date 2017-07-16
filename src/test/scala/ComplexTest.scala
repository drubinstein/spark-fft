import complex.Complex

/**
  * Created by david on 7/16/17.
  */
class ComplexTest extends org.scalatest.FunSuite {
  var a = new Complex(1, 2)

  test("A complex number should correctly assign the real and imag parts") {
    assert(a.real == 1)
    assert(a.imag == 2)
  }

  test("Complex addition") {
    val b = a + a
    assert(b.real == 2)
    assert(b.imag == 4)
  }

  test("Complex + Real") {
    val c = a + 1
    assert(c.real == 2)
    assert(c.imag == 2)
  }

  test("Magnitude Squared") {
    assert(a.magsqr() == 5)
  }

  test("Complex * Real") {
    val b = a * 5
    assert(b.real == 5)
    assert(b.imag == 10)
  }
}
