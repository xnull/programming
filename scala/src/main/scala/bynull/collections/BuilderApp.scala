package bynull.collections

/**
  * Created by bynull on 12.04.16.
  */
class BuilderApp extends App {


}

class Builder extends scala.collection.mutable.Builder[Int, String] {
  def +=(elem: Int) = ???

  def result() = ???

  def clear() = ???
}
