package arithmetic

// P36 (**) Determine the prime factors of a given positive integer (2).
//     Construct a list containing the prime factors and their multiplicity.
//
//     scala> 315.primeFactorMultiplicity
//     res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
//
//     Alternately, use a Map for the result.
//     scala> 315.primeFactorMultiplicity
//     res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)

class IntP36(a: Int) {
  import IntP35._
  def primeFactorMultiplicity: List[(Int, Int)] =
    a.primeFactors.groupBy(_ + 0).mapValues(_.length).toList
}

object IntP36 {
  implicit def int2IntP36(i: Int): IntP36 = new IntP36(i)
}

object P36 extends App {
  import IntP36._
  println(315.primeFactorMultiplicity)
}