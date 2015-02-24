object exercise_4_6_1 {
  def factorial(n: Int) = {
  	assert(n >= 0)
  	
  	def factorialIter(n: Int, acc: Int): Int =
  		if(n == 0) acc
  		else factorialIter(n - 1, n * acc)
  	factorialIter(n, 1)
  }                                               //> factorial: (n: Int)Int
  val x = factorial(3)                            //> x  : Int = 6
}