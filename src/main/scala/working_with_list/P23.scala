package working_with_list

import scala.annotation.tailrec
import scala.util.Random

/**
 * P23 (**) Extract a given number of randomly selected elements from a list.
 *     Example:
 *     scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
 *     res0: List[Symbol] = List('e, 'd, 'a)
 *
 *     Hint: Use the answer to P20.
 */
object P23 extends App {
  // imparetive way
  def randomSelect[T](a : Int, b : List[T]): List[T] = {
    for(i <- 1 to a) yield b(Random.nextInt(b.length))
  } toList
  
  import P20.removeAt

  def randomSelect1[A](n: Int, ls: List[A]): List[A] =
    if (n <= 0) Nil
    else {
      val (rest, e) = removeAt((new util.Random).nextInt(ls.length), ls)
      e :: randomSelect1(n - 1, rest)
    }

  // It can be expensive to create a new Random instance every time, so let's
  // only do it once.
  def randomSelect2[A](n: Int, ls: List[A]): List[A] = {
    def randomSelectR(n: Int, ls: List[A], r: util.Random): List[A] =
      if (n <= 0) Nil
      else {
        val (rest, e) = removeAt(r.nextInt(ls.length), ls)
        e :: randomSelectR(n - 1, rest, r)
      }
    randomSelectR(n, ls, new util.Random)
  }

  
  println(randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
}