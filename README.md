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


* P11 (*) Modified run-length encoding.

Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
Example:

	scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

* P12 (**) Decode a run-length encoded list.

Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
Example:

	scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
	res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

* P13 (**) Run-length encoding of a list (direct solution).

Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
Example:

	scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

* P14 (*) Duplicate the elements of a list.

Example:

	scala> duplicate(List('a, 'b, 'c, 'c, 'd))
	res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

* P15 (**) Duplicate the elements of a list a given number of times.

Example:

	scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
	res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

* P16 (**) Drop every Nth element from a list.

Example:

	scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

* P17 (*) Split a list into two parts.

The length of the first part is given. Use a Tuple for your result.
Example:

	scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

* P18 (**) Extract a slice from a list.

Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
Example:

	scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	res0: List[Symbol] = List('d, 'e, 'f, 'g)

* P19 (**) Rotate a list N places to the left.

Examples:

	scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

	scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

* P20 (*) Remove the Kth element from a list.

Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:

	scala> removeAt(1, List('a, 'b, 'c, 'd))
	res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

* P21 (*) Insert an element at a given position into a list.

Example:

	scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
	res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

* P22 (*) Create a list containing all integers within a given range.

Example:

	scala> range(4, 9)
	res0: List[Int] = List(4, 5, 6, 7, 8, 9)

* P23 (**) Extract a given number of randomly selected elements from a list.

Example:

	scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
	res0: List[Symbol] = List('e, 'd, 'a)

Hint: Use the solution to problem P20

* P24 (*) Lotto: Draw N different random numbers from the set 1..M.

Example:
	scala> lotto(6, 49)
	res0: List[Int] = List(23, 1, 17, 33, 21, 37)

* P25 (*) Generate a random permutation of the elements of a list.

Hint: Use the solution of problem P23.
Example:

	scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
	res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

related topic:

* http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
* http://blog.codinghorror.com/the-danger-of-naivete/
* http://bost.ocks.org/mike/shuffle/
* http://www.i-programmer.info/programming/theory/2744-how-not-to-shuffle-the-kunth-fisher-yates-algorithm.html
* **TODO : [perfect shuffle](http://okmij.org/ftp/Haskell/perfect-shuffle.txt)**

* P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.

In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient). For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
Example:

	scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
	res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

* P27 (**) Group the elements of a set into disjoint subsets.

a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.
Example:

	scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
	res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...

b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.

Example:

	scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
	res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...

Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...). However, we make a difference between ((Aldo, Beat), (Carla, David), ...) and ((Carla, David), (Aldo, Beat), ...).

You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".

**TODO compile error**

* P28 (**) Sorting a list of lists according to length of sublists.

a) We suppose that a list contains elements that are lists themselves. The objective is to sort the elements of the list according to their length. E.g. short lists first, longer lists later, or vice versa.
Example:

	scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
	res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))

b) Again, we suppose that a list contains elements that are lists themselves. But this time the objective is to sort the elements according to their length frequency; i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed, others with a more frequent length come later.

Example:

	scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
	res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))

Note that in the above example, the first two lists in the result have length 4 and 1 and both lengths appear just once. The third and fourth lists have length 3 and there are two list of this length. Finally, the last three lists have length 
2. This is the most frequent length.

### Arithmetic

For the next section, we're going to take a different tack with the solutions. We'll declare a new class, S99Int, and an implicit conversion from regular Ints. The [arithmetic1](https://github.com/jasonqu/Ninety-Nine-Scala-Problems/blob/master/src/main/scala/arithmetic/package.scala) file contains the starting definitions for this section. Each individual solution will show the relevant additions to the S99Int class. The full class will be given at the end of the section.

* P31 (**) Determine whether a given integer number is prime.

	scala> 7.isPrime
	res0: Boolean = true

* P32 (**) Determine the greatest common divisor of two positive integer numbers.

Use Euclid's algorithm.

	scala> gcd(36, 63)
	res0: Int = 9

* P33 (*) Determine whether two positive integer numbers are coprime.

Two numbers are coprime if their greatest common divisor equals 1.

	scala> 35.isCoprimeTo(64)
	res0: Boolean = true
* P34 (**) Calculate Euler's totient function phi(m).

Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.

	scala> 10.totient
	res0: Int = 4

* P35 (**) Determine the prime factors of a given positive integer.

Construct a flat list containing the prime factors in ascending order.

	scala> 315.primeFactors
	res0: List[Int] = List(3, 3, 5, 7)

* P36 (**) Determine the prime factors of a given positive integer (2).

Construct a list containing the prime factors and their multiplicity.

	scala> 315.primeFactorMultiplicity
	res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))

