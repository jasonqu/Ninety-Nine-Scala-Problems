package working_with_list

import scala.annotation.tailrec

/**
 * P12 (**) Decode a run-length encoded list.
 *     Given a run-length code list generated as specified in problem P10,
 *     construct its uncompressed version.
 *
 *     Example:
 *     scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
 *     res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 */
object P12 extends App {
  def decode[T](ls: List[(Int, T)]): List[T] = {
    var result = List[T]()
    ls.foldRight(List[T]())((a, b) => {
      for(i <- 1 to a._1) result = a._2 :: result
      result
    })
  }
  
  // use make
  def decode2[A](ls: List[(Int, A)]): List[A] =
    ls flatMap { e => List.make(e._1, e._2) }
  
  assert(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
      == decode2(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
}