package bynull.hackerrank.swap_nodes

/**
  * Created by null on 7/17/16.
  */
object SwapNodesApp extends App {

  val oldIn = System.in
  val dataUrl = ClassLoader.getSystemResource("swap_nodes.txt")

  try {
    System.setIn(dataUrl.openStream())
    Solution.main(Array())
  } finally {
    System.setIn(oldIn)
  }
}

object Solution {

  def main(args: Array[String]) {
    val lines = io.Source.stdin.getLines()
    val nodes = lines.take(1).toSeq.head.toInt
    //val data = lines.take(nodes).toList

    var tree = Node(1)
    funcFill(tree, readValues())

    def funcFill(parent: Node[Int], lr: (Int, Int)): Node[Int] = {
      lr match {
        case (l: Int, r: Int) =>
          println("Complete: " + l)
          //прочитать 2 строки, и заполнить левую и правую ноду
          var left =  parent.left(l)
          val right = left.right(r)
          val leftSubtree = readValues()
          val rightSubtree = readValues()
          funcFill(left, leftSubtree)
          funcFill(right, rightSubtree)

        case (l: Int, -1) =>
          println("Only left: " + l)
          Node(l)
        case (-1, r: Int) =>
          println("Only right: " + r)
          Node(r)
        case (-1, -1) =>
          println("Empty: ")
          Node(-1)
      }
    }

    def readValues(): (Int, Int) = {
      val values = lines.take(1).toSeq.head.split(' ')
      values(0).toInt -> values(1).toInt
    }
  }

  trait Tree[A]

  case class Node[A](value: A, l: Option[Node[A]] = None, r: Option[Node[A]] = None) extends Tree[A] {
    def left(v: A) = Node(value, newNode(v), r)

    def right(v: A) = Node(value, l, newNode(v))

    def leftRight(l: A, r: A): Node[A] = Node(value, newNode(l), newNode(r))

    private def newNode(v: A): Option[Node[A]] = if (v == -1) None else Some(Node(v))
  }

}