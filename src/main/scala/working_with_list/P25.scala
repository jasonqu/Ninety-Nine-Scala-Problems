package working_with_list

import scala.annotation.tailrec
import scala.util.Random
import scala.collection.mutable.ArrayBuffer

/**
 * P25 (*) Generate a random permutation of the elements of a list.
 *     Hint: Use the solution of problem P23.
 *
 *     Example:
 *     scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
 *     res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
 */
object P25 extends App {
  // imparetive way, naive
  def randomPermute[T](a : List[T]): List[T] = {
    val ab = ArrayBuffer(a:_*)
    for(i <- 0 to ab.length - 1) {
      val index = Random.nextInt(ab.length - 1)
      val tmp = ab(index)
      ab(index) = ab(i)
      ab(i) = tmp
    }
    ab.toList
  }
  
  // This algorithm is O(n^2), but it makes up for that in simplicity of
  // implementation.
  import P23.randomSelect
  def randomPermute1[A](ls: List[A]): List[A] = randomSelect(ls.length, ls)

  // The canonical way to shuffle imperatively is Fisher-Yates.  It requires a
  // mutable array.  This is O(n).
  def randomPermute2[A](ls: List[A]): List[A] = {
    val rand = new util.Random
    val a = ArrayBuffer(ls:_*)
    for (i <- a.length - 1 to 1 by -1) {
      val i1 = rand.nextInt(i + 1)
      val t = a(i)
      a.update(i, a(i1))
      a.update(i1, t)
    }
    a.toList
  }

  // Efficient purely functional algorithms for shuffling are a lot harder.  One
  // is described in http://okmij.org/ftp/Haskell/perfect-shttp://okmij.org/ftp/Haskell/perfect-shuffle.txthuffle.txt using
  // Haskell. Implementing it in Scala is left as an exercise for the reader
  
  println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
}