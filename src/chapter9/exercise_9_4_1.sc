//package chapter9

object exercise_9_4_1 {
	def squareList(xs: List[Int]): List[Int] = xs match {
		case List() => xs
		case y :: ys => y*y :: squareList(ys)
	}                                         //> squareList: (xs: List[Int])List[Int]
	
	def squareListMap(xs: List[Int]): List[Int] =
		xs map(y => y*y)                  //> squareListMap: (xs: List[Int])List[Int]
		
	val list1 =  List(1, 2, 3, 4)             //> list1  : List[Int] = List(1, 2, 3, 4)
 	// test squareList
 	assert(squareList(list1) == List[Int](1, 4, 9, 16))
 	
 	// test squareListMap
 	assert(squareListMap(list1) == List[Int](1, 4, 9, 16))
}