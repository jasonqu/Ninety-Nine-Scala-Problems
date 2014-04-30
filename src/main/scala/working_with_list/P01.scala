package working_with_list

import java.util.NoSuchElementException
import scala.annotation.tailrec

/**
 * Find the last element of a list.
 * Example:
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 8
 *
 */
object P01 extends App {
  // unlike head, last's complexity is O(n)
  def last[T](list: List[T]): T = {
    list.last
  }

  // complexity O(n)
  @tailrec
  def lastRecursive[T](list: List[T]): T = {
    list match {
      case Nil => throw new NoSuchElementException
      case ele :: Nil   => ele
      case head :: tail => lastRecursive(tail)
    }
  }

  // slightly better since list is probably not empty
  // and it is still tail recursive?! since the compiler will optimize it
  @tailrec
  def lastRecursive2[T](ls: List[T]): T = ls match {
    case h :: Nil  => h
    case _ :: tail => lastRecursive2(tail)
    case _         => throw new NoSuchElementException
  }
  
  assert(8 == last(List(1, 1, 2, 3, 5, 8)))
  assert(8 == lastRecursive(List(1, 1, 2, 3, 5, 8)))
  assert(8 == lastRecursive2(List(1, 1, 2, 3, 5, 8)))
}

/**
 * decompile result by jd-gui-0.3.6, no recursive call
  public <T> T lastRecursive(scala.collection.immutable.List<T> list)
  {
    int i = 0;
    null;
    Object localObject1 = null;
    scala.collection.immutable.List localList1 = list;
    localList2 = localList1; 
    scala.collection.immutable.Nil. tmp17_10 = scala.collection.immutable.Nil..MODULE$;
    if (tmp17_10 == null) { 
      tmp17_10;
      if (localList2 == null) break label38;
      tmpTernaryOp = tmp17_10;
      break label46;
    }
  }
  
  public <T> T lastRecursive2(scala.collection.immutable.List<T> ls)
  {
    int i = 0;
    null;
    scala.collection.immutable..colon.colon localcolon = null;
    scala.collection.immutable.List localList1 = ls;
    if ((localList1 instanceof scala.collection.immutable..colon.colon)) {
      i = 1;
      localcolon = (scala.collection.immutable..colon.colon)localList1;
      Object h = localcolon.hd$1();
      scala.collection.immutable.List localList2 = localcolon.tl$1();
      localList3 = localList2;
      scala.collection.immutable.Nil. tmp48_41 = scala.collection.immutable.Nil..MODULE$;
      if (tmp48_41 == null) {
        tmp48_41;
        if (localList3 == null)
          break label69;
        tmpTernaryOp = tmp48_41;
        break label76;
      }
    }
  }
 */