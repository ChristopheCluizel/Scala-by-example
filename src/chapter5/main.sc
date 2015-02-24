object main {
  def id(x: Int): Int = x                         //> id: (x: Int)Int
  
	def square(x: Int): Int = x * x           //> square: (x: Int)Int
	
	def powerOfTwo(x: Int): Int =
		if(x == 0) 1
		else 2 * powerOfTwo(x - 1)        //> powerOfTwo: (x: Int)Int
		
	/* definition of sums */
	def sumInts(a: Int, b: Int): Int =
		if(a > b) 0 else a + sumInts(a + 1, b)
                                                  //> sumInts: (a: Int, b: Int)Int
	def sumSquares(a: Int, b: Int): Int =
		if(a > b) 0 else square(a) + sumSquares(a + 1, b)
                                                  //> sumSquares: (a: Int, b: Int)Int
	def sumPowerOfTwo(a: Int, b: Int): Int =
		if(a > b) 0 else powerOfTwo(a) + sumPowerOfTwo(a + 1, b)
                                                  //> sumPowerOfTwo: (a: Int, b: Int)Int
		
	/* upgrade */
  def sum(f: Int => Int, a: Int, b: Int): Int =
  	if(a > b) 0 else f(a) + sum(f, a + 1, b)  //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  def sumInts2(a: Int, b: Int): Int = sum(id, a, b)
                                                  //> sumInts2: (a: Int, b: Int)Int
  def sumSquares2(a: Int, b: Int): Int = sum(square, a, b)
                                                  //> sumSquares2: (a: Int, b: Int)Int
 	def sumPowerOfTwo2(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
                                                  //> sumPowerOfTwo2: (a: Int, b: Int)Int
  /* upgrade */
  def sumInts3(a: Int, b: Int): Int = sum(x => x, a, b)
                                                  //> sumInts3: (a: Int, b: Int)Int
  def sumSquares3(a: Int, b: Int): Int = sum(x => x * x, a, b)
                                                  //> sumSquares3: (a: Int, b: Int)Int
  /* upgrade */
  def sum2(f: Int => Int): (Int, Int) => Int = {
  	def sumF(a: Int, b: Int): Int =
  		if(a > b) 0 else f(a) + sumF(a + 1, b)
  	sumF
  }                                               //> sum2: (f: Int => Int)(Int, Int) => Int
  def sumInts4 = sum2(x => x)                     //> sumInts4: => (Int, Int) => Int
  def sumSquares4 = sum2(x => x * x)              //> sumSquares4: => (Int, Int) => Int
  def sumPowerOfTwo4 = sum2(powerOfTwo)           //> sumPowerOfTwo4: => (Int, Int) => Int
  
  /* upgrade */
  def sum3(f: Int => Int)(a: Int, b: Int): Int =
  	if(a > b) 0 else f(a) + sum3(f)(a + 1, b) //> sum3: (f: Int => Int)(a: Int, b: Int)Int
  def sumInts5 = sum3(x => x)_                    //> sumInts5: => (Int, Int) => Int
  def sumSquares5 = sum3(x => x * x)_             //> sumSquares5: => (Int, Int) => Int
  def sumPowerOfTwo5 = sum3(powerOfTwo)_          //> sumPowerOfTwo5: => (Int, Int) => Int
  sumSquares5(1, 10)                              //> res0: Int = 385
}