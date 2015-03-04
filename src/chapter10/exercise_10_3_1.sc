package chapter10

object exercise_10_3_1 {
	def flatten[A](xss: List[List[A]]): List[A] =
		(xss :\ (Nil: List[A])) ((xs, ys) => xs ::: ys)
                                                  //> flatten: [A](xss: List[List[A]])List[A]
		
	def flattenFor[A](xss: List[List[A]]): List[A] =
		for (lst <- xss; nb <- lst) yield nb
                                                  //> flattenFor: [A](xss: List[List[A]])List[A]
		
	val list = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
                                                  //> list  : List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
	flatten(list)                             //> res0: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
	
	// test flattenFor
	assert(flattenFor(list) == flatten(list))
}