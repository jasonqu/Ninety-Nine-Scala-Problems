package working_with_list

import scala.annotation.tailrec

/**
 * P20 (*) Remove the Kth element from a list.
 *     Return the list and the removed element in a Tuple.  Elements are
 *     numbered from 0.
 *
 *     Example:
 *     scala> removeAt(1, List('a, 'b, 'c, 'd))
 *     res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 */
object P20 extends App {
  def removeAt[T](n : Int, ls: List[T]): (List[T], T) = 
    (ls.take(n) ::: ls.drop(n + 1), ls.drop(n).head)

  def removeAt1[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post)  => (pre ::: post, e)
    case (pre, Nil)        => throw new NoSuchElementException
  }

  // Alternate, with fewer builtins.
  def removeAt2[A](n: Int, ls: List[A]): (List[A], A) =
    if (n < 0) throw new NoSuchElementException
    else (n, ls) match {
      case (_, Nil) => throw new NoSuchElementException
      case (0, h :: tail) => (tail, h)
      case (_, h :: tail) => {
        val (t, e) = removeAt(n - 1, ls.tail)
        (ls.head :: t, e)
      }
    }
  
  println(removeAt(1, List('a, 'b, 'c, 'd)))
  assert((List('a, 'c, 'd),'b)
      == removeAt(1, List('a, 'b, 'c, 'd)))
}