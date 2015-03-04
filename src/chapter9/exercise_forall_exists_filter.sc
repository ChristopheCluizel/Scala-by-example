//package chapter9

object exercise_forall_exists_filter {
	def forallFilter[A](list: List[A], p: A => Boolean): Boolean =
		(list filter p).length == list.length
                                                  //> forallFilter: [A](list: List[A], p: A => Boolean)Boolean
		
	def existsFilter[A](list: List[A], p: A => Boolean): Boolean =
		(list filter p).length >= 1       //> existsFilter: [A](list: List[A], p: A => Boolean)Boolean
		
  val evenList = List[Int](2, 4, 6, 8)            //> evenList  : List[Int] = List(2, 4, 6, 8)
  val oddList = List[Int](1, 3, 5, 7)             //> oddList  : List[Int] = List(1, 3, 5, 7)
  
  // test forallFilter
  assert(forallFilter[Int](evenList, x => (x % 2) == 0))
  assert(forallFilter[Int](oddList, x => (x % 2) != 0))
  assert(forallFilter[Int](List[Int](), x => x == 3))	// forallFilter of an empty list must always return true
  assert((List[Int]() forall(x => x == 3)))	// check with the original method
  
  // test existsFilter
  assert(existsFilter[Int](evenList, x => x > 6))
  assert(!existsFilter[Int](evenList, x => x > 8))
  assert(existsFilter[Int](evenList, x => x == 6))
  assert(!existsFilter[Int](evenList, x => x == 3))
  assert(!existsFilter[Int](List[Int](), x => x == 2))
}