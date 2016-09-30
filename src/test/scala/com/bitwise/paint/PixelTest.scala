package com.bitwise.paint

import org.junit.{Assert, Test}

class PixelTest {

  @Test
  def itShouldCreateDefaultPixel(): Unit ={
    //given
    val p:Pixel = Pixel((1,2))
    //when

    //then
    Assert.assertTrue(p.isDefault())
  }

  @Test
  def itShouldCreateColouredPixel(): Unit ={
    //given
    val p:Pixel = Pixel((1,2))
    //when
    val p1:Pixel = p.colour('c');
    //then
    Assert.assertFalse(p1.isDefault())
  }

}