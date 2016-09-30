package com.bitwise.paint

import org.junit.{Test}
import org.scalatest.Matchers._

class CanvasTests {

  @Test
  def itShouldCreateADefaultCanvas(): Unit = {
    //given
    val canvas:Canvas = Canvas(20,10)
    //when

    //then
    canvas.isDefault() shouldBe true

  }

  @Test
  def itShouldCreateADefaultCanvasWithAllDefaultPixels(): Unit = {
    //given
    val canvas:Canvas = Canvas(5,5)
    //when

    //then
    AssertCanvas checkAllPixelsOf canvas
  }

}