Alternately, use a Map for the result.

	scala> 315.primeFactorMultiplicity
	res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)

* P37 (**) Calculate Euler's totient function phi(m) (improved).

See problem P34 for the definition of Euler's totient function. If the list of the prime factors of a number m is known in the form of problem P36 then the function phi(m>) can be efficiently calculated as follows: Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors (and their multiplicities) of a given number m. Then phi(m) can be calculated with the following formula:

<p>phi(<i>m</i>) =
(<i>p</i><sub>1</sub>-1)*<i>p</i><sub>1</sub><sup>(<i>m</i><sub>1</sub>-1)</sup>
*(<i>p</i><sub>2</sub>-1)*<i>p</i><sub>2</sub><sup>(<i>m</i><sub>2</sub>-1)</sup>
*(<i>p</i><sub>3</sub>-1)*<i>p</i><sub>3</sub><sup>(<i>m</i><sub>3</sub>-1)</sup> * ...</p>

Note that ab stands for the bth power of a.

* P38 (*) Compare the two methods of calculating Euler's totient function.
Use the solutions of problems P34 and P37 to compare the algorithms. Try to calculate phi(10090) as an example.

* P39 (*) A list of prime numbers.
Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.

	scala> listPrimesinRange(7 to 31)
	res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

* P40 (**) Goldbach's conjecture.

Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers. E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the general case. It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent). Write a function to find the two prime numbers that sum up to a given even integer.

	scala> 28.goldbach
	res0: (Int, Int) = (5,23)

* P41 (**) A list of Goldbach compositions.

Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.

	scala> printGoldbachList(9 to 20)
	10 = 3 + 7
	12 = 5 + 7
	14 = 3 + 11
	16 = 3 + 13
	18 = 5 + 13
	20 = 3 + 17

In most cases, if an even number is written as the sum of two prime numbers, one of them is very small. Very rarely, the primes are both bigger than, say, 50. Try to find out how many such cases there are in the range 2..3000.

Example (minimum value of 50 for the primes):

	scala> printGoldbachListLimited(1 to 2000, 50)
	992 = 73 + 919
	1382 = 61 + 1321
	1856 = 67 + 1789
	1928 = 61 + 1867

The file containing the full class for this section is [arithmetic.scala](https://github.com/jasonqu/Ninety-Nine-Scala-Problems/blob/master/src/main/scala/arithmetic/package.scala).


### Logic and Codes

As in the previous section, we will start with a skeleton file, logic1.scala, and add code to it for each problem. The difference here is that the file starts out almost empty.

* P46 (**) Truth tables for logical expressions.

Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence) which return true or false according to the result of their respective operations; e.g. and(A, B) is true if and only if both A and B are true.

	scala> and(true, true)
	res0: Boolean = true
	
	scala> xor(true. true)
	res1: Boolean = false

A logical expression in two variables can then be written as an function of two variables, e.g: `(a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))`

Now, write a function called table2 which prints the truth table of a given logical expression in two variables.

	scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
	A     B     result
	true  true  true
	true  false true
	false true  false
	false false false

* P47 (*) Truth tables for logical expressions (2).

Continue problem P46 by redefining and, or, etc as operators. (i.e. make them methods of a new class with an implicit conversion from Boolean.) not will have to be left as a object method.

	scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
	A     B     result
	true  true  true
	true  false true
	false true  false
	false false false

* P48 (**) Truth tables for logical expressions (3).

Omitted for now.

* P49 (**) Gray code. **TODO a cleaner version**

An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,

	n = 1: C(1) = ("0", "1").
	n = 2: C(2) = ("00", "01", "11", "10").
	n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").

Find out the construction rules and write a function to generate Gray codes.

	scala> gray(3)
	res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)

See if you can use memoization to make the function more efficient.

* P50 (***) Huffman code. **TODO a cleaner version?**

First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman codes!

We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples. E.g. `(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))`. Our objective is to construct a list of (S, C) Tuples, where C is the Huffman code word for the symbol S.

	scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
	res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))






