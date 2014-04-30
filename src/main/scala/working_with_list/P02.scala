package working_with_list

import java.util.NoSuchElementException
import scala.annotation.tailrec

/**
 * (*) Find the last but one element of a list.
 * Example:
 * scala> penultimate(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 5
 */
object P02 extends App {
  // complexity O(n)
  def penultimateBuiltin[T](ls: List[T]): T = {
    if (ls.length < 2) throw new NoSuchElementException
    else ls.init.last
  }

  // complexity O(n)
  @tailrec
  def penultimateRecursive[T](list: List[T]): T = {
    list match {
      case elem1 :: _ :: Nil => elem1
      case _ :: tail => penultimateRecursive(tail)
      case _ => throw new NoSuchElementException
    }
  }

  assert(5 == penultimateBuiltin(List(1, 1, 2, 3, 5, 8)))
  assert(5 == penultimateRecursive(List(1, 1, 2, 3, 5, 8)))
}