package arithmetic

// P40 (**) Goldbach's conjecture.
//     Goldbach's conjecture says that every positive even number greater than 2
//     is the sum of two prime numbers.  E.g. 28 = 5 + 23.  It is one of the
//     most famous facts in number theory that has not been proved to be correct
//     in the general case.  It has been numerically confirmed up to very large
//     numbers (much larger than Scala's Int can represent).  Write a function
//     to find the two prime numbers that sum up to a given even integer.
//
//     scala> 28.goldbach
//     res0: (Int, Int) = (5,23)

class IntP40(start: Int) {
  import IntP31._
  def goldbach: (Int,Int) =
    IntP31.primes takeWhile { _ < start } find { p => (start - p).isPrime } match {
      case None     => throw new IllegalArgumentException
      case Some(p1) => (p1, start - p1)
    }
}

object IntP40 {
  implicit def int2IntP40(i: Int): IntP40 = new IntP40(i)
}

object P40 extends App {
  import IntP40._
  println(28.goldbach)
}