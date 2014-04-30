Ninety-Nine-Scala-Problems
==========================

[Ninety-Nine Scala Problems](http://aperiodic.net/phil/scala/s-99/) from [Phil Gold](http://aperiodic.net/phil/). An adaptation of the [Ninety-Nine Prolog Problems](https://prof.ti.bfh.ch/hew1/informatik3/prolog/p-99/) written by Werner Hett at the Berne University of Applied Sciences in Berne, Switzerland.

### Working with lists

In Scala, lists are objects of type List[A], where A can be any type. Lists are effective for many recursive algorithms, because it's easy to add elements to the head of a list, and to get the tail of the list, which is everything but the first element.

The solutions to the problems in this section will be in objects named after the problems (P01, P02, etc.). You can compile the source files with scalac and thereafter use import to bring the functions into scope. Some of the problems can be solved easily by using imported solutions to previous problems.

In many cases, there's more than one reasonable approach. The files linked here may include multiple solutions, with all but one commented out. They'll also indicate whether there's a builtin method in Scala that accomplishes the task.

* P01 (*) Find the last element of a list.

Example:

	scala> last(List(1, 1, 2, 3, 5, 8))
	res0: Int = 8

* P02 (*) Find the last but one element of a list.

Example:

	scala> penultimate(List(1, 1, 2, 3, 5, 8))
	res0: Int = 5

* P02+ (*) Find the last Kth element of a list.

Example:

	scala> lastNth(2, List(1, 1, 2, 3, 5, 8))
	res0: Int = 5

* P03 (*) Find the Kth element of a list.
By convention, the first element in the list is element 0.

Example:

	scala> nth(2, List(1, 1, 2, 3, 5, 8))
	res0: Int = 2

* P04 (*) Find the number of elements of a list.

Example:

	scala> length(List(1, 1, 2, 3, 5, 8))
	res0: Int = 6

* P05 (*) Reverse a list.

Example:

	scala> reverse(List(1, 1, 2, 3, 5, 8))
	res0: List[Int] = List(8, 5, 3, 2, 1, 1)

* P06 (*) Find out whether a list is a palindrome.

Example:

	scala> isPalindrome(List(1, 2, 3, 2, 1))
	res0: Boolean = true

* P07 (**) Flatten a nested list structure.

Example:

	scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
	res0: List[Any] = List(1, 1, 2, 3, 5, 8)

* P08 (**) Eliminate consecutive duplicates of list elements.

If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

Example:

	scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

* P09 (**) Pack consecutive duplicates of list elements into sublists.

If a list contains repeated elements they should be placed in separate sublists.
Example:

	scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

* P10 (*) Run-length encoding of a list.

Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
Example:

	scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))





