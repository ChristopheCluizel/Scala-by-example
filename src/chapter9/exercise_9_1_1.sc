//package chapter9

object exercise_9_1_1 {
	def isort(xs: List[Int]): List[Int] =
		if(xs.isEmpty) Nil
		else insert(xs.head, isort(xs.tail))
                                                  //> isort: (xs: List[Int])List[Int]
	def insert(x: Int, xs: List[Int]): List[Int] =
		if(xs.isEmpty) List(x)
		else if(x <= xs.head) x :: xs
		else xs.head :: insert(x, xs.tail)//> insert: (x: Int, xs: List[Int])List[Int]

	val numbers: List[Int] = List(4, 8, 1, 5) //> numbers  : List[Int] = List(4, 8, 1, 5)
	
	// test insert
	val res1 = insert(3, List(4, 8, 1, 5))    //> res1  : List[Int] = List(3, 4, 8, 1, 5)
	assert(res1 contains 3)
	
	// test isort
	val res2 = isort(numbers)                 //> res2  : List[Int] = List(1, 4, 5, 8)
	assert(res2.head == 1)
	assert(res2.tail.head == 4)
	assert(res2.tail.tail.head == 5)
	assert(res2.tail.tail.tail.head == 8)
}