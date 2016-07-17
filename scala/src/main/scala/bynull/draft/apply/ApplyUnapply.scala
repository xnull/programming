package bynull.apply

import scala.collection.immutable.Nil
import scala.util.Random


object FirstLatPatternMatching extends App {

  search(List(1, 2, 3, 3, 2, 1))

  def search(list: List[Int]): Boolean = {
    list match {
      case head :: (listBody :+ tail) =>
        if (head != tail) {
          println(s"not palindrome")
          false
        } else {
          println("next step")
          search(listBody)
        }
      case Nil =>
        println("end")
        true
    }
  }
}

/**
  * http://docs.scala-lang.org/tutorials/tour/extractor-objects.html
  *
  * http://danielwestheide.com/blog/2012/11/21/the-neophytes-guide-to-scala-part-1-extractors.html
  */
package unapplyExample {

  object UnapplyApp extends App {
    val user: User = new FreeUser("FreeMan")

    user match {
      //First way to define case
      case free: FreeUser =>
        println("I am a free user, my name is: " + free.name)
      //Another way to define case (always used)
      case PremiumUser(name) =>
        println("I am a premium user, my name is: " + name)
    }
  }

  trait User {
    def name: String
  }

  class FreeUser(val name: String) extends User

  class PremiumUser(val name: String) extends User

  /**
    * Extractor objects
    */
  object FreeUser {
    def unapply(user: FreeUser): Option[String] = Some(user.name)
  }

  object PremiumUser {
    def unapply(user: PremiumUser): Option[String] = Some(user.name)
  }

}

package applyExample {

  /**
    * http://docs.scala-lang.org/tutorials/tour/extractor-objects.html
    * Created by null on 4/5/16.
    */
  object ApplyUnapply extends App {
    UnapplyAndPatternMatching().hello
    UnapplyAndPatternMatching().hello
  }

  object UnapplyAndPatternMatching {
    def apply(): UnapplyAndPatternMatching = new UnapplyAndPatternMatching()
  }

  class UnapplyAndPatternMatching {
    val id = Random.nextInt(1000)

    def hello = println("Hi, I am " + id)
  }

  class SimpleClass {
    def apply: SimpleClass = new SimpleClass()
  }

}


