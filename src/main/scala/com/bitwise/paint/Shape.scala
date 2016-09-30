package com.bitwise.paint

trait Shape {
  val allCoordinates: List[Coordinate]
}

case class Line(x1y1:StartCoordinate,x2y2:EndCoordinate) extends Shape {

  override lazy val allCoordinates: List[Coordinate] = (x1y1,x2y2) match {
    case ((x1,y1),(x2,y2)) if y1 == y2 => (x1 to x2).map(x => (x, y1)).toList
    case ((x1,y1),(x2,y2)) if x1 == x2 => (y1 to y2).map(y => (x1, y)).toList
    case _ => throw InvalidCoordinates(this)
  }

  case class InvalidCoordinates(line: Line) extends RuntimeException

}

case class Rect(x1y1:LeftTop,x2y2:RightBottom) extends Shape {
  override lazy val allCoordinates: List[(Width, Width)] = {
    Line(x1y1,(x2y2._1 - x1y1._1, x1y1._2)).allCoordinates ++
      Line(x1y1,(x1y1._1,x2y2._2 -  x1y1._2)).allCoordinates ++
      Line((x2y2._1 - x1y1._1, x1y1._2),x2y2).allCoordinates ++
      Line((x1y1._1,x2y2._2 - x1y1._2),x2y2).allCoordinates
  }
}

object Shape {
  def line(x1y1:StartCoordinate,x2y2:EndCoordinate):Shape = Line(x1y1,x2y2)
  def rect(x1y1:StartCoordinate,x2y2:EndCoordinate):Shape = Rect(x1y1,x2y2)
}

