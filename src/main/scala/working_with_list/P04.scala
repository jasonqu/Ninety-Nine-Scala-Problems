package working_with_list

/**
 * (*) Find the number of elements of a list.
 * Example:
 * scala> length(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 6
 */
object P04 extends App {
  // complexity O(n)
  def length[T](list: List[T]): Int= {
    list.length
  }

  // complexity O(n)
  def lengthRec[T](list: List[T]): Int = {
    list.foldLeft(0){(a, b) => a+1}
  }
  
  assert(6 == lengthRec(List(1, 1, 2, 3, 5, 8)))
}