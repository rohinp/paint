package com.bitwise.paint

trait Pixel {
  val cord: Coordinate
  def isDefault():Boolean
  def colour(c: Colour):Pixel
}

case class DefaultPixel(cord: Coordinate) extends Pixel {
  override def isDefault(): Boolean = true
  override def colour(c: Colour): Pixel = Pixel(cord)
}

case class ColouredPixel(cord: Coordinate, c:Colour) extends Pixel {
  override def isDefault(): Boolean = false
  override def colour(c: Colour): Pixel = Pixel(cord,c)
}

object Pixel {
  def apply(cord: Coordinate): Pixel = DefaultPixel(cord)
  def apply(cord: Coordinate, c:Colour): Pixel = ColouredPixel(cord,c)
}


