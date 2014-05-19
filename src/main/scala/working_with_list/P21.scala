package working_with_list

import scala.annotation.tailrec

/**
 * P21 (*) Insert an element at a given position into a list.
 *     Example:
 *     scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
 *     res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 */
object P21 extends App {
  def insertAt[T](elem : T, n : Int, ls: List[T]): List[T] = 
    ls.take(n) ::: (elem :: ls.drop(n))

  def insertAt2[A](e: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
    case (pre, post) => pre ::: e :: post
  }
  
  println(insertAt('new, 1, List('a, 'b, 'c, 'd)))
  assert(List('a, 'new, 'b, 'c, 'd)
      == insertAt('new, 1, List('a, 'b, 'c, 'd)))
}