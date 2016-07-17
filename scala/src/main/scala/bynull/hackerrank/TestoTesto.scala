package bynull.hackerrank

import scala.collection.immutable.IndexedSeq

/**
  * Created by null on 7/17/16.
  */
object TestoTesto extends App {

  /*def f(num: Int, arr: List[Int]): List[Int] = {
    arr.flatMap { el =>
      Range.inclusive(1, num).flatMap(x => Seq(el))
    }
  }*/

  /*def f(delim: Int, arr: List[Int]): List[Int] = {
    arr.filter(el => el < delim)
  }*/

  /*def f(arr: List[Int]): List[Int] = {
    arr.zipWithIndex
      .filter(x => x._2 % 2 != 0)
      .map(x => x._1)
  }*/

  /*def f(num:Int) : List[Int] = {
    Range(0, num).toList
  }*/

  /*def f(arr: List[Int]): List[Int] = arr.reverse*/

  /*def f(arr: List[Int]): Int = {
    arr.filter(el => el % 2 != 0).sum
  }*/

  /*val res = f(List(2, 1, 2, 3, 4, 5))
  println(res)

  def f(arr: List[Int]): Int = {
    var cnt: Int = 0

    arr.foreach { el =>
      println(el)
      cnt += 1
      el
    }

    cnt
  }*/

  //def f(arr: List[Int]): List[Int] = arr.map(_.abs)

  def f(x: Float): Float = {
    val res = x match {
      case 0.0F =>
        1.0F
      case _ =>
        val result = Range(1, 10).map { idx =>
          math.pow(x, idx).toFloat / (1 until idx).product.toFloat
        }.sum

        BigDecimal(result).setScale(4, BigDecimal.RoundingMode.HALF_UP).toFloat
    }

    res
  }
}
