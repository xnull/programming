package bynull.draft.common

/**
  * Created by null on 4/17/16.
  */
object CanEqualApp extends App {

  val parent = new CanEqualParent
  val child = new CanEqualChild

  println (parent eq child)
}

trait CanEqualTrait

class CanEqualParent extends CanEqualTrait with Equals {
  override def canEqual(that: Any): Boolean = {
    return true
  }
}

class CanEqualChild extends CanEqualParent with Equals
