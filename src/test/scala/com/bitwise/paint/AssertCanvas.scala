package com.bitwise.paint

import org.scalatest.Matchers._

object AssertCanvas {

  def checkAllPixelsOf(canvas: Canvas):Unit = {
    canvas.canvas.flatMap(pl => pl).exists(p => !p.isDefault()) shouldBe false
  }

  def checkIfShapeDrawnFor(canvas: Canvas, l:Shape):Unit = {
    canvas.canvas.flatMap(pl => pl).exists(p => if(l.allCoordinates.contains(p.cord))!p.isDefault()else p.isDefault()) shouldBe false
  }
}
