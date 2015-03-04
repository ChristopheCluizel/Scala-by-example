package chapter9

object exercise_9_4_3 {
	def mapFun[A, B](xs: List[A], f: A => B): List[B] =
		(xs :\ List[B]()){(x, xs) => f(x) :: xs} // foldRight
                                                  //> mapFun: [A, B](xs: List[A], f: A => B)List[B]
		
	def lengthFun[A](xs: List[A]): Int =
		(0 /: xs){(x, xs) => x + 1}       //> lengthFun: [A](xs: List[A])Int
	val list = List(1, 2, 3, 4)               //> list  : List[Int] = List(1, 2, 3, 4)
	
	// test mapFun
	assert(mapFun[Int, Int](list, x => x * x) == List(1, 4, 9, 16))
	
	// test lengthFun
	assert(lengthFun[Int](list) == 4)
}