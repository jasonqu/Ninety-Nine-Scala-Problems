package working_with_list

import scala.annotation.tailrec

/**
 * P14 (*) Duplicate the elements of a list.
 *     Example:
 *     scala> duplicate(List('a, 'b, 'c, 'c, 'd))
 *     res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 */
object P14 extends App {
  def duplicate[T](ls: List[T]): List[T] =
    ls.foldRight(List[T]()) {(elem, list) => elem :: elem :: list}
  
  def duplicate2[T](ls: List[T]): List[T] =
    ls.foldRight(List[T]()) {(elem, list) => List.make(2, elem) ::: list}
  
  def duplicate3[A](ls: List[A]): List[A] = ls flatMap { e => List(e, e) }
   
  assert(List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
      == duplicate2(List('a, 'b, 'c, 'c, 'd)))
  println(duplicate2(List('a, 'b, 'c, 'c, 'd)))
}