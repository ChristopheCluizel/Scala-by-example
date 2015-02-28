package chapter6

object exercise_IntSet_6_0_1and2 {
	
	val valOneTwo = new NonEmptySet(2, new NonEmptySet(1, EmptySet, EmptySet), EmptySet)
                                                  //> valOneTwo  : chapter6.NonEmptySet = {{.1.}2.}
	val valThree = new NonEmptySet(3, EmptySet, EmptySet)
                                                  //> valThree  : chapter6.NonEmptySet = {.3.}
	val valUnion = valOneTwo union valThree   //> valUnion  : chapter6.IntSet = {{.1{.2.}}3.}
	
	// test union
	assert(valUnion contains 1)
	assert(valUnion contains 2)
	assert(valUnion contains 3)
	
	// test intersection
	val valIntersectionNotNull = (valOneTwo incl 4) intersection (valThree incl 4)
                                                  //> valIntersectionNotNull  : chapter6.IntSet = {.4.}
	assert(!(valIntersectionNotNull contains 1))
	assert(!(valIntersectionNotNull contains 2))
	assert(!(valIntersectionNotNull contains 3))
	assert(valIntersectionNotNull contains 4)
	
	// test isEmpty
	assert((valOneTwo intersection valThree).isEmpty)
	assert(! valIntersectionNotNull.isEmpty)
	
	// test excl
	assert(valUnion contains 1)
	assert(valUnion contains 2)
	assert(valUnion contains 3)
	assert(!(valUnion excl 2 contains 2))
	assert(valUnion excl 2 contains 1)
	assert(valUnion excl 2 contains 3)
	assert(!(valUnion excl 2 excl 3 contains 3))
	assert(valUnion excl 2 excl 3 contains 1)
	assert((valUnion excl 1 excl 2 excl 3).isEmpty)
}

trait IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
	def intersection(other: IntSet): IntSet
	def isEmpty: Boolean
	def excl(x: Int): IntSet
}
	
object EmptySet extends IntSet {
	def contains(x: Int): Boolean = false
	
	def incl(x: Int): IntSet =
		new NonEmptySet(x, EmptySet, EmptySet)
		
	def union(other: IntSet): IntSet = other
	
	def intersection(other: IntSet): IntSet = this
	
	def isEmpty: Boolean = true
	
	def excl(x: Int): IntSet = this
	
	override def toString: String = "."
}

class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {
	def contains(x: Int): Boolean =
		if (x < elem) left contains x
		else if (x > elem) right contains x
		else true
		
	def incl(x: Int): IntSet =
		if (x < elem) new NonEmptySet(elem, left incl x, right)
		else if (x > elem) new NonEmptySet(elem, left, right incl x)
		else this
		
	def union(other: IntSet): IntSet =
		((left union right) union other) incl elem
		
	def intersection(other: IntSet): IntSet = {
		val res = (left intersection other) union (right intersection other)
		if(other contains(elem)) res incl elem
		else res
	}
	
	def isEmpty: Boolean = false
	
	def excl(x: Int): IntSet = {
		if(elem == x) left union right
		else if(x < elem) (left excl x) union right incl elem
		else (right excl x) union left incl elem
	}
		
	override def toString: String = "{" + left + elem + right + "}"
		
}