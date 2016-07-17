package bynull.draft.apply

/**
  * Created by bynull on 05.04.16.
  */
object SingletonApp extends App {

}

/**
  * 1. Each singleton object is implemented as an instance of
  * a synthetic class referenced from a static variable, so they have the same
  * initialization semantics as Java statics.
  * In particular, a singleton object is initialized the first time some code accesses it.
  *
  * A singleton object that does not share the same name with a companion class is called a standalone object.
  *
  *
  */
object MySingleton {
  private val privateField = 0
}
