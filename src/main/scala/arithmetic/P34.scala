package arithmetic

// P34 (**) Calculate Euler's totient function phi(m).
//     Euler's so-called totient function phi(m) is defined as the number of
//     positive integers r (1 <= r < m) that are coprime to m.  As a special
//     case, phi(1) is defined to be 1.
//
//     scala> 10.totient
//     res0: Int = 4

import P32.gcd

class IntP34(a: Int) {
  def isCoprimeTo(b: Int) : Boolean = gcd(a, b) == 1
  
  def totient : Int = 2 to a filter isCoprimeTo length
}

object IntP34 {
  implicit def int2IntP34(i: Int): IntP34 = new IntP34(i)
}

object P34 extends App {
  import IntP34._
  println(10.totient)
}