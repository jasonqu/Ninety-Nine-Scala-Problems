package working_with_list

import scala.annotation.tailrec
import scala.util.Random

/**
 * P24 (*) Lotto: Draw N different random numbers from the set 1..M.
 *     Example:
 *     scala> lotto(6, 49)
 *     res0: List[Int] = List(23, 1, 17, 33, 21, 37)
 */
object P24 extends App {
  // imparetive way
  def lotto(a : Int, b : Int): List[Int] = {
    for(i <- 1 to a) yield Random.nextInt(b) + 1
  } toList
  
  import P23.randomSelect
  def lotto2(count: Int, max: Int): List[Int] = 
    randomSelect(count, List.range(1, max + 1))
  
  println(lotto(6, 49))
}