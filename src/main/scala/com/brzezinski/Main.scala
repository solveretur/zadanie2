package com.brzezinski

import com.brzezinski.zad1.Zad1._
import com.brzezinski.zad2.Zad2._

object Main {
  val validTestUrl = "https://finder.eocloud.eu/resto/api/collections/Sentinel1/search.json?maxRecords=10&q=winter+in+Warsaw&sortParam=startDate&sortOrder=descending&dataset=ESA-DATASET"
  val invalidTestUrl = "https://finder.eocloud.eu/resto/api/collections/Sentinel1/search.json?maxRecords=s10&q=winter+in+Warsaw&sortParam=startDate&sortOrder=descending&dataset=ESA-DATASET"
  val testList = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val emptyTestList = List()

  def main(args: Array[String]): Unit = {
    println("exists should return false when list is empty")
    println(exists[Int](emptyTestList, null))
    println("-------------------")
    println("exists should return false when none of list elements matches the predicate")
    println(exists[Int](testList, i => i > 10))
    println("-------------------")
    println("exists should return true when at at least one of list element matches the predicate")
    println(exists[Int](testList, i => i == 2))
    println("-------------------")
    println("listAllProducts should print exeption message when url is invalid")
    listAllProductsFromUrl(invalidTestUrl)
    println("-------------------")
    println("listAllProducts should list all products when url is valid")
    listAllProductsFromUrl(validTestUrl)
    println("-------------------")
  }

}
