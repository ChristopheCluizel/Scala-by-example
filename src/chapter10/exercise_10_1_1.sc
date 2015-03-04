//package chapter10
import scala.math.abs

object exercise_10_1_1 {
	def isSafe(col: Int, queens: List[Int], delta: Int): Boolean = queens match {
		case Nil => true
		case x :: xs =>
			col != x && abs(col - x) != delta && isSafe(col, xs, delta + 1)
	}                                         //> isSafe: (col: Int, queens: List[Int], delta: Int)Boolean

	def queens(n: Int): List[List[Int]] = {
		def placeQueens(k: Int): List[List[Int]] =
			if (k == 0) List(List())
			else for { queens <- placeQueens(k - 1)
									column <- List.range(1, n + 1)
									if isSafe(column, queens, 1) } yield column :: queens
		placeQueens(n)
	}                                         //> queens: (n: Int)List[List[Int]]
	
	// test isSafe
	val list = List(1, 4, 2)                  //> list  : List[Int] = List(1, 4, 2)
	assert(!isSafe(4, list, 1))
	assert(isSafe(3, list, 1))
	assert(!isSafe(4, List(2, 3, 1), 1))
	
	queens(4)                                 //> res0: List[List[Int]] = List(List(3, 1, 4, 2), List(2, 4, 1, 3))
	queens(8).length                          //> res1: Int = 92
}