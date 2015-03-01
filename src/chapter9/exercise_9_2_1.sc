//package chapter9

object exercise_9_2_1 {
	def length(list: List[Int]): Int = list match {
		case Nil => 0
		case x :: xs => 1 + xs.length
	}                                         //> length: (list: List[Int])Int
	
	def lengthTailRec(list: List[Int]): Int = {
		def iter(list: List[Int], acc: Int): Int = list match {
			case Nil => acc
			case x :: xs => iter(xs, acc + 1)
		}
		iter(list, 0)
	}                                         //> lengthTailRec: (list: List[Int])Int

	val numbers: List[Int] = List(1, 2, 3, 4) //> numbers  : List[Int] = List(1, 2, 3, 4)
	val lengthNumbers = length(numbers)       //> lengthNumbers  : Int = 4
	
	// test lengthTailRec
	assert(lengthTailRec(numbers) == 4)
	assert(lengthTailRec(List()) == 0)
}