//package chapter11

object exercise_11_2_1 {
	def repeatLoop(command: => Unit)(condition: => Boolean) {
		if(!condition) {
			command; repeatLoop(command)(condition)
		}
		else ()
	}                                         //> repeatLoop: (command: => Unit)(condition: => Boolean)Unit
	
	// test repeatLoop
	var counter: Int = 0                      //> counter  : Int = 0
	repeatLoop{
		println("pouet")
		counter += 1
	} (counter >= 5)                          //> pouet
                                                  //| pouet
                                                  //| pouet
                                                  //| pouet
                                                  //| pouet
}