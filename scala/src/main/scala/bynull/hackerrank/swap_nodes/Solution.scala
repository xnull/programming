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
    tree = funcFill(tree, readValues() /*v(2,3)*/)
    println(tree)

    def funcFill(parent: Node[Int], lr: (Int, Int)): Node[Int] = {
      lr match {
        case (l, r) if l == -1 && r == -1 =>
          parent
        case (l, r) if r == -1 =>
          println("Only left: " + l)
          val left = parent.left(l)
          funcFill(left, readValues())
        case (l, r) if l == -1 =>
          println("Only right: " + r)
          val right = parent.right(r)
          funcFill(right, readValues())
        case (l: Int, r: Int) => //s1
          println("Two nodes: " + l + ", " + r)
          val p = parent.leftRight(l, r)
          val leftSubtree = readValues() //v(4, -1)
        val rightSubtree = readValues() //v(5, -1)
          p.leftRightNode(p.l.map(ll => funcFill(ll, leftSubtree)), p.r.map(rr => funcFill(rr, rightSubtree)))
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

    def leftRightNode(lNode: Option[Node[A]], rNode: Option[Node[A]]): Node[A] = Node(value, lNode, rNode)

    private def newNode(v: A): Option[Node[A]] = if (v == -1) None else Some(Node(v))

    override def toString: String = {
      s"*\n${toStr(0)}"
    }

    private def toStr(offset: Int): String = {
      val offsetStr = if (offset == 0) "" else (1 to offset).map(x => " ").mkString

      val vStr = s"|$offsetStr${if (offset == 0) "" else "|"}-$value"
      val lStr = s"${l.map(n => n.toStr(offset + 2)).getOrElse("")}"
      val rStr = s"${r.map(n => n.toStr(offset + 2)).getOrElse("")}"

      s"$vStr\n$lStr\n$rStr"
    }
  }

}