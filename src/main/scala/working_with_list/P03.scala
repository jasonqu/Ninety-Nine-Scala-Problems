package working_with_list

import java.util.NoSuchElementException

/**
 * (*) Find the Kth element of a list.
 * By convention, the first element in the list is element 0.
 * Example:
 *
 * scala> nth(2, List(1, 1, 2, 3, 5, 8))
 * res0: Int = 2
 */
object P03 extends App {
  // complexity O(n)
  def nth[T](i : Int, list: List[T]): T = {
    list.drop(i).head
  }

  // complexity O(n)
  def nthRecursive[T](i : Int, list: List[T]): T = {
    (i, list) match {
      case (a, Nil) if a >= 0 => throw new NoSuchElementException
      case (0, list) => list.head
      case (i, list) => nthRecursive(i - 1, list.tail)
    }
  }
  
  assert(2 == nth(2, List(1, 1, 2, 3, 5, 8)))
  assert(3 == nth(3, List(1, 1, 2, 3, 5, 8)))
  assert(3 == nthRecursive(3, List(1, 1, 2, 3, 5, 8)))
}