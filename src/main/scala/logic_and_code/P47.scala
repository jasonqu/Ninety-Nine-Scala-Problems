package logic_and_code

// P47 (*) Truth tables for logical expressions (2).
//     Continue problem P46 by redefining and, or, etc as operators.  (i.e. make
//     them methods of a new class with an implicit conversion from Boolean.)
//     not will have to be left as a object method.
//
//     scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
//     A     B     result
//     true  true  true
//     true  false true
//     false true  false
//     false false false

// For simplicity, we remove `and`, `or`, `equ`, `xor`, `nor`, `nand`, and
// `impl` from the S99Logic object before putting them into a new class.

//class S99Logic(a: Boolean) {
//  import S99Logic._
//  
//  def and(b: Boolean): Boolean = (a, b) match {
//    case (true, true) => true
//    case _            => false
//  }
//  def or(b: Boolean): Boolean = (a, b) match {
//    case (true, _) => true
//    case (_, true) => true
//    case _         => false
//  }
//  def equ(b: Boolean): Boolean = (a and b) or (not(a) and not(b))
//  def xor(b: Boolean): Boolean = not(a equ b)
//  def nor(b: Boolean): Boolean = not(a or b)
//  def nand(b: Boolean): Boolean = not(a and b)
//  def impl(b: Boolean): Boolean = not(a) or b
//}

case class MyBoolean(a: Boolean) {
  import MyBoolean.boolean2Mine
  
  def not() = a match {
    case true  => false
    case false => true
  }
  def and(b: Boolean): Boolean = (a, b) match {
    case (true, true) => true
    case _            => false
  }
  def or(b: Boolean): Boolean = (a, b) match {
    case (true, _) => true
    case (_, true) => true
    case _         => false
  }
  def equ(b: Boolean): Boolean = (a and b) or (a.not and b.not)
  def xor(b: Boolean): Boolean = (a equ b) not
  def nor(b: Boolean): Boolean = (a or b) not
  def nand(b: Boolean): Boolean = (a and b) not
  def impl(b: Boolean): Boolean = a.not or b
  
}

object MyBoolean {
  implicit def boolean2Mine(i: Boolean): MyBoolean = new MyBoolean(i)

  def table2(f: (Boolean, Boolean) => Boolean) {
    println("A     B     result")
    for {a <- List(true, false);
         b <- List(true, false)} {
     printf("%-5s %-5s %-5s\n", a, b, f(a, b))
    }
  }
  def not(b: Boolean) = b match {
    case true  => false
    case false => true
  }
}

object P47 extends App {
  import MyBoolean._
  println(table2((a: Boolean, b: Boolean) => a and (a or not(b))))
}