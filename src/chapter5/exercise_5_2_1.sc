object exercise_5_2_1 {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
  	def iter(a: Int, result: Int): Int = {
  		if(a > b) result
  		else iter(a + 1, f(a) + result)
  	}
  	iter(a, 0)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int
  sum(x => x*x)(0, 10)                            //> res0: Int = 385
}