object exercise_5_2_2 {
	def product(f: Int => Int)(a: Int, b: Int): Int = {
		if(a > b) 1 else f(a) * product(f)(a + 1, b)
	}                                         //> product: (f: Int => Int)(a: Int, b: Int)Int
	
	product(x => x)(1, 4)                     //> res0: Int = 24
}