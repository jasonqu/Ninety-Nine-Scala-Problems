package working_with_list

import java.util.NoSuchElementException
import scala.annotation.tailrec

/**
 * (*) Find the last nth element of a list.
 * the last element in the list is element 1 in lastNth (implies index of n - 1).
 * Example:
 * scala> lastNth(3, List(1, 1, 2, 3, 5, 8))
 * res0: Int = 3
 */
object P02plus extends App {
  // complexity O(n)
  def lastNth[T](n : Int, ls: List[T]): T = {
    if (n < 0) throw new IllegalArgumentException
    if (ls.length < n) throw new NoSuchElementException
    else ls.takeRight(n).head
  }

  // complexity O(n * n)?
  @tailrec
  def lastNthRecursive[T](n : Int, list: List[T]): T = {
    (n, list) match {
      case (n, Nil) if(n >= 1) => throw new NoSuchElementException
      case (1, list) => list.last
      case (n, list) => lastNthRecursive(n - 1, list.init)
    }
  }

  // Gold's solution, complexity O(n)
  def lastNthRecursive2[A](n: Int, ls: List[A]): A = {
    @tailrec
    def lastNthR(count: Int, resultList: List[A], curList: List[A]): A =
      curList match {
        case Nil if count > 0 => throw new NoSuchElementException
        case Nil              => resultList.head
        case _ :: tail        =>
          lastNthR(count - 1,
                   if (count > 0) resultList else resultList.tail,
                   tail)
      }
    if (n <= 0) throw new IllegalArgumentException
    else lastNthR(n, ls, ls)
  }
  
  

  assert(5 == lastNth(2, List(1, 1, 2, 3, 5, 8)))
  assert(3 == lastNth(3, List(1, 1, 2, 3, 5, 8)))
  assert(3 == lastNthRecursive(3, List(1, 1, 2, 3, 5, 8)))
  assert(3 == lastNthRecursive2(3, List(1, 1, 2, 3, 5, 8)))
}