package working_with_list

import scala.annotation.tailrec

/**
 * P16 (**) Drop every Nth element from a list.
 *     Example:
 *     scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *     res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 */
object P16 extends App {
  def drop[T](c : Int, ls: List[T]): List[T] = {
    def droprec(ls: List[T], index : Int): List[T] = {
      (index, ls) match {
        case (_, Nil) => Nil
        case (x, head :: tail) if(x == c - 1) => droprec(tail, 0)
        case (i, head :: tail) => head :: droprec(tail, i + 1 % c)
      }
    }
    droprec(ls, 0)
  }
  
  
  // Simple recursion.
  def dropRecursive[A](n: Int, ls: List[A]): List[A] = {
    def dropR(c: Int, curList: List[A]): List[A] = (c, curList) match {
      case (_, Nil)       => Nil
      case (1, _ :: tail) => dropR(n, tail)
      case (_, h :: tail) => h :: dropR(c - 1, tail)
    }
    dropR(n, ls)
  }

  // Tail recursive.
  def dropTailRecursive[A](n: Int, ls: List[A]): List[A] = {
    def dropR(c: Int, curList: List[A], result: List[A]): List[A] = (c, curList) match {
      case (_, Nil)       => result.reverse
      case (1, _ :: tail) => dropR(n, tail, result)
      case (_, h :: tail) => dropR(c - 1, tail, h :: result)
    }
    dropR(n, ls, Nil)
  }

  // Functional.
  def dropFunctional[A](n: Int, ls: List[A]): List[A] = 
    ls.zipWithIndex filter { v => (v._2 + 1) % n != 0 } map { _._1 }
  
  assert(List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
      == drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
}