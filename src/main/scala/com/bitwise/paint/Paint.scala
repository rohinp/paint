package com.bitwise.paint

trait Paint {
  val canvas:Canvas
}

object Paint {
  def apply(c: Canvas,shape: Shape): Paint = new Paint {
    lazy val canvas:Canvas = Canvas(c,shape.allCoordinates,DefaultColour)
  }
}
