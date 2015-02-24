object exercice_4_4_1 {
		def sqrt(x: Double) = {
			def sqrtIter(guess: Double): Double =
				if(isGoodEnough(guess)) guess
				else sqrtIter(improve(guess))
				
			def isGoodEnough(guess: Double) =
				abs(x - square(guess)) <= math.ulp(x)
				
			def square(x: Double) = x * x
			
			def abs(x: Double) = if(x < 0) -x else x
			
			def improve(guess: Double) = {
				//println(guess)
				(guess + x/guess) / 2
			}
			
			sqrtIter(1.0)
		}                                 //> sqrt: (x: Double)Double
		
		val x = sqrt(4)                   //> x  : Double = 2.0
		assert(x == 2)
}