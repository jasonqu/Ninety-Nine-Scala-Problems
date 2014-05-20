package arithmetic

// P31 (**) Determine whether a given integer number is prime.
//     scala> 7.isPrime
//     res0: Boolean = true

// A fairly naive implementation for primality testing is simply: a number is
// prime if it it not divisible by any prime number less than or equal to its
// square root.
// Here, we use a Stream to create a lazy infinite list of prime numbers.  The
// mutual recursion between `primes` and `isPrime` works because of the limit
// on `isPrime` to the square root of the number being tested.

class IntP31(val start: Int) {
  def isPrime: Boolean =
    (start > 1) && (IntP31.primes takeWhile { _ <= Math.sqrt(start) } forall { start % _ != 0 })
}

object IntP31 {
  implicit def int2IntP31(i: Int): IntP31 = new IntP31(i)
  val primes = Stream.cons(2, Stream.from(3, 2) filter { _.isPrime })
}

// Readers interested in more sophisticated (and more efficient) primality tests
// are invited to read http://primes.utm.edu/prove/index.html .  Implementation
// in Scala is left as an exercise for the reader.

// Similarly, a more efficient, functional, lazy, infinite prime list can be found
// at http://article.gmane.org/gmane.comp.lang.haskell.cafe/19470 .  (Haskell
// implementation.)

object P31 extends App {
  import IntP31._
  println(7.isPrime)
}