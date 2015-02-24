//package chapter6
import scala.math.abs

object Rational {
	val nb1 = new Rational(1, 2)              //> nb1  : Rational.Rational = 1/2
	val nb2 = new Rational(3, 4)              //> nb2  : Rational.Rational = 3/4
		
	nb1 + nb2                                 //> res0: Rational.Rational = 5/4
	nb1 - nb2                                 //> res1: Rational.Rational = -1/4
	nb1 * nb2                                 //> res2: Rational.Rational = 3/8
	nb1 / nb2                                 //> res3: Rational.Rational = 2/3
	-nb1                                      //> res4: Rational.Rational = -1/2
	
	class Rational(val numer: Int, val denom: Int) {
		
		private val g = gcd(numer, denom)
		
		def +(that: Rational) = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
		
		def -(that: Rational) = this + -that
		
		def *(that: Rational) = new Rational(numer * that.numer, denom * that.denom)
			
		def /(that: Rational) = new Rational(numer * that.denom, denom * that.numer)
		
		def unary_- : Rational = new Rational(-numer, denom)
			
		private def gcd(a: Int, b: Int): Int = if(b == 0) abs(a) else gcd(b, a % b)
		
		override def toString = (numer / g) + "/" + (denom / g)
	}
}