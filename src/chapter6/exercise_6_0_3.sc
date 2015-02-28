object exercise_6_0_3 {
  val valZero = Zero                              //> valZero  : Zero.type = Zero$@68a614a4
  val valOne = new Succ(Zero)                     //> valOne  : Succ = Succ@26116f4f
  val valTwo = new Succ(valOne)                   //> valTwo  : Succ = Succ@42a2bf0f
  val valThree = new Succ(new Succ(new Succ(Zero)))
                                                  //> valThree  : Succ = Succ@4aad93f6
  val valOneNeg = new Pred(Zero)                  //> valOneNeg  : Pred = Pred@49cd21c7
  val valTwoNeg = new Pred(valOneNeg)             //> valTwoNeg  : Pred = Pred@3a64b5ab
  val valThreeNeg = new Pred(new Pred(new Pred(Zero)))
                                                  //> valThreeNeg  : Pred = Pred@29d30b80
  // ============ test class Zero ============
  // test isPositive
	assert(valZero.isPositive)
	
  // test predecessor/successor
  assert(!valZero.predecessor.isPositive)
  assert(valZero.successor.isPositive)

	// test +
  assert((valZero + valZero).isZero)
  assert((valZero + valOne).isPositive)
  assert((valZero + valOne).predecessor.isZero)
  assert(!(valZero + valOneNeg).isPositive)
  assert((valZero + valOneNeg).successor.isZero)
  
  // test -
  assert((valZero - valZero).isZero)
  assert(!(valZero - valOne).isPositive)
  assert((valZero - valOne).successor.isZero)
  assert((valZero - valTwo).successor.successor.isZero)
  assert((valZero - valOneNeg).isPositive)
  assert((valZero - valOneNeg).predecessor.isZero)
  
  // ============ test class Succ ============
  // test isPositive
	assert(valOne.isPositive)
	
  // test predecessor/successor
  assert(valOne.predecessor.isZero)
  assert(valOne.successor.predecessor.predecessor.isZero)
  
  // test +
  assert((valOne + valZero).predecessor.isZero)
  assert((valOne + valOne).predecessor.predecessor.isZero)
  assert((valOne + valTwo).predecessor.predecessor.predecessor.isZero)
  
  // test - (only positive result)
  assert((valOne - valZero).predecessor.isZero)
	assert((valOne - valOne).isZero)
	assert((valTwo - valOne).predecessor.isZero)
	
	// test negate
	assert(!(valTwo negate).isPositive)
	assert((valTwo negate).successor.successor.isZero)
	
	// ============ test class Pred ============
	// test isPositive
	assert(!valOneNeg.isPositive)
	
	// testPredecessor/successor
	assert(valOneNeg.successor.isZero)
	assert(valOneNeg.predecessor.successor.successor.isZero)
	
	
	// test + (only negative result)
	assert((valOneNeg + valZero).successor.isZero)
	assert((valOneNeg + valOneNeg).successor.successor.isZero)
	assert((valOneNeg + valTwoNeg).successor.successor.successor.isZero)
	
	// test -
	assert((valOneNeg - valZero).successor.isZero)
	assert((valOneNeg - valOneNeg).isZero)
	assert((valTwoNeg - valOneNeg).successor.isZero)
	
	// =========== test with sign change ============
	// test +
	assert((valOne + valOneNeg).isZero)
	assert(!(valOne + valTwoNeg).isPositive)
	assert((valOne + valTwoNeg).successor.isZero)
	assert((valOne + valThreeNeg).successor.successor.isZero)
	assert((valOneNeg + valOne).isZero)
	assert((valOneNeg + valTwo).isPositive)
	assert((valOneNeg + valTwo).predecessor.isZero)
	assert((valOneNeg + valThree).predecessor.predecessor.isZero)
	
	// test -
	assert((valOne - valOneNeg).isPositive)
	assert((valOne - valOneNeg).predecessor.predecessor.isZero)
	assert((valTwo - valTwoNeg).predecessor.predecessor.predecessor.predecessor.isZero)
	assert(!(valOne - valThree).isPositive)
	assert((valOne - valThree).successor.successor.isZero)
	assert(!(valOneNeg - valOne).isPositive)
	assert((valOneNeg - valOne).successor.successor.isZero)
	assert((valOneNeg - valThreeNeg).isPositive)
	assert((valOneNeg - valThreeNeg).predecessor.predecessor.isZero)
}

abstract class Integer {
	def isZero: Boolean
	def predecessor: Integer
	def successor: Integer
	def + (that: Integer): Integer
	def - (that: Integer): Integer
	def isPositive: Boolean
	def negate: Integer
}

object Zero extends Integer {
	def isZero: Boolean = true
	def predecessor: Integer = new Pred(Zero)
	def successor: Integer = new Succ(Zero)
	def + (that: Integer): Integer = that
	def - (that: Integer): Integer = {
		def iter(n: Integer, res: Integer): Integer = {
			if(n.isZero) res
			else if(n.isPositive) iter(n.predecessor, res.predecessor)
			else iter(n.successor, res.successor)
		}
		iter(that, this)
	}
	def isPositive: Boolean = true
	def negate: Integer = this
}

class Succ(x: Integer) extends Integer {
	def isZero: Boolean = false
	def predecessor: Integer = x
	def successor: Integer = new Succ(this)
	def + (that: Integer): Integer = x + that.successor
	def - (that: Integer): Integer = x - that.predecessor
	def isPositive: Boolean = true
	def negate: Integer = Zero - this
}

class Pred(x: Integer) extends Integer {
	def isZero: Boolean = false
	def predecessor: Integer = new Pred(this)
	def successor: Integer = x
	def + (that: Integer): Integer = x + that.predecessor
	def - (that: Integer): Integer = x - that.successor
	def isPositive: Boolean = false
	def negate: Integer = Zero - this
}