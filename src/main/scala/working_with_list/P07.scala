package working_with_list

/**
 * P07 (**) Flatten a nested list structure.
 * Example:
 * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
 * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */
object P07 extends App {

  // no good solution since the input has no type info 
  // lost type info
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }
  
  assert(List(1, 1, 2, 3, 5, 8) == flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
}