package com.brzezinski.zad2

import play.api.libs.json.JsObject

object Zad2 {

  def listAllProductsFromUrl = getJsonFromUrl _ andThen getProductListStringFromJson andThen println

  def getProductListStringFromJson(jsonEither: Either[Exception, String]): String = {
    import play.api.libs.json.Json
    jsonEither match {
      case Right(rawJson) =>
        val json = Json.parse(rawJson)
        val features = (json \\ "features")
        var resultString = ""
        for (feature <- features) {
          resultString += feature.as[List[JsObject]].map(f => Json.prettyPrint(f)).mkString("\n")
        }
        resultString
      case Left(e) => e.getMessage
    }
  }

  def getJsonFromUrl(url: String): Either[Exception, String] = {
    import scala.io.Source._
    try {
      Right(fromURL(url).mkString)
    } catch {
      case e: Exception => Left(e)
    }
  }

}
