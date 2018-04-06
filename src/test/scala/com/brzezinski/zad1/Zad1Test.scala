package com.brzezinski.zad1

import com.brzezinski.zad1.Zad1._
import org.junit.Assert._
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

class Zad1Test extends AssertionsForJUnit {

  @Test def existsShouldReturnFalseWhenListIsEmpty(): Unit = {
    val testList = List()

    val result = exists[Int](testList, null)
    assertEquals(false, result)
  }

  @Test def existsShouldReturnTrueWhenAtLeastOneOfListElementMatchThePredicate(): Unit = {
    val testList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val result = exists[Int](testList, i => i == 2)
    assertEquals(true, result)
  }

  @Test def existsShouldReturnFalseWhenNoneOfListElementMatchThePredicate(): Unit = {
    val testList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val result = exists[Int](testList, i => i > 10)
    assertEquals(false, result)
  }

}
