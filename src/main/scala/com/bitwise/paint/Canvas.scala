package com.bitwise.paint

trait Canvas {
  val w:Width
  val h:Height
  val x1y1:LeftTop = (0,0)
  val x2y2:RightBottom = (w,h)
  val canvas:PixelCanvas
  def isDefault(): Boolean
 // def isBorder():Boolean = ???
}

case class DefaultCanvas(w:Width, h:Height) extends Canvas {
  override val canvas: PixelCanvas = (0 to h).map(y => (0 to w).map(x => Pixel((x,y))).toList).toList
  override def isDefault(): Boolean = true
}


case class FillCanvas(oldCanvas: Canvas, co:List[Coordinate], pColour:Colour) extends Canvas {
  override val w: Width = oldCanvas.w
  override val h: Height = oldCanvas.h
  override def isDefault(): Boolean = false
  override val canvas: PixelCanvas =
    oldCanvas.canvas.map(l =>
      l.map(p => if(co.contains(p.cord)) Pixel(p.cord,pColour) else p))
}

object Canvas {
  def apply(w:Width,h:Height): Canvas = DefaultCanvas(w,h)
  def apply(oldCanvas: Canvas, co:List[Coordinate], pColour:Colour): Canvas = FillCanvas(oldCanvas,co,pColour)
}
