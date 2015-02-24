object exercise_5_2_3 {
  def product(f: Int => Int)(a: Int, b: Int): Int = {
		if(a > b) 1 else f(a) * product(f)(a + 1, b)
	}                                         //> product: (f: Int => Int)(a: Int, b: Int)Int
	
	def factorial(n: Int): Int = {
		product(x => x)(1, n)
	}                                         //> factorial: (n: Int)Int
	
	factorial(4)                              //> res0: Int = 24
}