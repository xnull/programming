package bynull.viewbounds

/**
  * https://twitter.github.io/scala_school/advanced-types.html
  */
object ViewBounds extends App {
  val upper = MyInvariantBounder[Child](new Child)
  upper.print()
}

trait GrandParent

class Parent extends GrandParent {

  override def toString = s"Parent()"
}

class Child extends Parent {
  override def toString = s"Child()"
}

case class MyInvariantBounder[+A](value: A) {
  def print() = println(value)
}

case class MyContravariantBounder[-A](value: A) {
  def print() = println(value)
}
