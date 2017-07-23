import org.scalatest.FunSuite
import fft.Fft
import complex.Complex

class FftTest extends FunSuite {

  test("Test FFT function") {
    val num_bins = 256
    val input_signal = Vector.fill(num_bins){new Complex(1,0)}
    var output_signal = Vector.fill(num_bins){new Complex(0,0)}
    output_signal = output_signal.updated(0, new Complex(num_bins, 0))

    val test_output = new Fft(num_bins).fft(input_signal, 1)
    //Assert that the reference and test output are within 3 significant figures of each other
    assert(.001 > test_output.zip(output_signal).map{ case(test,ref) => (test-ref).magsqr() }.sum/num_bins)

  }

}
