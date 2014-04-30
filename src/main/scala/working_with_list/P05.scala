package working_with_list

/**
 * P05 (*) Reverse a list.
 * Example:
 * scala> reverse(List(1, 1, 2, 3, 5, 8))
 * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */
object P05 extends App {

  // complexity O(n)
  def reverse[T](list: List[T]): List[T] = {
    list.reverse
  }
  
  // complexity O(n * n)
  def reverseBad[T](list: List[T]): List[T] = {
    list match {
      case a @ List(_) => a
      case head :: last => reverseBad(last) ::: List(head)
    }
  }
  
  // Tail recursive.
  def reverseTailRecursive[A](ls: List[A]): List[A] = {
    def reverseR(result: List[A], curList: List[A]): List[A] = curList match {
      case Nil       => result
      case h :: tail => reverseR(h :: result, tail)
    }
    reverseR(Nil, ls)
  }

  // complexity O(n), can use "List[T]()" instead of "Nil : List[T]" 
  def reverse2[T](list: List[T]): List[T] = {
    list.foldLeft(Nil : List[T])((list, elem) => elem :: list)
  }
  
  assert(List(8, 5, 3, 2, 1, 1) == reverse(List(1, 1, 2, 3, 5, 8)))
  assert(List(8, 5, 3, 2, 1, 1) == reverseBad(List(1, 1, 2, 3, 5, 8)))
  assert(List(8, 5, 3, 2, 1, 1) == reverse2(List(1, 1, 2, 3, 5, 8)))
}