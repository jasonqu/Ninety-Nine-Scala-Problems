package working_with_list

import scala.annotation.tailrec

/**
 * P15 (**) Duplicate the elements of a list a given number of times.
 *     Example:
 *     scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
 *     res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
 */
object P15 extends App {
  def duplicateN[T](c : Int, ls: List[T]): List[T] =
    ls.foldRight(List[T]()) {(elem, list) => List.make(c, elem) ::: list}
  
  def duplicateN2[A](n: Int, ls: List[A]): List[A] =
    ls flatMap { List.make(n, _) }
  
  assert(List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
      == duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
  println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
}