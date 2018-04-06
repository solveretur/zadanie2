package com.brzezinski.zad1

import scala.annotation.tailrec

object Zad1 {
  @tailrec
  def exists[T](list: List[T], predicate: T => Boolean): Boolean = {
    list match {
      case Nil => false
      case head :: tail =>
        if (predicate(head))
          return true
        exists(tail, predicate)
    }
  }
}
