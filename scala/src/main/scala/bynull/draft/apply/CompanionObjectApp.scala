package bynull.draft.apply

/**
  * Created by null on 4/5/16.
  */
object CompanionObjectApp extends App {
  CompanionObject("Dmitry").hello
  CompanionObject().hello
}

/**
  * http://daily-scala.blogspot.ru/2009/09/companion-object.html
  * An analog to a companion object in Java is having a class with static methods. In Scala you would move the static methods to a Companion object.
  * 1. One of the most common uses of a companion object is to define factory methods for class.
  * 2.
  */
object CompanionObject {
  private val privateStaticVariable = 0
  val singletonValue = 0

  def apply(name: String): CompanionObject = new CompanionObject(name)

  def apply(): CompanionObject = new CompanionObject("Mr. Doe")
}

class CompanionObject(name: String) {
  val singletonValue = 15

  def hello = println("Hello " + name + ", and private static variable is: " + CompanionObject.privateStaticVariable)
}
