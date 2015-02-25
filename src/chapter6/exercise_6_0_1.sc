//package chapter6

object exercise_6_0_1 {
	
	val val1 = new NonEmptySet(9, new NonEmptySet(10, EmptySet, EmptySet), EmptySet)
                                                  //> val1  : NonEmptySet = {{.10.}9.}
	val other = new NonEmptySet(14, new NonEmptySet(9, EmptySet, EmptySet), new NonEmptySet(16, EmptySet, EmptySet))
                                                  //> other  : NonEmptySet = {{.9.}14{.16.}}
	val unionVal = val1 union other           //> unionVal  : IntSet = {{.9{.10.}}14{.16.}}
	val intersectionVal = other intersection val1
                                                  //> intersectionVal  : IntSet = {{.10.}9.}
}

trait IntSet {
	def incl(x: Int): IntSet
	def contains(x: Int): Boolean
	def union(other: IntSet): IntSet
	def intersection(other: IntSet): IntSet
}
	
object EmptySet extends IntSet {
	def contains(x: Int): Boolean = false
	
	def incl(x: Int): IntSet =
		new NonEmptySet(x, EmptySet, EmptySet)
		
	def union(other: IntSet): IntSet = other
	
	def intersection(other: IntSet): IntSet = this
	
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
		
	def intersection(other: IntSet): IntSet = other // TODO
		
	override def toString: String = "{" + left + elem + right + "}"
		
}