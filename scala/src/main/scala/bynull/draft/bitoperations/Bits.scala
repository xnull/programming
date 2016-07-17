package bynull.draft.bitoperations

/**
  * https://habrahabr.ru/post/187606/
  * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
  * Created by bynull on 12.04.16.
  */
object Bits extends App {

  signedLeftShift()


  def signedLeftShift() = {
    val bitMask = Integer.parseInt("1000", 2)
    println("Dec number: " + bitMask)
    println("Bin number: " + Integer.toBinaryString(bitMask))
    val shiftMask = Integer.parseInt("101", 2)
    //will be added number of zeros that is equal to decimal number of binary number. In our case 111 = 7. Seven zeros will be added to 1000
    val shift = Integer.toBinaryString(bitMask << shiftMask)
    println("left shift: " + shift)

    println((1 to shiftMask).fold(bitMask)((p, c) => p * 2) + " = " + (bitMask << shiftMask))
  }
}
