package working_with_list

/**
 * P06 (*) Find out whether a list is a palindrome.
 * Example:
 * scala> isPalindrome(List(1, 2, 3, 2, 1))
 * res0: Boolean = true
 */
object P06 extends App {

  // complexity O(n * n)
  def isPalindrome[T](list: List[T]): Boolean = {
    list match {
      case Nil => true
      case _ :: Nil => true
      case _ if list.head == list.last => isPalindrome(list.tail.init)
      case _ => false
    }
  }
  
  // In theory, we could be slightly more efficient than this.  This approach
  // traverses the list twice: once to reverse it, and once to check equality.
  // Technically, we only need to check the first half of the list for equality
  // with the first half of the reversed list.  The code to do that more
  // efficiently than this implementation is much more complicated, so we'll
  // leave things with this clear and concise implementation.
  def isPalindrome2[A](ls: List[A]): Boolean = ls == ls.reverse
  

  assert(isPalindrome(List(1, 2, 3, 2, 1)))
  assert(!isPalindrome(List(1, 1, 3, 2, 1)))
}