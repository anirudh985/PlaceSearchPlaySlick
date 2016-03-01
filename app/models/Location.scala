package models

import play.api.libs.json.Json

/**
  * Created by anirudh on 1/3/16.
  */
case class Location(intRowId: Int, locName: String, category: String,
                          rating: Double, latitude: Double, longitude: Double)

object Location{
  implicit val locationFormat = Json.format[Location]
}
