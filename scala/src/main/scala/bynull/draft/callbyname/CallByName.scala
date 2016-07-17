package bynull.draft.callbyname

/**
  * Created by bynull on 07.04.16.
  */
object CallByName extends App {

  delayed(time())

  def time() = {
    println("Getting time in nano seconds")
    System.nanoTime
  }

  def delayed(t: => Long) = {
    println("In delayed method")
    println("Param: " + t)
    println("t: " + t)
  }
}
