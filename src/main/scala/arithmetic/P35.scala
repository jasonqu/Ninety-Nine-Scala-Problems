package arithmetic

// P35 (**) Determine the prime factors of a given positive integer.
//     Construct a flat list containing the prime factors in ascending order.
//
//     scala> 315.primeFactors
//     res0: List[Int] = List(3, 3, 5, 7)

import P32.gcd

class IntP35(a: Int) {
  import IntP31._
  def primeFactors: List[Int] = {
    def primeFactorsR(n: Int, ps: Stream[Int]): List[Int] =
      if (n.isPrime) List(n)
      else if (n % ps.head == 0) ps.head :: primeFactorsR(n / ps.head, ps)
      else primeFactorsR(n, ps.tail)
    primeFactorsR(a, primes)
  }
}

object IntP35 {
  implicit def int2IntP35(i: Int): IntP35 = new IntP35(i)
}

object P35 extends App {
  import IntP35._
  println(10.primeFactors)
}