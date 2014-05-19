package working_with_list

import scala.annotation.tailrec

/**
 * P13 (**) Run-length encoding of a list (direct solution).
 *     Implement the so-called run-length encoding data compression method
 *     directly.  I.e. don't use other methods you've written (like P09's
 *     pack); do all the work directly.
 *
 *     Example:
 *     scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 *     res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */
object P13 extends App {
  // both are not tail-recursive
  def encodeDirect[T](ls: List[T]): List[(Int, T)] = {
    ls match {
      case Nil => Nil
      case list => {
        val (h, t) = list.span(_ == list.head)
        (h.length, h.head) :: encodeDirect(t)
      }
    }
  }
  
  // This is basically a modification of P09.
  def encodeDirect2[A](ls: List[A]): List[(Int, A)] =
    if (ls.isEmpty) Nil
    else {
      val (packed, next) = ls span { _ == ls.head }
      (packed.length, packed.head) :: encodeDirect(next)
    }
  
  assert(List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
      == encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
}