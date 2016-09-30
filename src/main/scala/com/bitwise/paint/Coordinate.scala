package com.bitwise

package object paint {
  type Coordinate = (Int,Int)
  type LeftTop = Coordinate
  type RightBottom = Coordinate
  type StartCoordinate = Coordinate
  type EndCoordinate = Coordinate
  type Colour = Char

  type PixelLine = List[Pixel]
  type PixelCanvas = List[PixelLine]
  type Width = Int
  type Height = Int

  val DefaultColour:Colour = 'x'
}