package bynull.draft.collections

import scala.collection.SortedSet

object Sets {

}

/**
  * http://docs.scala-lang.org/overviews/collections/sets
  * Created by bynull on 12.04.16.
  */
object SortedSetApp extends App {
  val setNumbers = SortedSet(5, 4, 3, 2, 1)

  //You can use a custom ordering or extends your elements (which contains in the collection) from Ordered trait
  // for example http://alvinalexander.com/scala/how-to-use-sortable-sets-in-scala-sortedset-treeset
  val reverseSetNumbers = SortedSet(5, 4, 3, 2, 1)(Ordering.fromLessThan(_ > _))

  println("Set numbers collection class: " + setNumbers.getClass)
  print("sorted set, values: ")
  setNumbers.foreach(v => print(v + ", "))
  println()
  print("reverse sorted set, values: ")
  reverseSetNumbers.foreach(v => print(v + ", "))
}


