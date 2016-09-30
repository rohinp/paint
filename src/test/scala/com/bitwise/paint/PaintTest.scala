package com.bitwise.paint

import org.junit.Test

class PaintTest {

  @Test
  def itShouldDrawShapeLineOnCanvas(): Unit ={
    //given
    val canvas1:Canvas = Canvas(20,4)
    val l:Shape = Shape.line((1,2),(6,2))

    //when
    val p:Paint = Paint(canvas1,l)

    //then
    AssertCanvas checkIfShapeDrawnFor (p.canvas ,l)
  }
}
