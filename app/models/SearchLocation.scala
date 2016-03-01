package models

import play.api.libs.json.Json

/**
  * Created by anirudh on 1/3/16.
  */

case class SearchLocation(intRowId: Long, locName: String, category: String,
                          rating: Double, latitude: Double, longitude: Double)


object SearchLocation{
  implicit val searchLocationFormat = Json.format[SearchLocation]
}