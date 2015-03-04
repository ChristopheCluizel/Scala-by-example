//package chapter10

object exercise_10_3_2 {
	case class Book(title: String, authors: List[String])
	
	val books: List[Book] = List(
		Book("Structure and Interpretation of Computer Programs",
			List("Abelson, Harold", "Sussman, Gerald J.")),
		Book("Principles of Compiler Design",
			List("Aho, Alfred", "Ullman, Jeffrey")),
		Book("Programming in Modula-2",
			List("Wirth, Niklaus")),
		Book("Introduction to Functional Programming",
			List("Bird, Richard")),
		Book("The Java Language Specification",
			List("Gosling, James", "Joy, Bill", "Steele, Guy", "Bracha, Gilad")))
                                                  //> books  : List[exercise_10_3_2.Book] = List(Book(Structure and Interpretation
                                                  //|  of Computer Programs,List(Abelson, Harold, Sussman, Gerald J.)), Book(Princ
                                                  //| iples of Compiler Design,List(Aho, Alfred, Ullman, Jeffrey)), Book(Programmi
                                                  //| ng in Modula-2,List(Wirth, Niklaus)), Book(Introduction to Functional Progra
                                                  //| mming,List(Bird, Richard)), Book(The Java Language Specification,List(Goslin
                                                  //| g, James, Joy, Bill, Steele, Guy, Bracha, Gilad)))
                                                  
    for (b <- books; a <- b.authors if a startsWith "Bird") yield b.title
                                                  //> res0: List[String] = List(Introduction to Functional Programming)
    
    for (b <- books if (b.title indexOf "Program") >= 0) yield b.title
                                                  //> res1: List[String] = List(Structure and Interpretation of Computer Programs,
                                                  //|  Programming in Modula-2, Introduction to Functional Programming)
    
    
    //books flatMap(x => for (author <- x.authors if author startsWith "Bird") yield x.title)
    /*books flatMap(book => for {author <-
    	book.authors.filter(y => y startsWith "Bird")
 		} yield book.title)    */
 		
 		books flatMap(book => (book.authors.filter(y => y startsWith "Bird")) map (author => book.title))
                                                  //> res2: List[String] = List(Introduction to Functional Programming)
 		
 		//books flatMap(book => (book.title.filter(y => (y indexOf "Program") >= 0)))
 		//for (b <- books.filter(b => (b.title indexOf "Program") >= 0)) yield b.title
 		books.filter(book => (book.title indexOf "Program") >= 0) map (book => book.title)
                                                  //> res3: List[String] = List(Structure and Interpretation of Computer Programs
                                                  //| , Programming in Modula-2, Introduction to Functional Programming)
}