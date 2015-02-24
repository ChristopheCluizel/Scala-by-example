object exercise_5_2_4 {
	def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x+y, 0)(a, b)
                                                  //> sum: (f: Int => Int)(a: Int, b: Int)Int
	
	def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x*y, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
	
	def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
		if(a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
	}                                         //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
	
	sum(x => x)(0, 10)                        //> res0: Int = 55
	product(x => x)(1, 4)                     //> res1: Int = 24
}