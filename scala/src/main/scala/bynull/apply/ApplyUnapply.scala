package bynull.apply

import scala.util.Random

object ApplyApp extends App {

}

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


