package arithmetic

// P33 (*) Determine whether two positive integer numbers are coprime.
//     Two numbers are coprime if their greatest common divisor equals 1.
//
//     scala> 35.isCoprimeTo(64)
//     res0: Boolean = true//     res0: Int = 9

import P32.gcd

class IntP33(a: Int) {
  def isCoprimeTo(b: Int) : Boolean = gcd(a, b) == 1
}

object IntP33 {
  implicit def int2IntP33(i: Int): IntP33 = new IntP33(i)
}

object P33 extends App {
  import IntP33._
  println(35.isCoprimeTo(64))
}