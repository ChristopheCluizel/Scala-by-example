//package chapter7

object exercise_7_2_2 {
  val treeOneTwo = new Node(2, new Node(1, EmptyTree, EmptyTree), EmptyTree)
                                                  //> treeOneTwo  : Node = Node(2,Node(1,EmptyTree,EmptyTree),EmptyTree)
  val treeTwo = new Node(2, EmptyTree, EmptyTree) //> treeTwo  : Node = Node(2,EmptyTree,EmptyTree)
  val treeThree = new Node(3, EmptyTree, EmptyTree)
                                                  //> treeThree  : Node = Node(3,EmptyTree,EmptyTree)
  // test contains
  assert(treeOneTwo contains 1)
  assert(treeOneTwo contains 2)
  assert(!(treeOneTwo contains 3))
             
  // test insert
  val treeTwoThree = treeTwo insert 3             //> treeTwoThree  : IntTree = Node(2,EmptyTree,Node(3,EmptyTree,EmptyTree))
  assert(!(treeTwoThree contains 1))
  assert(treeTwoThree contains 2)
  assert(treeTwoThree contains 3)
}
  
  abstract class IntTree {
  	def contains(v: Int): Boolean = this match {
  		case EmptyTree => false
  		case Node(elem, left, right) => {
  			if(v == elem) true
  			else if(v < elem) left contains v
  			else right contains v
  		}
  	}
  	
  	def insert(v: Int): IntTree = this match {
  		case EmptyTree => new Node(v, EmptyTree, EmptyTree)
  		case Node(elem, left, right) => {
  			if(v == elem) this
  			else if(v < elem) new Node(elem, left insert v, right)
  			else new Node(elem, left, right insert v)
  		}
  	}
  }
  
case object EmptyTree extends IntTree
case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree